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
public class Surveillant extends Infirmier {

    private int no_chambre;

    public Surveillant()
    {
    }
    public Surveillant(String nom, String prenom, String tel, String adresse, int numero, String rotation, int salaire, int no_chambre,String code_service) {
        super(nom, prenom, tel, adresse, numero, rotation, salaire,code_service);
        this.no_chambre = no_chambre;
    }

    public int getNo_chambre() {
        return no_chambre;
    }

    public void setNo_chambre(int a) {
        no_chambre = a;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+"no chambre : "+no_chambre;
    }
}
