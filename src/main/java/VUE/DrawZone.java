/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VUE;

/**
 *
 * @author TIGER FOX
 * Ceci est une Fonction qui a pour but de creer un panel de dessin qui fonctionne avec 
 * la bibliotheque Graphics de java , le principe est de dessiner des formes de graphics en suivant les mouvements
 * de la souris sur le panel de dessin pour permettre un meilleur control à l'utilisateur , celui-ci choisi l'origine et les dimentions
 * de sa figure avec sa souris et voie le modifications en temps reel 
 */
import MODEL_BD.FORME;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawZone extends JPanel implements MouseListener, MouseMotionListener {
    static FORME forme =new FORME();
    @Override
  public boolean isPaintingTile() {
        return super.isPaintingTile(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

  public DrawZone() {
    super();
    setBackground(Color.WHITE);
    addMouseListener(this);
    addMouseMotionListener(this);
    forme.setType("Rectangle"); // La forme par défaut
    forme.color = Color.RED; // La couleur par défaut
      setSize(870, 384);
  }
  public DrawZone(boolean  b) {
    super();
    setBackground(Color.WHITE);
    addMouseListener(this);
    addMouseMotionListener(this);
    setSize(870, 384);
  } // ce constructeur ne sert qu'à creer la drawzone qui se trouve dans la fonction d'edition

  // Cette fonction redéfinit la méthode paintComponent de la classe JPanel pour dessiner les formes géométriques dans le panel
// La fonction prend en paramètre un objet de type Graphics qui représente le contexte graphique du panel
// La fonction utilise la classe Graphics2D pour dessiner les formes avec des attributs avancés
// La fonction utilise l'attribut forme de type Forme qui contient les informations sur la forme à dessiner, tels que le type, la couleur, les coordonnées, l'angle, le rayon et le remplissage
// La fonction utilise la classe Menu pour accéder aux composants de l'interface graphique, tels que les champs de texte et les boutons
// La fonction affiche les coordonnées de l'origine de la figure dans les champs de texte cooXrect et CooYrect de la fenêtre principale
// La fonction utilise un switch case pour dessiner la forme en fonction du type choisi par l'utilisateur
// La fonction utilise des boucles for et des fonctions mathématiques pour calculer les points des formes polygonales (hexagone, triangle, losange)
// La fonction vérifie si la figure est pleine ou pas et utilise les méthodes fill ou draw en fonction du choix de l'utilisateur
// La fonction affiche un message d'erreur si le type de la forme est invalide
  public void paintComponent(Graphics g) {
    //la fonction qui dessine les formes dans le panel , la forme est l'objet graphics
    
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(forme.color);
    // Dessiner la forme en fonction du type choisi
    Menu.cooXrect.setText( Integer.toString(forme.getX1()));// cette partie est là pour mettre l'origine de la figure
    Menu.CooYrect.setText( Integer.toString(forme.getY1()));//sur la fentre principale 
    switch (forme.getType()) {
      case "Rectangle":
          // ce code verifie si la figure est pleine ou pas et utilise fill ou draw en fonction du choix
          if (Menu.isplain) {
              g2.drawRect(forme.getX1(), forme.getY1(), forme.getX2()-forme.getX1(), forme.getY2()-forme.getY1());
          } else {
              g2.fillRect(forme.getX1(), forme.getY1(), forme.getX2()-forme.getX1(), forme.getY2()-forme.getY1());
          }
          
        break;
      case "Ellipse":
          if (Menu.isplain) {
              g2.drawOval(forme.getX1(), forme.getY1(), forme.getX2()-forme.getX1(), forme.getY2()-forme.getY1());
          } else {
              g2.fillOval(forme.getX1(), forme.getY1(), forme.getX2()-forme.getX1(), forme.getY2()-forme.getY1());
          }
        
        break;
      case "Line":
        g2.drawLine(forme.getX1(), forme.getY1(), forme.getX2(), forme.getY2());
        break;
      case "Hexagon":
        // Créer un hexagone avec les coordonnées du centre et le rayon
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
          int x = (int) (forme.getX1() + forme.getR() * Math.cos(i * Math.PI / 3));
          int y = (int) (forme.getY1() + forme.getR() * Math.sin(i * Math.PI / 3));
          hexagon.addPoint(x, y);
        }
        // Dessiner l'hexagone
          if (Menu.isplain) {
              g2.drawPolygon(hexagon);
          } else {
              g2.fillPolygon(hexagon);
          }
        
        break;
      case "Triangle":
        // Créer un triangle avec les coordonnées du centre et le rayon
        Polygon triangle = new Polygon();
        for (int i = 0; i < 3; i++) {
          int x = (int) (forme.getX1() + forme.getR() * Math.cos(i * 2 * Math.PI / 3));
          int y = (int) (forme.getY1() + forme.getR() * Math.sin(i * 2 * Math.PI / 3));
          triangle.addPoint(x, y);
        }
        // Dessiner le triangle
        if (Menu.isplain) {
              g2.drawPolygon(triangle);
          } else {
              g2.fillPolygon(triangle);
          }
        break;
      case "Rhombus":
        // Créer un losange avec les coordonnées du centre, le rayon et l'angle
        Polygon rhombus = new Polygon();
        for (int i = 0; i < 4; i++) {
          int x = (int) (forme.getX1() + forme.getR() * Math.cos(i * Math.PI / 2 + Math.toRadians(forme.getAngle()))) ;
          int y = (int) (forme.getY1() + forme.getR() * Math.sin(i * Math.PI / 2 + Math.toRadians(forme.getAngle()) ));
          rhombus.addPoint(x, y);
        }
        // Dessiner le losange
        if (Menu.isplain) {
              g2.drawPolygon(rhombus);
          } else {
              g2.fillPolygon(rhombus);
          }
        break;
        
      default:
        g2.drawString("Invalid shape", forme.getX1(), forme.getY1());
        break;
    }
}


  // Gérer les événements de la souris
  public void mousePressed(MouseEvent e) {
    // Récupérer les coordonnées du premier point
    forme.setX1(e.getX());
    forme.setY1(e.getY()); 
    forme.setR((int) new Point(forme.getX1(), forme.getY1()).distance(forme.getX2(), forme.getY2()));
    forme.setAngle(  (float )Math.atan2(forme.getY2() - forme.getY1(), forme.getX2() - forme.getX1()));
  }

  public void mouseDragged(MouseEvent e) {
    // Récupérer les coordonnées du deuxième point
    forme.setX2(e.getX());
    forme.setY2(e.getY());
   forme.setR((int) new Point(forme.getX1(), forme.getY1()).distance(forme.getX2(), forme.getY2()));
   forme.setAngle((float )Math.atan2(forme.getY2() - forme.getY1(), forme.getX2() - forme.getX1()));
    
    /**** LA PARTIE QUI DOIT GERER L'AFFICHAGE DES CARACTERISTIQUES DES FORMES SELON LA FORME DESSINEE ***/
    
    
    switch (forme.getType()) {
      case "Rectangle":
          Menu.LongRect.setText( Integer.toString(e.getX()-forme.getX1()));
          Menu.LargRect.setText( Integer.toString(e.getY()-forme.getY1()));
          Menu.AireRet.setText(Integer.toString((e.getX()-forme.getX1())*(e.getY()-forme.getY1())));
          Menu.PerimRect.setText(Integer.toString(2*((e.getX()-forme.getX1())+e.getY()-forme.getY1())));
          
        break;
      case "Ellipse":
          
          Menu.RayonX.setText( Integer.toString(e.getX()-forme.getX1()));
          Menu.RayonY.setText( Integer.toString(e.getY()-forme.getY1()));
          Menu.AireEllip.setText(Float.toString((float ) Math.PI*(e.getX()-forme.getX1())*(e.getY()-forme.getY1())));
          int a=e.getX()-forme.getX1();
          int b=e.getY()-forme.getY1();
          float h1=(3*(a+b));
          float h2=(float ) (Math.sqrt((3*a+b)+(a+3*b)));
          Menu.PerimEllip.setText(Float.toString((float) 3.14*(h1-h2)));
          
        break;
      
      case "Hexagon":
          Menu.RayonHex.setText( Double.toString((new Point(forme.getX1(), forme.getY1()).distance(e.getX(), e.getY()))));
          forme.setR(  (int) new Point(forme.getX1(), forme.getY1()).distance(e.getX(),e.getY()));
          Menu.AireHexa.setText(Double.toString(6*forme.getR()));
          Menu.PerimHexa.setText(Float.toString((float) (forme.getR()*forme.getR()*6*Math.sqrt(3)/4)));
       
        
        break;
      case "Triangle":
          double cote=new Point(forme.getX1(), forme.getY1()).distance(e.getX(), e.getY());
          Menu.CoteTri.setText(Float.toString((float) cote)); 
          Menu.AireTri.setText(Float.toString((float) ((float) cote*cote*0.86/2))); // Aire = b*h /2 or b=cote ,h=cote*cos(pi/6)
          Menu.PerimTri.setText(Float.toString((float) (cote*3)));
          break;

      case "Rhombus":
          int diag=(e.getY()-forme.getY1());
          Menu.DiagoLos.setText( Integer.toString(diag));
          Menu.PerimLos.setText(Integer.toString(diag*4));
          Menu.AireLos.setText(Integer.toString(diag*diag));
          
        
        break;
        
      default:
        
        break;
    }
    
    
    /***** FIN DE CETTE PARTIE ****/
    
    
    
    
    // Redessiner le canvas
    repaint();

  }
  


  public void mouseReleased(MouseEvent e) {
    // Récupérer les coordonnées du deuxième point
    forme.setX2(e.getX());
    forme.setY2(e.getY()); 
    // Redessiner le canvas
    forme.setR(  (int) new Point(forme.getX1(), forme.getY1()).distance(forme.getX2(), forme.getY2()));
    forme.setAngle( (float ) Math.atan2(forme.getY2() - forme.getY1(), forme.getX2() - forme.getX1()));
    repaint();
  }
  public void mouseMoved(MouseEvent e) {
   // TODO add your handling code here:
        Menu.Xlabel.setText(" X: "+Integer.toString(e.getX()));
        Menu.Ylabel.setText("Y: "+Integer.toString(e.getY()));
        this.setToolTipText("Y: "+Integer.toString(e.getY())+" X: "+Integer.toString(e.getX())); //je met ce tooltip pour indiquer à l'utilisateur les coordonées de l'écran
  }
  // Les autres méthodes de l'interface MouseListener et MouseMotionListener ne sont pas utilisées
  public void mouseClicked(MouseEvent e) {
      
  }
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}


  
  //fonction Main uniquement destinée à un potentiel test de la classe 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Shape Function");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(870, 384);
    frame.setResizable(false);
    DrawZone sf = new DrawZone();
   
    frame.add(sf);
    frame.setVisible(true);
    // Changer le type de la forme
    forme.setType("Hexagon");
    // Changer la couleur de la forme
    forme.color=Color.RED;
  }
}
