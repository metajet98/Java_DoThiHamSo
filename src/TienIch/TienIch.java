package TienIch;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class TienIch {
	public static void ThongBao(String _msg)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thông báo");
		alert.setHeaderText("Thông báo!");
		alert.setContentText(_msg);
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Confirmed Alert!");
		    }
		});
	}
}
