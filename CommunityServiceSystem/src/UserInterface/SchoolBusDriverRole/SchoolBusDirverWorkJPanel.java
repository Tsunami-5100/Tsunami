/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SchoolBusDriverRole;

//import UserInterface.Teacher.*;
//import UserInterface.Doctor.*;
//import UserInterface.SupermarkAdmin.*;
//import UserInterface.HospitalAdmin.*;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.KindergartenEnterprise;
import Business.KBApplication.KBApplication;
import Business.KindergartenBus.KindergartenBus;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.BusOrganization;
import Business.UserAccount.UserAccount;
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
public class SchoolBusDirverWorkJPanel extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    BusOrganization busOrganization;
    KindergartenEnterprise kindergartenEnterprise;
    Network network;
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
//    private Hospital hospital;
//    private Doctor student;
//    private Ambulance schoolBus;
//    private Patient teacher;
    private String imagePath;
    public SchoolBusDirverWorkJPanel(JPanel userProcessContainer,UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = account;
        this.busOrganization = (BusOrganization) organization;
        this.kindergartenEnterprise = (KindergartenEnterprise) enterprise;
        this.network = network;
        labWelcome.setText("Welcome, " +userAccount.getUsername() + "!");

        Thread t = new Thread(this);
        t.start();
        /*TableUI(TableNotification);
        TableUI(TableStudent);
        TableUI(tableWaitList);
        TableUI(TableDriver);
        TableUI(TablePatient);
        TableUI(TableComplaint);
        
        Dashboard.setVisible(true);
        Doctor.setVisible(false);
        Ambulance.setVisible(false);
        Patient.setVisible(false);
        SecurityRequest.setVisible(false);
        AmbulanceRequest.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        
        labelDoctorNum.setText(Integer.toString(hospital.getDoctorDirectory().getDoctorList().size()));
        labelDoctorNum.setFont(new Font("Tahoma", Font.BOLD, 36));
        labelDoctorNum.setOpaque(false);
        labelDoctorNum.setForeground(Color.WHITE);
        
        labelPatientNum.setText(Integer.toString(hospital.getPatientDirectory().getPatientList().size()));
        labelDoctorNum.setFont(new Font("Tahoma", Font.BOLD, 36));
        labelDoctorNum.setOpaque(false);
        labelDoctorNum.setForeground(Color.WHITE);
        
        labelComplaintNum.setText(Integer.toString(hospital.getComplaintDirectory().getComplaintList().size()));
        labelDoctorNum.setFont(new Font("Tahoma", Font.BOLD, 36));
        labelDoctorNum.setOpaque(false);
        labelDoctorNum.setForeground(Color.WHITE);
    }
    
    //pattern
    private boolean letterPattern(String a){
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(a);
        boolean b = m.matches();
        return b;
    }
    
    private boolean digitsPattern(String a){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(a);
        boolean b = m.matches();
        return b;
    }
    
    
    public void TableUI(JTable table) {
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(58, 83, 155));
        table.getTableHeader().setForeground(Color.BLACK); 
    */}
    
    public void populateKinderBusTable() {
        DefaultTableModel model = (DefaultTableModel) tabKinderBus.getModel();
        model.setRowCount(0);

        if (userAccount.getKindergartenBusDirectory().getBusList()!= null) {
            for (KindergartenBus kb : userAccount.getKindergartenBusDirectory().getBusList()) {
                Object[] row = new Object[6];
                row[0] = kb;
                row[1] = kb.getKindergartenName();
                row[2] = kb.getDriverName();
                row[3] = kb.getCapacity();
                row[4] = kb.getBusStudentNum();
                row[5] = kb.getRemainSeats();
                model.addRow(row);
            }
        }
    }
    
    public void populateApplicationTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();

        model.setRowCount(0);
            for (KBApplication kba : ecoSystem.getkBApplicationDirectory().getkBApplicationList()) {
                if (userAccount.getUsername().equals(kba.getReceiver())) {
                    Object[] row = new Object[7];
                    row[0] = kba;
                    row[1] = kba.getLicenseNum();
                    row[2] = kba.getSender();
                    row[3] = kba.getKidName();
                    row[4] = kba.getKidAge();               
                    row[5] = kba.getStatus();
                    row[6] = kba.getResolveDate();
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

        labTime = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        labWelcome = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        btnManageApplication = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableNotification1 = new javax.swing.JTable();
        btnMarkread1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        StudentList = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        btnViewStudent = new javax.swing.JButton();
        StudentJpanel = new javax.swing.JPanel();
        StudentDetails = new javax.swing.JPanel();
        txtStudentName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSentMessageToG = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtStudentGuardian = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtStudentAddress = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableStudent = new javax.swing.JTable();
        ManageApplication = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tabApplication = new javax.swing.JTable();
        MABtnAccept = new javax.swing.JButton();
        ManageKinderBus = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabKinderBus = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        MKBTxtLicensePlate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        MKBTxtCapacity = new javax.swing.JTextField();
        MKBBtnSubmit = new javax.swing.JButton();
        btnManageBus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 291, 45));

        btnLogOut.setBackground(new java.awt.Color(58, 83, 155));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-double_left.png"))); // NOI18N
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(null);
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 50, 140, 40));

        labWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labWelcome.setText("Hi,*** ");
        add(labWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 48, 240, 40));

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

        btnStudent.setBackground(new java.awt.Color(58, 83, 155));
        btnStudent.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnStudent.setText("Student List");
        btnStudent.setBorder(null);
        btnStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });
        add(btnStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 240, 40));

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

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableNotification1.setModel(new javax.swing.table.DefaultTableModel(
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
        TableNotification1.setFocusable(false);
        TableNotification1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableNotification1.setRowHeight(30);
        TableNotification1.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableNotification1.setShowVerticalLines(false);
        TableNotification1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TableNotification1);

        Dashboard.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 630, 280));

        btnMarkread1.setBackground(new java.awt.Color(255, 255, 255));
        btnMarkread1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMarkread1.setForeground(new java.awt.Color(58, 83, 155));
        btnMarkread1.setText("Markread");
        btnMarkread1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMarkread1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarkread1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkread1ActionPerformed(evt);
            }
        });
        Dashboard.add(btnMarkread1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, 170, 40));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("You have * new Notifications:");
        Dashboard.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 330, 30));

        jLabel36.setBackground(new java.awt.Color(58, 83, 155));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(58, 83, 155));
        jLabel36.setText("DASHBOARD");
        Dashboard.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, -1, -1));

        ContentPanel.add(Dashboard, "card5");

        StudentList.setBackground(new java.awt.Color(255, 255, 255));
        StudentList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(58, 83, 155));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(58, 83, 155));
        jLabel52.setText("STUDENT LIST");
        StudentList.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, -1));

        btnViewStudent.setBackground(new java.awt.Color(255, 255, 255));
        btnViewStudent.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnViewStudent.setForeground(new java.awt.Color(58, 83, 155));
        btnViewStudent.setText("View");
        btnViewStudent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewStudent.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentActionPerformed(evt);
            }
        });
        StudentList.add(btnViewStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 390, 120, 30));

        StudentJpanel.setBackground(new java.awt.Color(255, 255, 255));
        StudentJpanel.setLayout(new java.awt.CardLayout());

        StudentDetails.setBackground(new java.awt.Color(255, 255, 255));
        StudentDetails.setForeground(new java.awt.Color(255, 255, 255));
        StudentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStudentName.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        StudentDetails.add(txtStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 210, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 83, 155));
        jLabel9.setText("Name:");
        StudentDetails.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 80, 30));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(58, 83, 155));
        jLabel11.setText("Sent Message to Guardian:");
        StudentDetails.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 270, 30));

        txtSentMessageToG.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtSentMessageToG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSentMessageToGActionPerformed(evt);
            }
        });
        StudentDetails.add(txtSentMessageToG, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 370, 30));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("Guardian:");
        StudentDetails.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 110, 30));

        txtStudentGuardian.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtStudentGuardian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentGuardianActionPerformed(evt);
            }
        });
        StudentDetails.add(txtStudentGuardian, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 210, 30));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(58, 83, 155));
        jButton3.setText("Sent");
        StudentDetails.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 130, 30));

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 83, 155));
        jLabel14.setText("Address:");
        StudentDetails.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 110, 30));

        txtStudentAddress.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtStudentAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentAddressActionPerformed(evt);
            }
        });
        StudentDetails.add(txtStudentAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 210, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(58, 83, 155));
        jButton4.setText("View Location");
        StudentDetails.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 150, 30));

        jLabel53.setBackground(new java.awt.Color(58, 83, 155));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(58, 83, 155));
        jLabel53.setText("Student Details Information:");
        StudentDetails.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-boy 3.png"))); // NOI18N
        StudentDetails.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -10, 660, 550));

        StudentJpanel.add(StudentDetails, "card3");

        StudentList.add(StudentJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 900, 630));

        TableStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        TableStudent.setFocusable(false);
        TableStudent.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableStudent.setRowHeight(30);
        TableStudent.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableStudent.setShowVerticalLines(false);
        TableStudent.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TableStudent);

        StudentList.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 910, 280));

        ContentPanel.add(StudentList, "card4");

        ManageApplication.setBackground(new java.awt.Color(255, 255, 255));

        jLabel48.setBackground(new java.awt.Color(58, 83, 155));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(58, 83, 155));
        jLabel48.setText("MANAGE APPLICATION");

        tabApplication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kindergarten", "License Plate", "Applicant", "Kid Name", "Age", "Status", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false, true
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
        tabApplication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabApplicationMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tabApplication);
        if (tabApplication.getColumnModel().getColumnCount() > 0) {
            tabApplication.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

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

        javax.swing.GroupLayout ManageApplicationLayout = new javax.swing.GroupLayout(ManageApplication);
        ManageApplication.setLayout(ManageApplicationLayout);
        ManageApplicationLayout.setHorizontalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ManageApplicationLayout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGroup(ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(650, 650, 650)
                        .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ManageApplicationLayout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(jLabel48)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ManageApplicationLayout.setVerticalGroup(
            ManageApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManageApplicationLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel48)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(MABtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(567, Short.MAX_VALUE))
        );

        ContentPanel.add(ManageApplication, "card5");

        ManageKinderBus.setBackground(new java.awt.Color(255, 255, 255));
        ManageKinderBus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setBackground(new java.awt.Color(58, 83, 155));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(58, 83, 155));
        jLabel47.setText("MANAGE KINDERGARTEN BUS");
        ManageKinderBus.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 32, -1, -1));

        tabKinderBus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kindergarten", "License Plate", "Driver name", "Capacity", "Student Number", "Remaining Seats"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabKinderBus.setFocusable(false);
        tabKinderBus.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabKinderBus.setRowHeight(30);
        tabKinderBus.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabKinderBus.setShowVerticalLines(false);
        tabKinderBus.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabKinderBus);

        ManageKinderBus.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 79, 784, 278));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(58, 83, 155));
        jLabel38.setText("Add a new Kindergarten Bus:");
        ManageKinderBus.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("License Plate:");
        ManageKinderBus.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 560, -1, 41));

        MKBTxtLicensePlate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MKBTxtLicensePlate.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ManageKinderBus.add(MKBTxtLicensePlate, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 182, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("Capacity:");
        ManageKinderBus.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 630, -1, 41));

        MKBTxtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MKBTxtCapacity.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ManageKinderBus.add(MKBTxtCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 640, 182, -1));

        MKBBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        MKBBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MKBBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        MKBBtnSubmit.setText("Submit");
        MKBBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MKBBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MKBBtnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MKBBtnSubmitActionPerformed(evt);
            }
        });
        ManageKinderBus.add(MKBBtnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 750, 132, 42));

        ContentPanel.add(ManageKinderBus, "card6");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 132, 1460, 1080));

        btnManageBus.setBackground(new java.awt.Color(58, 83, 155));
        btnManageBus.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnManageBus.setForeground(new java.awt.Color(255, 255, 255));
        btnManageBus.setText("Manage Bus");
        btnManageBus.setBorder(null);
        btnManageBus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBusActionPerformed(evt);
            }
        });
        add(btnManageBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 240, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-student_male.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(true);
        StudentList.setVisible(false);
        ManageKinderBus.setVisible(false);
        ManageApplication.setVisible(false);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        StudentList.setVisible(true);
        ManageKinderBus.setVisible(false);
        ManageApplication.setVisible(false);

    }//GEN-LAST:event_btnStudentActionPerformed

   /* public void refreshStudentTable(){
        DefaultTableModel model = (DefaultTableModel) TableStudent.getModel();
        model.setRowCount(0);
        for(Student a: kindergarden.getStudentDirectory().getStudentList()){
            Object row[] = new Object[3];
            row[0] = a;
            row[1] = a.getId();
            row[2] = a.getClassname();
            model.addRow(row);
        }
    }*/
    
    private void btnManageApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageApplicationActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        StudentList.setVisible(false);
        ManageKinderBus.setVisible(false);
        ManageApplication.setVisible(true);
        populateApplicationTable();
    }//GEN-LAST:event_btnManageApplicationActionPerformed
    
    public void refreshTeacherTable(){
    }    
    private void btnManageBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBusActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        StudentList.setVisible(false);
        ManageKinderBus.setVisible(true);
        ManageApplication.setVisible(false);
        populateKinderBusTable();
    }//GEN-LAST:event_btnManageBusActionPerformed

    private void btnMarkread1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkread1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMarkread1ActionPerformed

    private void btnViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentActionPerformed
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
    }//GEN-LAST:event_btnViewStudentActionPerformed

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void txtSentMessageToGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSentMessageToGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSentMessageToGActionPerformed

    private void txtStudentGuardianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentGuardianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentGuardianActionPerformed

    private void txtStudentAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentAddressActionPerformed

    private void MKBBtnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MKBBtnSubmitActionPerformed
        // TODO add your handling code here:
        String licensePlate = MKBTxtLicensePlate.getText();
        int capacity = 0;
        try {
            capacity = Integer.parseInt(MKBTxtCapacity.getText());
            }
            
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "The capacity should be a number.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            KindergartenBus kb = new KindergartenBus();
            kb.setKindergartenName(kindergartenEnterprise.getName());
            kb.setLicenseNum(licensePlate);
            kb.setCapacity(capacity);
            kb.setDriverName(userAccount.getEmployee().getName());
            kb.setDriverUsername(userAccount.getUsername());
            kb.setDriverId(userAccount.getEmployee().getId());
            kb.setBusStudentNum(kb.getBusStudentNum());
            kb.setRemainSeats(capacity);
            System.out.println("UserInterface.SchoolBusDriverRole.SchoolBusDirverWorkJPanel.MKBBtnSubmitActionPerformed()882. " + kb.getRemainSeats());
            userAccount.getKindergartenBusDirectory().getBusList().add(kb);
            populateKinderBusTable();
        
    }//GEN-LAST:event_MKBBtnSubmitActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void tabApplicationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabApplicationMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabApplicationMouseClicked

    private void MABtnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MABtnAcceptActionPerformed
        // TODO add your handling code here:
        int row = tabApplication.getSelectedRow();

        if(row >=0){
            int selectionResult = JOptionPane.showConfirmDialog(null, "Do you confirm the application?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(selectionResult == JOptionPane.YES_OPTION){
                KBApplication kba = (KBApplication) tabApplication.getValueAt(row, 0);
                SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
                Date dNow = new Date();
                kba.setResolveDate(dateformat.format(dNow));
                kba.setStatus("Accepted");

                for (KindergartenBus kb : userAccount.getKindergartenBusDirectory().getBusList()) {
                    if (kba.getLicenseNum().equals(kb.getLicenseNum())) {
                        kb.setBusStudentNum(kb.getBusStudentNum()+1);
                        kb.setRemainSeats(kb.getRemainSeats()-1);
                        populateKinderBusTable();
                        populateApplicationTable();
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MABtnAcceptActionPerformed
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton MABtnAccept;
    private javax.swing.JButton MKBBtnSubmit;
    private javax.swing.JTextField MKBTxtCapacity;
    private javax.swing.JTextField MKBTxtLicensePlate;
    private javax.swing.JPanel ManageApplication;
    private javax.swing.JPanel ManageKinderBus;
    private javax.swing.JPanel StudentDetails;
    private javax.swing.JPanel StudentJpanel;
    private javax.swing.JPanel StudentList;
    private javax.swing.JTable TableNotification1;
    private javax.swing.JTable TableStudent;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManageApplication;
    private javax.swing.JButton btnManageBus;
    private javax.swing.JButton btnMarkread1;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnViewStudent;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labWelcome;
    private javax.swing.JTable tabApplication;
    private javax.swing.JTable tabKinderBus;
    private javax.swing.JTextField txtSentMessageToG;
    private javax.swing.JTextField txtStudentAddress;
    private javax.swing.JTextField txtStudentGuardian;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
