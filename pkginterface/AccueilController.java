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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import module_connexion.Connexion;
import module_connexion.super_connexion;

/**
 *
 * @author deathley
 */
public class AccueilController implements Initializable, ControlledScreen {

    ScreensController myController;

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    @FXML
    private Text actiontarget;
    @FXML
    private TextField dblogin;
    @FXML
    private TextField dbpwd;
    @FXML
    private TextField login;
    @FXML
    private PasswordField pwd;

    @FXML
    private String dblogintxt;
    @FXML
    private String dbpwdtxt;
    @FXML
    private String logintext;
    @FXML
    private String pwdtext;

    private void setprompts(){
        dblogin.setPromptText("Enter DataBase Login.");
        dbpwd.setPromptText("Enter DataBase Pwd.");
        login.setPromptText("Enter Login.");
        pwd.setPromptText("Enter Password.");
    }
    
    private void verif() {
        actiontarget.setText("Please fill in the empty field(s).");
        if (dblogintxt.equals("")) {
            dblogin.setId("text-empty");
        }
        if (dbpwdtxt.equals("")) {
            dbpwd.setId("text-empty");
        }
        if (logintext.equals("")) {
            login.setId("text-empty");
        }
        if (pwdtext.equals("")) {
            pwd.setId("text-empty");
        }
        if (!(dblogintxt.equals(""))) {
            dblogin.setId("text");
        }
        if (!(dbpwdtxt.equals(""))) {
            dbpwd.setId("text");
        }
        if (!(logintext.equals(""))) {
            login.setId("text");
        }
        if (!(pwdtext.equals(""))) {
            pwd.setId("text");
        }
    }

    private void cleanform() {
        actiontarget.setText("");
        dblogin.clear();
        dblogin.setId("text");
        dbpwd.clear();
        dbpwd.setId("text");
        login.clear();
        login.setId("text");
        pwd.clear();
        pwd.setId("text");
    }

    private void gettexts() {
        dblogintxt = (dblogin.getText());
        dbpwdtxt = (dbpwd.getText());
        logintext = (login.getText());
        pwdtext = (pwd.getText());

    }
/**
 * 
 * @param keyEvent 
 */
    @FXML
    private void key(KeyEvent keyEvent) {
        gettexts();
        ActionEvent event = new ActionEvent();
        if (keyEvent.getCode() == KeyCode.ENTER) {
            goToMenu(event);
        }
    }
/**
 * 
 * @param event 
 */
    @FXML
    private void goToMenu(ActionEvent event) {
        gettexts();
        if ((dblogintxt.equals("")) || (dbpwdtxt.equals("")) || (logintext.equals("")) || (pwdtext.equals(""))) {
            verif();
        } else {
            try {
                super_connexion.my_con = new Connexion(logintext,pwdtext,dblogintxt,dbpwdtxt, false);// mettre le login de l ece, le mot de passe , l(identifiant de la bdd , son mdp et true/false pour avoir connexion locale
                if (super_connexion.my_con.isConnectionEstablished())
                {
                    myController.setScreen(Interface.menuID);
                    cleanform();
                }
                else{
                    cleanform();
                    actiontarget.setText("Error in connexion: check again!");}
            } catch (SQLException ex) {
                Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/**
 * 
 * @param url
 * @param rb 
 */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setprompts();
    }
}
