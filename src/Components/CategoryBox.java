/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author niketshwetabh
 */
public class CategoryBox extends javax.swing.JPanel {
    
    String name;
    String userMail;

    /**
     * Creates new form CategoryBox
     * @param name
     * @param userMail
     */
    public CategoryBox(String name, String userMail) {
        this.name = name;
        this.userMail = userMail;
        initComponents();
        init(name);
        
    }

    private void init(String name) {
        setBackground(new Color(7, 164, 121));
        setSize(240, 60);
        jLabel1.setText(name);
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setVerticalAlignment(JLabel.CENTER);
        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        add(jLabel1);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openListingView();
            }
        });  
    }
    private void openListingView() {
        ListingView listingView = new ListingView(this.name, this.userMail);
        listingView.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(7, 164, 121));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(7, 164, 121), 1, true));
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(240, 60));
        setSize(new java.awt.Dimension(240, 60));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
