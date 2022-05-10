/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;

//import static com.mycompany.projetsemestre2.Matrice.test3;


import static liautardclotilde.projettreillis.Projet_Treillis.getlisteAD;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteAS;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteBarre;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteNS;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteNoeuds;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteTT;
import static liautardclotilde.projettreillis.Projet_Treillis.test;


//import static JFrame.NewBarre.getListeBarre;
//import static Interface.NewNoeuds.NbrAppuiDouble;
//import static Interface.NewNoeuds.NbrAppuiSimple;
//import static Interface.NewNoeuds.getListeNoeuds;

/**
 *
 * @author sabin
 */
public class Prog_Pricipal 
{
    public static void main(String[] args)
    {
       /* double a;
        System.out.println("saisir le nb de ligne");
        int nl=Lire.i();
        System.out.println("saisir le nb de colonne");
        int nc=Lire.i();
        Matrice m=new Matrice(nl,nc);
        
        for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                System.out.println("Saisir le coeff  "+(i+1)+";"+(j+1));
                a=Lire.d();
                m.set(i,j,a);
            }
        }
        
        for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                System.out.print(m.get(i,j)+"  ");
                 
            }
            System.out.println("");
        }
        Matrice b =new Matrice(nl,nc);
        b.creeVecteur(nc);
       double k;
        for(int j=0;j<nc;j++)
        {
            System.out.println("Saisir le coeff  "+(j+1)+";"+1);
            k=Lire.d();
            b.set(j,0,k);
        }
        for(int j=0;j<nl;j++)
        {
            //System.out.print(b.get(j,1)+"  ");
            System.out.print(b.get(j,0)+"  ");
        }
        test4(m,b,nl,nc);*/
        
        ////////////////////////
        
        /*System.out.println("nb de noeud  ");
        int nbNoeud=getListeNoeuds().size();
        int nc =getListeBarre().size();
        Matrice c =new Matrice(2*nbNoeud,nc+2*NbrAppuiDouble()+NbrAppuiSimple());
        c.creeVecteur(nc+2*NbrAppuiDouble()+NbrAppuiSimple());
      
        for(int j=0;j<nc+2*NbrAppuiDouble()+NbrAppuiSimple();j++)
        {
            c.set(j,0,0);
        }
        double force =1000;
                
        //creeMatrice(getListeNoeuds(), getListeBarre(), force);
        test4(creeMatrice(listeNoeuds, listeBarre, force),c,2*nbNoeud,nc+2*NbrAppuiDouble()+NbrAppuiSimple());*/
        Terrain Tb= new Terrain (0.5,4.0,-5.0,1.0);
        PointTerrain PT1=new PointTerrain(0.0,-6.0,0);
        PointTerrain PT2=new PointTerrain(0.0,2.0,1);
        PointTerrain PT3=new PointTerrain(-3.0,2.0,2);
        TriangleTerrain Ta= new TriangleTerrain(PT1,PT2,PT3,1);
        getlisteTT().add(Ta);
        
        //Noeuds na =new Appui_Double(0,Ta,PT1,0.75);
        //Noeuds nb =new Appui_Simple(1,Ta,PT1,0.25);
        Noeuds na =new Appui_Double(0,Ta,0,2);
        Noeuds nb =new Appui_Simple(1,Ta,0,0);
        Noeuds nc =new Noeud_Simple(2,1,1);
        getlisteNoeuds().add(na);
        getlisteNoeuds().add(nb);
        getlisteNoeuds().add(nc);
        
        getlisteAD().add(na);
        getlisteAS().add(nb);
        getlisteNS().add(nc);
        Catalogue_Barre ca=new Catalogue_Barre();
        //ca.getCatalogueBarre();
        
        //(Noeuds Noeudi,Noeuds Noeudf, int nom, Catalogue_Barre C, int numero)
        Barre ba= new Barre(na,nc,0,ca.getCatalogueBarre(),0);
        Barre bb= new Barre(nb,nc,1,ca.getCatalogueBarre(),0);
        Barre bc= new Barre(na,nb,2,ca.getCatalogueBarre(),0);
        getlisteBarre().add(ba);
        getlisteBarre().add(bb);
        getlisteBarre().add(bc);
        test();
    }
    
}
