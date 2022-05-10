/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
//import liautardclotilde.projettreillis.DessinCanvas.PFEM2DGuiPanel;
//import liautardclotilde.projettreillis.DessinCanvas.PFEM2DObjectManager;
import static liautardclotilde.projettreillis.Projet_Treillis.getT;
/*import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import liautardclotilde.projettreillis.DessinCanvas.MainPane;

/**
 *
 * @author Elève
 */
public class Dessin extends JFrame {
    
    Graphique graphic = new Graphique ();
    
    public Dessin (String frameTitle){
        super(frameTitle);
        this.initComponents();
    }
    
    private void initComponents() {
        
        this.graphic = new Graphique();
        this.graphic.setPreferredSize(new Dimension(800, 600));
        this.add(graphic, BorderLayout.CENTER);

        JToolBar Menue = new JToolBar();
        Menue.setPreferredSize(new Dimension(100, 40));
        Menue.setFloatable(false);

        // bouton screenshot

        JButton SCREEN = new JButton("Screenshot");
        SCREEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphic.takeScreenshot();
            }
        });
        Menue.add(SCREEN);
        
        
        // bouton resize

        JButton ZOOM = new JButton("Zoom");
        ZOOM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double data[] = new double[4];
                data[0] = 4*getT().getxMin();
                data[1] = 4*getT().getxMax();
                data[2] = 4*getT().getyMin();
                data[3] = 4*getT().getyMax();
                graphic.centreView(data);
            }
        });
        Menue.add(ZOOM);
        

        Menue.add(new JSeparator(JSeparator.VERTICAL));

        // bouton close

        JButton FERMER = new JButton("Fermer");
        FERMER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Menue.add(FERMER);
        
        this.add(Menue, BorderLayout.NORTH);
        this.pack();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    public Dessin (){
        //this.setSize(getT().getxMax()-getT().getxMin(), getT().getyMax()-getT().getyMin());
        this.setSize(420, 420);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(graphic);
        //this.offsetX = 0;
        this.setVisible(true);
    }
    
}
