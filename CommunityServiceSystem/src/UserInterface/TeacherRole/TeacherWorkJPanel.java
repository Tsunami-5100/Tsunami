/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TeacherRole;

//import UserInterface.Doctor.*;
//import UserInterface.SupermarkAdmin.*;
//import UserInterface.HospitalAdmin.*;
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
import java.awt.CardLayout;
//import Business.Hospital.Ambulance;
//import Business.Hospital.Doctor;
//import Business.Hospital.Hospital;
//import Business.Hospital.Patient;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
        System.out.println("UserInterface.TeacherRole.TeacherWorkJPanel.<init>() 70. " + ecoSystem);

        Thread t = new Thread(this);
        t.start();
    }
    
    public void populateClassTable() {
        DefaultTableModel model = (DefaultTableModel) tabKClass.getModel();
        model.setRowCount(0);

        if (userAccount.getClassList() != null) {
            for (KClass kc : userAccount.getClassList()) {
                Object[] row = new Object[8];
                row[0] = kc;
                row[1] = kc.getClassType();
                row[2] = userAccount.getEmployee().getName();
                row[3] = kc.getCapacity();
                row[4] = kc.getDeadline();
                row[5] = kc.getStartDate();
                row[6] = kc.getEndDate();
                row[7] = kc.getStudentNum();
                model.addRow(row);
            }
        }
    }
    
    public void populateKApplicaitonTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();

        model.setRowCount(0);
        System.out.println("UserInterface.TeacherRole.TeacherWorkJPanel.populateKApplicaitonTable() 100. " + ecoSystem);
        System.out.println("UserInterface.TeacherRole.TeacherWorkJPanel.populateKApplicaitonTable() 101. " + ecoSystem.getkAppicationDirectory().getkApplicationList());
        if (ecoSystem.getkAppicationDirectory().getkApplicationList() !=null) {
            for (KApplication ka : ecoSystem.getkAppicationDirectory().getkApplicationList()) {
                Object[] row = new Object[7];
                row[0] = ka.getSender();
                row[1] = ka.getKidName();
                row[2] = ka.getKidAge();
                row[3] = ka.getClassName();
                row[4] = ka.getRequestDate();
                row[5] = ka.getStatus();
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTime = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnMyStudent = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelComplaintNum = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        labelPatientNum = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelDoctorNum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        btnMarkread = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
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
        txtViewStudent = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btnViewBus1 = new javax.swing.JButton();
        StudentJPanel = new javax.swing.JPanel();
        StudentNull = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        StudentDetails = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCommnuity = new javax.swing.JTable();
        ManageApplication = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        MABtnAccept = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tabApplication = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnMyClass = new javax.swing.JButton();
        btnManageApplication = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi,*** ");

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

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-registration.png"))); // NOI18N

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(58, 83, 155));

        labelComplaintNum.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelComplaintNum.setForeground(new java.awt.Color(255, 255, 255));
        labelComplaintNum.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(labelComplaintNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelComplaintNum)
                .addGap(30, 30, 30))
        );

        DashboardPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 160, -1));

        jPanel8.setBackground(new java.awt.Color(58, 83, 155));

        labelPatientNum.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelPatientNum.setForeground(new java.awt.Color(255, 255, 255));
        labelPatientNum.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(labelPatientNum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelPatientNum)
                .addGap(30, 30, 30))
        );

        DashboardPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 160, -1));

        jPanel9.setBackground(new java.awt.Color(58, 83, 155));

        labelDoctorNum.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelDoctorNum.setForeground(new java.awt.Color(255, 255, 255));
        labelDoctorNum.setText("$200");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(labelDoctorNum, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(labelDoctorNum)
                .addGap(29, 29, 29))
        );

        DashboardPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, -1));

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

        DashboardPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 630, 280));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(58, 83, 155));
        jLabel26.setText("Complaint Received");
        DashboardPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 170, 30));

        btnMarkread.setBackground(new java.awt.Color(255, 255, 255));
        btnMarkread.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMarkread.setForeground(new java.awt.Color(58, 83, 155));
        btnMarkread.setText("Markread");
        btnMarkread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMarkread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarkread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkreadActionPerformed(evt);
            }
        });
        DashboardPanel.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 750, 170, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(58, 83, 155));
        jLabel27.setText("You have * new Notifications:");
        DashboardPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 330, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(58, 83, 155));
        jLabel28.setText("Payments ");
        DashboardPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 90, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(58, 83, 155));
        jLabel33.setText("Students Amount");
        DashboardPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        jLabel35.setBackground(new java.awt.Color(58, 83, 155));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(58, 83, 155));
        jLabel35.setText("DASHBOARD");
        DashboardPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        ContentPanel.add(DashboardPanel, "card5");

        MyClassPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setBackground(new java.awt.Color(58, 83, 155));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("My Class");

        tabKClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Class Name", "Class Type", "Teacher", "Capacity", "Deadline", "Start Date", "End Date", "Studnet Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true, true
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
            tabKClass.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabKClass.getColumnModel().getColumn(6).setPreferredWidth(50);
            tabKClass.getColumnModel().getColumn(7).setPreferredWidth(120);
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
        MCComboClassType.setBorder(null);
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
                .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MyClassPanelLayout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jLabel73))
                    .addGroup(MyClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MyClassPanelLayout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addGroup(MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addComponent(MCTxtEDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MyClassPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MCBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(489, 489, 489))
        );
        MyClassPanelLayout.setVerticalGroup(
            MyClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MyClassPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
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
                .addGap(57, 57, 57)
                .addComponent(MCBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        ContentPanel.add(MyClassPanel, "card3");

        MyStudnetPanel.setBackground(new java.awt.Color(255, 255, 255));
        MyStudnetPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewStudent.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewStudentActionPerformed(evt);
            }
        });
        MyStudnetPanel.add(txtViewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 160, 30));

        jLabel50.setBackground(new java.awt.Color(58, 83, 155));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(58, 83, 155));
        jLabel50.setText("Student Directory");
        MyStudnetPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        btnViewBus1.setBackground(new java.awt.Color(255, 255, 255));
        btnViewBus1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewBus1.setForeground(new java.awt.Color(58, 83, 155));
        btnViewBus1.setText("View");
        btnViewBus1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewBus1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewBus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBus1ActionPerformed(evt);
            }
        });
        MyStudnetPanel.add(btnViewBus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 120, 30));

        StudentJPanel.setBackground(new java.awt.Color(255, 255, 255));
        StudentJPanel.setLayout(new java.awt.CardLayout());

        StudentNull.setBackground(new java.awt.Color(255, 255, 255));
        StudentNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-boy 3.png"))); // NOI18N
        StudentNull.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 660, 550));

        StudentJPanel.add(StudentNull, "card5");

        StudentDetails.setBackground(new java.awt.Color(255, 255, 255));
        StudentDetails.setForeground(new java.awt.Color(255, 255, 255));
        StudentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        StudentDetails.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 210, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 83, 155));
        jLabel1.setText("Name:");
        StudentDetails.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 80, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 83, 155));
        jLabel2.setText("Sent Message to Guardian:");
        StudentDetails.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 270, 30));

        jTextField3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        StudentDetails.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 370, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("Guardian:");
        StudentDetails.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 110, 30));

        jTextField4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        StudentDetails.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 210, 30));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(58, 83, 155));
        jButton1.setText("Sent");
        StudentDetails.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 130, 30));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 83, 155));
        jLabel5.setText("Address:");
        StudentDetails.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 110, 30));

        jTextField5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        StudentDetails.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 210, 30));

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(58, 83, 155));
        jButton2.setText("View Location");
        StudentDetails.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 140, 30));

        jLabel51.setBackground(new java.awt.Color(58, 83, 155));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(58, 83, 155));
        jLabel51.setText("Student Details Information");
        StudentDetails.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-boy 3.png"))); // NOI18N
        StudentDetails.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -10, 660, 550));

        StudentJPanel.add(StudentDetails, "card3");

        MyStudnetPanel.add(StudentJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableCommnuity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Name", "Student ID", "Class", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCommnuity.setFocusable(false);
        TableCommnuity.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableCommnuity.setRowHeight(30);
        TableCommnuity.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableCommnuity.setShowVerticalLines(false);
        TableCommnuity.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableCommnuity);

        MyStudnetPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 630, 280));

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Applicant", "Kid Name", "Age", "Class", "Application Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, false
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
            tabApplication.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabApplication.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        javax.swing.GroupLayout ManageApplicationLayout = new javax.swing.GroupLayout(ManageApplication);
        ManageApplication.setLayout(ManageApplicationLayout);
        ManageApplicationLayout.setHorizontalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGroup(ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(438, 438, 438)
                        .addComponent(jLabel36))
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageApplicationLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(558, 558, 558))
        );
        ManageApplicationLayout.setVerticalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel36)
                .addGap(76, 76, 76)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(472, Short.MAX_VALUE))
        );

        ContentPanel.add(ManageApplication, "card7");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-student_male.png"))); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179)
                .addComponent(jLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnMyStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnManageApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel12)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMyClass, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel6)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btnMyClass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMyStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageApplication, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(540, 540, 540)
                        .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
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
    }//GEN-LAST:event_btnMyStudentActionPerformed

   
    public void refreshTeacherTable(){
    }    
    private void btnMarkreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkreadActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnMarkreadActionPerformed

    private void txtViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewStudentActionPerformed

    private void btnViewBus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBus1ActionPerformed
        // TODO add your handling code here:
        /*int selectedRow = TableDriver.getSelectedRow();

        if (selectedRow >= 0)
        {
            SchoolBus s = (SchoolBus) TablePatient.getValueAt(selectedRow, 0);
            //setvisable
            PatientNull.setVisible(false);
            SchoolBusAdd.setVisible(false);
            PatientViewInformation.setVisible(true);

            //txt
            vPatientName.setText(s.getLicense());
            vPatientPhone.setText(s.getModelNum());
            vPatientTypeofillness.setText(s.getPersonCapacity());
            vYear.setText(s.getManfacturedYear());

            //
            schoolBus = s;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a school bus.");
        }*/
    }//GEN-LAST:event_btnViewBus1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
        String startDate = MCTxtSdate.getText();
        String endDate = MCTxtEDate.getText();
        String deadline = MCTxtDeadline.getText();
        kc.setClassName(className);
        kc.setTeacherName(teacherName);
        kc.setClassType(classType);
        kc.setCapacity(capacity);
        kc.setStartDate(startDate);
        kc.setEndDate(endDate);
        kc.setDeadline(deadline);
        userAccount.getClassList().add(kc);
        kindergartenEnterprise.getAllClassList().add(kc);
        JOptionPane.showMessageDialog(null, "Class created successfully!");
        populateClassTable();
        MCTxtClassName.setText("");
        MCTxtCapacity.setText("");
        MCTxtDeadline.setText("");
        MCTxtEDate.setText("");
        MCTxtSdate.setText("");
        
//        CoachClass cc = new CoachClass();
//        if (!(nameJTextField2.getText().equals("") || nameJTextField1.getText().equals(""))) {
//            if (Integer.parseInt(nameJTextField1.getText()) < 200 && Integer.parseInt(nameJTextField1.getText()) > 0) {
//                cc.setClassname(nameJTextField2.getText());
//                cc.setCapacity(Integer.parseInt(nameJTextField1.getText()));
//                cc.setCoach(userAccount.getUsername());
////        cc.setTime(time);
//                userAccount.getClasslist().add(cc);
//                enterprise.getAllClassList().add(cc);
//                JOptionPane.showMessageDialog(null, "KClass  created successfully !");
//
//                container.remove(this);
//                CardLayout layout = (CardLayout) container.getLayout();
//                layout.previous(container);
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "Capacity  must between 1-200 !");
//
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "please fill all items !");
//
//        }
        
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
        //        String name = NTxtNetwork.getText();
        //        Network network = ecoSystem.createAndAddNetwork();
        //        network.setName(name);
        //        populateNetworkTable();
    }//GEN-LAST:event_MABtnAcceptActionPerformed

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
    private javax.swing.JPanel StudentDetails;
    private javax.swing.JPanel StudentJPanel;
    private javax.swing.JPanel StudentNull;
    private javax.swing.JTable TableCommnuity;
    private javax.swing.JTable TableNotification;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnManageApplication;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnMyClass;
    private javax.swing.JButton btnMyStudent;
    private javax.swing.JButton btnViewBus1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labelComplaintNum;
    private javax.swing.JLabel labelDoctorNum;
    private javax.swing.JLabel labelPatientNum;
    private javax.swing.JTable tabApplication;
    private javax.swing.JTable tabKClass;
    private javax.swing.JTextField txtViewStudent;
    // End of variables declaration//GEN-END:variables
}
