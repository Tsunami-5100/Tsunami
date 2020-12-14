/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Resident.ResidentDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author edmond
 */
public class MainJFrame extends javax.swing.JFrame{

    /**
     * Creates new form Login
     */
    int hour, minute, second;
            
    EcoSystem ecoSystem;
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public MainJFrame() {
        initComponents();
        ecoSystem = dB4OUtil.retrieveSystem();
        this.setLocationRelativeTo(null);
        this.setSize(1407, 1100);
//        Thread t = new Thread(this);
//        t.start();
        scaleImage();
    }
    
    public void scaleImage() {
        ImageIcon icon = new ImageIcon("D:\\Courses\\2020Fall\\INFO5100\\Aassignements\\FinalProject\\CommunityServiceSystem_2.1\\src\\UserInterface\\images\\icons8-communityservice.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelImage.getWidth(), labelImage.getHeight(), img.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelImage.setIcon(scaledIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        JPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtLoginId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        labelImage = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        labToRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(58, 83, 155));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setLayout(new java.awt.CardLayout());

        JPanel.setBackground(new java.awt.Color(255, 255, 255));
        JPanel.setMaximumSize(new java.awt.Dimension(1300, 820));
        JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 2, 69));
        jLabel2.setText("Login ID");
        JPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 434, -1, -1));

        txtLoginId.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        JPanel.add(txtLoginId, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 479, 374, 49));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Password");
        JPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 592, -1, -1));

        btnLogIn.setBackground(new java.awt.Color(58, 83, 155));
        btnLogIn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(255, 255, 255));
        btnLogIn.setText("LOGIN");
        btnLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });
        JPanel.add(btnLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 770, 128, 40));

        labelImage.setBackground(new java.awt.Color(58, 83, 155));
        labelImage.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        labelImage.setText("Image");
        JPanel.add(labelImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 320));

        fieldPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });
        JPanel.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 637, 374, 49));

        labToRegister.setBackground(new java.awt.Color(58, 83, 155));
        labToRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labToRegister.setForeground(new java.awt.Color(58, 83, 155));
        labToRegister.setText("No account yet? Click here to register.");
        labToRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labToRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labToRegisterMouseClicked(evt);
            }
        });
        JPanel.add(labToRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, -1, -1));

        Container.add(JPanel, "card2");

        getContentPane().add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 1050));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        // TODO add your handling code here:
        String userName = txtLoginId.getText();
        // Get Password
        char[] passwordCharArray = fieldPassword.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount = ecoSystem.getUserAccountDirectory().authenticateUser(userName, password);

        Network inNetwork = null;
        Enterprise inEnterprise = null;
        Organization inOrganization = null;

        if (userAccount == null) {
            //Step 2: Go inside each network and check each enterprise
            for (Network network : ecoSystem.getNetworkList()) {
                //Step 2.a: check against each enterprise
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if (userAccount == null) {
                        //Step 3:check against each organization for each enterprise
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                            if (userAccount != null) {
                                inNetwork = network;
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                break;
                            }
                        }

                    } else {
                        inNetwork = network;
                        inEnterprise = enterprise;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }
        
        if (userAccount == null) {
            for (UserAccount ua : ecoSystem.getResidentDirectory().getResidentAccountList()) {
                if (ua.getUsername().equals(userName) && ua.getPassword().equals(password)){
                    userAccount = ua;
                }                              
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        } else {
            CardLayout layout = (CardLayout) Container.getLayout();
            Container.add("workArea", userAccount.getRole().createWorkArea(Container, userAccount, inOrganization, inEnterprise, inNetwork, ecoSystem));
            layout.next(Container);
        }
        txtLoginId.setText("");
        fieldPassword.setText(""); 

    }//GEN-LAST:event_btnLogInActionPerformed

    private void labToRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labToRegisterMouseClicked
        // TODO add your handling code here:
        txtLoginId.setText("");
        fieldPassword.setText(""); 
        RegisterJPanel rjp = new RegisterJPanel(Container, ecoSystem);
        Container.add("RegisterJPanel", rjp);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_labToRegisterMouseClicked

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel JPanel;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labToRegister;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField txtLoginId;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void run() {
//        while (true) {            
//            Calendar cal = Calendar.getInstance();
//            hour = cal.get(Calendar.HOUR_OF_DAY);
//            minute = cal.get(Calendar.MINUTE);
//            second = cal.get(Calendar.SECOND);
//            
//            SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            Date date = cal.getTime();
//            String time12 = sdf12.format(date);
//            labClock.setText(time12);
//        }
//    }
}