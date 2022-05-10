/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

/**
 *
 * @author Clotilde
 */
public abstract class Noeuds { 
    
    //Définitions des attibuts
    private double abscisse; //Peut-être changer tout ca pour mettre Noeud classe abstraite 
    private double ordonne; //abs et ord dans Noeud Simple et donc que nom 
    private int nom;
    
    //Constructeur
    public Noeuds (double abs, double ord, int nom){
        this.abscisse=abs;
        this.ordonne=ord;
        this.nom=nom;
    }
    
    public Noeuds (double abs, double ord){
        this.abscisse=abs;
        this.ordonne=ord;
    }
    
    public Noeuds (){
        this.abscisse=0;
        this.ordonne=0;
        this.nom=0;
    }
    
    public Noeuds (int nom){
        this.nom=nom;
    }
    
    //Encapsulations
    public double getabscisse(){
        return this.abscisse;
    }
    public double getordonne(){
        return this.ordonne;
    }
    public int getnom(){
        return this.nom;
    }
    
    //Encapsulation2
    public abstract TriangleTerrain getTT ();
    
    public abstract int getNumero ();
    
    public abstract double getPosition ();
    
    
    public void setabscisse (double abs){
        this.abscisse=abs;
    }
    public void setordonne (double ord){
        this.ordonne=ord;
    }
    public void setnom (int nom){
        this.nom = nom;
    }
    
    //ToString
    public String toString() {
        return "Noeud :"+this.nom+":("+this.abscisse+","+this.ordonne+") ou ("+this.getTT()+"; "+this.getNumero()+"; "+this.getPosition()+")";
    }
    
    public static String NoeudsString (Noeuds N) {
        return N.nom+":("+N.abscisse+","+N.ordonne+")";
    }
    
    //Méthode qui vérifie l'appartenance du Noeud au Terrain
        public boolean Verification_Appartenance_TerrainN (Terrain T){
            if ((this.abscisse<=T.getxMax())&&(this.ordonne<=T.getyMax())&&(this.abscisse>=T.getxMin())&&(this.ordonne>=T.getyMin())){
                return true;
            }else{
                return false;
            }
        }
        
    public double absNoeuds (PointTerrain PT1, PointTerrain PT2, double alpha){
        return (1-alpha)*PT1.getPx() + alpha*PT2.getPx();
    }
    public double ordNoeuds (PointTerrain PT1, PointTerrain PT2, double alpha){
        return (1-alpha)*PT1.getPy() + alpha*PT2.getPy();
    }
    /*Méthode de vérification d'un noeud sur le terrain (Si oui alors utilisateur choix
    entre 3 types de noeud(simple, appuis simple appui double), si non soeud simple obligatoirement)
    IL DOIT Y A AVOIR AU MOINS UN NOEUD APPUI AU TERRAIN !!( Créer un message d'erreur 
    à l'utilisateur)*/

  
    
}

