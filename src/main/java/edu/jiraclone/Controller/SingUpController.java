package edu.jiraclone.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.jiraclone.Users.Roles;
import edu.jiraclone.Users.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField regLoginField;

    @FXML
    private TextField regNameField;

    @FXML
    private Button regBackToSingInPage;

    @FXML
    private TextField regSurnameField;

    @FXML
    private CheckBox regCheckAgree;

    @FXML
    private ChoiceBox<Roles> regRoleChoiceBox;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private Button regSingUpButton;

    @FXML
    private void configRegRoleChoiceBox(){
        ObservableList<Roles> roles = FXCollections.observableArrayList(Roles.values());
        regRoleChoiceBox.setItems(roles);
        regRoleChoiceBox.setValue(roles.get(3));
    }

    @FXML
    private void returnToSingInPage(){
        Parent root1 = null;
        try {
            root1 = FXMLLoader.load(getClass().getResource("/singIn.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.show();
            regBackToSingInPage.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void initialize() {
        configRegRoleChoiceBox();

        regSingUpButton.disableProperty().bind(
                regLoginField.textProperty().isEmpty()
                .or(regPasswordField.textProperty().isEmpty())
                .or(regNameField.textProperty().isEmpty())
                .or(regSurnameField.textProperty().isEmpty())
                .or(regCheckAgree.selectedProperty())
        );



        regSingUpButton.setOnAction(event -> {
            //Создание нового юзера
            new User(regLoginField.getText(), regPasswordField.getText(), regNameField.getText(), regSurnameField.getText(), regRoleChoiceBox.getValue());
            returnToSingInPage();
        });

        regBackToSingInPage.setOnAction(event -> {
            returnToSingInPage();
        });





    }

}
