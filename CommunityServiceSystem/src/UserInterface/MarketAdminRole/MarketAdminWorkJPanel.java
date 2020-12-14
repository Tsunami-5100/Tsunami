/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MarketAdminRole;

//import UserInterface.HospitalAdmin.*;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MarketEnterprise;
import Business.Market.Merchandise;
import Business.Market.MerchandiseOrder;
import Business.Message.Message;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.MarketManagementOrganization;
import Business.Resident.Resident;
import Business.Role.DeliveryManRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
//import Business.Hospital.Ambulance;
//import Business.Hospital.Doctor;
//import Business.Hospital.Hospital;
//import Business.Hospital.Patient;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class MarketAdminWorkJPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;

    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    MarketEnterprise marketEnterprise;
    MarketManagementOrganization managementOrganization;
    Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private Merchandise merchandise;
    private UserAccount deliveryaccount;
    private String imagePath;
    private MerchandiseOrder selectMerchandiseOrder;

    public MarketAdminWorkJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        selectMerchandiseOrder = new MerchandiseOrder();
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = userAccount;
        this.managementOrganization = (MarketManagementOrganization) organization;
        this.marketEnterprise = (MarketEnterprise) enterprise;
        this.network = network;
        //jLabel6.setText("HI! " + userAccount.getEmployee().getName());
        populateMessageTable();
        jLabel30.setText("You have " + TableNotification.getRowCount()+  " new Notifications:");
        Thread t = new Thread(this);
        t.start();
        //TableUI(TableNotification);

    }

    public void populateMerchandiseTable() {
        DefaultTableModel model = (DefaultTableModel) tableMerchandise.getModel();
        model.setRowCount(0);
        for (Merchandise m : marketEnterprise.getMerchandiseList()) {
            Object[] row = new Object[3];
            row[0] = m;
            row[1] = m.getPrice();
            row[2] = m.getQuantity();
            model.addRow(row);
        }

    }

    public void populateDeliveryTable() {
        DefaultTableModel model = (DefaultTableModel) TableDelivery.getModel();
        model.setRowCount(0);
        for (UserAccount userAccount : marketEnterprise.getUserAccountDirectory().getUserAccountList()) {
            if (userAccount.getRole().toString().equals("Business.Role.DeliveryManRole")) {
                Object[] row = new Object[3];
                row[0] = userAccount;
                row[1] = userAccount.getEmployee().getName();
                row[2] = userAccount.getEmployee().getId();
                model.addRow(row);
            }
        }
    }

    public void populateOrderTable() {
        DefaultTableModel model = (DefaultTableModel) TableOrder.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                if (m.getMarketName().equals(marketEnterprise.getName())) {
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

    public void populateOrderDetailsTable() {
        DefaultTableModel model = (DefaultTableModel) tableRequestDetails.getModel();
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
                if (m.getReceiver().equals(marketEnterprise.getName())) {
                    Object[] row = new Object[2];
                    row[0] = m;
                    row[1] = m.getRequestDate();
                    model.addRow(row);
                
            }
        }
    }

    //public void TableUI(JTable table) {
    //table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
    //table.getTableHeader().setOpaque(false);
    //table.getTableHeader().setBackground(new Color(58, 83, 155));
    //table.getTableHeader().setForeground(Color.BLACK);
    //}
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
        btnDashboard = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnMerchandise = new javax.swing.JButton();
        btnDeliveryman = new javax.swing.JButton();
        btnComplaint = new javax.swing.JButton();
        btnInformation = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        labelComplaintNum = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        labelPatientNum = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        labelDoctorNum = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        btnMarkread = new javax.swing.JButton();
        Order = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        txtStudentView1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnViewOrder = new javax.swing.JButton();
        OrderListJPanel = new javax.swing.JPanel();
        RequestListNull = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        RequestListView = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtRequestLocation = new javax.swing.JTextField();
        txtRequestCustomer = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableRequestDetails = new javax.swing.JTable();
        btnRequestAssign = new javax.swing.JButton();
        comboDeliveryman = new javax.swing.JComboBox();
        txtRequestPhone = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtRequestD = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Merchandise = new javax.swing.JPanel();
        txtStudentView = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        btnViewMerchandise = new javax.swing.JButton();
        btnMerchandiseAdd = new javax.swing.JButton();
        MerchandiseJPanel = new javax.swing.JPanel();
        MerchandiseNull = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        MerchandiseAdd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        aMerchandiseQuantity = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        aMerchandiseName = new javax.swing.JTextField();
        aMerchandisePrice = new javax.swing.JTextField();
        aMerchandiseAdd = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        MerchandiseView = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        vMerchandiseQuantity = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        vMerchandiseName = new javax.swing.JTextField();
        vMerchandisePrice = new javax.swing.JTextField();
        vMerchandiseUpload = new javax.swing.JButton();
        btnMerchandiseSave = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDelMerchandise = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableMerchandise = new javax.swing.JTable();
        Deliveryman = new javax.swing.JPanel();
        txtViewBus = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btnViewDelivery = new javax.swing.JButton();
        DeliverymanJPanel = new javax.swing.JPanel();
        DeliveryManNull = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        DeliveryManAdd = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aDeliverymanName = new javax.swing.JTextField();
        btnSubmitDelivery = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        aDeliverymanUserName = new javax.swing.JTextField();
        aDeliverymanPassword = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        DeliveryManView = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vDeliveryManName = new javax.swing.JTextField();
        btnDeliveryUpload = new javax.swing.JButton();
        btnDeliverSave = new javax.swing.JButton();
        vDeliveryManUserName = new javax.swing.JTextField();
        vDeliveryManPassword = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDelivery = new javax.swing.JTable();
        btnDAdd = new javax.swing.JButton();
        btnDeliveryDelete = new javax.swing.JButton();
        ManageComplaint = new javax.swing.JPanel();
        txtViewReceiver = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        btnViewComplaint = new javax.swing.JButton();
        ComplaintJPanel = new javax.swing.JPanel();
        ComplaintNull = new javax.swing.JPanel();
        ComplaintInformation = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtComplaintEmployee = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtComplaintDesc = new javax.swing.JTextArea();
        jLabel100 = new javax.swing.JLabel();
        sentMessageToAddresser = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        sentMessageToReceiver = new javax.swing.JButton();
        txtComplaintReason = new javax.swing.JTextField();
        txtComAddresser = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableComplaint = new javax.swing.JTable();
        ManageInformation = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        btnphotoUpload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtEntName = new javax.swing.JTextField();
        txtEntLocation = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txtUserAccount = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        comboxClosedTime = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        comboxOpenTime = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 1031, 291, 45));

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
        add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 35, 140, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi,*** ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 48, -1, -1));

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

        btnOrder.setBackground(new java.awt.Color(58, 83, 155));
        btnOrder.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("Customer Order");
        btnOrder.setBorder(null);
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        add(btnOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 240, 40));

        btnMerchandise.setBackground(new java.awt.Color(58, 83, 155));
        btnMerchandise.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnMerchandise.setForeground(new java.awt.Color(255, 255, 255));
        btnMerchandise.setText("Merchandise Catalog");
        btnMerchandise.setBorder(null);
        btnMerchandise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMerchandiseActionPerformed(evt);
            }
        });
        add(btnMerchandise, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 240, 40));

        btnDeliveryman.setBackground(new java.awt.Color(58, 83, 155));
        btnDeliveryman.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnDeliveryman.setForeground(new java.awt.Color(255, 255, 255));
        btnDeliveryman.setText("DeliveryMan Directory");
        btnDeliveryman.setBorder(null);
        btnDeliveryman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeliveryman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverymanActionPerformed(evt);
            }
        });
        add(btnDeliveryman, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 240, 40));

        btnComplaint.setBackground(new java.awt.Color(58, 83, 155));
        btnComplaint.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnComplaint.setForeground(new java.awt.Color(255, 255, 255));
        btnComplaint.setText("Manage Complaint");
        btnComplaint.setBorder(null);
        btnComplaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComplaintActionPerformed(evt);
            }
        });
        add(btnComplaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 240, 40));

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
        add(btnInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 240, 40));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 60, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-strike.png"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 60));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-registration.png"))); // NOI18N
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 50, 60));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

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

        Dashboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 160, -1));

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

        Dashboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 160, -1));

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

        Dashboard.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(58, 83, 155));
        jLabel26.setText("Complaint Received");
        Dashboard.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 170, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(58, 83, 155));
        jLabel28.setText("Amount of Orders");
        Dashboard.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 170, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(58, 83, 155));
        jLabel33.setText("Revenue");
        Dashboard.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 80, 30));

        jLabel35.setBackground(new java.awt.Color(58, 83, 155));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(58, 83, 155));
        jLabel35.setText("DASHBOARD");
        Dashboard.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

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
        jScrollPane1.setViewportView(TableNotification);

        Dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, 630, 280));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("You have * new Notifications:");
        Dashboard.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, 330, 30));

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
        Dashboard.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 210, 40));

        ContentPanel.add(Dashboard, "card5");

        Order.setBackground(new java.awt.Color(255, 255, 255));
        Order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order Id", "Customer Name", "Status", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableOrder.setFocusable(false);
        TableOrder.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableOrder.setRowHeight(30);
        TableOrder.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableOrder.setShowVerticalLines(false);
        TableOrder.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(TableOrder);
        if (TableOrder.getColumnModel().getColumnCount() > 0) {
            TableOrder.getColumnModel().getColumn(0).setResizable(false);
            TableOrder.getColumnModel().getColumn(1).setResizable(false);
            TableOrder.getColumnModel().getColumn(2).setResizable(false);
            TableOrder.getColumnModel().getColumn(3).setResizable(false);
        }

        Order.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 720, 230));

        txtStudentView1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtStudentView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentView1ActionPerformed(evt);
            }
        });
        Order.add(txtStudentView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel21.setBackground(new java.awt.Color(58, 83, 155));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(58, 83, 155));
        jLabel21.setText("Request List");
        Order.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        btnViewOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnViewOrder.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewOrder.setForeground(new java.awt.Color(58, 83, 155));
        btnViewOrder.setText("View");
        btnViewOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderActionPerformed(evt);
            }
        });
        Order.add(btnViewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        OrderListJPanel.setBackground(new java.awt.Color(255, 255, 255));
        OrderListJPanel.setLayout(new java.awt.CardLayout());

        RequestListNull.setBackground(new java.awt.Color(255, 255, 255));
        RequestListNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-money.png"))); // NOI18N
        RequestListNull.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 690, 470));

        OrderListJPanel.add(RequestListNull, "card5");

        RequestListView.setBackground(new java.awt.Color(255, 255, 255));
        RequestListView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setBackground(new java.awt.Color(58, 83, 155));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(58, 83, 155));
        jLabel38.setText("Order Detailed Information");
        RequestListView.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(58, 83, 155));
        jLabel10.setText("Location:");
        RequestListView.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("Customer Name:");
        RequestListView.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, 30));

        txtRequestLocation.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestLocation.setEnabled(false);
        txtRequestLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestLocationActionPerformed(evt);
            }
        });
        RequestListView.add(txtRequestLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 140, -1));

        txtRequestCustomer.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestCustomer.setEnabled(false);
        txtRequestCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestCustomerActionPerformed(evt);
            }
        });
        RequestListView.add(txtRequestCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 140, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        jButton2.setBorder(null);
        RequestListView.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 80, 30));

        tableRequestDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Merchandize Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableRequestDetails);
        if (tableRequestDetails.getColumnModel().getColumnCount() > 0) {
            tableRequestDetails.getColumnModel().getColumn(0).setResizable(false);
            tableRequestDetails.getColumnModel().getColumn(1).setResizable(false);
        }

        RequestListView.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 160));

        btnRequestAssign.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnRequestAssign.setForeground(new java.awt.Color(58, 83, 155));
        btnRequestAssign.setText("Assign");
        btnRequestAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestAssignActionPerformed(evt);
            }
        });
        RequestListView.add(btnRequestAssign, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 40));

        comboDeliveryman.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        RequestListView.add(comboDeliveryman, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 150, 40));

        txtRequestPhone.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestPhone.setEnabled(false);
        txtRequestPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestPhoneActionPerformed(evt);
            }
        });
        RequestListView.add(txtRequestPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 140, -1));

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(58, 83, 155));
        jLabel23.setText("Phone Number:");
        RequestListView.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, -1));

        txtRequestD.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestD.setEnabled(false);
        txtRequestD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestDActionPerformed(evt);
            }
        });
        RequestListView.add(txtRequestD, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 140, -1));

        jLabel25.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(58, 83, 155));
        jLabel25.setText("Deliveryman:");
        RequestListView.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-money.png"))); // NOI18N
        RequestListView.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 690, 470));

        OrderListJPanel.add(RequestListView, "card4");

        Order.add(OrderListJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        ContentPanel.add(Order, "card4");

        Merchandise.setBackground(new java.awt.Color(255, 255, 255));
        Merchandise.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtStudentView.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtStudentView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentViewActionPerformed(evt);
            }
        });
        Merchandise.add(txtStudentView, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel19.setBackground(new java.awt.Color(58, 83, 155));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 83, 155));
        jLabel19.setText("Manage Merchandise Catalog");
        Merchandise.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        btnViewMerchandise.setBackground(new java.awt.Color(255, 255, 255));
        btnViewMerchandise.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewMerchandise.setForeground(new java.awt.Color(58, 83, 155));
        btnViewMerchandise.setText("View");
        btnViewMerchandise.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewMerchandise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMerchandiseActionPerformed(evt);
            }
        });
        Merchandise.add(btnViewMerchandise, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        btnMerchandiseAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnMerchandiseAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnMerchandiseAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnMerchandiseAdd.setText("Add");
        btnMerchandiseAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMerchandiseAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMerchandiseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMerchandiseAddActionPerformed(evt);
            }
        });
        Merchandise.add(btnMerchandiseAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 110, 30));

        MerchandiseJPanel.setBackground(new java.awt.Color(255, 255, 255));
        MerchandiseJPanel.setLayout(new java.awt.CardLayout());

        MerchandiseNull.setBackground(new java.awt.Color(255, 255, 255));
        MerchandiseNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-shopping_bag.png"))); // NOI18N
        MerchandiseNull.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        MerchandiseJPanel.add(MerchandiseNull, "card5");

        MerchandiseAdd.setBackground(new java.awt.Color(255, 255, 255));
        MerchandiseAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(58, 83, 155));
        jLabel3.setText("Name:");
        MerchandiseAdd.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, 30));

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(58, 83, 155));
        jLabel29.setText("Price:");
        jLabel29.setToolTipText("");
        MerchandiseAdd.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 80, 30));

        aMerchandiseQuantity.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aMerchandiseQuantity.setToolTipText("");
        MerchandiseAdd.add(aMerchandiseQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 180, 30));

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(58, 83, 155));
        jLabel31.setText("Quantity:");
        jLabel31.setToolTipText("");
        MerchandiseAdd.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, 30));

        aMerchandiseName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aMerchandiseName.setToolTipText("");
        MerchandiseAdd.add(aMerchandiseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 180, 30));

        aMerchandisePrice.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aMerchandisePrice.setToolTipText("");
        MerchandiseAdd.add(aMerchandisePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 180, 30));

        aMerchandiseAdd.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        aMerchandiseAdd.setForeground(new java.awt.Color(58, 83, 155));
        aMerchandiseAdd.setText("ADD");
        aMerchandiseAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aMerchandiseAddActionPerformed(evt);
            }
        });
        MerchandiseAdd.add(aMerchandiseAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 130, 40));

        jLabel39.setBackground(new java.awt.Color(58, 83, 155));
        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(58, 83, 155));
        jLabel39.setText("Input  Detailed Information to Add a New Merchandise");
        MerchandiseAdd.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel32.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-shopping_bag.png"))); // NOI18N
        MerchandiseAdd.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 590, 470));

        MerchandiseJPanel.add(MerchandiseAdd, "card3");

        MerchandiseView.setBackground(new java.awt.Color(255, 255, 255));
        MerchandiseView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(58, 83, 155));
        jLabel40.setText("Name:");
        MerchandiseView.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, 30));

        jLabel41.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(58, 83, 155));
        jLabel41.setText("Price:");
        jLabel41.setToolTipText("");
        MerchandiseView.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 80, 30));

        vMerchandiseQuantity.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vMerchandiseQuantity.setToolTipText("");
        vMerchandiseQuantity.setEnabled(false);
        MerchandiseView.add(vMerchandiseQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 180, 30));

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(58, 83, 155));
        jLabel42.setText("Quantity:");
        jLabel42.setToolTipText("");
        MerchandiseView.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, 30));

        vMerchandiseName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vMerchandiseName.setToolTipText("");
        vMerchandiseName.setEnabled(false);
        MerchandiseView.add(vMerchandiseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 180, 30));

        vMerchandisePrice.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vMerchandisePrice.setToolTipText("");
        vMerchandisePrice.setEnabled(false);
        MerchandiseView.add(vMerchandisePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 180, 30));

        vMerchandiseUpload.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        vMerchandiseUpload.setForeground(new java.awt.Color(58, 83, 155));
        vMerchandiseUpload.setText("UPLOAD");
        vMerchandiseUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vMerchandiseUploadActionPerformed(evt);
            }
        });
        MerchandiseView.add(vMerchandiseUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 130, 40));

        btnMerchandiseSave.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnMerchandiseSave.setForeground(new java.awt.Color(58, 83, 155));
        btnMerchandiseSave.setText("SAVE");
        btnMerchandiseSave.setEnabled(false);
        btnMerchandiseSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMerchandiseSaveActionPerformed(evt);
            }
        });
        MerchandiseView.add(btnMerchandiseSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 130, 40));

        jLabel43.setBackground(new java.awt.Color(58, 83, 155));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(58, 83, 155));
        jLabel43.setText("Merchandise Detailed Information");
        MerchandiseView.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-shopping_bag.png"))); // NOI18N
        MerchandiseView.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 590, 470));

        MerchandiseJPanel.add(MerchandiseView, "card4");

        Merchandise.add(MerchandiseJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        btnDelMerchandise.setBackground(new java.awt.Color(255, 255, 255));
        btnDelMerchandise.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDelMerchandise.setForeground(new java.awt.Color(58, 83, 155));
        btnDelMerchandise.setText("Delete");
        btnDelMerchandise.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnDelMerchandise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMerchandiseActionPerformed(evt);
            }
        });
        Merchandise.add(btnDelMerchandise, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 110, 30));

        tableMerchandise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMerchandise.setFocusable(false);
        tableMerchandise.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableMerchandise.setRowHeight(30);
        tableMerchandise.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tableMerchandise.setShowVerticalLines(false);
        tableMerchandise.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tableMerchandise);
        if (tableMerchandise.getColumnModel().getColumnCount() > 0) {
            tableMerchandise.getColumnModel().getColumn(0).setResizable(false);
            tableMerchandise.getColumnModel().getColumn(1).setResizable(false);
            tableMerchandise.getColumnModel().getColumn(2).setResizable(false);
        }

        Merchandise.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 590, 230));

        ContentPanel.add(Merchandise, "card4");

        Deliveryman.setBackground(new java.awt.Color(255, 255, 255));
        Deliveryman.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewBus.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewBusActionPerformed(evt);
            }
        });
        Deliveryman.add(txtViewBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 160, 30));

        jLabel46.setBackground(new java.awt.Color(58, 83, 155));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(58, 83, 155));
        jLabel46.setText("Deliveryman Directory");
        Deliveryman.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        btnViewDelivery.setBackground(new java.awt.Color(255, 255, 255));
        btnViewDelivery.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewDelivery.setForeground(new java.awt.Color(58, 83, 155));
        btnViewDelivery.setText("View");
        btnViewDelivery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewDelivery.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDeliveryActionPerformed(evt);
            }
        });
        Deliveryman.add(btnViewDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 120, 30));

        DeliverymanJPanel.setBackground(new java.awt.Color(255, 255, 255));
        DeliverymanJPanel.setLayout(new java.awt.CardLayout());

        DeliveryManNull.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryManNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-deliveryman.png"))); // NOI18N
        DeliveryManNull.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 590, 470));

        DeliverymanJPanel.add(DeliveryManNull, "card5");

        DeliveryManAdd.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryManAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setBackground(new java.awt.Color(58, 83, 155));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(58, 83, 155));
        jLabel49.setText("Input Detailed Information to add a new DeliveryMan");
        DeliveryManAdd.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("Name:");
        DeliveryManAdd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 30));

        aDeliverymanName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aDeliverymanName.setToolTipText("");
        DeliveryManAdd.add(aDeliverymanName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 180, 30));

        btnSubmitDelivery.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmitDelivery.setForeground(new java.awt.Color(58, 83, 155));
        btnSubmitDelivery.setText("Submit");
        btnSubmitDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitDeliveryActionPerformed(evt);
            }
        });
        DeliveryManAdd.add(btnSubmitDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 130, 40));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(58, 83, 155));
        jLabel55.setText("Password:");
        jLabel55.setToolTipText("");
        DeliveryManAdd.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(58, 83, 155));
        jLabel63.setText("UserName:");
        jLabel63.setToolTipText("");
        DeliveryManAdd.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 40));

        aDeliverymanUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aDeliverymanUserName.setToolTipText("");
        DeliveryManAdd.add(aDeliverymanUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 180, 30));

        aDeliverymanPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aDeliverymanPassword.setToolTipText("");
        DeliveryManAdd.add(aDeliverymanPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 180, 30));

        jLabel36.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-deliveryman.png"))); // NOI18N
        DeliveryManAdd.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 590, 470));

        DeliverymanJPanel.add(DeliveryManAdd, "card3");

        DeliveryManView.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryManView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(58, 83, 155));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(58, 83, 155));
        jLabel48.setText("Deliveryman Detailed Information");
        DeliveryManView.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 83, 155));
        jLabel7.setText("Name:");
        DeliveryManView.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 30));

        vDeliveryManName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vDeliveryManName.setToolTipText("");
        vDeliveryManName.setEnabled(false);
        DeliveryManView.add(vDeliveryManName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 180, 30));

        btnDeliveryUpload.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnDeliveryUpload.setForeground(new java.awt.Color(58, 83, 155));
        btnDeliveryUpload.setText("UPLOAD");
        btnDeliveryUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryUploadActionPerformed(evt);
            }
        });
        DeliveryManView.add(btnDeliveryUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 130, 40));

        btnDeliverSave.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnDeliverSave.setForeground(new java.awt.Color(58, 83, 155));
        btnDeliverSave.setText("SAVE");
        btnDeliverSave.setEnabled(false);
        btnDeliverSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverSaveActionPerformed(evt);
            }
        });
        DeliveryManView.add(btnDeliverSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 130, 40));

        vDeliveryManUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vDeliveryManUserName.setToolTipText("");
        vDeliveryManUserName.setEnabled(false);
        DeliveryManView.add(vDeliveryManUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 180, 30));

        vDeliveryManPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vDeliveryManPassword.setToolTipText("");
        vDeliveryManPassword.setEnabled(false);
        DeliveryManView.add(vDeliveryManPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, 180, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(58, 83, 155));
        jLabel56.setText("Password:");
        jLabel56.setToolTipText("");
        DeliveryManView.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, 30));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(58, 83, 155));
        jLabel64.setText("UserName:");
        jLabel64.setToolTipText("");
        DeliveryManView.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 40));

        jLabel47.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-deliveryman.png"))); // NOI18N
        DeliveryManView.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 590, 470));

        DeliverymanJPanel.add(DeliveryManView, "card4");

        Deliveryman.add(DeliverymanJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserAccount", "Name", "Employee ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDelivery.setFocusable(false);
        TableDelivery.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableDelivery.setRowHeight(30);
        TableDelivery.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableDelivery.setShowVerticalLines(false);
        TableDelivery.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableDelivery);
        if (TableDelivery.getColumnModel().getColumnCount() > 0) {
            TableDelivery.getColumnModel().getColumn(0).setResizable(false);
            TableDelivery.getColumnModel().getColumn(1).setResizable(false);
            TableDelivery.getColumnModel().getColumn(2).setResizable(false);
        }

        Deliveryman.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 590, 250));

        btnDAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnDAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnDAdd.setText("Add");
        btnDAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnDAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAddActionPerformed(evt);
            }
        });
        Deliveryman.add(btnDAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 110, 30));

        btnDeliveryDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDeliveryDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDeliveryDelete.setForeground(new java.awt.Color(58, 83, 155));
        btnDeliveryDelete.setText("Delete");
        btnDeliveryDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnDeliveryDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeliveryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryDeleteActionPerformed(evt);
            }
        });
        Deliveryman.add(btnDeliveryDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 110, 30));

        ContentPanel.add(Deliveryman, "card4");

        ManageComplaint.setBackground(new java.awt.Color(255, 255, 255));
        ManageComplaint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewReceiver.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewReceiverActionPerformed(evt);
            }
        });
        ManageComplaint.add(txtViewReceiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 160, 30));

        jLabel70.setBackground(new java.awt.Color(58, 83, 155));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(58, 83, 155));
        jLabel70.setText("Manage Complaint");
        ManageComplaint.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        btnViewComplaint.setBackground(new java.awt.Color(255, 255, 255));
        btnViewComplaint.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewComplaint.setForeground(new java.awt.Color(58, 83, 155));
        btnViewComplaint.setText("View");
        btnViewComplaint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnViewComplaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewComplaintActionPerformed(evt);
            }
        });
        ManageComplaint.add(btnViewComplaint, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 120, 30));

        ComplaintJPanel.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintJPanel.setLayout(new java.awt.CardLayout());

        ComplaintNull.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        ComplaintJPanel.add(ComplaintNull, "card5");

        ComplaintInformation.setBackground(new java.awt.Color(255, 255, 255));
        ComplaintInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(58, 83, 155));
        jLabel93.setText("The detail information of Complaint");
        ComplaintInformation.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(58, 83, 155));
        jLabel94.setText("Complaint Reason:");
        ComplaintInformation.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, 30));

        txtComplaintEmployee.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtComplaintEmployee.setToolTipText("");
        ComplaintInformation.add(txtComplaintEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 170, 30));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(58, 83, 155));
        jLabel99.setText("Description:");
        jLabel99.setToolTipText("");
        ComplaintInformation.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, 30));

        txtComplaintDesc.setColumns(20);
        txtComplaintDesc.setRows(5);
        jScrollPane9.setViewportView(txtComplaintDesc);

        ComplaintInformation.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 530, 200));

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(58, 83, 155));
        jLabel100.setText("Employee:");
        jLabel100.setToolTipText("");
        ComplaintInformation.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, 30));

        sentMessageToAddresser.setBackground(new java.awt.Color(255, 255, 255));
        sentMessageToAddresser.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sentMessageToAddresser.setForeground(new java.awt.Color(58, 83, 155));
        sentMessageToAddresser.setText("Sent Message");
        sentMessageToAddresser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        sentMessageToAddresser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sentMessageToAddresser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentMessageToAddresserActionPerformed(evt);
            }
        });
        ComplaintInformation.add(sentMessageToAddresser, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 170, 30));

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(58, 83, 155));
        jLabel101.setText("Addresser:");
        jLabel101.setToolTipText("");
        ComplaintInformation.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, 30));

        sentMessageToReceiver.setBackground(new java.awt.Color(255, 255, 255));
        sentMessageToReceiver.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sentMessageToReceiver.setForeground(new java.awt.Color(58, 83, 155));
        sentMessageToReceiver.setText("Sent Message");
        sentMessageToReceiver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        sentMessageToReceiver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sentMessageToReceiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentMessageToReceiverActionPerformed(evt);
            }
        });
        ComplaintInformation.add(sentMessageToReceiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 170, 30));

        txtComplaintReason.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtComplaintReason.setToolTipText("");
        ComplaintInformation.add(txtComplaintReason, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 170, 30));

        txtComAddresser.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtComAddresser.setToolTipText("");
        ComplaintInformation.add(txtComAddresser, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 170, 30));

        ComplaintJPanel.add(ComplaintInformation, "card5");

        ManageComplaint.add(ComplaintJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableComplaint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Complaint Reson", "Addresser", "Receiver"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane8.setViewportView(TableComplaint);
        if (TableComplaint.getColumnModel().getColumnCount() > 0) {
            TableComplaint.getColumnModel().getColumn(0).setResizable(false);
            TableComplaint.getColumnModel().getColumn(1).setResizable(false);
            TableComplaint.getColumnModel().getColumn(2).setResizable(false);
        }

        ManageComplaint.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 630, 250));

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
        ManageInformation.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 810, 200, 40));

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
        ManageInformation.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 810, 200, 40));

        jLabel71.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(58, 83, 155));
        jLabel71.setText("Enterprise Name:");
        jLabel71.setToolTipText("");
        ManageInformation.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, 30));

        txtEntName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtEntName.setForeground(new java.awt.Color(58, 83, 155));
        txtEntName.setToolTipText("");
        txtEntName.setEnabled(false);
        ManageInformation.add(txtEntName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 180, 30));

        txtEntLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtEntLocation.setForeground(new java.awt.Color(58, 83, 155));
        txtEntLocation.setToolTipText("");
        txtEntLocation.setEnabled(false);
        ManageInformation.add(txtEntLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 180, 30));

        jLabel72.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(58, 83, 155));
        jLabel72.setText("Location:");
        jLabel72.setToolTipText("");
        ManageInformation.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 90, 30));

        jLabel73.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("PM");
        jLabel73.setToolTipText("");
        ManageInformation.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 460, 60, 30));

        txtPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(58, 83, 155));
        txtPhoneNumber.setToolTipText("");
        txtPhoneNumber.setEnabled(false);
        ManageInformation.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 180, 30));

        jLabel74.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(58, 83, 155));
        jLabel74.setText("Work Time:");
        jLabel74.setToolTipText("");
        ManageInformation.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 90, 30));

        jLabel75.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(58, 83, 155));
        jLabel75.setText("Password:");
        jLabel75.setToolTipText("");
        ManageInformation.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 90, 30));

        txtPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(58, 83, 155));
        txtPassword.setToolTipText("");
        txtPassword.setEnabled(false);
        ManageInformation.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 180, 30));

        jLabel76.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(58, 83, 155));
        jLabel76.setText("User Account:");
        jLabel76.setToolTipText("");
        ManageInformation.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 120, 30));

        txtUserAccount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtUserAccount.setForeground(new java.awt.Color(58, 83, 155));
        txtUserAccount.setToolTipText("");
        txtUserAccount.setEnabled(false);
        ManageInformation.add(txtUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 180, 30));

        jButton9.setForeground(new java.awt.Color(58, 83, 155));
        jButton9.setText("SET LOCATION");
        jButton9.setEnabled(false);
        ManageInformation.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, -1, -1));

        comboxClosedTime.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        comboxClosedTime.setForeground(new java.awt.Color(58, 83, 155));
        comboxClosedTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        comboxClosedTime.setEnabled(false);
        ManageInformation.add(comboxClosedTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 60, 50));

        jLabel77.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(58, 83, 155));
        jLabel77.setText("Status:");
        jLabel77.setToolTipText("");
        ManageInformation.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 60, 30));

        comboStatus.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        comboStatus.setForeground(new java.awt.Color(58, 83, 155));
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OPEN", "CLOSED" }));
        comboStatus.setEnabled(false);
        ManageInformation.add(comboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 180, 50));

        comboxOpenTime.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        comboxOpenTime.setForeground(new java.awt.Color(58, 83, 155));
        comboxOpenTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", " " }));
        comboxOpenTime.setEnabled(false);
        ManageInformation.add(comboxOpenTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 60, 50));

        jLabel83.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(58, 83, 155));
        jLabel83.setText("Phone Number:");
        jLabel83.setToolTipText("");
        ManageInformation.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 30));

        jLabel84.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(58, 83, 155));
        jLabel84.setText("AM - ");
        jLabel84.setToolTipText("");
        ManageInformation.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 460, 60, 30));

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-profile.png"))); // NOI18N
        ManageInformation.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 680, 670));

        jLabel86.setBackground(new java.awt.Color(58, 83, 155));
        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(58, 83, 155));
        jLabel86.setText("Manage Information");
        ManageInformation.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        ContentPanel.add(ManageInformation, "card8");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 128, -1, 954));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 50, 50));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-fast_moving_consumer_goods.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 348, -1, 60));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-delivery.png"))); // NOI18N
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 48, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(true);
        Merchandise.setVisible(false);
        Deliveryman.setVisible(false);
        Order.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        populateMessageTable();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Merchandise.setVisible(false);
        Deliveryman.setVisible(false);
        Order.setVisible(true);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        RequestListView.setVisible(false);
        RequestListNull.setVisible(true);
        populateOrderTable();
        /*
        //SubJPanel
        DoctorNull.setVisible(true);
        StudentWaitList.setVisible(false);
        DoctorInformation.setVisible(false);
        
        //first-in
        refreshStudentTable();*/
    }//GEN-LAST:event_btnOrderActionPerformed

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
        Merchandise.setVisible(false);

        Deliveryman.setVisible(false);

        Order.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(true);

        /*txtEntName.setText(kindergarden.getName());
        txtEntLocation.setText(kindergarden.getName());
        txtPhoneNumber.setText(kindergarden.getName());
        txtEntName.setText(kindergarden.getName());
        comboStatus.setSelectedItem(kindergarden.getStatus());
        comboxOpenTime.setSelectedItem(kindergarden.getOpenTime());
        comboxClosedTime.setSelectedItem(kindergarden.getClosedTime());*/
    }//GEN-LAST:event_btnInformationActionPerformed

    private void btnMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMerchandiseActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Merchandise.setVisible(true);
        Deliveryman.setVisible(false);
        Order.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);
        populateMerchandiseTable();

        MerchandiseNull.setVisible(true);
        MerchandiseAdd.setVisible(false);
        MerchandiseView.setVisible(false);
    }//GEN-LAST:event_btnMerchandiseActionPerformed
    
    private void btnDeliverymanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverymanActionPerformed
        // TODO add your handling code here:
        populateDeliveryTable();
        Dashboard.setVisible(false);
        Merchandise.setVisible(false);
        Deliveryman.setVisible(true);
        Order.setVisible(false);
        ManageComplaint.setVisible(false);
        ManageInformation.setVisible(false);

        DeliveryManNull.setVisible(true);
        DeliveryManAdd.setVisible(false);
        DeliveryManView.setVisible(false);
    }//GEN-LAST:event_btnDeliverymanActionPerformed

    private void btnComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComplaintActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        Merchandise.setVisible(false);

        Deliveryman.setVisible(false);

        Order.setVisible(false);
        ManageComplaint.setVisible(true);
        ManageInformation.setVisible(false);

        //Sub
        ComplaintNull.setVisible(true);
        ComplaintInformation.setVisible(false);
    }//GEN-LAST:event_btnComplaintActionPerformed

    private void txtStudentViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentViewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentViewActionPerformed

    private void btnViewMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMerchandiseActionPerformed
        // TODO add your handling code here:
        MerchandiseNull.setVisible(false);
        MerchandiseAdd.setVisible(false);
        MerchandiseView.setVisible(true);

        int selectedRow = tableMerchandise.getSelectedRow();

        if (selectedRow >= 0) {
            Merchandise s = (Merchandise) tableMerchandise.getValueAt(selectedRow, 0);
            vMerchandiseName.setText(s.getName());
            vMerchandisePrice.setText(Integer.toString(s.getPrice()));
            vMerchandiseQuantity.setText(Integer.toString(s.getQuantity()));
            merchandise = s;
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Merchandise.");
        }
    }//GEN-LAST:event_btnViewMerchandiseActionPerformed

    private void txtViewBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewBusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewBusActionPerformed

    private void txtViewReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewReceiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewReceiverActionPerformed

    private void btnMerchandiseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMerchandiseAddActionPerformed
        // TODO add your handling code here:
        MerchandiseNull.setVisible(false);
        MerchandiseAdd.setVisible(true);
        MerchandiseView.setVisible(false);
    }//GEN-LAST:event_btnMerchandiseAddActionPerformed

    private void btnViewDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableDelivery.getSelectedRow();
        if (selectedRow >= 0) {
            DeliveryManNull.setVisible(false);
            DeliveryManAdd.setVisible(false);
            DeliveryManView.setVisible(true);
            UserAccount s = (UserAccount) TableDelivery.getValueAt(selectedRow, 0);
            vDeliveryManName.setText(s.getEmployee().getName());
            vDeliveryManUserName.setText(s.getUsername());
            vDeliveryManPassword.setText(s.getPassword());
            deliveryaccount = s;
        } else {
            JOptionPane.showMessageDialog(null, "Please select a DeliveryMan.");
        }
    }//GEN-LAST:event_btnViewDeliveryActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtEntName.setEnabled(true);
        txtEntLocation.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
        txtEntName.setEnabled(true);
        comboStatus.setEnabled(true);
        comboxOpenTime.setEnabled(true);
        comboxClosedTime.setEnabled(true);
        txtPassword.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnSave.setEnabled(true);
        btnphotoUpload.setEnabled(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:

        /*txtEntName.setText(kindergarden.getName());
        txtEntLocation.setText(kindergarden.getName());
        txtPhoneNumber.setText(kindergarden.getName());
        txtEntName.setText(kindergarden.getName());
        comboStatus.setSelectedItem(kindergarden.getStatus());
        comboxOpenTime.setSelectedItem(kindergarden.getOpenTime());
        comboxClosedTime.setSelectedItem(kindergarden.getClosedTime());*/
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnphotoUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphotoUploadActionPerformed
        // TODO add your handling code here:
        /*JFileChooser upload = new JFileChooser();
       upload.showOpenDialog(null);
       File file = upload.getSelectedFile();
       String path = file.getAbsolutePath();
       imagePath = path;
       
       Image im = Toolkit.getDefaultToolkit().createImage(path);
       im = im.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
       ImageIcon ima = new ImageIcon(im);
       kindergarden.setMyimage(ima);
       image.setIcon(ima);*/
    }//GEN-LAST:event_btnphotoUploadActionPerformed

    private void sentMessageToAddresserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentMessageToAddresserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sentMessageToAddresserActionPerformed

    private void sentMessageToReceiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sentMessageToReceiverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sentMessageToReceiverActionPerformed

    private void btnViewComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewComplaintActionPerformed
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
    }//GEN-LAST:event_btnViewComplaintActionPerformed

    private void txtStudentView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentView1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentView1ActionPerformed

    private void btnViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableOrder.getSelectedRow();
        if (selectedRow >= 0) {
            comboDeliveryman.removeAllItems();
            for (UserAccount userAccount : marketEnterprise.getUserAccountDirectory().getUserAccountList()) {
                if (userAccount.getRole().toString().equals("Business.Role.DeliveryManRole")) {
                    comboDeliveryman.addItem(userAccount.getEmployee().getName());
                }
            }
            RequestListNull.setVisible(false);
            RequestListView.setVisible(true);
            selectMerchandiseOrder = (MerchandiseOrder) TableOrder.getValueAt(selectedRow, 0);
            if (selectMerchandiseOrder.getStatus().equalsIgnoreCase("Waiting for delivery")) {
                btnRequestAssign.setEnabled(true);
            } else {
                btnRequestAssign.setEnabled(false);
            }
            txtRequestCustomer.setText(selectMerchandiseOrder.getSender());
            txtRequestLocation.setText(selectMerchandiseOrder.getLocation());
            txtRequestPhone.setText(selectMerchandiseOrder.getPhoneNumber());
            txtRequestD.setText(selectMerchandiseOrder.getReceiver());
            populateOrderDetailsTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Order.");
        };
    }//GEN-LAST:event_btnViewOrderActionPerformed

    private void btnDelMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMerchandiseActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableMerchandise.getSelectedRow();
        if (selectedRow >= 0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                Merchandise merchandise = (Merchandise) tableMerchandise.getValueAt(selectedRow, 0);
                marketEnterprise.removeMerchandise(merchandise);
                populateMerchandiseTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnDelMerchandiseActionPerformed

    private void txtRequestLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestLocationActionPerformed

    private void txtRequestCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestCustomerActionPerformed

    private void btnDAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAddActionPerformed
        // TODO add your handling code here:
        DeliveryManNull.setVisible(false);
        DeliveryManAdd.setVisible(true);
        DeliveryManView.setVisible(false);
    }//GEN-LAST:event_btnDAddActionPerformed

    private void aMerchandiseAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aMerchandiseAddActionPerformed
        // TODO add your handling code here:
        Merchandise t = new Merchandise();
        t.setName(aMerchandiseName.getText());
        t.setPrice(Integer.parseInt(aMerchandisePrice.getText()));
        t.setQuantity(Integer.parseInt(aMerchandiseQuantity.getText()));
        marketEnterprise.getMerchandiseList().add(t);
        populateMerchandiseTable();
        JOptionPane.showMessageDialog(null, "Add Successfully");
        aMerchandiseName.setText("");
        aMerchandisePrice.setText("");
        aMerchandiseQuantity.setText("");
    }//GEN-LAST:event_aMerchandiseAddActionPerformed

    private void btnDeliveryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableDelivery.getSelectedRow();
        if (selectedRow >= 0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                UserAccount userAccount = (UserAccount) TableDelivery.getValueAt(selectedRow, 0);
                marketEnterprise.getUserAccountDirectory().getUserAccountList().remove(userAccount);
                populateDeliveryTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnDeliveryDeleteActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSubmitDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitDeliveryActionPerformed
        // TODO add your handling code here:
        String username = aDeliverymanUserName.getText();
        String password = aDeliverymanPassword.getText();
        String name = aDeliverymanName.getText();
        Employee employee = marketEnterprise.getEmployeeDirectory().createEmployee(name);
        UserAccount account = marketEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new DeliveryManRole());
        populateDeliveryTable();
        
        aDeliverymanUserName.setText("");
        aDeliverymanPassword.setText("");
        aDeliverymanName.setText("");
        
        DeliveryManNull.setVisible(true);
        DeliveryManAdd.setVisible(false);
        DeliveryManView.setVisible(false);
    }//GEN-LAST:event_btnSubmitDeliveryActionPerformed

    private void vMerchandiseUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vMerchandiseUploadActionPerformed
        // TODO add your handling code here:
        vMerchandiseName.setEnabled(true);
        vMerchandisePrice.setEnabled(true);
        vMerchandiseQuantity.setEnabled(true);
        btnMerchandiseSave.setEnabled(true);
        vMerchandiseUpload.setEnabled(false);
    }//GEN-LAST:event_vMerchandiseUploadActionPerformed

    private void btnMerchandiseSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMerchandiseSaveActionPerformed
        // TODO add your handling code here:
        merchandise.setName(vMerchandiseName.getText());
        merchandise.setPrice(Integer.parseInt(vMerchandisePrice.getText()));
        merchandise.setQuantity(Integer.parseInt(vMerchandiseQuantity.getText()));
        vMerchandiseName.setEnabled(false);
        vMerchandisePrice.setEnabled(false);
        vMerchandiseQuantity.setEnabled(false);
        btnMerchandiseSave.setEnabled(false);
        vMerchandiseUpload.setEnabled(true);
        populateMerchandiseTable();
    }//GEN-LAST:event_btnMerchandiseSaveActionPerformed

    private void btnDeliveryUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryUploadActionPerformed
        // TODO add your handling code here:
        vDeliveryManName.setEnabled(true);
        vDeliveryManUserName.setEnabled(false);
        vDeliveryManPassword.setEnabled(true);
        btnDeliveryUpload.setEnabled(false);
        btnDeliverSave.setEnabled(true);
    }//GEN-LAST:event_btnDeliveryUploadActionPerformed

    private void btnDeliverSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverSaveActionPerformed
        // TODO add your handling code here:
        deliveryaccount.getEmployee().setName(vDeliveryManName.getText());
        deliveryaccount.setPassword(vDeliveryManPassword.getText());
        vDeliveryManName.setEnabled(false);
        vDeliveryManUserName.setEnabled(false);
        vDeliveryManPassword.setEnabled(false);
        btnDeliveryUpload.setEnabled(true);
        btnDeliverSave.setEnabled(false);
        populateDeliveryTable();
    }//GEN-LAST:event_btnDeliverSaveActionPerformed

    private void txtRequestPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestPhoneActionPerformed

    private void btnRequestAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestAssignActionPerformed
        // TODO add your handling code here:
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                if (m.getMarketName().equals(marketEnterprise.getName())) {
                    if (m.toString().equals(selectMerchandiseOrder.toString())) {
                        m.setReceiver(comboDeliveryman.getSelectedItem().toString());
                        m.setStatus("In delivery");
                        
                        Message message1 = new Message();
                        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd  hh:mm");
                        Date dNow = new Date();
                        message1.setReceiver(comboDeliveryman.getSelectedItem().toString());
                        message1.setContent("You received a new delivery request");
                        message1.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message1);
                        
                        Message message2 = new Message();
                        message2.setReceiver(m.getSender());
                        message2.setContent("Your market order (id" + m.toString() + ") is in deliverying.");
                        message2.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message2);
                                             
                        populateOrderTable();
                        JOptionPane.showMessageDialog(null, "Assign successfully!!");
                        RequestListView.setVisible(false);
                        RequestListNull.setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRequestAssignActionPerformed

    private void txtRequestDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestDActionPerformed

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
    private javax.swing.JPanel DeliveryManAdd;
    private javax.swing.JPanel DeliveryManNull;
    private javax.swing.JPanel DeliveryManView;
    private javax.swing.JPanel Deliveryman;
    private javax.swing.JPanel DeliverymanJPanel;
    private javax.swing.JPanel ManageComplaint;
    private javax.swing.JPanel ManageInformation;
    private javax.swing.JPanel Merchandise;
    private javax.swing.JPanel MerchandiseAdd;
    private javax.swing.JPanel MerchandiseJPanel;
    private javax.swing.JPanel MerchandiseNull;
    private javax.swing.JPanel MerchandiseView;
    private javax.swing.JPanel Order;
    private javax.swing.JPanel OrderListJPanel;
    private javax.swing.JPanel RequestListNull;
    private javax.swing.JPanel RequestListView;
    private javax.swing.JTable TableComplaint;
    private javax.swing.JTable TableDelivery;
    private javax.swing.JTable TableNotification;
    private javax.swing.JTable TableOrder;
    private javax.swing.JTextField aDeliverymanName;
    private javax.swing.JTextField aDeliverymanPassword;
    private javax.swing.JTextField aDeliverymanUserName;
    private javax.swing.JButton aMerchandiseAdd;
    private javax.swing.JTextField aMerchandiseName;
    private javax.swing.JTextField aMerchandisePrice;
    private javax.swing.JTextField aMerchandiseQuantity;
    private javax.swing.JButton btnComplaint;
    private javax.swing.JButton btnDAdd;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDelMerchandise;
    private javax.swing.JButton btnDeliverSave;
    private javax.swing.JButton btnDeliveryDelete;
    private javax.swing.JButton btnDeliveryUpload;
    private javax.swing.JButton btnDeliveryman;
    private javax.swing.JButton btnInformation;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnMerchandise;
    private javax.swing.JButton btnMerchandiseAdd;
    private javax.swing.JButton btnMerchandiseSave;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnRequestAssign;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmitDelivery;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnViewComplaint;
    private javax.swing.JButton btnViewDelivery;
    private javax.swing.JButton btnViewMerchandise;
    private javax.swing.JButton btnViewOrder;
    private javax.swing.JButton btnphotoUpload;
    private javax.swing.JComboBox comboDeliveryman;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<String> comboxClosedTime;
    private javax.swing.JComboBox<String> comboxOpenTime;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labelComplaintNum;
    private javax.swing.JLabel labelDoctorNum;
    private javax.swing.JLabel labelPatientNum;
    private javax.swing.JButton sentMessageToAddresser;
    private javax.swing.JButton sentMessageToReceiver;
    private javax.swing.JTable tableMerchandise;
    private javax.swing.JTable tableRequestDetails;
    private javax.swing.JTextField txtComAddresser;
    private javax.swing.JTextArea txtComplaintDesc;
    private javax.swing.JTextField txtComplaintEmployee;
    private javax.swing.JTextField txtComplaintReason;
    private javax.swing.JTextField txtEntLocation;
    private javax.swing.JTextField txtEntName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtRequestCustomer;
    private javax.swing.JTextField txtRequestD;
    private javax.swing.JTextField txtRequestLocation;
    private javax.swing.JTextField txtRequestPhone;
    private javax.swing.JTextField txtStudentView;
    private javax.swing.JTextField txtStudentView1;
    private javax.swing.JTextField txtUserAccount;
    private javax.swing.JTextField txtViewBus;
    private javax.swing.JTextField txtViewReceiver;
    private javax.swing.JTextField vDeliveryManName;
    private javax.swing.JTextField vDeliveryManPassword;
    private javax.swing.JTextField vDeliveryManUserName;
    private javax.swing.JTextField vMerchandiseName;
    private javax.swing.JTextField vMerchandisePrice;
    private javax.swing.JTextField vMerchandiseQuantity;
    private javax.swing.JButton vMerchandiseUpload;
    // End of variables declaration//GEN-END:variables
}