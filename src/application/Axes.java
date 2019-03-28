package application;

import javafx.beans.binding.Bindings;
import javafx.geometry.Side;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;

public class Axes extends Pane {
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