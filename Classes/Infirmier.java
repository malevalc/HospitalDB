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
public class Infirmier extends Employe {

    private String rotation;
    private int salaire;
    private String code_service;//on rajoute cet attribut pour faire le lien avec un service

    public Infirmier()
    {}
    public Infirmier(String nom, String prenom, String tel, String adresse, int numero, String rotation, int salaire,String code_service) {
        super(nom, prenom, tel, adresse, numero);
        this.rotation = rotation;
        this.salaire = salaire;
        this.code_service=code_service;
    }

    public String getRotation() {
        return rotation;
    }

    public void setRotation(String a) {
        rotation = a;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int a) {
        salaire = a;
    }
    public String getCodeService()
    {
    return code_service;
    }
    
    public void setCodeService(String code_service)
    {
    this.code_service=code_service;
    }
    
    @Override
    public String toString()
    {
    return super.toString()+"rotation : "+rotation+" Salaire : "+salaire+"\n";
    }
    
    public void afficher()
    {
    System.out.print(this.toString());
    }

}
