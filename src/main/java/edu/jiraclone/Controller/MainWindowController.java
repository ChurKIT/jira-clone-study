package edu.jiraclone.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.jiraclone.Command;
import edu.jiraclone.RepositoryTasks;
import edu.jiraclone.RepositoryUsers;
import edu.jiraclone.Tasks.Task;
import edu.jiraclone.Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcomeUserName;

    @FXML
    private Button logOutButton;

    @FXML
    private Button newTaskButton;

    @FXML
    private ListView<Task> tasksListView;

    @FXML
    private TextField taskNameField;

    @FXML
    private ChoiceBox assigneeLogin;

    @FXML
    private Button refreshTasks;

    @FXML
    private void configAssigneeLogin(){
        ObservableList<String> logins = FXCollections.observableArrayList(RepositoryUsers.getInstance().getLogins());
        assigneeLogin.setItems(logins);
    }

    @FXML
    private void toSingInPage(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/singIn.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            logOutButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

        ObservableList<Task> tasks = FXCollections.observableArrayList(RepositoryTasks.getSingleton().getTasks());
        tasksListView.setItems(tasks);
        configAssigneeLogin();
        logOutButton.setOnAction(event -> {
            User.setLogIn(false);
            toSingInPage();
        });
        newTaskButton.setOnAction(event -> {
            new Task(taskNameField.getText(), User.getCurrentLogin(), (String) assigneeLogin.getValue());
        });
        refreshTasks.setOnAction(event -> {
            ObservableList<Task> tasksRefresh = FXCollections.observableArrayList(RepositoryTasks.getSingleton().getTasks());
            tasksListView.setItems(tasksRefresh);
        });
    }
}





