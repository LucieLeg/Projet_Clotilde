/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import liautardclotilde.projettreillis.Classes.Barre;
import liautardclotilde.projettreillis.Classes.Noeud_Simple;
import liautardclotilde.projettreillis.Classes.Terrain;

/**
 *
 * @author Elève
 */
public class EditTerrain extends Projet_Treillis {

    /**
     * Creates new form EditTerrain
     */
    public EditTerrain() {
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

        Ymin = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Xmax = new javax.swing.JTextField();
        Xmin = new javax.swing.JTextField();
        Ymax = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
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

        jLabel1.setText("Xmax");

        jLabel2.setText("Xmin");

        jLabel3.setText("Ymax");

        jLabel4.setText("Ymin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Xmax, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Xmin))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Ymin)
                            .addComponent(Ymax, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(Xmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ymax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(Xmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ymin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Annuler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Annuler
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Annuler

    private void Terminer(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Terminer
        // TODO add your handling code here:
        int u=0;
        try{
            double inter;
            double xmin=Double.parseDouble(Xmin.getText());
            double xmax=Double.parseDouble(Xmax.getText());
            double ymin=Double.parseDouble(Ymin.getText());
            double ymax=Double.parseDouble(Ymax.getText());
            if (xmax<xmin){
                inter=xmax;
                xmax=xmin;
                xmin=inter;
                new Erreur7().setVisible(true);
            }
            if (ymax<ymin){
                inter=ymax;
                ymax=ymin;
                ymin=inter;
                new Erreur7().setVisible(true);
            }
            Terrain Tr=new Terrain (xmin,xmax,ymin,ymax);
            setT(Tr);
            System.out.println(getT().getxMin()+","+getT().getxMax()+","+getT().getyMin()+","+getT().getyMax());
            
            u=u+1;
            for (int i=0;i<getlisteBarre().size();i++){
                if (getlisteBarre().get(i).getNoeudi().Verification_Appartenance_TerrainN(getT())==false){
                    Barre B=getlisteBarre().get(i);
                    getlisteBarre().remove(i);
                    for (int j=0;j<getlisteNoeuds().size();j++){
                        if (B.getNoeudi().getnom()==getlisteNoeuds().get(j).getnom()){
                            getlisteNoeuds().remove(j);
                        }
                    }
                }
            }
            u=u+1;
            for (int i=0;i<getlisteBarre().size();i++){
                if (getlisteBarre().get(i).getNoeudf().Verification_Appartenance_TerrainN(getT())==false){
                    Barre B=getlisteBarre().get(i);
                    getlisteBarre().remove(i);
                    for (int j=0;j<getlisteNoeuds().size();j++){
                        if (B.getNoeudi().getnom()==getlisteNoeuds().get(j).getnom()){
                            getlisteNoeuds().remove(j);
                        }//remove dans la liste des noeud appui, noeud simple, ..
                    }
                }
            }
            for (int i=0;i<getlisteBarre().size();i++){
                getlisteBarre().get(i).setnom(i+1);
            }
            
            u=u+1;
            Noeud_Simple N;
            for (int i=0;i<getlisteTT().size();i++){
                if ((getlisteTT().get(i).getPT1().Verification_Appartenance_TerrainP(getT())==false)||(getlisteTT().get(i).getPT2().Verification_Appartenance_TerrainP(getT())==false)||(getlisteTT().get(i).getPT3().Verification_Appartenance_TerrainP(getT())==false)){
                    for (int k=0;k<getlisteNoeuds().size();k++){
                        for (int j=0;j<getlisteAD().size();j++){
                            for (int h=0;h<getlisteAS().size();h++){
                                if (getlisteAD().get(j).getTT()==getlisteTT().get(i)){
                                    if (getlisteAD().get(j).getnom()==getlisteNoeuds().get(k).getnom()){
                                        getlisteAD().remove(j);
                                        N=new Noeud_Simple(getlisteNoeuds().get(k));
                                        getlisteNoeuds().remove(k);
                                        getlisteNoeuds().add(N);
                                        getlisteNS().add(N);
                                    }
                                }
                                if (getlisteAS().get(h).getTT()==getlisteTT().get(i)){
                                    if (getlisteAS().get(h).getnom()==getlisteNoeuds().get(k).getnom()){
                                        getlisteAS().remove(h);
                                        N=new Noeud_Simple(getlisteNoeuds().get(k));
                                        getlisteNoeuds().remove(k);
                                        getlisteNoeuds().add(N);
                                        getlisteNS().add(N);
                                    }
                                }
                            }
                        }
                    }
                    getlisteTT().remove(i);
                } 
            }
            for (int i=0;i<getlisteTT().size();i++){
                getlisteTT().get(i).setNOM(i+1);
            }
            
            u=u+1;
            for (int i=0;i<getlisteNoeuds().size();i++){
                if (getlisteNoeuds().get(i).Verification_Appartenance_TerrainN(getT())==false){
                    getlisteNoeuds().remove(i);
                }
            }
            int j=0;
            for (int i=0;i<getlisteNoeuds().size();i++){
                if (getlisteNoeuds().get(i).getnom()==getlisteNS().get(i).getnom()){
                    getlisteNoeuds().get(i).setnom(j+1);
                    getlisteNS().get(i).setnom(j);
                }
                if (getlisteNoeuds().get(i).getnom()==getlisteAD().get(i).getnom()){
                    getlisteNoeuds().get(i).setnom(j+1);
                    getlisteAD().get(i).setnom(j);
                }
                if (getlisteNoeuds().get(i).getnom()==getlisteAS().get(i).getnom()){
                    getlisteNoeuds().get(i).setnom(j+1);
                    getlisteAS().get(i).setnom(j);
                }
                j=j+1;
            }
            dispose();
        }catch (NumberFormatException e) {
            if (u==0){
                new Erreur2().setVisible(true);
                System.out.println("CATCH1: problème NewTerrain"); 
            }
            if (u==1){
                new Erreur2().setVisible(true);
                System.out.println("CATCH2: problème suppression Barre par Noeudi"); 
            }
            if (u==2){
                new Erreur2().setVisible(true);
                System.out.println("CATCH3: problème suppression Barre par Noeudf"); 
            }
            if (u==3){
                new Erreur2().setVisible(true);
                System.out.println("CATCH4: problème suppression TriangleTerrain");
            }
            if (u==4){
                new Erreur2().setVisible(true);
                System.out.println("CATCH5: problème suppression Noeud"); 
            }
        }
    }//GEN-LAST:event_Terminer

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
            java.util.logging.Logger.getLogger(EditTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTerrain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTerrain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Xmax;
    private javax.swing.JTextField Xmin;
    private javax.swing.JTextField Ymax;
    private javax.swing.JTextField Ymin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
