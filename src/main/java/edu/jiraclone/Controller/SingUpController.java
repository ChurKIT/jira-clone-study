package edu.jiraclone.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private ChoiceBox<?> regRoleChoiseBox;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private Button regSingUpButton;



    @FXML
    void initialize() {


    }
}
