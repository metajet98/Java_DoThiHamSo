package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.google.api.client.util.Key;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;


import com.jfoenix.controls.JFXListView;

import Model.ChatMessenge;
import Model.Topic;
import TienIch.TienIch;
import itemListView.ChatMessageListViewCell;
import itemListView.TopicListViewCell;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;


public class HoTroOnlineController implements Initializable  {
	
	@FXML
	private Button btnSendChat;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextArea txtChatInput;
	@FXML
	private JFXListView<ChatMessenge> listViewChat;
	@FXML
	private JFXListView<Topic> listViewTopic;
	
	ObservableList<ChatMessenge> listChat= FXCollections.observableArrayList();
	ObservableList<Topic> listTopic= FXCollections.observableArrayList();
	
	Firestore db;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	DateFormat dateFormatForCompare = new SimpleDateFormat("yyyyMMddHHmmss");
	Double openAppTime;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		//lay time bat dau app
		Date date = new Date();
		openAppTime= Double.parseDouble(dateFormatForCompare.format(date));
		
		try {
			initFirestore();
		} catch (IOException | ExecutionException|InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		//set cell con chatlistview
		listViewChat.setCellFactory(new Callback<ListView<ChatMessenge>, ListCell<ChatMessenge>>() {
		    @Override
		    public ListCell<ChatMessenge> call(ListView<ChatMessenge> chatListView) {
		        return new ChatMessageListViewCell();
		    }
		});
		listViewTopic.setCellFactory(new Callback<ListView<Topic>, ListCell<Topic>>() {

			@Override
			public ListCell<Topic> call(ListView<Topic> param) {
				return new TopicListViewCell();
			}
		});
		
		
		

	}
	
	
	
	public void initFirestore() throws IOException, InterruptedException, ExecutionException {
				
		FileInputStream serviceAccount =
				  new FileInputStream("firestore.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://kshshelponline.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);

		db = FirestoreClient.getFirestore();
		

		Query chatRef = db.collection("chats");
		chatRef.addSnapshotListener(new EventListener<QuerySnapshot>() {

			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				for (DocumentChange dc : value.getDocumentChanges()) {
			          switch (dc.getType()) {
			            case ADDED:
			            	
			            	listChat.add(new ChatMessenge(dc.getDocument().getData().get("userName").toString(), dc.getDocument().getData().get("time").toString(), dc.getDocument().getData().get("text").toString()));
			            	listViewChat.setItems(listChat);
			            	
			            	break;
					default:
						break;
	
						
			          }
			        }
				
			}
		});
		Query topicRef = db.collection("topics");
		topicRef.addSnapshotListener(new EventListener<QuerySnapshot>() {

			@Override
			public void onEvent(QuerySnapshot value, FirestoreException error) {
				for (DocumentChange dc : value.getDocumentChanges()) {
			          switch (dc.getType()) {
			            case ADDED:
			            	Map<String, Object> temp=dc.getDocument().getData();
			            	listTopic.add(new Topic(temp.get("noiDung").toString(), temp.get("askedName").toString(), temp.get("tag").toString(), temp.get("id").toString(), temp.get("time").toString(),Integer.parseInt(temp.get("luotXem").toString()) , Integer.parseInt(temp.get("luotCmt").toString()), temp.get("tieuDe").toString()));
			            	listViewTopic.setItems(listTopic);
			            	
			            	break;
					default:
						break;
	
						
			          }
			        }
				
			}
		});
		
		
		
		
	}
	private void sendMessenge() {
		if(txtChatInput.getText().isEmpty()||txtUserName.getText().isEmpty())
		{
			TienIch.ThongBao("Không được để trống trường!");
			return;
		}
		else 
		{
			try {
				//lay ngay thang tu he thong
				
				Date date = new Date();
				//lay username+text
				String userName= txtUserName.getText();
				String textChat= txtChatInput.getText();
				//gop lai trong hashmap
				Map<String, Object> docData = new HashMap<>();
				docData.put("text", textChat);
				docData.put("userName", userName);
				docData.put("time", dateFormat.format(date));
				docData.put("timeForCompare", Long.parseUnsignedLong(dateFormatForCompare.format(date)));
				//push len voi mot document() moi
				db.collection("chats").document().set(docData);
				
				txtChatInput.clear();
			
			} catch (Exception e) {
				TienIch.ThongBao("Lỗi không xác định!"+e.toString());
			}
		}
	}
	//ham event cua nut Gui
	public void handleButtonSendEvent(ActionEvent actionEvent) 
	{	
		sendMessenge();		
	}
	//Ham xu ly event khi nhap vao chat field, xu ly enter va shift enter
	public void handleEnterAutoSend(KeyEvent keyEvent) 
	{	
		if(!keyEvent.isShiftDown()&&keyEvent.getCode()==KeyCode.ENTER)
		{
			sendMessenge();
		}
		else 
		{
			if(keyEvent.isShiftDown()&&keyEvent.getCode()==KeyCode.ENTER)
			{
				txtChatInput.appendText("\n");
			}
		}
			
	}
	

}
