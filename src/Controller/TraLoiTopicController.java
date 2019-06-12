package Controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Transaction;

import Model.ChatMessenge;
import Model.Comment;
import Model.Topic;
import TienIch.TienIch;
import itemListView.ChatMessageListViewCell;
import itemListView.CommentListViewCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TraLoiTopicController implements Initializable {
	
	@FXML
	private Button btnGuiBinhLuan;
	@FXML
	private Label txtTieuDe;
	@FXML
	private TextArea txtNoiDung;
	@FXML
	private Label txtSoCmt;
	@FXML
	private Label txtSoLuotXem;
	@FXML
	private Label txtNguoiHoi;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextArea txtComment;
	@FXML
	private ListView<Comment> 	listViewCmt;
	
	private Stage thisStage;
	private Topic topic;
	
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	DateFormat dateFormatForCompare = new SimpleDateFormat("yyyyMMddHHmmss");
	ObservableList<Comment> listComment= FXCollections.observableArrayList();
	
	public TraLoiTopicController(Topic topic) {
		
		this.topic=topic;
		
		
		this.thisStage= new Stage();
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("TraLoiTopic.fxml"));

            // Set this class as the controller
            loader.setController(this);

            // Load the scene
            thisStage.setScene(new Scene(loader.load()));

            // Setup the window/stage
            thisStage.setTitle("Trả lời!");
            thisStage.setMinHeight(700);
            thisStage.setMinWidth(440);
            thisStage.setMaxWidth(440);
            thisStage.setMaxHeight(700);

        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	public void showStage() {
        thisStage.showAndWait();
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		txtTieuDe.setText(topic.getTieuDe());
		txtNoiDung.setText(topic.getNoiDung());
		txtSoCmt.setText("Trả lời: "+topic.getLuotCmt());
		txtSoLuotXem.setText("Lượt xem: "+topic.getLuotXem());
		txtNguoiHoi.setText(topic.getAskedName());
		
		ApiFuture<Void> transactionLuotXem =
			    topic.getDb().runTransaction(
			        new Transaction.Function<Void>() {
			          @Override
			          public Void updateCallback(Transaction transaction) throws Exception {
			            // retrieve document and increment population field
			            DocumentSnapshot snapshot = transaction.get(topic.getDb().collection("topics").document(topic.getId())).get();
			            long oldLuotXem = snapshot.getLong("luotXem");
			            transaction.update(topic.getDb().collection("topics").document(topic.getId()), "luotXem", oldLuotXem + 1);
			            return null;
			          }
			        });
		
		
		listViewCmt.setCellFactory(new Callback<ListView<Comment>, ListCell<Comment>>() {
		    @Override
		    public ListCell<Comment> call(ListView<Comment> commentListView) {
		        return new CommentListViewCell();
		    }
		});
		
		CollectionReference commentRef = topic.getDb().collection("topics").document(topic.getId()).collection("comments");
		if(commentRef!=null)
		{
			commentRef.addSnapshotListener(new EventListener<QuerySnapshot>() {

				@Override
				public void onEvent(QuerySnapshot value, FirestoreException error) {
					for (DocumentChange dc : value.getDocumentChanges()) {
				          switch (dc.getType()) {
				            case ADDED:
				            	Map<String, Object> temp= dc.getDocument().getData();
				            	listComment.add(new Comment(temp.get("noiDung").toString(), temp.get("time").toString(), temp.get("userName").toString()));
				            	listViewCmt.setItems(listComment);
				            	break;

						default:
							break;
		
							
				          }
				        }
					
				}
			});
			
		}
		
		
		btnGuiBinhLuan.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(txtUserName.getText().isEmpty()||txtComment.getText().isEmpty())
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
						String comment=txtComment.getText();
						//gop lai trong hashmap
						Map<String, Object> docData = new HashMap<>();
						docData.put("noiDung", comment);
						docData.put("userName", userName);
						docData.put("time", dateFormat.format(date));
						docData.put("timeForCompare", Long.parseUnsignedLong(dateFormatForCompare.format(date)));
						//push len voi mot document() moi
						topic.getDb().collection("topics").document(topic.getId()).collection("comments").document().set(docData);
						
						ApiFuture<Void> transactionLuotCmt =
							    topic.getDb().runTransaction(
							        new Transaction.Function<Void>() {
							          @Override
							          public Void updateCallback(Transaction transaction) throws Exception {
							            // retrieve document and increment population field
							            DocumentSnapshot snapshot = transaction.get(topic.getDb().collection("topics").document(topic.getId())).get();
							            long oldLuotCmt = snapshot.getLong("luotCmt");
							            transaction.update(topic.getDb().collection("topics").document(topic.getId()), "luotCmt", oldLuotCmt + 1);
							            return null;
							          }
							        });
						
						txtComment.clear();
					
					} catch (Exception e) {
						TienIch.ThongBao("Lỗi không xác định!"+e.toString());
					}
				}
				
			}
		});
		
	}

}
