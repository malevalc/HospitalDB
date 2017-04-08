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
public class Hospitalisation {

    private int no_malade;
    private String code_service;
    private int no_chambre;
    private int lit;
    
    
    public Hospitalisation()
    {}

    public Hospitalisation(int no_malade, String code_service, int no_chambre, int lit) {
        this.no_malade = no_malade;
        this.code_service = code_service;
        this.no_chambre = no_chambre;
        this.lit = lit;
    }

    public int getNo_malade() {
        return no_malade;
    }

    public void setNo_malade(int a) {
        no_malade = a;
    }

    public String getCode_service() {
        return code_service;
    }

    public void setCode_service(String a) {
        code_service = a;
    }

    public int getNo_chambre() {
        return no_chambre;
    }

    public void setNo_chambre(int a) {
        no_chambre = a;
    }

    public int getLit() {
        return lit;
    }

    public void setLit(int a) {
        lit = a;
    }

}
