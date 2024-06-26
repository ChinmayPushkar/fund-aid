package Windows;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Chinmay Pushkar
 */
public class CreateListingPage extends javax.swing.JFrame {

    /**
     * Creates new form CreateListingPage
     */
    private String usermail;
    
    public CreateListingPage(){
        
    }
    public CreateListingPage(String usermail) {
        this.usermail = usermail;
        initComponents();
        setDefaultCloseOperation(CreateListingPage.DISPOSE_ON_CLOSE);
        init();
    }
    private void init(){
        getContentPane().setBackground(Color.WHITE);
        myTextField1.setHint("Enter Listing Name");
        myTextField2.setHint("Enter Listing Description");
        myTextField3.setHint("Enter Amount Required");
        myTextField4.setHint("Enter Account Details");
        myTextField5.setHint("Enter End Date (YYYY-MM-DD)");
    }
    

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        myTextField1 = new swing.MyTextField();
        myTextField2 = new swing.MyTextField();
        myTextField3 = new swing.MyTextField();
        myTextField4 = new swing.MyTextField();
        myTextField5 = new swing.MyTextField();
        button1 = new swing.Button();
        button2 = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        jLabel1.setText("Create a New Listing");

        jLabel6.setText("Category");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Health & Medical Supplies", "Food & Nutrition", "Shelter & Housing", "Marriage", "Animal Welfare", "Disaster Relief", "Arts & Culture", "Technology & Innovation", "Enviromental Conservation" }));

        myTextField1.setToolTipText("");

        button1.setBackground(new java.awt.Color(7, 164, 121));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Create Listing");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(7, 164, 121));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Go Back");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(myTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(myTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/fundaid";
        String mysqluser = "root";
        String mysqlpwd = "123456789";
        String insertListingquery = "insert into listing (ListingName, Description, AmountRequired, AccountDetails, StartDate, EndDate) values (?,?,?,?,?,?);";
        String insertCreatesQuery = "INSERT INTO creates (Email, ListingID) VALUES (?,?);";
        String insertOfTypeQuery = "insert into OfType (ListingID, CategoryName) values (?,?);";
        String curdateQuery = "select current_date()";
        String name = myTextField1.getText();
        String desc = myTextField2.getText();
        int amtreq = Integer.parseInt(myTextField3.getText());
        String accdet = myTextField4.getText();        
        String edate = myTextField5.getText();
        String selectedCategory = jComboBox1.getSelectedItem().toString();
        try{
            Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
            
            Statement checkstm = conn.createStatement();
            ResultSet rs1 = checkstm.executeQuery(curdateQuery);
            rs1.next();
            String curdate = rs1.getString("current_date()");
            
            PreparedStatement stm = conn.prepareCall(insertListingquery);
            stm.setString(1,name);
            stm.setString(2,desc);
            stm.setInt(3,amtreq);
            stm.setString(4, accdet);
            stm.setString(5, curdate);
            stm.setString(6, edate);
            stm.execute();
            
            ResultSet rs = stm.getGeneratedKeys();
            int listingID = 0;
            if (rs.next()) {
                listingID = rs.getInt(1);
            }
            
            // Insert into creates table
            PreparedStatement createsStm = conn.prepareStatement(insertCreatesQuery);
            createsStm.setString(1, usermail); // Use the user's email obtained from login
            createsStm.setInt(2, listingID);
            createsStm.executeUpdate();
            
            //Insert into Oftype table
            PreparedStatement oftypestm = conn.prepareStatement(insertOfTypeQuery);
            oftypestm.setInt(1, listingID);
            oftypestm.setString(2, selectedCategory);
            oftypestm.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Listing Successfully created");
            myTextField1.setText(null);
            myTextField2.setText(null);
            myTextField3.setText(null);
            myTextField4.setText(null);            
            myTextField5.setText(null);
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private swing.MyTextField myTextField1;
    private swing.MyTextField myTextField2;
    private swing.MyTextField myTextField3;
    private swing.MyTextField myTextField4;
    private swing.MyTextField myTextField5;
    // End of variables declaration//GEN-END:variables

}
