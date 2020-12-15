/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdminRole;

import Business.AmbulanceDriver.AmbulanceDriver;
import Business.AmbulanceRequest.AmbulanceRequest;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.KApplication.KApplication;
import Business.KClass.KClass;
import Business.Network.Network;
import Business.Organization.HospitalManagementOrganization;
import Business.Organization.Organization;
import Business.Role.AmbulanceDriverRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class HospitalAdminWorkPanel extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form HospitalWorkPanel
     */
    int hour, minute, second;
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    HospitalManagementOrganization hospitalManagementOrganization;
    HospitalEnterprise hospitalEnterprise;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public HospitalAdminWorkPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.hospitalEnterprise = (HospitalEnterprise)enterprise;
        this.hospitalManagementOrganization = (HospitalManagementOrganization) organization;
        txtWelcome.setText("Welcome, " + userAccount.getUsername() + "!");
        Thread t = new Thread(this);
        t.start();
    }
    
    public void populateAmbulanceDriverTable() {
        DefaultTableModel model = (DefaultTableModel) tabDriver.getModel();
        model.setRowCount(0);
        for (int i=0; i<userAccount.getEmployee().getSubIdList().size(); i ++) {
            for (UserAccount u : hospitalEnterprise.getUserAccountDirectory().getUserAccountList()) {
                if (userAccount.getEmployee().getSubIdList().get(i) == u.getEmployee().getId() && u.getRole().toString().equals("Business.Role.AmbulanceDriverRole")) {
                    for (AmbulanceDriver ad : userAccount.getAmbulanceDriverDirectoy().getAmbulanceDriverList()){
                        if (ad.getEmployeeId() == u.getEmployee().getId()) {
                            Object[] row = new Object[4];
                            row[0] = u;
                            row[1] = u.getEmployee().getName();
                            row[2] = u.getEmployee().getId();
                            row[3] = ad.getAvailability();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }
    
    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) MRTabRequest.getModel();
        model.setRowCount(0);
        System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.populateRequestTable() 85. " + ecoSystem.getAmbulanceRequestDirectory().getAmbulanceRequestList());
        for (AmbulanceRequest ar : ecoSystem.getAmbulanceRequestDirectory().getAmbulanceRequestList()) {
            System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.populateRequestTable()87. Reciever: " + ar.getReceiver() + " Sender: " + ar.getSender());
            System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.populateRequestTable() 87. (1)" + userAccount.getUsername().equals(ar.getReceiver()) + " (2) " + userAccount.getUsername().equals(ar.getSender()));
                if (userAccount.getUsername().equals(ar.getReceiver()) || userAccount.getUsername().equals(ar.getSender())) {
                    System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.populateRequestTable() 88. ");
                    Object[] row = new Object[9];
                    row[0] = ar;
                    row[1] = ar.getUrgencyLevel();
                    row[2] = ar.getInjuredNum();
                    row[3] = ar.getDescription();               
                    row[4] = ar.getLocation();
                    row[5] = ar.getSender();
                    row[6] = ar.getPhoneNum();
                    row[7] = ar.getRequestDate();
                    row[8] = ar.getStatus();
                    model.addRow(row);
                }
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

        txtWelcome = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnAmbulanceDriver = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        DriverPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabDriver = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        DTxtUserName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        DTxtPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        DTxtName = new javax.swing.JTextField();
        DBtnSubmit = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        RequestPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        MRTabRequest = new javax.swing.JTable();
        MRComboDriver = new javax.swing.JComboBox();
        MRBtnRefuse = new javax.swing.JButton();
        MRBtnAssign = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        DashboardPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(255, 255, 255));
        txtWelcome.setText("Welcome, XXX! ");
        add(txtWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 99, 190, 40));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 189, 41, -1));

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 1155, 291, 45));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 281, -1, -1));

        btnDashboard.setBackground(new java.awt.Color(58, 83, 155));
        btnDashboard.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorder(null);
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });
        add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 198, 244, 41));

        btnAmbulanceDriver.setBackground(new java.awt.Color(58, 83, 155));
        btnAmbulanceDriver.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnAmbulanceDriver.setForeground(new java.awt.Color(255, 255, 255));
        btnAmbulanceDriver.setText("Driver Directory");
        btnAmbulanceDriver.setBorder(null);
        btnAmbulanceDriver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAmbulanceDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbulanceDriverActionPerformed(evt);
            }
        });
        add(btnAmbulanceDriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 281, 244, 40));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        DriverPanel.setBackground(new java.awt.Color(255, 255, 255));
        DriverPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(58, 83, 155));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 83, 155));
        jLabel14.setText("MANAGE AMBULANCE DRIVER");
        DriverPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 6, -1, 48));

        tabDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "User Name", "Driver Name", "Driver Id", "Availability"
            }
        ));
        tabDriver.setFocusable(false);
        tabDriver.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabDriver.setName("abc"); // NOI18N
        tabDriver.setRowHeight(25);
        tabDriver.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabDriver.setShowVerticalLines(false);
        tabDriver.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabDriver);

        DriverPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 88, 663, 224));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("User Name:");
        DriverPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 390, -1, 41));

        DTxtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DriverPanel.add(DTxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 397, 182, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("Password:");
        DriverPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 466, -1, 41));

        DTxtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DriverPanel.add(DTxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 473, 182, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("Name:");
        DriverPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 535, -1, 41));

        DTxtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        DriverPanel.add(DTxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 542, 182, -1));

        DBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        DBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        DBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        DBtnSubmit.setText("Submit");
        DBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        DBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBtnSubmitActionPerformed(evt);
            }
        });
        DriverPanel.add(DBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 667, 132, 42));

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance 2.png"))); // NOI18N
        DriverPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 590, 470));

        ContentPanel.add(DriverPanel, "card3");

        RequestPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(58, 83, 155));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 83, 155));
        jLabel18.setText("MANAGE REQUEST");

        MRTabRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Incident Type", "Urgency Level", "Number of Injured", "Description", "Location", "Requester", "Phone #", "Request Time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MRTabRequest.setFocusable(false);
        MRTabRequest.setIntercellSpacing(new java.awt.Dimension(0, 0));
        MRTabRequest.setName("abc"); // NOI18N
        MRTabRequest.setRowHeight(25);
        MRTabRequest.setSelectionBackground(new java.awt.Color(216, 232, 249));
        MRTabRequest.setShowVerticalLines(false);
        MRTabRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(MRTabRequest);
        if (MRTabRequest.getColumnModel().getColumnCount() > 0) {
            MRTabRequest.getColumnModel().getColumn(5).setPreferredWidth(50);
            MRTabRequest.getColumnModel().getColumn(7).setPreferredWidth(150);
            MRTabRequest.getColumnModel().getColumn(8).setPreferredWidth(60);
        }

        MRComboDriver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        MRBtnRefuse.setBackground(new java.awt.Color(255, 255, 255));
        MRBtnRefuse.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MRBtnRefuse.setForeground(new java.awt.Color(58, 83, 155));
        MRBtnRefuse.setText("Refuse");
        MRBtnRefuse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MRBtnRefuse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MRBtnRefuse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRBtnRefuseActionPerformed(evt);
            }
        });

        MRBtnAssign.setBackground(new java.awt.Color(255, 255, 255));
        MRBtnAssign.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MRBtnAssign.setForeground(new java.awt.Color(58, 83, 155));
        MRBtnAssign.setText("Assign");
        MRBtnAssign.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MRBtnAssign.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MRBtnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRBtnAssignActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-siren.png"))); // NOI18N

        javax.swing.GroupLayout RequestPanelLayout = new javax.swing.GroupLayout(RequestPanel);
        RequestPanel.setLayout(RequestPanelLayout);
        RequestPanelLayout.setHorizontalGroup(
            RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(609, 609, 609))
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RequestPanelLayout.createSequentialGroup()
                        .addComponent(MRBtnRefuse, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MRComboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(MRBtnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addGap(421, 421, 421)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RequestPanelLayout.setVerticalGroup(
            RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MRBtnRefuse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MRComboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MRBtnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(279, Short.MAX_VALUE))
        );

        ContentPanel.add(RequestPanel, "card4");

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(58, 83, 155));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("DASHBOARD");

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardPanelLayout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(644, 644, 644))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1047, Short.MAX_VALUE))
        );

        ContentPanel.add(DashboardPanel, "card2");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 99, -1, -1));

        btnRequest.setBackground(new java.awt.Color(58, 83, 155));
        btnRequest.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRequest.setText("Manage Request");
        btnRequest.setBorder(null);
        btnRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 362, 244, 40));

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
        add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1620, 21, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(true);
        DriverPanel.setVisible(false);
        RequestPanel.setVisible(false);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnAmbulanceDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbulanceDriverActionPerformed
        // TODO add your handling code here:        
        DriverPanel.setVisible(true);
        DashboardPanel.setVisible(false);
        RequestPanel.setVisible(false);
        populateAmbulanceDriverTable();
        
    }//GEN-LAST:event_btnAmbulanceDriverActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        RequestPanel.setVisible(true);
        DriverPanel.setVisible(false);
        DashboardPanel.setVisible(false);
        populateRequestTable();
        
        MRComboDriver.removeAllItems();
        for (int i=0; i<userAccount.getEmployee().getSubIdList().size(); i ++) {
            for (UserAccount u : hospitalEnterprise.getUserAccountDirectory().getUserAccountList()) {
                System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.btnRequestActionPerformed() 531. " + hospitalEnterprise.getUserAccountDirectory().getUserAccountList());
                if (userAccount.getEmployee().getSubIdList().get(i) == u.getEmployee().getId() && u.getRole().toString().equals("Business.Role.AmbulanceDriverRole")) {
                    MRComboDriver.addItem(u.getUsername());
                }
            }
        }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void DBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBtnSubmitActionPerformed
        // TODO add your handling code here:
        String username = DTxtUserName.getText();
        String password = DTxtPassword.getText();
        String driverName = DTxtName.getText();
        System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.DBtnSubmitActionPerformed() 496. " + hospitalEnterprise.getEmployeeDirectory().toString());
        Employee employee = hospitalEnterprise.getEmployeeDirectory().createEmployee(driverName);
        employee.setId(hospitalEnterprise.getUserAccountDirectory().getUserAccountList().size()+1);
        userAccount.getEmployee().getSubIdList().add(employee.getId());
        userAccount.getAmbulanceDriverDirectoy().addAmbulanceDriver(employee.getId(), "Available");
//        ecoSystem.getAmbulanceDriverDirectoy().addAmbulanceDriver(employee.getId(), "Available");
        System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.DBtnSubmitActionPerformed() 499. " + employee.getSubIdList());       
        UserAccount account = hospitalEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new AmbulanceDriverRole());
        populateAmbulanceDriverTable();
    }//GEN-LAST:event_DBtnSubmitActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void MRBtnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRBtnAssignActionPerformed
        // TODO add your handling code here:
    int selectedClass = MRTabRequest.getSelectedRow();
            
    if (selectedClass < 0){
        JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
    }         
    else {
        AmbulanceRequest ar = (AmbulanceRequest)MRTabRequest.getValueAt(selectedClass, 0);
        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
        Date dNow = new Date();
        ar.setResolveDate(dateformat.format(dNow));
        ar.setSender(userAccount.getUsername());
        ar.setReceiver(String.valueOf(MRComboDriver.getSelectedItem()));
        ar.setStatus("Assigned to a diver");
        System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.MRBtnAssignActionPerformed() 602. " + ar.getResolveDate().toString());
        populateRequestTable();
        for (UserAccount u : hospitalEnterprise.getUserAccountDirectory().getUserAccountList()) {
            if (u.getRole().toString().equals("Business.Role.AmbulanceDriverRole")) {
                for (AmbulanceDriver ad : userAccount.getAmbulanceDriverDirectoy().getAmbulanceDriverList()) {
                    if (ad.getEmployeeId() == u.getEmployee().getId() && u.getUsername().equals(String.valueOf(MRComboDriver.getSelectedItem()))) {
                        ad.setAvailability("Not available");
                    }
            
                }
            } 
        }
    }
    }//GEN-LAST:event_MRBtnAssignActionPerformed

    private void MRBtnRefuseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRBtnRefuseActionPerformed
        // TODO add your handling code here:
    int selectedClass = MRTabRequest.getSelectedRow();
            
    if (selectedClass < 0){
        JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    else {
        String message = JOptionPane.showInputDialog(null, "Message: ","Input",JOptionPane.INFORMATION_MESSAGE);
            try {
                if(message.equals(null)) {
                
                }
                else {
                    AmbulanceRequest ar = (AmbulanceRequest)MRTabRequest.getValueAt(selectedClass, 0);
                    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
                    Date dNow = new Date();
                    ar.setResolveDate(dateformat.format(dNow));                    
                    ar.setStatus("Refused");
                    ar.setMessage(message);
    
                    System.out.println("UserInterface.HospitalAdminRole.HospitalAdminWorkPanel.MRBtnAssignActionPerformed() 602. " + ar.getResolveDate().toString());
                    populateRequestTable();
                }
            
            } catch (Exception e) {
                
            }            
    }
    
    }//GEN-LAST:event_MRBtnRefuseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JButton DBtnSubmit;
    private javax.swing.JTextField DTxtName;
    private javax.swing.JTextField DTxtPassword;
    private javax.swing.JTextField DTxtUserName;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel DriverPanel;
    private javax.swing.JButton MRBtnAssign;
    private javax.swing.JButton MRBtnRefuse;
    private javax.swing.JComboBox MRComboDriver;
    private javax.swing.JTable MRTabRequest;
    private javax.swing.JPanel RequestPanel;
    private javax.swing.JButton btnAmbulanceDriver;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labTime;
    private javax.swing.JTable tabDriver;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
       while (true) {            
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
            
            SimpleDateFormat sdftime = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
            Date date = cal.getTime();
            String timeForm = sdftime.format(date);
            labTime.setText(timeForm);
        }
    }
}
