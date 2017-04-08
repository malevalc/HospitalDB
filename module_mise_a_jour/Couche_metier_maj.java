/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_mise_a_jour;

import Classes.*;
import DAO.*;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 *
 * C'est ici que l'on va définir nos règles. Et nous allons faire
 * particulièrement attention aux règles d'intégrité référentielle.
 *
 * Il faudra blinder le numéro de tel car taille maximum...
 */
public class Couche_metier_maj implements Couche_metier_maj_interface {

    //--------------INSERTION-----------------   
    public boolean insererMalade(Malade malade) {//++++++++ok++++++++
        MaladeDAO maladedao = new MaladeDAO();

        //Si le malade n'existe pas déjà, on l'insère.
        if (maladedao.find(malade.getNumero()) == null) {
            maladedao.create(malade);
            
            return true;
        }
        return false;
        
    }
    
    public boolean insererDocteur(Docteur docteur) {//++++++++ok++++++++  à finir
        DocteurDAO docteurdao = new DocteurDAO();
        EmployeDAO employedao = new EmployeDAO();

        //Si le docteur n'existe pas déjà, on l'insère
        if (employedao.find(docteur.getNumero()) == null) {
            
            
            //on l'insere dans la table employe également
            employedao.create(docteur);
            
            docteurdao.create(docteur);


            //Il faudra aussi introduire les gens qu'il soigne dans la table soigne et le service qu'il dirige
            return true;
        }
        return false;
        
    }
    
    public boolean insererInfirmier(Infirmier infirmier) {//------ok---------   --> attention, on ne voit pas les modifs dans le local
        InfirmierDAO infirmierdao = new InfirmierDAO();
        EmployeDAO employedao = new EmployeDAO();
        //Si l'infirmier n'existe pas deja, on l'insere.
        if (employedao.find(infirmier.getNumero()) == null) {
            
             //on l'insere dans la table employe également
            employedao.create(infirmier);
            
            infirmierdao.create(infirmier);

           
            return true;
        }
        return false;
        
    }

//-------------------MISE A JOUR----------------  
    
    // On considère qu'on ne change pas les noms et prénoms
    @Override
    public boolean updateMalade(Malade malade) {//+++++++ok++++
        MaladeDAO maladedao = new MaladeDAO();
        //Si le malade existe, on peut alors le mettre à jour.
        if (maladedao.find(malade.getNumero()) != null) {
            maladedao.update(malade);
            return true;
        }
        return false;
        
    }
    
    public boolean updateDocteur(Docteur docteur) {//+++++++ok++++++
        DocteurDAO docteurdao = new DocteurDAO();
         EmployeDAO employedao = new EmployeDAO();
        //Si le docteur existe, on peut alors le mettre à jour.
        if (docteurdao.find(docteur.getNumero()) != null) {
            employedao.update(docteur);
            docteurdao.update(docteur);
            return true;
        }
        return false;
        
    }
    
    public boolean updateInfirmier(Infirmier infirmier) {//+++++++ok++++++
        InfirmierDAO infirmierdao = new InfirmierDAO();
        EmployeDAO employedao = new EmployeDAO();
        //Si l'infirmier existe, on peut alors le mettre à jour.
        if (infirmierdao.find(infirmier.getNumero()) != null) {
            employedao.update(infirmier);
            infirmierdao.update(infirmier);
            return true;
        }
        return false;
    }

    //--------------------SUPRESSION-------------------- 
    public boolean deleteMalade(Malade malade) {//+++++++++++ok+++++++   --> a tester avec hospitalisation et soigne
        
        MaladeDAO maladedao = new MaladeDAO();
        HospitalisationDAO hospitalisationdao = new HospitalisationDAO();
        SoigneDAO soignedao = new SoigneDAO();

        //On vérifie si il existe 
        if (maladedao.find(malade.getNumero()) != null) {
           
            // on doit le supprimer de hospitalisation si il est hospitalisé
            if(hospitalisationdao.find(malade.getNumero())!=null)
            hospitalisationdao.delete(hospitalisationdao.find(malade.getNumero()));

            //On doit supprimer aussi le supprimer dans la table soigne correspondante si il est soigné
            ArrayList<Soigne> soignes = soignedao.findByMalade(malade.getNumero());
            if(soignes!=null)
            {
             for (int j = 0; j < soignes.size(); j++) {
                soignedao.delete(soignes.get(j));
            }
            }
           

            // On le supprime enfin de la table malade
            maladedao.delete(malade);
            return true;
        }
        
        return false;
        
    }
    
    public boolean deleteDocteur(Docteur docteur) { //+++++ok++++  --> mais tester avec les patients
        DocteurDAO docteurdao = new DocteurDAO();
        SoigneDAO soignedao = new SoigneDAO();
        EmployeDAO employedao = new EmployeDAO();

        //On vérifie si il existe 
        if (docteurdao.find(docteur.getNumero()) != null) {

            //On doit supprimer aussi les éléments de soigne correspondant où le docteur intervient
            ArrayList<Soigne> soignes = soignedao.findByDocteur(docteur.getNumero());
            for (int j = 0; j < soignes.size(); j++) {
                soignedao.delete(soignes.get(j));
            }
     // Si il est directeur, il faut supprimer le directeur du service dans service

            //On le supprime de la table employé
            employedao.delete(docteur);
            // On supprime le docteur dans la table docteur
            docteurdao.delete(docteur);
            return true;
        }
        return false;
    }
    
    public boolean deleteInfirmier(Infirmier infirmier)  //++++++ok+++++ mais voir pour la surveillance
//voir si l'infirmier surveille une chambre ou pas.
    {
        InfirmierDAO infirmierdao = new InfirmierDAO();
        EmployeDAO employedao = new EmployeDAO();
        //On vérifie si il existe 
        if (infirmierdao.find(infirmier.getNumero()) != null) {

            //On doit le supprimer du service
            //On le supprime de la table employé
            employedao.delete(infirmier);
            //On le supprime enfin de la table infirmier (et supprimer de surveillant si nécessaire
            infirmierdao.delete(infirmier);
            
            return true;
        }
        
        return false;
        
    }
    
}
