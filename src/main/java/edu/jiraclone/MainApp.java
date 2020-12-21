package edu.jiraclone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("/singIn.fxml"));
       stage.setTitle("JiraClone by ChurKIT");
       stage.setScene(new Scene(root, 800, 400));
       stage.show();
    }
}