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
public class HospitalisationDAO extends DAO<Hospitalisation> {

    /**
     * Permet de récupérer un objet via son ID
     *
     * @param num_malade
     * @return
     */
    public Hospitalisation find(int num_malade) {

        Hospitalisation hosp = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsetMeta = null;

        try {
            // création d'un ordre SQL (statement)
            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from hospitalisation WHERE no_malade = ?");
            stmt.setInt(1, num_malade);
            rset = stmt.executeQuery();

            if (rset.next()) {

                int no_malade = rset.getInt(1);
                String code_service = rset.getString(2);
                int no_chambre = rset.getInt(3);
                int nb_lits = rset.getInt(4);

                hosp = new Hospitalisation();
                hosp.setNo_malade(no_malade);
                hosp.setCode_service(code_service);
                hosp.setNo_chambre(no_chambre);
                hosp.setLit(nb_lits);
            }
           // rsetMeta=rset.getMetaData();

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hosp;

    }

    public ArrayList<Hospitalisation> findByService(String code_servicebis) {

        Hospitalisation hosp = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsetMeta = null;
        ArrayList<Hospitalisation> hospitalisations = new ArrayList<Hospitalisation>();

        try {
            // création d'un ordre SQL (statement)
            stmt = super_connexion.my_con.getConnection().prepareStatement("select * from hospitalisation WHERE code_service LIKE ?");
            stmt.setString(1, "%" + code_servicebis + "%");
            rset = stmt.executeQuery();

            while (rset.next()) {
                System.out.print("resulat");
                int no_malade = rset.getInt(1);
                String code_service = rset.getString(2);
                int no_chambre = rset.getInt(3);
                int num_lit = rset.getInt(4);

                Hospitalisation hospit = new Hospitalisation();
                hospit.setNo_malade(no_malade);
                hospit.setCode_service(code_service);
                hospit.setNo_chambre(no_chambre);
                hospit.setLit(num_lit);

                hospitalisations.add(hospit);

            }

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hospitalisations;

    }

    /**
     * Permet de créer une entrée dans la base de données par rapport à un objet
     * @param hospitalisation 
     */
    public void create(Hospitalisation hospitalisation) {
        PreparedStatement stmt = null;
        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("insert into hospitalisation (no_malade,code_service,no_chambre,lit) values (?,?,?,?)");

            stmt.setInt(1, hospitalisation.getNo_malade());
            stmt.setString(2, hospitalisation.getCode_service());
            stmt.setInt(3, hospitalisation.getNo_chambre());
            stmt.setInt(4, hospitalisation.getLit());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param hospitalisation 
     */
    public void update(Hospitalisation hospitalisation) {
        PreparedStatement stmt = null;

        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("update hospitalisation set CODE_SERVICE = ?,NO_CHAMBRE = ?, LIT = ? where NO_MALADE = ?");
            stmt.setString(1, hospitalisation.getCode_service());
            stmt.setInt(2, hospitalisation.getNo_chambre());
            stmt.setInt(3, hospitalisation.getLit());
            stmt.setInt(4, hospitalisation.getNo_malade());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Permet la suppression d'une entrée de la base
     * @param hospitalisation 
     */
    public void delete(Hospitalisation hospitalisation) {

        PreparedStatement stmt = null;

        try {
            stmt = super_connexion.my_con.getConnection().prepareStatement("delete from hospitalisation WHERE NO_MALADE = ?");
            stmt.setInt(1, hospitalisation.getNo_malade());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HospitalisationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
