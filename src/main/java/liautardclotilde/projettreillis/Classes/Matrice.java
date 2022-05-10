/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis.Classes;
 
/**
 *
 * @author cliautard01
 */

//créer une classe force pour calculer les forces
public class Matrice {
  //Définition des attributs 
    private int nbrLig;
    private int nbrCol;
    
    private double [][]coeffs;
    //Matrice vecteur;
    

    
    public Matrice(int nl, int nc)
    {                
        this.nbrLig=nl;
        this.nbrCol=nc;
        this.coeffs= new double [nl][nc];  
        //this.coeffs2= new double [nl][1];    
    }
    private Matrice(double[][] coeffs) {
        this.nbrLig = coeffs.length;
        this.nbrCol = coeffs[0].length;
        this.coeffs = coeffs;
    }
   
    public int getNbrLig(){
        return this.nbrLig;
    }
    
    public int getNbrCol(){
        return this.nbrCol;
    }
    
    public void setNbrLig(int nbrLig){
        this.nbrLig= nbrLig;
    }
    
    public void setNbrCol(int nbrCol){
        this.nbrCol= nbrCol;
    }
   
    //correctuon : pas de matrice !
    public double get(int lig, int col) {
        return this.coeffs[lig][col];
    }
    
    public void set(int lig, int col, double val) {
        this.coeffs[lig][col] = val;
    }
    
    public static Matrice creeVecteur(int nl)
    {
        Matrice vecteur= new Matrice(nl,0);    
        return vecteur;    
    }

        public String toString() {
        // oui, il serait plus efficace d'utiliser un {@link java.lang.StringBuilder}
        // mais ils n'ont pas été vu
        String res = "";
        for (int i = 0; i < nbrLig; i++) {
            res = res + "[";
            for (int j = 0; j < nbrCol; j++) {
                res = res + this.get(i, j);
                if (j < nbrCol - 1) {
                    res = res + " ";
                }
            }
            res = res + "]\n";
        }
        return res;
    }
        
    public Matrice mult (Matrice m2)
    {
       if (this.getNbrCol() != m2.getNbrLig()) 
       {
            throw new Error("tailles incompatibles pour mult");
       } 
        Matrice mat = new Matrice (this.getNbrLig(),m2.getNbrCol());
        
        for (int i=0; i<this.getNbrLig();i++)
        {
            for (int j=0; j<this.getNbrCol();j++)
            {
                double cur =0;
                for (int k = 0; k < this.getNbrCol(); k++)
                {
                    cur = cur + this.get(i, k) * m2.get(k, j);
                }
                mat.set(i, j, cur);
            }
        }
        return mat;
    }
    
    /* Fonction de calcul et retour d'une copie    */
    /* d'un tableau de double a 2 indices          */
    /* t : La matrice à cloner                     */

  public static Matrice clone(Matrice t)
  {
    int n = t.getNbrLig();
    int m = t.getNbrCol();
    Matrice nt = new Matrice(n,m);
    for ( int i = 0 ; i < n ; i++ )
    {
      for ( int j = 0 ; j < m ; j++ ) 
      {
        nt.set(i, j, t.get(i,j));
      }
    }
    return nt;
  }
  
  public Matrice subCols(int colMin, int colMax) {
        if (colMin < 0 || colMax < colMin || colMax >this.getNbrCol()) {
            throw new Error("indices colonnes invalides");
        }
        Matrice res = new Matrice(this.getNbrLig(), colMax - colMin + 1);
        for (int lig = 0; lig < res.getNbrLig(); lig++) {
            for (int col = 0; col < res.getNbrCol(); col++) {
                res.set(lig, col, this.get(lig, colMin + col));
            }
        }
        return res;
    }
    /* Recherche et permutation entre lignes       */
    /* de coefficients dans le cadre               */
    /* de la résolution d'un système               */
    /* de n équations linéaires à n inconnues      */
    /* par pivot de Gauss                          */
    /* l : Le numéro de la ligne à permuter        */
    /* a : La matrice de réels à traiter           */
    /* b : Le tableau de réels à traiter           */
    /*     concourrament à la matrice a            */
    
    public static void permutation(int l,Matrice m,Matrice b) 
    {
        
        int n = m.getNbrLig();
        double aux;
        int ll = l;
        while ( m.get(ll,l) == 0.0 ) {
          ll++; 
        }
        for ( int i = l ; i < n ; i++ )
        {
          aux = m.get(l, i);
          m.set(l,i,m.get(ll,i));
          m.set(ll,i,aux); 
        }
        
        aux = b.getNbrCol();
        b.set(l,0, b.get(ll,0));
        
        b.set(ll,0,aux);
    }
     
    /* Première partie de la méthode de résolution */
    /* d'un système de n équations linéaires       */
    /* à n inconnues par pivot de Gauss:           */
    /* Triangularisation de la matrice             */
    /* des coefficients et modification            */
    /* concourante du vecteur                      */ 
    /* a : La matrice de réels à transformer       */
    /*     par triangularisation                   */
    /* b : Le tableau de réels modifié             */
    /*     concourrament à la matrice a            */

    public static void transformation(Matrice a,Matrice b) 
    {
        int n = a.getNbrLig();
        for ( int i = 1 ; i < n ; i++ ) 
        {
          if ( a.get(i-1, i-1) == 0.0 )
          {
            permutation(i-1,a,b);
          }
          for ( int j = i ; j < n ; j++ ) 
          {
            double facteur = a.get(j, i-1)/a.get(i-1,i-1);
            for ( int k = i-1 ; k < n ; k++ ) 
            {
                a.set(j, k, a.get(j, k)-a.get(i-1, k)*facteur);
            }
            b.set(j,0,b.get(j,0)-b.get(i-1,0)*facteur);
            //b.creeVecteur(n).set(j,1,b.get(j, 1)-b.get(i-1,1)*facteur);  
          } 
        }
    }
    
    /* Seconde partie de la méthode de résolution  */
    /* des systèmes de n équations linéaires       */
    /* à n inconnues: Extraction du résultat       */
    /* Le retour est un tableau de réels           */
    /* a : La matrice de réels triangulaire carrée */
    /* b : Le tableau de réels                     */
  
    public static Matrice extraction(Matrice a,Matrice b) {
        int n = a.getNbrLig();
        int m = a.getNbrCol();
        
        Matrice v=new Matrice(n,m);
        
        v.set(n-1,0, b.get(n-1,0)/a.get(n-1, n-1));
        for ( int i = n-2 ; i >= 0 ; i-- ) 
        {
          v.set(i,0,b.get(i, 0));
          for ( int j = n-1 ; j > i ; j-- ) 
          {
              v.set(i,0,v.get(i,0)-v.get(j,0)*a.get(i, j));
          }
          v.set(i,0, v.get(i,0)/a.get(i, i));
        }
        return v;
    } 

    /* Fonction de calcul et retour de la solution */
    /* du systeme d'équations linéaires a.v = b    */
    /* a est une matrice de coefficients           */
    /* b est un vecteur de coefficients            */
    /* v est le vecteur à déterminer               */
    /* a, b et v sont de taille n.n, n et n        */
    /* n quelconque                                */
    /* Méthode utilisée : pivot de Gauss           */
    /* Attention: Les deux tableaux a et b         */
    /* sont modifiés au cours de la résolution     */
    /* Le retour est un tableau de réels           */
    /* a : La matrice de réels (carrée)            */
    /* b : Le tableau de réels                     */

    static Matrice resolution(Matrice a, Matrice b) 
    {
        //b.creeVecteur(getNbrLig());
        transformation(a,b);
        return extraction(a,b);
    }
     
   /* Fonction de calcul et retour de la solution */
    /* du systeme d'équations linéaires a.v = b    */
    /* a est une matrice de coefficients           */
    /* b est un vecteur de coefficients            */
    /* v est le vecteur à déterminer               */
    /* a, b et v sont de taille n.n, n et n        */
    /* n quelconque                                */
    /* Méthode utilisée : pivot de Gauss           */
    /* Une copie des deux tableaux a et b          */
    /* supports des coefficients est réalisée      */
    /* pour ne pas détruire ces informations       */
    /* au cours de la résolution                   */
    /* Le retour est un tableau de réels           */
    /* a : La matrice de réels (carrée)            */
    /* b : Le tableau de réels                     */

    public static Matrice resolutionGauss(Matrice a,Matrice b) {
        //int n=a.getNbrCol();
        return resolution(clone(a),clone(b));
    } 
      
    /*public static void  test3 (Matrice m, Matrice v){
        int nl=m.getNbrLig();
        int nc=m.getNbrCol();
      //System.out.println("saisir n 3");
      //int n=Lire.i();
      System.out.println("----------- test 3 --------------");
      //Matrice m = Matrice.matTest1(n);
      //System.out.println("mat M : ");
      //System.out.println(m);
      //System.out.println("M*v :");
      System.out.println("mat M : ");
       for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                
                System.out.print(m.get(i, j)+"  ");
            }
            System.out.println(" ");
        }
       System.out.println("M*v :");
        for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                
                System.out.println(m.mult(v).get(i, j)+"   ");
            }
            System.out.println(" ");
        }
    }*/
    
    public static void  test4(Matrice a,Matrice b,int nl,int nc)
    {
        System.out.println("----------- test 4 --------------");
        System.out.println("mat M : ");
        Matrice w = new Matrice(nl,nc);
        for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                System.out.print(a.get(i, j)+"  ");
                w.set(i, j, a.get(i,j));
            }
            System.out.println(" ");
        }
        
        Matrice v = new Matrice(nl,nc);
        System.out.println("vecteur ");
        for(int i=0;i<nl;i++)
        {
             System.out.print(b.get(i, 0)+"  ");
   
            System.out.println(" ");
        }
        System.out.println("résolution ");
        //v.creeVecteur(nc);
        for(int i=0;i<nl;i++)
        {
             
            v.set(i,0,resolutionGauss(a,b).get(i,0));
             System.out.print(v.get(i, 0)+"  ");
   
            System.out.println(" ");
        }
        
        System.out.println("mat M : ");
        for(int i=0;i<nl;i++)
        {
            for(int j=0;j<nc;j++)
            {
                System.out.print(w.get(i, j)+"  ");
            }
            System.out.println(" ");
        }
        System.out.println("M*v :");
        Matrice y = new Matrice(nl,nc);
        y=w.mult(v);
        for(int i=0;i<nl;i++)
        {
            
                System.out.print(y.get(i, 0)+"   ");
            
            System.out.println(" ");
        }
    }//fin test 4
    
}//fin classe

    
    

