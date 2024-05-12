/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.canam;
import CONTROLEUR_BD.Connexion;
import VUE.LOGIN;
import VUE.Menu;
import VUE.SplashScreen;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

/**
 *
 * @author TIGER FOX
 */
public class Canam {

    public static void main(String[] args) {
         FlatMacDarkLaf.setup();//fonction pour appliquer le theme de l'interface de facon globale
         //cet appel sert uniquement a essayer de creer la structure de la base de données
         Connexion.testCreation();
         //on affiche le Splash
         new SplashScreen(4500);
         new LOGIN().setVisible(true);
    }
}
