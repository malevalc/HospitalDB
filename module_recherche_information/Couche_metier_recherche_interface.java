/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_recherche_information;
import Classes.*;
import DAO.InfirmierDAO;
import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public interface Couche_metier_recherche_interface {
    
       ArrayList<Infirmier> rechercher_infirmier_selon_rotation_R2(String rotation);
   
   
       // Opérations de recherche sur les malades----------------
           ArrayList<Malade> rechercher_malade_selon_mutuelle_R1(String mutuelle);
           
}
