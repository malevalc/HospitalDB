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
public class Employe extends Personne {

    private int numero;
    
    public Employe()
    {
    
    }

    public Employe(String nom, String prenom, String tel, String adresse, int numero) {
        super(nom, prenom, tel, adresse);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int a) {
        numero = a;
    }
    
    @Override
    public String toString()
    {
    return super.toString()+"\n numero : "+numero+"\n";
    
    }

}
