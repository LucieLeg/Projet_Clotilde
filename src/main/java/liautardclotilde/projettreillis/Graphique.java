/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liautardclotilde.projettreillis;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import static liautardclotilde.projettreillis.Projet_Treillis.*;

/**
 *
 * @author Elève
 */

//Aide de https://plegat.developpez.com/tutoriels/java/pfem2d_guipanel/#LIII 

public class Graphique extends JPanel implements MouseListener, MouseMotionListener{
    
    private int xold, yold;                     // coordonnées du point local précédent
    private int xstart, ystart;                 // coordonnées du point local initial
    private int mode;                           // mode d'interaction : VIEW, DRAG ou SCALE
    private double offsetX, offsetY;            // décalage de la vue
    private double echelle;                     // échelle de la vue
    private static int VIEW = 0;        
    private static int DRAG = 1;
    private static int SCALE = 2;
    private static double ECHELLE_BASE = 10.;  // échelle de base
    private static double stepX=10, stepY=10;//100
    
    public Graphique (){
      super();

        this.mode = VIEW;

        this.offsetX = 0;
        this.offsetY = 0;

        this.echelle = ECHELLE_BASE;

        this.addMouseListener(this);
        this.addMouseMotionListener(this);   
    }
    
    /**
     * Convertit une abscisse réelle en abscisse locale (repère JPanel)
     * @param x l'abscisse réelle
     * @return l'abscisse locale
     */
    public int getLocalCoordX(double x) {

        return (int) Math.round(this.getWidth() / 2 + this.offsetX + x * this.echelle / ECHELLE_BASE);

    }

    /**
     * Convertit une ordonnée réelle en ordonnée locale (repère JPanel)
     * @param y l'ordonnée réelle
     * @return l'ordonnée locale
     */
    public int getLocalCoordY(double y) {

        return (int) Math.round(this.getHeight() / 2 + this.offsetY - y * this.echelle / ECHELLE_BASE);

    }

    /**
     * Convertit une abscisse locale (repère JPanel) en abscisse réelle
     * @param x l'abscisse locale
     * @return l'abscisse réelle
     */
    public double getRealCoordX(double x) {

        return (x - (this.getWidth() / 2 + this.offsetX)) * ECHELLE_BASE / this.echelle;

    }

    /**
     * Convertit une ordonnée locale (repère JPanel) en ordonnée réelle
     * @param y l'ordonnée locale
     * @return l'ordonnée réelle
     */
    public double getRealCoordY(double y) {

        return (y - (this.getHeight() / 2 + this.offsetY)) * -ECHELLE_BASE / this.echelle;

    }
    
    public void paintComponent (Graphics g){
        
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        float abs;
        float ord;
        
        Graphics2D g2 = (Graphics2D) g;
        
         int h = this.getHeight();
        int w = this.getWidth();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, w, h);

        //tracé des axes et du quadrillage

        int roundOffsetX = (int) Math.round(this.offsetX);
        int roundOffsetY = (int) Math.round(this.offsetY);
        int localStepX = (int) Math.round(this.echelle / ECHELLE_BASE * stepX);
        int localStepY = (int) Math.round(this.echelle / ECHELLE_BASE * stepY);

        g.setColor(Color.ORANGE);
        g.drawLine(w / 2 + roundOffsetX, 0, w / 2 + roundOffsetX, h);
        g.drawLine(0, h / 2 + roundOffsetY, w, h / 2 + roundOffsetY);

        int offsetStrokeX = 7 - roundOffsetX % 7;
        int offsetStrokeY = 7 - roundOffsetY % 7;

        float[] dash = {2, 5};
        BasicStroke bsX = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, offsetStrokeX);
        BasicStroke bsY = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10, dash, offsetStrokeY);

        g.setColor(new Color(60, 85, 60));

        g2.setStroke(bsY);

        int nbxp = (w - (w / 2 + roundOffsetX)) / localStepX + 1;
        int nbxm = (w / 2 + roundOffsetX) / localStepX + 1;

        for (int i = 1; i < nbxp; i++) {
            int xline = w / 2 + roundOffsetX + (int) Math.round(i * stepX * this.echelle / ECHELLE_BASE);
            g.drawLine(xline, 0, xline, h);

        }
        for (int i = 1; i < nbxm; i++) {
            int xline = w / 2 + roundOffsetX - (int) Math.round(i * stepX * this.echelle / ECHELLE_BASE);
            g.drawLine(xline, 0, xline, h);
        }

        g2.setStroke(bsX);

        int nbym = (h - (h / 2 + roundOffsetY)) / localStepY + 1;
        int nbyp = (h / 2 + roundOffsetY) / localStepY + 1;

        for (int i = 1; i < nbyp; i++) {
            int yline = h / 2 + roundOffsetY - (int) Math.round(i * stepY * this.echelle / ECHELLE_BASE);
            g.drawLine(0, yline, w, yline);
        }
        for (int i = 1; i < nbym; i++) {
            int yline = h / 2 + roundOffsetY + (int) Math.round(i * stepY * this.echelle / ECHELLE_BASE);
            g.drawLine(0, yline, w, yline);
        }

        g2.setStroke(new BasicStroke());
        /*
        Premier code à utiliser avec l'autre constructeur en enlevant quasi tout le reste
        
        if ((getlisteTT() != null) && (!getlisteTT().isEmpty())){
            for (int i=0;i<getlisteTT().size();i++){
                if (getverifCoordTTP()==1){
                    abs=(float) getlisteTT().get(i).getPT1().getPx();
                    ord=(float) getlisteTT().get(i).getPT1().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                    
                    abs=(float) getlisteTT().get(i).getPT2().getPx();
                    ord=(float) getlisteTT().get(i).getPT2().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                    
                    abs=(float) getlisteTT().get(i).getPT3().getPx();
                    ord=(float) getlisteTT().get(i).getPT3().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.MAGENTA);
                g2.setStroke(new BasicStroke(2));
                g2.draw(new Line2D.Double(getlisteTT().get(i).getPT1().getPx(),getlisteTT().get(i).getPT1().getPy(),getlisteTT().get(i).getPT2().getPx(),getlisteTT().get(i).getPT2().getPy()));
                g2.draw(new Line2D.Double(getlisteTT().get(i).getPT2().getPx(),getlisteTT().get(i).getPT2().getPy(),getlisteTT().get(i).getPT3().getPx(),getlisteTT().get(i).getPT3().getPy()));
                g2.draw(new Line2D.Double(getlisteTT().get(i).getPT3().getPx(),getlisteTT().get(i).getPT3().getPy(),getlisteTT().get(i).getPT1().getPx(),getlisteTT().get(i).getPT1().getPy()));
            }
        }

        if ((getlisteNS() != null) && (!getlisteNS().isEmpty())){
            for (int i=0;i<getlisteNS().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteNS().get(i).getabscisse();
                    ord=(float) getlisteNS().get(i).getordonne();
                    g2.drawString(getlisteNS().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(1));
                //g2D.fill(new Ellipse2D.Double(0.0000001,0.0000001,getlisteNS().get(i).getabscisse(),getlisteNS().get(i).getordonne())); 
                g2.fill(new Ellipse2D.Double(getlisteNS().get(i).getabscisse(),getlisteNS().get(i).getordonne(),5,5)); 
            }
        }
        
        if ((getlisteAD() != null) && (!getlisteAD().isEmpty())){
            for (int i=0;i<getlisteAD().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteNS().get(i).getabscisse();
                    ord=(float) getlisteNS().get(i).getordonne();
                    g2.drawString(getlisteNS().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(1));
                g2.fill(new Ellipse2D.Double(getlisteAD().get(i).getabscisse(),getlisteAD().get(i).getordonne(),5,5)); 
            }
        }
        
        if ((getlisteAS() != null) && (!getlisteAS().isEmpty())){
            for (int i=0;i<getlisteAS().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteAS().get(i).getabscisse();
                    ord=(float) getlisteAS().get(i).getordonne();
                    g2.drawString(getlisteAS().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.GRAY);
                g2.setStroke(new BasicStroke(1));
                g2.fill(new Ellipse2D.Double(getlisteAS().get(i).getabscisse(),getlisteAS().get(i).getordonne(),5,5)); 
            }
        }
        
        if ((getlisteBarre() != null) && (!getlisteBarre().isEmpty())){
            for (int i=0;i<getlisteBarre().size();i++){
                g2.setColor(Color.CYAN);
                //g2D.setStroke(new BasicStroke(0.1));
                g2.draw(new Line2D.Double(getlisteBarre().get(i).getNoeudi().getabscisse(),getlisteBarre().get(i).getNoeudi().getordonne(),getlisteBarre().get(i).getNoeudf().getabscisse(),getlisteBarre().get(i).getNoeudf().getordonne()));
            }
        }
        */
        if ((getlisteTT() != null) && (!getlisteTT().isEmpty())){
            for (int i=0;i<getlisteTT().size();i++){
                if (getverifCoordTTP()==1){
                    abs=(float) getlisteTT().get(i).getPT1().getPx();
                    ord=(float) getlisteTT().get(i).getPT1().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                    
                    abs=(float) getlisteTT().get(i).getPT2().getPx();
                    ord=(float) getlisteTT().get(i).getPT2().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                    
                    abs=(float) getlisteTT().get(i).getPT3().getPx();
                    ord=(float) getlisteTT().get(i).getPT3().getPy();
                    g2.drawString(getlisteTT().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.GREEN);
                g2.setStroke(new BasicStroke(2));
                g2.draw(new Line2D.Double(getLocalCoordX(getlisteTT().get(i).getPT1().getPx()),getLocalCoordY(getlisteTT().get(i).getPT1().getPy()),getLocalCoordX(getlisteTT().get(i).getPT2().getPx()),getLocalCoordY(getlisteTT().get(i).getPT2().getPy())));
                g2.draw(new Line2D.Double(getLocalCoordX(getlisteTT().get(i).getPT2().getPx()),getLocalCoordY(getlisteTT().get(i).getPT2().getPy()),getLocalCoordX(getlisteTT().get(i).getPT3().getPx()),getLocalCoordY(getlisteTT().get(i).getPT3().getPy())));
                g2.draw(new Line2D.Double(getLocalCoordX(getlisteTT().get(i).getPT3().getPx()),getLocalCoordY(getlisteTT().get(i).getPT3().getPy()),getLocalCoordX(getlisteTT().get(i).getPT1().getPx()),getLocalCoordY(getlisteTT().get(i).getPT1().getPy())));
            }
        }

        if ((getlisteNS() != null) && (!getlisteNS().isEmpty())){
            for (int i=0;i<getlisteNS().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteNS().get(i).getabscisse();
                    ord=(float) getlisteNS().get(i).getordonne();
                    g2.drawString(getlisteNS().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.BLACK);
                g2.setStroke(new BasicStroke(1));
                //g2.fill(new Ellipse2D.Double(0.0000001,0.0000001,getlisteNS().get(i).getabscisse(),getlisteNS().get(i).getordonne())); 
                g2.fill(new Ellipse2D.Double(getLocalCoordX(getlisteNS().get(i).getabscisse()),getLocalCoordY(getlisteNS().get(i).getordonne()),8,8)); 
            }
        }
        
        if ((getlisteAD() != null) && (!getlisteAD().isEmpty())){
            for (int i=0;i<getlisteAD().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteAD().get(i).getabscisse();
                    ord=(float) getlisteAD().get(i).getordonne();
                    g2.drawString(getlisteAD().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(1));
                g2.fill(new Ellipse2D.Double(getLocalCoordX(getlisteAD().get(i).getabscisse()),getLocalCoordY(getlisteAD().get(i).getordonne()),8,8)); 
            }
        }
        
        if ((getlisteAS() != null) && (!getlisteAS().isEmpty())){
            for (int i=0;i<getlisteAS().size();i++){
                if (getverifCoordNoeuds()==1){
                    abs=(float) getlisteAS().get(i).getabscisse();
                    ord=(float) getlisteAS().get(i).getordonne();
                    g2.drawString(getlisteAS().get(i).toString(),abs, ord);
                }
                g2.setColor(Color.GRAY);
                g2.setStroke(new BasicStroke(1));
                g2.fill(new Ellipse2D.Double(getLocalCoordX(getlisteAS().get(i).getabscisse()),getLocalCoordY(getlisteAS().get(i).getordonne()),8,8)); 
            }
        }
        
        if ((getlisteBarre() != null) && (!getlisteBarre().isEmpty())){
            for (int i=0;i<getlisteBarre().size();i++){
                g2.setColor(Color.CYAN);
                g2.setStroke(new BasicStroke(4));
                g2.draw(new Line2D.Double(getLocalCoordX(getlisteBarre().get(i).getNoeudi().getabscisse()),getLocalCoordY(getlisteBarre().get(i).getNoeudi().getordonne()),getLocalCoordX(getlisteBarre().get(i).getNoeudf().getabscisse()),getLocalCoordY(getlisteBarre().get(i).getNoeudf().getordonne())));
            }
        }
    }    

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.xold = e.getX();
        this.yold = e.getY();

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                this.mode = DRAG;
                break;
            case MouseEvent.BUTTON2:
                this.mode = SCALE;
                this.xstart = e.getX();
                this.ystart = e.getY();
                break;
            default:
                this.mode = VIEW;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.mode == DRAG) {
            int x = e.getX();
            int y = e.getY();

            this.offsetX = this.offsetX + (x - this.xold);
            this.offsetY = this.offsetY + (y - this.yold);

            this.xold = x;
            this.yold = y;

            this.repaint();
        } else if (this.mode == SCALE) {
            int x = e.getX();
            int y = e.getY();

            int dx = x - this.xold;
            int dy = y - this.yold;

            int delta;
            if (Math.abs(dx) > Math.abs(dy)) {
                delta = dx;
            } else {
                delta = dy;
            }

            double newEchelle = Math.max(1, this.echelle * Math.pow(1.01, delta));
            double newOffsetX = this.offsetX + this.getRealCoordX(this.xstart) / ECHELLE_BASE * (this.echelle - newEchelle);
            double newOffsetY = this.offsetY - this.getRealCoordY(this.ystart) / ECHELLE_BASE * (this.echelle - newEchelle);

            this.offsetX = newOffsetX;
            this.offsetY = newOffsetY;
            this.echelle = newEchelle;

            this.xold = x;
            this.yold = y;

            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Centre la vue sur les éléments à afficher. 
     * @param boundingBox tableau de 4 double: Xmin, Xmax, Ymin,Ymax, en coordonnées réelles
     */
    public void centreView(double[] boundingBox) {

        if ((boundingBox[1] - boundingBox[0] != Double.NEGATIVE_INFINITY) && (boundingBox[3] - boundingBox[2] != Double.NEGATIVE_INFINITY)) {

            double echelleX = (this.getWidth() - 50) * ECHELLE_BASE / (boundingBox[1] - boundingBox[0]);
            double echelleY = (this.getHeight() - 50) * ECHELLE_BASE / (boundingBox[3] - boundingBox[2]);

            this.echelle = Math.min(echelleX, echelleY);
            
            this.offsetX = -(this.getLocalCoordX((boundingBox[1] + boundingBox[0]) / 2) - this.getLocalCoordX(0));
            this.offsetY = -(this.getLocalCoordY((boundingBox[3] + boundingBox[2]) / 2) - this.getLocalCoordY(0));

            this.repaint();
        }
    }
    
    /**
     * Crée une capture d'écran de l'affichage courant.
     * Le fichier de sortie est défini par sélection du fichier via un JFileChooser.
     * Deux formats possibles en sortie: png ou jpg
     */
    public void takeScreenshot() {

        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File fichier = fc.getSelectedFile();
            String nomFichier = fichier.getName().toLowerCase();

            if ((nomFichier.endsWith("png")) || (nomFichier.endsWith("jpg"))) {
                try {
                    BufferedImage bufImage = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_RGB);
                    this.paint(bufImage.createGraphics());

                    String extension = "png";
                    if (nomFichier.endsWith("jpg")) {
                        extension = "jpg";
                    }

                    ImageIO.write(bufImage, extension, fichier);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Veuillez préciser l'extension du fichier image (png ou jpg)",
                        "Extension fichier manquante", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*public static double[] Centre() {

        double data[] = new double[4];

        data[0] = Double.POSITIVE_INFINITY;
        data[1] = Double.NEGATIVE_INFINITY;
        data[2] = Double.POSITIVE_INFINITY;
        data[3] = Double.NEGATIVE_INFINITY;
       
        data[0] = getT().getxMax();
        data[1] = getT().getxMin();
        data[2] = getT().getyMax();
        data[3] = getT().getyMin();
        
        return data;
    }*/
}
