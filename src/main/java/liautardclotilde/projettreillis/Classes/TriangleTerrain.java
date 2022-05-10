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
   
    
    
public class TriangleTerrain {

    private PointTerrain pT1;
    private PointTerrain pT2;
    private PointTerrain pT3;
    private int nom;
    
    public PointTerrain getPT1(){
        return this.pT1;
    }
    public PointTerrain getPT2(){
        return this.pT2;
    }
    public PointTerrain getPT3(){
        return this.pT3;
    }
    public int getNOM(){
        return this.nom;
    }

    public void setpT1(PointTerrain pT1) {
        this.pT1 = pT1;
    }

    public void setpT2(PointTerrain pT2) {
        this.pT2 = pT2;
    }

    public void setpT3(PointTerrain pT3) {
        this.pT3 = pT3;
    }

    public void setNOM(int nom) {
        this.nom = nom;
    }
    
    
    
    public TriangleTerrain (PointTerrain a, PointTerrain b, PointTerrain c, int nom){
        this.pT1= a;
        this.pT2= b;
        this.pT3= c;
        this.nom=nom;
        SegmentTerrain sT1 = new SegmentTerrain(this.pT1, this.pT2);
        SegmentTerrain sT2 = new SegmentTerrain(this.pT2, this.pT3);
        SegmentTerrain sT3 = new SegmentTerrain(this.pT1, this.pT3);
    }
   
    public SegmentTerrain getSegment1 (){
        SegmentTerrain sT1 = new SegmentTerrain(this.pT1, this.pT2);
        return sT1;
    }
    public SegmentTerrain getSegment2 (){
        SegmentTerrain sT2 = new SegmentTerrain(this.pT2, this.pT3);
        return sT2;
    }
    public SegmentTerrain getSegment3 (){
        SegmentTerrain sT3 = new SegmentTerrain(this.pT1, this.pT3);
        return sT3;
    }
    
    public String toString (){
        return "Triangle; "+this.nom+"; ("+this.pT1.getPx()+","+this.pT1.getPy()+"); ("+this.pT2.getPx()+","+this.pT2.getPy()+"); ("+this.pT3.getPx()+","+this.pT3.getPy()+")";
    }

    //Méthode pour avoir angle de 2 points, pas utilisé pour l'instant, c'était un test
    public static double getAngleFromPoint (PointTerrain a, PointTerrain b){
        if((b.getPx()> a.getPx())){
            return (Math.atan2((b.getPx() - a.getPx()), (a.getPy()- b.getPy())))*180/Math.PI;

        }
        else if((b.getPx()<a.getPx())){
            return 360 -(Math.atan2((a.getPx()-b.getPx()),(a.getPy()-b.getPy())))*180/Math.PI;
        }
        return Math.atan2(0,0);
    } 
    
    //donne angle entre 3 points en degrés - statique:
    public static double angleEntreDeuxPoints(PointTerrain p, PointTerrain a, PointTerrain b) {

        double angle1 = Math.atan2(p.getPy() - a.getPy(), p.getPx() - a.getPx());
        double angle2 = Math.atan2(p.getPy() - b.getPy(), p.getPx() - b.getPx());
        double angle= angle2-angle1;
        if (Math.toDegrees(angle)<0){
            angle+= (2*Math.PI);
        }
        //System.out.println(Math.toDegrees(angle));
        return angle ;
    }  
    
    //donne angle entre 3 points en degrés - statique:
    public static double angleEntreNoeudPoints(Noeuds p, PointTerrain a, PointTerrain b) {

        double angle1 = Math.atan2(p.getordonne() - a.getPy(), p.getabscisse() - a.getPx());
        double angle2 = Math.atan2(p.getordonne() - b.getPy(), p.getabscisse() - b.getPx());
        double angle= angle2-angle1;
        if (Math.toDegrees(angle)<0){
            angle+= (2*Math.PI);
        }
        //System.out.println(Math.toDegrees(angle));
        return angle ;
    }  
        

    //donne angle entre 3 points en degrés - normal:
    public double angleEntreNoeudPoint (Noeuds p){

        double angle1 = Math.atan2(p.getordonne()-this.pT1.getPy(),p.getabscisse() - this.pT1.getPx());
        double angle2 = Math.atan2(p.getordonne()-this.pT2.getPy(),p.getabscisse() - this.pT2.getPx());
        double angle= angle2-angle1;
        if (Math.toDegrees(angle)<0){
            angle+= (2*Math.PI);
        }
        System.out.println(Math.toDegrees(angle));
        return angle ;
    }  


    //méthode permettant de savoir si un point appartient au TriangleTerrain
    public static double verifPointDansTerrain ( PointTerrain  p , PointTerrain  a , PointTerrain  b) {

        double appartenance;
        if (( Math.toDegrees(angleEntreDeuxPoints (p, a, b)) ==  0  )|| ((Math.toDegrees(angleEntreDeuxPoints (p, a, b)) )== -180)  ||( Math.toDegrees(angleEntreDeuxPoints (p, a, b)) == 180)|| (Math.toDegrees(angleEntreDeuxPoints(p, a, b))==360)) {
            System.out. println ( " point colinéaire au segment " );
            return appartenance = 0 ;
        }
        if ( ((Math.toDegrees(angleEntreDeuxPoints (p, a, b))) > 0) && ((Math.toDegrees (angleEntreDeuxPoints (p, a, b))) < 180)) {
            System.out. println ( " point positif par rapport à segment " );
            return appartenance = 1 ;
        }
        if ( ((Math.toDegrees (angleEntreDeuxPoints (p, a, b))) > 180)&&((Math.toDegrees (angleEntreDeuxPoints (p,a,b))) < 360 )) {
            System.out. println ( " point négatif par rapport à segment " );
            return appartenance = - 1 ;
        }
        else{
            return appartenance=2;
        }
        //System.out.println(appartenance);

    } 
   
   
    //même méthode mais en normal
    public double verifPointDansTerrain ( PointTerrain  p) {

        double appartenance;
        if (( Math.toDegrees(angleEntreDeuxPoints (p, this.pT1, this.pT2)) ==  0  )|| ((Math.toDegrees(angleEntreDeuxPoints (p, this.pT1, this.pT2)) )== -180)  ||( Math.toDegrees(angleEntreDeuxPoints (p, this.pT1, this.pT2)) == 180)) {
            // c'est ça la sythaxe?
            appartenance = 0 ;
            System.out. println ( " point colinéaire au segment " );
        }
        if ( ((Math.toDegrees(angleEntreDeuxPoints (p, this.pT1, this.pT2))) > 0) && ((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) == 0)&&((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) == 180 )&&((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) < 180 )) {
            appartenance = 1 ;
            System.out. println ( " point positif par rapport à segment " );
        }
        if ( ((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) > 180)&&((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) == 360 )&&((Math.toDegrees (angleEntreDeuxPoints (p, this.pT1, this.pT2))) < 360 )) {
            appartenance = - 1 ;
            System.out. println ( " point négatif par rapport à segment " );
        }
        else{
            appartenance=2;
        }
        //System.out.println(appartenance);
        return appartenance;
    } 
    
     //méthode permettant de savoir si un point appartient au TriangleTerrain
    public static double verifNoeudsDansTerrain ( Noeuds  p , PointTerrain  a , PointTerrain  b) {

        double appartenance;
        if (( Math.toDegrees(angleEntreNoeudPoints (p, a, b)) ==  0  )|| ((Math.toDegrees(angleEntreNoeudPoints (p, a, b)) )== -180)  ||( Math.toDegrees(angleEntreNoeudPoints (p, a, b)) == 180)|| (Math.toDegrees(angleEntreNoeudPoints(p, a, b))==360)) {
            System.out. println ( " point colinéaire au segment " );
            return appartenance = 0 ;
        }
        if ( ((Math.toDegrees(angleEntreNoeudPoints (p, a, b))) > 0) && ((Math.toDegrees (angleEntreNoeudPoints (p, a, b))) < 180)) {
            System.out. println ( " point positif par rapport à segment " );
            return appartenance = 1 ;
        }
        if ( ((Math.toDegrees (angleEntreNoeudPoints (p, a, b))) > 180)&&((Math.toDegrees (angleEntreNoeudPoints (p,a,b))) < 360 )) {
            System.out. println ( " point négatif par rapport à segment " );
            return appartenance = - 1 ;
        }
        else{
            return appartenance=2;
        }
        //System.out.println(appartenance);
    }
    
    //même méthode mais en normal et noeud
    public double verifNoeudDansTerrain ( Noeuds  p) {

        double appartenance;
        if (( Math.toDegrees(angleEntreNoeudPoints (p, this.pT1, this.pT2)) ==  0  )|| ((Math.toDegrees(angleEntreNoeudPoints (p, this.pT1, this.pT2)) )== -180)  ||( Math.toDegrees(angleEntreNoeudPoints (p, this.pT1, this.pT2)) == 180)) {
            // c'est ça la sythaxe?
            appartenance = 0 ;
            System.out. println ( " point colinéaire au segment " );
        }
        if ( ((Math.toDegrees(angleEntreNoeudPoints (p, this.pT1, this.pT2))) > 0) && ((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) == 0)&&((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) == 180 )&&((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) < 180 )) {
            appartenance = 1 ;
            System.out. println ( " point positif par rapport à segment " );
        }
        if ( ((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) > 180)&&((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) == 360 )&&((Math.toDegrees (angleEntreNoeudPoints (p, this.pT1, this.pT2))) < 360 )) {
            appartenance = - 1 ;
            System.out. println ( " point négatif par rapport à segment " );
        }
        else{
            appartenance=2;
        }
        //System.out.println(appartenance);
        return appartenance;
    } 

    //booléen si point est dans TriangleTerrain ou non
    public boolean appartenanceTerrain (PointTerrain p) { 

        //Encore un test de méthode, pas utilisée pour l'instant, pas encore fonctionnelle
        PointTerrain a=this.pT1;
        PointTerrain b=this.pT2;
        PointTerrain c=this.pT3;
       // PointTerrain p =  new  PointTerrain (abs, ord);//Variables non initialisés

        double appartenance1 = verifPointDansTerrain(p, a, b); //apb
        double appartenance2 = verifPointDansTerrain(p, b, c); //bpc
        double appartenance3 = verifPointDansTerrain(p, c, a); //cpa

        if ( (appartenance1==1)&& (appartenance2==1)&& (appartenance3==1)){
            return true;
        } 
        if ( (appartenance1==-1)&& (appartenance2==-1)&& (appartenance3==-1)){
            return true;
        } 
        else{
            return false;
        }

    }
    
     //booléen si point est dans TriangleTerrain ou non
    public boolean appartenanceTerrainNoeuds (Noeuds p) { 

        //Encore un test de méthode, pas utilisée pour l'instant, pas encore fonctionnelle
        PointTerrain a=this.pT1;
        PointTerrain b=this.pT2;
        PointTerrain c=this.pT3;
       // PointTerrain p =  new  PointTerrain (abs, ord);//Variables non initialisés

        double appartenance1 = verifNoeudsDansTerrain (p, a, b); //apb
        double appartenance2 = verifNoeudsDansTerrain (p, b, c); //bpc
        double appartenance3 = verifNoeudsDansTerrain (p, c, a); //cpa

        if ( (appartenance1==1)&& (appartenance2==1)&& (appartenance3==1)){
            return true;
        } 
        if ( (appartenance1==-1)&& (appartenance2==-1)&& (appartenance3==-1)){
            return true;
        } 
        else{
            return false;
        }

    }

    public static boolean appartenanceTerrain (PointTerrain a, PointTerrain b, PointTerrain c, PointTerrain p) { 

        //pas encore fonctionnel comme il faut, dit si point appartient au TriangleTerrain

        double appartenance1 = verifPointDansTerrain(p, a, b); //apb
        double appartenance2 = verifPointDansTerrain(p, b, c); //bpc
        double appartenance3 = verifPointDansTerrain(p, c, a); //cpa

        if ( (appartenance1==1)&& (appartenance2==1)&& (appartenance3==1)){
            return true;
        } 
        if ( (appartenance1==-1)&& (appartenance2==-1)&& (appartenance3==-1)){
            return true;
        } 
        if ( ((appartenance1==0)|| appartenance2==0 || appartenance3==0)&& ((appartenance1==1) ||(appartenance2==1)||(appartenance3==1))){
            return true;
        }
        if ( ((appartenance1==0)|| appartenance2==0 || appartenance3==0)&& ((appartenance1==-1) ||(appartenance2==-1)||(appartenance3==-1))){
            return true;
        }
        if( (appartenance1==0|| appartenance2==0 || appartenance3==0) && ((appartenance1==-1) ||(appartenance2==-1)||(appartenance3==-1)) && ((appartenance1==1) ||(appartenance2==1)||(appartenance3==1))){
            return false;
        } //cas où un positif, un négatif et un colinéaire cf screen !!!à revoir marche pas 
        else{
            return false;
        }//dire quand c'est sur segment, ou point confondu avec un point du triangle

    }
    
    public static boolean appartenanceTerrainTNoeuds (PointTerrain a, PointTerrain b, PointTerrain c, Noeuds p) { 

        //pas encore fonctionnel comme il faut, dit si point appartient au TriangleTerrain

        double appartenance1 = verifNoeudsDansTerrain(p, a, b); //apb
        double appartenance2 = verifNoeudsDansTerrain(p, b, c); //bpc
        double appartenance3 = verifNoeudsDansTerrain(p, c, a); //cpa

        if ( (appartenance1==1)&& (appartenance2==1)&& (appartenance3==1)){
            return true;
        } 
        if ( (appartenance1==-1)&& (appartenance2==-1)&& (appartenance3==-1)){
            return true;
        } 
        if ( ((appartenance1==0)|| appartenance2==0 || appartenance3==0)&& ((appartenance1==1) ||(appartenance2==1)||(appartenance3==1))){
            return true;
        }
        if ( ((appartenance1==0)|| appartenance2==0 || appartenance3==0)&& ((appartenance1==-1) ||(appartenance2==-1)||(appartenance3==-1))){
            return true;
        }
        if( (appartenance1==0|| appartenance2==0 || appartenance3==0) && ((appartenance1==-1) ||(appartenance2==-1)||(appartenance3==-1)) && ((appartenance1==1) ||(appartenance2==1)||(appartenance3==1))){
            return false;
        } //cas où un positif, un négatif et un colinéaire cf screen !!!à revoir marche pas 
        else{
            return false;
        }//dire quand c'est sur segment, ou point confondu avec un point du triangle

    }
   
    public  boolean  verifUniciteTroisPoints () {

        if (( this . getPT1 () == this . getPT2 ()) && (this . getPT1 () == this . getPT3 ())) {

            System.out.println( " Les 3 points sont confondus " );
            return  false ;
        }
        else {

            return  true ; // il y a unicité des 3 points
        }

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
            } else{
                surSegment= false;
            }
        } else {
            surSegment= false;
        }   
        return surSegment;
    }
   
    
    public boolean verifNoeudDansTerrainSurLesBords(Noeuds N){
        boolean surLesBords;
        if (appartenanceTerrainNoeuds(N) == true && (verifNoeudsDansTerrain(N,this.getPT1(),this.getPT2())== 0 || verifNoeudsDansTerrain(N,this.getPT2(),this.getPT3())== 0 || verifNoeudsDansTerrain(N,this.getPT3(),this.getPT1())== 0)){
            surLesBords = true;
            //le noeud est sur un des trois bords
        } else{
            surLesBords = false;
            //le noeud n'est pas sur un des 3 bords
        }
        return surLesBords;
    }
    
    public boolean verifNoeudPasDansTerrainSurLesBords(Noeuds N){
        boolean surLesBordsPasDansTerrain;
        if (appartenanceTerrainNoeuds(N) == true && (verifNoeudsDansTerrain(N,this.getPT1(),this.getPT2())== 0 || verifNoeudsDansTerrain(N,this.getPT2(),this.getPT3())== 0 || verifNoeudsDansTerrain(N,this.getPT3(),this.getPT1())== 0)){
            surLesBordsPasDansTerrain = true;
            //le noeud est sur un des trois bords
        } else{
            surLesBordsPasDansTerrain = false;
            //le noeud n'est pas sur un des 3 bords
        }
        return surLesBordsPasDansTerrain;
    }


}
    
