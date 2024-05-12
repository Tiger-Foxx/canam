/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLEUR_BD;


/**
 * Cette classe permet d'établir une connexion avec la base de données MySQL
 * et de créer la base de données canam à partir d'un script SQL.
 * La base de données canam contient une table shape qui stocke les informations
 * sur les formes géométriques dessinées par l'utilisateur dans l'application.
 * La classe Connexion utilise la bibliothèque ibatis-common pour exécuter le script SQL.
 * La classe Connexion utilise également la bibliothèque swing pour afficher des messages d'erreur
 * en cas de problème de connexion ou de création de la base de données.
 * La classe Connexion dispose d'un attribut de type Connection pour stocker la connexion
 * et de deux constantes de type String pour stocker le nom d'utilisateur et le mot de passe
 * pour se connecter à la base de données.
 * La classe Connexion dispose d'une méthode getConnection qui retourne la connexion avec la base de données canam,
 * et d'une méthode testCreation qui crée la base de données canam chez l'utilisateur à partir d'un script SQL.
 * @author TIGER FOX
 * @version 1.0
 */


import com.ibatis.common.jdbc.ScriptRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connexion {
    
    Connection con;
    public static String name="root";
    public static String passW="";
        
     /*methode qui etablit la connexion avec la BD MySQL */
    public Connection getConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/canam",name,passW);
            
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de Connection");
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    //methode pour creer la bd canam chez l'utilisateur  a partir d'un script sql
    
    public static void testCreation(){
        String script = "canam.sql";
        try {
            // Créer une connexion JDBC avec la base de données par défaut
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306?serverTimezone=UTC", 
                name, 
                passW
            );

            // Créer un ScriptRunner
            ScriptRunner runner = new ScriptRunner(conn,false,false);          
            // Exécuter le script
            BufferedReader reader = new BufferedReader(new FileReader(script));
            runner.runScript(reader);

            // Fermer le reader et la connexion
            reader.close();
            conn.close();

        } catch (Exception e) {
            // Gérer les exceptions
            script = "canam.sql";
        try {
            
            // Créer une connexion JDBC avec la base de données par défaut
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306?serverTimezone=UTC", 
                name, 
                passW
            );

            // Créer un ScriptRunner
            ScriptRunner runner = new ScriptRunner(conn,false,false);          
// Exécuter le script
            BufferedReader reader = new BufferedReader(new FileReader(script));
            runner.runScript(reader);

            // Fermer le reader et la connexion
            reader.close();
            conn.close();

        }
        catch (Exception e2) {
            e2.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur l'ors de la creation de la base de donnees"); 
        }
        }
        

        }
    
    
    
}

