package com.example._3miniprojectreviewcourse;

import com.example._3miniprojectreviewcourse.model.Edge;
import com.example._3miniprojectreviewcourse.model.Graph;
import com.example._3miniprojectreviewcourse.model.Vertex;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloController {
    @FXML
    private Pane myPane;

    @FXML
    private Label myLabel;
    private Vertex firstVertex = null;
    private int id = 1;
    Graph graph;
    Map<Vertex, Circle> vertexCircleMapping = new HashMap<>();

    @FXML
    private void initialize() {
        // adding label to the pane
        Label label = new Label("Graph Area");
        myPane.getChildren().add(label);

        // Init a graph
        graph = new Graph();

        // Pane's clicked event handler
        myPane.setOnMouseClicked(eventPane -> {
            double x = eventPane.getX();
            double y = eventPane.getY();

            // Add Vertex to the graph
            Vertex vertex = new Vertex(id, x, y);
            graph.addVertex(vertex);

            // Create Circle to the pane
            Circle circle = new Circle(x, y, 10);
            System.out.println((id++) + " circle created!");
            myPane.getChildren().add(circle);
            circle.setUserData(vertex); // connect the circle to the vertex
            vertexCircleMapping.put(vertex, circle); // connect the vertex to the circle

            // Event mouse CLICKED
            circle.setOnMouseClicked(eventCircle -> {
                if (eventCircle.isStillSincePress()) {
                    System.out.println("Vertex clicked");
                    circle.setFill(Color.valueOf("red"));
                    checkVertex(((Vertex)circle.getUserData()));
                }
                eventCircle.consume(); // stop bubbling to pane
            });

            // Event mouse DRAGGED
            circle.setOnMouseDragged(eventCircle -> {
                double newX = eventCircle.getX();
                double newY = eventCircle.getY();
                circle.setCenterX(newX);
                circle.setCenterY(newY);
                updateVertex(((Vertex)circle.getUserData()),newX, newY);
                eventCircle.consume(); // stop bubbling to pane
            });
        });
    }

    private void updateVertex(Vertex vertex, double x, double y) {
        vertex.setX(x);
        vertex.setY(y);
    }

    // if choosing a vertex, call this method to check if it's the second vertex -> make line
    private void checkVertex(Vertex vertex) {
        if (firstVertex != null) {
            makeLine(firstVertex, vertex);
        } else {
            firstVertex = vertex;
        }
    }

    private void makeLine(Vertex vertex1, Vertex vertex2) {
        Circle circle1 = vertexCircleMapping.get(vertex1);
        Circle circle2 = vertexCircleMapping.get(vertex2);
        // add edge to the graph
        Edge edge = new Edge(((Vertex) circle1.getUserData()), ((Vertex) circle2.getUserData()), 0);
        graph.addEdge(edge);

        // make line and binding it to the vertex
        Line line = new Line();
        line.setUserData(edge);
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());

        // add weight for the edge
        TextField textField = new TextField();
        double midx = (circle1.getCenterX() + circle2.getCenterX()) / 2;
        double midy = (circle1.getCenterY() + circle2.getCenterY()) / 2;
        textField.setLayoutX(midx);
        textField.setLayoutY(midy);
        textField.setMinWidth(3);
        textField.setOnAction(event -> {
            String value = textField.getText();
            int weight = Integer.parseInt(value);
            ((Edge)line.getUserData()).setWeight(weight); //Update the real weight of the edge
           // System.out.println(weight);
            Text weightText = new Text(value);
            weightText.setFill(Color.WHITE);
            weightText.setId("WeightText");
            weightText.setMouseTransparent(true);
            weightText.layoutXProperty().bind(Bindings.divide(Bindings.add(circle1.centerXProperty(), circle2.centerXProperty()), 2));
            weightText.layoutYProperty().bind(Bindings.divide(Bindings.add(circle1.centerYProperty(), circle2.centerYProperty()), 1.85));
            myPane.getChildren().remove(textField);
            myPane.getChildren().add(weightText);
        });

        line.setStrokeWidth(2);
        line.setMouseTransparent(true); // Disable mouse for lines
        myPane.getChildren().add(line);
        myPane.getChildren().add(textField);
        firstVertex = null;
        circle1.setFill(Color.BLACK);
        circle2.setFill(Color.BLACK);
    }

}

