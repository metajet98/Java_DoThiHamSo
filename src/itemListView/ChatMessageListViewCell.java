package itemListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

import Model.ChatMessenge;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
	


public class ChatMessageListViewCell extends ListCell<ChatMessenge>  {
	

	@FXML
	private Label lbUserName;
	@FXML
	private Label lbTime;
	@FXML
	private JFXTextArea txtText;
	@FXML  
	private AnchorPane anchorPane;
	FXMLLoader mLoader;
	
	@Override
	protected void updateItem(ChatMessenge item, boolean empty) {

		super.updateItem(item, empty);
		
		if(empty || item == null) 
		{
            setText(null);
            setGraphic(null);
		}
		else 
		{
			if (mLoader == null) 
			{
                mLoader = new FXMLLoader(getClass().getClassLoader().getResource("ChatItem.fxml"));
                mLoader.setController(this);

                try {
                    mLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

			}
			lbUserName.setText(item.getUserName());
			lbTime.setText(item.getTime());
			txtText.setText(item.getText());
			setText(null);
            setGraphic(anchorPane);
			
		}
	
	}
	
	
}
