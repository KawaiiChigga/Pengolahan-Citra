/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagezoom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Daniel
 */
public class Zoom extends javax.swing.JFrame {

    /**
     * Creates new form Enhancement
     */
    public Zoom() {
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
        setTitle("Image Zoom");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOK))
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    private BufferedImage img;

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
            java.util.logging.Logger.getLogger(Zoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zoom().setVisible(true);
            }
        });
    }

    public void prepare() {

        try {
            img = ImageIO.read(new File("src/res/sample.jpg"));
            lblImage.setOpaque(true);
            lblImage.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String[] list = {"Pixel Replication", "Bilinear Interpolation", "K-Times Zooming"};

        cbPilihan.setModel(new DefaultComboBoxModel(list));

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = cbPilihan.getSelectedIndex();
                switch (a) {
                    case 0:
                        methodOne();
                        break;
                    case 1:
                        methodTwo();
                        break;
                    case 2:
                        methodThree();
                        break;
                }
            }
        });
    }

    public void methodOne() {
        try {
            int n = 2;

            JFrame frame = new JFrame();
            frame.setSize(img.getHeight() * n, img.getWidth() * n);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Pixel Replication");

            JLabel lblImg = new JLabel();
            lblImg.setSize(img.getWidth() * n, img.getHeight() * n);
            lblImg.setOpaque(true);

            BufferedImage imgZoom = new BufferedImage(img.getHeight() * n, img.getWidth() * n, img.getType());
            for (int y = 0; y < imgZoom.getHeight(); y++) {
                for (int x = 0; x < imgZoom.getWidth(); x++) {
                    imgZoom.setRGB(x, y, img.getRGB(x / n, y / n));
                }
            }

            lblImg.setIcon(new ImageIcon(imgZoom));
            frame.add(lblImg);

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodTwo() {
        try {
            int n = 2;

            JFrame frame = new JFrame();
            frame.setSize(img.getHeight() * n - 1, img.getWidth() * n - 1);
            frame.setLocationRelativeTo(null);
            frame.setTitle("Bilinear Interpolation");

            JLabel lblImg = new JLabel();
            lblImg.setSize(img.getHeight() * n - 1, img.getWidth() * n - 1);
            lblImg.setOpaque(true);

            BufferedImage imgZoomOne = new BufferedImage(img.getWidth() * n - 1, img.getHeight(), img.getType());

            for (int y = 0; y < imgZoomOne.getHeight(); y++) {
                for (int x = 0; x < imgZoomOne.getWidth(); x++) {
                    if (x % 2 == 0) {
                        imgZoomOne.setRGB(x, y, img.getRGB(x / n, y));
                    } else {
                        Color a = new Color(imgZoomOne.getRGB(x - 1, y));
                        Color b = new Color(img.getRGB((x / n) + 1, y));
                        Color c = new Color((b.getRed() + a.getRed()) / 2, (b.getGreen() + a.getGreen()) / 2, (b.getBlue() + a.getBlue()) / 2);
                        imgZoomOne.setRGB(x, y, c.getRGB());
                    }
                }
            }

            BufferedImage imgZoomTwo = new BufferedImage(img.getWidth() * n - 1, img.getHeight() * n - 1, img.getType());

            for (int y = 0; y < imgZoomTwo.getHeight(); y++) {
                for (int x = 0; x < imgZoomTwo.getWidth(); x++) {
                    if (y % 2 == 0) {
                        imgZoomTwo.setRGB(x, y, imgZoomOne.getRGB(x, y / n));
                    } else {
                        Color a = new Color(imgZoomTwo.getRGB(x, y - 1));
                        Color b = new Color(imgZoomOne.getRGB(x, (y / n) + 1));
                        Color c = new Color((b.getRed() + a.getRed()) / 2, (b.getGreen() + a.getGreen()) / 2, (b.getBlue() + a.getBlue()) / 2);
                        imgZoomTwo.setRGB(x, y, c.getRGB());
                    }
                }
            }

            lblImg.setIcon(new ImageIcon(imgZoomTwo));
            frame.add(lblImg);

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void methodThree() {
        try {
            int k = 3;
            int op = 0;
            int r,g,b=0;
            boolean maxLeft = false;
            boolean maxTop = false;
            JFrame frame = new JFrame();
            frame.setSize(((img.getWidth() - 1) * k) + 1, ((img.getHeight() - 1) * k) + 1);
            frame.setLocationRelativeTo(null);
            frame.setTitle("K Times Zooming");

            JLabel lblImg = new JLabel();
            lblImg.setSize((( img.getWidth()- 1) * k) + 1, ((img.getHeight() - 1) * k) + 1); //ini size baru nya//
            lblImg.setOpaque(true);

            BufferedImage imgZoomOne = new BufferedImage(((img.getWidth() - 1) * k) + 1, img.getHeight(), img.getType());

            //width lebar nya dlu
            for (int i = 0; i < imgZoomOne.getHeight(); i++) {
                for (int j = 0; j < imgZoomOne.getWidth(); j++) {
                    if (j % k == 0) {
                        if (j + 1 != imgZoomOne.getWidth()) {
                            
                            Color satu = new Color(img.getRGB(j / k, i));
                            Color dua = new Color(img.getRGB((j / k) + 1, i));
                            op = (Math.abs(satu.getRed()-dua.getRed())+
                                    Math.abs(satu.getGreen()-dua.getGreen())+
                                    Math.abs(satu.getBlue()-dua.getBlue()))/3 / k;
                            if (img.getRGB(j / k, i) > img.getRGB(j / k + 1, i)) {
                                maxLeft = true;
                            } else {
                                maxLeft = false;
                            }
                        }

                        imgZoomOne.setRGB(j, i, img.getRGB(j / k, i));
                    } else if (maxLeft) {
                        
                        Color color = new Color(imgZoomOne.getRGB(j-1,i));
                        r = color.getRed();
                        g = color.getGreen();
                        b = color.getBlue();
                        if(color.getRed()-op<0){
                            r = 0;
                        }
                        if(color.getGreen()-op<0){
                            g = 0;
                        }
                        if(color.getBlue()-op<0){
                            b = 0;
                        }
                        Color colorHasil = new Color(r, g, b);
                        imgZoomOne.setRGB(j, i, colorHasil.getRGB());
                    } else {
                        
                        Color color = new Color(imgZoomOne.getRGB(j-1,i));
                        r = color.getRed();
                        g = color.getGreen();
                        b = color.getBlue();
                        if(color.getRed()+op>255){
                            r = 255;
                        }
                        if(color.getGreen()+op>255){
                            g = 255;
                        }
                        if(color.getBlue()+op>255){
                            b = 255;
                        }
                        Color colorHasil = new Color(r, g, b);
                        imgZoomOne.setRGB(j, i, colorHasil.getRGB());
                    }

                    //imgZoom.setRGB(i, j, img.getRGB(((i - 1) / k) + 1, ((j - 1) / k) + 1));
                }
            } //Ini zoom method 1 woi//

            BufferedImage imgZoomTwo = new BufferedImage(((img.getWidth() - 1) * k) + 1, ((img.getHeight() - 1) * k) + 1, img.getType());
            for (int i = 0; i < imgZoomTwo.getHeight(); i++) {
                for (int j = 0; j < imgZoomTwo.getWidth(); j++) {
                    if (i % k == 0) {
                        if (i + 1 != imgZoomTwo.getHeight()) {

                            Color satu = new Color(imgZoomOne.getRGB(j , i/ k));
                            Color dua = new Color(imgZoomOne.getRGB(j , i/ k + 1));
                            op = (Math.abs(satu.getRed()-dua.getRed())+
                                    Math.abs(satu.getGreen()-dua.getGreen())+
                                    Math.abs(satu.getBlue()-dua.getBlue()))/3 / k;
                            if (imgZoomOne.getRGB(j, i / k) > imgZoomOne.getRGB(j, i / k + 1)) {
                                maxTop = true;
                            } else {
                                maxTop = false;
                            }
                        }
                        imgZoomTwo.setRGB(j, i, imgZoomOne.getRGB(j, i / k));
                    } else if (maxTop) {
                        Color color = new Color(imgZoomTwo.getRGB(j,i-1));
                        r = color.getRed();
                        g = color.getGreen();
                        b = color.getBlue();
                        if(color.getRed()-op<0){
                            r = 0;
                        }
                        if(color.getGreen()-op<0){
                            g = 0;
                        }
                        if(color.getBlue()-op<0){
                            b = 0;
                        }
                        Color colorHasil = new Color(r, g, b);
                        imgZoomTwo.setRGB(j, i, colorHasil.getRGB());
                    } else {
                        
                        Color color = new Color(imgZoomTwo.getRGB(j,i-1));
                        r = color.getRed();
                        g = color.getGreen();
                        b = color.getBlue();
                        if(color.getRed()+op>255){
                            r = 255;
                        }
                        if(color.getGreen()+op>255){
                            g = 255;
                        }
                        if(color.getBlue()+op>255){
                            b = 255;
                        }
                        Color colorHasil = new Color(r, g, b);
                        imgZoomTwo.setRGB(j, i, colorHasil.getRGB());
                    }

                    //imgZoom.setRGB(i, j, img.getRGB(((i - 1) / k) + 1, ((j - 1) / k) + 1));
                }
            }

            lblImg.setIcon(new ImageIcon(imgZoomTwo));
            frame.add(lblImg);

            frame.setVisible(true);
        } catch (Exception e) {
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
