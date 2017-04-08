/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import module_reporting.*;
import module_connexion.*;
import module_mise_a_jour.*;
import DAO.*;
import module_mise_a_jour.*;
import Classes.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_recherche_information.*;


/**
 *
 * @author Vincent
 */
public class ProjetBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //**************Connection****************
        try {
            super_connexion.my_con=new Connexion("colindev",",,VIvignivin2","colindev-rw","ffUcaWXW",true);// mettre le login de l ece, le mot de passe , l(identifiant de la bdd , son mdp et true/false pour avoir connexion locale
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
      
        
        
        
        
        
      // Couche_metier_recherche recherche=new Couche_metier_recherche();
       
       /*R9*/
       /*Resultat_recherche<Docteur,Integer, Integer> resultat=recherche.rechercher_requete_R10();
       
      
       for(int j=0;j<resultat.getArrayList1().size();j++)
       {
        System.out.println(resultat.getArrayList1().get(j).getNom());
       }
      */
       
       /*R8*/
     /* Resultat_recherche<Service,Float,Integer> mon_resultat;
      
       mon_resultat=recherche.rechercher_requete_R8();
       
       for(int j=0;j<mon_resultat.getArrayList1().size();j++)
       {
       System.out.print(mon_resultat.getArrayList1().get(j).getNom()+" ");
       System.out.println(mon_resultat.getArrayList2().get(j).floatValue());
       }
    */
      
      /* R7*/
     /*  Resultat_recherche<Malade,Integer,Integer> mon_resultat=recherche.rechercher_requete_R7();
      for(int j=0;j<mon_resultat.getArrayList1().size();j++)
      {
      
      System.out.print(mon_resultat.getArrayList1().get(j).getNom()+" ");
      System.out.print(mon_resultat.getArrayList1().get(j).getPrenom()+" ");
      System.out.print(mon_resultat.getArrayList2().get(j).intValue());
      System.out.print(" ");
      System.out.print(mon_resultat.getArrayList3().get(j).intValue());
       System.out.println("");
      
      }*/
       
      /*R6*/
      /* Resultat_recherche<Service, Float, Integer> resultat= recherche.rechercher_requete_R6();
      for(int j=0;j<resultat.getArrayList1().size();j++)
      {
      
      System.out.print(resultat.getArrayList1().get(j).getCode());
      System.out.println(resultat.getArrayList2().get(j).floatValue());
      
      
      }*/
       /*R5*/
     /*  Resultat_recherche<String,Integer, Integer> resultat=recherche.rechercher_requete_R5();
        for(int j=0;j<resultat.getArrayList1().size();j++)
      {
      
      System.out.print(resultat.getArrayList1().get(j));
      System.out.println(resultat.getArrayList2().get(j));
      
      
      }*/
       /*R4*/
      /* Resultat_recherche<Hospitalisation,Service,Malade> resultat=recherche.rechercher_requete_R4("B","MN");
        for(int j=0;j<resultat.getArrayList1().size();j++)
      {
       System.out.print(resultat.getArrayList1().get(j).getNo_chambre());
        System.out.print(" ");
      System.out.print(resultat.getArrayList1().get(j).getLit());
       System.out.print(" ");
      System.out.print(resultat.getArrayList2().get(j).getNom());
       System.out.print(" ");
       System.out.println(resultat.getArrayList3().get(j).getNom());
      
      }*/
      /*R3*/ 
     /*  Resultat_recherche<Service, Docteur, Integer> resultat=recherche.rechercher_requete_R3();
          for(int j=0;j<resultat.getArrayList1().size();j++)
      {
       System.out.print(resultat.getArrayList1().get(j).getNom());
        System.out.print(" ");
      System.out.print(resultat.getArrayList1().get(j).getBatiment());
       System.out.print(" ");
      System.out.print(resultat.getArrayList2().get(j).getNom());
       System.out.print(" ");
       System.out.println(resultat.getArrayList2().get(j).getSpecialite());
      
      }*/
      /*ArrayList<Infirmier> inf =recherche.rechercher_infirmier_selon_rotation("NUIT");
     
     for(int j=0;j<inf.size();j++)
        {
      inf.get(j).afficher();
        }*/
      
     /*ArrayList<Malade> mal=recherche.rechercher_malade_selon_mutuelle("LMDE");
      for(int j=0;j<mal.size();j++)
        {
      mal.get(j).afficher();
        }*/
       
        
      
        
       Couche_metier_reporting reporting=new Couche_metier_reporting();
      Donnees_pie_bar_chart resultat= reporting.obtenir_donnees_bar_chart_x_docteur_y_nb_actes_medicaux();
      
      /* for(int j=0;j<resultat.getAxesAbscisses().size();j++)
       {
       
      System.out.print( resultat.getAxesAbscisses().get(j)+" ");
         System.out.println(  resultat.getAxesOrdonnees().get(j));
           
           
       }*/
      
     Donnees_pie_bar_chart resultat2= reporting.obtenir_pie_chart_x_code_service_y_nblits_occupes();
     /* for(int j=0;j<resultat2.getAxesAbscisses().size();j++)
       {
       
      System.out.print( resultat2.getAxesAbscisses().get(j)+" ");
         System.out.println(  resultat2.getAxesOrdonnees().get(j));
           
           
       }*/
      
      Donnees_pie_bar_chart resultat3=reporting.obtenir_pie_chart_x_specialite_y_nb_docteurs();
      for(int j=0;j<resultat3.getAxesAbscisses().size();j++)
       {
       
      System.out.print( resultat3.getAxesAbscisses().get(j)+" ");
         System.out.println(resultat3.getAxesOrdonnees().get(j));
           
           
       }
        
     
       /* 
        Couche_metier_maj maj=new Couche_metier_maj();
      //on verifie si ca supprime en tant réel 
       MaladeDAO maladedao=new MaladeDAO();
       //boolean b= maj.insererInfirmier(new Infirmier("colin","vincent","0125636688","8 avenue de la grande fourchette ",99,"Jour",1860,"CAR"));
      // System.out.print(b);
       //maladedao.delete(maladedao.find(2));
     Docteur docteur=new Docteur("JULIEN9","SUPPRIMER","0125555555","12 avenue de la grande fourchette ",300,"Cardiologue");
      Infirmier inf=new Infirmier("Myriam","Romanesco2","0125636688","8 avenue de la grande fourchette ",91,"Jour",1860,"CAR");
       Malade malade=new Malade("robin","tutecalme","0125252314","12 bachi","LMDE",7);
      // Malade malade2=new Malade("asupp","Aceschats","0125252314","12 bachi","LMDE",100);
    maj.insererDocteur(docteur);
     maj.insererInfirmier(inf);
     maj.insererMalade(malade);
    //  maj.insererInfirmier(inf);*/
      
    /* maj.updateDocteur(docteur);
     maj.updateInfirmier(inf);
     maj.updateMalade(malade);
     
     maj.deleteDocteur(docteur);
     maj.deleteInfirmier(inf);
     maj.deleteMalade(malade);*/
      
     // maj.insererMalade(malade2);    

//  MAIN INFIRMIER
     /*   
     System.out.print("Test du début");
     InfirmierDAO infirmierdao=new InfirmierDAO();
     //infirmierdao.create(new Infirmier("colin","vincent","0125636688","8 avenue de la grande fourchette ",99,"Jour",1860,"CAR"));
    infirmierdao.update(new Infirmier("colin","vincent","0125636688","8 avenue de la grande fourchette ",99,"Jour",2000,"CAR"));
     ArrayList<Infirmier> infirmiers=infirmierdao.findAll();
     
     for(Infirmier inf:infirmiers)
     {
     System.out.println(inf.toString());
     }*/
     
     
        // MAIN MALADE
        /*System.out.print(maladeDAO.find(6).toString());
        System.out.print(maladeDAO.find(3).toString());
        Malade malade=new Malade("Absalon","lome","0145568899","12 rue tournesol","LMDE",2);
        System.out.print(malade.toString());
        maladeDAO.create(malade);
       // maladeDAO.update(malade);
       // maladeDAO.delete(malade);
       // maladeDAO.create(malade); */  
        
        
       
      //************************Déconnection******************************
        try {
            super_connexion.my_con.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
