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
public class Service {

    private String code;
    private String nom;
    private String batiment;
    private int num_directeur;
    private ArrayList<Chambre> chambres;
    private ArrayList<Infirmier> infirmiers;
    

    public Service()
    {
    }
    public Service(String code, String nom, String batiment, int num_directeur) {
        this.code = code;
        this.nom = nom;
        this.batiment = batiment;
        this.num_directeur = num_directeur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String a) {
        nom = a;
    }

    public String getBatiment() {
        return batiment;
    }

    public void setBatiment(String a) {
        batiment = a;
    }

    public int getDirecteur() {
        return num_directeur;
    }

    public void setDirecteur(int a) {
        num_directeur = a;
    }
    
    
    
    public ArrayList<Chambre> getChambres()
    {
    return chambres;
    }
    
    public void setChambres(ArrayList<Chambre> chambres)
    {
    this.chambres=chambres;
    
    }
    
    public  ArrayList<Infirmier> getInfirmiers()
    {
    return infirmiers;
    }
    
    public void setInfirmier(ArrayList<Infirmier> infirmiers)
    {
    this.infirmiers=infirmiers;
    }
    
    @Override
    public String toString()
    {
    return "code : "+code+" nom : "+nom+" batiment : "+batiment+"\n"+"directeur : "+num_directeur;
    }
}
