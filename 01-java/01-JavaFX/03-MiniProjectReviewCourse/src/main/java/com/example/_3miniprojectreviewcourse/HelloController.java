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
    private int count = 1;

    @FXML
    private void initialize() {
        Label label = new Label("Graph Area");
        myPane.getChildren().add(label);
        myPane.setOnMouseClicked(eventPane -> {
            double x = eventPane.getX();
            double y = eventPane.getY();
            Circle circle = new Circle(x, y, 15);
            System.out.println(count + " circle created!");
            count++;


            // Event mouse CLICKED
            circle.setOnMouseClicked(eventCircle -> {
                if (eventCircle.isStillSincePress()) {
                    System.out.println("Vertex clicked");
                    circle.setFill(Color.valueOf("red"));
                    checkVertex(circle);
                }
                eventCircle.consume(); // stop bubbling to pane
            });

            // Event mouse DRAGGED
            circle.setOnMouseDragged(eventCircle -> {
                double newX = eventCircle.getX();
                double newY = eventCircle.getY();
                circle.setCenterX(newX);
                circle.setCenterY(newY);
                eventCircle.consume(); // stop bubbling to pane
            });

            myPane.getChildren().add(circle);
        });
    }

    // if choosing a vertex, call this method to check if it's the second vertex -> make line
    private void checkVertex(Circle circle) {
        if (firstVertex != null) {
            makeLine(firstVertex, circle);
        } else {
            firstVertex = circle;
        }
    }

    private void makeLine(Circle circle1, Circle circle2) {
        Line line = new Line();
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());

        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());
        line.setStrokeWidth(2);
        line.setMouseTransparent(true); // Disable mouse for lines
        myPane.getChildren().add(line);
        firstVertex = null;
        circle1.setFill(Color.BLACK);
        circle2.setFill(Color.BLACK);
    }
}

