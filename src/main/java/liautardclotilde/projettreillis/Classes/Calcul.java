/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package liautardclotilde.projettreillis.Classes;

import static liautardclotilde.projettreillis.Classes.Matrice.resolutionGauss;
import static liautardclotilde.projettreillis.Classes.TriangleTerrain.appartenanceTerrain;
import static liautardclotilde.projettreillis.Classes.TriangleTerrain.appartenanceTerrainTNoeuds;
import static liautardclotilde.projettreillis.Classes.TriangleTerrain.verifNoeudsDansTerrain;
import static liautardclotilde.projettreillis.Projet_Treillis.getT;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteBarre;
import static liautardclotilde.projettreillis.Projet_Treillis.getlisteNoeuds;




/**
 *
 * @author sabin
 */
public abstract class Calcul{ //extends Treillis{
    
    //--------méthode permettant de calculer l'angle formé par 2 noeuds donnés --------   
    public static double angleEntreTroisNoeuds( Noeuds noeudi, Noeuds noeudf) {


          //le noeud fixé et un noeud qui est sur la même ordonnee que le noeud pour lequel on cherche les tensions mais a une autre abscisse pour pouvoir calculer l'angle sur une barre horizontal
          Noeuds p = new Noeud_Simple(noeudi.getabscisse()+1, noeudi.getordonne(),20);
      
           double angle1 = Math.atan2(p.getordonne()- noeudi.getordonne(), p.getabscisse() - noeudi.getabscisse());
           //System.out.println("angle 1 "+ Math.toDegrees(angle1));
           double angle2 = Math.atan2(noeudf.getordonne() - noeudi.getordonne(), noeudf.getabscisse() - noeudi.getabscisse());
           //System.out.println("angle 2 "+ Math.toDegrees(angle2));
           double angle= angle2-angle1;
           
  
          // System.out.println("angle rad "+ angle);
           
          //test des angles pour voir si les valeurs sont bonnes (notamment les signes hors de la matrice
           //System.out.println("angle cos "+ Math.cos(angle));
           //System.out.println("angle sin "+ Math.sin(angle));

            //System.out.println("angle deg "+ Math.toDegrees(angle));
        return angle;
        //}

    }//fin méthode angleEntreTroisNoeuds
    //---------méthode non utilisé, c'était un test de calculé le sin directement dans la méthode et de renvoyé la bonne valeur dans la matrice, mais le problème de signe etait toujours présent (j'avais fait une méthode similaire avec cos)
    public static double angleEntreTroisNoeudsS( Noeuds noeudi, Noeuds noeudf) 
    {
 
        Noeuds p = new Noeud_Simple(noeudi.getabscisse()+1, noeudi.getordonne(),20);

         double angle1 = Math.atan2(p.getordonne()- noeudi.getordonne(), p.getabscisse() - noeudi.getabscisse());
         //System.out.println("angle 1 "+ Math.toDegrees(angle1));
         double angle2 = Math.atan2(noeudf.getordonne() - noeudi.getordonne(), noeudf.getabscisse() - noeudi.getabscisse());
         //System.out.println("angle 2 "+ Math.toDegrees(angle2));
         double angle= angle2-angle1;

        // System.out.println("angle rad "+ angle);

         //System.out.println("angle cos "+ Math.cos(angle));
         //System.out.println("angle sin "+ Math.sin(angle));

          //System.out.println("angle deg "+ Math.toDegrees(angle));
        return Math.sin(angle);

    }//fin méthode angleEntreTroisNoeudsS
    
    
        //donne angle entre un point et un noeud statique:
    public static double angleEntreNoeudPoint(Noeuds p, PointTerrain a)
    {

        PointTerrain b = new PointTerrain(a.getPx()+1, a.getPy(),20);
        double angle1 = Math.atan2(p.getordonne() - a.getPy(), p.getabscisse() - a.getPx());
        double angle2 = Math.atan2(p.getordonne() - b.getPy(), p.getabscisse() - b.getPx());
        double angle= angle2-angle1;

        //System.out.println(Math.toDegrees(angle));
        return angle ;
    } // fin méthode angleEntreNoeudPoint
    
    public static double angleEntreNoeudPoints(Noeuds p, PointTerrain a, PointTerrain b) 
    {
        double angle1 = Math.atan2(p.getordonne() - a.getPy(), p.getabscisse() - a.getPx());
        double angle2 = Math.atan2(p.getordonne() - b.getPy(), p.getabscisse() - b.getPx());
        double angle= angle2-angle1;
   
        //System.out.println(Math.toDegrees(angle));
        return angle ;
    } 
    
    //on assemble les projections sur x et y
    public static Matrice concatLig(Matrice m1,Matrice m2) 
    {
        if (m1.getNbrCol() != m2.getNbrCol()) {
            throw new Error("les matrices doivent avoir même nombre de colonnes");
        }
    
        Matrice res = new Matrice(m1.getNbrLig() + m2.getNbrLig(), m1.getNbrCol());
        for (int i = 0; i < res.getNbrLig(); i++) {
            for (int j = 0; j < res.getNbrCol(); j++) {
                if (i < m1.getNbrLig()) {
                    res.set(i, j, m1.get(i, j));
                } else {
                    res.set(i, j, m2.get(i - m1.getNbrLig(), j));
                }
            }
        }
        return res;
    }//fin méthode concatLig
    
    public static boolean VerifNoeudPointSurSegment (Noeuds n,PointTerrain p1,PointTerrain p2){
        boolean surSegment=false;
        if ( ( Math.toDegrees (angleEntreNoeudPoints (n,p1,p2)) ==  0 ) || (Math.toDegrees(angleEntreNoeudPoints (n,p1,p2))== -180) ||( Math.toDegrees(angleEntreNoeudPoints (n,p1,p2)) == 180) || (Math.toDegrees(angleEntreNoeudPoints(n,p1,p2))==360)) {
            surSegment=true;
        }
        return surSegment;
    }
    
    public static PointTerrain trouveUnPoint(Noeuds N){
        PointTerrain P = new PointTerrain();
        if (N.getTT().verifNoeudDansTerrainSurLesBords(N)==true){
            if(verifNoeudsDansTerrain(N,N.getTT().getPT1(),N.getTT().getPT2())==0){
                P=N.getTT().getPT1();
            }
            if(verifNoeudsDansTerrain(N,N.getTT().getPT2(),N.getTT().getPT3())==0){
                P=N.getTT().getPT2();
            }
            if(verifNoeudsDansTerrain(N,N.getTT().getPT3(),N.getTT().getPT1())==0){
                P=N.getTT().getPT3();
            }
        }        
        return P;       
    }
    //-----méthode permettant de trouver un point perpendiculaire à une droite (composé d'un noeud et d'un point terrain)--> elle permettra de calculer la réaction pour les noeuds simples
    public static PointTerrain coeffdirPerpendiculaire(PointTerrain p, Noeuds n, TriangleTerrain t)
    {

        //on cherche un point de le terrain
        for (double i=getT().getxMin();i<getT().getxMax();i++){
            for (double j=getT().getyMin();j<getT().getyMax();j++){
                PointTerrain p3= new PointTerrain(i,j,100);

                if (appartenanceTerrain(t.getPT1(),t.getPT2(),t.getPT3(),p3)==true)//normalement toujours true
                 {
                     //on calcule l'équation de la droite entre le point donné et le noeud donné à l'entrée de la méthode
                     double coefDir1 = 0f;
                     float absOr1 = 0f;
                     coefDir1=(float)((p.getPy()-n.getordonne())/p.getPx()-n.getabscisse());
                     absOr1 = (float) ((n.getordonne()-(n.getabscisse()*coefDir1))/20f);
                     //équation de la droite :y=coefDir1x+ absOr1
                     //on calcul l'équation de la droite perpendiculaire qui passe par p3 de la droite trouvée précédement 
                     double coefDir2 = 0f;
                     double absOr2 = 0f;
                     coefDir2 = (float) (-1 / coefDir1);
                      absOr2 = (float) ((p3.getPy() - (p3.getPx() * coefDir2)) / 20f);
                     //PointTerrain p4= new PointTerrain(101,coefDir2*1,coefDir2*1+absOr2); //peut ne pas marcher si ce point est dans un triangle de terrain

                     //on créé un noeud qui appartient à la droite perpendiculaire
                     Noeuds n4= new Noeud_Simple(coefDir2*getT().getxMin(),coefDir2*getT().getxMin()+absOr2,100); //pour faire la condition si le point crée est dans une triangle de terrain
                     for (double k=getT().getxMin();k<getT().getxMax();k++){
                         //on test si il apppatient à un triangle de terrain
                         //si c'est le cas on en cherche un autre
                         while (appartenanceTerrainTNoeuds(t.getPT1(),t.getPT2(),t.getPT3(),n4)==true)
                         {
                             Noeuds n5= new Noeud_Simple(coefDir2*k,coefDir2*k+absOr2,101);
                             continue;
                         }
                         //le noeud n'appartient pas un un terrain il ne peut donc pas rester un noeud, on le transforme en point terrain
                         PointTerrain p4= new PointTerrain(coefDir2*k,coefDir2*k+absOr2,101) ;
                         return p4;
                     }
                }//fin if
                return p3;

            }//fin for j
        }//fin for i
        return p;

    } 
        
    //projection sur x
    public static Matrice ProjX (){

        
        Matrice m = new Matrice (getlisteNoeuds().size(),2*getlisteNoeuds().size());
        
        //projection des tensions des barres sur x
        //on fait le tour des noeuds (lignes de la matrice) et des barres colonnes de la matrice
        for(int i=0;i<getlisteNoeuds().size();i++)
        {
            for(int j=0;j<getlisteBarre().size();j++) 
            {
                //si le noeud trouvé appartient à une basse
                if (getlisteNoeuds().get(i)==getlisteBarre().get(j).getNoeudi()||getlisteNoeuds().get(i)==getlisteBarre().get(j).getNoeudf())
                {
                    //cas on le cos est positif, le noeud cherché à une abscisse inférieur au 2e noeud de la barre
                    if (getlisteNoeuds().get(i).getabscisse()<getlisteBarre().get(j).getNoeudf().getabscisse()||getlisteNoeuds().get(i).getabscisse()<getlisteBarre().get(j).getNoeudi().getabscisse()){

                        m.set(i, j,Math.cos(angleEntreTroisNoeuds(getlisteBarre().get(j).getNoeudi(),getlisteBarre().get(j).getNoeudf())));
                    }
                    //cas on le cos est négatif
                    if (getlisteNoeuds().get(i).getabscisse()>getlisteBarre().get(j).getNoeudf().getabscisse()||getlisteNoeuds().get(i).getabscisse()>getlisteBarre().get(j).getNoeudi().getabscisse()){
                        m.set(i, j,Math.cos(angleEntreTroisNoeuds(getlisteBarre().get(j).getNoeudi(),getlisteBarre().get(j).getNoeudf())));
                        //System.out.println("//////////+++++++");   -->verification que la méthoe passe bien par là
                    }
                    if (getlisteNoeuds().get(i).getabscisse()==Math.cos(Math.PI)){
                        m.set(i,j,-1); 
                    }
                }else{
                    
                    m.set(i,j,0);
                }   
            }
        }
        
        //réaction normal au terrain pour les appuis simples !!le terrain peut être vertical ou horizontal
        //calcul des réactions
        int k=getlisteBarre().size();
        for (int i=0;i<getlisteNoeuds().size();i++)
        {
             
           //un appui double à 2 inconnues pour sur x et y pour la réaction normal, un appui simple n'en a qu'un
            //réaction des appuis simples
            if (getlisteNoeuds().get(i).getClass()==Appui_Simple.class)
            {

                //System.out.println("///////"); --> verification que la méthode passe bien par la
               

                    //for (int k=listeBarre.size()+1;k<2*listeNoeuds.size();k++){


                        
                         //m.set(i, k,Math.cos(angleEntreNoeudPoint(getlisteNoeuds().get(i),coeffdirPerpendiculaire(trouveUnPoint(getlisteNoeuds().get(i)),getlisteNoeuds().get(i),getlisteNoeuds().get(i).getTT()))));
                          m.set(i,k,1);
                         //double coeffdir2= -1/(coeffdirPerpendiculaire(trouveUnPoint(listeNoeuds.get(i)),listeNoeuds.get(i),listeNoeuds.get(i).getTT()));

                         k++;
                         //continue;
                        /*Noeuds p1 = new Noeud_Simple(20,listeNoeuds.get(i).getabscisse()+1,listeNoeuds.get(i).getordonne());
                        if (Math.cos(angleEntreDeuxNoeuds(listeNoeuds.get(i),p1))==1||Math.cos(angleEntreTroisNoeuds(listeNoeuds.get(i),p1))==-1){
                            m.set(i, k, 1);    
                        }else{
                            System.out.println("///////!!!!!");
                           m.set(i, k, 0);
                        }
                        Noeuds p2 = new Noeud_Simple(1000,listeNoeuds.get(i).getabscisse(),listeNoeuds.get(i).getordonne()+1);
                        if (Math.cos(angleEntreDeuxNoeuds(listeNoeuds.get(i),p2))==0){
                            m.set(i, k, 1);
                        }else{
                            System.out.println("///////,,,,,,,,,,,,");
                           m.set(i, k, 0);
                        }*/

                        /*if (listeNoeuds.get(i)==listeBarre.get(k).getNoeudi()||listeNoeuds.get(i)==listeBarre.get(j).getNoeudf()){
                            if (Math.sin(angleEntreTroisNoeuds (listeBarre.get(k).getNoeudi(),listeBarre.get(k).getNoeudf())) == 1  ) 
                            {
                                m.set(i, j, 1);    
                            }
                            if (((Math.sin(angleEntreTroisNoeuds (listeBarre.get(k).getNoeudi(),listeBarre.get(k).getNoeudf())) )== -1)) 
                            {
                                m.set(i, j, -1); 
                            }else{
                                m.set(i, j, 0); 
                            }
                        }*/
                    //}


                //}
            }

            // réaction appui appui double

            if (getlisteNoeuds().get(i).getClass()==Appui_Double.class)
            {
                m.set(i, k, 1);
                //deux inconnues il faut donc laissé une colonne de libre oour la projection sur y
                k=k+2;    
            }
                
                
        }
        //}
        /*System.out.println("proj sur x ");
        for(int i=0;i<getlisteNoeuds().size();i++)
        {
            for(int j=0;j<2*getlisteNoeuds().size();j++)
            {
                if (m.get(i, j)<(1E-10)){
                    m.set(i, j,0);
                }
                System.out.print(m.get(i, j)+"  ");
                
            }
            System.out.println(" ");
        }*/
        return m;
    }//fin classe projX
    
    //projection sur y
    public static Matrice ProjY(){

        Matrice m = new Matrice (getlisteNoeuds().size(),2*getlisteNoeuds().size());
        for (int i=0;i<getlisteNoeuds().size();i++)
        {
           for(int j=0;j<getlisteBarre().size();j++) 
            {
                if (getlisteNoeuds().get(i)==getlisteBarre().get(j).getNoeudi()||getlisteNoeuds().get(i)==getlisteBarre().get(j).getNoeudf())
                {
                    if (getlisteNoeuds().get(i).getordonne()<getlisteBarre().get(j).getNoeudf().getordonne())//||listeNoeuds.get(i).getordonne()<listeBarre.get(j).getNoeudi().getordonne())
                    {
                    /*if(listeBarre.get(j).getNoeudi().getabscisse()==listeBarre.get(j).getNoeudf().getabscisse()){
                        m.set(i, j, 0);
                    }
                    if(listeBarre.get(j).getNoeudi().getordonne()==listeBarre.get(j).getNoeudf().getordonne()){
                        m.set(i, j, 1);
                    }*/
                     m.set(i, j, Math.sin(angleEntreTroisNoeuds(getlisteNoeuds().get(i),getlisteBarre().get(j).getNoeudf())));
                    }
                    if (getlisteNoeuds().get(i).getordonne()<getlisteBarre().get(j).getNoeudi().getordonne()){
                        
                        m.set(i, j, Math.sin(angleEntreTroisNoeuds(getlisteNoeuds().get(i),getlisteBarre().get(j).getNoeudi())));
                    }
                    if (getlisteNoeuds().get(i).getordonne()>getlisteBarre().get(j).getNoeudf().getordonne())//||listeNoeuds.get(i).getordonne()>listeBarre.get(j).getNoeudi().getordonne())
                    {
                        //ici on ne devrait pas avoir a mettre un moins devant car les valeurs sont négatives mais comme les valaeurs négatives de s'affichent pas, on a mis un moins pour voir si les valeurs étaient tout de même correctes
                        m.set(i, j,-Math.sin(angleEntreTroisNoeuds(getlisteNoeuds().get(i),getlisteBarre().get(j).getNoeudf()))); 
                    }
                    if (getlisteNoeuds().get(i).getordonne()>getlisteBarre().get(j).getNoeudi().getordonne())
                    {
                        //de même
                        m.set(i, j, -Math.sin(angleEntreTroisNoeuds(getlisteNoeuds().get(i),getlisteBarre().get(j).getNoeudi())));
                    }
                    if (getlisteNoeuds().get(i).getordonne()==Math.sin(-Math.PI/2)){
                        m.set(i,j,-1);
                    }
                }else{
                    m.set(i,j,0);
                }     
            }
        }
        //on rajoute le poids sur la projection sur y des noeuds simples
       /* for (int i=0;i<listeNoeuds.size();i++)
        {
            for (int j=0;j<listeNS.size();j++){
            if (listeNoeuds.get(i).getClass()==Noeud_Simple.class)
                //if (listeNoeuds.get(i)==listeNS.get(j))
                {
                    //la colonne listeBarre.size()  correspond a la force, on fait pas +1 car on commence à0
                    m.set(i,listeBarre.size() , force);
                }else{
                    m.set(i,listeBarre.size() , 0);
                }
            }
        }*/
        //réaction normal au terrain pour les appuis simples !!le terrain peut être vertical ou horizontal
         //on projette sur y
        int k=getlisteBarre().size(); 
        for (int i=0;i<getlisteNoeuds().size();i++)
        {

           //un appui double à 2 inconnues pour sur x et y pour la réaction normal, un appui simple n'en a qu'un
            if (getlisteNoeuds().get(i).getClass()==Appui_Simple.class){

                //System.out.println("///////");
                
                 m.set(i, k, 0);
                 //m.set(i, k,Math.sin(angleEntreNoeudPoint(getlisteNoeuds().get(i),coeffdirPerpendiculaire(trouveUnPoint(getlisteNoeuds().get(i)),getlisteNoeuds().get(i),getlisteNoeuds().get(i).getTT()))));
                 
                 k++;
            }
                
                //appui double
          
            if (getlisteNoeuds().get(i).getClass()==Appui_Double.class){
                k++;
                m.set(i, k, 1);
                
               k++; 
            }
                
        }
        /*for (int i=0;i<listeNoeuds.size();i++)
        {
           //on commelisteBarre.size()e les colonnes a partir de listeBarre.size()+2 car avant il y a les tensions et le poids
           //un appui double à 2 ilisteBarre.size()onnues pour sur x et y pour la réaction normal, un appui simple n'en a qu'un
           for(int j=listeBarre.size()+1;j<2*listeAD.size()+listeAS.size();j++) 
            {
                //if (listeNoeuds.get(i).getClass()==Appui_Simple.class){
                if (listeNoeuds.get(i)==listeAS.get(i)){
                    for (int k=0;k<listeBarre.size();k++){
                        if (listeNoeuds.get(i)==listeBarre.get(k).getNoeudi()||listeNoeuds.get(i)==listeBarre.get(k).getNoeudf()){
                            if ((Math.cos(angleEntreTroisNoeuds (listeBarre.get(k).getNoeudi(),listeBarre.get(k).getNoeudf())) == 1  ))
                            {
                                m.set(i, j, 1);    
                            }
                            if (((Math.cos(angleEntreTroisNoeuds (listeBarre.get(k).getNoeudi(),listeBarre.get(k).getNoeudf())) )== -1)) 
                            {
                                m.set(i, j, -1); 
                            }else{
                                m.set(i, j, 0); 
                            }
                        }
                    }
                }
                //if (listeNoeuds.get(i).getClass()==Appui_Double.class){
                if (listeNoeuds.get(i)==listeAD.get(i)){
                    for (int k=0;k<listeBarre.size();k++){
                        if (listeNoeuds.get(i)==listeBarre.get(k).getNoeudi()||listeNoeuds.get(i)==listeBarre.get(k).getNoeudf()){
                            m.set(i, j, 1);
                        }else{
                            m.set(i,j,0);
                        }
                    }
                }
            }
        }*/
       /* System.out.println("proj sur y ");
        for(int i=0;i<getlisteNoeuds().size();i++)
        {
            for(int j=0;j<2*getlisteNoeuds().size();j++)
            {
                if (m.get(i, j)<(1E-10)){
                    m.set(i, j,0);
                }
                System.out.print(m.get(i, j)+"  ");
                
            }
            System.out.println(" ");
        }*/
        return m;
    }//fin classe projY
    
    public static Matrice creeMatrice (){
        //(ArrayList<Noeuds> listeNoeuds, ArrayList<Barre> listeBarre, double force){
        for(int i=0;i<getlisteNoeuds().size();i++)
        {
            for(int j=0;j<2*getlisteNoeuds().size();j++)
            {
                concatLig(ProjX(),ProjY());
                
            }
            System.out.println(" ");
        }
            System.out.println(concatLig(ProjX(),ProjY()).toString());
        return concatLig(ProjX(),ProjY());   
    }

    public static Matrice Resolution(){
        Matrice c =new Matrice(2*getlisteNoeuds().size(),2*getlisteNoeuds().size());
        //c.creeVecteur(nc+2*listeAD.size()+listeAS.size());
        c.creeVecteur(2*getlisteNoeuds().size());
        //for(int j=0;j<nc+2*listeAD.size()+listeAS.size();j++)
        double force =1000;
        for(int j=0;j<2*getlisteNoeuds().size()-1;j++)
        {
            if (getlisteNoeuds().get(j).getClass()==Noeud_Simple.class){
               c.set(j,0,force); 
            }else{
           c.set(j,0,0);
            }
        }
        Matrice v = new Matrice(getlisteNoeuds().size()*2,0);

        for(int i=0;i<getlisteNoeuds().size()*2;i++)
        {
             
            v.set(i,0,resolutionGauss(creeMatrice(),c).get(i,0));

        }
        System.out.println(resolutionGauss(creeMatrice(),c).toString());
        return v;
    }
}
