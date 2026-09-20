package com.example._3miniprojectreviewcourse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Pane myPane;

    @FXML
    private Label myLabel;

    @FXML
    private void initialize(){
        Label label = new Label("Graph Area");
        myPane.getChildren().add(label);
        myPane.setOnMouseClicked(eventPane -> {
            double x = eventPane.getX();
            double y = eventPane.getY();
            Circle circle = new Circle(x, y, 5);
            circle.setOnMouseClicked(eventCircle -> {
                System.out.println("Vertex clicked");
                circle.setFill(Color.valueOf("red"));
                eventCircle.consume();
            });
            myPane.getChildren().add(circle);
        });
    }
}

