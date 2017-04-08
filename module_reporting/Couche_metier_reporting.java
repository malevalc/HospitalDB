/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_reporting;

import Classes.*;
import DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public class Couche_metier_reporting implements Couche_metier_reporting_interface {

    // ----------------------Bar Chart-----------
    //-------ok------
    public Donnees_pie_bar_chart obtenir_donnees_bar_chart_x_service_y_salaire_moyen() {
        InfirmierDAO infirmierdao = new InfirmierDAO();
        ServiceDAO servicedao = new ServiceDAO();
        ArrayList<Service> services;
        ArrayList<Infirmier> infirmiers;

        Service service_actuel = null;
        int moyenne = 0;

        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();

        // On récupère tous les services
        services = servicedao.findAll();

//Pour tous les services, on chope les infirmiers, on fait une moyenne de leur salaire 
        //puis on stocke le code du service avec la moyenne dans mes_donnees
        for (int i = 0; i < services.size(); i++) {
            service_actuel = services.get(i);
            infirmiers = infirmierdao.findByService(service_actuel.getCode());
            moyenne = moyenne_salaire_infirmier(infirmiers);

            mes_donnees.setDonneeAxesAbscisses(service_actuel.getCode());
            mes_donnees.setDonneeAxesOrdonnees(moyenne);
        }

        return mes_donnees;

    }

    //+++++++ok++++++
    public Donnees_pie_bar_chart obtenir_donnees_bar_chart_x_docteur_y_nb_actes_medicaux() {
        //Nos résultats
        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();
        ArrayList<String> resultat_docteurs = new ArrayList<String>();
        ArrayList<Integer> resultat_nb_lit = new ArrayList<Integer>();

        // On récupère tout les médecins et pour chaque médecin on compte ses soigness
        DocteurDAO docteurdao = new DocteurDAO();

        ArrayList<Docteur> docteurs = docteurdao.findAll();

        for (int i = 0; i < docteurs.size(); i++) {

            SoigneDAO soignedao = new SoigneDAO();
            ArrayList<Soigne> soignes_par_docteurs = soignedao.findByDocteur(i);

            resultat_nb_lit.add(soignes_par_docteurs.size());
            resultat_docteurs.add(docteurs.get(i).getNom());

        }

        mes_donnees.setAxesAbscisses(resultat_docteurs);
        mes_donnees.setAxesOrdonnees(resultat_nb_lit);

        return mes_donnees;

    }

    //nb de chambre par surveillant
    public Donnees_pie_bar_chart obtenir_donnees_bar_chart_x_surveillant_y_chambre() {
//Resulatat
        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();
        ArrayList<String> resultat_surveillants;
        ArrayList<Integer> resultat_nb_chambre;

        ArrayList<String> surveillants = new ArrayList<String>();
        ArrayList<Integer> nb_chambre = new ArrayList<Integer>();

// Pour toute les chambres, on regarde pour chaque surveillant
        int compteur = 0;

        ChambreDAO chambredao = new ChambreDAO();
        InfirmierDAO infirmierdao = new InfirmierDAO();

        ArrayList<Chambre> chambres = chambredao.findAll();

        //tableau de marquage
        int[] marquage = new int[chambres.size()];
        for (int i = 0; i < chambres.size(); i++) {
            marquage[i] = 0;
        }

        for (int i = 0; i < chambres.size(); i++) {

            //Pour chaque surveillant on compte toutes les fois où il apparait
            for (int j = 0; j < chambres.size(); j++) {
                if (((marquage[j] == 0) && (i != j) && (chambres.get(j).getNoSurveillant() == chambres.get(i).getNoSurveillant()))) {
                    compteur++;
                    marquage[j] = 1;
                }
            }
            if (marquage[i] == 0) {
                surveillants.add(infirmierdao.find(chambres.get(i).getNoSurveillant()).getNom());
                nb_chambre.add(compteur + 1);
                marquage[i] = 1;
            }
            compteur = 0;

        }

        mes_donnees.setAxesAbscisses(surveillants);
        mes_donnees.setAxesOrdonnees(nb_chambre);

        return mes_donnees;

    }

//-----------------Pie Chart--------------------
    //+++++++ok++++++++
    public Donnees_pie_bar_chart obtenir_pie_chart_x_code_service_y_nblits_occupes() {
        //Nos résultats
        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();
        ArrayList<String> resultat_services = new ArrayList<String>();
        ArrayList<Integer> resultat_nb_lit = new ArrayList<Integer>();
        // On récupère tout les services et on compte le nombre d'hospitalisation
        ServiceDAO servicedao = new ServiceDAO();

        ArrayList<Service> services = servicedao.findAll();

        for (int i = 0; i < services.size(); i++) {

            HospitalisationDAO hospdao = new HospitalisationDAO();

            ArrayList<Hospitalisation> hospitalisation_service = hospdao.findByService(services.get(i).getCode());

            if (!hospitalisation_service.isEmpty()) {
                resultat_services.add(services.get(i).getCode());
                resultat_nb_lit.add(hospitalisation_service.size());
            } else {
                resultat_services.add(services.get(i).getCode());
                resultat_nb_lit.add(0);
            }

        }

        mes_donnees.setAxesAbscisses(resultat_services);
        mes_donnees.setAxesOrdonnees(resultat_nb_lit);

        return mes_donnees;
    }

    //++++++ok++++++
    public Donnees_pie_bar_chart obtenir_pie_chart_x_specialite_y_nb_docteurs() {
        //Résultat
        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();
        ArrayList<String> resultat_specialites = new ArrayList<String>();
        ArrayList<Integer> resultat_nb_docteur = new ArrayList<Integer>();

        // On récupère les docteurs par specialite et on a juste a les compter
        resultat_specialites.add("Pneumologue");
        resultat_specialites.add("Cardiologue");
        resultat_specialites.add("Traumatologue");
        resultat_specialites.add("Orthopediste");
        resultat_specialites.add("Radiologue");
        resultat_specialites.add("Anesthesiste");

        DocteurDAO docteurdao = new DocteurDAO();

        for (int i = 0; i < resultat_specialites.size(); i++) {
            ArrayList<Docteur> docteurs = docteurdao.findBySpecialite(resultat_specialites.get(i));
            resultat_nb_docteur.add(docteurs.size());

        }

        mes_donnees.setAxesAbscisses(resultat_specialites);
        mes_donnees.setAxesOrdonnees(resultat_nb_docteur);

        return mes_donnees;
    }

    public Donnees_pie_bar_chart obtenir_pie_chart_x_services_y_nb_infirmier() {
       //Notre resultat

        Donnees_pie_bar_chart mes_donnees = new Donnees_pie_bar_chart();
        ArrayList<String> resultat_code_service = new ArrayList<String>();
        ArrayList<Integer> resultat_nb = new ArrayList<Integer>();

        //On récupère tout les infirmiers par services et on les compte
        ServiceDAO servicedao = new ServiceDAO();
        ArrayList<Service> services = servicedao.findAll();

        for (int i = 0; i < services.size(); i++) {
            InfirmierDAO infirmierdao = new InfirmierDAO();
            ArrayList<Infirmier> infirmiers = infirmierdao.findByService(services.get(i).getCode());
            resultat_nb.add(infirmiers.size());
            resultat_code_service.add(services.get(i).getCode());

        }

        mes_donnees.setAxesAbscisses(resultat_code_service);
        mes_donnees.setAxesOrdonnees(resultat_nb);

        return mes_donnees;

    }

    /*PRIVATE functions*/
    private int moyenne_salaire_infirmier(ArrayList<Infirmier> infirmiers) {
        int moyenne = 0;
        int compteur = 0;
        Infirmier inf;
        for (int j = 0; j < infirmiers.size(); j++) {
            inf = infirmiers.get(j);
            moyenne += inf.getSalaire();
            compteur++;
        }
        return moyenne /= compteur;
    }

}
