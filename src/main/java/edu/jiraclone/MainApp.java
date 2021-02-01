package edu.jiraclone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        readJsons();
        launch(args);
        writeJsons();
    }

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("/singIn.fxml"));
       stage.setTitle("JiraClone by ChurKIT");
       stage.setScene(new Scene(root, 800, 400));
       stage.show();
    }

    public static void readJsons(){
        RepositoryUsers.getInstance().readFromJson();
        RepositoryTasks.getSingleton().readFromJson();
    }

    public static void writeJsons(){
        RepositoryTasks.getSingleton().writeToJson();
        RepositoryUsers.getInstance().writeToJson();
    }
}