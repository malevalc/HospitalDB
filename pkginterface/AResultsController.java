/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import Classes.Chambre;
import Classes.Docteur;
import Classes.Infirmier;
import Classes.Malade;
import Classes.Service;
import DAO.ChambreDAO;
import DAO.DocteurDAO;
import DAO.InfirmierDAO;
import DAO.MaladeDAO;
import DAO.ServiceDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class AResultsController implements Initializable, ControlledScreen {

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
        text.setText("Queries results displayed here.");
    }

    /**
     *
     * @param event
     */
    @FXML
    private void backToRequests(ActionEvent event) {
        myController.setScreen(Interface.requestsID);

    }

    @FXML
    private void displayResults(ActionEvent event) {
        StringBuilder txt = new StringBuilder();
        switch (Resultat.tableselect) {
            case 0:
                MaladeDAO maladedao = new MaladeDAO();
                ArrayList<Malade> malades = maladedao.findAll();
                for (int i = 0; i < malades.size(); i++) {
                    if (Resultat.attributsselect[0]) {
                        txt.append(malades.get(i).getNumero()).append("\t");
                    }
                    if (Resultat.attributsselect[1]) {
                        txt.append(malades.get(i).getNom()).append("\t");
                    }
                    if (Resultat.attributsselect[2]) {
                        txt.append(malades.get(i).getPrenom()).append("\t");
                    }
                    if (Resultat.attributsselect[3]) {
                        txt.append(malades.get(i).getTel()).append("\t");
                    }
                    if (Resultat.attributsselect[4]) {
                        txt.append(malades.get(i).getAdresse()).append("\t");
                    }
                    if (Resultat.attributsselect[5]) {
                        txt.append(malades.get(i).getMutuelle()).append("\t");
                    }
                    txt.append("\n");
                }
                break;
            case 1:
                DocteurDAO docteur = new DocteurDAO();
                ArrayList<Docteur> docteurs = docteur.findAll();
                for (int i = 0; i < docteurs.size(); i++) {
                    if (Resultat.attributsselect[0]) {
                        txt.append(docteurs.get(i).getNumero()).append("\t");
                    }
                    if (Resultat.attributsselect[1]) {
                        txt.append(docteurs.get(i).getNom()).append("\t");
                    }
                    if (Resultat.attributsselect[2]) {
                        txt.append(docteurs.get(i).getPrenom()).append("\t");
                    }
                    if (Resultat.attributsselect[3]) {
                        txt.append(docteurs.get(i).getTel()).append("\t");
                    }
                    if (Resultat.attributsselect[4]) {
                        txt.append(docteurs.get(i).getAdresse()).append("\t");
                    }
                    if (Resultat.attributsselect[6]) {
                        txt.append(docteurs.get(i).getSpecialite()).append("\t");
                    }
                    txt.append("\n");
                }
                break;
            case 2:
                InfirmierDAO infdao = new InfirmierDAO();
                ArrayList<Infirmier> infirmiers = infdao.findAll();
                for (int i = 0; i < infirmiers.size(); i++) {
                    if (Resultat.attributsselect[0]) {
                        txt.append(infirmiers.get(i).getNumero()).append("\t");
                    }
                    if (Resultat.attributsselect[1]) {
                        txt.append(infirmiers.get(i).getNom()).append("\t");
                    }
                    if (Resultat.attributsselect[2]) {
                        txt.append(infirmiers.get(i).getPrenom()).append("\t");
                    }
                    if (Resultat.attributsselect[3]) {
                        txt.append(infirmiers.get(i).getTel()).append("\t");
                    }
                    if (Resultat.attributsselect[4]) {
                        txt.append(infirmiers.get(i).getAdresse()).append("\t");
                    }
                    if (Resultat.attributsselect[7]) {
                        txt.append(infirmiers.get(i).getCodeService()).append("\t");
                    }
                    if (Resultat.attributsselect[8]) {
                        txt.append(infirmiers.get(i).getRotation()).append("\t");
                    }
                    if (Resultat.attributsselect[9]) {
                        txt.append(infirmiers.get(i).getSalaire()).append("\t");
                    }
                    txt.append("\n");
                }
                break;
            case 3:
                ChambreDAO roomdao = new ChambreDAO();
                ArrayList<Chambre> rooms = roomdao.findAll();
                for (int i = 0; i < rooms.size(); i++) {
                    if (Resultat.attributsselect[0]) {
                        txt.append(rooms.get(i).getNo_chambre()).append("\t");
                    }
                    if (Resultat.attributsselect[7]) {
                        txt.append(rooms.get(i).getCode_service()).append("\t");
                    }
                    if (Resultat.attributsselect[10]) {
                        txt.append(rooms.get(i).getNoSurveillant()).append("\t");
                    }
                    if (Resultat.attributsselect[11]) {
                        txt.append(rooms.get(i).getNb_lits()).append("\t");
                    }
                    txt.append("\n");
                }
                break;
            case 4:
                ServiceDAO servicedao = new ServiceDAO();
                ArrayList<Service> services = servicedao.findAll();
                for (int i = 0; i < services.size(); i++) {
                    if (Resultat.attributsselect[0]) {
                        txt.append(services.get(i).getCode()).append("\t");
                    }
                    if (Resultat.attributsselect[1]) {
                        txt.append(services.get(i).getNom()).append("\t");
                    }
                    if (Resultat.attributsselect[12]) {
                        txt.append(services.get(i).getBatiment()).append("\t");
                    }
                    if (Resultat.attributsselect[13]) {
                        txt.append(services.get(i).getDirecteur()).append("\t");
                    }
                    txt.append("\n");
                }
                break;
            default:;
        }
        text.setText(txt.toString());
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
