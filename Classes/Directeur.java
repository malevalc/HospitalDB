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
public class Directeur extends Docteur {

    private int code_service;

    
    public Directeur()
    {
    
    }
    public Directeur(String nom, String prenom, String tel, String adresse, int numero, String specialite, int code_service) {
        super(nom, prenom, tel, adresse, numero, specialite);
        this.code_service = code_service;
    }

    public int getCode_service() {
        return code_service;
    }

    public void setCode_service(int a) {
        code_service = a;
    }
   
    @Override
    public String toString()
    {
     return super.toString()+" code service : "+code_service;
    }

}
