/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TeacherRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.KindergartenEnterprise;
import Business.KApplication.KApplication;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.TeacherOrganization;
import Business.UserAccount.UserAccount;
import Business.KClass.KClass;
import Business.KindergartenStudent.KindergartenStudent;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class TeacherWorkJPanel extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    KindergartenEnterprise kindergartenEnterprise;
    TeacherOrganization teacherOrganization;
    Network network;
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public TeacherWorkJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = account;
        this.teacherOrganization = (TeacherOrganization) organization;
        this.kindergartenEnterprise = (KindergartenEnterprise) enterprise;
        this.network = network;
        labWelcome.setText("Welcome, " + userAccount.getUsername() + "!");

        Thread t = new Thread(this);
        t.start();
    }
    
    public void populateClassTable() {
        DefaultTableModel model = (DefaultTableModel) tabKClass.getModel();
        model.setRowCount(0);

        if (userAccount.getClassList() != null) {
            for (KClass kc : userAccount.getClassList()) {
                Object[] row = new Object[9];
                row[0] = kc;
                row[1] = kc.getClassType();
                row[2] = userAccount.getEmployee().getName();
                row[3] = kc.getCapacity();
                row[4] = kc.getRemainPlaces();
                row[5] = kc.getDeadline();
                row[6] = kc.getStartDate();
                row[7] = kc.getEndDate();
                row[8] = kc.getStudentNum();
                model.addRow(row);
            }
        }
    }
    
    public void populateKApplicaitonTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();

        model.setRowCount(0);
            for (KApplication ka : ecoSystem.getkAppicationDirectory().getkApplicationList()) {
                if (userAccount.getUsername().equals(ka.getReceiver())) {
                    Object[] row = new Object[8];
                    row[0] = ka;
                    row[1] = ka.getClassName();
                    row[2] = ka.getKidName();
                    row[3] = ka.getKidAge();
                    row[4] = ka.getSender();
                    row[5] = ka.getEmail();
                    row[6] = ka.getStatus();
                    row[7] = ka.getRequestDate();
                    
                    model.addRow(row);
                }
            }
    }
    
    public void populateAllStudentDirectory() {
        DefaultTableModel model = (DefaultTableModel) tabStudentDirectory.getModel();

        model.setRowCount(0);
            for (KindergartenStudent ks : userAccount.getKindergartenStudentDirectory().getKindergartenStudentList()) {               
                    Object[] row = new Object[7];
                    row[0] = ks;
                    row[1] = ks.getStudentAge();
                    row[2] = ks.getStudentId();
                    row[3] = ks.getGuardian();               
                    row[4] = ks.getClassName();
                    row[5] = ks.getEmail();
                    row[6] = ks.getPhoneNum();
                    model.addRow(row);
            }
    }
    
    public void populateSelectedClassStudent() {
        DefaultTableModel model = (DefaultTableModel) tabStudentDirectory.getModel();

        model.setRowCount(0);
            for (KindergartenStudent ks : userAccount.getKindergartenStudentDirectory().getKindergartenStudentList()) {
                if (ks.getClassName().equals(SDComboClassList.getSelectedItem())) {
                    Object[] row = new Object[7];
                    row[0] = ks;
                    row[1] = ks.getStudentAge();
                    row[2] = ks.getStudentId();
                    row[3] = ks.getGuardian();               
                    row[4] = ks.getClassName();
                    row[5] = ks.getEmail();
                    row[6] = ks.getPhoneNum();
                    model.addRow(row);
                }
            }
    }
        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTime = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        labWelcome = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnMyStudent = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        btnMarkread = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        MyClassPanel = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabKClass = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        MCTxtCapacity = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        MCTxtDeadline = new javax.swing.JTextField();
        MCBtnSubmit = new javax.swing.JButton();
        MCComboClassType = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        MCTxtClassName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        MCTxtSdate = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        MCTxtEDate = new javax.swing.JTextField();
        MyStudnetPanel = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabStudentDirectory = new javax.swing.JTable();
        SDComboClassList = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        ManageApplication = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        MABtnAccept = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tabApplication = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnMyClass = new javax.swing.JButton();
        btnManageApplication = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 291, 45));

        jButton6.setBackground(new java.awt.Color(58, 83, 155));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-double_left.png"))); // NOI18N
        jButton6.setText("Log out");
        jButton6.setBorder(null);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1640, 50, 140, 40));

        labWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labWelcome.setText("Hi,*** ");
        add(labWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 48, 250, 40));

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
        add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, 40));

        btnMyStudent.setBackground(new java.awt.Color(58, 83, 155));
        btnMyStudent.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMyStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnMyStudent.setText("My Student");
        btnMyStudent.setBorder(null);
        btnMyStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMyStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyStudentActionPerformed(evt);
            }
        });
        add(btnMyStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 240, 40));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-registration.png"))); // NOI18N
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 60));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableNotification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Addresser", "Content"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableNotification.setFocusable(false);
        TableNotification.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableNotification.setRowHeight(30);
        TableNotification.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableNotification.setShowVerticalLines(false);
        TableNotification.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableNotification);

        DashboardPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 630, 280));

        btnMarkread.setBackground(new java.awt.Color(255, 255, 255));
        btnMarkread.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnMarkread.setForeground(new java.awt.Color(58, 83, 155));
        btnMarkread.setText("Markread");
        btnMarkread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMarkread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarkread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkreadActionPerformed(evt);
            }
        });
        DashboardPanel.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 620, 170, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(58, 83, 155));
        jLabel27.setText("You have * new Notifications:");
        DashboardPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 330, 30));

        jLabel35.setBackground(new java.awt.Color(58, 83, 155));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(58, 83, 155));
        jLabel35.setText("DASHBOARD");
        DashboardPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        ContentPanel.add(DashboardPanel, "card5");

        MyClassPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setBackground(new java.awt.Color(58, 83, 155));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("My Class");

        tabKClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Class Name", "Class Type", "Teacher", "Capacity", "Remaining Places", "Deadline", "Start Date", "End Date", "Studnet Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabKClass.setFocusable(false);
        tabKClass.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabKClass.setRowHeight(30);
        tabKClass.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabKClass.setShowVerticalLines(false);
        tabKClass.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tabKClass);
        if (tabKClass.getColumnModel().getColumnCount() > 0) {
            tabKClass.getColumnModel().getColumn(0).setResizable(false);
            tabKClass.getColumnModel().getColumn(2).setPreferredWidth(40);
            tabKClass.getColumnModel().getColumn(3).setResizable(false);
            tabKClass.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabKClass.getColumnModel().getColumn(5).setPreferredWidth(50);
            tabKClass.getColumnModel().getColumn(7).setPreferredWidth(50);
            tabKClass.getColumnModel().getColumn(8).setPreferredWidth(120);
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("Class Type:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("Capacity:");

        MCTxtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCTxtCapacity.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 83, 155));
        jLabel18.setText("Deadline:");

        MCTxtDeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCTxtDeadline.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        MCBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        MCBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MCBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        MCBtnSubmit.setText("Submit");
        MCBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MCBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MCBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCBtnSubmitActionPerformed(evt);
            }
        });

        MCComboClassType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCComboClassType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DayCare", "Pre-School", "Pre-Kindergarten" }));
        MCComboClassType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCComboClassTypeActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(58, 83, 155));
        jLabel20.setText("Class Name:");

        MCTxtClassName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCTxtClassName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(58, 83, 155));
        jLabel21.setText("Start Date:");

        MCTxtSdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCTxtSdate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(58, 83, 155));
        jLabel22.setText("End Date:");

        MCTxtEDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MCTxtEDate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout MyClassPanelLayout = new javax.swing.GroupLayout(MyClassPanel);
        MyClassPanel.setLayout(MyClassPanelLayout);
        MyClassPanelLayout.setHorizontalGroup(
            MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyClassPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyClassPanelLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(554, 554, 554)))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyClassPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MyClassPanelLayout.createSequentialGroup()
                            .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel20))
                            .addGap(133, 133, 133)
                            .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(MCTxtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MCComboClassType, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MCTxtClassName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MyClassPanelLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MCTxtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MyClassPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel21))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MCTxtSdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MCTxtEDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyClassPanelLayout.createSequentialGroup()
                        .addComponent(MCBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)))
                .addGap(503, 503, 503))
        );
        MyClassPanelLayout.setVerticalGroup(
            MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyClassPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel73)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCTxtClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCComboClassType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCTxtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCTxtDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCTxtSdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCTxtEDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addComponent(MCBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        ContentPanel.add(MyClassPanel, "card3");

        MyStudnetPanel.setBackground(new java.awt.Color(255, 255, 255));
        MyStudnetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(58, 83, 155));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(58, 83, 155));
        jLabel50.setText("Student Directory");
        MyStudnetPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        tabStudentDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student Name", "Age", "Student Id", "Guardian ", "Class", "Email", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabStudentDirectory.setFocusable(false);
        tabStudentDirectory.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabStudentDirectory.setRowHeight(30);
        tabStudentDirectory.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabStudentDirectory.setShowVerticalLines(false);
        tabStudentDirectory.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabStudentDirectory);
        if (tabStudentDirectory.getColumnModel().getColumnCount() > 0) {
            tabStudentDirectory.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        MyStudnetPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 990, 490));

        SDComboClassList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SDComboClassList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SDComboClassListMouseClicked(evt);
            }
        });
        SDComboClassList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SDComboClassListActionPerformed(evt);
            }
        });
        MyStudnetPanel.add(SDComboClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 210, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 83, 155));
        jLabel7.setText("Class:");
        jLabel7.setToolTipText("");
        MyStudnetPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        ContentPanel.add(MyStudnetPanel, "card4");

        ManageApplication.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setBackground(new java.awt.Color(58, 83, 155));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(58, 83, 155));
        jLabel36.setText("MANAGE APPLICATION");

        MABtnAccept.setBackground(new java.awt.Color(255, 255, 255));
        MABtnAccept.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MABtnAccept.setForeground(new java.awt.Color(58, 83, 155));
        MABtnAccept.setText("Accept");
        MABtnAccept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MABtnAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MABtnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MABtnAcceptActionPerformed(evt);
            }
        });

        tabApplication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kindergarten", "Class Name", "Kid Name", "Age", "Guardian", "Email", "Status", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabApplication.setFocusable(false);
        tabApplication.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabApplication.setRowHeight(30);
        tabApplication.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabApplication.setShowVerticalLines(false);
        tabApplication.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(tabApplication);
        if (tabApplication.getColumnModel().getColumnCount() > 0) {
            tabApplication.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabApplication.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabApplication.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        javax.swing.GroupLayout ManageApplicationLayout = new javax.swing.GroupLayout(ManageApplication);
        ManageApplication.setLayout(ManageApplicationLayout);
        ManageApplicationLayout.setHorizontalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGroup(ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 1173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(582, 582, 582)
                        .addComponent(jLabel36)))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageApplicationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(634, 634, 634))
        );
        ManageApplicationLayout.setVerticalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel36)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );

        ContentPanel.add(ManageApplication, "card7");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 128, 1460, 1080));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-student_male.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        btnMyClass.setBackground(new java.awt.Color(58, 83, 155));
        btnMyClass.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMyClass.setForeground(new java.awt.Color(255, 255, 255));
        btnMyClass.setText("My Class");
        btnMyClass.setBorder(null);
        btnMyClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMyClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyClassActionPerformed(evt);
            }
        });
        add(btnMyClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 240, 40));

        btnManageApplication.setBackground(new java.awt.Color(58, 83, 155));
        btnManageApplication.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnManageApplication.setForeground(new java.awt.Color(255, 255, 255));
        btnManageApplication.setText("Manage Application");
        btnManageApplication.setBorder(null);
        btnManageApplication.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageApplicationActionPerformed(evt);
            }
        });
        add(btnManageApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 240, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(true);
        MyClassPanel.setVisible(false);
        MyStudnetPanel.setVisible(false);
        ManageApplication.setVisible(false);    
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnMyStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyStudentActionPerformed
        MyStudnetPanel.setVisible(true);
        ManageApplication.setVisible(false);
        DashboardPanel.setVisible(false);      
        MyClassPanel.setVisible(false);
        
        SDComboClassList.removeAllItems();
        SDComboClassList.addItem("All");
        for(KClass kc : userAccount.getClassList()) {               
                SDComboClassList.addItem(kc.getClassName());
        }
        populateAllStudentDirectory();
        
    }//GEN-LAST:event_btnMyStudentActionPerformed

   
    public void refreshTeacherTable(){
    }    
    private void btnMarkreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkreadActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnMarkreadActionPerformed

    private void btnMyClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyClassActionPerformed
        // TODO add your handling code here:
        MyClassPanel.setVisible(true);
        MyStudnetPanel.setVisible(false);
        DashboardPanel.setVisible(false);
        ManageApplication.setVisible(false);
        populateClassTable();
    }//GEN-LAST:event_btnMyClassActionPerformed

    private void MCBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCBtnSubmitActionPerformed
        // TODO add your handling code here:
        KClass kc = new KClass();
        String className = MCTxtClassName.getText();
        String classType = String.valueOf(MCComboClassType.getSelectedItem());
        int capacity = Integer.parseInt(MCTxtCapacity.getText());
        String teacherName = userAccount.getEmployee().getName();
        int teacherId = userAccount.getEmployee().getId();
        String startDate = MCTxtSdate.getText();
        String endDate = MCTxtEDate.getText();
        String deadline = MCTxtDeadline.getText();
        kc.setClassName(className);
        kc.setTeacherName(teacherName);
        kc.setTeacherId(teacherId);
        kc.setClassType(classType);
        kc.setCapacity(capacity);
        kc.setRemainPlaces(capacity);
        kc.setStartDate(startDate);
        kc.setEndDate(endDate);
        kc.setDeadline(deadline);
        kc.setTeacherUserName(userAccount.getUsername());
        System.out.println("UserInterface.TeacherRole.TeacherWorkJPanel.MCBtnSubmitActionPerformed() 1013. username" + kc.getTeacherUserName());

        userAccount.getClassList().add(kc);
        kindergartenEnterprise.getAllClassList().add(kc);
        populateClassTable();
        MCTxtClassName.setText("");
        MCTxtCapacity.setText("");
        MCTxtDeadline.setText("");
        MCTxtEDate.setText("");
        MCTxtSdate.setText("");
        
    }//GEN-LAST:event_MCBtnSubmitActionPerformed

    private void MCComboClassTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCComboClassTypeActionPerformed
        // TODO add your handling code here:
        }

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
    }//GEN-LAST:event_MCComboClassTypeActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_jButton6ActionPerformed

//GEN-FIRST:event_btnInformationActionPerformed
 
//GEN-LAST:event_btnInformationActionPerformed

    private void btnManageApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageApplicationActionPerformed
        // TODO add your handling code here:
        MyStudnetPanel.setVisible(false);
        ManageApplication.setVisible(true);
        DashboardPanel.setVisible(false);      
        MyClassPanel.setVisible(false);
        populateKApplicaitonTable();
    }//GEN-LAST:event_btnManageApplicationActionPerformed

    private void MABtnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MABtnAcceptActionPerformed
        // TODO add your handling code here:
        int row = tabApplication.getSelectedRow();
        
        if(row >=0){
            int selectionResult = JOptionPane.showConfirmDialog(null, "Do you confirm the application?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(selectionResult == JOptionPane.YES_OPTION){
            KApplication ka = (KApplication) tabApplication.getValueAt(row, 0);
            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
            Date dNow = new Date();
            ka.setResolveDate(dateformat.format(dNow));
            ka.setStatus("Accepted");
            
            for (KClass kcl : userAccount.getClassList()) {
                if (kcl.getClassName().equals(ka.getClassName())) {
                    kcl.setStudentNum(kcl.getStudentNum()+1);
                    kcl.setRemainPlaces(kcl.getRemainPlaces()-1);
                    System.out.println("UserInterface.TeacherRole.TeacherWorkJPanel.MABtnAcceptActionPerformed() 1080. sNum: " + kcl.getStudentNum());
                }
            }
            
            KindergartenStudent ks = new KindergartenStudent();
            ks.setClassName(ka.getClassName());
            ks.setGuardian(ka.getSender());
            ks.setEmail(ka.getEmail());
            ks.setPhoneNum(ka.getPhoneNum());
            ks.setStudentId(kindergartenEnterprise.getKindergartenStudentDirectory().getKindergartenStudentList().size()+1);
            ks.setStudentName(ka.getKidName());
            ks.setStudentAge(ka.getKidAge());
            ks.setTeacherUserName(ka.getReceiver());
            userAccount.getKindergartenStudentDirectory().getKindergartenStudentList().add(ks);
            kindergartenEnterprise.getKindergartenStudentDirectory().getKindergartenStudentList().add(ks);
            
            populateClassTable();
            populateKApplicaitonTable();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MABtnAcceptActionPerformed

    private void SDComboClassListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDComboClassListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SDComboClassListActionPerformed

    private void SDComboClassListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SDComboClassListMouseClicked
        // TODO add your handling code here:
        SDComboClassList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                Object selectedItem = event.getItem();
                if (selectedItem == SDComboClassList.getSelectedItem()) {
                    populateSelectedClassStudent();
                }
                
                if (selectedItem.equals("All")) {
                    populateAllStudentDirectory();
                }
            }
        });
    }//GEN-LAST:event_SDComboClassListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JButton MABtnAccept;
    private javax.swing.JButton MCBtnSubmit;
    private javax.swing.JComboBox MCComboClassType;
    private javax.swing.JTextField MCTxtCapacity;
    private javax.swing.JTextField MCTxtClassName;
    private javax.swing.JTextField MCTxtDeadline;
    private javax.swing.JTextField MCTxtEDate;
    private javax.swing.JTextField MCTxtSdate;
    private javax.swing.JPanel ManageApplication;
    private javax.swing.JPanel MyClassPanel;
    private javax.swing.JPanel MyStudnetPanel;
    private javax.swing.JComboBox SDComboClassList;
    private javax.swing.JTable TableNotification;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnManageApplication;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnMyClass;
    private javax.swing.JButton btnMyStudent;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labWelcome;
    private javax.swing.JTable tabApplication;
    private javax.swing.JTable tabKClass;
    private javax.swing.JTable tabStudentDirectory;
    // End of variables declaration//GEN-END:variables
}
