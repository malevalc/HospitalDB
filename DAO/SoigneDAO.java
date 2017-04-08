/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class SoigneDAO extends DAO<Soigne>{
    
   public Soigne find(int num)
   {return null;}
    
    public Soigne find(int no_docteur,int no_malade)
        {
       
            Soigne soigne=null;
            PreparedStatement stmt=null;
            ResultSet rset=null;
            ResultSetMetaData rsetMeta=null;
            
            
        try {
            // création d'un ordre SQL (statement)
            stmt=super_connexion.my_con.getConnection().prepareStatement("select * from soigne WHERE no_malade = ? and no_docteur= ?");
            stmt.setInt(1,no_malade);
            stmt.setInt(2,no_docteur);
            rset=stmt.executeQuery();
            
            if(rset.next())
            {
            
        int num_docteur= rset.getInt(1);
        int num_malade=rset.getInt(2);
       
         soigne=new Soigne();
         soigne.setNumero_docteur(num_docteur);
         soigne.setNumero_malade(num_malade);
        
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

            return soigne;
        
        }
    
    public ArrayList<Soigne> findAll()//on rajoute cette méthode car 1..*
        {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Soigne> tableau_soigne =new ArrayList<Soigne>();
        Soigne soigne;
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("select * from soigne");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
            
        int num_docteur= rst.getInt(1);
        int num_malade=rst.getInt(2);
       
         soigne=new Soigne();
         soigne.setNumero_docteur(num_docteur);
         soigne.setNumero_malade(num_malade);
   
         tableau_soigne.add(soigne);
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return tableau_soigne;
        
        }
    
   public ArrayList<Soigne> findByMalade(int num_maladebis)//on rajoute cette méthode car 1..*
        {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Soigne> tableau_soigne =new ArrayList<Soigne>();
        Soigne soigne;
        int num_malade;
        int num_docteur;
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("select * from soigne");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
            
        num_docteur= rst.getInt(1);
        num_malade=rst.getInt(2);
       
        if(num_maladebis==num_malade)
        {
         soigne=new Soigne();
         soigne.setNumero_docteur(num_docteur);
         soigne.setNumero_malade(num_malade);
   
         tableau_soigne.add(soigne);
        }
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return tableau_soigne;
        
        }
    
      public ArrayList<Soigne> findByDocteur(int num_docteurbis)//on rajoute cette méthode car 1..*
        {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Soigne> tableau_soigne =new ArrayList<Soigne>();
        Soigne soigne;
        try{
      // System.out.print("coucou");
         stmt=super_connexion.my_con.getConnection().prepareStatement("select no_docteur,no_malade from soigne");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
            
        int num_docteur= rst.getInt(1);
        int num_malade=rst.getInt(2);
       
        if(num_docteurbis==num_docteur)
        {
         soigne=new Soigne();
         soigne.setNumero_docteur(num_docteur);
         soigne.setNumero_malade(num_malade);
   
         tableau_soigne.add(soigne);
        }
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return tableau_soigne;
        
        }
    public void create(Soigne soigne)
        {
        PreparedStatement stmt=null;
        try {
             stmt=super_connexion.my_con.getConnection().prepareStatement("insert into soigne (no_docteur,no_malade) values (?,?)");
            
            stmt.setInt(1,soigne.getNumero_docteur());
            stmt.setInt(2,soigne.get_Numero_malade());
     
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
    
    public void update(Soigne soigne)
        {
     //Ici, Ca n'a pas de sens de mettre à jour.  
        }
    
    public void delete(Soigne soigne)
        {
        
        PreparedStatement stmt=null;
        
        
        try {
             stmt=super_connexion.my_con.getConnection().prepareStatement("delete from soigne WHERE no_malade = ? AND no_docteur = ?");
            stmt.setInt(1,soigne.get_Numero_malade());
            stmt.setInt(2,soigne.getNumero_docteur());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        } 
    
}
