/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package AdminDashboard;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import swing.ScrollBar;

public class DashPanel extends javax.swing.JPanel {

    private String admin;

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
    public DashPanel() {
        initComponents();
        //init();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icon/dollar-2.png"))," ",0));
        
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        CellAction event = new CellAction(){
            
            @Override
            public void onAccept(int row){
                String url = "jdbc:mysql://localhost:3306/fundaid";
                String mysqluser = "root";
                String mysqlpwd = "123456789";
                String query = "update LISTING set isApproved = 1, isActive = 1 where ListingID = ?;";
                String query1 = "insert into ApprovedBy (Admin_ID, ListingID) values (?,?);";
                String LID = table.getValueAt(row, 0).toString();
                try{
                    Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
                    
                    PreparedStatement stm = conn.prepareCall(query);
                    stm.setString(1, LID);
                    stm.execute();
                    
                    PreparedStatement stm1 = conn.prepareCall(query1);
                    stm1.setString(1, admin);
                    stm1.setString(2,LID);
                    stm1.execute();

                    stm.close();
                    if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
                }
            }
            @Override
            public void onReject(int row){
                String url = "jdbc:mysql://localhost:3306/fundaid";
                String mysqluser = "root";
                String mysqlpwd = "123456789";
                String query = "update LISTING set isApproved = -1, isActive = 1 where ListingID = ?;";
                String LID = table.getValueAt(row, 0).toString();
                try{
                    Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
                    
                    PreparedStatement stm = conn.prepareCall(query);
                    stm.setString(1, LID);
                    stm.execute();
                    stm.close();
                    
                    if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(new JFrame(),e.getMessage());
                }
            }
        };
        table.setEvent(event);
        
    }
    public void init(String admin){
        String url = "jdbc:mysql://localhost:3306/fundaid";
        String mysqluser = "root";
        String mysqlpwd = "123456789";
        String catQuery = "select CategoryName from Managedby where Admin_ID = '"+admin+"';";
        
        try{
            Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
            
            //finding category
            Statement catstm = conn.createStatement();
            ResultSet rss = catstm.executeQuery(catQuery);
            rss.next();
            String category = rss.getString("CategoryName");
            String query = "select * from Category where CategoryName = '"+category+"';";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            float amt = rs.getFloat("TotalAmount");
            String cat = rs.getString("CategoryName");
            System.out.println("working");
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/Icon/dollar-2.png")),cat,amt));
            
            rs.close();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
        
    }
    
    public void addRow(Object[] row){
        table.addRow(row);
    }
    public void setEvent(CellAction event){
        table.setEvent(event);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table1 = new AdminDashboard.Table();
        table2 = new AdminDashboard.Table();
        table3 = new AdminDashboard.Table();
        table4 = new AdminDashboard.Table();
        cardPanel = new javax.swing.JLayeredPane();
        card1 = new AdminDashboard.Cards();
        panelBorder1 = new swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new AdminDashboard.Table();

        setBackground(new java.awt.Color(245, 245, 245));

        cardPanel.setLayout(new java.awt.GridLayout(1, 0));

        card1.setColor1(new java.awt.Color(52, 143, 80));
        card1.setColor2(new java.awt.Color(52, 133, 128));
        cardPanel.add(card1);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(91, 91, 91));
        jLabel1.setText("Unapproved Listings");

        spTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "UserID", "Amount", "Start Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionBackground(new java.awt.Color(57, 137, 111));
        spTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addContainerGap(588, Short.MAX_VALUE))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spTable)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AdminDashboard.Cards card1;
    private javax.swing.JLayeredPane cardPanel;
    private javax.swing.JLabel jLabel1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private AdminDashboard.Table table;
    private AdminDashboard.Table table1;
    private AdminDashboard.Table table2;
    private AdminDashboard.Table table3;
    private AdminDashboard.Table table4;
    // End of variables declaration//GEN-END:variables
}
