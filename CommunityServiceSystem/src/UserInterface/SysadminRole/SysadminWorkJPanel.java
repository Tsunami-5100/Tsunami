/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SysadminRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Role.HospitalManagerRole;
import Business.Role.KindergartenManagerRole;
import Business.Role.MarketManagerRole;
import Business.Role.PropertyManagerRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class SysadminWorkJPanel extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public SysadminWorkJPanel(JPanel userProcessContainer, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        Thread t = new Thread(this);
        t.start();
        TableUI();
        populateNetworkTable();
        
    }
    
    public void TableUI() {
        tabNetwork.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        tabNetwork.getTableHeader().setOpaque(false);
        tabNetwork.getTableHeader().setBackground(new Color(58, 83, 155));
        tabNetwork.getTableHeader().setForeground(Color.BLACK);
//        DefaultTableCellHeaderRenderer networkRenderer = (DefaultTableCellHeaderRenderer) tabNetwork.getTableHeader().getDefaultRenderer();
//        networkRenderer.setHorizontalAlignment((int) JTable.CENTER_ALIGNMENT);
//        tabNetwork.getTableHeader().setDefaultRenderer(networkRenderer);
        
//        tabNetwork.getTableHeader().;
        
        tabEnterprise.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        tabEnterprise.getTableHeader().setOpaque(false);
        tabEnterprise.getTableHeader().setBackground(new Color(58, 83, 155));
        tabEnterprise.getTableHeader().setForeground(Color.BLACK);
        
        tabAccount.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        tabAccount.getTableHeader().setOpaque(false);
        tabAccount.getTableHeader().setBackground(new Color(58, 83, 155));
        tabAccount.getTableHeader().setForeground(Color.BLACK);
    }
    
    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) tabNetwork.getModel();

        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
            model.addRow(row);
        }
    }
    
    private void populateEnterpriseTable() {
        DefaultTableModel model = (DefaultTableModel) tabEnterprise.getModel();

        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                Object[] row = new Object[3];
                row[0] = enterprise.getName();
                row[1] = enterprise.getEnterpriseType().getValue();
                row[2] = network.getName();

                model.addRow(row);
            }
        }
    }
    
    private void populateAccountTable() {
        DefaultTableModel model = (DefaultTableModel) tabAccount.getModel();

        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    boolean market = userAccount.getRole().toString().equals("Business.Role.MarketManagerRole");
                    boolean property = userAccount.getRole().toString().equals("Business.Role.PropertyManagerRole");
                    boolean hospital = userAccount.getRole().toString().equals("Business.Role.HospitalManagerRole");
                    boolean kinder = userAccount.getRole().toString().equals("Business.Role.KindergartenManagerRole");
                    System.out.println("UserInterface.SysadminRole.SysadminWorkJPanel.populateAccountTable() 114. " + market + property + hospital + kinder);
                    System.out.println("UserInterface.SysadminRole.SysadminWorkJPanel.populateAccountTable() 115. " + userAccount.getRole());
                    if (market|| property || hospital || kinder) {
                        Object[] row = new Object[3];
                        row[0] = userAccount.getUsername();
                        row[1] = enterprise.getName();
                        row[2] = network.getName();

                        model.addRow(row);
                    }
                }
            }
        }
    }
    
    private void populateEComboBox() {
        EComboNetwork.removeAllItems();
        EComboEnterType.removeAllItems();
        

        for (Network network : ecoSystem.getNetworkList()) {
            EComboNetwork.addItem(network);
        }

        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            EComboEnterType.addItem(type);
        }
    }
    
    private void populateANetworkComboBox() {
        AComboNetwork.removeAllItems();
        
        for (Network network : ecoSystem.getNetworkList()){
            AComboNetwork.addItem(network);
        }
    }
    
    private void populateAEpnameComboBox(Network network) {    
        AComboEpName.removeAllItems();
        
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            AComboEpName.addItem(enterprise);
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

        labTime = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNetworkmag = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnEnterprise = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAccount = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        EnterprisePanel = new javax.swing.JPanel();
        ETxtEpName = new javax.swing.JTextField();
        EComboEnterType = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EComboNetwork = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabEnterprise = new javax.swing.JTable();
        EBtnSubmit = new javax.swing.JButton();
        AccountPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabAccount = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        AComboNetwork = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ATxtUserName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ATxtPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ATxtName = new javax.swing.JTextField();
        ABtnSubmit = new javax.swing.JButton();
        AComboEpName = new javax.swing.JComboBox();
        NetworkPanel = new javax.swing.JPanel();
        NBtnSubmit = new javax.swing.JButton();
        NTxtNetwork = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabNetwork = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");

        btnLogout.setBackground(new java.awt.Color(58, 83, 155));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-double_left.png"))); // NOI18N
        btnLogout.setText("Log out");
        btnLogout.setBorder(null);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi, Administrator!");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-network.png"))); // NOI18N
        jLabel2.setText("jLabel1");

        btnNetworkmag.setBackground(new java.awt.Color(58, 83, 155));
        btnNetworkmag.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnNetworkmag.setForeground(new java.awt.Color(255, 255, 255));
        btnNetworkmag.setText("Manage Network");
        btnNetworkmag.setBorder(null);
        btnNetworkmag.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNetworkmag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNetworkmagActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-company.png"))); // NOI18N
        jLabel3.setText("jLabel1");

        btnEnterprise.setBackground(new java.awt.Color(58, 83, 155));
        btnEnterprise.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        btnEnterprise.setText("Manage Enterprise");
        btnEnterprise.setBorder(null);
        btnEnterprise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterpriseActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-admin_settings_male.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        btnAccount.setBackground(new java.awt.Color(58, 83, 155));
        btnAccount.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnAccount.setText("Manage Account");
        btnAccount.setBorder(null);
        btnAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        EnterprisePanel.setBackground(new java.awt.Color(255, 255, 255));
        EnterprisePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ETxtEpName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ETxtEpName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EnterprisePanel.add(ETxtEpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 182, -1));

        EComboEnterType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EnterprisePanel.add(EComboEnterType, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 182, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(58, 83, 155));
        jLabel10.setText("Enterprise Name:");
        EnterprisePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, -1, 41));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(58, 83, 155));
        jLabel11.setText("Enterprise Type:");
        EnterprisePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, 41));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 83, 155));
        jLabel9.setText("Network:");
        EnterprisePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, 41));

        EComboNetwork.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EnterprisePanel.add(EComboNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 182, -1));

        jLabel8.setBackground(new java.awt.Color(58, 83, 155));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(58, 83, 155));
        jLabel8.setText("MANAGE ENTERPRISE");
        EnterprisePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, 48));

        tabEnterprise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Enterprise Name", "Type", "Network"
            }
        ));
        tabEnterprise.setFocusable(false);
        tabEnterprise.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabEnterprise.setRowHeight(25);
        tabEnterprise.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabEnterprise.setShowVerticalLines(false);
        tabEnterprise.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabEnterprise);

        EnterprisePanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 697, 236));

        EBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        EBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        EBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        EBtnSubmit.setText("Submit");
        EBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        EBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EBtnSubmitActionPerformed(evt);
            }
        });
        EnterprisePanel.add(EBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, 132, 42));

        ContentPanel.add(EnterprisePanel, "card3");

        AccountPanel.setBackground(new java.awt.Color(255, 255, 255));
        AccountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(58, 83, 155));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(58, 83, 155));
        jLabel12.setText("MANAGE ACCOUNT");
        AccountPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, 48));

        tabAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User Name", "Enterprise Name", "Network"
            }
        ));
        tabAccount.setFocusable(false);
        tabAccount.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabAccount.setName("abc"); // NOI18N
        tabAccount.setRowHeight(25);
        tabAccount.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabAccount.setShowVerticalLines(false);
        tabAccount.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabAccount);

        AccountPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 644, 236));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("Network:");
        AccountPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, 41));

        AComboNetwork.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AComboNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AComboNetworkActionPerformed(evt);
            }
        });
        AccountPanel.add(AComboNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 182, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 83, 155));
        jLabel14.setText("Enterprise Name:");
        AccountPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, -1, 41));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("User Name:");
        AccountPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, -1, 41));

        ATxtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ATxtUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AccountPanel.add(ATxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 182, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("Password:");
        AccountPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 640, -1, 41));

        ATxtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ATxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AccountPanel.add(ATxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 640, 182, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("Name:");
        AccountPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 710, -1, 41));

        ATxtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ATxtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AccountPanel.add(ATxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 710, 182, -1));

        ABtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        ABtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ABtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        ABtnSubmit.setText("Submit");
        ABtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        ABtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ABtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ABtnSubmitActionPerformed(evt);
            }
        });
        AccountPanel.add(ABtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 800, 132, 42));

        AComboEpName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AComboEpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AComboEpNameActionPerformed(evt);
            }
        });
        AccountPanel.add(AComboEpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 500, 182, -1));

        ContentPanel.add(AccountPanel, "card4");

        NetworkPanel.setBackground(new java.awt.Color(255, 255, 255));
        NetworkPanel.setName(""); // NOI18N
        NetworkPanel.setOpaque(false);
        NetworkPanel.setLayout(null);

        NBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        NBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        NBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        NBtnSubmit.setText("Submit");
        NBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        NBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NBtnSubmitActionPerformed(evt);
            }
        });
        NetworkPanel.add(NBtnSubmit);
        NBtnSubmit.setBounds(640, 660, 132, 42);

        NTxtNetwork.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NTxtNetwork.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        NetworkPanel.add(NTxtNetwork);
        NTxtNetwork.setBounds(540, 570, 320, 40);

        jLabel4.setBackground(new java.awt.Color(58, 83, 155));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("MANAGE NETWORK");
        NetworkPanel.add(jLabel4);
        jLabel4.setBounds(590, 90, 236, 48);

        tabNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Network"
            }
        ));
        tabNetwork.setFocusable(false);
        tabNetwork.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabNetwork.setName("abc"); // NOI18N
        tabNetwork.setRowHeight(25);
        tabNetwork.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabNetwork.setShowVerticalLines(false);
        tabNetwork.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabNetwork);

        NetworkPanel.add(jScrollPane2);
        jScrollPane2.setBounds(400, 210, 600, 236);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 83, 155));
        jLabel5.setText("Please Enter a Network Name:");
        NetworkPanel.add(jLabel5);
        jLabel5.setBounds(400, 480, 317, 80);

        ContentPanel.add(NetworkPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 974, Short.MAX_VALUE)
                        .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnNetworkmag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 347, Short.MAX_VALUE)
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1452, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(117, 117, 117)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnNetworkmag, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(805, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 97, Short.MAX_VALUE)
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNetworkmagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNetworkmagActionPerformed
        // TODO add your handling code here:
        NetworkPanel.setVisible(true);
        EnterprisePanel.setVisible(false);
        AccountPanel.setVisible(false);
        
    }//GEN-LAST:event_btnNetworkmagActionPerformed

    private void btnEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterpriseActionPerformed
        // TODO add your handling code here:
        EnterprisePanel.setVisible(true);
        NetworkPanel.setVisible(false);
        AccountPanel.setVisible(false);
        populateEComboBox();
        populateEnterpriseTable();
    }//GEN-LAST:event_btnEnterpriseActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        AccountPanel.setVisible(true);
        EnterprisePanel.setVisible(false);
        NetworkPanel.setVisible(false);
        populateAccountTable();
        populateANetworkComboBox();
        
    }//GEN-LAST:event_btnAccountActionPerformed

    private void NBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NBtnSubmitActionPerformed
        // TODO add your handling code here:
        String name = NTxtNetwork.getText();
        Network network = ecoSystem.createAndAddNetwork();
        network.setName(name);
        populateNetworkTable();
    }//GEN-LAST:event_NBtnSubmitActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void EBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EBtnSubmitActionPerformed
        // TODO add your handling code here:
        Network network = (Network) EComboNetwork.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) EComboEnterType.getSelectedItem();
        String epName = ETxtEpName.getText();

        if (network == null || type == null) {
            JOptionPane.showMessageDialog(null, "Please select both network and enterprise type!");
            return;
        }
        
        if (network.getEnterpriseDirectory().checkIfEpNameIsUnique(epName)) {
            Enterprise enterprise = network.getEnterpriseDirectory().AddEnterprise(epName, type);
            populateEnterpriseTable();
            return;
        }
        else {
            JOptionPane.showMessageDialog(null, "The enterprise name already exists!");
        }

//        Enterprise enterprise = network.getEnterpriseDirectory().AddEnterprise(epName, type);

        
        
    }//GEN-LAST:event_EBtnSubmitActionPerformed

    private void ABtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ABtnSubmitActionPerformed
        // TODO add your handling code here:
        Enterprise enterprise = (Enterprise) AComboEpName.getSelectedItem();
                
        String username = ATxtUserName.getText();
        String password = ATxtPassword.getText();
        String name = ATxtName.getText();
        Employee employee = enterprise.getEmployeeDirectory().createEmployee(name);
        
        if (enterprise.getEnterpriseType().toString().equals("Hospital")) {
            UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new HospitalManagerRole());
            
        }
        else if (enterprise.getEnterpriseType().toString().equals("Kindergarten")) {
            UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new KindergartenManagerRole());
        }
        else if (enterprise.getEnterpriseType().toString().equals("Market")) {
            UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new MarketManagerRole());
        }
        else if (enterprise.getEnterpriseType().toString().equals("Property")) {
            UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new PropertyManagerRole());
        }
        ATxtUserName.setText("");
        ATxtPassword.setText("");
        ATxtName.setText("");
        populateAccountTable();
    }//GEN-LAST:event_ABtnSubmitActionPerformed

    private void AComboEpNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AComboEpNameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AComboEpNameActionPerformed

    private void AComboNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AComboNetworkActionPerformed
        // TODO add your handling code here:
        Network network = (Network) AComboNetwork.getSelectedItem();
        if (network != null){
            populateAEpnameComboBox(network);
        }
    }//GEN-LAST:event_AComboNetworkActionPerformed
    @Override
    public void run() {
        while (true) {            
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
            
            SimpleDateFormat sdftime = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
            Date date = cal.getTime();
            String timeForm = sdftime.format(date);
            labTime.setText(timeForm);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABtnSubmit;
    private javax.swing.JComboBox AComboEpName;
    private javax.swing.JComboBox AComboNetwork;
    private javax.swing.JTextField ATxtName;
    private javax.swing.JTextField ATxtPassword;
    private javax.swing.JTextField ATxtUserName;
    private javax.swing.JPanel AccountPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JButton EBtnSubmit;
    private javax.swing.JComboBox EComboEnterType;
    private javax.swing.JComboBox EComboNetwork;
    private javax.swing.JTextField ETxtEpName;
    private javax.swing.JPanel EnterprisePanel;
    private javax.swing.JButton NBtnSubmit;
    private javax.swing.JTextField NTxtNetwork;
    private javax.swing.JPanel NetworkPanel;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnEnterprise;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNetworkmag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel labTime;
    private javax.swing.JTable tabAccount;
    private javax.swing.JTable tabEnterprise;
    private javax.swing.JTable tabNetwork;
    // End of variables declaration//GEN-END:variables
}
