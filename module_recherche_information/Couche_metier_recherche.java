/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_recherche_information;

import java.util.ArrayList;
import Classes.*;
import DAO.*;
import java.util.HashSet;
import java.util.Set;
import module_reporting.*;
import module_reporting.*;

/**
 *
 * @author Vincent
 */
public class Couche_metier_recherche implements Couche_metier_recherche_interface {

   
    
//----ok---
// Opérations de recherche sur les malades----------------
    public ArrayList<Malade> rechercher_malade_selon_mutuelle_R1(String mutuelle) {

        MaladeDAO maladedao = new MaladeDAO();
        ArrayList<Malade> malades;
        ArrayList<Malade> malades2 = new ArrayList<Malade>();

        malades = maladedao.findAll();

        //On récupère les malades avec une certaine mutuelle
        for (int j = 0; j < malades.size(); j++) {
            if (malades.get(j).getMutuelle().equals(mutuelle)) {
                malades2.add(malades.get(j));
            }
        }
        return malades2;
    }


// ---ok----
    // Opérations de recherche sur les infirmiers----------------
    public ArrayList<Infirmier> rechercher_infirmier_selon_rotation_R2(String rotation) {

        InfirmierDAO infirmierdao = new InfirmierDAO();
        ArrayList<Infirmier> infirmiers;
        ArrayList<Infirmier> infirmiers2 = new ArrayList<Infirmier>();

        // On récupère les infirmiers pour on sélectionne ceux de la rotation correspondantes
        infirmiers = infirmierdao.findAll();

        //On supprimles infirmiers ne correspondants pas à la rotation
        for (int j = 0; j < infirmiers.size(); j++) {
            if (infirmiers.get(j).getRotation().equals(rotation)) {
                infirmiers2.add(infirmiers.get(j));
            }
        }
        return infirmiers2;
    }



  // Opérations sur docteur et service------
   //+++++++++ok++++++  
    public Resultat_recherche<Service, Docteur, Integer> rechercher_requete_R3() {
        Resultat_recherche<Service, Docteur, Integer> resultat = new Resultat_recherche<Service, Docteur, Integer>(true, true, false);
        //creer une template contenant deux array list en générale.
        ServiceDAO servicedao = new ServiceDAO();
        DocteurDAO docteurdao = new DocteurDAO();

        // On récupère tout les services
        ArrayList<Service> services = servicedao.findAll();

        //On récupère tout les docteurs chefs de service
        ArrayList<Docteur> docteurs = new ArrayList<Docteur>();
        //On récupère le docteur chef du service en question
        for (int j = 0; j < services.size(); j++) {

            docteurs.add(docteurdao.find(services.get(j).getDirecteur()));
        }
        resultat.setArrayList1(services);
        resultat.setArrayList2(docteurs);
        return resultat;
    }

  
//*******************************************************************
   //+++++++ok++++++++
    public Resultat_recherche<Hospitalisation,Service,Malade> rechercher_requete_R4(String batiment,String debut_mutuelle) {
      
       //Notre liste de résultat
        Resultat_recherche<Hospitalisation,Service,Malade> resultat= new Resultat_recherche<Hospitalisation,Service,Malade>(true,true,true);
        ArrayList<Hospitalisation> hospitalisations_resultat=new  ArrayList<Hospitalisation>();
        ArrayList<Service> services_resultat = new  ArrayList<Service>();
        ArrayList<Malade> malades_resultat= new  ArrayList<Malade> ();
        
        //On récupère toute les services par batiment
        ServiceDAO servicedao= new ServiceDAO();
        
        ArrayList<Service> services_batiment=servicedao.findByBatiment(batiment);
        
        //On regarde chaque hospiitalisation de chaque service 
        //du batiment a et on chope le numéro
        //du malade. On regarde pour le malade correspondant s'il est affilié
        //à une mutuelle dont le nom...
        
        HospitalisationDAO hospdao=new HospitalisationDAO();
        
        //pour tous les services
        for (int j = 0; j < services_batiment.size(); j++)
        { System.out.println( services_batiment.get(j).getCode());
        ArrayList<Hospitalisation> hospitalisation_du_service=hospdao.findByService(services_batiment.get(j).getCode());
        System.out.println(hospitalisation_du_service.size());
         
        for (int i = 0; i <  hospitalisation_du_service.size(); i++)
         {
         MaladeDAO maladedao= new MaladeDAO();
         Malade malade=maladedao.find( hospitalisation_du_service.get(i).getNo_malade());
         
         //On a plus qu'à regarder la mutuelle  si elle commence par les lettres souhaitées
         if(malade.getMutuelle().startsWith(debut_mutuelle))
         {
         //On ajoute nos résultats
             malades_resultat.add(malade);
             hospitalisations_resultat.add(hospitalisation_du_service.get(i));
             services_resultat.add(services_batiment.get(j));
         }
         
         }
        
        
        }
        
        resultat.setArrayList1(hospitalisations_resultat);
        resultat.setArrayList2(services_resultat);
        resultat.setArrayList3(malades_resultat);
        
        return resultat;     
    }
//**************************************************************

     public Resultat_recherche<String,Integer, Integer> rechercher_requete_R5()
     {
     //On appelle notre requete deja existante dans le module reporting
         Couche_metier_reporting couche=new Couche_metier_reporting();
         Donnees_pie_bar_chart donnees =couche.obtenir_donnees_bar_chart_x_service_y_salaire_moyen();
         
     Resultat_recherche<String,Integer, Integer> resultat= new Resultat_recherche<String,Integer, Integer>(true,true,false);
     resultat.setArrayList1(donnees.getAxesAbscisses());
     resultat.setArrayList2(donnees.getAxesOrdonnees());
     
     return resultat;
     
     
     }
   


//**********************************************************
    // Opérations services
    public Resultat_recherche<Service, Float, Integer> rechercher_requete_R6() {
       //+++++++ok++++++++
        
        Resultat_recherche<Service,Float, Integer> resultat = new Resultat_recherche<Service,Float, Integer>(true, true, false);
        ServiceDAO servicedao = new ServiceDAO();

        //on chope tous les services du batimentA
        ArrayList<Service> services = servicedao.findAll();
        ArrayList<Service> services_bat_A = new ArrayList<Service>();
        ArrayList<Float> nb_lits_moyen = new ArrayList<Float>();
        for (int j = 0; j < services.size(); j++) {
            // Si c'est le batiment A 
            if (services.get(j).getBatiment().equals("A")) {
                services_bat_A.add(services.get(j));
                nb_lits_moyen.add(moyenne_nblits_R6(services.get(j)));
            }

        }

        resultat.setArrayList1(services_bat_A);
        resultat.setArrayList2(nb_lits_moyen);

        return resultat;
          //on regarde pour chacun de ces services toutes les chambres
        // puis on fait la moyenne du nb de lits

    }
//***************************************************************************
   
   //*************************************************************************** 
    public Resultat_recherche<Malade, Integer, Integer> rechercher_requete_R7() {
       //++++++ok++++++
        
        // On regarde dans la table soigne si l'on voit trois fois le mm malade
        // Si oui,on compte le nombre de médecins soignés
        // ainsi que les nombres de spécialité.
        SoigneDAO soignedao = new SoigneDAO();
        MaladeDAO maladedao = new MaladeDAO();
        ArrayList<Soigne> tab_soigne = soignedao.findAll();

        //tableau de marquage pour éviter les doublons
        int[] marquages = new int[tab_soigne.size()];
        //on l'initialise à zero
        for (int j = 0; j < tab_soigne.size(); j++) {
            marquages[j] = 0;
        }

        //Notre conteneur de resultat
        Resultat_recherche<Malade, Integer, Integer> recherche = new Resultat_recherche<Malade, Integer, Integer>(true, true, true);
        //Nos listes 
        ArrayList<Malade> malades_resultat = new ArrayList<Malade>();
        ArrayList<Integer> nb_soignants = new ArrayList<Integer>();
        ArrayList<Integer> nb_specialites = new ArrayList<Integer>();
             //on regard

        //Pour tous les soigne(pour chaque malade)
        for (int j = 0; j < tab_soigne.size(); j++) 
        {
            int nb_medecin = nb_docteur_greater_than_3_R7(tab_soigne, j);

            if ((marquages[j] == 0) && (nb_medecin > 3))//on l'ajoute 
            {
                //On ajoute le malade correspondant au numero
                malades_resultat.add(maladedao.find(tab_soigne.get(j).get_Numero_malade()));
                //On remplit le nombre de médecin
                nb_soignants.add(nb_medecin);
                //On trouve le nombre de spécialitité
                nb_specialites.add(nb_specialite_R7(tab_soigne, j, marquages));

            }
        }

          for (int j = 0; j < tab_soigne.size(); j++) {
           System.out.print(marquages[j]);
        }
          System.out.print("\n");
        //On affecte nos résultats
        recherche.setArrayList1(malades_resultat);
        recherche.setArrayList2(nb_soignants);
        recherche.setArrayList3(nb_specialites);

        //On renvoie le resultat
        return recherche;
    }
//*************************************************************
  
  public Resultat_recherche<Service, Float, Integer> rechercher_requete_R8() { //++++++++++ok++++++++
    Resultat_recherche<Service,Float, Integer> resultat = new Resultat_recherche<Service,Float, Integer>(true, true, false);  
  
  ServiceDAO servicedao=new ServiceDAO();
  InfirmierDAO infirmierdao=new InfirmierDAO();
    
  HospitalisationDAO hospidao=new HospitalisationDAO();
  
  ArrayList<Service>services=servicedao.findAll();
  for(int j=0;j<services.size();j++)
      services.get(j).setInfirmier(infirmierdao.findByService(services.get(j).getCode()));
  
 // System.out.print(hospidao.findByService(services.get(1).getCode()).size()+services.get(1).getNom());
  
  //Listes contenants les résultat
  ArrayList<Float> rapports_i_sur_m=new ArrayList<Float>();


  
  if(!services.isEmpty())
  {
  for(int j=0;j<services.size();j++)
  {
      rapports_i_sur_m.add((float)((float)services.get(j).getInfirmiers().size()/(float)hospidao.findByService(services.get(j).getCode()).size()));//
  //System.out.print((double)(services.get(j).getInfirmiers().size()/hospidao.findByService(services.get(j).getCode()).size())+" ");
  } }
  
  //on met tout ca dans notre resultat
  resultat.setArrayList1(services);
  resultat.setArrayList2(rapports_i_sur_m);
  return resultat;
  }
    
  //********************************************************************************************
  //++++++++ok +++++++
  public Resultat_recherche<Docteur,Integer, Integer> rechercher_requete_R9()
   {
   
       Resultat_recherche<Docteur,Integer, Integer> resultat= new Resultat_recherche<Docteur,Integer, Integer>(true,false,false);
      
       ArrayList<Docteur> docteurs_resultat=new ArrayList<Docteur>();
       
       //Pour tous les patients de la table soigne, on regarde si celui ci subit une opération
       // Puis on renvoie son docteur
       SoigneDAO soignedao=new SoigneDAO();
       DocteurDAO docteurdao= new DocteurDAO();
       
       ArrayList<Docteur>docteurs=docteurdao.findAll();
       int numero_malade=0;
      
       for(int i=0;i<docteurs.size();i++)
       {
       ArrayList<Soigne>soignes=soignedao.findByDocteur(docteurs.get(i).getNumero());
       for(int h=0;h<soignes.size();h++)
       System.out.print(soignes.get(h).getNumero_docteur());
  
        //On regarde pour tous les soigne les numeros des malades
       // et on regarde si le numero du malade est dans une hospitalisation
       for(int j=0;j<soignes.size();j++)
       {
       numero_malade=soignes.get(j).get_Numero_malade();
       
       if(isHospitalized_R9_R10(numero_malade))
       {
       //on l'ajoute aux résultats
        docteurs_resultat.add(docteurs.get(i));
        break;
       }
       
       }
       
       }
       
       resultat.setArrayList1(docteurs_resultat);
       return resultat;
   }
   
    //****************************************************************************
    

  //*************************************************************************
  public Resultat_recherche<Docteur,Integer, Integer> rechercher_requete_R10()//+++++++ok+++++
  {
     Resultat_recherche<Docteur,Integer, Integer> resultat_contraire =rechercher_requete_R9();
       ArrayList<Docteur>docteurs_avec_hospitalises=resultat_contraire.getArrayList1();
      
        DocteurDAO docteurdao= new DocteurDAO();
       //On chope tout les docteurs
       ArrayList<Docteur>docteurs=docteurdao.findAll();
       boolean contient=true;
       
       //Résultats à renvoyer
       Resultat_recherche<Docteur,Integer, Integer> resultat= new   Resultat_recherche<Docteur,Integer, Integer>(true,false,false);
       ArrayList<Docteur>docteurs_resultat= new  ArrayList<Docteur>();
       
       //On fait la différence entre les docteurs qui ont au moins un medecin
       // de la liste de tout les docteurs, comme ca on obtient le résultat souhaité!
       
        for(int i=0;i<docteurs.size();i++)
        {
        
            for(int j=0;j<docteurs_avec_hospitalises.size();j++)
            {
              if(docteurs.get(i).getNumero()==docteurs_avec_hospitalises.get(j).getNumero())
              {
              contient=false;
              }
              
            }
            //On l'ajoute s'il n'a été trouvé nul part
              if(contient==true)
              docteurs_resultat.add(docteurs.get(i));
              
              contient=true;
        }
       
       resultat.setArrayList1(docteurs_resultat);
       return resultat;
  
  }
 //*********************************************************** 
   
  
  
  
  
  
  
    
    /*PRIVATE FUNCTIONS*/
   
  //********************************************************************
  private boolean isHospitalized_R9_R10(int numero_malade)
    {
        //Pour toutes les hospitalisations, on regarde si le malade est présent
        //si oui on retourne vrai sinon faux.
        HospitalisationDAO hospitalisationdao= new HospitalisationDAO();
     
        if(hospitalisationdao.find(numero_malade)!=null)
        {return true;}
        else
        {return false;}
    }
  //*****************************************************************      
        
    
       
 //************************************************************************      
    private int nb_specialite_R7(ArrayList<Soigne> tab_soigne, int indice, int[] marquages) {
        ArrayList<Docteur> docteurs = new ArrayList<Docteur>();
        DocteurDAO docteurdao = new DocteurDAO();

        for (int j = 0; j < tab_soigne.size(); j++) {
             //On recupere le docteur et sa spécialité et on la met dans une array list
            //ensuite on vire les doublons et on compte le nombre de spécialité
            if ((tab_soigne.get(j).get_Numero_malade() == tab_soigne.get(indice).get_Numero_malade())) {
                //on recupere le docteur correspondant
                docteurs.add(docteurdao.find(tab_soigne.get(j).getNumero_docteur()));
                System.out.print("ok!!");
                //on effectue notre marquage
                marquages[j] = 1;
            }

        }

         System.out.print("\n taille :"+docteurs.size());
        //Il ne nous reste plus qua compter le nombre de specilaites differentes
        ArrayList<String> specialitees_trouvees = new ArrayList<String>();
        //specialitees_trouvees.add("jj");
        // Pour tous les docteurs, regarder sa spécialité et la rajouter si elle n'est pas dans la liste
        for (int i = 0; i < docteurs.size(); i++) {
          specialitees_trouvees.add(docteurs.get(i).getSpecialite());
        }
        
        Set set= new HashSet();
        set.addAll(specialitees_trouvees);
        ArrayList distinctList=new ArrayList(set);
       
        //specialitees_trouvees. 
      
        return distinctList.size();

    }
//*************************************************************************
  
    //*********************************************************************
    private int nb_docteur_greater_than_3_R7(ArrayList<Soigne> tab_soigne, int indice) {
             //on regarde chaque valeur des malades dans toute la liste
        //on fait un compteur 
        int compteur = 0;

        for (int j = 0; j < tab_soigne.size(); j++) {
            //Si le numero de malade est le meme, on incremente le compteur
            if ((tab_soigne.get(j).get_Numero_malade() == tab_soigne.get(indice).get_Numero_malade())) {
                compteur++;
            }

        }

        //Si le malade apparait plus de trois fois, on retourne le nb
        if (compteur > 3) {
            return compteur;
        }

        return 0;
    }
//*************************************************************************
   
    
 //********************************************************************   
    private float moyenne_nblits_R6(Service service) {

         //choper toutes les chambres du service
        //choper le nombre de lits
        float moyenne = 0;
        ChambreDAO chambredao= new ChambreDAO();
       // ArrayList<Chambre> chambres_du_service = service.getChambres();
        ArrayList<Chambre> chambres_du_service=chambredao.findByService(service.getCode());
        
        
        for (int i = 0; i < chambres_du_service.size(); i++) {
            moyenne += chambres_du_service.get(i).getNb_lits();

        }

        return (float)(moyenne /= (float)chambres_du_service.size());

    }
//***************************************************************
}
