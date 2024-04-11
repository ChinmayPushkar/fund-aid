
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Components.PanelCover;
import Components.PanelLoginAndRegister;
import Main.AdminMain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {
    
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister LoginAndRegister;
    private boolean isLogin;
    private boolean isAdmin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###"); 
    
    public Main() {
        initComponents();
        init();
    }
    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            }
        };
        LoginAndRegister = new PanelLoginAndRegister(eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
               double fractionCover;
               double fractionLogin;
               double size = coverSize;
               if(fraction<0.5f){
                   size += fraction*addSize;
               }else{
                   size += addSize - fraction*addSize;
               }
               if(isLogin){
                   fractionCover = 1f- fraction;
                   fractionLogin = fraction;
                   if(fraction>0.5f){
                       cover.registerRight(fractionCover*100);
                   }else{
                       cover.loginRight(fractionLogin * 100);
                   }
               }
               else{
                   fractionCover = fraction;
                   fractionLogin = 1f - fraction;
                   if(fraction<=0.5f){
                       cover.registerLeft(fraction * 100);
                   }else{
                       cover.loginLeft((1f - fraction) * 100);
                   }
               }
               if(fraction>=0.5f){
                   LoginAndRegister.showRegister(isLogin);
               }
               fractionCover = Double.valueOf(df.format(fractionCover));
               fractionLogin = Double.valueOf(df.format(fractionLogin));
               
               layout.setComponentConstraints(cover, "width "+ size +"%, pos "+fractionCover+"al 0 n 100%");
               layout.setComponentConstraints(LoginAndRegister, "width "+ loginSize +"%, pos "+fractionLogin+"al 0 n 100%");
               bg.revalidate();
            }
            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.add(cover,"width "+coverSize+"%, pos 0al 0 n 100%");
        bg.add(LoginAndRegister,"width "+loginSize+"%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!animator.isRunning()){
                    animator.start();
                }
            }
           }
        );
        //LoginAndRegister.addEvent(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent ae) {
        //        Adminlogin();
        //    }
        //   }
        //);
     
    }
    
    private void login(){
        System.out.println("working");
        String url = "jdbc:mysql://localhost:3306/fundaid";
        String mysqluser = "root";
        String mysqlpwd = "123456789";
        String pwd = LoginAndRegister.getLoginPswd();
        String usermail = LoginAndRegister.getLoginEmail();
        System.out.println(usermail);
        System.out.println(usermail);
        String query = ("select Password from User where Email = '"+usermail+"';");
        try{
            Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if(rs.next()){
                String realpwd = rs.getString("Password");
                
                if(realpwd.equals(pwd)){
                    this.dispose();
                    AdminMain.main();
                }else{
                    JOptionPane.showMessageDialog(this,"Email or Password Incorrect");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Wrong Email ID");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
       this.dispose();
       
    }
    
    private void Adminlogin() {
        this.dispose();
        AdminMain.main();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
