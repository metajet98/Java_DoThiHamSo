package itemListView;

import java.io.IOException;

import Controller.TraLoiTopicController;
import Model.Comment;
import Model.Topic;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CommentListViewCell extends ListCell<Comment>{
	
	@FXML
	private Label txtTacGia;
	@FXML
	private Label txtTime;
	@FXML
	private TextArea txtComment;
	@FXML
	private AnchorPane anchorPane;
	
	
FXMLLoader mLoader;
	

	@Override
	protected void updateItem(Comment item, boolean empty) {
		
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
                mLoader = new FXMLLoader(getClass().getClassLoader().getResource("CommentItem.fxml"));
                mLoader.setController(this);

                try {
                    mLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

			}
			
			txtTacGia.setText(item.getCmtUserName());
			txtComment.setText(item.getComment());
			txtTime.setText(item.getTime());
			
			
			setText(null);
            setGraphic(anchorPane);
			
		}
	
	}
}
