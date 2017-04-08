/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import module_reporting.*;

/**
 * FXML Controller class
 *
 * @author deathley
 */
public class ReportingController implements Initializable, ControlledScreen {

    ScreensController myController;
    /**
     * Initializes the controller class.
     */

    @FXML
    private BarChart bar1, bar2, bar3;
    @FXML
    private PieChart pie1, pie2, pie3;
    @FXML
    private AnchorPane fenetre;

    /**
     *
     * @param i
     * @return
     */
    private BarChart.Series<String, Number> getbars(int i) {
        Couche_metier_reporting reporting = new Couche_metier_reporting();
        switch (i) {
            case 0:
                Donnees_pie_bar_chart donnees1 = reporting.obtenir_donnees_bar_chart_x_service_y_salaire_moyen();
                ArrayList<String> abscisse1 = donnees1.getAxesAbscisses();
                ArrayList<Integer> ordonnees1 = donnees1.getAxesOrdonnees();

                BarChart.Series<String, Number> seriesbar1 = new BarChart.Series<>();
                for (int j = 0; j < abscisse1.size(); j++) {
                    seriesbar1.getData().add(new XYChart.Data<>(abscisse1.get(j), (Number) ordonnees1.get(j)));
                }
                return seriesbar1;
            case 1:
                Donnees_pie_bar_chart donnees2 = reporting.obtenir_donnees_bar_chart_x_docteur_y_nb_actes_medicaux();
                ArrayList<String> abscisses2 = donnees2.getAxesAbscisses();
                ArrayList<Integer> ordonnees2 = donnees2.getAxesOrdonnees();

                BarChart.Series<String, Number> seriesbar2 = new BarChart.Series<>();
                for (int j = 0; j < abscisses2.size(); j++) {
                    seriesbar2.getData().add(new XYChart.Data<>(abscisses2.get(j), (Number) ordonnees2.get(j)));
                }
                return seriesbar2;
            case 2:
                Donnees_pie_bar_chart donnees3 = reporting.obtenir_donnees_bar_chart_x_surveillant_y_chambre();
                ArrayList<String> abscisses3 = donnees3.getAxesAbscisses();
                ArrayList<Integer> ordonnees3 = donnees3.getAxesOrdonnees();

                BarChart.Series<String, Number> seriesbar3 = new BarChart.Series<>();
                for (int j = 0; j < abscisses3.size(); j++) {
                    seriesbar3.getData().add(new XYChart.Data<>(abscisses3.get(j), (Number) ordonnees3.get(j)));
                }
                return seriesbar3;
            default: ;
        }
        return null;
    }

    /**
     *
     * @param i
     * @return
     */
    ObservableList<PieChart.Data> getpies(int i) {
        Couche_metier_reporting reporting = new Couche_metier_reporting();
        switch (i) {
            case 0:
                Donnees_pie_bar_chart donnees1 = reporting.obtenir_pie_chart_x_code_service_y_nblits_occupes();
                ArrayList<String> abscisse1 = donnees1.getAxesAbscisses();
                ArrayList<Integer> ordonnees1 = donnees1.getAxesOrdonnees();

                ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList(
                        new PieChart.Data(abscisse1.get(0), ordonnees1.get(0)),
                        new PieChart.Data(abscisse1.get(1), ordonnees1.get(1)),
                        new PieChart.Data(abscisse1.get(2), ordonnees1.get(2)));
                return pieChartData1;
            case 1:
                Donnees_pie_bar_chart donnees2 = reporting.obtenir_pie_chart_x_specialite_y_nb_docteurs();
                ArrayList<String> abscisse2 = donnees2.getAxesAbscisses();
                ArrayList<Integer> ordonnees2 = donnees2.getAxesOrdonnees();

                ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList(
                        new PieChart.Data(abscisse2.get(0), ordonnees2.get(0)),
                        new PieChart.Data(abscisse2.get(1), ordonnees2.get(1)),
                        new PieChart.Data(abscisse2.get(2), ordonnees2.get(2)),
                        new PieChart.Data(abscisse2.get(3), ordonnees2.get(3)),
                        new PieChart.Data(abscisse2.get(4), ordonnees2.get(4)),
                        new PieChart.Data(abscisse2.get(5), ordonnees2.get(5)));
                return pieChartData2;
            case 2:
                Donnees_pie_bar_chart donnees3 = reporting.obtenir_pie_chart_x_services_y_nb_infirmier();
                ArrayList<String> abscisse3 = donnees3.getAxesAbscisses();
                ArrayList<Integer> ordonnees3 = donnees3.getAxesOrdonnees();

                ObservableList<PieChart.Data> pieChartData3 = FXCollections.observableArrayList(
                        new PieChart.Data(abscisse3.get(0), ordonnees3.get(0)),
                        new PieChart.Data(abscisse3.get(1), ordonnees3.get(1)),
                        new PieChart.Data(abscisse3.get(2), ordonnees3.get(2)));

                return pieChartData3;
            default: ;
        }
        return null;
    }

    /**
     *
     * @param screenParent
     */
    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    private void calculs() {
        calculbar();
        calculpie();
    }

    /**
     *
     * @param event
     */
    @FXML
    private void backToMenu(ActionEvent event) {
        myController.setScreen(Interface.menuID);
    }

    private void calculpie() {

        pie1.setData(getpies(0));
        pie1.setTitle("Occupied bed by service");

        pie2.setData(getpies(1));
        pie2.setTitle("Doctors by speciality");

        pie3.setData(getpies(2));
        pie3.setTitle("Nurses by service");
    }

    private void calculbar() {
        ObservableList<XYChart.Series<String, Number>> barChartData1 = FXCollections.observableArrayList();
        barChartData1.add(getbars(0));
        bar1.setData(barChartData1);
        bar1.setTitle("Average salary by service");

        ObservableList<XYChart.Series<String, Number>> barChartData2 = FXCollections.observableArrayList();
        barChartData2.add(getbars(1));
        bar2.setData(barChartData2);

        ObservableList<XYChart.Series<String, Number>> barChartData3 = FXCollections.observableArrayList();
        barChartData3.add(getbars(2));
        bar3.setData(barChartData3);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void refresh(ActionEvent event) {
        calculs();
    }

    @FXML
    private void displaybar(boolean value) {
        bar1.setVisible(value);
        bar2.setVisible(value);
        bar3.setVisible(value);
    }

    @FXML
    private void displaypie(boolean value) {
        pie1.setVisible(value);
        pie2.setVisible(value);
        pie3.setVisible(value);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void barAction(ActionEvent event) {
        calculbar();

        displaybar(true);
        displaypie(false);
    }

    /**
     *
     * @param event
     */
    @FXML
    private void pieAction(ActionEvent event) {
        calculpie();

        displaypie(true);
        displaybar(false);
    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        displaybar(true);
        displaypie(false);
    }
}
