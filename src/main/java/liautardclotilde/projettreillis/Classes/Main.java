/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

import static liautardclotilde.projettreillis.Classes.Barre.verification_croisement;



/**
 *
 * @author Clotilde
 */
public class Main {
    
    public static void main (String[] args){
    Noeuds A = new Noeud_Simple (0,0,1) ;
    Noeuds B = new Noeud_Simple (2,2,2) ;
    //TypeBarre T1= new TypeBarre ("A",2,3,4,5,6);
    Catalogue_Barre T1=new Catalogue_Barre ();
    Barre S1 = new Barre (A,B,1,T1,0);
    Noeuds C = new Noeud_Simple (0,2,3) ;
    Noeuds D = new Noeud_Simple (2,0,4) ;
    Barre S2 = new Barre (C,D,2,T1,1);
    int k=verification_croisement(S1,S2);
    System.out.println(k);
    for (int j=0;j<6;j++){
        System.out.println(T1.getEnsemble_TypeBarre().get(j));
    }
    }
}
