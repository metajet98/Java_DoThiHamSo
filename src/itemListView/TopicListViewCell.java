package itemListView;

import java.io.IOException;

import com.jfoenix.controls.JFXTextArea;

import Controller.TraLoiTopicController;
import Model.ChatMessenge;
import Model.Topic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class TopicListViewCell extends ListCell<Topic>{
	@FXML
	private Label txtTieuDe;
	@FXML
	private Text txtUserName;
	@FXML
	private Text txtTag;
	@FXML
	private Button btnXem;
	@FXML
	private Label lbLuotXem;
	@FXML
	private Label lbLuotCmt;
	@FXML
	private AnchorPane anchorPane;
	

	FXMLLoader mLoader;
	

	@Override
	protected void updateItem(Topic item, boolean empty) {
		
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
                mLoader = new FXMLLoader(getClass().getResource("/itemListView/HoiDapItem.fxml"));
                mLoader.setController(this);

                try {
                    mLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

			}
			
			txtTieuDe.setText(item.getTieuDe());
			txtUserName.setText(item.getAskedName());
			txtTag.setText(item.getTag());
			
			lbLuotCmt.setText("Trả lời: "+item.getLuotCmt());
			lbLuotXem.setText("Lượt xem: "+item.getLuotXem());
			
			btnXem.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					TraLoiTopicController traLoiTopicController= new TraLoiTopicController(item);
					traLoiTopicController.showStage();
					
				}
			});
			
			setText(null);
            setGraphic(anchorPane);
			
		}
	
	}
	
}
