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
public class ServiceDAO extends DAO<Service>{
    /**
     * Permet de récupérer un objet via son ID
     * @param babla
     * @return 
     */

    
    public Service find(int babla)
        {return null;
        }
        
	public Service find(String code)
        {
            Service service=null;
            PreparedStatement stmt=null;
            ResultSet rset=null;
            ResultSetMetaData rsetMeta=null;
            
            
        try {
            // création d'un ordre SQL (statement)
         
            stmt=super_connexion.my_con.getConnection().prepareStatement("select * from service WHERE CODE LIKE '?'");
            stmt.setString(1,code);
            rset = stmt.executeQuery();
            
            if(rset.next())
            {
            String code_service=rset.getString(1);
            String nom=rset.getString(2);
            String batiment=rset.getString(3); //On peut mettre char aussi 
            int directeur=rset.getInt(4);
           
            service=new Service();
            service.setCode(code_service);
            service.setNom(nom);
            service.setBatiment(batiment);
            service.setDirecteur(directeur);
            }
            rsetMeta=rset.getMetaData();
     
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            return service;
        }
	
        
        public ArrayList<Service> findAll()
        {
        
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Service> services =new ArrayList<Service>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM service");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
            
        String code=rst.getString(1);
        String nom=rst.getString(2);
        String batiment=rst.getString(3);
        int num_directeur=rst.getInt(4);
       
       Service service=new Service();
       service.setCode(code);
       service.setNom(nom);
       service.setBatiment(batiment);
       service.setDirecteur(num_directeur);
       
       //On complète la liste d'infimier et la liste de chambre
      /*InfirmierDAO infirmierdao=new InfirmierDAO();
       ChambreDAO chambredao= new ChambreDAO();
       
       service.setChambres(chambredao.findByService(code));
       service.setInfirmier(infirmierdao.findByService(code));
       */
       
       services.add(service);
       
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return services;
        
        }
        
        public ArrayList<Service> findByBatiment(String batimentbis)
        {
        
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Service> services =new ArrayList<Service>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM service where batiment LIKE ?");
        stmt.setString(1,"%"+batimentbis+"%");
         rst=stmt.executeQuery();
        
        while(rst.next())
        {
            
        String code=rst.getString(1);
        String nom=rst.getString(2);
        String batiment=rst.getString(3);
        int num_directeur=rst.getInt(4);
       
       Service service=new Service();
       service.setCode(code);
       service.setNom(nom);
       service.setBatiment(batiment);
       service.setDirecteur(num_directeur);
       
       //On complète la liste d'infimier et la liste de chambre
      /*InfirmierDAO infirmierdao=new InfirmierDAO();
       ChambreDAO chambredao= new ChambreDAO();
       
       service.setChambres(chambredao.findByService(code));
       service.setInfirmier(infirmierdao.findByService(code));
       */
       
       services.add(service);
       
          
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return services;
        
        }
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 */
          @Override
	public void create(Service service)
        {
        PreparedStatement stmt=null;
        try {
       
            stmt=super_connexion.my_con.getConnection().prepareStatement("insert into service (CODE,NOM,BATIMENT,DIRECTEUR) values (?,?,?,?)");
            
            stmt.setString(1,service.getCode());
            stmt.setString(2,service.getNom());
            stmt.setString(3,service.getBatiment());
            stmt.setInt(4,service.getDirecteur());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        }
	
	/**
         * Permet de mettre à jour les données d'une entrée dans la base 
         * @param service 
         */
	public void update(Service service)
        {
        PreparedStatement stmt=null;
        
 
        try {
          stmt=super_connexion.my_con.getConnection().prepareStatement("update service set NOM = ?,BATIMENT = ?, DIRECTEUR = ? where CODE LIKE '?'");
            stmt.setString(1,service.getNom());
            stmt.setString(2,service.getBatiment());
            stmt.setInt(3,service.getDirecteur());
            stmt.setString(4,service.getCode());
             System.out.println("lppppp");
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
        
	
	/**
         * Permet la suppression d'une entrée de la base
         * @param service 
         */
	public void delete(Service service)//voir pour les regles
        {
        PreparedStatement stmt=null;
        
        
        try {
             stmt=super_connexion.my_con.getConnection().prepareStatement("delete from service WHERE CODE LIKE '?'");
            stmt.setString(1,service.getCode());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
            
        
        }
        
        }

