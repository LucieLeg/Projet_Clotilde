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
public class PointTerrain {

         private double px ;
         private double py;
         private int nom;
         
        public  PointTerrain () {
            double z=0;
            this.px=z;
            this.py=z;
        }

        public  PointTerrain ( double  abs , double  ord, int nom ) {
            this.px = abs;
            this.py= ord; 
            this.nom=nom;
        }
        //Nom entre 1 et 3;
        public  double  getPx () {
            return this.px;
        }

        public  double  getPy () {
            return  this.py;
        }
        public  int  getNom () {
            return  this.nom;
        }

        public  void  setPx ( double  px ) {
            this.px = px;
        }

        public  void  setPy ( double  py ) {
            this.py = py;
        }
        
        //Méthode qui vérifie l'appartenance du point au Terrain
        public boolean Verification_Appartenance_TerrainP (Terrain T){
            if ((this.px<=T.getxMax())&&(this.py<=T.getyMax())&&(this.px>=T.getxMin())&&(this.py>=T.getyMin())){
                return true;
            }else{
                return false;
            }
        }

        
        public String toString () {
            return "(" + this.px + "," + this.py + ")";
        }
        
    }

