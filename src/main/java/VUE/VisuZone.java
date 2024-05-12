/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VUE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cette classe représente la zone dans laquelle la figure apparait pour la visualisation.
 * La classe VisuZone hérite de la classe JPanel et redéfinit la méthode paintComponent
 * pour dessiner les formes géométriques dans le panel.
 * La classe VisuZone dispose de plusieurs attributs statiques pour stocker les informations
 * sur la forme à dessiner, tels que le type, la couleur, le remplissage, les coordonnées, le rayon et l'angle.
 * La classe VisuZone dispose également d'un constructeur qui initialise le panel avec une taille et une couleur de fond.
 * La classe VisuZone dispose enfin d'une méthode main qui permet de tester la classe en créant une fenêtre avec un panel de visualisation.
 * La classe VisuZone utilise la bibliothèque swing pour créer l'interface graphique et la bibliothèque awt pour dessiner les formes géométriques.
 * La classe VisuZone utilise un switch case pour dessiner la forme en fonction du type choisi par l'utilisateur.
 * La classe VisuZone utilise des boucles for et des fonctions mathématiques pour calculer les points des formes polygonales (hexagone, triangle, losange).
 * La classe VisuZone utilise la méthode isPaintingTile pour optimiser le rendu graphique du panel.
 * @author TIGER FOX
 * @version 1.0
 */


/***
 * represente la zone dans laquelle la figure apparait pour la visualisations
 * 
 * 
 * @author TIGER FOX
 */
public class VisuZone extends JPanel{
   static float angle=120; //l'angle de rotation
   static int x1=0, y1=0, x2=120, y2=120;
   static float r=120; // Les coordonnées de la forme

   
   
    @Override
 public boolean isPaintingTile() {
        return super.isPaintingTile(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
 
  
  static String shape="Rectangle"; // Le type de la forme
  static Color color=Color.RED; // La couleur de la forme
  static  boolean is_plain=false;
  public void paintComponent(Graphics g) {
    //la fonction qui dessine les formes dans le panel , la forme est l'objet graphics
    
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(color);
   
    switch (shape) {
      case "Rectangle":
          // ce code verifie si la figure est pleine ou pas et utilise fill ou draw en fonction du choix
          if (!is_plain) {
              g2.drawRect(x1, y1, x2-x1, y2-y1);
          } else {
              g2.fillRect(x1, y1, x2-x1, y2-y1);
          }
          
        break;
      case "Ellipse":
          if (!is_plain) {
              g2.drawOval(x1, y1, x2-x1, y2-y1);
          } else {
              g2.fillOval(x1, y1, x2-x1, y2-y1);
          }
        
        break;
      case "Line":
        g2.drawLine(x1, y1, x2, y2);
        break;
      case "Hexagon":
        // Créer un hexagone avec les coordonnées du centre et le rayon
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
          int x = (int) (x1 + r * Math.cos(i * Math.PI / 3));
          int y = (int) (y1 + r * Math.sin(i * Math.PI / 3));
          hexagon.addPoint(x, y);
        }
        // Dessiner l'hexagone
          if (!is_plain) {
              g2.drawPolygon(hexagon);
          } else {
              g2.fillPolygon(hexagon);
          }
        
        break;
      case "Triangle":
        // Créer un triangle avec les coordonnées du centre et le rayon
        Polygon triangle = new Polygon();
        for (int i = 0; i < 3; i++) {
          int x = (int) (x1 + r * Math.cos(i * 2 * Math.PI / 3));
          int y = (int) (y1 + r * Math.sin(i * 2 * Math.PI / 3));
          triangle.addPoint(x, y);
        }
        // Dessiner le triangle
        if (!is_plain) {
              g2.drawPolygon(triangle);
          } else {
              g2.fillPolygon(triangle);
          }
        break;
      case "Rhombus":
        // Créer un losange avec les coordonnées du centre, le rayon et l'angle
        Polygon rhombus = new Polygon();
        for (int i = 0; i < 4; i++) {
          int x = (int) (x1 + r * Math.cos(i * Math.PI / 2 + Math.toRadians(angle))) ;
          int y = (int) (y1 + r * Math.sin(i * Math.PI / 2 + Math.toRadians(angle) ));
          rhombus.addPoint(x, y);
        }
        // Dessiner le losange
        if (!is_plain) {
              g2.drawPolygon(rhombus);
          } else {
              g2.fillPolygon(rhombus);
          }
        break;
        
      default:
        g2.drawString("Invalid shape", x1, y1);
        break;
    }
}

  public VisuZone() {
    super();
     // La couleur par défaut
    setSize(870, 384);
    setBackground(Color.WHITE);
    repaint();
  }





  
  //fonction Main uniquement destinée à un potentiel test de la classe 
  public static void main(String[] args) {
    JFrame frame = new JFrame("Shape Function");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(870, 384);
    frame.setResizable(false);
    VisuZone sf = new VisuZone();
   
    frame.add(sf);
    frame.setVisible(true);
  }
    
}
