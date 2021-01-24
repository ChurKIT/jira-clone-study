package edu.jiraclone.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.jiraclone.Users.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SingInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSingInButton;

    @FXML
    private PasswordField authPasswordField;

    @FXML
    private Button authSingUpButton;

    @FXML
    private TextField authLoginField;

    @FXML
    private void singUpPage(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/singUp.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            authSingUpButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void toMainPage(){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            authSingUpButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void incorrectLoginOrPass(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Incorrect login or password");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect login or password. Repeat or SingUp");

        alert.showAndWait();
    }




    @FXML
    void initialize() {

        authSingUpButton.setOnAction(event -> {
            singUpPage();
        });


        authSingInButton.disableProperty().bind(
                authLoginField.textProperty().isEmpty()
                    .or(authPasswordField.textProperty().isEmpty())
        );

        authSingInButton.setOnAction(event -> {
            User.singIn(authLoginField.getText(), authPasswordField.getText());
            if(User.isLogIn()){
                toMainPage();
            } else {
                incorrectLoginOrPass();
            }

        });

    }
}

