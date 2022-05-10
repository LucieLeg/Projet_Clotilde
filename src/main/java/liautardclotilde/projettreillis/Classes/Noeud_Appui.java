/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;
import static liautardclotilde.projettreillis.Classes.TriangleTerrain.angleEntreNoeudPoints;

/**
 *
 * @author audre
 */
public class Noeud_Appui extends Noeuds {
    
     //attributs 
    
    private TriangleTerrain TT; //normalement type=Triangle de Terrain
    private int numero;//3; numéro du premier PointTerrain du TT
    private double position; //4; correspond au alpha i.e. la position sur le segment
    
    //Encapsulation
    public TriangleTerrain getTT (){
        return this.TT;
    }
    
    public int getNumero (){
        return this.numero;
    }
    
    public double getPosition (){
        return this.position;
    }
    
    public void setTT (TriangleTerrain TT){
        this.TT=TT;
    }
    public void setNumero (int Numero){
        this.numero=Numero;
    }
    public void setPosition (double Position){
        this.position=Position;
    }
    
    public Noeud_Appui (int nom, TriangleTerrain TT, PointTerrain PTk, double alpha ){
        super(nom);
        this.TT=TT;
        this.numero= PTk.getNom();
        this.position= alpha;       
    }
    
    
    //constructeur avec 1 triangle, 2 PTs et alpha
    public Noeud_Appui (TriangleTerrain TT, PointTerrain PT1, PointTerrain PT2, double alpha){     
        this.TT=TT;
        this.position=alpha;
        this.setabscisse(this.absNoeudAppui(PT1, PT2, alpha));
        this.setordonne(this.ordNoeudAppui(PT1, PT2, alpha));
    }
    
    //constructeur avec 1 triangle, 2 PTs, alpha et le nom
    //LUI QU'ON utilise il me semble par rapport à new noeud appui
    public Noeud_Appui (int nom, TriangleTerrain TT, PointTerrain PT1, PointTerrain PT2, double alpha ){
        super(nom);
        this.TT=TT;
        this.position=alpha;
        this.setabscisse(this.absNoeudAppui(PT1, PT2, alpha));
        this.setordonne(this.ordNoeudAppui(PT1, PT2, alpha));
    }
    
        //constructeur avec abs, ord et qui calcule le alpha
    public Noeud_Appui (int nom, TriangleTerrain TT, double abs, double ord ){
        super(abs,ord,nom);
        this.TT=TT;
        //renvoie alpha
        //à quel triangle il appartient, à quel segment
        if (verifSurSegmentTerrain(this, this.TT.getPT1(),this.TT.getPT2())== true){
            this.numero= this.TT.getPT1().getNom();
        }
        if (verifSurSegmentTerrain(this, this.TT.getPT2(),this.TT.getPT3())== true){
            this.numero= this.TT.getPT2().getNom();
        }
        if (verifSurSegmentTerrain(this, this.TT.getPT3(),this.TT.getPT1())== true){
            this.numero= this.TT.getPT3().getNom();
        }
        
        int k = (this.numero+1)%3;
        //double alpha;
        
        if (TT.getPT1().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT3(), TT.getPT1());
        }
        if (TT.getPT2().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT1(), TT.getPT2());
        } 
        if (TT.getPT3().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT2(), TT.getPT3());
        }   
        
    }

    //constructeur auquel on donne pas alpha, va le calculer en fonction des coord des PTs
    //mais a besoin des abs et ordonnées du coup
    //est-ce qu'on en a besoin?
    //peut pas ne pas avoir ni alpha ni coord, soit l'un soit l'autre
    /*public Noeud_Appui (int nom, TriangleTerrain TT, PointTerrain sommet ){
        
        super(nom);
        this.TT=TT;
        
        if (verifSurSegmentTerrain(this, sommet, TT.getPT2())==true){
            this.numero = TT.getPT1().getNom();
        }
        if (verifSurSegmentTerrain(this, sommet, TT.getPT3())==true){
            this.numero = TT.getPT2().getNom();
        }
         if (verifSurSegmentTerrain(this, sommet, TT.getPT1())==true){
            this.numero = TT.getPT3().getNom();
        }
         
        int k = (this.numero+1)%3;
        //double alpha;
        
        if (TT.getPT1().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT3(), TT.getPT1());
        }
        if (TT.getPT2().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT1(), TT.getPT2());
        } 
        if (TT.getPT3().getNom()==k){
            this.position = this.calculDeAlpha(TT.getPT2(), TT.getPT3());
        }
   
    }*/

    public String toString(){
        return  "NoeudAppui ;"+this.getnom()+";"+this.TT+"; "+this.getNumero()+"; "+this.getPosition();
    }
   
    public double absNoeudAppui (PointTerrain PT1, PointTerrain PT2, double alpha){
        return (alpha*PT1.getPx() + (1-alpha)*PT2.getPx());
    }
     public double ordNoeudAppui (PointTerrain PT1, PointTerrain PT2, double alpha){
        return (alpha*PT1.getPy() + (1-alpha)*PT2.getPy());
    }
    
    
    public String position (PointTerrain PT1, PointTerrain PT2, double alpha){

        double abscisseNoeudAppui = alpha*PT1.getPx() + (1-alpha)*PT2.getPx();
        double ordonneeNoeudAppui = alpha*PT1.getPy() + (1-alpha)*PT2.getPy();

        System.out.println("Le noeud appui a pour coordonnées: P ("+abscisseNoeudAppui+", "+ordonneeNoeudAppui+")");
        return "i.e. P = (alpha)PT1 +  (1-alpha)PT2,  avec  alpha="+alpha;
        
    }
    
    public double calculDeAlpha (PointTerrain P1, PointTerrain P2){
        
        double alpha;
        if (P1.getPx()==P2.getPx()){
            alpha = ((this.getordonne() - P1.getPy())/(P2.getPy()-P1.getPy()));
        } else if (P1.getPy()==P2.getPy()){
            alpha = ((this.getabscisse() - P1.getPx())/(P2.getPx()-P1.getPx()));
        } else{
            alpha =((this.getabscisse() - P1.getPx())/(P2.getPx()-P1.getPx()));
        }
        return alpha;  
    }
    
    //méthode qui vérifie si un noeud est sur un segment de Terrain
    public boolean Verification_SegmentTerrain (Noeuds N, PointTerrain P1, PointTerrain P2){
        double x1;
        double x2;
        double y1;
        double y2;
        
        if (P1.getPx()<P2.getPx()){
            x1=P1.getPx();
            x2=P2.getPx();
            y1=P1.getPy();
            y2=P2.getPy();
        }else{
            x1=P2.getPx();
            x2=P1.getPx();
            y1=P2.getPy();
            y2=P1.getPy();  
        }
        
        double x=N.getabscisse();
        double y=N.getordonne();
        
        //Non prise en compte des segments verticals de terrain, attention 0 au dénominateur
        if ((x2-x1)/(y2-y1) == (x-x1)/(y-y1)) {
        // N est sur la droite formée par P1/P2
            if( x<=x2 && x>=x1) {
            // N est sur le segment P1-P2
            return true;
            } else {
            // N est sur la droite mais en dehors du segment
            return false;
            }
        } else {
         // N est en dehors de la droite donc en dehors du segment
         return false;
        }
    }
    
    //autre méthode pour verifier appartenance au segment
    public boolean verifSurSegmentTerrain (Noeuds N, PointTerrain P1, PointTerrain P2){
       
        boolean surSegment=false;
        if ( ( Math.toDegrees (angleEntreNoeudPoints(N,P1,P2)) ==  0 ) || (Math.toDegrees(angleEntreNoeudPoints (N,P1,P2))== -180) ||( Math.toDegrees(angleEntreNoeudPoints (N, P1,P2)) == 180) || (Math.toDegrees(angleEntreNoeudPoints(N,P1,P2))==360)) {
            System.out. println ( " point colinéaire au segment ["+P1.getNom()+"; "+P2.getNom()+"]" );
            if(P1.getPx()<P2.getPx() ){
                
                if( N.getabscisse()>= P1.getPx() && N.getabscisse()<=P2.getPx()){
                    surSegment= true;
                }
                if( N.getabscisse()< P1.getPx() || N.getabscisse()>P2.getPx()){
                    surSegment= false;
                }
            
            }if (P1.getPx()>P2.getPx()){
                
                if( N.getabscisse()<= P1.getPx() && N.getabscisse()>=P2.getPx()){
                    surSegment= true;
                }
                if( N.getabscisse()> P1.getPx() || N.getabscisse()<P2.getPx()){
                    surSegment= false;
                }
            } if (P1.getPy()<P2.getPy()){
                
                if( N.getordonne()<= P2.getPy() && N.getordonne()>= P1.getPy()){
                    surSegment= true;
                }
                if( N.getordonne()> P2.getPy() || N.getordonne()< P1.getPy()){
                    surSegment= false;
                }         
            } if (P1.getPy()>P2.getPy()){
                
                if( N.getordonne()<= P1.getPy() && N.getordonne()>= P2.getPy()){
                    surSegment= true;
                }
                if( N.getordonne()> P1.getPy() || N.getordonne()< P2.getPy()){
                    surSegment= false;
                }         
            }            
        } else {
            surSegment= false;
        }   
        return surSegment;
    }
    
    /* Explication du alpha:
    
    nombre compris entre 0 et 1 qui rend compte de la position du noeud sur la 
    barre/ le segment:
    EX:
    - si alpha = 0.5  , alors le noeud est placé au millieu de la barre
                        i.e. à 50% de la longueur de la barre
    - si alpha = 0.2  , alors le noeud est placé plus proche d'un des deux point
                        du triangle de terrain.
                        i.e. à 20% de la longueur de la barre
    !!Attention, on compte en partant du premier point saisit
    !!donc pour 20% sur un segment [AB], le noeud C sera plus proche de A
    !!en effet alpha = AC/AB
    !!Donc plus on veut proche du 2eme point plus alpha proche de 1
    !!plus noeud proche du 1er point, plus alpha proche de 0
    Si noeud_Appui == PointTerrain --> erreur
    */
    
}
