/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import java.util.Arrays;
import liautardclotilde.projettreillis.Classes.Appui_Double;
import liautardclotilde.projettreillis.Classes.Appui_Simple;
import liautardclotilde.projettreillis.Classes.Noeud_Simple;

/**
 *
 * @author Elève
 */
public class Edit2 extends Projet_Treillis {

    /**
     * Creates new form EditNoeuds
     */
    public Edit2() {
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
        nom = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        faire = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit");

        jLabel1.setText("Identificateur");

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Annuler(evt);
            }
        });

        jButton2.setText("Suivant");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Suite(evt);
            }
        });

        jLabel3.setText("Faire ?");

        faire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supprimer", "Modifier", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(71, 71, 71)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(faire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(faire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Annuler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Annuler
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Annuler

    private void Suite(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Suite
        // TODO add your handling code here:
        int u=0;
        int y=0;
        try{
            Nom=((Integer)nom.getValue());
            String Faire=faire.getSelectedItem().toString();
            Noeud_Simple N;
            if ("Supprimer".equals(Faire)){
                for (int j=0;j<getlisteNoeuds().size();j++){
                    if (getlisteNoeuds().get(j).getnom()==Nom){
                        for (int i=0;i<getlisteBarre().size();i++){
                            if (getlisteBarre().get(i).getNoeudf()==getlisteNoeuds().get(j)||getlisteBarre().get(i).getNoeudi()==getlisteNoeuds().get(j)){
                                getlisteBarre().remove(i);
                            }
                        }
                        for (int h=0;h<getlisteAD().size();h++){
                            if (getlisteAD().get(h)==getlisteNoeuds().get(j)){
                                getlisteAD().remove(h);
                            }
                        }
                        for (int h=0;h<getlisteAS().size();h++){
                            if (getlisteAS().get(h)==getlisteNoeuds().get(j)){
                                getlisteAS().remove(h);
                            }
                        }
                        for (int h=0;h<getlisteNS().size();h++){
                            if (getlisteNS().get(h)==getlisteNoeuds().get(j)){
                                getlisteNS().remove(h);
                            }
                        }
                        getlisteNoeuds().remove(j);
                        y=y+1;
                    } 
                }
                for (int j=0;j<getlisteNoeuds().size();j++){
                    getlisteNoeuds().get(j).setnom(j+1);
                }
                if (y==0){
                    new Erreur16().setVisible(true);
                }else{
                    System.out.println(Arrays.toString(getlisteNoeuds().toArray()));
                    dispose(); 
                }
            }
            if ("Modifier".equals(Faire)){
                for (int i=0;i<getlisteNoeuds().size();i++){
                    if (getlisteNoeuds().get(i).getnom()==Nom){
                        if (getlisteNoeuds().get(i).getClass()==Appui_Double.class){
                            new EditNoeudAppui().setVisible(true); 
                            dispose();
                        }
                        if (getlisteNoeuds().get(i).getClass()==Appui_Simple.class){
                            new EditNoeudAppui().setVisible(true);
                            dispose();
                        }
                        if (getlisteNoeuds().get(i).getClass()==Noeud_Simple.class){
                            new EditNoeudSimple().setVisible(true); 
                            dispose();
                        }
                    }
                }
                new Erreur16().setVisible(true);
            }
        }catch (Exception e) {
        }
    }//GEN-LAST:event_Suite
    
    private static int Nom;
    public static int getId2(){
        return Nom;
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
            java.util.logging.Logger.getLogger(Edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> faire;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner nom;
    // End of variables declaration//GEN-END:variables
}
