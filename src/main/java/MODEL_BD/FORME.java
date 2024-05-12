/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL_BD;
import java.awt.Color;
import java.sql.Timestamp;
/**
 *
 * @author TIGER FOX
 */

/*

 Cette classe représente une forme géométrique qui peut être dessinée dans l'application
 La classe FORME implémente l'interface Cloneable pour pouvoir créer des copies profondes des objets de type FORME
 La classe FORME dispose de plusieurs attributs pour stocker les informations sur la forme, tels que :
 - les coordonnées x1, y1, x2, y2 de la forme
 - le rayon r de la forme (utile pour les cercles et les ellipses)
 - l'identifiant ID de la forme (utile pour la base de données)
 - le nom name de la forme (choisi par l'utilisateur)
 - le booléen is_plain qui indique si la forme est pleine ou pas
 - l'angle angle de la forme (en degrés)
 - la couleur color de la forme (de type Color)
 - le type type de la forme (parmi ellipse, triangle, rectangle, hexagone, losange)
 - la date date de la création de la forme (de type Timestamp)
 La classe FORME dispose de plusieurs constructeurs pour créer des objets de type FORME avec différents paramètres
 La classe FORME dispose de plusieurs getters et setters pour accéder et modifier les attributs de la classe
 La classe FORME dispose d'une méthode getColor qui retourne la couleur de la forme sous forme de chaîne de caractères "R G B"
 La classe FORME dispose d'une méthode setColor qui prend en paramètre une chaîne de caractères "R G B" et modifie la couleur de la forme
 La classe FORME dispose d'une méthode clone qui crée une copie profonde de l'objet FORME
 La classe FORME utilise la classe Color pour gérer les couleurs des formes
 La classe FORME utilise la classe Timestamp pour gérer les dates de création des formes
 La classe FORME n'utilise pas de classe abstraite ni de sous-classes pour représenter les différents types de formes
 Cette conception a été choisie pour simplifier le code et éviter la duplication de code
 Cette conception permet également de stocker toutes les formes dans une même table de la base de données
 Cette conception implique cependant de gérer le dessin des formes dans une autre classe (VisuZone) en utilisant un switch case
 Cette conception pourrait être améliorée en utilisant le principe de l'héritage et du polymorphisme pour définir des classes spécifiques pour chaque type de forme
 Ces classes hériteraient d'une classe abstraite Forme qui définirait les attributs et les méthodes communes à toutes les formes
 Ces classes redéfiniraient la méthode draw pour dessiner la forme en fonction de ses caractéristiques
 Cette conception permettrait de rendre le code plus modulaire, plus lisible et plus facile à maintenir
 Cette conception nécessiterait cependant de modifier la structure de la base de données pour stocker les formes dans des tables séparées ou dans une table avec des colonnes supplémentaires

*/

public class FORME implements Cloneable{
    int x1,y1,x2,y2;
    float r;
    int ID;
    Timestamp date;
    
    public Timestamp getDate(){
        return this.date;
    }
    public void setDate(Timestamp date){
        this.date=date;
    }

    public int getID() {
        return ID;
    }

    public FORME(int x1, int y1, int x2, int y2, float r, int ID, String name, boolean is_plain, float angle, Color color, String type) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
        this.ID = ID;
        this.name = name;
        this.is_plain = is_plain;
        this.angle = angle;
        this.color = color;
        this.type = type;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    String name;
    boolean is_plain;

    public FORME(int ID,int x1, int y1, int x2, int y2, float r, String name, boolean is_plain, float angle, Color color, String type) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
        this.name = name;
        this.is_plain = is_plain;
        this.angle = angle;
        this.color=color;
        this.type = type;
        this.ID=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIs_plain() {
        return is_plain;
    }

    public void setIs_plain(boolean is_plain) {
        this.is_plain = is_plain;
    }
    public FORME(int x1, int y1, int x2, int y2, float r, String name, float angle, Color color, String type) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
        this.name = name;
        this.angle = angle;
        this.color = color;
        this.type = type;
    }
    public FORME() {
        
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    
    /* ici c'est un peu particulier car je decompose les couleurs en r g b  je retourne la chaine R G B*/
    public String getColor() {
        int red=color.getRed();
        int blue= color.getBlue();
        int green=color.getGreen();
        
        return red+" "+green+" "+blue;
    }

    /* ici c'est un peu particulier car je decompose les couleurs en r g b  */
    public void setColor(String color) {
        
        String[] colors=color.split(" ");
        
        this.color = new Color(Integer.parseInt(colors[0]), Integer.parseInt(colors[1]), Integer.parseInt(colors[2]));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    float angle;
    public Color color;
    public String type;
    
    
    // la méthode clone crée une copie profonde de l'objet FORME
    @Override
    public FORME clone() throws CloneNotSupportedException {
        try {
            // on appelle la méthode clone de la classe Object
            FORME copie = (FORME) super.clone();
            // on copie les attributs de type Color qui ne sont pas clonables par défaut
            copie.color = new Color(this.color.getRGB());
            // on retourne la copie
            return copie;
        } catch (CloneNotSupportedException e) {
            // cette exception ne devrait pas se produire car la classe FORME implémente l'interface Cloneable
            e.printStackTrace();
            return null;
        }
    }

    
}
