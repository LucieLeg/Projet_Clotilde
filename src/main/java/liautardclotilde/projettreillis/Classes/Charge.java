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
public class Charge {
    
    private int nom;
    private double module;
    private Noeuds application;
    private double alpha; //angle charge
    
    public Charge (int nom, double module, Noeuds N, double alpha){
        this.nom=nom;
        this.module=module;
        this.application=N;
        this.alpha=alpha;
    }  
    
}
