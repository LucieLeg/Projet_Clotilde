/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

import static liautardclotilde.projettreillis.Classes.TriangleTerrain.angleEntreDeuxPoints;

/**
 *
 * @author Elève
 */
public class SegmentTerrain {
    
         private PointTerrain debut ;
         private PointTerrain fin ;

        public  SegmentTerrain ( PointTerrain  debut , PointTerrain  fin ) {
            this. debut = debut;
            this.fin = fin;
        }
        
        //Segment fait d'un PoinTerrain et d'un noeud
        //uniquement pour la classe Noeud_appui
        public SegmentTerrain( Noeud_Appui n, PointTerrain p){
            PointTerrain Pn = new PointTerrain(n.getabscisse(),  n.getordonne(),n.getnom());
            this.debut = Pn;
            this.fin = p;
        }
        
        public  PointTerrain  getDebut () {
            return this.debut;
        }

        public  PointTerrain  getFin () {
            return this.fin;
        }

        public  String  toString () {
            return  " [ "  +  this. debut +  " , "  +  this. fin +  " ] " ;
        }

        
        public double longueurSegment (){
            return Math.sqrt(Math.pow((this.fin.getPx()-this.debut.getPx()),2) + Math.pow((this.fin.getPy()-this.debut.getPy()),2));
        }
        
        public static boolean VerifSurSegment(PointTerrain PT, PointTerrain P1, PointTerrain P2){
       
        boolean surSegment=false;
        if ( ( Math.toDegrees (angleEntreDeuxPoints (PT,P1,P2)) ==  0 ) || (Math.toDegrees(angleEntreDeuxPoints (PT,P1,P2))== -180) ||( Math.toDegrees(angleEntreDeuxPoints (PT, P1,P2)) == 180) || (Math.toDegrees(angleEntreDeuxPoints(PT,P1,P2))==360)) {
            System.out. println ( " point colinéaire au segment [pT1;pT2]" );
            if(P1.getPx()<P2.getPy() ){
                
                if( PT.getPx()>= P1.getPx() && PT.getPx()<=P2.getPx()){
                    surSegment= true;
                }
                if( PT.getPx()< P1.getPx() || PT.getPx()>P2.getPx()){
                    surSegment= false;
                }
            
            } else if (P1.getPx()>P2.getPy()){
                
                if( PT.getPx()<= P1.getPx() && PT.getPx()>=P2.getPx()){
                    surSegment= true;
                }
                if( PT.getPx()> P1.getPx() || PT.getPx()<P2.getPx()){
                    surSegment= false;
                }
            } else {
                surSegment= false;
            }
        } else {
            surSegment= false;
        }   
        return surSegment;
    }
}
