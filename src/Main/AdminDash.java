
package Main;

import Model.Admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import swing.ScrollBar;

public class AdminDash extends javax.swing.JFrame {
    
    public AdminDash(String admin) {
        initComponents();
        dashPanel2.setAdmin(admin);
        dashPanel2.init(admin);
        init(admin);
        sp.setVerticalScrollBar(new ScrollBar());
    }
    
    private void init(String admin){

        fetchList(admin);
        
        ActionListener eventLogout = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                logout();
            }
        };
        menu1.setLogout(eventLogout);      
    }
    
    public void fetchList(String admin){
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
            String query = "select * from LISTING natural join OfType where isApproved = 0 and CategoryName = '"+category+"';";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                String listingId = rs.getString("ListingID");
                //String listingName = rs.getString("ListingName");
                //String desc = rs.getString("Description");
                float amtreq = rs.getFloat("AmountRequired");
                //String accdet = rs.getString("AccountDetails");
                String sdate = rs.getString("StartDate");
                //String edate = rs.getString("EndDate");
                //String cat = rs.getString("CategoryName");
                dashPanel2.addRow(new Object[]{listingId, "mikebhand@gmail.com", amtreq, sdate});
            }
            rs.close();
            stm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    
    public void logout(){
        this.dispose();
        AdminMain.main();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu1 = new Components.Menu();
        sp = new javax.swing.JScrollPane();
        dashPanel2 = new AdminDashboard.DashPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setViewportView(dashPanel2);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(Admin admin) {
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
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDash(admin.getEmail()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private AdminDashboard.DashPanel dashPanel2;
    private Components.Menu menu1;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
