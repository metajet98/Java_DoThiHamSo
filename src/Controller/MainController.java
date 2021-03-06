package Controller;



import java.awt.TextArea;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;

import javax.security.auth.kerberos.KerberosTicket;

import com.google.cloud.firestore.v1beta1.FirestoreClient.ListCollectionIdsFixedSizeCollection;
import com.sun.glass.ui.Application;
import com.sun.glass.ui.Robot;

import CoreDraw.Axes;
import CoreDraw.Plot;
import KhaoSat.PTB2;
import KhaoSat.PTB3;
import KhaoSat.PTTrungPhuong;
import KhaoSat.PT_Hypebol;
import TienIch.TienIch;
import application.Main;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainController implements Initializable{
	
	Robot robot =Application.GetApplication().createRobot();
	final int DEFAULT_CHIA_AXES=1;
	final int DEFAULT_MAX_AXES=20;
	
	private float currentZoom=1;
	private float currentChiaAxes=1;
	private int currentAxesMax=10;
	private float inc=1;
	private int currentTab;
	
	

	@FXML
	private MenuItem aboutMenuItem;
	@FXML
	private MenuBar menuBar;
	@FXML
	private StackPane stackPane= new StackPane();
	@FXML
	private TextField txtField;

	@FXML 
	private Button btnNhapLai;
	@FXML 
	private Button btnKhaoSat;
	@FXML
	private Button btnZoomIn;
	@FXML
	private Button btnZoomOut;
	@FXML
	private TabPane tabPane;
	@FXML
	private TextField tf_a2;
	@FXML
	private TextField tf_b2;
	@FXML
	private TextField tf_c2;
	@FXML
	private TextField tf_a3;
	@FXML
	private TextField tf_b3;
	@FXML
	private TextField tf_c3;
	@FXML
	private TextField tf_d3;
	@FXML
	private TextField tf_a4;
	@FXML
	private TextField tf_b4;
	@FXML
	private TextField tf_c4;
	@FXML
	private TextField tf_a1;
	@FXML
	private TextField tf_b1;
	@FXML
	private TextField tf_min;
	@FXML
	private TextField tf_max;
	@FXML
	private TextField tf_c1;
	@FXML
	private TextField tf_d1;
	@FXML
	private TextField tf_custom;

	
	@FXML
	private Group group;
	@FXML
	private ComboBox<String> cbxChoose;
	private String[] str = {"sin(x)","cos(x)","tan(x)","cot(x)","log(x)","log2(x)","log10(x)"};
	
	@FXML
	private ScrollPane scrollPane;
	
	@FXML
	private MenuItem exitMenu;
	@FXML
	private javafx.scene.control.TextArea ta_KSHS;
	
	String backgroundColor="-fx-background-color: rgb(255,255,255);";
	Axes axes;
	Plot plot,plot1,plot2;
	int min,max;
	
	ArrayList<String> _listFunc = new ArrayList<String>();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
        
        scrollPane.setPannable(true);
        scrollPane.setContent(stackPane);
        
        tf_min.setText(String.valueOf((int)(-DEFAULT_MAX_AXES/currentZoom)));
		tf_max.setText(String.valueOf((int)(DEFAULT_MAX_AXES/currentZoom)));

        min = (int)(-DEFAULT_MAX_AXES/currentZoom);
        max = (int)(DEFAULT_MAX_AXES/currentZoom);
        
        cbxChoose.getItems().addAll(str);
        stackPane.setOnScroll(event->HandleOnScroll(event));
        
       
	}
	private void HandleOnScroll(ScrollEvent event)
	{	
		double mainX=Main.getRootStage().getX();
		double mainY=Main.getRootStage().getY();
		int x = robot.getMouseX(); 
		int y = robot.getMouseY();
		
		double positionX=(x-mainX-363);
		double positionY=(y-mainY-58);
		
		double width=stackPane.getWidth();
		double height=stackPane.getHeight();
		
		double tileX=positionX/width+0.2;
		double tileY=positionY/height+0.2;
		

		
		System.out.println("x: "+tileX+ " y: "+tileY);
		
		int currentTabScroll= tabPane.getSelectionModel().getSelectedIndex();
		 
		double deltaY=event.getDeltaY();
		System.out.println("Scroll: "+deltaY);
		if(deltaY>0)
		{
			switch (currentTabScroll) {
			case 0:
				KhaoSatBacHai(1.1);
				break;
			case 1:
				KhaoSatBacBa(1.1);
				break;
			case 2:
				KhaoSatBacBon(1.1);
				break;
			case 3:
				KhaoSatBacNhat(1.1);
				break;
			case 4:
				
				KhaoSatTuyChon(1.1);
				break;

			default:
				break;
			}
		}
		else {
			switch (currentTabScroll) {
			case 0:
				KhaoSatBacHai(0.8);
				break;
			case 1:
				KhaoSatBacBa(0.8);
				break;
			case 2:
				KhaoSatBacBon(0.8);
				break;
			case 3:
				KhaoSatBacNhat(0.8);
				tf_custom.clear();
				break;
			case 4:
				KhaoSatTuyChon(0.8);
				break;

			default:
				break;
			}
		}
		Platform.runLater(new Runnable() {
		    @Override
		    public void run() {
		    	scrollPane.setVvalue(tileY);
				scrollPane.setHvalue(tileX);
		    }
		});
		

	}
	public void Close()
	{
		exitMenu.setOnAction(e->{
        	Platform.runLater(new Runnable() {				
				@Override
				public void run() {
					Platform.exit();			
				}
			});
        });
	}
	public void Draw(double zoom, double a, double b, double c, double d, double e)// vẽ dạng thường
	{	
		currentZoom=(float) (currentZoom*zoom);
		currentAxesMax=(int) (DEFAULT_MAX_AXES/currentZoom);
		max = Integer.parseInt(tf_max.getText());
		min = Integer.parseInt(tf_min.getText());
		currentChiaAxes=(float) (DEFAULT_CHIA_AXES/currentZoom);
		
		
		double w=0;
		if(currentZoom<1)
		{
			w=scrollPane.getWidth();
		}
		else 
		{
			w=scrollPane.getWidth()*currentZoom;
		}

//		axes = new Axes(
//				w, w,
//                -currentAxesMax, currentAxesMax,currentChiaAxes,
//                -currentAxesMax, currentAxesMax,currentChiaAxes
//        );
		axes = new Axes(
				w, w,
                min, max,currentChiaAxes,
                -currentAxesMax, currentAxesMax,currentChiaAxes
        );

        plot = new Plot(
                x -> ((a*x*x*x*x+b*x*x*x+c*x*x+d*x+e)),
                min, max, 0.05,
                w,w,
                axes
        );
        
        
        
        stackPane.getChildren().clear();
        stackPane.getChildren().add(plot);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle(backgroundColor);
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
        
	}
	public void Draw(double zoom, double a, double b, double c, double d)// vẽ đồ thị theo dạng phân số
	{	
		currentZoom=(float) (currentZoom*zoom);
		currentAxesMax=(int) (DEFAULT_MAX_AXES/currentZoom);
		max = Integer.parseInt(tf_max.getText());
		min = Integer.parseInt(tf_min.getText());
		currentChiaAxes=(float) (DEFAULT_CHIA_AXES/currentZoom);
		
		
		double w=0;
		if(currentZoom<1)
		{
			w=scrollPane.getWidth();
		}
		else 
		{
			w=scrollPane.getWidth()*currentZoom;
		}

//		axes = new Axes(
//				w, w,
//                -currentAxesMax, currentAxesMax,currentChiaAxes,
//                -currentAxesMax, currentAxesMax,currentChiaAxes
//        );
		axes = new Axes(
				w, w,
                min, max,currentChiaAxes,
                -currentAxesMax, currentAxesMax,currentChiaAxes
        );
		 
        plot = new Plot(
                x -> (a*x+b) / (c*x + d),
                min, max, 0.05,
                w,w,
                axes
        );
//        plot1 = new Plot(
//                y -> a/c,
//                min, max, 0.05,
//                w,w,
//                axes
//        );
//        plot2 = new Plot(
//                x -> (-d/c),
//                min, max, 0.05,
//                w,w,
//                axes
//        );
        
        stackPane.getChildren().clear();
        stackPane.getChildren().addAll(plot);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle(backgroundColor);
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
        
	}
	public void Draw(float _currentZoom,int _currentAxesMax,float _currentChiaAxes, String str) // vẽ dạng đặc biệt
	{
		
		
		double w=0;
		if(_currentZoom<1)
		{
			
			w=scrollPane.getWidth();
		}
		else 
		{
			w=scrollPane.getWidth()*_currentZoom;
		}
		axes = new Axes(
				w, w,
                min, max,_currentChiaAxes,
                min, max,_currentChiaAxes
        );
		
		if(str!="") {
			plot = new Plot(
	                str,
	                min, max, 0.05,
	                w,w,
	                axes
	        );
		}
        
        stackPane.getChildren().addAll(plot);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle(backgroundColor);
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        
	}
	public void Draw(Double zoom) // vẽ truc toa do
	{
		currentZoom=(float) (currentZoom*zoom);
		currentAxesMax=(int) (DEFAULT_MAX_AXES/currentZoom);
		max = Integer.parseInt(tf_max.getText());
		min = Integer.parseInt(tf_min.getText());
		currentChiaAxes=(float) (DEFAULT_CHIA_AXES/currentZoom);
		
		
		double w=0;
		if(currentZoom<1)
		{
			w=scrollPane.getWidth();
		}
		else 
		{
			w=scrollPane.getWidth()*currentZoom;
		}
		axes = new Axes(
				w, w,
                min, max,currentChiaAxes,
                min, max,currentChiaAxes
        );
		
        
        stackPane.getChildren().clear();
        stackPane.getChildren().addAll(axes);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle(backgroundColor);
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255), CornerRadii.EMPTY, Insets.EMPTY)));
        
	}
	public void KhaoSatBacHai(double zoom)
	{
		double a=0,b=0,c=0;
		try {
			a=Double.parseDouble(tf_a2.getText().toString());
			b=Double.parseDouble(tf_b2.getText().toString());
			c=Double.parseDouble(tf_c2.getText().toString());
			Draw(zoom, 0, 0, a, b, c);
			
			PTB2 ptb2 = new PTB2();
			ptb2.NhapPTT2(a, b, c, min, max);
			ptb2.KhaoSatPTB2();
			ta_KSHS.setText(ptb2.khaosat);
			
			ptb2.VeBangBienThien(group);
			
		} catch (Exception e) {
			TienIch.ThongBao("Lỗi nhập thông tin!");
		}
		
		
	}
	public void KhaoSatBacBa(double zoom)
	{
		double a=0,b=0,c=0,d=0;
		try {
			a=Double.parseDouble(tf_a3.getText().toString());
			b=Double.parseDouble(tf_b3.getText().toString());
			c=Double.parseDouble(tf_c3.getText().toString());
			d=Double.parseDouble(tf_d3.getText().toString());
			Draw(zoom, 0, a, b, c, d);
			PTB3 ptb3 = new PTB3();
			ptb3.NhapPT3(a, b, c, d,min,max);
			ptb3.KhaoSatPTB3();
			ta_KSHS.setText(ptb3.khaosat);
						
			ptb3.VeBangBienThien(group);
			
		} catch (Exception e) {
			TienIch.ThongBao("Lỗi nhập thông tin!");
		}
	}
	public void KhaoSatBacBon(double zoom)
	{
		double a=0,b=0,c=0;
		try {
			a=Double.parseDouble(tf_a4.getText().toString());
			b=Double.parseDouble(tf_b4.getText().toString());
			c=Double.parseDouble(tf_c4.getText().toString());
			
			Draw(zoom, a, 0, b, 0, c);
			PTTrungPhuong trungPhuong = new PTTrungPhuong();
			trungPhuong.NhapPT4(a, b, c, min, max);
			trungPhuong.KhaoSatPTTrungPhuong();
			ta_KSHS.setText(trungPhuong.khaosat);
			
			trungPhuong.VeBangBienThien(group);
		} catch (Exception e) {
			TienIch.ThongBao("Lỗi nhập thông tin!");
		}
	}
	public void KhaoSatBacNhat(double zoom)
	{
		double a=0,b=0,c=0,d=0;
		try {
			a = Double.parseDouble(tf_a1.getText().toString());
			b = Double.parseDouble(tf_b1.getText().toString());
			c = Double.parseDouble(tf_c1.getText().toString());
			d = Double.parseDouble(tf_d1.getText().toString());
			Draw(zoom,a, b,c,d);
			
			PT_Hypebol hypebol = new PT_Hypebol();
			hypebol.NhapPT_Hypebol(a, b, c, d,min,max);
			hypebol.KhaoSatPT_Hypebol();
			ta_KSHS.setText(hypebol.khaosat);
			
			hypebol.VeBangBienThien(group);
		} catch (Exception e) {
			TienIch.ThongBao("Lỗi nhập thông tin!");
		}
		
		
		PT_Hypebol hypebol = new PT_Hypebol();
		hypebol.NhapPT_Hypebol(a, b, c, d,min,max);
		hypebol.KhaoSatPT_Hypebol();
		ta_KSHS.setText(hypebol.khaosat);
		
		hypebol.VeBangBienThien(group);
	}
	public void KhaoSatTuyChon(double zoom)
	{	
		currentZoom=(float) (currentZoom*zoom);
		max = Integer.parseInt(tf_max.getText());
		min = Integer.parseInt(tf_min.getText());
		currentChiaAxes= (float) (currentChiaAxes/zoom);
		
		if(zoom==1)
		{
			stackPane.getChildren().clear();
			String pt = tf_custom.getText().toLowerCase().trim();
			_listFunc.add(pt);
			String textFunc="";
			for(String item : _listFunc) {
				Draw(currentZoom, currentAxesMax, currentChiaAxes, item);
				textFunc+="y = "+item+'\n';
			}
			ta_KSHS.setText(textFunc);
		}
		else 
		{
			stackPane.getChildren().clear();
			for(String item : _listFunc) {
				Draw(currentZoom, currentAxesMax, currentChiaAxes, item);
			}
		}
		
		
		
		
	}
	
	public void KhaoSat(ActionEvent actionEvent)
	{	
		
		int currentTab= tabPane.getSelectionModel().getSelectedIndex();
		System.out.println(currentTab);
		
		
	    switch (currentTab) {
		case 0:
			KhaoSatBacHai(1);
			break;
		case 1:
			KhaoSatBacBa(1);
			break;
		case 2:
			KhaoSatBacBon(1);
			break;
		case 3:
			KhaoSatBacNhat(1);
			break;
		case 4:
			
			KhaoSatTuyChon(1);
			break;
		default:
			break;
		}

	}
	public void ZoomIn(ActionEvent actionEvent)
	{	
		int currentTab= tabPane.getSelectionModel().getSelectedIndex();
		System.out.println(currentTab);
		
		
	    switch (currentTab) {
		case 0:
			KhaoSatBacHai(2);
			break;
		case 1:
			KhaoSatBacBa(2);
			break;
		case 2:
			KhaoSatBacBon(2);
			break;
		case 3:
			KhaoSatBacNhat(2);
			break;
		case 4:
			
			KhaoSatTuyChon(2);
			break;

		default:
			break;
		}
	    

	    

		
	}
	public void ZoomOut(ActionEvent actionEvent)
	{
		int currentTab= tabPane.getSelectionModel().getSelectedIndex();
		System.out.println(currentTab);
		
		
	    switch (currentTab) {
		case 0:
			KhaoSatBacHai(0.5);
			break;
		case 1:
			KhaoSatBacBa(0.5);
			break;
		case 2:
			KhaoSatBacBon(0.5);
			break;
		case 3:
			KhaoSatBacNhat(0.5);
			tf_custom.clear();
			break;
		case 4:
			KhaoSatTuyChon(0.5);
			break;

		default:
			break;
		}
	    

	}
	public void NhapLai(ActionEvent actionEvent)
	{	
		currentZoom=1;
		currentChiaAxes=1;
		currentAxesMax=20;
		
		for (Tab tab : tabPane.getTabs()) {
			
			System.out.println(tab.toString());
			
			Node node= tab.getContent();
			
			if(node instanceof AnchorPane)
			{	
				System.out.println(node.toString());
				for (Node node_inside : ((AnchorPane) node).getChildren()) {
					if(node_inside instanceof TextField)
						((TextField) node_inside).clear();
				}
			}
		}
		ta_KSHS.clear();
		group.getChildren().clear();
		stackPane.getChildren().clear();
		Draw(1.0);
		_listFunc.clear();
	}
	
	
	
	
	
	
	
	
	public void openAboutUsForm(ActionEvent event)
	{
		System.out.println("About Us clicked!");
		Parent root;
        try {
        	root= FXMLLoader.load(getClass().getClassLoader().getResource("AboutUs.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Về chúng tôi");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            //Main.getRootStage().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void openOnlineHelpForm(ActionEvent event)
	{
		System.out.println("Online Help clicked!");
		Parent root;
        try {
        	root= FXMLLoader.load(getClass().getClassLoader().getResource("HoTroOnline.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Cộng đồng Hỗ trợ Online");
            stage.setScene(new Scene(root));
			stage.setMinHeight(670);
			stage.setMinWidth(890);
			stage.setMaxHeight(670);
			stage.setMaxWidth(890);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}


	public void Choose(ActionEvent e) {
		tf_custom.setText(tf_custom.getText()+cbxChoose.getValue());
	}
}
