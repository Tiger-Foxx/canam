/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VUE;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author TIGER FOX
 */


// ceci est une classe qui represente la splash screen avec une image
public class SplashScreen extends JWindow {
    public SplashScreen(int duration) {
        // Créer le contenu du splash screen 
        JPanel content = (JPanel)getContentPane();

        // Positionner et dimensionnez la fenêtre
        int width = 550;
        int height = 400;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x, y, width, height);

        // Ajoutez une image et du texte
        JLabel label = new JLabel(new ImageIcon("tache2.png"));
        JLabel text2 = new JLabel("DRAW WITH CANAM 2023", JLabel.CENTER);
        text2.setFont(new java.awt.Font("Segoe UI", 1, 38));
        JLabel text = new JLabel("BY FOX - concours canam", JLabel.CENTER);
        text.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        content.add(label, BorderLayout.CENTER);
        content.add(text, BorderLayout.NORTH);
        content.add(text2, BorderLayout.SOUTH);
        
        // Affichez le splash screen et attendez
        setVisible(true);
        
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(false);
    }
    
 }
