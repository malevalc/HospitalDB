/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public class Docteur extends Employe {

    private String specialite;
    ArrayList<Malade> patients;
    
    public Docteur()
    {
    
    }

    public Docteur(String nom, String prenom, String tel, String adresse, int numero, String specialite) {
        super(nom, prenom, tel, adresse, numero);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;

    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    public ArrayList<Malade> getPatients()
    {
    return patients;
    }
    
    public void setPatients(ArrayList<Malade> patients)
    {
    this.patients=patients;
    }
    
    @Override
    public String toString()
    {
    return super.toString()+" specialité : "+specialite+"\n";
    }

}
