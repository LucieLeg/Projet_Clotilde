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
public class Terrain {
    
    private  double xMin;
    private  double xMax;
    private  double yMin;
    private  double yMax;
    
    public Terrain (double xMin,double xMax,double yMin,double yMax){
        this.xMin=xMin;
        this.xMax=xMax;
        this.yMin=yMin;
        this.yMax=yMax;
    }
    
    public String toString (){
        return "Terrain: ( X:("+xMin+"<"+xMax+"); Y:("+yMin+"<"+yMax+") )";
    }
    
    public double getxMin (){
        return this.xMin;
    }
    public double getxMax (){
        return this.xMax;
    }
    public double getyMin (){
        return this.yMin;
    }
    public double getyMax (){
        return this.yMax;
    }
    
    public void setxMin (double xMin){
        this.xMin=xMin;
    }
    public void setxMax (double xMax){
        this.xMax=xMax;
    }
    public void setyMin (double yMin){
        this.yMin=yMin;
    }
    public void setyMax (double yMax){
        this.yMax=yMax;
    }
}  

    


    

