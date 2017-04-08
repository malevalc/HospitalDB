/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_recherche_information;

import java.util.ArrayList;
import Classes.*;

/**
 *
 * @author Vincent
 */
public class Resultat_recherche<T, U, V> {

    private ArrayList<T> array_list1;
    private ArrayList<U> array_list2;
    private ArrayList<V> array_list3;

    public Resultat_recherche() {
        
    }
    public Resultat_recherche(boolean b1,boolean b2,boolean b3) {
        if(b1==true)
        array_list1 = new ArrayList<T>();
        if(b2==true)
        array_list2 = new ArrayList<U>();
        if(b3==true)
        array_list3 = new ArrayList<V>();
    }

    
    //getters
    public ArrayList<T> getArrayList1()
    {
    return array_list1;
    }
    
    public ArrayList<U> getArrayList2()
    {
    return array_list2;
    }
    
     public ArrayList<V> getArrayList3()
    {
    return array_list3;
    }
     
     //setters
     
     public void setArrayList1(ArrayList<T> list)
     {
     array_list1=list;
     }
     public void setArrayList2(ArrayList<U> list)
     {
     array_list2=list;
     }
      public void setArrayList3(ArrayList<V> list)
     {
     array_list3=list;
     }
}
