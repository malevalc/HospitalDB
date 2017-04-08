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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class ChambreDAO extends DAO<Chambre>{
    
       
    
    
    /**
     ** Permet de créer une entrée dans la base de données
     ** par rapport à un objet
     * @param chambre 
     */
	public void create(Chambre chambre)
        {
        PreparedStatement stmt=null;
        try {
    
         stmt=super_connexion.my_con.getConnection().prepareStatement("insert into chambre (NO_CHAMBRE,CODE_SERVICE,SURVEILLANT,NB_LITS) values (?,?,?,?)");
            stmt.setInt(1,chambre.getNo_chambre());
            stmt.setString(2,chambre.getCode_service());
            stmt.setInt(3,chambre.getNoSurveillant());
            stmt.setInt(4,chambre.getNb_lits());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    
    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return 
     */
  public Chambre find(int id)//juset pour overider
  {return new Chambre();}
    
     
	public Chambre find(int numero,String code_service)
        { 
            Chambre chambre=null;
            PreparedStatement stmt=null;
            ResultSet rset=null;
            ResultSetMetaData rsetMeta=null;
            
        try {
            // création d'un ordre SQL (statement)
           stmt=super_connexion.my_con.getConnection().prepareStatement("select * from chambre WHERE NO_CHAMBRE = '?' AND CODE_SERVICE LIKE '?'");
            stmt.setInt(1,numero);
            stmt.setString(2,code_service);
            rset=stmt.executeQuery();
            
            if(rset.next())
            {
            
            int no_chambre= rset.getInt(1);
        String c_service=rset.getString(2);
        int surveillant=rset.getInt(3);
        int nb_lits=rset.getInt(4);
        
        chambre=new Chambre();
        chambre.setNo_chambre(no_chambre);
        chambre.setCode_service(c_service);
        chambre.setNoSurveillant(surveillant);
        chambre.setNb_lits(nb_lits);
            }
         //   rsetMeta=rset.getMetaData();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
            return chambre;

            
        }
	
        
        /**
         * 
         * @param code_service la valeur de retour
         * @return 
         */
        
        public ArrayList<Chambre> findByService(String code_service)//on rajoute cette méthode car 1..*
         {

        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Chambre> chambres_du_service =new ArrayList<Chambre>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT code_service,no_chambre,surveillant,nb_lits FROM chambre WHERE code_service LIKE ?");
        stmt.setString(1,code_service);
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
        
        String c_service=rst.getString(1);
        int no_chambre= rst.getInt(2);
        int surveillant=rst.getInt(3);
        int nb_lits=rst.getInt(4);
        
        Chambre chambre=new Chambre();
        chambre.setNo_chambre(no_chambre);
        chambre.setCode_service(c_service);
        chambre.setNoSurveillant(surveillant);
        chambre.setNb_lits(nb_lits);
        
       
        chambres_du_service.add(chambre);
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
       
   
        return chambres_du_service;
         }
        
        //888888888888888888888888888888888888888888888888888
        public ArrayList<Chambre> findBySurveillant(int numero_surveillant)//on rajoute cette méthode car 1..*
         {

        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Chambre> chambres_du_service =new ArrayList<Chambre>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT code_service,no_chambre,surveillant,nb_lits FROM chambre WHERE surveillant = ?");
        stmt.setInt(1,numero_surveillant);
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
        
        String c_service=rst.getString(1);
        int no_chambre= rst.getInt(2);
        int surveillant=rst.getInt(3);
        int nb_lits=rst.getInt(4);
        
        Chambre chambre=new Chambre();
        chambre.setNo_chambre(no_chambre);
        chambre.setCode_service(c_service);
        chambre.setNoSurveillant(surveillant);
        chambre.setNb_lits(nb_lits);
        
       
        chambres_du_service.add(chambre);
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
       
   
        return chambres_du_service;
         }
       //8888888888888888888888888888888888888888888888888888
        
        
                 
           public ArrayList<Chambre> findAll()
           {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Chambre> chambres =new ArrayList<Chambre>();
        
        try{
    
        stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT code_service,no_chambre,surveillant,nb_lits FROM chambre");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
        String code_service=rst.getString(1);
        int no_chambre= rst.getInt(2);
        int surveillant=rst.getInt(3);
         int nb_lits=rst.getInt(4);
        
        Chambre chambre=new Chambre();
        chambre.setNo_chambre(no_chambre);
        chambre.setCode_service(code_service);
        chambre.setNoSurveillant(surveillant);
        chambre.setNb_lits(nb_lits);
        
       
        chambres.add(chambre);
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return chambres;
           
           }
	
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 */
        @Override
	public void update(Chambre chambre)
        {

        PreparedStatement stmt=null;
        try {
             stmt=super_connexion.my_con.getConnection().prepareStatement("update chambre set SURVEILLANT = ?, NB_LITS = ? where NO_CHAMBRE = ? AND CODE_SERVICE = ?");
            stmt.setInt(1,chambre.getNoSurveillant());
            stmt.setInt(2,chambre.getNb_lits());
            stmt.setInt(3,chambre.getNo_chambre());
            stmt.setString(4,chambre.getCode_service());
       
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        }
	
	/**
         * Permet la suppression d'une entrée de la base
         * @param chambre 
         */
	public void delete(Chambre chambre)
        {
        PreparedStatement stmt=null;
        
        
        try {
            stmt=super_connexion.my_con.getConnection().prepareStatement("delete from Chambre WHERE NO_CHAMBRE = ? AND CODE_SERVICE = ?");
            stmt.setInt(1,chambre.getNo_chambre());
            stmt.setString(2,chambre.getCode_service());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
            
        }
    
}
