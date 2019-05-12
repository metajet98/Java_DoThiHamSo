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
			
			Parent root=FXMLLoader.load(getClass().getClassLoader().getResource("HoTroOnline.fxml"));
			
			System.out.println("Load Main fxml file succeed!");
			
			primaryStage.setTitle("Cộng đồng Hỗ trợ Online");
			primaryStage.setScene(new Scene(root));
			primaryStage.setMinHeight(600);
			primaryStage.setMinWidth(800);

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
