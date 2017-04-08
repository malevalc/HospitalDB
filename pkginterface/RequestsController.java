/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class RequestsController implements Initializable, ControlledScreen {

    ScreensController myController;
    /**
     * Initializes the controller class.
     */

    @FXML
    private Tab tab1, tab2;
    @FXML
    private ListView requete;
    @FXML
    private ComboBox table;
    @FXML
    private CheckBox number;
    @FXML
    private CheckBox nom;
    @FXML
    private CheckBox prenom;
    @FXML
    private CheckBox adresse;
    @FXML
    private CheckBox mut;
    @FXML
    private CheckBox spec;
    @FXML
    private CheckBox tel;
    @FXML
    private CheckBox servinf;
    @FXML
    private CheckBox rotation;
    @FXML
    private CheckBox salary;
    @FXML
    private CheckBox servicechambre;
    @FXML
    private CheckBox surveillant;
    @FXML
    private CheckBox nblits;
    @FXML
    private CheckBox batiment;
    @FXML
    private CheckBox directeur;

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetform();
        Resultat.attributsselect = new boolean[15];
        table.setValue("Patient");
        tab1.setClosable(false);
        tab2.setClosable(false);
    }

    void getSelections() {
        Resultat.attributsselect[0] = (number.isSelected());
        Resultat.attributsselect[1] = (nom.isSelected());
        Resultat.attributsselect[2] = (prenom.isSelected());
        Resultat.attributsselect[4] = (adresse.isSelected());
        Resultat.attributsselect[5] = (mut.isSelected());
        Resultat.attributsselect[6] = (spec.isSelected());
        Resultat.attributsselect[3] = (tel.isSelected());
        Resultat.attributsselect[7] = (servinf.isSelected());
        Resultat.attributsselect[8] = (rotation.isSelected());
        Resultat.attributsselect[9] = (salary.isSelected());
        Resultat.attributsselect[7] = (servicechambre.isSelected());
        Resultat.attributsselect[10] = (surveillant.isSelected());
        Resultat.attributsselect[11] = (nblits.isSelected());
        Resultat.attributsselect[12] = (batiment.isSelected());
        Resultat.attributsselect[13] = (directeur.isSelected());
    }

    private void resetform() {
        number.setSelected(false);
        nom.setVisible(true);
        nom.setSelected(false);
        nom.setText("Last Name");
        prenom.setVisible(true);
        prenom.setSelected(false);
        adresse.setVisible(true);
        adresse.setSelected(false);
        mut.setVisible(true);
        mut.setSelected(false);
        spec.setVisible(false);
        spec.setSelected(false);
        tel.setVisible(true);
        tel.setSelected(false);
        servinf.setVisible(false);
        servinf.setSelected(false);
        rotation.setVisible(false);
        rotation.setSelected(false);
        salary.setVisible(false);
        salary.setSelected(false);
        servicechambre.setVisible(false);
        servicechambre.setSelected(false);
        surveillant.setVisible(false);
        surveillant.setSelected(false);
        nblits.setVisible(false);
        nblits.setSelected(false);
        batiment.setVisible(false);
        batiment.setSelected(false);
        directeur.setVisible(false);
        directeur.setSelected(false);
    }

    void attributes_doctor() {
        number.setSelected(false);
        nom.setVisible(true);
        nom.setSelected(false);
        nom.setText("Last Name");
        prenom.setVisible(true);
        prenom.setSelected(false);
        adresse.setVisible(true);
        adresse.setSelected(false);
        mut.setVisible(false);
        mut.setSelected(false);
        spec.setVisible(true);
        spec.setSelected(false);
        tel.setVisible(true);
        tel.setSelected(false);
        servinf.setVisible(false);
        servinf.setSelected(false);
        rotation.setVisible(false);
        rotation.setSelected(false);
        salary.setVisible(false);
        salary.setSelected(false);
        servicechambre.setVisible(false);
        servicechambre.setSelected(false);
        surveillant.setVisible(false);
        surveillant.setSelected(false);
        nblits.setVisible(false);
        nblits.setSelected(false);
        batiment.setVisible(false);
        batiment.setSelected(false);
        directeur.setVisible(false);
        directeur.setSelected(false);
    }

    void attributes_nurse() {
        number.setSelected(false);
        nom.setVisible(true);
        nom.setSelected(false);
        nom.setText("Last Name");
        prenom.setVisible(true);
        prenom.setSelected(false);
        adresse.setVisible(true);
        adresse.setSelected(false);
        mut.setVisible(false);
        mut.setSelected(false);
        spec.setVisible(false);
        spec.setSelected(false);
        tel.setVisible(true);
        tel.setSelected(false);
        servinf.setVisible(true);
        servinf.setSelected(false);
        rotation.setVisible(true);
        rotation.setSelected(false);
        salary.setVisible(true);
        salary.setSelected(false);
        servicechambre.setVisible(false);
        servicechambre.setSelected(false);
        surveillant.setVisible(false);
        surveillant.setSelected(false);
        nblits.setVisible(false);
        nblits.setSelected(false);
        batiment.setVisible(false);
        batiment.setSelected(false);
        directeur.setVisible(false);
        directeur.setSelected(false);
        number.setSelected(false);
        nom.setVisible(true);
        nom.setSelected(false);
        nom.setText("Last Name");
        prenom.setVisible(true);
        prenom.setSelected(false);
        adresse.setVisible(true);
        adresse.setSelected(false);
        mut.setVisible(false);
        mut.setSelected(false);
        spec.setVisible(false);
        spec.setSelected(false);
        tel.setVisible(true);
        tel.setSelected(false);
        servinf.setVisible(true);
        servinf.setSelected(false);
        rotation.setVisible(true);
        rotation.setSelected(false);
        salary.setVisible(true);
        salary.setSelected(false);
        servicechambre.setVisible(false);
        servicechambre.setSelected(false);
        surveillant.setVisible(false);
        surveillant.setSelected(false);
        nblits.setVisible(false);
        nblits.setSelected(false);
        batiment.setVisible(false);
        batiment.setSelected(false);
        directeur.setVisible(false);
        directeur.setSelected(false);
    }

    void attributes_room() {
        number.setSelected(false);
        nom.setVisible(false);
        nom.setSelected(false);
        prenom.setVisible(false);
        prenom.setSelected(false);
        adresse.setVisible(false);
        adresse.setSelected(false);
        mut.setVisible(false);
        mut.setSelected(false);
        spec.setVisible(false);
        spec.setSelected(false);
        tel.setVisible(false);
        tel.setSelected(false);
        servinf.setVisible(false);
        servinf.setSelected(false);
        rotation.setVisible(false);
        rotation.setSelected(false);
        salary.setVisible(false);
        salary.setSelected(false);
        servicechambre.setVisible(true);
        servicechambre.setSelected(false);
        surveillant.setVisible(true);
        surveillant.setSelected(false);
        nblits.setVisible(true);
        nblits.setSelected(false);
        batiment.setVisible(false);
        batiment.setSelected(false);
        directeur.setVisible(false);
        directeur.setSelected(false);
    }

    void attributes_service() {
        number.setSelected(false);
        nom.setVisible(true);
        nom.setSelected(false);
        nom.setText("Name");
        prenom.setVisible(false);
        prenom.setSelected(false);
        adresse.setVisible(false);
        adresse.setSelected(false);
        mut.setVisible(false);
        mut.setSelected(false);
        spec.setVisible(false);
        spec.setSelected(false);
        tel.setVisible(false);
        tel.setSelected(false);
        servinf.setVisible(false);
        servinf.setSelected(false);
        rotation.setVisible(false);
        rotation.setSelected(false);
        salary.setVisible(false);
        salary.setSelected(false);
        servicechambre.setVisible(false);
        servicechambre.setSelected(false);
        surveillant.setVisible(false);
        surveillant.setSelected(false);
        nblits.setVisible(false);
        nblits.setSelected(false);
        batiment.setVisible(true);
        batiment.setSelected(false);
        directeur.setVisible(true);
        directeur.setSelected(false);
    }

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    /**
     *
     * @param event
     */
    @FXML
    private void tablesel(ActionEvent event) {
        switch (table.getSelectionModel().getSelectedItem().toString()) {
            case "Patient":
                Resultat.tableselect = 0;
                resetform();
                break;
            case "Doctor":
                Resultat.tableselect = 1;
                attributes_doctor();
                break;
            case "Nurse":
                Resultat.tableselect = 2;
                attributes_nurse();
                break;
            case "Room":
                Resultat.tableselect = 3;
                attributes_room();
                break;
            case "Service":
                attributes_service();
                Resultat.tableselect = 4;
                break;
            default: ;
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void getResults(ActionEvent event) {
        getSelections();
        if (tab1.isSelected()) {
            switch (requete.getSelectionModel().getSelectedIndex()) {
                case 0:
                    Resultat.requeteselect = 0;
                    break;
                case 1:
                    Resultat.requeteselect = 1;
                    break;
                case 2:
                    Resultat.requeteselect = 2;
                    break;
                case 3:
                    Resultat.requeteselect = 3;
                    break;
                case 4:
                    Resultat.requeteselect = 4;
                    break;
                case 5:
                    Resultat.requeteselect = 5;
                    break;
                case 6:
                    Resultat.requeteselect = 6;
                    break;
                case 7:
                    Resultat.requeteselect = 7;
                    break;
                case 8:
                    Resultat.requeteselect = 8;
                    break;
                case 9:
                    Resultat.requeteselect = 9;
                    break;
                default:;
            }
            myController.setScreen(Interface.rresultsID);
        }
        if (tab2.isSelected()) {
            myController.setScreen(Interface.aresultsID);
        }
    }

    /**
     *
     * @param event
     */
    @FXML
    private void backToMenu(ActionEvent event) {
        myController.setScreen(Interface.menuID);
    }
}
