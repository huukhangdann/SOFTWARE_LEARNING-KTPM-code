package com.example._3miniprojectreviewcourse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HelloController {
    @FXML
    private Pane myPane;

    @FXML
    private Label myLabel;
    private Circle firstVertex = null;
    @FXML
    private void initialize(){
        Label label = new Label("Graph Area");
        myPane.getChildren().add(label);
        myPane.setOnMouseClicked(eventPane -> {
            double x = eventPane.getX();
            double y = eventPane.getY();
            Circle circle = new Circle(x, y, 15);
            circle.setOnMouseClicked(eventCircle -> {
                System.out.println("Vertex clicked");
                circle.setFill(Color.valueOf("red"));
                checkVertex(circle);
                eventCircle.consume();
            });
            myPane.getChildren().add(circle);
        });
    }

    // if choosing a vertex, call this method to check if it's the second vertex -> make line
    private void checkVertex(Circle circle){
        if(firstVertex!=null){
            makeLine(firstVertex, circle);
        }
        else{
            firstVertex=circle;
        }
    }

    private void makeLine(Circle circle1, Circle circle2){
        double x1 = circle1.getCenterX();
        double x2 = circle2.getCenterX();
        double y1 = circle1.getCenterY();
        double y2 = circle2.getCenterY();
        Line line = new Line(x1, y1, x2, y2);
        line.setStrokeWidth(2);
        myPane.getChildren().add(line);
        firstVertex = null;
        circle1.setFill(Color.BLACK);
        circle2.setFill(Color.BLACK);
    }
}

