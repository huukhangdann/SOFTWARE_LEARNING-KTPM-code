package com.example._3miniprojectreviewcourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/hello-view.fxml"));
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Graph Editor");
        stage.setScene(scene);
        stage.show();
    }
}
