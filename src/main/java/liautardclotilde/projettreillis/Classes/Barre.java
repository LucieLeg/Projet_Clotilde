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
public class Barre {
    //Définitions des attibuts (ajouter type barre)
    private Noeuds Noeudi;
    private Noeuds Noeudf;
    private int nom;
    private TypeBarre type;
    
    //Construcetur (ajouter un construcetur avec la longueur)
    public Barre (Noeuds Noeudi,Noeuds Noeudf, int nom, Catalogue_Barre C, int numero){ 
        this.Noeudf = Noeudf;
        this.Noeudi = Noeudi;
        this.nom = nom;
        this.type = C.getEnsemble_TypeBarre().get(numero);
    }
    
    //ToString
    public String toString() {
        return this.nom+":( de "+this.Noeudi.toString()+" à "+this.Noeudf.toString()+" ; Type:"+this.type+")";
    }
    
    //Encapsulations 
    public Noeuds getNoeudi (){
        return this.Noeudi;
    }
    public Noeuds getNoeudf (){
        return this.Noeudf;
    }
    public int getnom(){
        return this.nom;
    }
    public TypeBarre gettype(){
        return this.type;
    }
    
    public void setNoeudi (Noeuds Ni){
        this.Noeudi=Ni;
    }
    public void setNoeudf (Noeuds Nf){
        this.Noeudf=Nf;
    }
    public void setnom (int nom){
        this.nom = nom;
    }
    public void settype (Catalogue_Barre C,int num){
        this.type = C.getEnsemble_TypeBarre().get(num);
    }
    
    //Méthode calcule longureur Barre
    public double longueurBarre (){
        double Xmax,Xmin,Ymax,Ymin;
        if (this.Noeudf.getabscisse()<this.Noeudi.getabscisse()){
            Xmax=this.Noeudi.getabscisse();
            Xmin=this.Noeudf.getabscisse();
        }else{
            Xmin=this.Noeudi.getabscisse();
            Xmax=this.Noeudf.getabscisse();
        }
        if (this.Noeudf.getordonne()<this.Noeudi.getordonne()){
            Ymax=this.Noeudi.getordonne();
            Ymin=this.Noeudf.getordonne();
        }else{
            Ymin=this.Noeudi.getordonne();
            Ymax=this.Noeudf.getordonne();
        }
        return Math.sqrt(Math.pow((Xmax-Xmin),2) + Math.pow((Ymax-Ymin),2));
    }
    
    public static double longueurBarreStatic (Barre S){
        return Math.sqrt(Math.pow((S.Noeudf.getabscisse()-S.Noeudi.getabscisse()),2) + Math.pow((S.Noeudf.getordonne()-S.Noeudi.getordonne()),2));
    }
    
     /*Cout par unité de longueur:
    1: 1,5 | 10
    10: 2 | 8,5
    2: 2,2 | 20
    20: 4,5 | 27
    22: 4 | 25
    222: 5,3 | 40
    */
    
    //Méthode calcule du coûts de la barre par rapport à sa longueur (peut-etre le mettre en attribut de type barre)
    public double Couts (){
       return this.longueurBarre()*this.type.getcout();
    }
    
    //Méthode de vérification croisement de terrain (0 non, 1 oui)
    public static int verification_croisement (Barre S1, Barre S2){
        
        double X1max;
        double X1min;
        double X2min;
        double X2max;
        
        if (S1.Noeudi.getabscisse()<S1.Noeudf.getabscisse()){
            X1min=S1.Noeudi.getabscisse();
            X1max=S1.Noeudf.getabscisse();
        }else{
            X1max=S1.Noeudi.getabscisse();
            X1min=S1.Noeudf.getabscisse();
        }
        if (S2.Noeudi.getabscisse()<S2.Noeudf.getabscisse()){
            X2min=S2.Noeudi.getabscisse();
            X2max=S2.Noeudf.getabscisse();
        }else{
            X2max=S2.Noeudi.getabscisse();
            X2min=S2.Noeudf.getabscisse();
        }
        
        //Le min des max et le max des min
        double Xmaxmin;
        double Xminmax;
        
        if (X1min<X2min){
            Xmaxmin=X2min;
        }else{
            Xmaxmin=X1min;
        }
        if (X1max<X2max){
            Xminmax=X1max;
        }else{
            Xminmax=X2max;
        }
        
        //Non même intervalle abscisse
        if ((X1max<X2min)||(X2max<X1min)){
            return 0;
        }
        
        double Y1max;
        double Y1min;
        double Y2min;
        double Y2max;
        
        if (S1.Noeudi.getordonne()<S1.Noeudf.getordonne()){
            Y1min=S1.Noeudi.getordonne();
            Y1max=S1.Noeudf.getordonne();
        }else{
            Y1max=S1.Noeudi.getordonne();
            Y1min=S1.Noeudf.getordonne();
        }
        if (S2.Noeudi.getordonne()<S2.Noeudf.getordonne()){
            Y2min=S2.Noeudi.getordonne();
            Y2max=S2.Noeudf.getordonne();
        }else{
            Y2max=S2.Noeudi.getordonne();
            Y2min=S2.Noeudf.getordonne();
        }
        
        //Non même intervalle ordonne
        if ((Y1max<Y2min)||(Y2max<Y1min)){
            return 0;
        }
        
        //Non croisement si ce croise au noeud initial ou final 
        /*if ((verification_unicite(S1,S2)==1)&&((S1.Noeudf==S2.Noeudf)||(S1.Noeudi==S2.Noeudi)||(S1.Noeudf==S2.Noeudi)||(S1.Noeudi==S2.Noeudf))){
                return 0;
        }*/ 
        
        //Calcul de coeff pour droite
        double A1;
        double A2;
        double XA1;
        double XA2;
        double b1;
        double b2;
        
        /*if (S1.Noeudf.abscisse==S1.Noeudi.abscisse){
          XA1=S1.Noeudf.abscisse;
        }else{
          A1=(S1.Noeudf.ordonne-S1.Noeudi.ordonne)/(S1.Noeudf.abscisse-S1.Noeudi.abscisse);
          b1=S1.Noeudi.ordonne-A1*S1.Noeudi.abscisse;
        }
        if (S2.Noeudf.abscisse==S2.Noeudi.abscisse){
          XA2=S2.Noeudf.abscisse; 
        }else{
          A2=(S2.Noeudf.ordonne-S2.Noeudi.ordonne)/(S2.Noeudf.abscisse-S2.Noeudi.abscisse);
          b2=S2.Noeudi.ordonne-A2*S2.Noeudi.abscisse;
        }*/

        
        double XA;
        
        //Parallele verticale
        if ((droite_vertical(S1)==1)&&(droite_vertical(S2)==1)){
            XA1=S1.Noeudf.getabscisse();
            XA2=S2.Noeudf.getabscisse(); 
            if (XA1==XA2){
                return 1;
            }else{
                return 0;
            }  
        }
        
        //Un vertical l'autre penché
        if ((droite_vertical(S1)==1)&&(droite_vertical(S2)==0)){
            XA1=S1.Noeudf.getabscisse();
            A2=(S2.Noeudf.getordonne()-S2.Noeudi.getordonne())/(S2.Noeudf.getabscisse()-S2.Noeudi.getabscisse());
            b2=S2.Noeudi.getordonne()-A2*S2.Noeudi.getabscisse(); 
            if ((XA1>X2min)&&(XA1<X2max)&&(A2*XA1+b2>=Y1min)&&(A2*XA1+b2<=Y1max)){
                return 1;
            }else{
                return 0;
            }  
        }
        
        if ((droite_vertical(S1)==0)&&(droite_vertical(S2)==1)){
            XA2=S2.Noeudf.getabscisse();
            A1=(S1.Noeudf.getordonne()-S1.Noeudi.getordonne())/(S1.Noeudf.getabscisse()-S1.Noeudi.getabscisse());
            b1=S1.Noeudi.getordonne()-A1*S1.Noeudi.getabscisse();
            if ((XA2>X1min)&&(XA2<X1max)&&(A1*XA2+b1>=Y2min)&&(A1*XA2+b1<=Y2max)){
                return 1;
            }else{
                return 0;
            }
        }
        
        //Parallele penchée
        if ((droite_vertical(S1)==0)&&(droite_vertical(S2)==0)){
       
            A1=(S1.Noeudf.getordonne()-S1.Noeudi.getordonne())/(S1.Noeudf.getabscisse()-S1.Noeudi.getabscisse());
            b1=S1.Noeudi.getordonne()-A1*S1.Noeudi.getabscisse();
            A2=(S2.Noeudf.getordonne()-S2.Noeudi.getordonne())/(S2.Noeudf.getabscisse()-S2.Noeudi.getabscisse());
            b2=S2.Noeudi.getordonne()-A2*S2.Noeudi.getabscisse();
            
            if (A1==A2){
            if (!(b1==b2)) { // droite parallèle
                return 0;
            }
            if ((b1==b2)&&((X1max>X2min)||(X2max>X1min))){ // droite quasi-confondu
                return 1;
            }else{
                return 0;
            }
            }else{
                XA=(b2-b1)/(A1-A2);
            //X intersection dans intervalle des Barres
                if (XA > Xmaxmin && XA < Xminmax) {
                    return 1;
                }else{
                    return 0;     
                }
            }
        }
        return 0;
    }
    
    //Méthode si une droite est vertical ou non 
    public static int droite_vertical (Barre S){
        if (S.Noeudf.getabscisse()==S.Noeudi.getabscisse()){
          return 1;
        }else{
          return 0;
        } 
    }
    
     //Méthode de vérification croisement barre segment (0 non, 1 oui)
    public static int verification_croisement_barre_segment (Barre S1, SegmentTerrain S2){

        double X1max;
        double X1min;
        double X2min;
        double X2max;

        if (S1.Noeudi.getabscisse()<S1.Noeudf.getabscisse()){
            X1min=S1.Noeudi.getabscisse();
            X1max=S1.Noeudf.getabscisse();
        }else{
            X1max=S1.Noeudi.getabscisse();
            X1min=S1.Noeudf.getabscisse();
        }
        if (S2.getDebut().getPx()<S2.getFin().getPx()){
            X2min=S2.getDebut().getPx();
            X2max=S2.getFin().getPx();
        }else{
            X2max=S2.getDebut().getPx();
            X2min=S2.getFin().getPx();
        }

        //Le min des max et le max des min
        double Xmaxmin;
        double Xminmax;

        if (X1min<X2min){
            Xmaxmin=X2min;
        }else{
            Xmaxmin=X1min;
        }
        if (X1max<X2max){
            Xminmax=X1max;
        }else{
            Xminmax=X2max;
        }

        //Non même intervalle abscisse
        if ((X1max<X2min)||(X2max<X1min)){
            return 0;
        }

        double Y1max;
        double Y1min;
        double Y2min;
        double Y2max;

        if (S1.Noeudi.getordonne()<S1.Noeudf.getordonne()){
            Y1min=S1.Noeudi.getordonne();
            Y1max=S1.Noeudf.getordonne();
        }else{
            Y1max=S1.Noeudi.getordonne();
            Y1min=S1.Noeudf.getordonne();
        }
        if (S2.getDebut().getPy()<S2.getFin().getPy()){
            Y2min=S2.getDebut().getPy();
            Y2max=S2.getFin().getPy();
        }else{
            Y2max=S2.getDebut().getPy();
            Y2min=S2.getFin().getPy();
        }

        //Non même intervalle ordonne
        if ((Y1max<Y2min)||(Y2max<Y1min)){
            return 0;
        }

        //Non croisement si ce croise au noeud initial ou final 
        /*if ((verification_unicite(S1,S2)==1)&&((S1.Noeudf==S2.getFin())||(S1.Noeudi==S2.getDebut())||(S1.Noeudf==S2.getDebut())||(S1.Noeudi==S2.getFin()))){
                return 0;
        verification unicité pour barre et segment à faire si utilisé
        }*/

        //Calcul de coeff pour droite
        double A1;
        double A2;
        double XA1;
        double XA2;
        double b1;
        double b2;

       /* if (S1.Noeudf.getabscisse()==S1.Noeudi.getabscisse()){
          XA1=S1.Noeudf.getabscisse();
        }else{
          A1=(S1.Noeudf.getordonne()-S1.Noeudi.getordonne())/(S1.Noeudf.getabscisse()-S1.Noeudi.getabscisse());
          b1=S1.Noeudi.getordonne()-A1*S1.Noeudi.getabscisse();
        }
        if (S2.getFin().getPx()==S2.getDebut().getPx()){
          XA2=S2.getFin().getPx(); 
        }else{
          A2=(S2.getFin().getPy()-S2.getDebut().getPy())/(S2.getFin().getPx()-S2.getDebut().getPx());
          b2=S2.getDebut().getPy()-A2*S2.getDebut().getPx();
        }*/


        double XA;

        //Parallele verticale
        if ((droite_vertical(S1)==1)&&(segment_vertical(S2)==1)){
            XA1=S1.Noeudf.getabscisse();
            XA2=S2.getFin().getPx(); 
            if (XA1==XA2&&(Y2max<=Y1max||Y1min<=Y2min)){
                return 1;
            }else if (XA1==XA2){
                return 0;
            }

        }

        //Un vertical l'autre penché
        if ((droite_vertical(S1)==1)&&(segment_vertical(S2)==0)){
            XA1=S1.Noeudf.getabscisse();
            A2=(S2.getFin().getPy()-S2.getDebut().getPy())/(S2.getFin().getPx()-S2.getDebut().getPx());
            b2=S2.getDebut().getPy()-A2*S2.getDebut().getPx(); 
            if ((XA1>X2min)&&(XA1<X2max)&&(A2*XA1+b2>=Y1min)&&(A2*XA1+b2<=Y1max)){
                return 1;
            }else{
                return 0;
            }  
        }

        if ((droite_vertical(S1)==0)&&(segment_vertical(S2)==1)){
            XA2=S2.getFin().getPx();
            A1=(S1.Noeudf.getordonne()-S1.Noeudi.getordonne())/(S1.Noeudf.getabscisse()-S1.Noeudi.getabscisse());
            b1=S1.Noeudi.getordonne()-A1*S1.Noeudi.getabscisse();
            if ((XA2>X1min)&&(XA2<X1max)&&(A1*XA2+b1>=Y2min)&&(A1*XA2+b1<=Y2max)){
                return 1;
            }else{
                return 0;
            }
        }

        //Parallele penchée
        if ((droite_vertical(S1)==0)&&(segment_vertical(S2)==0)){

            A1=(S1.Noeudf.getordonne()-S1.Noeudi.getordonne())/(S1.Noeudf.getabscisse()-S1.Noeudi.getabscisse());
            b1=S1.Noeudi.getordonne()-A1*S1.Noeudi.getabscisse();
            A2=(S2.getFin().getPy()-S2.getDebut().getPy())/(S2.getFin().getPx()-S2.getDebut().getPx());
            b2=S2.getDebut().getPy()-A2*S2.getDebut().getPx();

            if (A1==A2){
            if (!(b1==b2)) { // droite parallèle
                return 0;
            }
            if ((b1==b2)&&((X1max>=X2min)||(X2max>=X1min))){ // droite quasi-confondu
                return 1;
            }else{
                return 0;
            }
            }else{
                XA=(b2-b1)/(A1-A2);
            //X intersection dans intervalle des Barres
                if (XA >= Xmaxmin && XA <= Xminmax) {
                    return 1;
                }else{
                    return 0;     
                }
            }
        }
        return 0;
    }

    //Méthode si un segment est vertical ou non 
    public static int segment_vertical (SegmentTerrain S){
        if (S.getFin().getPx()==S.getDebut().getPx()){
          return 1;
        }else{
          return 0;
        } 
    }
    
    //Méthode vérification d'unicité
    public static int verification_unicite (Barre S1, Barre S2){
        if (((S1.Noeudf==S2.Noeudf)&&(S1.Noeudi==S2.Noeudi))||((S1.Noeudi==S2.Noeudf)&&(S1.Noeudf==S2.Noeudi))||((S1.Noeudf==S2.Noeudi)&&(S1.Noeudi==S2.Noeudf))){
            return 0;//Les deux barres sont les mêmes
        }else{
            return 1;//les deux barre sont uniques
        }
    }
    
    //Methode vérification qu'une barre ne soit pas un point 
    public boolean verification_nonpoint (){
        if (this.Noeudf==this.Noeudi){
            return false;//un point barre 
        }else{
            return true;//une barre
        }
    }
    
}
