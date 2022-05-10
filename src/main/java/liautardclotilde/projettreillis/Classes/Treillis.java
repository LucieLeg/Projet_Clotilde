/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

import java.util.ArrayList;
import static liautardclotilde.projettreillis.Classes.Barre.verification_unicite;

/**
 *
 * @author Clotilde
 */
public class Treillis {
    
    private Terrain T;
    private ArrayList<TriangleTerrain> E_TT;
    private ArrayList<Noeuds> E_Noeuds; //E=Ensemble 
    private ArrayList<Barre> E_Barre;
    private Catalogue_Barre E_TypeBarre;//(Surement un fichier) ... 
    
    public Treillis (Terrain T, ArrayList<Noeuds> E_Noeuds, ArrayList<Barre> E_Barre ,ArrayList<TriangleTerrain> E_TT, Catalogue_Barre E_TypeBarre){
        this.T=T;
        this.E_TT=E_TT;
        this.E_Barre=E_Barre;
        this.E_Noeuds=E_Noeuds;
        this.E_TypeBarre=E_TypeBarre;
    }
    
    //Encapsulation 
    public Terrain getTerrain (){
        return this.T;
    }
    public ArrayList<TriangleTerrain> getE_TT (){
        return this.E_TT;
    }
    public ArrayList<Noeuds> getE_Noeuds (){
        return this.E_Noeuds;
    }
    public ArrayList<Barre> getE_Barre (){
        return this.E_Barre;
    }
    public Catalogue_Barre getE_TyperBarre (){
        return this.E_TypeBarre;
    }
    
    //méthode pour vérifier le type de chaque barre du treillis appartient au catalogue de barres du treillis.
    public int verification_typebarre_barre () {  
      int k=0;
        for (int i=0;i<this.E_Barre.size();i++){
            for (int j=0;j<this.E_TypeBarre.getEnsemble_TypeBarre().size();j++){
                if (this.E_Barre.get(i).gettype()==this.E_TypeBarre.getEnsemble_TypeBarre().get(j)){
                    k=k+1;   
                }
            }
        }
        if (k==this.E_Barre.size()){
            return 1;
        }else{
            return 0;
        }   
}
    //méthode pour vérifier les noeuds associés aux barres appartiennent à l’ensemble des noeuds du treillis.
    public int verification_barre_noeuds (){
        int k=0;
        for (int i=0;i<this.E_Barre.size();i++){
            for (int j=0;j<this.E_Noeuds.size();j++){
                for (int h=0;h<this.E_Noeuds.size();h++){
                    if (h!=j){
                        if ((this.E_Barre.get(i).getNoeudf()==this.E_Noeuds.get(j))&&(this.E_Barre.get(i).getNoeudi()==this.E_Noeuds.get(h))){
                            k=k+1;  
                        }
                    }
                }
            }
        }
        if (k==this.E_Barre.size()){
            return 1;
        }else{
            return 0;
        }
    }
    //méthode qui vérifie il ne peut y avoir qu’au plus une barre reliant deux noeuds donnés (Méthode Vérification Unicité Barre)
    public int verification_unicite_barre (){
        int k=0;
        for (int i=0;i<this.E_Barre.size();i++){
            for (int j=0;i<this.E_Barre.size();i++){
                if (j!=i){
                    if (verification_unicite(this.E_Barre.get(i), this.E_Barre.get(j))==0) {
                        k=k+1;
                    }
                }
            }
        }
        if (!(k==0)){//il y a au moins 2 barres pareils 
            return 0;//
        }else{
            return 1;
        }
    }
    
    //tous les noeuds appuis sont associé à un segment de terrain appartenant à un triangle terrain du treilli
    public int verification_unicite_NA (){
        int k=0;
        int verif=0;
        for (int i=0;i<this.E_Noeuds.size();i++){
            if (this.E_Noeuds.get(i).getClass()==Appui_Double.class){
                verif=verif+1;
                for (int j=0;j<this.E_TT.size();j++){
                    if (this.E_Noeuds.get(i).getTT()==this.E_TT.get(j)){
                        k=k+1;
                    }
                }
            }
            if (this.E_Noeuds.get(i).getClass()==Appui_Simple.class){
                verif=verif+1;
                for (int j=0;j<this.E_TT.size();j++){
                    if (this.E_Noeuds.get(i).getTT()==this.E_TT.get(j)){
                        k=k+1;
                    }
                }
            }
        }
        if (verif==k){
            return  1; 
        }else{
            return 0;
        }
    }


    //méthode Vérification complète du Treilli 
    public boolean verification_treillis (){
        if ((this.verification_unicite_barre()==0)||(this.verification_barre_noeuds()==0)||(this.verification_typebarre_barre ()==0)||(this.verification_unicite_NA()==0)){
            return false;  
        }else{
            return true;
        }
    }
    
    
}

 

    
