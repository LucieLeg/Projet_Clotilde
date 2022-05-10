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
public class Noeud_Simple extends Noeuds {
    
    public Noeud_Simple(double abs, double ord, int nom) {
        super(abs, ord, nom);
    }
    
    public Noeud_Simple() {
        super(0,0,0);
    }
    
    //constructeur avec 1 triangle, 2 PTs, alpha et le nom
    public Noeud_Simple (Noeuds N){
        super(N.getabscisse(),N.getordonne(),N.getnom());
    }
    
    public String toString(){
        return  "NoeudSimple ;"+this.getnom()+";"+this.getabscisse()+"; "+this.getordonne();
    }
    
    //Encapsulation

    @Override
    public TriangleTerrain getTT() {
        return null;
    }

    @Override
    public int getNumero() {
        return 0;
    }

    @Override
    public double getPosition() {
        return 0;
    }
   
}
