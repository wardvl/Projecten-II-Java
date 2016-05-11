/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.users;

import domain.DomainController;
import domain.interfaces.IObservable;
import domain.interfaces.IObserver;
import domain.users.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Maxim
 */
public class UserConfigurationPanelController extends GridPane implements IObserver {

    @FXML
    private TextField txtName;
    @FXML
    private Label lblInfo;
    @FXML
    private TextField txtName1;
    @FXML
    private Button btnDellete;
    @FXML
    private Button btnEdit;
    @FXML
    private CheckBox adminCheckBox;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnListLector;

    private DomainController domainController;

    /**
     * Initializes the controller class.
     */
    public UserConfigurationPanelController(DomainController domainController) {
        this.domainController = domainController;
        initLoader();
        domainController.addObserverToCatalog(this, User.class);
    }

    private void initLoader() throws RuntimeException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserConfigurationPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void edit(ActionEvent event) {
    }

    @FXML
    private void toggleAdmin(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
    }

    @FXML
    private void showLectors(ActionEvent event) {
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}