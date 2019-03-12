package application;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javax.security.auth.kerberos.KerberosTicket;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainController implements Initializable{
	
	

	private float k=1;
	private float inc=1;
	
	@FXML
	private MenuItem aboutMenuItem;
	@FXML
	private MenuBar menuBar;
	@FXML
	private StackPane stackPane= new StackPane();
	@FXML 
	private Button testBtn;
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
	private ScrollPane scrollPane;
	
	
	Axes axes;
	Plot plot;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
        
        scrollPane.setPannable(true);
        scrollPane.setContent(stackPane);
       
	}
	public void Draw(double zoom)
	{	
		k=(float) (k/zoom);
		double w=stackPane.getWidth();
		double h=stackPane.getHeight();
		
		w=w*zoom;
		h=h*zoom;
		axes = new Axes(
				w, h,
                -8, 8, k,
                -8, 8, k
        );

        plot = new Plot(
                x -> .25 * (x + 4) * (x + 1) * (x - 2),
                -8, 8, 0.1,
                w,h,
                axes
        );
        
        
        
        stackPane.getChildren().clear();
        stackPane.getChildren().add(plot);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle("-fx-background-color: rgb(35, 39, 50);");
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
	}
	public void TestButtonClicked(ActionEvent event)
	{	
		System.out.println("Button Test Clicked!");
		axes = new Axes(
				scrollPane.getWidth(), scrollPane.getHeight(),
                -8, 8, 1,
                -8, 8, 1
        );

        plot = new Plot(
                x -> .25 * (x + 4) * (x + 1) * (x - 2),
                -8, 8, 0.1,
                scrollPane.getWidth(),scrollPane.getHeight(),
                axes
        );
        
        
        
        stackPane.getChildren().clear();
        stackPane.getChildren().add(plot);
        stackPane.setPadding(new Insets(20));
        stackPane.setStyle("-fx-background-color: rgb(35, 39, 50);");
        stackPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));
        
        scrollPane.setStyle("-fx-background-color: rgb(35, 39, 50);");
        scrollPane.setBackground(new Background(new BackgroundFill(Color.rgb(10, 10, 20), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
	}
	public void KhaoSat(ActionEvent actionEvent)
	{
		
	}
	public void ZoomIn(ActionEvent actionEvent)
	{
		Draw(2);

		
	}
	public void ZoomOut(ActionEvent actionEvent)
	{
		Draw(0.5);
	}
	public void openAboutUsForm(ActionEvent event)
	{
		System.out.println("About Us clicked!");
		Parent root;
        try {
        	root= FXMLLoader.load(getClass().getResource("/application/AboutUs.fxml"));
            Stage stage = new Stage();
            stage.setTitle("About Us");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            //Main.getRootStage().hide();
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	class Axes extends Pane {
        private NumberAxis xAxis;
        private NumberAxis yAxis;

        public Axes(
                double d, double e,
                double xLow, double xHi, double xTickUnit,
                double yLow, double yHi, double yTickUnit
        ) {
            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(d, e);
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

            xAxis = new NumberAxis(xLow, xHi, xTickUnit);
            xAxis.setSide(Side.BOTTOM);
            xAxis.setMinorTickVisible(false);
            xAxis.setPrefWidth(d);
            xAxis.setLayoutY(e / 2);

            yAxis = new NumberAxis(yLow, yHi, yTickUnit);
            yAxis.setSide(Side.LEFT);
            yAxis.setMinorTickVisible(false);
            yAxis.setPrefHeight(e);
            yAxis.layoutXProperty().bind(
                Bindings.subtract(
                    (d / 2) + 1,
                    yAxis.widthProperty()
                )
            );

            getChildren().setAll(xAxis, yAxis);
        }

        public NumberAxis getXAxis() {
            return xAxis;
        }

        public NumberAxis getYAxis() {
            return yAxis;
        }
    }

    class Plot extends Pane {
        public Plot(
                Function<Double, Double> f,
                double xMin, double xMax, double xInc,
                double wMax, double hMax,
                Axes axes
        ) {
            Path path = new Path();
            path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
            path.setStrokeWidth(2);

            path.setClip(
                    new Rectangle(
                            0, 0, 
                            axes.getPrefWidth(), 
                            axes.getPrefHeight()
                    )
            );

            double x = xMin;
            double y = f.apply(x);

            path.getElements().add(
                    new MoveTo(
                            mapX(x, axes), mapY(y, axes)
                    )
            );

            x += xInc;
            while (x < xMax) {
                y = f.apply(x);

                path.getElements().add(
                        new LineTo(
                                mapX(x, axes), mapY(y, axes)
                        )
                );

                x += xInc;
            }

            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
            setMaxSize(wMax, hMax);

            getChildren().setAll(axes, path);
        }

        private double mapX(double x, Axes axes) {
            double tx = axes.getPrefWidth() / 2;
            double sx = axes.getPrefWidth() / 
               (axes.getXAxis().getUpperBound() - 
                axes.getXAxis().getLowerBound());

            return x * sx + tx;
        }

        private double mapY(double y, Axes axes) {
            double ty = axes.getPrefHeight() / 2;
            double sy = axes.getPrefHeight() / 
                (axes.getYAxis().getUpperBound() - 
                 axes.getYAxis().getLowerBound());

            return -y * sy + ty;
        }
    }
	
}
