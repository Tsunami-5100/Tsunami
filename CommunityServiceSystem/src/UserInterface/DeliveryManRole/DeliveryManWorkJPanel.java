/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeliveryManRole;

//import UserInterface.Ambulance.*;
//import UserInterface.SchoolBus.*;
//import UserInterface.Teacher.*;
//import UserInterface.Doctor.*;
//import UserInterface.SupermarkAdmin.*;
//import UserInterface.HospitalAdmin.*;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MarketEnterprise;
import Business.Market.Merchandise;
import Business.Market.MerchandiseOrder;
import Business.Message.Message;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ShippingOrganization;
import Business.Resident.Resident;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
//import Business.Hospital.Ambulance;
//import Business.Hospital.Doctor;
//import Business.Hospital.Hospital;
//import Business.Hospital.Patient;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class DeliveryManWorkJPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;

    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    MarketEnterprise marketEnterprise;
    ShippingOrganization shippingOrganization;
    Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private String imagePath;
    private MerchandiseOrder selectMerchandiseOrder;

    public DeliveryManWorkJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        selectMerchandiseOrder = new MerchandiseOrder();
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = account;
        this.shippingOrganization = (ShippingOrganization) organization;
        this.marketEnterprise = (MarketEnterprise) enterprise;
        this.network = network;
        labelName.setText("HI! " + userAccount.getEmployee().getName());
        populateMessageTable();
        jLabel30.setText("You have " + TableNotification.getRowCount()+  " new Notifications:");
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
         */
    }

    public void populateOrderTable() {
        DefaultTableModel model = (DefaultTableModel) TableRequest.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                if (m.getReceiver().equals(userAccount.getEmployee().getName()) && m.getStatus().equalsIgnoreCase("In delivery")) {
                    Object[] row = new Object[4];
                    row[0] = m;
                    row[1] = m.getSender();
                    row[2] = m.getStatus();
                    row[3] = m.getRequestTime();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void populateAllOrderTable() {
        DefaultTableModel model = (DefaultTableModel) TableRequest1.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                if (m.getReceiver().equals(userAccount.getEmployee().getName())) {
                    Object[] row = new Object[4];
                    row[0] = m;
                    row[1] = m.getSender();
                    row[2] = m.getStatus();
                    row[3] = m.getRequestTime();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateDOrderDetailsTable() {
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        model.setRowCount(0);
        for (Merchandise m : selectMerchandiseOrder.getMerchandiseList()) {
            Object[] row = new Object[2];
            row[0] = m;
            row[1] = m.getQuantity();
            model.addRow(row);
        }
    }
    
    public void populateAOrderDetailsTable() {
        DefaultTableModel model = (DefaultTableModel) OrderTable1.getModel();
        model.setRowCount(0);
        for (Merchandise m : selectMerchandiseOrder.getMerchandiseList()) {
            Object[] row = new Object[2];
            row[0] = m;
            row[1] = m.getQuantity();
            model.addRow(row);
        }
    }
    
    public void populateMessageTable() {
        DefaultTableModel model = (DefaultTableModel) TableNotification.getModel();
        model.setRowCount(0);
        for (Message m : ecoSystem.getMessageList().getMessageList()) {
                if (m.getReceiver().equals(userAccount.getEmployee().getName())) {
                    Object[] row = new Object[2];
                    row[0] = m;
                    row[1] = m.getRequestDate();
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
        jButton6 = new javax.swing.JButton();
        labelName = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnRquestList = new javax.swing.JButton();
        btnInformation = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        labelComplaintNum1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        labelPatientNum1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        labelDoctorNum1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        btnMarkread = new javax.swing.JButton();
        RequestList = new javax.swing.JPanel();
        txtViewRequest = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        btnViewRequest = new javax.swing.JButton();
        RequestJpanel = new javax.swing.JPanel();
        RequestNull = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        RequestDetails = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtVRLocation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtVRCPhone = new javax.swing.JTextField();
        btnFinishRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtVRCustomer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRequest = new javax.swing.JTable();
        RequestHistory = new javax.swing.JPanel();
        txtViewRequest1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        btnViewRequest1 = new javax.swing.JButton();
        RequestJpanel1 = new javax.swing.JPanel();
        RequestNull1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        RequestDetails1 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtVRLocation1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtVRCPhone1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtVRCustomer1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableRequest1 = new javax.swing.JTable();
        ManageComplaint = new javax.swing.JPanel();
        txtViewReceiver1 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        btnViewComplaint1 = new javax.swing.JButton();
        ComplaintJPanel = new javax.swing.JPanel();
        ComplaintNull = new javax.swing.JPanel();
        ComplaintInformation = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtComplaintDesc1 = new javax.swing.JTextArea();
        jLabel102 = new javax.swing.JLabel();
        sentMessageToAddresser1 = new javax.swing.JButton();
        txtComplaintReason1 = new javax.swing.JTextField();
        txtComAddresser1 = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        TableComplaint = new javax.swing.JTable();
        ManageInformation = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        btnphotoUpload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txtUserAccount = new javax.swing.JTextField();
        txtPosition = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        btnComplaint = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnRquestList1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 1031, 291, 45));

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
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 35, 140, 40));

        labelName.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 255, 255));
        labelName.setText("Hi,*** ");
        add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 48, -1, -1));

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
        add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 240, 40));

        btnRquestList.setBackground(new java.awt.Color(58, 83, 155));
        btnRquestList.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRquestList.setForeground(new java.awt.Color(255, 255, 255));
        btnRquestList.setText("Request Waitlist");
        btnRquestList.setBorder(null);
        btnRquestList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRquestList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRquestListActionPerformed(evt);
            }
        });
        add(btnRquestList, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 240, 40));

        btnInformation.setBackground(new java.awt.Color(58, 83, 155));
        btnInformation.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnInformation.setForeground(new java.awt.Color(255, 255, 255));
        btnInformation.setText("Manage Information");
        btnInformation.setBorder(null);
        btnInformation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationActionPerformed(evt);
            }
        });
        add(btnInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 240, 40));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-registration.png"))); // NOI18N
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 50, 60));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        Dashboard.setBackground(new java.awt.Color(255, 255, 255));
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(58, 83, 155));

        labelComplaintNum1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelComplaintNum1.setForeground(new java.awt.Color(255, 255, 255));
        labelComplaintNum1.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(labelComplaintNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelComplaintNum1)
                .addGap(30, 30, 30))
        );

        Dashboard.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 160, -1));

        jPanel11.setBackground(new java.awt.Color(58, 83, 155));

        labelPatientNum1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelPatientNum1.setForeground(new java.awt.Color(255, 255, 255));
        labelPatientNum1.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(labelPatientNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelPatientNum1)
                .addGap(30, 30, 30))
        );

        Dashboard.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 160, -1));

        jPanel12.setBackground(new java.awt.Color(58, 83, 155));

        labelDoctorNum1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        labelDoctorNum1.setForeground(new java.awt.Color(255, 255, 255));
        labelDoctorNum1.setText("$200");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(labelDoctorNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(labelDoctorNum1)
                .addGap(29, 29, 29))
        );

        Dashboard.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(58, 83, 155));
        jLabel29.setText("Complaint Received");
        Dashboard.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 170, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("You have * new Notifications:");
        Dashboard.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 330, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(58, 83, 155));
        jLabel31.setText("Payments ");
        Dashboard.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 90, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(58, 83, 155));
        jLabel34.setText("Request Finished");
        Dashboard.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, 30));

        jLabel36.setBackground(new java.awt.Color(58, 83, 155));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(58, 83, 155));
        jLabel36.setText("DASHBOARD");
        Dashboard.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        TableNotification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Content", "Time"
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
        jScrollPane6.setViewportView(TableNotification);

        Dashboard.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 630, 280));

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
        Dashboard.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 750, 210, 40));

        ContentPanel.add(Dashboard, "card5");

        RequestList.setBackground(new java.awt.Color(255, 255, 255));
        RequestList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewRequest.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewRequestActionPerformed(evt);
            }
        });
        RequestList.add(txtViewRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel52.setBackground(new java.awt.Color(58, 83, 155));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(58, 83, 155));
        jLabel52.setText("Request List");
        RequestList.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        btnViewRequest.setBackground(new java.awt.Color(255, 255, 255));
        btnViewRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewRequest.setForeground(new java.awt.Color(58, 83, 155));
        btnViewRequest.setText("View");
        btnViewRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestActionPerformed(evt);
            }
        });
        RequestList.add(btnViewRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        RequestJpanel.setBackground(new java.awt.Color(255, 255, 255));
        RequestJpanel.setLayout(new java.awt.CardLayout());

        RequestNull.setBackground(new java.awt.Color(255, 255, 255));
        RequestNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-flower_delivery.png"))); // NOI18N
        RequestNull.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 590, 460));

        RequestJpanel.add(RequestNull, "card5");

        RequestDetails.setBackground(new java.awt.Color(255, 255, 255));
        RequestDetails.setForeground(new java.awt.Color(255, 255, 255));
        RequestDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setBackground(new java.awt.Color(58, 83, 155));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(58, 83, 155));
        jLabel53.setText("Request Details Information");
        RequestDetails.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 83, 155));
        jLabel7.setText("Merchandise List:");
        jLabel7.setToolTipText("");
        RequestDetails.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 83, 155));
        jLabel3.setText("Location:");
        RequestDetails.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, 30));

        txtVRLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRLocation.setToolTipText("");
        txtVRLocation.setEnabled(false);
        RequestDetails.add(txtVRLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 130, 30));

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("Customer Phone Number:");
        jLabel15.setToolTipText("");
        RequestDetails.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 30));

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(58, 83, 155));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        jButton3.setText("View Location");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        RequestDetails.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 180, 30));

        txtVRCPhone.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRCPhone.setToolTipText("");
        txtVRCPhone.setEnabled(false);
        RequestDetails.add(txtVRCPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 180, 30));

        btnFinishRequest.setBackground(new java.awt.Color(255, 255, 255));
        btnFinishRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnFinishRequest.setForeground(new java.awt.Color(58, 83, 155));
        btnFinishRequest.setText("Finish");
        btnFinishRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnFinishRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinishRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishRequestActionPerformed(evt);
            }
        });
        RequestDetails.add(btnFinishRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 180, 30));

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(OrderTable);
        if (OrderTable.getColumnModel().getColumnCount() > 0) {
            OrderTable.getColumnModel().getColumn(0).setResizable(false);
            OrderTable.getColumnModel().getColumn(1).setResizable(false);
        }

        RequestDetails.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 170));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(58, 83, 155));
        jLabel5.setText("Customer Name:");
        RequestDetails.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 30));

        txtVRCustomer.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRCustomer.setToolTipText("");
        txtVRCustomer.setEnabled(false);
        RequestDetails.add(txtVRCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 130, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-flower_delivery.png"))); // NOI18N
        RequestDetails.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 620, 460));

        RequestJpanel.add(RequestDetails, "card3");

        RequestList.add(RequestJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Status", "Request time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRequest.setFocusable(false);
        TableRequest.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableRequest.setRowHeight(30);
        TableRequest.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableRequest.setShowVerticalLines(false);
        TableRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableRequest);
        if (TableRequest.getColumnModel().getColumnCount() > 0) {
            TableRequest.getColumnModel().getColumn(0).setResizable(false);
            TableRequest.getColumnModel().getColumn(1).setResizable(false);
            TableRequest.getColumnModel().getColumn(2).setResizable(false);
            TableRequest.getColumnModel().getColumn(3).setResizable(false);
        }

        RequestList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 690, 260));

        ContentPanel.add(RequestList, "card4");

        RequestHistory.setBackground(new java.awt.Color(255, 255, 255));
        RequestHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewRequest1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewRequest1ActionPerformed(evt);
            }
        });
        RequestHistory.add(txtViewRequest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel54.setBackground(new java.awt.Color(58, 83, 155));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(58, 83, 155));
        jLabel54.setText("Request List");
        RequestHistory.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        btnViewRequest1.setBackground(new java.awt.Color(255, 255, 255));
        btnViewRequest1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewRequest1.setForeground(new java.awt.Color(58, 83, 155));
        btnViewRequest1.setText("View");
        btnViewRequest1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewRequest1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequest1ActionPerformed(evt);
            }
        });
        RequestHistory.add(btnViewRequest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        RequestJpanel1.setBackground(new java.awt.Color(255, 255, 255));
        RequestJpanel1.setLayout(new java.awt.CardLayout());

        RequestNull1.setBackground(new java.awt.Color(255, 255, 255));
        RequestNull1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-flower_delivery.png"))); // NOI18N
        RequestNull1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 590, 460));

        RequestJpanel1.add(RequestNull1, "card5");

        RequestDetails1.setBackground(new java.awt.Color(255, 255, 255));
        RequestDetails1.setForeground(new java.awt.Color(255, 255, 255));
        RequestDetails1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setBackground(new java.awt.Color(58, 83, 155));
        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(58, 83, 155));
        jLabel55.setText("Request Details Information");
        RequestDetails1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(58, 83, 155));
        jLabel8.setText("Merchandise List:");
        jLabel8.setToolTipText("");
        RequestDetails1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 200, 30));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(58, 83, 155));
        jLabel6.setText("Location:");
        RequestDetails1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, 30));

        txtVRLocation1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRLocation1.setToolTipText("");
        txtVRLocation1.setEnabled(false);
        RequestDetails1.add(txtVRLocation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 130, 30));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(58, 83, 155));
        jLabel20.setText("Customer Phone Number:");
        jLabel20.setToolTipText("");
        RequestDetails1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 30));

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(58, 83, 155));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        jButton4.setText("View Location");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        RequestDetails1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 180, 30));

        txtVRCPhone1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRCPhone1.setToolTipText("");
        txtVRCPhone1.setEnabled(false);
        RequestDetails1.add(txtVRCPhone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 180, 30));

        OrderTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(OrderTable1);
        if (OrderTable1.getColumnModel().getColumnCount() > 0) {
            OrderTable1.getColumnModel().getColumn(0).setResizable(false);
            OrderTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        RequestDetails1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 130, 170));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 83, 155));
        jLabel9.setText("Customer Name:");
        RequestDetails1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 30));

        txtVRCustomer1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVRCustomer1.setToolTipText("");
        txtVRCustomer1.setEnabled(false);
        RequestDetails1.add(txtVRCustomer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 130, 30));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-flower_delivery.png"))); // NOI18N
        RequestDetails1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 620, 460));

        RequestJpanel1.add(RequestDetails1, "card3");

        RequestHistory.add(RequestJpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableRequest1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Status", "Request time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRequest1.setFocusable(false);
        TableRequest1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableRequest1.setRowHeight(30);
        TableRequest1.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableRequest1.setShowVerticalLines(false);
        TableRequest1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(TableRequest1);
        if (TableRequest1.getColumnModel().getColumnCount() > 0) {
            TableRequest1.getColumnModel().getColumn(0).setResizable(false);
            TableRequest1.getColumnModel().getColumn(1).setResizable(false);
            TableRequest1.getColumnModel().getColumn(2).setResizable(false);
            TableRequest1.getColumnModel().getColumn(3).setResizable(false);
        }

        RequestHistory.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 690, 270));

        ContentPanel.add(RequestHistory, "card4");

        ManageComplaint.setBackground(new java.awt.Color(255, 255, 255));
        ManageComplaint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewReceiver1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewReceiver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewReceiver1ActionPerformed(evt);
            }
        });
        ManageComplaint.add(txtViewReceiver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel73.setBackground(new java.awt.Color(58, 83, 155));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("Complaint Received");
        ManageComplaint.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        btnViewComplaint1.setBackground(new java.awt.Color(255, 255, 255));
        btnViewComplaint1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewComplaint1.setForeground(new java.awt.Color(58, 83, 155));
        btnViewComplaint1.setText("View");
        btnViewComplaint1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewComplaint1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewComplaint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewComplaint1ActionPerformed(evt);
            }
        });
        ManageComplaint.add(btnViewComplaint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        ComplaintJPanel.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintJPanel.setLayout(new java.awt.CardLayout());

        ComplaintNull.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ComplaintJPanel.add(ComplaintNull, "card5");

        ComplaintInformation.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(58, 83, 155));
        jLabel95.setText("The detail information of Complaint");
        ComplaintInformation.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(58, 83, 155));
        jLabel96.setText("Complaint Reason:");
        ComplaintInformation.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, 30));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(58, 83, 155));
        jLabel100.setText("Description:");
        jLabel100.setToolTipText("");
        ComplaintInformation.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, 30));

        txtComplaintDesc1.setColumns(20);
        txtComplaintDesc1.setRows(5);
        jScrollPane10.setViewportView(txtComplaintDesc1);

        ComplaintInformation.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 530, 200));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(58, 83, 155));
        jLabel102.setText("Addresser:");
        jLabel102.setToolTipText("");
        ComplaintInformation.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, 30));

        sentMessageToAddresser1.setBackground(new java.awt.Color(255, 255, 255));
        sentMessageToAddresser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sentMessageToAddresser1.setForeground(new java.awt.Color(58, 83, 155));
        sentMessageToAddresser1.setText("Sent Message");
        sentMessageToAddresser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        sentMessageToAddresser1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sentMessageToAddresser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentMessageToAddresser1ActionPerformed(evt);
            }
        });
        ComplaintInformation.add(sentMessageToAddresser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 170, 30));

        txtComplaintReason1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtComplaintReason1.setToolTipText("");
        ComplaintInformation.add(txtComplaintReason1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 170, 30));

        txtComAddresser1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtComAddresser1.setToolTipText("");
        ComplaintInformation.add(txtComAddresser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 170, 30));

        ComplaintJPanel.add(ComplaintInformation, "card5");

        ManageComplaint.add(ComplaintJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableComplaint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Complaint Reson", "Addresser"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableComplaint.setFocusable(false);
        TableComplaint.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableComplaint.setRowHeight(30);
        TableComplaint.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableComplaint.setShowVerticalLines(false);
        TableComplaint.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(TableComplaint);

        ManageComplaint.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 630, 270));

        ContentPanel.add(ManageComplaint, "card4");

        ManageInformation.setBackground(new java.awt.Color(255, 255, 255));
        ManageInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setForeground(new java.awt.Color(58, 83, 155));
        image.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile photo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14), new java.awt.Color(58, 83, 155))); // NOI18N
        ManageInformation.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 210, 270));

        btnphotoUpload.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnphotoUpload.setForeground(new java.awt.Color(58, 83, 155));
        btnphotoUpload.setText("Upload");
        btnphotoUpload.setEnabled(false);
        btnphotoUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphotoUploadActionPerformed(evt);
            }
        });
        ManageInformation.add(btnphotoUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 110, 40));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(58, 83, 155));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        ManageInformation.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 560, 200, 40));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(58, 83, 155));
        btnSave.setText("SAVE");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        ManageInformation.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 560, 200, 40));

        jLabel71.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(58, 83, 155));
        jLabel71.setText(" Name:");
        jLabel71.setToolTipText("");
        ManageInformation.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, 30));

        txtName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtName.setForeground(new java.awt.Color(58, 83, 155));
        txtName.setToolTipText("");
        txtName.setEnabled(false);
        ManageInformation.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 180, 30));

        txtEmail.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(58, 83, 155));
        txtEmail.setToolTipText("");
        txtEmail.setEnabled(false);
        ManageInformation.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 180, 30));

        jLabel72.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(58, 83, 155));
        jLabel72.setText("E-mails:");
        jLabel72.setToolTipText("");
        ManageInformation.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 90, 30));

        jLabel74.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(58, 83, 155));
        jLabel74.setText("Position:");
        jLabel74.setToolTipText("");
        ManageInformation.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 70, 30));

        jLabel75.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(58, 83, 155));
        jLabel75.setText("Password:");
        jLabel75.setToolTipText("");
        ManageInformation.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 90, 30));

        txtPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(58, 83, 155));
        txtPassword.setToolTipText("");
        txtPassword.setEnabled(false);
        ManageInformation.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 180, 30));

        jLabel76.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(58, 83, 155));
        jLabel76.setText("User Account:");
        jLabel76.setToolTipText("");
        ManageInformation.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 120, 30));

        txtUserAccount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtUserAccount.setForeground(new java.awt.Color(58, 83, 155));
        txtUserAccount.setToolTipText("");
        txtUserAccount.setEnabled(false);
        ManageInformation.add(txtUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 180, 30));

        txtPosition.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPosition.setForeground(new java.awt.Color(58, 83, 155));
        txtPosition.setToolTipText("");
        txtPosition.setEnabled(false);
        ManageInformation.add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 180, 30));

        txtPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(58, 83, 155));
        txtPhoneNumber.setToolTipText("");
        txtPhoneNumber.setEnabled(false);
        ManageInformation.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 180, 30));

        jLabel83.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(58, 83, 155));
        jLabel83.setText("Phone Number:");
        jLabel83.setToolTipText("");
        ManageInformation.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 140, 30));

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-profile.png"))); // NOI18N
        ManageInformation.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 680, 670));

        jLabel86.setBackground(new java.awt.Color(58, 83, 155));
        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(58, 83, 155));
        jLabel86.setText("Manage Information");
        ManageInformation.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, -1));

        ContentPanel.add(ManageInformation, "card8");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 128, -1, 954));

        btnComplaint.setBackground(new java.awt.Color(58, 83, 155));
        btnComplaint.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnComplaint.setForeground(new java.awt.Color(255, 255, 255));
        btnComplaint.setText("Complaint Received");
        btnComplaint.setBorder(null);
        btnComplaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComplaintActionPerformed(evt);
            }
        });
        add(btnComplaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 240, 40));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-strike.png"))); // NOI18N
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 40));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-list.png"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 50, 60));

        btnRquestList1.setBackground(new java.awt.Color(58, 83, 155));
        btnRquestList1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRquestList1.setForeground(new java.awt.Color(255, 255, 255));
        btnRquestList1.setText("Request History");
        btnRquestList1.setBorder(null);
        btnRquestList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRquestList1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRquestList1ActionPerformed(evt);
            }
        });
        add(btnRquestList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 240, 40));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 50, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(true);
        RequestList.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        RequestHistory.setVisible(true);
        populateMessageTable();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnRquestListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRquestListActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(true);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        RequestHistory.setVisible(true);
        populateOrderTable();
        /*        
        //first-in
        refreshStudentTable();*/
    }//GEN-LAST:event_btnRquestListActionPerformed

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

    private void btnInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformationActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(true);

        txtName.setText(userAccount.getEmployee().getName());
        txtEmail.setText(userAccount.getEmails());
        txtPhoneNumber.setText(userAccount.getPhone());
        txtPosition.setText("Delivery Man");
        txtUserAccount.setText(userAccount.getUsername());
        txtPassword.setText(userAccount.getPassword());
        image.setIcon(userAccount.getMyimage());

        /*txtEntName.setText(kindergarden.getName());
        txtEntLocation.setText(kindergarden.getName());
        txtPhoneNumber.setText(kindergarden.getName());
        txtEntName.setText(kindergarden.getName());
        comboStatus.setSelectedItem(kindergarden.getStatus());
        comboxOpenTime.setSelectedItem(kindergarden.getOpenTime());
        comboxClosedTime.setSelectedItem(kindergarden.getClosedTime());*/
    }//GEN-LAST:event_btnInformationActionPerformed

    private void btnComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComplaintActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(true);
    }//GEN-LAST:event_btnComplaintActionPerformed

    private void txtViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewRequestActionPerformed

    private void btnViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableRequest.getSelectedRow();
        if (selectedRow >= 0) {
            RequestNull.setVisible(false);
            RequestDetails.setVisible(true);
            selectMerchandiseOrder = (MerchandiseOrder) TableRequest.getValueAt(selectedRow, 0);
            txtVRCustomer.setText(selectMerchandiseOrder.getSender());
            txtVRLocation.setText(selectMerchandiseOrder.getLocation());
            txtVRCPhone.setText(selectMerchandiseOrder.getPhoneNumber());
            populateDOrderDetailsTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Request.");
        };
    }//GEN-LAST:event_btnViewRequestActionPerformed

    private void txtViewReceiver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewReceiver1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewReceiver1ActionPerformed

    private void btnViewComplaint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewComplaint1ActionPerformed
        // TODO add your handling code here:
        /*int selectedRow = TableComplaint.getSelectedRow();

        if (selectedRow >= 0)
        {
            Complaint s = (Complaint) TableComplaint.getValueAt(selectedRow, 0);
            //setvisable
            ComplaintNull.setVisible(false);
            ComplaintInformation.setVisible(true);

            //txt
            txtComAddresser.setText(s.getAddresser());
            txtComplaintEmployee.setText(s.getReceiver());
            txtComplaintReason.setText(s.getComplaintReason());
            txtComplaintDesc.setText(s.getDesc());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a school bus.");
        }*/
    }//GEN-LAST:event_btnViewComplaint1ActionPerformed

    private void sentMessageToAddresser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentMessageToAddresser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sentMessageToAddresser1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFinishRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishRequestActionPerformed
        // TODO add your handling code here:
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                if (m.getMarketName().equals(marketEnterprise.getName())) {
                    if (m.toString().equals(selectMerchandiseOrder.toString())) {
                        m.setStatus("Compeleted");
                        
                        Message message1 = new Message();
                        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd  hh:mm");
                        Date dNow = new Date();
                        message1.setReceiver(m.getMarketName());
                        message1.setContent("The customer order (id" + m.toString() + ") is finished.");
                        message1.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message1);
                        
                        Message message2 = new Message();
                        message2.setReceiver(m.getSender());
                        message2.setContent("Your market order (id" + m.toString() + ") is finished.");
                        message2.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message2);
                        
                        
                        populateOrderTable();
                        JOptionPane.showMessageDialog(null, "Finish request successfully!!");
                        RequestNull.setVisible(false);
                        RequestDetails.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnFinishRequestActionPerformed

    private void btnphotoUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphotoUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser upload = new JFileChooser();
        upload.showOpenDialog(null);
        File file = upload.getSelectedFile();
        String path = file.getAbsolutePath();
        imagePath = path;

        Image im = Toolkit.getDefaultToolkit().createImage(path);
        im = im.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ima = new ImageIcon(im);
        userAccount.setMyimage(ima);
        image.setIcon(ima);
    }//GEN-LAST:event_btnphotoUploadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtName.setEnabled(true);
        txtEmail.setEnabled(true);
        txtPhoneNumber.setEnabled(true);

        txtPassword.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnphotoUpload.setEnabled(true);


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        userAccount.setName(txtName.getText());
        userAccount.setEmails(txtEmail.getText());
        userAccount.setPhone(txtPhoneNumber.getText());
        userAccount.setPassword(txtPassword.getText());

        txtName.setEnabled(false);
        txtEmail.setEnabled(false);
        txtPhoneNumber.setEnabled(false);

        txtPassword.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnSave.setEnabled(false);
        btnphotoUpload.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Update Successfully.");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnRquestList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRquestList1ActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        RequestHistory.setVisible(true);
        populateAllOrderTable();
    }//GEN-LAST:event_btnRquestList1ActionPerformed

    private void txtViewRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewRequest1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewRequest1ActionPerformed

    private void btnViewRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequest1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableRequest1.getSelectedRow();
        if (selectedRow >= 0) {
            RequestNull1.setVisible(false);
            RequestDetails1.setVisible(true);
            selectMerchandiseOrder = (MerchandiseOrder) TableRequest1.getValueAt(selectedRow, 0);
            txtVRCustomer1.setText(selectMerchandiseOrder.getSender());
            txtVRLocation1.setText(selectMerchandiseOrder.getLocation());
            txtVRCPhone1.setText(selectMerchandiseOrder.getPhoneNumber());
            populateAOrderDetailsTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Request.");
        };
    }//GEN-LAST:event_btnViewRequest1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnMarkreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkreadActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableNotification.getSelectedRow();
        if (selectedRow >= 0) {
            Message s = (Message) TableNotification.getValueAt(selectedRow, 0);
            for(Message message : ecoSystem.getMessageList().getMessageList()){
                if(message == s){
                    ecoSystem.getMessageList().getMessageList().remove(message);
                    populateMessageTable();
                }
            }
            jLabel30.setText("You have " + TableNotification.getRowCount()+  " new Notifications:");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a Message.");
        }
    }//GEN-LAST:event_btnMarkreadActionPerformed

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
    private javax.swing.JPanel ComplaintInformation;
    private javax.swing.JPanel ComplaintJPanel;
    private javax.swing.JPanel ComplaintNull;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel ManageComplaint;
    private javax.swing.JPanel ManageInformation;
    private javax.swing.JTable OrderTable;
    private javax.swing.JTable OrderTable1;
    private javax.swing.JPanel RequestDetails;
    private javax.swing.JPanel RequestDetails1;
    private javax.swing.JPanel RequestHistory;
    private javax.swing.JPanel RequestJpanel;
    private javax.swing.JPanel RequestJpanel1;
    private javax.swing.JPanel RequestList;
    private javax.swing.JPanel RequestNull;
    private javax.swing.JPanel RequestNull1;
    private javax.swing.JTable TableComplaint;
    private javax.swing.JTable TableNotification;
    private javax.swing.JTable TableRequest;
    private javax.swing.JTable TableRequest1;
    private javax.swing.JButton btnComplaint;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnFinishRequest;
    private javax.swing.JButton btnInformation;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnRquestList;
    private javax.swing.JButton btnRquestList1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewComplaint1;
    private javax.swing.JButton btnViewRequest;
    private javax.swing.JButton btnViewRequest1;
    private javax.swing.JButton btnphotoUpload;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labelComplaintNum1;
    private javax.swing.JLabel labelDoctorNum1;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPatientNum1;
    private javax.swing.JButton sentMessageToAddresser1;
    private javax.swing.JTextField txtComAddresser1;
    private javax.swing.JTextArea txtComplaintDesc1;
    private javax.swing.JTextField txtComplaintReason1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtUserAccount;
    private javax.swing.JTextField txtVRCPhone;
    private javax.swing.JTextField txtVRCPhone1;
    private javax.swing.JTextField txtVRCustomer;
    private javax.swing.JTextField txtVRCustomer1;
    private javax.swing.JTextField txtVRLocation;
    private javax.swing.JTextField txtVRLocation1;
    private javax.swing.JTextField txtViewReceiver1;
    private javax.swing.JTextField txtViewRequest;
    private javax.swing.JTextField txtViewRequest1;
    // End of variables declaration//GEN-END:variables
}
