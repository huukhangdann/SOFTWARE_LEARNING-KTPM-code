package com.example._3miniprojectreviewcourse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML
    private Pane myPane;

    @FXML
    private Label myLabel;

    @FXML
    private void initialize(){
        Label label = new Label("Graph Area");
        myPane.getChildren().add(label);
    }

}
