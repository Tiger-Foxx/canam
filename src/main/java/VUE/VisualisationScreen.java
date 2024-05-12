/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VUE;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author TIGER FOX
 */
public class VisualisationScreen extends javax.swing.JFrame {

    /**
     * Creates new form VisualisationScreen
     */
    public VisualisationScreen() {
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

        MOnPanelDeVisu = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Exportvisu = new javax.swing.JMenuItem();

        setTitle("VISUALISATION Figure");
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        MOnPanelDeVisu.setBackground(new java.awt.Color(255, 255, 51));
        VisuZone Zone=new VisuZone();
        MOnPanelDeVisu.add(Zone);
        MOnPanelDeVisu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MOnPanelDeVisuMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout MOnPanelDeVisuLayout = new javax.swing.GroupLayout(MOnPanelDeVisu);
        MOnPanelDeVisu.setLayout(MOnPanelDeVisuLayout);
        MOnPanelDeVisuLayout.setHorizontalGroup(
            MOnPanelDeVisuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        MOnPanelDeVisuLayout.setVerticalGroup(
            MOnPanelDeVisuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu1.setText("fichier");

        Exportvisu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Exportvisu.setText("EXPORTER L'IMAGE");
        Exportvisu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exportvisu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportvisuActionPerformed(evt);
            }
        });
        jMenu1.add(Exportvisu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MOnPanelDeVisu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MOnPanelDeVisu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MOnPanelDeVisuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MOnPanelDeVisuMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_MOnPanelDeVisuMouseMoved

    private void ExportvisuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportvisuActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("ENTREZ LE NOM DE VOTRE FICHIER IMAGE");
        fileChooser.setFileFilter(new ImageFilter());
        if (fileChooser.showSaveDialog(MOnPanelDeVisu) == JFileChooser.APPROVE_OPTION) {
          File file = fileChooser.getSelectedFile();
            try {
                //creation d'un bjet buffered image a partir du contenu du Panel de dessin
                BufferedImage image= (BufferedImage)MOnPanelDeVisu.createImage(MOnPanelDeVisu.getWidth(),MOnPanelDeVisu.getHeight());
                Graphics g=image.getGraphics();
                MOnPanelDeVisu.paint(g); // ce code est là pour que l'image générée ne soit pas vide , on redessine la figure sur e panelDraw
                ImageIO.write(image, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ExportvisuActionPerformed

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
            java.util.logging.Logger.getLogger(VisualisationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualisationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualisationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualisationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualisationScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exportvisu;
    private javax.swing.JPanel MOnPanelDeVisu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}