/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLEUR_BD;

import MODEL_BD.FORME;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TIGER FOX
 */
public class FormeDAO implements DAO {
    Connexion cn =new Connexion();
    Connection con;
    PreparedStatement pst;
    ResultSet res;

    @Override
    public boolean insert(FORME Obj) {
         // on prepare la requete SQL avec des variables qui vont recevoir les valeurs des attributs de l'objet pris en parametre          
        String sql="INSERT INTO shape (name,type,color,is_plain,x1,y1,x2,y2,r,angle) VALUES " + "(?,?,?,?,?,?,?,?,?,?)";
        try {
            con=cn.getConnection();
            pst=con.prepareStatement(sql);
            pst.setString(1, Obj.getName());
            pst.setString(2, Obj.getType());
            pst.setString(3, Obj.getColor());
            pst.setBoolean(4, Obj.getIs_plain());
            pst.setInt(5, Obj.getX1());
            pst.setInt(6, Obj.getY1());
            pst.setInt(7, Obj.getX2());
            pst.setInt(8, Obj.getY2());
            pst.setFloat(9, Obj.getR());
            pst.setFloat(10, Obj.getAngle());
            System.out.println(sql);
            System.out.println(pst);
            System.out.println(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "OPERATION REUSSIE ! ");
             return true;
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "UNE EREUR S'EST PRODUITE DANS L'AJOUT ");

            e.printStackTrace();
             return false;
        }
        finally{
            try {
                con.close();
            } catch (Exception e) {
                    System.out.println("errrrrrrrrrrrr");

                e.printStackTrace();
            }
            
        }
    }



    @Override
    public boolean delete(int ID) {
        String sql="DELETE FROM shape WHERE id = ?";
        try {
            con=cn.getConnection();
            pst=con.prepareStatement(sql);
            pst.setInt(1, ID);
            System.out.println(sql);
            System.out.println(pst);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Forme Supprimée");
             return true;
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "UNE erreur s'est produite ");


            e.printStackTrace();
             return false;
        }
    }

    @Override
    public ArrayList Select() {
                
      ArrayList<FORME> lis =new ArrayList<>();
      String sql= "select * from shape ORDER BY DATE DESC;";
        try {
            con=cn.getConnection();
             pst=con.prepareStatement(sql);
             res=pst.executeQuery();
             
             while (res.next()) {
                FORME mo = new FORME();
                mo.setID(res.getInt("ID"));
                mo.setColor(res.getString("color"));
                mo.setType(res.getString("type"));
                mo.setIs_plain(res.getBoolean("is_plain"));
                mo.setX1(res.getInt("x1"));
                mo.setY1(res.getInt("y1"));
                mo.setX2(res.getInt("x2"));
                 mo.setY2(res.getInt("y2"));
                mo.setAngle(res.getFloat("angle"));
                mo.setR(res.getFloat("r"));
                mo.setName(res.getString("name"));
                mo.setDate(res.getTimestamp("DATE"));
                lis.add(mo);  
                
            }
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERREUR DE RECUPERATION AVEC LA BD");
            e.printStackTrace();
            
        }
        return lis;
    }

    @Override
    public ArrayList Search(String type, String name) {
      ArrayList<FORME> lis =new ArrayList<>();
      String sql= "SELECT * FROM shape WHERE type LIKE '%"+type+"%'  AND name LIKE '%"+name+"%' ORDER BY DATE DESC;";
        try {
            con=cn.getConnection();
             pst=con.prepareStatement(sql);
             System.out.println(sql);
             res=pst.executeQuery();
             System.out.println(pst);
             
             while(res.next()) {
                FORME mo = new FORME();
                mo.setID(res.getInt("ID"));
                mo.setColor(res.getString("color"));
                mo.setType(res.getString("type"));
                mo.setIs_plain(res.getBoolean("is_plain"));
                mo.setX1(res.getInt("x1"));
                mo.setY1(res.getInt("y1"));
                mo.setX2(res.getInt("x2"));
                mo.setY2(res.getInt("y2"));
                mo.setAngle(res.getFloat("angle"));
                mo.setR(res.getFloat("r"));
                mo.setName(res.getString("name"));
                mo.setDate(res.getTimestamp("DATE"));
                lis.add(mo);   
                
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lis;    }

    @Override
    public boolean update(FORME Obj) {
                

        String sql="UPDATE shape SET name ='"+Obj.getName()+"', type ='"+Obj.getType()+"', color ='"+Obj.getColor()+"', is_plain ="+Obj.getIs_plain()+", angle ="+Obj.getAngle()+", r ="+Obj.getR()+", x1 ="+Obj.getX1()+", y1 ="+Obj.getY1()+", x2 ="+Obj.getX2()+", y2 ="+Obj.getY2()+ "  WHERE id ="+Obj.getID();
        System.out.println(sql);
        try {
            con=cn.getConnection();
             pst=con.prepareStatement(sql);
             pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "OPERATION REUSSIE ! ");
             return true;
             
             
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, "ERREUR l'ors de la modification !!! ");
             e.printStackTrace();
             return false;
        }
    }
    
}
