/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_mise_a_jour;

import Classes.*;

/**
 *
 * @author Vincent
 */
public interface Couche_metier_maj_interface {
    
   boolean insererMalade(Malade malade);  
   public boolean insererDocteur(Docteur docteur);
   boolean insererInfirmier(Infirmier infirmier);
   
   boolean updateMalade(Malade malade);
   boolean updateDocteur(Docteur docteur);
   boolean updateInfirmier(Infirmier infirmier);
   
   boolean deleteMalade(Malade malade);
   boolean deleteDocteur(Docteur docteur);
   boolean deleteInfirmier(Infirmier infirmier);
   
    
}
