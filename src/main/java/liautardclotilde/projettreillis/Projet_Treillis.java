/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import liautardclotilde.projettreillis.Classes.Appui_Double;
import liautardclotilde.projettreillis.Classes.Appui_Simple;
import liautardclotilde.projettreillis.Classes.Barre;
import static liautardclotilde.projettreillis.Classes.Calcul.creeMatrice;
import liautardclotilde.projettreillis.Classes.Catalogue_Barre;
import static liautardclotilde.projettreillis.Classes.Catalogue_Barre.Afficher_Catalogue_Barre;
import liautardclotilde.projettreillis.Classes.Matrice;
import static liautardclotilde.projettreillis.Classes.Matrice.test4;
import liautardclotilde.projettreillis.Classes.Noeud_Simple;
import liautardclotilde.projettreillis.Classes.Noeuds;
import static liautardclotilde.projettreillis.Classes.Noeuds.NoeudsString;
import liautardclotilde.projettreillis.Classes.Terrain;
import liautardclotilde.projettreillis.Classes.Treillis;
import liautardclotilde.projettreillis.Classes.TriangleTerrain;
/**
 *
 * @author Elève
 */
public class Projet_Treillis extends javax.swing.JFrame {
    
    private static Terrain T;
    private static ArrayList<TriangleTerrain> listeTT = new ArrayList();
    private static ArrayList<Noeuds> listeNoeuds = new ArrayList();
    private static ArrayList<Barre> listeBarre = new ArrayList();
    private static Catalogue_Barre C = new Catalogue_Barre();
    
    private static int ki=0;
    private static ArrayList <Integer> kp = new ArrayList();
    
    private  static  ArrayList < Noeuds > listeAD =  new  ArrayList ();
    private  static  ArrayList < Noeuds > listeAS =  new  ArrayList ();
    private  static  ArrayList < Noeuds > listeNS =  new  ArrayList ();
    
    private static int verifCoordNoeuds=0;
    private static int verifCoordTTP=0;
    
    private Treillis PT = new Treillis (T, listeNoeuds, listeBarre ,listeTT , C);
    
    private String fichier;
    /**
     * Creates new form Projet_Treillis
     * @return 
     */
    
    //Encapsulations
    public static Terrain getT (){
        return T;
    }
    public void setT (Terrain Tr){
        T=Tr;
    }
    
    public static Catalogue_Barre getCatalogue (){
        return C;
    }
    public void setCatalogue (Catalogue_Barre Ca){
        C=Ca;
    }
    
    public static ArrayList<TriangleTerrain> getlisteTT (){
        return listeTT;
    }
    public void setlisteTT (ArrayList<TriangleTerrain> listeTTr){
        for (int i=0;i<listeTTr.size();i++){
           listeTT.add(listeTTr.get(i));
        }
    }
    
    public static ArrayList<Noeuds> getlisteNoeuds (){
        return listeNoeuds;
    }
    public void setlisteNoeuds (ArrayList<Noeuds> listeNoeud){
        for (int i=0;i<listeNoeud.size();i++){
           listeNoeuds.add(listeNoeud.get(i));
        }
    }
    
    public static ArrayList<Noeuds> getlisteNS (){
        return listeNS;
    }
    public void setlisteNS (ArrayList<Noeuds> listeNoeud){
        for (int i=0;i<listeNoeud.size();i++){
           listeNS.add(listeNoeud.get(i));
        }
    }
    
    public static ArrayList<Noeuds> getlisteAS (){
        return listeAS;
    }
    public void setlisteAS (ArrayList<Noeuds> listeNoeud){
        for (int i=0;i<listeNoeud.size();i++){
           listeAS.add(listeNoeud.get(i));
        }
    }
    
    public static ArrayList<Noeuds> getlisteAD (){
        return listeAD;
    }
    public void setlisteAD (ArrayList<Noeuds> listeNoeud){
        for (int i=0;i<listeNoeud.size();i++){
           listeAD.add(listeNoeud.get(i));
        }
    }
    
    public static ArrayList<Barre> getlisteBarre (){
        return listeBarre;
    }
    public void setlisteBarre (ArrayList<Barre> listeBarres){
        for (int i=0;i<listeBarres.size();i++){
           listeBarre.add(listeBarres.get(i));
        }
    }
    
     //Encapsulation
    public static int getKi(){
        return ki;
    }
    public void setKi(int Ki){
        ki=Ki;
    }
    public static ArrayList<Integer> getKp(){
        return kp;
    }
    public void setKp(ArrayList<Integer> Kp){
        kp=Kp;
    }
    
    public static int getverifCoordNoeuds(){
        return verifCoordNoeuds;
    }
    public static int getverifCoordTTP(){
        return verifCoordTTP;
    }
    
    
    public Projet_Treillis(int Rien) {
        initComponents();
        //ImageIcon icon = new ImageIcon("test.jpg");
        //this.add(new JLabel(icon));
    }
    
    //Pour ne pas avoir le menu ProjetTreilli dans les autres extend 
    public Projet_Treillis() {
    }
    
    /*public Projet_Treillis(Terrain T,ArrayList<TriangleTerrain> TT) {
        initComponents();
        this.T=T;
        this.listeTT=TT;
    }
    
    public Projet_Treillis(Terrain T) {
        initComponents();
        this.T=T;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CréationDeTreillis");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(180, 180, 220));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu5.setText("Fichier");

        jMenuItem15.setText("Enregistrer sous");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerSous(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem12.setText("Ouvrir");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OuvrirUnFichier(evt);
            }
        });
        jMenu5.add(jMenuItem12);

        jMenuItem8.setText("Supprimer New Project");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppProjet(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuBar1.add(jMenu5);

        jMenu1.setText("Nouveau");

        jMenuItem3.setText("Terrain");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTerrain(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem7.setText("Triangle de Terrain");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewTriangleTerrain(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem1.setText("Noeud");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewNoeuds(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Barre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewBarre(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Modifier/Supprimer");

        jMenuItem4.setText("Terrain");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditTerrain(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Triangle de Terrain");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditTT(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Noeud");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNoeuds(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem10.setText("Barre");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBarre(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Affichage");

        jMenuItem9.setText("Afficher Treillis");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DessinTreillis(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem13.setText("Liste du Treillis");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherListe(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setText("Calculs des Tensions (Comparaison)");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tension(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem16.setText("Calculs du Coût");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Coût(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuBar1.add(jMenu7);

        jMenu4.setText("Settings");

        jMenu6.setText("Show Coordinates");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Noeud");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AficherCoordNoeuds(evt);
            }
        });
        jMenu6.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Point Terrain");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AficherCoordTTP(evt);
            }
        });
        jMenu6.add(jCheckBoxMenuItem2);

        jMenu4.add(jMenu6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1365, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NewNoeuds(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewNoeuds
        // TODO add your handling code here:
        if (T != null){
            new NewNoeuds().setVisible(true);
        }else{
            new Erreur10().setVisible(true); 
        }
    }//GEN-LAST:event_NewNoeuds

    /*
    }                                     
*/
    ///////////////////
    public static void test(){
        //remplissage matrice pour test
        
        //System.out.println("nb de noeud  ");
       //Terrain Tb= new Terrain (0.5,4.0,-5.0,1.0);
        System.out.println("nb noeud  "+getlisteNoeuds().size());
        System.out.println("nb barre  "+getlisteBarre().size());
        System.out.println("nb barre  "+listeBarre.size());
        System.out.println(-Math.cos(3*Math.PI/4));
        //Matrice c =new Matrice(2*getlisteNoeud().size(),getlisteBarre().size()+2*listeAD.size()+listeAS.size());
        //Matrice c =new Matrice(nc+2*listeAD.size()+listeAS.size(),nc+2*listeAD.size()+listeAS.size());
        Matrice c =new Matrice(2*getlisteNoeuds().size(),2*getlisteNoeuds().size());
        //c.creeVecteur(nc+2*listeAD.size()+listeAS.size());
        c.creeVecteur(2*getlisteNoeuds().size());
        //for(int j=0;j<nc+2*listeAD.size()+listeAS.size();j++)
        double force =1000;
        for(int j=0;j<2*listeNoeuds.size()-1;j++)
        {
            //if (listeNoeuds.get(j).getClass()==Noeud_Simple.class){
              // c.set(j,0,force); 
           //}else{
                c.set(j,0,0);
            //}
        }
           //c.set(2*getlisteNoeuds().size()-1,0,force);
        
                      
        //creeMatrice(getListeNoeuds(), getListeBarre(), force);
        //test4(creeMatrice(getlisteNoeuds(), getlisteBarre(), force),c,2*nbNoeud,getlisteBarre().size()+2*listeAD.size()+listeAS.size());
        //test4(creeMatrice(getlisteNoeuds(), getlisteBarre(), force),c,getlisteBarre().size()+2*listeAD.size()+listeAS.size(),getlisteBarre().size()+2*listeAD.size()+listeAS.size());
        test4(creeMatrice(),c,2*getlisteNoeuds().size(),2*getlisteNoeuds().size());
    }
    
    private void NewTerrain(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTerrain
        // TODO add your handling code here:
        new NewEditTerrain().setVisible(true);
    }//GEN-LAST:event_NewTerrain

    private void NewBarre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewBarre
        // TODO add your handling code here:
        if ((listeNoeuds != null) && (!listeNoeuds.isEmpty()) && (listeNoeuds.size()>1)){
            System.out.println(C.toString());
            new NewBarre().setVisible(true);  
        }else{
            new Erreur10().setVisible(true);  
        }
    }//GEN-LAST:event_NewBarre

    private void NewTriangleTerrain(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewTriangleTerrain
        // TODO add your handling code here:
        if (T != null){
            new NewTriangleTerrain().setVisible(true);
        }else{
            new Erreur10().setVisible(true);
        }
    }//GEN-LAST:event_NewTriangleTerrain

    private void OuvrirUnFichier(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OuvrirUnFichier
        // TODO add your handling code here:
        new OuvrirUnFichier().setVisible(true);
    }//GEN-LAST:event_OuvrirUnFichier

    private void EditTT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTT
        // TODO add your handling code here:
        if ((listeTT != null) && (!listeTT.isEmpty())){
            new Edit1().setVisible(true);
        }//Rejouter une erreur qui indique qu'il n'y a rien à éditer ?
    }//GEN-LAST:event_EditTT

    private void EditNoeuds(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNoeuds
        // TODO add your handling code here:
        if ((listeNoeuds != null) && (!listeNoeuds.isEmpty())){
            new Edit2().setVisible(true); 
        }//Rejouter une erreur qui indique qu'il n'y a rien à éditer ?
    }//GEN-LAST:event_EditNoeuds

    private void EditBarre(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBarre
        // TODO add your handling code here:
        if ((listeBarre != null) && (!listeBarre.isEmpty())){
            new Edit3().setVisible(true);
        }
    }//GEN-LAST:event_EditBarre

    private void EditTerrain(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTerrain
        // TODO add your handling code here:
        if (T != null){
            new EditTerrain().setVisible(true);
        }//Rejouter une erreur qui indique qu'il n'y a rien à éditer ?
    }//GEN-LAST:event_EditTerrain

    private void SuppProjet(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppProjet
        // TODO add your handling code here:
        for (int i=0;i<listeTT.size();i++){
            listeTT.remove(i);
        }
        for (int i=0;i<listeNoeuds.size();i++){
            listeNoeuds.remove(i);
        }
        for (int i=0;i<listeNS.size();i++){
            listeNS.remove(i);
        }
        for (int i=0;i<listeAD.size();i++){
            listeAD.remove(i);
        }
        for (int i=0;i<listeAS.size();i++){
            listeAS.remove(i);
        }
        for (int i=0;i<listeBarre.size();i++){
            listeBarre.remove(i);
        }
        System.out.println(listeTT.size());
        System.out.println(listeNoeuds.size());
        System.out.println(listeBarre.size());
    }//GEN-LAST:event_SuppProjet

    private void AfficherListe(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherListe
        // TODO add your handling code here:
        if (T != null){
            System.out.println(T.toString());
        }
        if ((listeTT != null) && (!listeTT.isEmpty())){
            System.out.println(Arrays.toString(listeTT.toArray()));
        }
        Afficher_Catalogue_Barre(C);
        if ((listeNoeuds != null) && (!listeNoeuds.isEmpty())){
            System.out.println(Arrays.toString(listeNoeuds.toArray()));
        }
        if ((listeBarre != null) && (!listeBarre.isEmpty())){
            System.out.println(Arrays.toString(listeBarre.toArray()));
        }
        
    }//GEN-LAST:event_AfficherListe

    private void Coût(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Coût
        // TODO add your handling code here:
        new AfficheCout().setVisible(true);
    }//GEN-LAST:event_Coût

    private void Tension(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tension
        // TODO add your handling code here:
        new AfficheTension().setVisible(true);
    }//GEN-LAST:event_Tension

    private void DessinTreillis(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DessinTreillis
        // TODO add your handling code here:
        new Dessin("Dessin Treillis").setVisible(true);
    }//GEN-LAST:event_DessinTreillis

    private void AficherCoordNoeuds(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AficherCoordNoeuds
        // TODO add your handling code here:
        if (verifCoordNoeuds==0){
            verifCoordNoeuds=verifCoordNoeuds+1;
        }
        if (verifCoordNoeuds==1){
            verifCoordNoeuds=verifCoordNoeuds-1;
        }
    }//GEN-LAST:event_AficherCoordNoeuds

    private void AficherCoordTTP(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AficherCoordTTP
        // TODO add your handling code here:
        if (verifCoordTTP==0){
            verifCoordTTP=verifCoordTTP+1;
        }
        if (verifCoordTTP==1){
            verifCoordTTP=verifCoordTTP-1;
        }
    }//GEN-LAST:event_AficherCoordTTP

    private void EnregistrerSous(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerSous
         // TODO add your handling code here:
         // TODO add your handling code here:
        //try
        //{
        JFileChooser filechoose = new JFileChooser();
        // Créer un JFileChooser
           filechoose.setCurrentDirectory(new File(".")); // Le répertoire
        //source du JFileChooser est le répertoire d'où est lancé
        //notre programme
           String approve = new String("ENREGISTRER");
        // Le bouton pour valider l'enregistrement portera la
        //mention ENREGSITRER
           int resultatEnregistrer = filechoose.showDialog(filechoose, approve); // Pour afficher le JFileChooser...
           if (resultatEnregistrer ==JFileChooser.APPROVE_OPTION) // Si l'utilisateur clique
        //sur le bouton ENREGSITRER
           { String monFichier= new String(filechoose.getSelectedFile().toString());
           
        // Récupérer le nom du fichier qu'il a spécifié
              if(monFichier.endsWith(".txt")|| monFichier.endsWith(".TXT")) {;}
        // Si ce nom de fichier finit par .txt ou .TXT, ne rien faire et passer à
        //a suite
             // else{(monFichier = monFichier+ ".txt");}
        // Sinon renommer le fichier pour qu'il porte l'extension .txt
              { 

                 try{
        //String fichier=null;
        //double xMin,xMax, yMin, yMax;
        //NewEditTerrain a=new NewEditTerrain ();
        //PrintWriter sortie = new PrintWriter (new FileWriter(fichier));
        
                    FileWriter lu=new FileWriter(monFichier);
                    BufferedWriter fichier1=new BufferedWriter(lu);//new FileWriter("treillis.txt", true));
                    //fichier1.write(creationFichier()); 
                    fichier1.write("ZoneConstructible;"+T.getxMin()+";"+T.getxMax()+";"+T.getyMin()+";"+T.getyMax());
                    fichier1.newLine();
                    for (int i=0;i<listeTT.size();i++){
                        fichier1.write("Triangle;"+listeTT.get(i).getNOM()+";("+listeTT.get(i).getPT1().getPx()+","+listeTT.get(i).getPT1().getPy()+");("+listeTT.get(i).getPT2().getPx()+","+listeTT.get(i).getPT2().getPy()+");("+listeTT.get(i).getPT3().getPx()+","+listeTT.get(i).getPT3().getPy()+")");
                        fichier1.newLine();
                    }
                    fichier1.write("FINTRIANGLES");
                    fichier1.newLine();
                    Catalogue_Barre c=new Catalogue_Barre();

                    for (int i=0;i<6;i++){// ensemble_typebarre est vide

                        fichier1.write("TypeBarre;"+c.getEnsemble_TypeBarre().get(i).getnom()+";"+c.getEnsemble_TypeBarre().get(i).getcout()+";"+c.getEnsemble_TypeBarre().get(i).getLmax()+";"+c.getEnsemble_TypeBarre().get(i).getRtmax()+";"+c.getEnsemble_TypeBarre().get(i).getRtmax());
                        fichier1.newLine();
                    }
                    fichier1.write("FINCATALOGUE");
                    fichier1.newLine();
                    for (int i=0;i<listeNoeuds.size();i++){
                        if (listeNoeuds.get(i).getClass()==Appui_Double.class){

                            fichier1.write("AppuiDouble;"+listeNoeuds.get(i).getnom()+";"+listeNoeuds.get(i).getTT().getNOM()+";"+listeNoeuds.get(i).getNumero()+";"+listeNoeuds.get(i).getPosition());
                            fichier1.newLine();
                        }
                        if (listeNoeuds.get(i).getClass()==Appui_Simple.class){
                            fichier1.write("AppuiSimple;"+listeNoeuds.get(i).getnom()+";"+listeNoeuds.get(i).getTT().getNOM()+";"+listeNoeuds.get(i).getNumero()+";"+listeNoeuds.get(i).getPosition());
                            fichier1.newLine();
                        }
                        if (listeNoeuds.get(i).getClass()==Noeud_Simple.class){
                            //System.out.print("NoeudSimple;"+listeNoeuds.get(i).getnom()+";("+listeNoeuds.get(i).getabscisse()+","+listeNoeuds.get(i).getordonne()+")");
                            fichier1.write("NoeudSimple;"+listeNoeuds.get(i).getnom()+";("+listeNoeuds.get(i).getabscisse()+","+listeNoeuds.get(i).getordonne()+")");
                            fichier1.newLine();
                        }
                    }
                    fichier1.write("FINNOEUDS");
                    fichier1.newLine();
                    for (int i=0;i<listeBarre.size();i++){
                        fichier1.write("Barre;"+listeBarre.get(i).getnom()+";"+listeBarre.get(i).gettype().getnom()+";"+listeBarre.get(i).getNoeudi().getnom()+";"+listeBarre.get(i).getNoeudf().getnom());
                        fichier1.newLine();
                    }
                    fichier1.write("FINBARRES");
                    fichier1.newLine();
                    fichier1.close();
                }catch(Exception e) {
                        e.printStackTrace();
                }

              }
            }
        //} catch (IOException er) {;} 
    }//GEN-LAST:event_EnregistrerSous

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Projet_Treillis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projet_Treillis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projet_Treillis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projet_Treillis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Projet_Treillis(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
