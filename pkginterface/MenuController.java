/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import Controleur.ProjetBDD;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import module_connexion.super_connexion;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class MenuController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML 
    private Label connexion;
    
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    private void goToMaj(ActionEvent event) {
        myController.setScreen(Interface.majID);
    }

    @FXML
    private void goToReporting(ActionEvent event) {
        myController.setScreen(Interface.reportingID);
    }

    @FXML
    private void goToRequests(ActionEvent event) {
        myController.setScreen(Interface.requestsID);
    }

    @FXML
    private void goToHelp(ActionEvent event) {
        myController.setScreen(Interface.helpID);
    }
    
    private void connexiontype(){
        connexion.setText(super_connexion.my_con.typeConnection());
    }
/**
 * 
 * @param event 
 */
    @FXML
    private void goBackToAccueil(ActionEvent event) {
        try {
            super_connexion.my_con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        myController.setScreen(Interface.accueilID);
    }
}
