/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

/**
 *
 * @author Elève
 */
public class Appui_Double extends Noeud_Appui {
    
    public Appui_Double(TriangleTerrain TT, PointTerrain PTk, double alpha, int nom) {
        super(nom,TT, PTk, alpha);
    }
    
    public Appui_Double (TriangleTerrain TT, PointTerrain PT1, PointTerrain PT2, double alpha, int nom){
        super (nom,TT,PT1,PT2,alpha);
    }
    
    public Appui_Double (double abs,TriangleTerrain T, double ord, int nom){
        super (nom,T, abs, ord);
    }
    

    
   
    

   
    
   
    
    
    
    
}
