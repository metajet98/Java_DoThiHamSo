package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	static Stage rootStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			System.out.println("Load Main fxml file");
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("MainWindow.fxml"));
			
			System.out.println("Load Main fxml file succeed!");
			
			primaryStage.setTitle("Phần mềm hỗ trợ giải bài tập khảo sát hàm số");
			primaryStage.setScene(new Scene(root));
			primaryStage.setMinHeight(720);
			primaryStage.setMinWidth(1280);

			primaryStage.show();
			rootStage=primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static Stage getRootStage()
	{
		return rootStage;
	}
}
