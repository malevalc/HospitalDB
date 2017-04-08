/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import Controleur.ProjetBDD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import module_connexion.super_connexion;

/**
 *
 * @author deathley
 */
public class Interface extends Application {

    public static String accueilID = "Accueil";
    public static String accueilFile = "Accueil.fxml";
    public static String menuID = "Menu";
    public static String menuFile = "Menu.fxml";
    public static String helpID = "Help";
    public static String helpFile = "Help.fxml";
    public static String majID = "Maj";
    public static String majFile = "Maj.fxml";
    public static String reportingID = "Reporting";
    public static String reportingFile = "Reporting.fxml";
    public static String rresultsID = "RResults";
    public static String rresultsFile = "RResults.fxml";
    public static String aresultsID = "AResults";
    public static String aresultsFile = "AResults.fxml";
    public static String requestsID = "Requests";
    public static String requestsFile = "Requests.fxml";
/**
 * 
 * @param mainContainer 
 */
    private void close(ScreensController mainContainer) {
        try {
            super_connexion.my_con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainContainer.setScreen(Interface.accueilID);
        Platform.exit();
    }
/**
 * 
 * @param primaryStage
 * @throws Exception 
 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Interface.accueilID, Interface.accueilFile);
        mainContainer.loadScreen(Interface.menuID, Interface.menuFile);
        mainContainer.loadScreen(Interface.helpID, Interface.helpFile);
        mainContainer.loadScreen(Interface.majID, Interface.majFile);
        mainContainer.loadScreen(Interface.reportingID, Interface.reportingFile);
        mainContainer.loadScreen(Interface.rresultsID, Interface.rresultsFile);
        mainContainer.loadScreen(Interface.aresultsID, Interface.aresultsFile);
        mainContainer.loadScreen(Interface.requestsID, Interface.requestsFile);

        mainContainer.setScreen(Interface.accueilID);
        StackPane root = new StackPane();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image("file:medical-symbol_small.jpg"));
        primaryStage.setTitle("Hospital Database Software");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            close(mainContainer);
        });
        scene.getStylesheets().add(Interface.class.getResource("Interface.css").toExternalForm());
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
