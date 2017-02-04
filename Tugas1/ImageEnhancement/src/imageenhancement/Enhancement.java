/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageenhancement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel
 */
public class Enhancement extends javax.swing.JFrame {

    /**
     * Creates new form Enhancement
     */
    public Enhancement() {
        initComponents();
        setLocationRelativeTo(null);
        prepare();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        lblImage = new javax.swing.JLabel();
        cbPilihan = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Enhancement");
        setResizable(false);

        cbPilihan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(cbPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOK)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

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
            java.util.logging.Logger.getLogger(Enhancement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Enhancement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Enhancement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enhancement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Enhancement().setVisible(true);
            }
        });
    }
    
    public void prepare() {
        normal();
        String [] list = {"Normal", "Brightness", "Negatif", "Binary","Grey Scale"};
        
        cbPilihan.setModel(new DefaultComboBoxModel(list));
        
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = cbPilihan.getSelectedIndex();
                switch (a) {
                    case 0 : normal(); break;
                    case 1 : brightness(); break;
                    case 2 : negatif(); break;
                    case 3 : binary(); break;
                    case 4 : greyScale();break;
                }
            }
        });
    }

    public void normal() {
        try {
            BufferedImage img = ImageIO.read(new File("src/res/sample.jpg"));
//            BufferedImage img2 = img;
//            for (int i = 0; i < img2.getWidth(); i++) {
//                for (int j = 0; j < img2.getHeight(); j++) {
//                    if ((i > 250 && i < 300) || (j > 250 && j < 300)) {
//                        img2.setRGB(i, j, -16567481);
//                    }
//                }
//            }
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void negatif() {
        try {
            BufferedImage img = ImageIO.read(new File("src/res/sample.jpg"));
            BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < img2.getWidth(); i++) {
                for (int j = 0; j < img2.getHeight(); j++) {
                    Color temp = new Color(img.getRGB(i, j));
                    
                    int neg = 255 - (temp.getRed() + temp.getGreen() + temp.getBlue())/3;
                    Color f = new Color(neg, neg, neg);
                    img2.setRGB(i, j, f.getRGB());
                }
            }
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void brightness() {
        try {
            int treshold = 120;
            BufferedImage img = ImageIO.read(new File("src/res/sample.jpg"));
            BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < img2.getWidth(); i++) {
                for (int j = 0; j < img2.getHeight(); j++) {
                    Color temp = new Color(img.getRGB(i, j));
                    
                    int r = temp.getRed();
                    int g = temp.getGreen();
                    int b = temp.getBlue();
                    
                    r = (r+treshold > 255) ? 255 : r;
                    g = (g+treshold > 255) ? 255 : g;
                    b = (b+treshold > 255) ? 255 : b;
                    
                    r = (r+treshold < 0) ? 0 : r;
                    g = (g+treshold < 0) ? 0 : g;
                    b = (b+treshold < 0) ? 0 : b;
                    Color f = new Color(r, g, b);
                    img2.setRGB(i, j, f.getRGB());
                }
            }
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void greyScale(){
        try {
            BufferedImage img = ImageIO.read(new File("src/res/sample.jpg"));
            BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < img2.getWidth(); i++) {
                for (int j = 0; j < img2.getHeight(); j++) {
                    Color temp = new Color(img.getRGB(i, j));
                    
                    int grey = (temp.getRed() + temp.getGreen() + temp.getBlue())/3;
                    Color f = new Color(grey,grey,grey);
                    img2.setRGB(i, j, f.getRGB());
                }
            }
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void binary() {
        try {
            BufferedImage img = ImageIO.read(new File("src/res/sample.jpg"));
            BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < img2.getWidth(); i++) {
                for (int j = 0; j < img2.getHeight(); j++) {
                    Color temp = new Color(img.getRGB(i, j));
                    int thres = 100;
                    int binary = (temp.getRed() + temp.getGreen() + temp.getBlue())/3;
                    if(binary>=100){
                        binary = 255;
                    }else{
                        binary = 0;
                    }
                    Color f = new Color(binary, binary, binary);
                    img2.setRGB(i, j, f.getRGB());
                }
            }
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img2));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<String> cbPilihan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
