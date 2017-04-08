/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import module_connexion.SSHTunnel;
import module_connexion.super_connexion;

/**
 *
 * @author Vincent
 */
public class InfirmierDAO extends DAO<Infirmier> {

    /**
     * Permet de récupérer un objet via son ID
     *
     * @param id
     * @return
     */
    @Override
    public Infirmier find(int id) {
        Infirmier infirmier = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)
            /*stmt=my_con.prepareStatement("select * from Infirmier WHERE Id= ?");
             stmt.setString(1,id);
             stmt.
             */
            //stmt = super_connexion.my_con.getConnection().createStatement();
             stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT numero,code_service,rotation,salaire FROM infirmier where numero = ?");
            //rset = stmt.executeQuery("select * from infirmier WHERE numero = " + id);
            stmt.setInt(1,id);
             rset = stmt.executeQuery();
            if (rset.next()) {
                int numero = rset.getInt(1);
                String code_service = rset.getString(2);
                String rotation1 = rset.getString(3);
                int salaire = rset.getInt(4);

                infirmier = new Infirmier();
                infirmier.setNumero(numero);
                infirmier.setCodeService(code_service);
                infirmier.setRotation(rotation1);
                infirmier.setSalaire(salaire);
                
                //!!!!!!!
                 EmployeDAO employedao = new EmployeDAO();
                Employe employe = employedao.find(numero);

               
                //On lui complete ce qui lui est propre en tant qu'infirmier
     
                //On lui complete cequi lui est propre en tant qu'employé
               infirmier.setNom(employe.getNom());
                infirmier.setPrenom(employe.getPrenom());
                infirmier.setAdresse(employe.getAdresse());
                infirmier.setTel(employe.getTel());
                
            }
            //rsetMeta=rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return infirmier;

    }

    public ArrayList<Infirmier> findAll()//on rajoute cette méthode car 1..*
    {
        PreparedStatement stmt = null;
        ResultSet rst = null;
        ArrayList<Infirmier> infirmiers = new ArrayList<Infirmier>();

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT NUMERO,CODE_SERVICE,ROTATION,SALAIRE FROM infirmier");
            rst = stmt.executeQuery();

            while (rst.next()) {
                int numero = rst.getInt(1);
                String code_service = rst.getString(2);
                String rotation = rst.getString(3);
                int salaire = rst.getInt(4);

        //Choper les employés dao et compléter la suite...
                //employe=employedao.find(numero)
                //et on peut choper et compléter ce qui manque
                // On fait pareil pour les autres méthodes find
        //Il faut qu'on rajoute une table personne dans notre base
                // on supprime les atttributs nom prenom adress tel des tables employe et malade
                // et on fabrique une nvlle table personne
                //on peut rajouter une table surveillant
                EmployeDAO employedao = new EmployeDAO();
                Employe employe = employedao.find(numero);

                Infirmier inf = new Infirmier();
                //On lui complete ce qui lui est propre en tant qu'infirmier
                inf.setNumero(numero);
                inf.setCodeService(code_service);
                inf.setRotation(rotation);
                inf.setSalaire(salaire);
                //On lui complete cequi lui est propre en tant qu'employé
                inf.setNom(employe.getNom());
                inf.setPrenom(employe.getPrenom());
                inf.setAdresse(employe.getAdresse());
                inf.setTel(employe.getTel());

                infirmiers.add(inf);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return infirmiers;

    }

    public ArrayList<Infirmier> findByService(String code_service)//on rajoute cette méthode car 1..*
    {
        PreparedStatement stmt = null;
        ResultSet rst = null;
        ArrayList<Infirmier> infirmiers_du_service = new ArrayList<Infirmier>();
        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("SELECT NUMERO,CODE_SERVICE,ROTATION,SALAIRE FROM infirmier WHERE CODE_SERVICE LIKE ? ");
            stmt.setString(1, code_service);
            rst = stmt.executeQuery();

            while (rst.next()) {
                int num = rst.getInt(1);
                String c_service = rst.getString(2);
                String rotation = rst.getString(3);
                int salaire = rst.getInt(4);

                Infirmier inf = new Infirmier();
                inf.setNumero(num);
                inf.setCodeService(c_service);
                inf.setRotation(rotation);
                inf.setSalaire(salaire);

                infirmiers_du_service.add(inf);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

        return infirmiers_du_service;

    }

    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     * @param infirmier 
     */
    @Override
    public void create(Infirmier infirmier) {
        PreparedStatement stmt = null;
        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("insert into infirmier (NUMERO,CODE_SERVICE,ROTATION,SALAIRE) values (?,?,?,?)");
            stmt.setInt(1, infirmier.getNumero());
            stmt.setString(2, infirmier.getCodeService());
            stmt.setString(3, infirmier.getRotation());
            stmt.setInt(4, infirmier.getSalaire());


            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param infirmier 
     */
    public void update(Infirmier infirmier) {
        PreparedStatement stmt = null;

        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("update infirmier set CODE_SERVICE = ?, ROTATION = ?,SALAIRE = ? where NUMERO = ?");
            stmt.setString(1, infirmier.getCodeService());
            stmt.setString(2, infirmier.getRotation());
            stmt.setInt(3, infirmier.getSalaire());
            stmt.setInt(4, infirmier.getNumero());
            System.out.println("lppppp");
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet la suppression d'une entrée de la base
     * @param infirmier 
     */
    public void delete(Infirmier infirmier) {
        PreparedStatement stmt = null;

        try {

            stmt = super_connexion.my_con.getConnection().prepareStatement("delete from infirmier WHERE NUMERO = ?");
            stmt.setInt(1, infirmier.getNumero());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InfirmierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
