/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Vincent
 */
public class Personne {

    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    
    public Personne()
    {
    
    }

    public Personne(String nom, String prenom, String tel, String adresse) {

        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresse = adresse;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String a) {
        nom = a;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String a) {
        prenom = a;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString()
    {
    return "nom : "+nom+" prenom : "+prenom+"\ntel : "+tel+" adresse : "+adresse;
    }
    
    
}
