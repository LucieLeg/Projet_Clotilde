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
public class TypeBarre {
    
    //attributs
    private int nom;
    private double cout; //double cout
    private double Lmax;
    private double Lmin;
    private double Rtmax;
    private double Rcmax;
    
    //Ecrire diff- type par rapport au section 
    
    //Constructeur
    public TypeBarre (int nom, double cout, double Lmax, double Lmin, double Rtmax, double Rcmax){
        this.nom=nom;
        this.cout= cout;
        this.Lmax=Lmax;
        this.Lmin=Lmin;
        this.Rtmax=Rtmax;
        this.Rcmax=Rcmax;
    }
    
    public String toString (){
        return this.nom+": ( coût: "+this.cout+"; Longueur min: "+this.Lmin+"; Longueur max: "+this.Lmax+"; Résistance Tension max: "+this.Rtmax+"; Résistance Compression max: "+this.Rcmax;
    }
    
    //Encapsulations 
    public double getcout(){
        return this.cout;
    }
    public double getLmax(){
        return this.Lmax;
    }
    public int getnom(){
        return this.nom;
    }
    public double getLmin(){
        return this.Lmin;
    }
    public double getRtmax(){
        return this.Rtmax;
    }
     public double getRcmax(){
        return this.Rcmax;
    }
    
    public void setcout (double cout){
        this.cout=cout;
    }
    public void setLmax (double Lmax){
        this.Lmax=Lmax;
    }
    public void setnom (int nom){
        this.nom = nom;
    }
    public void setLmin (double Lmin){
        this.Lmin=Lmin;
    }
    public void setRtmax (double Rtmax){
        this.Rtmax = Rtmax;
    }
    public void setRcmax (double Rcmax){
        this.Rcmax = Rcmax;
    }
   
}
