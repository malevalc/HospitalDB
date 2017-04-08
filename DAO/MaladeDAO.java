/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.*;
import Controleur.ProjetBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.*;

/**
 *
 * @author Vincent
 */
public class MaladeDAO extends DAO<Malade> {

    /**
     * Permet de récupérer un objet via son ID
     *
     * @param numero
     * @return
     */

    public Malade find(int numero)//ok++++++++++++++++
    {
        Malade malade = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)

            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from malade WHERE NUMERO =?");
            stmt.setInt(1, numero);
            rset = stmt.executeQuery();

            if (rset.next()) {
                int num = rset.getInt(1);
                String nom = rset.getString(2);
                String prenom = rset.getString(3);
                String adresse = rset.getString(4);
                String tel = rset.getString(5);
                String mutuelle = rset.getString(6);

                malade = new Malade();

                malade.setNumero(num);
                malade.setNom(nom);
                malade.setPrenom(prenom);
                malade.setTel(tel);
                malade.setAdresse(adresse);
                malade.setMutuelle(mutuelle);

            //On trouve aussi ses docteurs
            }
            rsetMeta = rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return malade;

    }

    public ArrayList<Malade> findAll()//on rajoute cette méthode car 1..*
    {
        PreparedStatement stmt = null;
        ResultSet rst = null;
        ArrayList<Malade> malades = new ArrayList<Malade>();

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT numero,nom,prenom,adresse,tel,mutuelle FROM malade");
            rst = stmt.executeQuery();

            while (rst.next()) {
                int numero = rst.getInt(1);
                String nom = rst.getString(2);
                String prenom = rst.getString(3);
                String adresse = rst.getString(4);
                String tel = rst.getString(5);
                String mutuelle = rst.getString(6);

                Malade malade = new Malade();

                malade.setNumero(numero);
                malade.setNom(nom);
                malade.setPrenom(prenom);
                malade.setAdresse(adresse);
                malade.setTel(tel);
                malade.setMutuelle(mutuelle);

                malades.add(malade);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return malades;

    }

    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     * @param malade 
     */
    @Override
    public void create(Malade malade)//++++++ok
    {
        PreparedStatement stmt = null;
        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("insert into malade (NUMERO,NOM,PRENOM,ADRESSE,TEL,MUTUELLE) values (?,?,?,?,?,?)");
            stmt.setInt(1, malade.getNumero());
            stmt.setString(2, malade.getNom());
            stmt.setString(3, malade.getPrenom());
            stmt.setString(4, malade.getAdresse());
            System.out.println(malade.getTel());
            stmt.setString(5, malade.getTel());
            stmt.setString(6, malade.getMutuelle());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param malade 
     */
    public void update(Malade malade)//+++++++++ok
    {
        PreparedStatement stmt = null;

        try {
            //On suppose que le malade garde toujours le mm nom prénom et tel
            stmt = super_connexion.my_con.getConnection().prepareStatement("update malade set nom = ?,prenom = ?,adresse = ?,tel = ? ,mutuelle = ? where numero = ?");

            stmt.setString(1, malade.getNom());
            stmt.setString(2, malade.getPrenom());
            stmt.setString(3, malade.getAdresse());
            stmt.setString(4, malade.getTel());
            stmt.setString(5, malade.getMutuelle());
            stmt.setInt(6, malade.getNumero());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Permet la suppression d'une entrée de la base
     * @param malade 
     */
    public void delete(Malade malade)//+++++++++++ok
    {

        PreparedStatement stmt = null;

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("delete from malade WHERE NUMERO = ?");
            stmt.setInt(1, malade.getNumero());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
