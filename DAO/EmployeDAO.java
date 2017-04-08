/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class EmployeDAO extends DAO<Employe> {
    
    public Employe find(int numero)
        {
            Employe employe=null;
            PreparedStatement stmt=null;
            ResultSet rset=null;
            ResultSetMetaData rsetMeta=null;
            
            
        try {
            // création d'un ordre SQL (statement)
            
            stmt=super_connexion.my_con.getConnection().prepareStatement("select * from employe WHERE NUMERO =?");
            stmt.setInt(1,numero);
            rset=stmt.executeQuery();
            
            if(rset.next())
            {
            int num=rset.getInt(1);
            String nom=rset.getString(2);
            String prenom=rset.getString(3);
            String adresse=rset.getString(4);
            String tel=rset.getString(5);
            
            
           employe=new Employe();
           employe.setNumero(num);
           employe.setNom(nom);
           employe.setPrenom(prenom);
           employe.setAdresse(adresse);
           employe.setTel(tel);
             
            }
        
                     
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return employe;
        
        }
	
	/**
         * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
         * @param employe 
         */
	public void create(Employe employe)
        {
        PreparedStatement stmt=null;
        try {
            
            stmt=super_connexion.my_con.getConnection().prepareStatement("insert into employe (numero,nom,prenom,adresse,tel) values (?,?,?,?,?)");
            
            
            stmt.setInt(1,employe.getNumero());
            stmt.setString(2,employe.getNom());
            stmt.setString(3,employe.getPrenom());
            stmt.setString(4,employe.getAdresse());
            stmt.setString(5,employe.getTel());
            //stmt.set
          
           // super_connexion.my_con.getConnection().setAutoCommit(false);
            //super_connexion.my_con.getConnection().commit();
       stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
	
	/**
         * Permet de mettre à jour les données d'une entrée dans la base 
         * @param employe 
         */
	public void update(Employe employe)
        {
        PreparedStatement stmt=null;
        
        try {
            //On suppose que l'employe garde toujours le mm nom prénom 
            stmt=super_connexion.my_con.getConnection().prepareStatement("update employe set nom = ?,prenom = ?, adresse = ?, tel = ? where numero = ?");
            
            stmt.setString(1,employe.getNom());
            stmt.setString(2,employe.getPrenom());
            stmt.setString(3,employe.getAdresse());
            stmt.setString(4,employe.getTel());
            stmt.setInt(5,employe.getNumero());
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
	
	/**
         * Permet la suppression d'une entrée de la base
         * @param employe 
         */
	public void delete(Employe employe)
        {
       
        PreparedStatement stmt=null;
        
        try {
  
            stmt=super_connexion.my_con.getConnection().prepareStatement("delete from employe WHERE NUMERO = ?");
            stmt.setInt(1,employe.getNumero());
           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    
    
}
