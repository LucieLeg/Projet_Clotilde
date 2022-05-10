/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

import java.util.ArrayList;

/**
 *
 * @author Elève
 */
public class Catalogue_Barre {
    
    static ArrayList<TypeBarre > Ensemble_TypeBarre = new ArrayList ();
    
    /*Type section:
    1: Rond
    10:Rond creux
    2: Rectangle
    20:Rectangle creux
    22:Section forme L (x2 rectangle)
    222:Section forme I (x3 rectangle)
    */
    
    /*Attributs TypeBarre:
    private String nom;
    private int section;
    private double Lmax;
    private double Lmin;
    private double Rtmax;
    private double Rcmax;
    */
    
    /*Cout par unité de longueur:
    1: 1,5 | 100
    10: 2 | 80,5
    2: 2,2 | 200
    20: 4,5 | 270
    22: 4 | 250
    222: 5,3 | 400
    */
    
    public ArrayList<TypeBarre > getEnsemble_TypeBarre () {
        return this.Ensemble_TypeBarre;
    }
    
    public void setCatalogue_Barre (ArrayList<TypeBarre > TBarre){
        this.Ensemble_TypeBarre=TBarre;
    }
    
    public Catalogue_Barre getCatalogueBarre() {
        return this;
    }
    
    public Catalogue_Barre (ArrayList<TypeBarre > TBarre){
        this.Ensemble_TypeBarre=TBarre;
    }
    
    public Catalogue_Barre (){
        
        ArrayList<TypeBarre > EnsTB=new ArrayList();
        this.Ensemble_TypeBarre=EnsTB;
        TypeBarre R=new TypeBarre(1, 10.5,200,0,3500,4800);//1
        TypeBarre R0=new TypeBarre(2, 20,200,0,4500,5800);//10
        TypeBarre Rt=new TypeBarre(3, 20.2,200,0,4500,6800);//2
        TypeBarre Rt0=new TypeBarre(4, 40.5,200,0,6500,7400);//20
        TypeBarre RtL=new TypeBarre(5, 40,200,0,6500,6800);//22
        TypeBarre RtI=new TypeBarre(6, 50.3,200,0,7500,7800);//222
        this.Ensemble_TypeBarre.add(R);
        this.Ensemble_TypeBarre.add(R0);
        this.Ensemble_TypeBarre.add(Rt);
        this.Ensemble_TypeBarre.add(Rt0);
        this.Ensemble_TypeBarre.add(RtL);
        this.Ensemble_TypeBarre.add(RtL);
        /*this.Ensemble_TypeBarre[1]= R0;
        this.Ensemble_TypeBarre[2]= Rt;
        this.Ensemble_TypeBarre[3]= Rt0;
        this.Ensemble_TypeBarre[4]= RtL;
        this.Ensemble_TypeBarre[5]= RtI;*/
    }
    
    public static void Afficher_Catalogue_Barre (Catalogue_Barre C){
        for (int i=0;i<C.Ensemble_TypeBarre.size();i++){
            if (!(C.Ensemble_TypeBarre.get(i)== null)){
                System.out.println(i+":"+C.Ensemble_TypeBarre.get(i).getnom()+"( coût: "+C.Ensemble_TypeBarre.get(i).getcout()+"; Longueur min: "+C.Ensemble_TypeBarre.get(i).getLmin()+"; Longueur max: "+C.Ensemble_TypeBarre.get(i).getLmax()+"; Résistance Tension max: "+C.Ensemble_TypeBarre.get(i).getRtmax()+"; Résistance Compression max: "+C.Ensemble_TypeBarre.get(i).getRcmax());
            }
        }
    }
    //public Catalogue_Barre getCatalogueBarre(){
       // return this;
    //}
    //Toujours de façon intuitive, on pressent que si le profil de la barre est en ”I”, elle résistera mieux qu’une barre
    //de section rectangulaire, surtout si le rectangle est ”aplati” dans la mauvaise direction
}
