/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import Classes.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import module_mise_a_jour.Couche_metier_maj;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class MajController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    ScreensController myController;

    @FXML
    private Text actiontarget;
    @FXML
    private TextField number;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresseligne;
    @FXML
    private TextField adresseville;
    @FXML
    private TextField adressecp;
    @FXML
    private TextField tel;
    @FXML
    private TextField salaire;
    @FXML
    private RadioButton add;
    @FXML
    private RadioButton update;
    @FXML
    private RadioButton delete;
    @FXML
    private ToggleGroup RadioGroup;
    @FXML
    private ComboBox table;
    @FXML
    private ComboBox spe;
    @FXML
    private ComboBox mut;
    @FXML
    private ComboBox service;
    @FXML
    private ComboBox rotation;
    @FXML
    private Label servicelbl;
    @FXML
    private Label salarylbl;
    @FXML
    private Label rotlbl;
    @FXML
    private Label healthlbl;
    @FXML
    private Label speclbl;

    private String numbertxt;
    private String nomtxt;
    private String prenomtxt;
    private String adress;
    private String teltxt;
    private String spectxt;
    private String servtxt;
    private Double salval;
    private String rottxt;
    private String mutuelletxt;

    private void resetform() {
        speclbl.setVisible(false);
        spe.setVisible(false);
        healthlbl.setVisible(true);
        mut.setVisible(true);
        table.setValue("Patient");
        spe.setValue("Anesthetist");
        mut.setValue("AG2R");
        service.setValue("Cardiology");
        rotation.setValue("Day");
        service.setVisible(false);
        rotation.setVisible(false);
        salaire.setVisible(false);
        servicelbl.setVisible(false);
        salarylbl.setVisible(false);
        rotlbl.setVisible(false);
    }

    private void verif() {
        actiontarget.setText("Please fill in the empty field(s).");
        if (numbertxt.equals("")) {
            number.setId("text-empty");
        }
        if (nomtxt.equals("")) {
            nom.setId("text-empty");
        }
        if (prenomtxt.equals("")) {
            prenom.setId("text-empty");
        }
        if (adresseligne.getText().equals("")) {
            adresseligne.setId("text-empty");
        }
        if (adressecp.getText().equals("")) {
            adressecp.setId("text-empty");
        }
        if (adresseville.getText().equals("")) {
            adresseville.setId("text-empty");
        }
        if (teltxt.equals("")) {
            tel.setId("text-empty");
        }
        if (!(numbertxt.equals(""))) {
            number.setId("text");
        }
        if (!(nomtxt.equals(""))) {
            nom.setId("text");
        }
        if (!(prenomtxt.equals(""))) {
            prenom.setId("text");
        }
        if (!(adresseligne.getText().equals(""))) {
            adresseligne.setId("text");
        }
        if (!(adressecp.getText().equals(""))) {
            adressecp.setId("text");
        }
        if (!(adresseville.getText().equals(""))) {
            adresseville.setId("text");
        }
        if (!teltxt.equals("")) {
            tel.setId("text");
        }
    }

    void setpromptstextfield() {
        number.setPromptText("ID");
        nom.setPromptText("Last Name");
        prenom.setPromptText("First Name");
        adresseligne.setPromptText("Adress Line 1");
        adresseville.setPromptText("City");
        adressecp.setPromptText("Postal Code");
        tel.setPromptText("Phone Number");
        salaire.setPromptText("Salary");
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetform();
        setpromptstextfield();
    }

    /**
     *
     * @param screenParent
     */
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    private void cas_nurse() {
        speclbl.setVisible(false);
        spe.setVisible(false);
        mut.setVisible(false);
        healthlbl.setVisible(false);
        service.setVisible(true);
        rotation.setVisible(true);
        salaire.setVisible(true);
        servicelbl.setVisible(true);
        salarylbl.setVisible(true);
        rotlbl.setVisible(true);
    }

    private void cas_patient() {
        speclbl.setVisible(false);
        spe.setVisible(false);
        mut.setVisible(true);
        healthlbl.setVisible(true);
        service.setVisible(false);
        rotation.setVisible(false);
        salaire.setVisible(false);
        servicelbl.setVisible(false);
        salarylbl.setVisible(false);
        rotlbl.setVisible(false);
    }

    private void cas_doctor() {
        speclbl.setVisible(true);
        spe.setVisible(true);
        mut.setVisible(false);
        healthlbl.setVisible(false);
        service.setVisible(false);
        rotation.setVisible(false);
        salaire.setVisible(false);
        servicelbl.setVisible(false);
        salarylbl.setVisible(false);
        rotlbl.setVisible(false);
    }

    private void cleanform() {
        actiontarget.setText("");
        number.setEditable(true);
        number.setId("text");
        number.clear();
        nom.setEditable(true);
        nom.setId("text");
        nom.clear();
        prenom.setEditable(true);
        prenom.setId("text");
        prenom.clear();
        adresseligne.setEditable(true);
        adresseligne.setId("text");
        adresseligne.clear();
        adresseville.setEditable(true);
        adresseville.setId("text");
        adresseville.clear();
        adressecp.setEditable(true);
        adressecp.setId("text");
        adressecp.clear();
        tel.setEditable(true);
        tel.setId("text");
        tel.clear();
    }

    /**
     * @param event
     */
    @FXML
    private void addsel(ActionEvent event) {
        cleanform();
        number.setEditable(true);
        number.setId("text");
        nom.setEditable(true);
        nom.setId("text");
        prenom.setEditable(true);
        prenom.setId("text");
        adresseligne.setEditable(true);
        adresseligne.setId("text");
        adresseville.setEditable(true);
        adresseville.setId("text");
        adressecp.setEditable(true);
        adressecp.setId("text");
        tel.setEditable(true);
        tel.setId("text");
        spe.setEditable(false);
        mut.setEditable(false);
        service.setEditable(false);
        rotation.setEditable(false);
        salaire.setEditable(true);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void updsel(ActionEvent event) {
        cleanform();
    }

    /**
     *
     * @param event
     */
    @FXML
    private void delsel(ActionEvent event) {
        cleanform();
        number.setEditable(true);
        number.setId("text");
        nom.setEditable(false);
        prenom.setEditable(false);
        adresseligne.setEditable(false);
        adresseville.setEditable(false);
        adressecp.setEditable(false);
        tel.setEditable(false);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void tablesel(ActionEvent event) {
        if (table.getSelectionModel().getSelectedItem().toString().equals("Nurse")) {
            cas_nurse();
        }
        if (table.getSelectionModel().getSelectedItem().toString().equals("Patient")) {
            cas_patient();
        }
        if (table.getSelectionModel().getSelectedItem().toString().equals("Doctor")) {
            cas_doctor();
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void launch(ActionEvent event) {
        numbertxt = (number.getText());
        nomtxt = (nom.getText());
        prenomtxt = (prenom.getText());
        teltxt = (tel.getText());
        adress = (adresseligne.getText() + ", " + adressecp.getText() + " " + adresseville.getText());
        switch (spe.getSelectionModel().getSelectedIndex()) {
            case 0:
                spectxt = "Anesthesiste";
                break;
            case 1:
                spectxt = "Cardiologue";
                break;
            case 2:
                spectxt = "Pneumologue";
                break;
            case 3:
                spectxt = "Orthopediste";
                break;
            case 4:
                spectxt = "Radiologue";
                break;
            case 5:
                spectxt = "Traumatologue";
                break;
            default:;
        }
        mutuelletxt = mut.getSelectionModel().getSelectedItem().toString();
        switch (service.getSelectionModel().getSelectedIndex()) {
            case 0:
                servtxt = "CAR";
                break;
            case 1:
                servtxt = "CHG";
                break;
            case 2:
                servtxt = "REA";
                break;
        }
        switch (rotation.getSelectionModel().getSelectedIndex()) {
            case 0:
                rottxt = "JOUR";
                break;
            case 1:
                rottxt = "NUIT";
                break;
            default:;
        }
        if (salaire.getText().equals("")) {
            salval = 0.0;
        } else {
            salval = Double.parseDouble(salaire.getText());
        }
        if (RadioGroup.getSelectedToggle() == delete) {
            Couche_metier_maj couche = new Couche_metier_maj();
            switch (table.getSelectionModel().getSelectedItem().toString()) {
                case "Patient":
                    Malade malade = new Malade();
                    malade.setNumero(Integer.parseInt(numbertxt));
                    couche.deleteMalade(malade);
                    break;
                case "Doctor":
                    Docteur docteur = new Docteur();
                    docteur.setNumero(Integer.parseInt(numbertxt));
                    couche.deleteDocteur(docteur);
                    break;
                case "Nurse":
                    Infirmier inf = new Infirmier();
                    inf.setNumero(Integer.parseInt(numbertxt));
                    couche.deleteInfirmier(inf);
                    break;
                default: ;
            }

        }
        if (RadioGroup.getSelectedToggle() == add) {
            if ((numbertxt.equals("")) || (nomtxt.equals("")) || (prenomtxt.equals("")) || (teltxt.equals("")) || (adresseligne.getText().equals("")) || (adressecp.getText().equals("")) || (adresseville.getText().equals(""))) {
                verif();
            } else {
                Couche_metier_maj couche = new Couche_metier_maj();
                switch (table.getSelectionModel().getSelectedItem().toString()) {
                    case "Patient":
                        Malade malade = new Malade();
                        malade.setNumero(Integer.parseInt(numbertxt));
                        malade.setMutuelle(mutuelletxt);
                        malade.setPrenom(prenomtxt);
                        malade.setNom(nomtxt);
                        malade.setTel(teltxt);
                        malade.setAdresse(adress);
                        couche.insererMalade(malade);
                        break;
                    case "Doctor":
                        Docteur docteur = new Docteur();
                        docteur.setNumero(Integer.parseInt(numbertxt));
                        docteur.setSpecialite(spectxt);
                        docteur.setAdresse(adress);
                        docteur.setNom(nomtxt);
                        docteur.setPrenom(prenomtxt);
                        docteur.setTel(teltxt);
                        couche.insererDocteur(docteur);
                        break;
                    case "Nurse":
                        Infirmier infirmier = new Infirmier();
                        infirmier.setNumero(Integer.parseInt(numbertxt));
                        infirmier.setCodeService(servtxt);
                        infirmier.setRotation(rottxt);
                        infirmier.setSalaire(salval.intValue());
                        infirmier.setNom(nomtxt);
                        infirmier.setPrenom(prenomtxt);
                        infirmier.setAdresse(adress);
                        infirmier.setTel(teltxt);
                        couche.insererInfirmier(infirmier);
                        break;
                    default: ;
                }
            }
        }
        if (RadioGroup.getSelectedToggle() == update) {
            if ((numbertxt.equals("")) || (nomtxt.equals("")) || (prenomtxt.equals("")) || (teltxt.equals("")) || (adresseligne.getText().equals("")) || (adressecp.getText().equals("")) || (adresseville.getText().equals(""))) {
                verif();
            } else {
                Couche_metier_maj couche = new Couche_metier_maj();
                switch (table.getSelectionModel().getSelectedItem().toString()) {
                    case "Patient":
                        Malade malade = new Malade();
                        malade.setNumero(Integer.parseInt(numbertxt));
                        malade.setMutuelle(mutuelletxt);
                        malade.setPrenom(prenomtxt);
                        malade.setNom(nomtxt);
                        malade.setTel(teltxt);
                        malade.setAdresse(adress);
                        couche.updateMalade(malade);
                        break;
                    case "Doctor":
                        Docteur docteur = new Docteur();
                        docteur.setNumero(Integer.parseInt(numbertxt));
                        docteur.setSpecialite(spectxt);
                        docteur.setAdresse(adress);
                        docteur.setNom(nomtxt);
                        docteur.setPrenom(prenomtxt);
                        docteur.setTel(teltxt);
                        couche.updateDocteur(docteur);
                        break;
                    case "Nurse":
                        Infirmier infirmier = new Infirmier();
                        infirmier.setNumero(Integer.parseInt(numbertxt));
                        infirmier.setCodeService(servtxt);
                        infirmier.setRotation(adress);
                        infirmier.setSalaire(salval.intValue());
                        infirmier.setNom(adress);
                        infirmier.setPrenom(adress);
                        infirmier.setAdresse(adress);
                        infirmier.setTel(teltxt);
                        couche.updateInfirmier(infirmier);
                        break;
                    default: ;
                }
            }
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void backToMenu(ActionEvent event
    ) {
        myController.setScreen(Interface.menuID);
        cleanform();
        resetform();
    }
}
