/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Components;

import Windows.MakeDonation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author niketshwetabh
 */
public class ListingView extends javax.swing.JFrame {

    private String userMail;
    /**
     * Creates new form ListingView
     *
     * @param categoryName
     * @param userMail
     */
    public ListingView(String categoryName, String userMail) {
        this.userMail = userMail;
        initComponents();
        init(categoryName);
        populateTable(categoryName);
        
    }

    private void init(String categoryName) {
        setTitle(categoryName + " Listings");
//        setSize(1000, 500);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame
        jLabel1.setText(categoryName + " Listings");
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT, 10, 10);
        layout.setAlignOnBaseline(true); // Align components on their baseline
        layout.setHgap(10); // Horizontal gap between components
        layout.setVgap(10); // Vertical gap between components
        jPanel1.setLayout(layout);
    }

    private void populateTable(String categoryName) {
        String url = "jdbc:mysql://localhost:3306/fundaid";
        String mysqluser = "root";
        String mysqlpwd = "123456789";
        String query = "select * from listing natural join OfType where isApproved = 1 and CategoryName = '" + categoryName + "';";
        try {
            // Establishing a database connection
            Connection conn = DriverManager.getConnection(url, mysqluser, mysqlpwd);

            // Creating a PreparedStatement to execute the SQL query
            PreparedStatement statement = conn.prepareStatement(query);

            // Executing the query
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("ListingName");
                String desc = rs.getString("Description");
                String ID = rs.getString("ListingID");
                String Required = rs.getString("AmountRequired");
                String Received = rs.getString("AmountReceived");
                String endDate = rs.getString("EndDate");
                ListingCard lc = new ListingCard(title, desc, ID, Received, Required, endDate, this.userMail);
                jPanel1.add(lc);
            }

            // Closing resources
            rs.close();
            statement.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 25, 1000, 500));
        setMaximumSize(new java.awt.Dimension(1000, 500));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listings in Category");

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 350));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));
        jPanel1.setSize(new java.awt.Dimension(800, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1)
                .addContainerGap(451, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}