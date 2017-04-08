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
public class Malade extends Personne {

    private String mutuelle;
    private int numero;
    
    ArrayList<Docteur> docteurs;
    
    //faire une liste d'hospitalisation

    public Malade()
    {
    }
    
    public Malade(String nom, String prenom, String tel, String adresse, String mutuelle,int numero) {
        super(nom, prenom, tel, adresse);
        this.mutuelle = mutuelle;
        this.numero=numero;
    }

    public String getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(String a) {
        mutuelle = a;
    }
    
    public int getNumero()
    {
    return numero;
    }
    
    public void setNumero(int numero)
    {
    this.numero=numero;
    }
    
    public ArrayList<Docteur> getDocteurs()
    {
    return docteurs;
    }
    
    public void setDocteurs(ArrayList<Docteur> docteurs)
    {
    
    }
    
    @Override
    public String toString()
    {
    return super.toString()+" numero : "+numero+" mutuelle : "+mutuelle+"\n";
    }
    
    public void afficher()
    {
    System.out.println(this.toString());
    }

}
