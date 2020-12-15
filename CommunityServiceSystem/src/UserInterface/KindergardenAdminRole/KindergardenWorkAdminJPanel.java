/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.KindergardenAdminRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.KindergartenEnterprise;
import Business.KClass.KClass;
import Business.KindergartenStudent.KindergartenStudent;
import Business.Organization.TeacherOrganization;
import Business.Organization.KindergartenManagementOrganization;
import Business.Organization.Organization;
import Business.Role.BusDriverRole;
import Business.Role.TeacherRole;
import Business.UserAccount.UserAccount;
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
 * @author edmond
 */
public class KindergardenWorkAdminJPanel extends javax.swing.JPanel implements Runnable{
    
    int hour, minute, second;
    
    JPanel userProcessContainer;
    KindergartenEnterprise kindergartenEnterprise;
    KindergartenManagementOrganization kindergartenManagementOrganization;
//    Enterprise enterprise;
    UserAccount userAccount;
    EcoSystem ecoSystem;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public KindergardenWorkAdminJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
//        this.kindergartenManagementOrganization = kindergartenManagementOrganization;
//        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.kindergartenEnterprise = (KindergartenEnterprise)enterprise;
        System.out.println("UserInterface.KindergardenAdminRole.KindergardenWorkAdminJPanel.<init>() 51." + kindergartenEnterprise.getName());
        this.kindergartenManagementOrganization = (KindergartenManagementOrganization) organization;
        txtWelcome.setText("Welcome, " + userAccount.getUsername() + "!");
        Thread t = new Thread(this);
        t.start();        
    }
    
    public void populateTeacherTable() {
        DefaultTableModel model = (DefaultTableModel) tabTeacher.getModel();
        model.setRowCount(0);
        System.out.println("UserInterface.KindergardenAdminRole.KindergardenWorkAdminJPanel.populateTeacherTable() 59. " + userAccount.getEmployee().getSubIdList());
//      if (userAccount.getEmployee().getSubIdList() != null) {
            for (int i=0; i<userAccount.getEmployee().getSubIdList().size(); i ++) {
                System.out.println("UserInterface.KindergardenAdminRole.KindergardenWorkAdminJPanel.populateTeacherTable()" + "1111111");
                for (UserAccount u : kindergartenEnterprise.getUserAccountDirectory().getUserAccountList()) {
                    System.out.println("UserInterface.KindergardenAdminRole.KindergardenWorkAdminJPanel.populateTeacherTable()" + "222222");
                    boolean a = userAccount.getEmployee().getSubIdList().get(i) == u.getEmployee().getId();
                    boolean b = userAccount.getRole().toString().equals("Business.Role.TeacherRole");
                    System.out.println("boolean a " + a);
                    System.out.println("boolean b " + b);
                    if (userAccount.getEmployee().getSubIdList().get(i) == u.getEmployee().getId() && u.getRole().toString().equals("Business.Role.TeacherRole")) {
        //            System.out.println("UserInterface.KindergardenAdminRole.KindergardenWorkAdminJPanel.populateTeacherTable() 62. " + userAccount.getEmployee().getId() + "\n");
                    Object[] row = new Object[3];
                    row[0] = u;
                    row[1] = u.getEmployee().getName();
                    row[2] = u.getEmployee().getId();

                    model.addRow(row);
                    }
                }
            }
    }
    
    public void populateBusDriverTable(){
        DefaultTableModel model = (DefaultTableModel) tabBusDriver.getModel();
        model.setRowCount(0);
        for (int i=0; i<userAccount.getEmployee().getSubIdList().size(); i ++) {
            for (UserAccount u : kindergartenEnterprise.getUserAccountDirectory().getUserAccountList()) {
                if (userAccount.getEmployee().getSubIdList().get(i) == u.getEmployee().getId() && u.getRole().toString().equals("Business.Role.BusDriverRole")) {
                Object[] row = new Object[3];
                row[0] = u;
                row[1] = u.getEmployee().getName();
                row[2] = u.getEmployee().getId();

                model.addRow(row);
                }
            }
        }
    }
    
    public void populateAllStudentDirectory() {
        DefaultTableModel model = (DefaultTableModel) tabStudentDirectory.getModel();

        model.setRowCount(0);
            for (KindergartenStudent ks : kindergartenEnterprise.getKindergartenStudentDirectory().getKindergartenStudentList()) {
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
            for (KindergartenStudent ks : kindergartenEnterprise.getKindergartenStudentDirectory().getKindergartenStudentList()) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDashboard = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnStudent = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnTeacher = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBus = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        Student = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SDComboClassList = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabStudentDirectory = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        Teacher = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabTeacher = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        TTxtTeacherName = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        TTxtUsername = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        TTxtPassword = new javax.swing.JTextField();
        TBtnSubmit = new javax.swing.JButton();
        TBtnView = new javax.swing.JButton();
        TBtnDel = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        BusDriver = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabBusDriver = new javax.swing.JTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        BSDTxtUserName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BSDTxtPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        BSDTxtName = new javax.swing.JTextField();
        BSDBtnSubmit = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelComplaintNum = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        labelTeachersNum = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelStudentsNum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        btnMarkread = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labTime = new javax.swing.JLabel();
        txtWelcome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));

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

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-student_male.png"))); // NOI18N

        btnStudent.setBackground(new java.awt.Color(58, 83, 155));
        btnStudent.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnStudent.setText("Student Directoy");
        btnStudent.setBorder(null);
        btnStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

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

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-female_teacher.png"))); // NOI18N

        btnTeacher.setBackground(new java.awt.Color(58, 83, 155));
        btnTeacher.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnTeacher.setForeground(new java.awt.Color(255, 255, 255));
        btnTeacher.setText("Teacher Directory");
        btnTeacher.setBorder(null);
        btnTeacher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-school_bus.png"))); // NOI18N

        btnBus.setBackground(new java.awt.Color(58, 83, 155));
        btnBus.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnBus.setForeground(new java.awt.Color(255, 255, 255));
        btnBus.setText("Bus Driver Directory");
        btnBus.setBorder(null);
        btnBus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusActionPerformed(evt);
            }
        });

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        Student.setBackground(new java.awt.Color(255, 255, 255));
        Student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setBackground(new java.awt.Color(58, 83, 155));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 83, 155));
        jLabel19.setText("STUDENT DIRECTORY");
        Student.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 23, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 83, 155));
        jLabel9.setText("Class:");
        jLabel9.setToolTipText("");
        Student.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

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
        Student.add(SDComboClassList, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 180, -1));

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

        Student.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 720, 280));

        jLabel30.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-boy 3.png"))); // NOI18N
        Student.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 600, 510));

        ContentPanel.add(Student, "card4");

        Teacher.setBackground(new java.awt.Color(255, 255, 255));
        Teacher.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(58, 83, 155));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(58, 83, 155));
        jLabel29.setText("TEACHER DIRECTORY");
        Teacher.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 25, -1, -1));

        tabTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserName", "Name", "Teacher Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabTeacher.setFocusable(false);
        tabTeacher.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabTeacher.setRowHeight(30);
        tabTeacher.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabTeacher.setShowVerticalLines(false);
        tabTeacher.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tabTeacher);

        Teacher.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 106, 700, 264));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(58, 83, 155));
        jLabel39.setText("Name:");
        Teacher.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 719, -1, 30));

        TTxtTeacherName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        TTxtTeacherName.setToolTipText("");
        Teacher.add(TTxtTeacherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 720, 180, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(58, 83, 155));
        jLabel38.setText("Please input the teacher's Information:");
        Teacher.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 514, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(58, 83, 155));
        jLabel41.setText("UserName:");
        jLabel41.setToolTipText("");
        Teacher.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 571, -1, 30));

        TTxtUsername.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        TTxtUsername.setToolTipText("");
        Teacher.add(TTxtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 572, 180, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(58, 83, 155));
        jLabel42.setText("Password:");
        jLabel42.setToolTipText("");
        Teacher.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 650, -1, 30));

        TTxtPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        TTxtPassword.setToolTipText("");
        Teacher.add(TTxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 651, 180, 30));

        TBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        TBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        TBtnSubmit.setText("Submit");
        TBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        TBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBtnSubmitActionPerformed(evt);
            }
        });
        Teacher.add(TBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 840, 132, 42));

        TBtnView.setBackground(new java.awt.Color(255, 255, 255));
        TBtnView.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TBtnView.setForeground(new java.awt.Color(58, 83, 155));
        TBtnView.setText("View");
        TBtnView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        TBtnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBtnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBtnViewActionPerformed(evt);
            }
        });
        Teacher.add(TBtnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 398, 132, 36));

        TBtnDel.setBackground(new java.awt.Color(255, 255, 255));
        TBtnDel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        TBtnDel.setForeground(new java.awt.Color(58, 83, 155));
        TBtnDel.setText("Delete");
        TBtnDel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        TBtnDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TBtnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBtnDelActionPerformed(evt);
            }
        });
        Teacher.add(TBtnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 398, 132, 36));

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-woman_teacher.png"))); // NOI18N
        Teacher.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 590, 470));

        ContentPanel.add(Teacher, "card4");

        BusDriver.setBackground(new java.awt.Color(255, 255, 255));
        BusDriver.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(58, 83, 155));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(58, 83, 155));
        jLabel46.setText("BUS DRIVER DIRECTOY");
        BusDriver.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 21, -1, -1));

        tabBusDriver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "User Name", "Driver name", "Driver Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabBusDriver.setFocusable(false);
        tabBusDriver.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabBusDriver.setRowHeight(30);
        tabBusDriver.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabBusDriver.setShowVerticalLines(false);
        tabBusDriver.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabBusDriver);
        if (tabBusDriver.getColumnModel().getColumnCount() > 0) {
            tabBusDriver.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        BusDriver.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 104, 617, 248));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(58, 83, 155));
        jLabel40.setText("Please input bus the driver's information:");
        BusDriver.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 398, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("User Name:");
        BusDriver.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 466, -1, 41));

        BSDTxtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BSDTxtUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BusDriver.add(BSDTxtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 471, 182, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("Password:");
        BusDriver.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 542, -1, 41));

        BSDTxtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BSDTxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BusDriver.add(BSDTxtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 547, 182, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("Name:");
        BusDriver.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(613, 611, -1, 41));

        BSDTxtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BSDTxtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BusDriver.add(BSDTxtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 616, 182, -1));

        BSDBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        BSDBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        BSDBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        BSDBtnSubmit.setText("Submit");
        BSDBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        BSDBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BSDBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSDBtnSubmitActionPerformed(evt);
            }
        });
        BusDriver.add(BSDBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 735, 132, 42));

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-school_bus 2.png"))); // NOI18N
        BusDriver.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 590, 500));

        ContentPanel.add(BusDriver, "card4");

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        Dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, 160, -1));

        jPanel8.setBackground(new java.awt.Color(58, 83, 155));

        labelTeachersNum.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelTeachersNum.setForeground(new java.awt.Color(255, 255, 255));
        labelTeachersNum.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(labelTeachersNum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelTeachersNum)
                .addGap(30, 30, 30))
        );

        Dashboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 160, -1));

        jPanel9.setBackground(new java.awt.Color(58, 83, 155));

        labelStudentsNum.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelStudentsNum.setForeground(new java.awt.Color(255, 255, 255));
        labelStudentsNum.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(labelStudentsNum)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelStudentsNum)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Dashboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 160, -1));

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

        Dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 630, 280));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(58, 83, 155));
        jLabel26.setText("Complaint Received:");
        Dashboard.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 150, 190, 30));

        btnMarkread.setBackground(new java.awt.Color(255, 255, 255));
        btnMarkread.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMarkread.setForeground(new java.awt.Color(58, 83, 155));
        btnMarkread.setText("Markread");
        btnMarkread.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMarkread.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dashboard.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 820, 170, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(58, 83, 155));
        jLabel27.setText("You have * new Notifications:");
        Dashboard.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 330, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(58, 83, 155));
        jLabel28.setText("Number of Students:");
        Dashboard.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(58, 83, 155));
        jLabel33.setText("Number of Teachers:");
        Dashboard.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 200, 30));

        jLabel4.setBackground(new java.awt.Color(58, 83, 155));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("DASHBOARD");
        Dashboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        ContentPanel.add(Dashboard, "card5");

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");

        txtWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(255, 255, 255));
        txtWelcome.setText("Welcome, XXX! ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTeacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(txtWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1462, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnBus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)))
                        .addContainerGap())
                    .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(true);
        Student.setVisible(false);
        Teacher.setVisible(false);
        BusDriver.setVisible(false);

    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Student.setVisible(true);
        Teacher.setVisible(false);
        BusDriver.setVisible(false);
        
        SDComboClassList.removeAllItems();
        SDComboClassList.addItem("All");
        for (KClass kc : kindergartenEnterprise.getAllClassList()) {
            SDComboClassList.addItem(kc.getClassName());
        }
        populateAllStudentDirectory();
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Student.setVisible(false);
        Teacher.setVisible(true);
        BusDriver.setVisible(false);
        populateTeacherTable();
    }//GEN-LAST:event_btnTeacherActionPerformed

    private void btnBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Student.setVisible(false);
        Teacher.setVisible(false);
        BusDriver.setVisible(true);
        populateBusDriverTable();
    }//GEN-LAST:event_btnBusActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void TBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBtnSubmitActionPerformed
        // TODO add your handling code here:
        String username = TTxtUsername.getText();
        String password = TTxtPassword.getText();
        String teacherName = TTxtTeacherName.getText();
        Employee employee = kindergartenEnterprise.getEmployeeDirectory().createEmployee(teacherName);
        employee.setId(kindergartenEnterprise.getUserAccountDirectory().getUserAccountList().size()+1);
        userAccount.getEmployee().getSubIdList().add(employee.getId());
        UserAccount account = kindergartenEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new TeacherRole());
        populateTeacherTable();
    }//GEN-LAST:event_TBtnSubmitActionPerformed

    private void TBtnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBtnViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TBtnViewActionPerformed

    private void TBtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBtnDelActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabTeacher.getSelectedRow();
        if(selectedRow>=0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                UserAccount u = (UserAccount) tabTeacher.getValueAt(selectedRow, 0);
                kindergartenEnterprise.getUserAccountDirectory().getUserAccountList().remove(u);
                populateTeacherTable();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_TBtnDelActionPerformed

    private void BSDBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSDBtnSubmitActionPerformed
        // TODO add your handling code here:
        String username = BSDTxtUserName.getText();
        String password = BSDTxtPassword.getText();
        String driverName = BSDTxtName.getText();
        Employee employee = kindergartenEnterprise.getEmployeeDirectory().createEmployee(driverName);
        employee.setId(kindergartenEnterprise.getUserAccountDirectory().getUserAccountList().size()+1);
        userAccount.getEmployee().getSubIdList().add(employee.getId());
        UserAccount account = kindergartenEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new BusDriverRole());
        populateBusDriverTable();
    }//GEN-LAST:event_BSDBtnSubmitActionPerformed

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

    private void SDComboClassListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SDComboClassListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SDComboClassListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BSDBtnSubmit;
    private javax.swing.JTextField BSDTxtName;
    private javax.swing.JTextField BSDTxtPassword;
    private javax.swing.JTextField BSDTxtUserName;
    private javax.swing.JPanel BusDriver;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JComboBox SDComboClassList;
    private javax.swing.JPanel Student;
    private javax.swing.JButton TBtnDel;
    private javax.swing.JButton TBtnSubmit;
    private javax.swing.JButton TBtnView;
    private javax.swing.JTextField TTxtPassword;
    private javax.swing.JTextField TTxtTeacherName;
    private javax.swing.JTextField TTxtUsername;
    private javax.swing.JTable TableNotification;
    private javax.swing.JPanel Teacher;
    private javax.swing.JButton btnBus;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labelComplaintNum;
    private javax.swing.JLabel labelStudentsNum;
    private javax.swing.JLabel labelTeachersNum;
    private javax.swing.JTable tabBusDriver;
    private javax.swing.JTable tabStudentDirectory;
    private javax.swing.JTable tabTeacher;
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
