/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.*;
import Controleur.ProjetBDD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.Connexion;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class DocteurDAO {
    
   
    public Docteur find(int numero)
        {
            Docteur docteur=null;
            PreparedStatement stmt=null;
            ResultSet rset=null;
            ResultSetMetaData rsetMeta=null;
            EmployeDAO employedao=new EmployeDAO();
            
            
        try {
            // création d'un ordre SQL (statement)
            
            stmt=super_connexion.my_con.getConnection().prepareStatement("select numero,specialite from docteur WHERE NUMERO =?");
            stmt.setInt(1,numero);
            rset=stmt.executeQuery();
            
            if(rset.next())
            {
            int num=rset.getInt(1);
            String specialite=rset.getString(2);
           
         
            docteur=new Docteur();
            docteur.setNumero(num);
            docteur.setSpecialite(specialite);
             
            //On complete ses infos d'employé
            Employe employe=employedao.find(numero);
            docteur.setNom(employe.getNom());
            docteur.setPrenom(employe.getPrenom());
            docteur.setAdresse(employe.getAdresse());
            docteur.setTel(employe.getTel());
            }
        
                     
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return docteur;
        
        }
 


//******************************************************************************   
     public ArrayList<Docteur> findAll()//on rajoute cette méthode car 1..*
        {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Docteur> docteurs=new ArrayList<Docteur>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM docteur");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
        int numero= rst.getInt(1);
     String specialite=rst.getString(2);
    
       Docteur docteur=new Docteur();
       
       docteur.setNumero(numero);
       docteur.setSpecialite(specialite);
      
       
       EmployeDAO employedao = new EmployeDAO();
       Employe employebis = employedao.find(numero);
       
       docteur.setAdresse(employebis.getAdresse());
       docteur.setNom(employebis.getNom());
       docteur.setPrenom(employebis.getPrenom());
       docteur.setTel(employebis.getTel());
     
       docteurs.add(docteur);
            
        }       
        
        }
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return docteurs;
        
        }
	//*************************************************************
     
      public ArrayList<Docteur> findBySpecialite(String specialitebis)//on rajoute cette méthode car 1..*
        {
        PreparedStatement stmt=null;
        ResultSet rst=null;
        ArrayList<Docteur> docteurs=new ArrayList<Docteur>();
        
        try{

         stmt=super_connexion.my_con.getConnection().prepareStatement("SELECT * FROM docteur");
        rst=stmt.executeQuery();
        
        while(rst.next())
        {
        int numero= rst.getInt(1);
     String specialite=rst.getString(2);
    
         if(specialitebis.equals(specialite))
         {
       Docteur docteur=new Docteur();
       
       docteur.setNumero(numero);
       docteur.setSpecialite(specialite);
      
       
       EmployeDAO employedao = new EmployeDAO();
       Employe employebis = employedao.find(numero);
       
       docteur.setAdresse(employebis.getAdresse());
       docteur.setNom(employebis.getNom());
       docteur.setPrenom(employebis.getPrenom());
       docteur.setTel(employebis.getTel());
     
       docteurs.add(docteur);
            
        }       
        
        }}
        catch(Exception e)
        {
        throw new RuntimeException(e);
        }
   
        return docteurs;
        
        }
      
      
     
	/**
         * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
         * @param docteur 
         */
	public void create(Docteur docteur)
        {
        PreparedStatement stmt=null;
        try {
            
            stmt=super_connexion.my_con.getConnection().prepareStatement("insert into docteur (NUMERO,SPECIALITE) values (?,?)");//
           stmt.setInt(1,docteur.getNumero());
            stmt.setString(2,docteur.getSpecialite());
             
            //super_connexion.my_con.getConnection().setAutoCommit(false);
            //super_connexion.my_con.getConnection().commit();
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
	
	/**
         *Permet de mettre à jour les données d'une entrée dans la base  
         * @param docteur 
         */
	public void update(Docteur docteur)
        {
        PreparedStatement stmt=null;
        
        try {
            //On suppose que le malade garde toujours le mm nom prénom et tel
            stmt=super_connexion.my_con.getConnection().prepareStatement("update docteur set SPECIALITE = ? where NUMERO = ?");
            stmt.setString(1,docteur.getSpecialite());
            stmt.setInt(2,docteur.getNumero());
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
	
	/**
         * Permet la suppression d'une entrée de la base
         * @param docteur 
         */
	public void delete(Docteur docteur)
        {
       
        PreparedStatement stmt=null;
        
        try {
  
            stmt=super_connexion.my_con.getConnection().prepareStatement("delete from docteur WHERE NUMERO = ?");
            stmt.setInt(1,docteur.getNumero());
           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    
    
    
}
