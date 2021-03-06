/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import java.util.ArrayList;
import java.util.Arrays;
import liautardclotilde.projettreillis.Classes.PointTerrain;
import liautardclotilde.projettreillis.Classes.TriangleTerrain;
/**
 *
 * @author Elève
 */
public class NewTriangleTerrain extends Projet_Treillis {
    
    //liste des triangles de terrain
    //private static ArrayList<TriangleTerrain> listeTT= new ArrayList();
    //Terrain donné
    //private static Terrain T=getTerrain ();
    
    /**
     * Creates new form NewTriangleTerrain
     */
    public NewTriangleTerrain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Abs1 = new javax.swing.JTextField();
        Ord1 = new javax.swing.JTextField();
        Abs2 = new javax.swing.JTextField();
        Ord2 = new javax.swing.JTextField();
        Abs3 = new javax.swing.JTextField();
        Ord3 = new javax.swing.JTextField();
        Annuler = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NewTriangleTerrain");

        jLabel1.setText("Abscisse");

        jLabel2.setText("Ordonne");

        jLabel3.setText("Point 1:");

        jLabel4.setText("Point 2:");

        jLabel5.setText("Point 3:");

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Annuler(evt);
            }
        });

        jButton2.setText("Terminer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Terminer(evt);
            }
        });

        jButton1.setText("Suivant");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suivant(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Abs1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                    .addComponent(Ord1))))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Annuler)
                        .addGap(52, 52, 52)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ord2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Abs2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Abs3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ord3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Abs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Abs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Abs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Ord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ord2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ord3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Annuler)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Annuler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Annuler
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Annuler
    
    private void Terminer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Terminer
        // TODO add your handling code here:
        int y=0;  
        ArrayList<TriangleTerrain> listeTt = new ArrayList();
        try{  
            y=y+1;
            double x1=Double.parseDouble(Abs1.getText());
            //System.out.println(x1);
            double x2=Double.parseDouble(Abs2.getText());
            //System.out.println(x2);
            double x3=Double.parseDouble(Abs3.getText());
            //System.out.println(x3);
            double y1=Double.parseDouble(Ord1.getText());
            //System.out.println(y1);
            double y2=Double.parseDouble(Ord2.getText());
            //System.out.println(y2);
            double y3=Double.parseDouble(Ord3.getText());
            //System.out.println(y3);
            PointTerrain PT1=new PointTerrain (x1,y1,0);
            //System.out.println(PT1.getNom()+":("+PT1.getPx()+","+PT1.getPy()+")");
            PointTerrain PT2=new PointTerrain (x2,y2,1);
            //System.out.println(PT2.getNom()+":("+PT2.getPx()+","+PT2.getPy()+")");
            PointTerrain PT3=new PointTerrain (x3,y3,2);
            //System.out.println(PT3.getNom()+":("+PT3.getPx()+","+PT3.getPy()+")");
            if ((PT1.Verification_Appartenance_TerrainP(getT())==true)&&(PT2.Verification_Appartenance_TerrainP(getT())==true)&&(PT3.Verification_Appartenance_TerrainP(getT())==true)){
                TriangleTerrain TT=new TriangleTerrain (PT1,PT2,PT3,getlisteTT().size()+1); 
                //System.out.println(TT.getNOM()+":("+TT.getPT1()+";"+TT.getPT2()+";"+TT.getPT3()+")");
                y=y+1;
                if (TT.verifUniciteTroisPoints()==false){
                    new Erreur8().setVisible(true);
                }else{
                    y=y+2;
                    if (VerifTT(getlisteTT(),TT)==false){ 
                        new Erreur5().setVisible(true);
                    }else{
                        listeTt.add(TT);
                        setlisteTT(listeTt);
                        System.out.println(Arrays.toString(getlisteTT().toArray()));
                        Abs1.setText("");
                        Abs2.setText("");
                        Abs3.setText(""); 
                        Ord1.setText("");
                        Ord2.setText("");
                        Ord3.setText("");
                        dispose();
                    }
                }
            }else{
                new Erreur6().setVisible(true);
            }
        }catch (NumberFormatException e) {
            if (y==1){
                System.out.println("CATCH");
                new Erreur2().setVisible(true); 
            }
             if (y==2){
                 System.out.println("CATCH");
                new Erreur8().setVisible(true); 
            }
            if (y>2&y<10){
                System.out.println("CATCH");
                new Erreur5().setVisible(true); 
            }
	}
    }//GEN-LAST:event_Terminer
    
    private void Suivant(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suivant
        // TODO add your handling code here:
        int y=0;  
        ArrayList<TriangleTerrain> listeTt = new ArrayList();
        try{  
            y=y+1;
            //System.out.println(T);
            double x1=Double.parseDouble(Abs1.getText());
            //System.out.println(x1);
            double x2=Double.parseDouble(Abs2.getText());
            //System.out.println(x2);
            double x3=Double.parseDouble(Abs3.getText());
            //System.out.println(x3);
            double y1=Double.parseDouble(Ord1.getText());
            //System.out.println(y1);
            double y2=Double.parseDouble(Ord2.getText());
            //System.out.println(y2);
            double y3=Double.parseDouble(Ord3.getText());
            //System.out.println(y3);
            PointTerrain PT1=new PointTerrain (x1,y1,0);
            //System.out.println(PT1.getNom()+":("+PT1.getPx()+","+PT1.getPy()+")");
            PointTerrain PT2=new PointTerrain (x2,y2,1);
            //System.out.println(PT2.getNom()+":("+PT2.getPx()+","+PT2.getPy()+")");
            PointTerrain PT3=new PointTerrain (x3,y3,2);
            //System.out.println(PT3.getNom()+":("+PT3.getPx()+","+PT3.getPy()+")");
            if ((PT1.Verification_Appartenance_TerrainP(getT())==true)&&(PT2.Verification_Appartenance_TerrainP(getT())==true)&&(PT3.Verification_Appartenance_TerrainP(getT())==true)){
                TriangleTerrain TT=new TriangleTerrain (PT1,PT2,PT3,getlisteTT().size()+1); 
                //System.out.println(TT.getNOM()+":("+PT1.getPx()+","+PT1.getPy()+";"+PT2.getPx()+","+PT2.getPy()+";"+PT3.getPx()+","+PT3.getPy()+")");
                y=y+1;
                if (TT.verifUniciteTroisPoints()==false){
                    new Erreur8().setVisible(true);
                }else{
                    y=y+2;
                    if (VerifTT(getlisteTT(),TT)==false){ 
                        new Erreur5().setVisible(true);
                    }else{
                        listeTt.add(TT);
                        setlisteTT(listeTt);
                        System.out.println(Arrays.toString(getlisteTT().toArray()));
                        Abs1.setText("");
                        Abs2.setText("");
                        Abs3.setText(""); 
                        Ord1.setText("");
                        Ord2.setText("");
                        Ord3.setText("");
                        System.out.println();
                    }
                }
            }else{
                new Erreur6().setVisible(true);
            }
        }catch (NumberFormatException e) {
            if (y==1){
                System.out.println("CATCH");
                new Erreur2().setVisible(true); 
            }
             if (y==2){
                 System.out.println("CATCH");
                new Erreur8().setVisible(true); 
            }
            if (y>2&y<10){
                System.out.println("CATCH");
                new Erreur5().setVisible(true); 
            }
	}
    }//GEN-LAST:event_Suivant

    //Méthode qui vérifie si listeTT vide ou non ou si contient deja un TT 
    public static boolean VerifTT (ArrayList<TriangleTerrain> listeTT, TriangleTerrain TT){
        int k=0;
        if (listeTT != null && !listeTT.isEmpty()){
            for (int i=0;i<listeTT.size();i++){
                if ((listeTT.get(i).getPT1()==TT.getPT1())&&(listeTT.get(i).getPT2()==TT.getPT2())&&(listeTT.get(i).getPT3()==TT.getPT3())){
                    return false;
                }else{
                    k=k+1;
                }
            }
            return k==listeTT.size();
        }else{
            return true;
        }
    }
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
            java.util.logging.Logger.getLogger(NewTriangleTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewTriangleTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewTriangleTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewTriangleTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewTriangleTerrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Abs1;
    private javax.swing.JTextField Abs2;
    private javax.swing.JTextField Abs3;
    private javax.swing.JButton Annuler;
    private javax.swing.JTextField Ord1;
    private javax.swing.JTextField Ord2;
    private javax.swing.JTextField Ord3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
