/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_reporting;

import java.util.ArrayList;

/**
 *
 * @author Vincent
 */
public class Donnees_pie_bar_chart {
    
    private ArrayList<String> axes_abscisses;
    private ArrayList<Integer> axes_ordonnees;
    
    
   public Donnees_pie_bar_chart()
   {
   axes_abscisses=new ArrayList<String>();
   axes_ordonnees=new ArrayList<Integer>();
   }
    
  public ArrayList<String>  getAxesAbscisses()
  {
  return axes_abscisses;
  }
  
  public ArrayList<Integer> getAxesOrdonnees()
  {
  
  return axes_ordonnees;
  }
  
  public void setDonneeAxesAbscisses(String axes_abscisses)
  {
  this.axes_abscisses.add(axes_abscisses);
  }
  public void setDonneeAxesOrdonnees(Integer entier)
  {
  this.axes_ordonnees.add(entier);
  }
  
  public void setAxesAbscisses(ArrayList<String> axes_abscisses)
  {
  this.axes_abscisses=axes_abscisses;
  
  }
    
   public void setAxesOrdonnees(ArrayList<Integer> axes_ordonnees)
   {
   this.axes_ordonnees=axes_ordonnees;
   }
    
   public void afficher()
   {
   for(int i=0;i<axes_abscisses.size();i++)
       System.out.println(axes_abscisses.get(i));
   
   for(int i=0;i<axes_ordonnees.size();i++)
       System.out.println(axes_ordonnees.get(i));
   }
    
}
