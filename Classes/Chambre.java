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
public class Chambre {

    private int no_chambre;
    private String code_service;
    private int surveillant;
    private int nb_lits;

    public Chambre()
    {
    
    }
    
    
    public Chambre(int no_chambre, String code_service, int surveillant, int nb_lits) {
        this.no_chambre = no_chambre;
        this.code_service = code_service;
        this.surveillant = surveillant;
        this.nb_lits = nb_lits;

    }

    public int getNo_chambre() {
        return no_chambre;
    }

    public void setNo_chambre(int a) {
        no_chambre = a;
    }

    public String getCode_service() {
        return code_service;
    }

    public void setCode_service(String b) {
        code_service = b;
    }

    public int getNoSurveillant() {
        return surveillant;
    }

    public void setNoSurveillant(int a) {
        surveillant = a;
    }

    public int getNb_lits() {
        return nb_lits;
    }

    public void setNb_lits(int a) {
        nb_lits = a;
    }
    
    @Override
   public String toString()
   {
   return "num : "+no_chambre+"code Service : "+code_service+"\n"+"Surveillant : "+surveillant+" nb lits : "+nb_lits;
   }

}
