package edu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.jiraclone.Command;
import edu.jiraclone.Users.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    private ListView<?> tasksListView;


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
        logOutButton.setOnAction(event -> {
            User.setLogIn(false);
            toSingInPage();
        });
    }
}





