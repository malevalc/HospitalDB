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
public class Soigne {
    
    private int numero_docteur;
    private int numero_malade;
    
    public Soigne()
    {}
    
    public Soigne(int numero_docteur,int numero_malade)
    {
    this.numero_docteur=numero_docteur;
    this.numero_malade=numero_malade;
    }
    
    public void setNumero_docteur(int numero_docteur)
    {
         this.numero_docteur=numero_docteur;
    }
    
    public void setNumero_malade(int numero_malade)
    {   this.numero_malade=numero_malade;
    }
    
    public int getNumero_docteur()
    {
    return numero_docteur;
    }
    
    public int get_Numero_malade()
    {
    return numero_malade;
    }
    
    @Override
    public String toString()
    {
    return "numero docteur : "+numero_docteur+"numero malade : "+numero_malade;
    }
    
    
}
