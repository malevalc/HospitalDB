/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import Classes.Docteur;
import Classes.Hospitalisation;
import Classes.Infirmier;
import Classes.Malade;
import Classes.Service;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import module_recherche_information.Couche_metier_recherche;
import module_recherche_information.Resultat_recherche;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class RResultsController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private TextArea text;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text.setText("Queries results displayed here(clic on 'Get Results').");
    }

    /**
     *
     * @param event
     */
    @FXML
    private void backToRequests(ActionEvent event) {
        myController.setScreen(Interface.requestsID);
        text.setText("Queries results displayed here (clic on 'Get Results').");
    }

    @FXML
    private void displayResults(ActionEvent event) {
        Couche_metier_recherche recherche = new Couche_metier_recherche();
        StringBuilder txt = new StringBuilder();
        switch (Resultat.requeteselect) {
            case 0:
                ArrayList<Malade> malades = recherche.rechercher_malade_selon_mutuelle_R1("MAAF");
                txt.append("R1- Name of patients registered in the 'MAAF' health plan.\n\nFirst Name \t Last Name\n\n");
                for (int j = 0; j < malades.size(); j++) {
                    txt.append(malades.get(j).getPrenom()).append("\t");
                    if (malades.get(j).getPrenom().length() < 5) {
                        txt.append("\t");
                    }
                    txt.append(malades.get(j).getNom()).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 1:
                ArrayList<Infirmier> infirmiers = recherche.rechercher_infirmier_selon_rotation_R2("NUIT");
                txt.append("R2- Name of nurses working nights.\n\nFirst Name \t Last Name\n\n");
                for (int j = 0; j < infirmiers.size(); j++) {
                    txt.append(infirmiers.get(j).getPrenom()).append("\t");
                    if (infirmiers.get(j).getPrenom().length() < 5) {
                        txt.append("\t");
                    }
                    txt.append(infirmiers.get(j).getNom()).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 2:
                Resultat_recherche<Service, Docteur, Integer> resultat1 = recherche.rechercher_requete_R3();
                txt.append("R3- For every service: its name, building, name and informations \non its director (name and speciality).\n\nService Name \t Building\t Director's First Name\t Director's Last Name\t Director's speciality\n\n");
                for (int j = 0; j < resultat1.getArrayList1().size(); j++) {
                    txt.append(resultat1.getArrayList1().get(j).getNom()).append("\t");
                    txt.append(resultat1.getArrayList1().get(j).getBatiment()).append("\t");
                    txt.append(resultat1.getArrayList2().get(j).getPrenom()).append("\t");
                    txt.append(resultat1.getArrayList2().get(j).getNom()).append("\t");
                    txt.append(resultat1.getArrayList2().get(j).getSpecialite()).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 3:
                Resultat_recherche<Hospitalisation, Service, Malade> resultat2 = recherche.rechercher_requete_R4("B", "MN");
                txt.append("R4- For every bed, in building 'B', which is assigned to a patient \nwhose health plan starts like 'MN': the bed number, the room number, the service name and informations on the patient (name & health plan).\n\nRoom Number \t Bed\t Service Name\t First Name\t Last Name\t Health plan\n\n");
                for (int j = 0; j < resultat2.getArrayList1().size(); j++) {
                    txt.append(resultat2.getArrayList1().get(j).getNo_chambre()).append("\t");
                    txt.append(resultat2.getArrayList1().get(j).getLit()).append("\t");
                    txt.append(resultat2.getArrayList2().get(j).getNom()).append("\t");
                    txt.append(resultat2.getArrayList3().get(j).getPrenom()).append("\t");
                    txt.append(resultat2.getArrayList3().get(j).getNom()).append("\t");
                    txt.append(resultat2.getArrayList3().get(j).getMutuelle()).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 4:
                Resultat_recherche<String,Integer, Integer> resultat3 = recherche.rechercher_requete_R5();
                txt.append("R5- The average of a nurse's salary for every service.\n\nService \t Average Salary\n\n");
                for (int j = 0; j < resultat3.getArrayList1().size(); j++) {
                    txt.append(resultat3.getArrayList1().get(j)).append("\t");
                    txt.append(resultat3.getArrayList2().get(j)).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 5:
                Resultat_recherche<Service, Float, Integer> resultat6 = recherche.rechercher_requete_R6();
                txt.append("R6- For every service in buiding 'A': the average number of bed per room.\n\nService \t Beds\n\n");
                for (int j = 0; j < resultat6.getArrayList1().size(); j++) {
                    txt.append(resultat6.getArrayList1().get(j).getNom()).append("\t");
                    txt.append(resultat6.getArrayList2().get(j)).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 6:
                Resultat_recherche<Malade, Integer, Integer> resultat7 = recherche.rechercher_requete_R7();
                txt.append("R7- For every patient who is in relation with more than 3 doctors: the total number \nof doctors he's in relation with and the corresponding number of specialities.\n\nLast Name \t First Name\t Doctors\t Specialities\n\n");
                for (int j = 0; j < resultat7.getArrayList1().size(); j++) {
                    txt.append(resultat7.getArrayList1().get(j).getNom()).append("\t");
                    txt.append(resultat7.getArrayList1().get(j).getPrenom()).append("\t");
                    txt.append(resultat7.getArrayList2().get(j)).append("\t");
                    txt.append(resultat7.getArrayList3().get(j)).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 7:
                Resultat_recherche<Service, Float, Integer> resultat8 = recherche.rechercher_requete_R8();
                txt.append("R8- For every service: the ratio between the number of nurses and the number \nof patients.\n\nService \t Ratio\n\n");
                for (int j = 0; j < resultat8.getArrayList1().size(); j++) {
                    txt.append(resultat8.getArrayList1().get(j).getNom()).append("\t");
                    txt.append(resultat8.getArrayList2().get(j)).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 8:
                Resultat_recherche<Docteur,Integer, Integer> resultat9 = recherche.rechercher_requete_R9();
                txt.append("R9- Name of doctors who are in relation with at least one patient staying \nat the hospital.\n\nFirst Name\t Last Name\n\n");
                for (int j = 0; j < resultat9.getArrayList1().size(); j++) {
                    txt.append(resultat9.getArrayList1().get(j).getPrenom()).append("\t");
                    txt.append(resultat9.getArrayList1().get(j).getNom()).append("\n");
                }
                text.setText(txt.toString());
                break;
            case 9:
                Resultat_recherche<Docteur,Integer, Integer> resultat10 = recherche.rechercher_requete_R10();
                txt.append("R10- Name of doctors who are not in relation with any patient staying \nat the hospital.\n\nFirst Name\t Last Name\n\n");
                for (int j = 0; j < resultat10.getArrayList1().size(); j++) {
                    txt.append(resultat10.getArrayList1().get(j).getPrenom()).append("\t");
                    txt.append(resultat10.getArrayList1().get(j).getNom()).append("\n");
                }
                text.setText(txt.toString());
                break;
            default:;
        }
    }

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}
