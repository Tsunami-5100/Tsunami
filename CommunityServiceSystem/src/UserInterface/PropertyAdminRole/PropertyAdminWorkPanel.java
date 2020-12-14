/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PropertyAdminRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PropertyEnterprise;
import Business.Message.Message;
import Business.Network.Network;
import Business.Organization.PropertyManagementOrganization;
import Business.Organization.Organization;
import Business.Property.Payment;
import Business.Property.SRRequest;
import Business.Resident.Resident;
import Business.Role.RepairManRole;
import Business.Role.SecurityRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
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
public class PropertyAdminWorkPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form PropertyAdminWorkPanel
     */
    int hour, minute, second;

    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    private UserAccount selectedUserAccount;
    PropertyManagementOrganization propertyManagementOrganization;
    PropertyEnterprise propertyEnterprise;
    private Resident resident;
    private SRRequest selectedRequest;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public PropertyAdminWorkPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        resident = new Resident();
        ecoSystem = dB4OUtil.retrieveSystem();
        this.propertyEnterprise = (PropertyEnterprise) enterprise;
        System.out.print(propertyEnterprise.getName());
        this.propertyManagementOrganization = (PropertyManagementOrganization) organization;
        populateMessageTable();
        //jLabel6.setText("HI! " + userAccount.getEmployee().getName());
        jLabel30.setText("You have " + TableNotification.getRowCount() + " new Notifications:");
        Thread t = new Thread(this);
        t.start();
    }

    public void populateSecurityTable() {
        DefaultTableModel model = (DefaultTableModel) TableSecurity.getModel();
        model.setRowCount(0);
        for (UserAccount userAccount : propertyEnterprise.getUserAccountDirectory().getUserAccountList()) {
            if (userAccount.getRole().toString().equals("Business.Role.SecurityRole")) {
                Object[] row = new Object[3];
                row[0] = userAccount;
                row[1] = userAccount.getEmployee().getName();
                row[2] = userAccount.getEmployee().getId();
                model.addRow(row);
            }
        }

    }

    public void populateRepairTable() {
        DefaultTableModel model = (DefaultTableModel) TableRepairman.getModel();
        model.setRowCount(0);
        for (UserAccount userAccount : propertyEnterprise.getUserAccountDirectory().getUserAccountList()) {
            if (userAccount.getRole().toString().equals("Business.Role.RepairManRole")) {
                Object[] row = new Object[3];
                row[0] = userAccount;
                row[1] = userAccount.getEmployee().getName();
                row[2] = userAccount.getEmployee().getId();
                model.addRow(row);
            }
        }

    }

    public void populatePaymentTable() {
        DefaultTableModel model = (DefaultTableModel) tabPayment.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (Payment m : resident.getPaymentList()) {
                if (m.getSender().equals(propertyEnterprise.getName())) {
                    Object[] row = new Object[5];
                    row[0] = m;
                    row[1] = m.getType();
                    row[2] = m.getSender();
                    row[3] = m.getReceiver();
                    row[4] = m.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    public void populatePendingPaymentTable() {
        DefaultTableModel model = (DefaultTableModel) tabPayment.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (Payment m : resident.getPaymentList()) {
                if (m.getSender().equals(propertyEnterprise.getName()) && m.getStatus().equalsIgnoreCase("Pending")) {
                    Object[] row = new Object[5];
                    row[0] = m;
                    row[1] = m.getType();
                    row[2] = m.getSender();
                    row[3] = m.getReceiver();
                    row[4] = m.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateCompeletedPaymentTable() {
        DefaultTableModel model = (DefaultTableModel) tabPayment.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (Payment m : resident.getPaymentList()) {
                if (m.getSender().equals(propertyEnterprise.getName()) && m.getStatus().equalsIgnoreCase("Compeleted")) {
                    Object[] row = new Object[5];
                    row[0] = m;
                    row[1] = m.getType();
                    row[2] = m.getSender();
                    row[3] = m.getReceiver();
                    row[4] = m.getStatus();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateAppRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();
        model.setRowCount(0);
        System.out.print(propertyEnterprise.getName());
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (SRRequest m : resident.getSRRequestList()) {
                if (m.getPropertyName().equals(propertyEnterprise.getName())) {
                    Object[] row = new Object[6];
                    row[0] = m;
                    row[1] = m.getSender();
                    row[2] = m.getRequestType();
                    row[3] = m.getStatus();
                    row[4] = m.getRequestDate();
                    row[5] = m.getReceiver();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateSAppRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();
        model.setRowCount(0);
        System.out.print(propertyEnterprise.getName());
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (SRRequest m : resident.getSRRequestList()) {
                if (m.getPropertyName().equals(propertyEnterprise.getName()) && m.getRequestType().equalsIgnoreCase("Security Request")) {
                    Object[] row = new Object[5];
                    row[0] = m;
                    row[1] = m.getSender();
                    row[2] = m.getRequestType();
                    row[3] = m.getStatus();
                    row[4] = m.getRequestDate();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateRAppRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tabApplication.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (SRRequest m : resident.getSRRequestList()) {
                if (m.getPropertyName().equals(propertyEnterprise.getName()) && m.getRequestType().equalsIgnoreCase("Maintenance Request")) {
                    Object[] row = new Object[5];
                    row[0] = m;
                    row[1] = m.getSender();
                    row[2] = m.getRequestType();
                    row[3] = m.getStatus();
                    row[4] = m.getRequestDate();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateMessageTable() {
        DefaultTableModel model = (DefaultTableModel) TableNotification.getModel();
        model.setRowCount(0);
        for (Message m : ecoSystem.getMessageList().getMessageList()) {
            if (m.getReceiver().equals(propertyEnterprise.getName())) {
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

        btnDashboard = new javax.swing.JButton();
        labAdminName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSecurity = new javax.swing.JButton();
        btnRepairman = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPayment = new javax.swing.JButton();
        btnApplicaiton = new javax.swing.JButton();
        btnCompalint = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        labTime = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        btnMarkread = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        PaymentPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabPayment = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btnPAdd = new javax.swing.JButton();
        btnPView = new javax.swing.JButton();
        txtViewBus2 = new javax.swing.JTextField();
        btnPDelete = new javax.swing.JButton();
        payment = new javax.swing.JPanel();
        paymentNull = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        paymentAdd = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        ResidentCombox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        APaymentFee = new javax.swing.JTextField();
        btnAPAdd = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        APaymentType = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        PaymentView = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        VPAmount = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        VPType = new javax.swing.JTextField();
        VPRdate = new javax.swing.JTextField();
        VPRname = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        VPRphone = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        PComboStatus = new javax.swing.JComboBox();
        RepairPanel = new javax.swing.JPanel();
        txtViewBus1 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        btnRView = new javax.swing.JButton();
        Repairman = new javax.swing.JPanel();
        RepairmanNull = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        RepairmanAdd = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        aRPassword = new javax.swing.JTextField();
        aRName = new javax.swing.JTextField();
        RAdd = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        aRUserName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        RepairmanView = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        vRPhoneNumber = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        vRName = new javax.swing.JTextField();
        btnRUpload = new javax.swing.JButton();
        btnRSave = new javax.swing.JButton();
        vRUserName = new javax.swing.JTextField();
        vRPassword = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableRepairman = new javax.swing.JTable();
        btnRAdd = new javax.swing.JButton();
        btnRDelete = new javax.swing.JButton();
        SecurityPanel = new javax.swing.JPanel();
        txtViewBus = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        btnSView = new javax.swing.JButton();
        SecurityJpanel = new javax.swing.JPanel();
        SecurityNull = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        SecurityAdd = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        aSName = new javax.swing.JTextField();
        btnSubmitSecurity = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        aSUserName = new javax.swing.JTextField();
        aSPassword = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        SecurityView = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vSName = new javax.swing.JTextField();
        btnSupload = new javax.swing.JButton();
        btnSSave = new javax.swing.JButton();
        vSUserName = new javax.swing.JTextField();
        vSPassword = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        vSPhoneNumber = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableSecurity = new javax.swing.JTable();
        btnSAdd = new javax.swing.JButton();
        btnSDelete = new javax.swing.JButton();
        ApplicationPanel = new javax.swing.JPanel();
        txtViewBus3 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabApplication = new javax.swing.JTable();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        AComboAppType = new javax.swing.JComboBox();
        btnAppView = new javax.swing.JButton();
        ApplicationJPanel = new javax.swing.JPanel();
        ApplicationNull = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        AppSecurity = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        comboAPPGuard = new javax.swing.JComboBox();
        btnRequestSAssign1 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        txtSUrgency = new javax.swing.JTextField();
        txtRequestTypeS = new javax.swing.JTextField();
        txtRequestLocationS = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtSecurityDesc = new javax.swing.JTextArea();
        jLabel84 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        AppMaintenance = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        comboAPPReapairman = new javax.swing.JComboBox();
        btnRequestMAssign1 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtMUrgency = new javax.swing.JTextField();
        txtRequestIssueType = new javax.swing.JTextField();
        txtRequestApartment = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtMDesc = new javax.swing.JTextArea();
        jLabel71 = new javax.swing.JLabel();
        ComplaintPanel = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabDoctor1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 243, 244, 41));

        labAdminName.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labAdminName.setForeground(new java.awt.Color(255, 255, 255));
        labAdminName.setText("xxx");
        add(labAdminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 71, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 467, 41, 50));

        btnSecurity.setBackground(new java.awt.Color(58, 83, 155));
        btnSecurity.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnSecurity.setForeground(new java.awt.Color(255, 255, 255));
        btnSecurity.setText("Security Management");
        btnSecurity.setBorder(null);
        btnSecurity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecurityActionPerformed(evt);
            }
        });
        add(btnSecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 477, 244, 40));

        btnRepairman.setBackground(new java.awt.Color(58, 83, 155));
        btnRepairman.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRepairman.setForeground(new java.awt.Color(255, 255, 255));
        btnRepairman.setText("Repairman Management");
        btnRepairman.setBorder(null);
        btnRepairman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRepairman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairmanActionPerformed(evt);
            }
        });
        add(btnRepairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 398, 244, 40));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 388, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-euro_money.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 310, -1, -1));

        btnPayment.setBackground(new java.awt.Color(58, 83, 155));
        btnPayment.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnPayment.setText("Payment Management");
        btnPayment.setBorder(null);
        btnPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        add(btnPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 320, 244, 40));

        btnApplicaiton.setBackground(new java.awt.Color(58, 83, 155));
        btnApplicaiton.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnApplicaiton.setForeground(new java.awt.Color(255, 255, 255));
        btnApplicaiton.setText("Application Management");
        btnApplicaiton.setBorder(null);
        btnApplicaiton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnApplicaiton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplicaitonActionPerformed(evt);
            }
        });
        add(btnApplicaiton, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 555, 244, 40));

        btnCompalint.setBackground(new java.awt.Color(58, 83, 155));
        btnCompalint.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnCompalint.setForeground(new java.awt.Color(255, 255, 255));
        btnCompalint.setText("Complaint Management");
        btnCompalint.setBorder(null);
        btnCompalint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCompalint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompalintActionPerformed(evt);
            }
        });
        add(btnCompalint, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 634, 244, 40));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-strike.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 624, 50, 50));

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 1031, 291, 45));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setBackground(new java.awt.Color(58, 83, 155));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("DASHBOARD");

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

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("You have * new Notifications:");

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(219, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnMarkread, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(416, 416, 416))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(btnMarkread, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );

        ContentPanel.add(DashboardPanel, "card2");

        PaymentPanel.setBackground(new java.awt.Color(255, 255, 255));
        PaymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(58, 83, 155));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 83, 155));
        jLabel14.setText("MANAGE PAYMENT");
        PaymentPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 48));

        tabPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Payment Type", "Fee Amount", "Resident Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabPayment.setFocusable(false);
        tabPayment.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabPayment.setName("abc"); // NOI18N
        tabPayment.setRowHeight(25);
        tabPayment.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabPayment.setShowVerticalLines(false);
        tabPayment.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabPayment);
        if (tabPayment.getColumnModel().getColumnCount() > 0) {
            tabPayment.getColumnModel().getColumn(0).setResizable(false);
            tabPayment.getColumnModel().getColumn(1).setResizable(false);
            tabPayment.getColumnModel().getColumn(2).setResizable(false);
            tabPayment.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabPayment.getColumnModel().getColumn(3).setResizable(false);
            tabPayment.getColumnModel().getColumn(3).setPreferredWidth(60);
            tabPayment.getColumnModel().getColumn(4).setResizable(false);
        }

        PaymentPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 800, 236));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("Status:");
        PaymentPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 50));

        btnPAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnPAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnPAdd.setText("Add");
        btnPAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnPAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAddActionPerformed(evt);
            }
        });
        PaymentPanel.add(btnPAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 110, 30));

        btnPView.setBackground(new java.awt.Color(255, 255, 255));
        btnPView.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPView.setForeground(new java.awt.Color(58, 83, 155));
        btnPView.setText("View");
        btnPView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnPView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPViewActionPerformed(evt);
            }
        });
        PaymentPanel.add(btnPView, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 120, 30));

        txtViewBus2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewBus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewBus2ActionPerformed(evt);
            }
        });
        PaymentPanel.add(txtViewBus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 160, 30));

        btnPDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnPDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPDelete.setForeground(new java.awt.Color(58, 83, 155));
        btnPDelete.setText("Delete");
        btnPDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnPDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDeleteActionPerformed(evt);
            }
        });
        PaymentPanel.add(btnPDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 110, 30));

        payment.setBackground(new java.awt.Color(255, 255, 255));
        payment.setLayout(new java.awt.CardLayout());

        paymentNull.setBackground(new java.awt.Color(255, 255, 255));
        paymentNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-expensive.png"))); // NOI18N
        paymentNull.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        payment.add(paymentNull, "card5");

        paymentAdd.setBackground(new java.awt.Color(255, 255, 255));
        paymentAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setBackground(new java.awt.Color(58, 83, 155));
        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(58, 83, 155));
        jLabel53.setText("Input Detailed Information to add a new Payment");
        paymentAdd.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        ResidentCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        paymentAdd.add(ResidentCombox, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(58, 83, 155));
        jLabel10.setText("Resident:");
        paymentAdd.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, 30));

        APaymentFee.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        APaymentFee.setToolTipText("");
        paymentAdd.add(APaymentFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 180, 30));

        btnAPAdd.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnAPAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnAPAdd.setText("Submit");
        btnAPAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPAddActionPerformed(evt);
            }
        });
        paymentAdd.add(btnAPAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, 40));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(58, 83, 155));
        jLabel59.setText("Payment Type:");
        jLabel59.setToolTipText("");
        paymentAdd.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, 30));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(58, 83, 155));
        jLabel67.setText("Payment Fee Amount:");
        jLabel67.setToolTipText("");
        paymentAdd.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, 40));

        APaymentType.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        APaymentType.setToolTipText("");
        paymentAdd.add(APaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 180, 30));

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-expensive.png"))); // NOI18N
        paymentAdd.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 590, 470));

        payment.add(paymentAdd, "card3");

        PaymentView.setBackground(new java.awt.Color(255, 255, 255));
        PaymentView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setBackground(new java.awt.Color(58, 83, 155));
        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(58, 83, 155));
        jLabel54.setText("Payment  Detailed Information");
        PaymentView.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(58, 83, 155));
        jLabel28.setText("Payment Type:");
        PaymentView.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 30));

        VPAmount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        VPAmount.setToolTipText("");
        VPAmount.setEnabled(false);
        PaymentView.add(VPAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 180, 30));

        jLabel60.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(58, 83, 155));
        jLabel60.setText("Fee Amount:");
        jLabel60.setToolTipText("");
        PaymentView.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 30));

        VPType.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        VPType.setToolTipText("");
        VPType.setEnabled(false);
        PaymentView.add(VPType, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 180, 30));

        VPRdate.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        VPRdate.setToolTipText("");
        VPRdate.setEnabled(false);
        PaymentView.add(VPRdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 180, 30));

        VPRname.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        VPRname.setToolTipText("");
        VPRname.setEnabled(false);
        PaymentView.add(VPRname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 180, 30));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(58, 83, 155));
        jLabel61.setText("Resident Name:");
        jLabel61.setToolTipText("");
        PaymentView.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(58, 83, 155));
        jLabel68.setText("Request Date:");
        jLabel68.setToolTipText("");
        PaymentView.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, 40));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(58, 83, 155));
        jLabel62.setText("Resident Phone:");
        jLabel62.setToolTipText("");
        PaymentView.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, 30));

        VPRphone.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        VPRphone.setToolTipText("");
        VPRphone.setEnabled(false);
        PaymentView.add(VPRphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 180, 30));

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-expensive.png"))); // NOI18N
        PaymentView.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        payment.add(PaymentView, "card4");

        PaymentPanel.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        PComboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Pending", "Compeleted" }));
        PComboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PComboStatusActionPerformed(evt);
            }
        });
        PaymentPanel.add(PComboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 200, 30));

        ContentPanel.add(PaymentPanel, "card3");

        RepairPanel.setBackground(new java.awt.Color(255, 255, 255));
        RepairPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewBus1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewBus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewBus1ActionPerformed(evt);
            }
        });
        RepairPanel.add(txtViewBus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 160, 30));

        jLabel47.setBackground(new java.awt.Color(58, 83, 155));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(58, 83, 155));
        jLabel47.setText("Repairman Management");
        RepairPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        btnRView.setBackground(new java.awt.Color(255, 255, 255));
        btnRView.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRView.setForeground(new java.awt.Color(58, 83, 155));
        btnRView.setText("View");
        btnRView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnRView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRViewActionPerformed(evt);
            }
        });
        RepairPanel.add(btnRView, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 120, 30));

        Repairman.setBackground(new java.awt.Color(255, 255, 255));
        Repairman.setLayout(new java.awt.CardLayout());

        RepairmanNull.setBackground(new java.awt.Color(255, 255, 255));
        RepairmanNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance 2.png"))); // NOI18N
        RepairmanNull.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        Repairman.add(RepairmanNull, "card5");

        RepairmanAdd.setBackground(new java.awt.Color(255, 255, 255));
        RepairmanAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(58, 83, 155));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(58, 83, 155));
        jLabel50.setText("Input Detailed Information to add a new Security Guard");
        RepairmanAdd.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(58, 83, 155));
        jLabel8.setText("Name:");
        RepairmanAdd.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 30));

        aRPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aRPassword.setToolTipText("");
        RepairmanAdd.add(aRPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 180, 30));

        aRName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aRName.setToolTipText("");
        RepairmanAdd.add(aRName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 180, 30));

        RAdd.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        RAdd.setForeground(new java.awt.Color(58, 83, 155));
        RAdd.setText("ADD");
        RAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAddActionPerformed(evt);
            }
        });
        RepairmanAdd.add(RAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 130, 40));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(58, 83, 155));
        jLabel57.setText("Password:");
        jLabel57.setToolTipText("");
        RepairmanAdd.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(58, 83, 155));
        jLabel65.setText("UserName:");
        jLabel65.setToolTipText("");
        RepairmanAdd.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, 40));

        aRUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aRUserName.setToolTipText("");
        RepairmanAdd.add(aRUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 180, 30));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance 2.png"))); // NOI18N
        RepairmanAdd.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        Repairman.add(RepairmanAdd, "card3");

        RepairmanView.setBackground(new java.awt.Color(255, 255, 255));
        RepairmanView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setBackground(new java.awt.Color(58, 83, 155));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(58, 83, 155));
        jLabel51.setText("Repairman Detailed Information");
        RepairmanView.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(58, 83, 155));
        jLabel9.setText("Name:");
        RepairmanView.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 30));

        vRPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vRPhoneNumber.setToolTipText("");
        vRPhoneNumber.setEnabled(false);
        RepairmanView.add(vRPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 180, 30));

        jLabel52.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(58, 83, 155));
        jLabel52.setText("Phone:");
        jLabel52.setToolTipText("");
        RepairmanView.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 30));

        vRName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vRName.setToolTipText("");
        vRName.setEnabled(false);
        RepairmanView.add(vRName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 180, 30));

        btnRUpload.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnRUpload.setForeground(new java.awt.Color(58, 83, 155));
        btnRUpload.setText("UPLOAD");
        btnRUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRUploadActionPerformed(evt);
            }
        });
        RepairmanView.add(btnRUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 130, 40));

        btnRSave.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnRSave.setForeground(new java.awt.Color(58, 83, 155));
        btnRSave.setText("SAVE");
        btnRSave.setEnabled(false);
        btnRSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRSaveActionPerformed(evt);
            }
        });
        RepairmanView.add(btnRSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 130, 40));

        vRUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vRUserName.setToolTipText("");
        vRUserName.setEnabled(false);
        RepairmanView.add(vRUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 180, 30));

        vRPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vRPassword.setToolTipText("");
        vRPassword.setEnabled(false);
        RepairmanView.add(vRPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 180, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(58, 83, 155));
        jLabel58.setText("Password:");
        jLabel58.setToolTipText("");
        RepairmanView.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, 40));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(58, 83, 155));
        jLabel66.setText("UserName:");
        jLabel66.setToolTipText("");
        RepairmanView.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, 50));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance 2.png"))); // NOI18N
        RepairmanView.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        Repairman.add(RepairmanView, "card4");

        RepairPanel.add(Repairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableRepairman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User Name", "Name", "Employee ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableRepairman.setFocusable(false);
        TableRepairman.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableRepairman.setRowHeight(30);
        TableRepairman.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableRepairman.setShowVerticalLines(false);
        TableRepairman.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TableRepairman);
        if (TableRepairman.getColumnModel().getColumnCount() > 0) {
            TableRepairman.getColumnModel().getColumn(1).setResizable(false);
            TableRepairman.getColumnModel().getColumn(2).setResizable(false);
        }

        RepairPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 590, 220));

        btnRAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnRAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnRAdd.setText("Add");
        btnRAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnRAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAddActionPerformed(evt);
            }
        });
        RepairPanel.add(btnRAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 110, 30));

        btnRDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnRDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRDelete.setForeground(new java.awt.Color(58, 83, 155));
        btnRDelete.setText("Delete");
        btnRDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnRDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRDeleteActionPerformed(evt);
            }
        });
        RepairPanel.add(btnRDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 110, 30));

        ContentPanel.add(RepairPanel, "card4");

        SecurityPanel.setBackground(new java.awt.Color(255, 255, 255));
        SecurityPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewBus.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewBusActionPerformed(evt);
            }
        });
        SecurityPanel.add(txtViewBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 160, 30));

        jLabel46.setBackground(new java.awt.Color(58, 83, 155));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(58, 83, 155));
        jLabel46.setText("Security Guards Management");
        SecurityPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        btnSView.setBackground(new java.awt.Color(255, 255, 255));
        btnSView.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSView.setForeground(new java.awt.Color(58, 83, 155));
        btnSView.setText("View");
        btnSView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSViewActionPerformed(evt);
            }
        });
        SecurityPanel.add(btnSView, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 120, 30));

        SecurityJpanel.setBackground(new java.awt.Color(255, 255, 255));
        SecurityJpanel.setLayout(new java.awt.CardLayout());

        SecurityNull.setBackground(new java.awt.Color(255, 255, 255));
        SecurityNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard 2.png"))); // NOI18N
        SecurityNull.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 590, 470));

        SecurityJpanel.add(SecurityNull, "card5");

        SecurityAdd.setBackground(new java.awt.Color(255, 255, 255));
        SecurityAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setBackground(new java.awt.Color(58, 83, 155));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(58, 83, 155));
        jLabel49.setText("Input Detailed Information to add a new Security Guard");
        SecurityAdd.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("Name:");
        SecurityAdd.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 30));

        aSName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aSName.setToolTipText("");
        SecurityAdd.add(aSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 180, 30));

        btnSubmitSecurity.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnSubmitSecurity.setForeground(new java.awt.Color(58, 83, 155));
        btnSubmitSecurity.setText("ADD");
        btnSubmitSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitSecurityActionPerformed(evt);
            }
        });
        SecurityAdd.add(btnSubmitSecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 130, 40));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(58, 83, 155));
        jLabel55.setText("Password:");
        jLabel55.setToolTipText("");
        SecurityAdd.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(58, 83, 155));
        jLabel63.setText("UserName:");
        jLabel63.setToolTipText("");
        SecurityAdd.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, -1, 40));

        aSUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aSUserName.setToolTipText("");
        SecurityAdd.add(aSUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 180, 30));

        aSPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        aSPassword.setToolTipText("");
        SecurityAdd.add(aSPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 180, 30));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard 2.png"))); // NOI18N
        SecurityAdd.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 590, 470));

        SecurityJpanel.add(SecurityAdd, "card3");

        SecurityView.setBackground(new java.awt.Color(255, 255, 255));
        SecurityView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setBackground(new java.awt.Color(58, 83, 155));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(58, 83, 155));
        jLabel48.setText("Security guard Detailed Information");
        SecurityView.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 83, 155));
        jLabel7.setText("Name:");
        SecurityView.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 30));

        vSName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vSName.setToolTipText("");
        vSName.setEnabled(false);
        SecurityView.add(vSName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 180, 30));

        btnSupload.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnSupload.setForeground(new java.awt.Color(58, 83, 155));
        btnSupload.setText("UPLOAD");
        btnSupload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuploadActionPerformed(evt);
            }
        });
        SecurityView.add(btnSupload, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 130, 40));

        btnSSave.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnSSave.setForeground(new java.awt.Color(58, 83, 155));
        btnSSave.setText("SAVE");
        btnSSave.setEnabled(false);
        btnSSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSSaveActionPerformed(evt);
            }
        });
        SecurityView.add(btnSSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 130, 40));

        vSUserName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vSUserName.setToolTipText("");
        vSUserName.setEnabled(false);
        SecurityView.add(vSUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 180, 30));

        vSPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vSPassword.setToolTipText("");
        vSPassword.setEnabled(false);
        SecurityView.add(vSPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 180, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(58, 83, 155));
        jLabel56.setText("Password:");
        jLabel56.setToolTipText("");
        SecurityView.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, 30));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(58, 83, 155));
        jLabel64.setText("UserName:");
        jLabel64.setToolTipText("");
        SecurityView.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, 40));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(58, 83, 155));
        jLabel69.setText("Phone:");
        jLabel69.setToolTipText("");
        SecurityView.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, 30));

        vSPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        vSPhoneNumber.setToolTipText("");
        vSPhoneNumber.setEnabled(false);
        SecurityView.add(vSPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 180, 30));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard 2.png"))); // NOI18N
        SecurityView.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 590, 470));

        SecurityJpanel.add(SecurityView, "card4");

        SecurityPanel.add(SecurityJpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        TableSecurity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "UserName", "Name", "Employee ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableSecurity.setFocusable(false);
        TableSecurity.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableSecurity.setRowHeight(30);
        TableSecurity.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableSecurity.setShowVerticalLines(false);
        TableSecurity.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableSecurity);
        if (TableSecurity.getColumnModel().getColumnCount() > 0) {
            TableSecurity.getColumnModel().getColumn(0).setResizable(false);
            TableSecurity.getColumnModel().getColumn(1).setResizable(false);
            TableSecurity.getColumnModel().getColumn(2).setResizable(false);
        }

        SecurityPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 590, 220));

        btnSAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnSAdd.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnSAdd.setText("Add");
        btnSAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAddActionPerformed(evt);
            }
        });
        SecurityPanel.add(btnSAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 110, 30));

        btnSDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnSDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSDelete.setForeground(new java.awt.Color(58, 83, 155));
        btnSDelete.setText("Delete");
        btnSDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSDeleteActionPerformed(evt);
            }
        });
        SecurityPanel.add(btnSDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 110, 30));

        ContentPanel.add(SecurityPanel, "card4");

        ApplicationPanel.setBackground(new java.awt.Color(255, 255, 255));
        ApplicationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtViewBus3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtViewBus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewBus3ActionPerformed(evt);
            }
        });
        ApplicationPanel.add(txtViewBus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 370, 160, 30));

        tabApplication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Application ID", "Resident Name", "Application Type", "Status", "Request Date", "Assigned employee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabApplication.setFocusable(false);
        tabApplication.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabApplication.setName("abc"); // NOI18N
        tabApplication.setRowHeight(25);
        tabApplication.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabApplication.setShowVerticalLines(false);
        tabApplication.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tabApplication);
        if (tabApplication.getColumnModel().getColumnCount() > 0) {
            tabApplication.getColumnModel().getColumn(0).setResizable(false);
            tabApplication.getColumnModel().getColumn(0).setPreferredWidth(60);
            tabApplication.getColumnModel().getColumn(1).setResizable(false);
            tabApplication.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabApplication.getColumnModel().getColumn(2).setResizable(false);
            tabApplication.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabApplication.getColumnModel().getColumn(3).setResizable(false);
            tabApplication.getColumnModel().getColumn(4).setResizable(false);
            tabApplication.getColumnModel().getColumn(5).setResizable(false);
        }

        ApplicationPanel.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 823, 230));

        jLabel72.setBackground(new java.awt.Color(58, 83, 155));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(58, 83, 155));
        jLabel72.setText("MANAGE APPLICATION");
        ApplicationPanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 48));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("Application type:");
        ApplicationPanel.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        AComboAppType.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AComboAppType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All Request", "Security Request", "Maintenance Request" }));
        AComboAppType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AComboAppTypeActionPerformed(evt);
            }
        });
        ApplicationPanel.add(AComboAppType, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 182, -1));

        btnAppView.setBackground(new java.awt.Color(255, 255, 255));
        btnAppView.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAppView.setForeground(new java.awt.Color(58, 83, 155));
        btnAppView.setText("View");
        btnAppView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnAppView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAppView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppViewActionPerformed(evt);
            }
        });
        ApplicationPanel.add(btnAppView, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 120, 30));

        ApplicationJPanel.setBackground(new java.awt.Color(255, 255, 255));
        ApplicationJPanel.setLayout(new java.awt.CardLayout());

        ApplicationNull.setBackground(new java.awt.Color(255, 255, 255));
        ApplicationNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-list 2.png"))); // NOI18N
        ApplicationNull.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 590, 470));

        ApplicationJPanel.add(ApplicationNull, "card5");

        AppSecurity.setBackground(new java.awt.Color(255, 255, 255));
        AppSecurity.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setBackground(new java.awt.Color(58, 83, 155));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(58, 83, 155));
        jLabel40.setText("Maintenance Application Detailed Information");
        AppSecurity.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        comboAPPGuard.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        AppSecurity.add(comboAPPGuard, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 150, 40));

        btnRequestSAssign1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnRequestSAssign1.setForeground(new java.awt.Color(58, 83, 155));
        btnRequestSAssign1.setText("Assign");
        btnRequestSAssign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestSAssign1ActionPerformed(evt);
            }
        });
        AppSecurity.add(btnRequestSAssign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, 40));

        jLabel78.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(58, 83, 155));
        jLabel78.setText("Location:");
        AppSecurity.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 30));

        jLabel79.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(58, 83, 155));
        jLabel79.setText("Incident Type:");
        AppSecurity.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel80.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(58, 83, 155));
        jLabel80.setText("Urgency Level:");
        AppSecurity.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        txtSUrgency.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtSUrgency.setEnabled(false);
        txtSUrgency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSUrgencyActionPerformed(evt);
            }
        });
        AppSecurity.add(txtSUrgency, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 140, -1));

        txtRequestTypeS.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestTypeS.setEnabled(false);
        txtRequestTypeS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestTypeSActionPerformed(evt);
            }
        });
        AppSecurity.add(txtRequestTypeS, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 140, -1));

        txtRequestLocationS.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestLocationS.setEnabled(false);
        txtRequestLocationS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestLocationSActionPerformed(evt);
            }
        });
        AppSecurity.add(txtRequestLocationS, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 140, -1));

        txtSecurityDesc.setColumns(20);
        txtSecurityDesc.setRows(5);
        jScrollPane12.setViewportView(txtSecurityDesc);

        AppSecurity.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 530, 190));

        jLabel84.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(58, 83, 155));
        jLabel84.setText("Description of Incident:");
        jLabel84.setToolTipText("");
        AppSecurity.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, 30));

        jLabel81.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard 2.png"))); // NOI18N
        AppSecurity.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 590, 470));

        ApplicationJPanel.add(AppSecurity, "card7");

        AppMaintenance.setBackground(new java.awt.Color(255, 255, 255));
        AppMaintenance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setBackground(new java.awt.Color(58, 83, 155));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(58, 83, 155));
        jLabel41.setText("Maintenance Application Detailed Information");
        AppMaintenance.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        comboAPPReapairman.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        AppMaintenance.add(comboAPPReapairman, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 150, 40));

        btnRequestMAssign1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnRequestMAssign1.setForeground(new java.awt.Color(58, 83, 155));
        btnRequestMAssign1.setText("Assign");
        btnRequestMAssign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestMAssign1ActionPerformed(evt);
            }
        });
        AppMaintenance.add(btnRequestMAssign1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 40));

        jLabel42.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(58, 83, 155));
        jLabel42.setText("Apartment #:");
        AppMaintenance.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, 30));

        jLabel43.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(58, 83, 155));
        jLabel43.setText("Issue Type:");
        AppMaintenance.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));

        jLabel44.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(58, 83, 155));
        jLabel44.setText("Urgency Level:");
        AppMaintenance.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        txtMUrgency.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtMUrgency.setEnabled(false);
        txtMUrgency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMUrgencyActionPerformed(evt);
            }
        });
        AppMaintenance.add(txtMUrgency, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 140, -1));

        txtRequestIssueType.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestIssueType.setEnabled(false);
        txtRequestIssueType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestIssueTypeActionPerformed(evt);
            }
        });
        AppMaintenance.add(txtRequestIssueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 140, -1));

        txtRequestApartment.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        txtRequestApartment.setEnabled(false);
        txtRequestApartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequestApartmentActionPerformed(evt);
            }
        });
        AppMaintenance.add(txtRequestApartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 140, -1));

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(58, 83, 155));
        jLabel85.setText("Description of Issue:");
        jLabel85.setToolTipText("");
        AppMaintenance.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, 30));

        txtMDesc.setColumns(20);
        txtMDesc.setRows(5);
        jScrollPane13.setViewportView(txtMDesc);

        AppMaintenance.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 530, 130));

        jLabel71.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance 2.png"))); // NOI18N
        AppMaintenance.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 590, 470));

        ApplicationJPanel.add(AppMaintenance, "card6");

        ApplicationPanel.add(ApplicationJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 940, 510));

        ContentPanel.add(ApplicationPanel, "card4");

        ComplaintPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setBackground(new java.awt.Color(58, 83, 155));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(58, 83, 155));
        jLabel26.setText("MANAGE COMPLAINT");

        tabDoctor1.setModel(new javax.swing.table.DefaultTableModel(
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
                "Complaint Id", "Driver Name", "Note"
            }
        ));
        tabDoctor1.setFocusable(false);
        tabDoctor1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabDoctor1.setName("abc"); // NOI18N
        tabDoctor1.setRowHeight(25);
        tabDoctor1.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabDoctor1.setShowVerticalLines(false);
        tabDoctor1.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabDoctor1);

        javax.swing.GroupLayout ComplaintPanelLayout = new javax.swing.GroupLayout(ComplaintPanel);
        ComplaintPanel.setLayout(ComplaintPanelLayout);
        ComplaintPanelLayout.setHorizontalGroup(
            ComplaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComplaintPanelLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(263, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComplaintPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(363, 363, 363))
        );
        ComplaintPanelLayout.setVerticalGroup(
            ComplaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComplaintPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
        );

        ContentPanel.add(ComplaintPanel, "card5");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 128, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome,");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 71, -1, -1));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, -1));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(true);
        PaymentPanel.setVisible(false);
        RepairPanel.setVisible(false);
        SecurityPanel.setVisible(false);
        ApplicationPanel.setVisible(false);
        ComplaintPanel.setVisible(false);
        populateMessageTable();
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecurityActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        RepairPanel.setVisible(false);
        SecurityPanel.setVisible(true);
        ApplicationPanel.setVisible(false);
        ComplaintPanel.setVisible(false);

        SecurityNull.setVisible(false);
        SecurityAdd.setVisible(false);
        SecurityView.setVisible(false);
        populateSecurityTable();
    }//GEN-LAST:event_btnSecurityActionPerformed

    private void btnRepairmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairmanActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        RepairPanel.setVisible(true);
        SecurityPanel.setVisible(false);
        ApplicationPanel.setVisible(false);
        ComplaintPanel.setVisible(false);
        RepairmanNull.setVisible(true);
        RepairmanAdd.setVisible(false);
        RepairmanView.setVisible(false);
        populateRepairTable();
    }//GEN-LAST:event_btnRepairmanActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        populatePaymentTable();
        paymentNull.setVisible(true);
        paymentAdd.setVisible(false);
        PaymentView.setVisible(false);
        DashboardPanel.setVisible(false);
        PaymentPanel.setVisible(true);
        RepairPanel.setVisible(false);
        SecurityPanel.setVisible(false);
        ApplicationPanel.setVisible(false);
        ComplaintPanel.setVisible(false);
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnApplicaitonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplicaitonActionPerformed
        // TODO add your handling code here:
        populateAppRequestTable();
        DashboardPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        RepairPanel.setVisible(false);
        SecurityPanel.setVisible(false);
        ApplicationPanel.setVisible(true);
        ComplaintPanel.setVisible(false);

        ApplicationNull.setVisible(true);
        AppSecurity.setVisible(false);
        AppMaintenance.setVisible(false);
    }//GEN-LAST:event_btnApplicaitonActionPerformed

    private void btnCompalintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompalintActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(false);
        PaymentPanel.setVisible(false);
        RepairPanel.setVisible(false);
        SecurityPanel.setVisible(false);
        ApplicationPanel.setVisible(false);
        ComplaintPanel.setVisible(true);
    }//GEN-LAST:event_btnCompalintActionPerformed

    private void txtViewBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewBusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewBusActionPerformed

    private void btnSViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableSecurity.getSelectedRow();

        if (selectedRow >= 0) {
            UserAccount s = (UserAccount) TableSecurity.getValueAt(selectedRow, 0);
            //setvisable
            SecurityNull.setVisible(false);
            SecurityAdd.setVisible(false);
            SecurityView.setVisible(true);

            //txt
            vSName.setText(s.getEmployee().getName());
            vSUserName.setText(s.getUsername());
            vSPassword.setText(s.getPassword());
            vSPhoneNumber.setText(s.getPhone());
            //
            selectedUserAccount = s;
        } else {
            JOptionPane.showMessageDialog(null, "Please select a guard.");
        }
    }//GEN-LAST:event_btnSViewActionPerformed

    private void btnSAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAddActionPerformed
        // TODO add your handling code here:
        SecurityNull.setVisible(false);
        SecurityAdd.setVisible(true);
        SecurityView.setVisible(false);
    }//GEN-LAST:event_btnSAddActionPerformed

    private void btnSDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSDeleteActionPerformed
        // TODO add your handling code here:

        int selectedRow = TableSecurity.getSelectedRow();
        if (selectedRow >= 0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                UserAccount userAccount = (UserAccount) TableSecurity.getValueAt(selectedRow, 0);
                propertyEnterprise.getUserAccountDirectory().getUserAccountList().remove(userAccount);
                populateSecurityTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnSDeleteActionPerformed

    private void txtViewBus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewBus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewBus1ActionPerformed

    private void btnRViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableSecurity.getSelectedRow();

        if (selectedRow >= 0) {
            UserAccount s = (UserAccount) TableSecurity.getValueAt(selectedRow, 0);
            //setvisable
            RepairmanNull.setVisible(false);
            RepairmanAdd.setVisible(false);
            RepairmanView.setVisible(true);

            //txt
            vRName.setText(s.getEmployee().getName());
            vRUserName.setText(s.getUsername());
            vRPassword.setText(s.getPassword());
            vRPhoneNumber.setText(s.getPhone());
            //
            selectedUserAccount = s;
        } else {
            JOptionPane.showMessageDialog(null, "Please select a guard.");
        }

    }//GEN-LAST:event_btnRViewActionPerformed

    private void btnRAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAddActionPerformed
        // TODO add your handling code here:
        RepairmanNull.setVisible(false);
        RepairmanAdd.setVisible(true);
        RepairmanView.setVisible(false);
    }//GEN-LAST:event_btnRAddActionPerformed

    private void btnRDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableRepairman.getSelectedRow();
        if (selectedRow >= 0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {
                UserAccount userAccount = (UserAccount) TableRepairman.getValueAt(selectedRow, 0);
                propertyEnterprise.getUserAccountDirectory().getUserAccountList().remove(userAccount);
                populateRepairTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnRDeleteActionPerformed

    private void btnSubmitSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitSecurityActionPerformed
        // TODO add your handling code here:
        String username = aSUserName.getText();
        String password = aSPassword.getText();
        String name = aSName.getText();
        Employee employee = propertyEnterprise.getEmployeeDirectory().createEmployee(name);
        UserAccount account = propertyEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new SecurityRole());
        populateSecurityTable();

        aSName.setText("");
        aSUserName.setText("");
        aSPassword.setText("");
    }//GEN-LAST:event_btnSubmitSecurityActionPerformed

    private void RAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAddActionPerformed
        // TODO add your handling code here:
        String username = aRUserName.getText();
        String password = aRPassword.getText();
        String name = aRName.getText();
        Employee employee = propertyEnterprise.getEmployeeDirectory().createEmployee(name);
        UserAccount account = propertyEnterprise.getUserAccountDirectory().createUserAccount(username, password, employee, new RepairManRole());
        populateRepairTable();
    }//GEN-LAST:event_RAddActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnPAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAddActionPerformed
        // TODO add your handling code here:
        paymentNull.setVisible(false);
        paymentAdd.setVisible(true);
        PaymentView.setVisible(false);
        ResidentCombox.removeAllItems();
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (Network network : ecoSystem.getNetworkList()) {
                if (resident.getNetworkName().equals(network.toString())) {
                    ResidentCombox.addItem(resident.getFullname());
                }
            }
        }
    }//GEN-LAST:event_btnPAddActionPerformed

    private void btnPViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPViewActionPerformed
        // TODO add your handling code here:      
        int selectedRow = tabPayment.getSelectedRow();

        if (selectedRow >= 0) {
            Payment s = (Payment) tabPayment.getValueAt(selectedRow, 0);
            //setvisable
            paymentNull.setVisible(false);
            paymentAdd.setVisible(false);
            PaymentView.setVisible(true);

            //txt
            VPType.setText(s.getType());
            VPAmount.setText(Integer.toString(s.getAmount()));
            VPRdate.setText(s.getRequestTime());
            VPRname.setText(s.getReceiver());
            VPRphone.setText(s.getPhone());
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Payment order.");
        }
    }//GEN-LAST:event_btnPViewActionPerformed

    private void txtViewBus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewBus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewBus2ActionPerformed

    private void btnPDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPDeleteActionPerformed

    private void btnAPAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAPAddActionPerformed
        // TODO add your handling code here:

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getFullname().equals(ResidentCombox.getSelectedItem().toString())) {
                Payment p = new Payment();
                p.setSender(propertyEnterprise.getName());
                p.setType(APaymentType.getText());
                p.setAmount(Integer.parseInt(APaymentFee.getText()));
                p.setReceiver(resident.getFullname());

                p.setPhone(resident.getPhoneNum());
                p.setStatus("Pending");
                SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd  hh:mm");
                Date dNow = new Date();
                p.setRequestTime(dateformat.format(dNow));
                resident.getPaymentList().add(p);

            }
        }
        populatePaymentTable();
        JOptionPane.showMessageDialog(null, "Submit successfully");
    }//GEN-LAST:event_btnAPAddActionPerformed

    private void btnSuploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuploadActionPerformed
        // TODO add your handling code here:
        vSName.setEnabled(true);
        vSUserName.setEnabled(false);
        vSPassword.setEnabled(true);
        vSPhoneNumber.setEnabled(false);
        btnSSave.setEnabled(true);
        btnSupload.setEnabled(false);
    }//GEN-LAST:event_btnSuploadActionPerformed

    private void btnSSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSSaveActionPerformed
        // TODO add your handling code here:
        selectedUserAccount.getEmployee().setName(vSName.getText());
        selectedUserAccount.setPassword(vSPassword.getText());
        vSName.setEnabled(false);
        vSUserName.setEnabled(false);
        vSPassword.setEnabled(false);
        vSPhoneNumber.setEnabled(false);
        btnSSave.setEnabled(false);
        btnSupload.setEnabled(true);
        populateSecurityTable();
    }//GEN-LAST:event_btnSSaveActionPerformed

    private void btnRUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRUploadActionPerformed
        // TODO add your handling code here:
        vRName.setEnabled(true);
        vRUserName.setEnabled(false);
        vRPassword.setEnabled(true);
        vRPhoneNumber.setEnabled(false);
        btnRSave.setEnabled(true);
        btnRUpload.setEnabled(false);
    }//GEN-LAST:event_btnRUploadActionPerformed

    private void btnRSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRSaveActionPerformed
        // TODO add your handling code here:
        selectedUserAccount.getEmployee().setName(vRName.getText());
        selectedUserAccount.setPassword(vRPassword.getText());
        vRName.setEnabled(false);
        vRUserName.setEnabled(false);
        vRPassword.setEnabled(false);
        vRPhoneNumber.setEnabled(false);
        btnRSave.setEnabled(false);
        btnRUpload.setEnabled(true);
        populateRepairTable();
    }//GEN-LAST:event_btnRSaveActionPerformed

    private void PComboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PComboStatusActionPerformed
        // TODO add your handling code here:
        if (PComboStatus.getSelectedItem().equals("Compeleted")) {
            populateCompeletedPaymentTable();
        } else if (PComboStatus.getSelectedItem().equals("Pending")) {
            populatePendingPaymentTable();
        } else {
            populatePaymentTable();
        }
    }//GEN-LAST:event_PComboStatusActionPerformed

    private void txtViewBus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewBus3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtViewBus3ActionPerformed

    private void btnRequestSAssign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestSAssign1ActionPerformed
        // TODO add your handling code here:
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (SRRequest m : resident.getSRRequestList()) {
                if (m.getPropertyName().equals(propertyEnterprise.getName())) {
                    //if (m.toString().equals(selectedRequest.toString()) && m.getSender().equals(selectedRequest.getSender())) {
                    if (m == selectedRequest) {
                        m.setReceiver(comboAPPGuard.getSelectedItem().toString());
                        m.setStatus("Processing");

                        Message message1 = new Message();
                        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd  hh:mm");
                        Date dNow = new Date();
                        message1.setReceiver(comboAPPGuard.getSelectedItem().toString());
                        message1.setContent("You received a new security request");
                        message1.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message1);

                        Message message2 = new Message();
                        message2.setReceiver(m.getSender());
                        message2.setContent("Your security order (id" + m.toString() + ") is processing.");
                        message2.setRequestDate(dateformat.format(dNow));
                        ecoSystem.getMessageList().getMessageList().add(message2);

                        AComboAppType.setSelectedIndex(0);
                        populateAppRequestTable();
                        JOptionPane.showMessageDialog(null, "Assign successfully!!");
                        ApplicationNull.setVisible(true);
                        AppSecurity.setVisible(false);
                        AppMaintenance.setVisible(false);

                    }
                }
            }
        }
    }//GEN-LAST:event_btnRequestSAssign1ActionPerformed

    private void txtSUrgencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSUrgencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSUrgencyActionPerformed

    private void txtRequestTypeSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestTypeSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestTypeSActionPerformed

    private void txtRequestLocationSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestLocationSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestLocationSActionPerformed

    private void txtMUrgencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMUrgencyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMUrgencyActionPerformed

    private void txtRequestIssueTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestIssueTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestIssueTypeActionPerformed

    private void txtRequestApartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequestApartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequestApartmentActionPerformed

    private void btnAppViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabApplication.getSelectedRow();
        comboAPPGuard.removeAllItems();
        if (selectedRow >= 0) {
            SRRequest s = (SRRequest) tabApplication.getValueAt(selectedRow, 0);
            selectedRequest = s;
            if (s.getRequestType().equalsIgnoreCase("Security Request")) {
                if (s.getStatus().equals("Awaiting processing")) {
                    ApplicationNull.setVisible(false);
                    AppSecurity.setVisible(true);
                    AppMaintenance.setVisible(false);

                    txtRequestLocationS.setText(s.getLocation());
                    txtRequestTypeS.setText(s.getType());
                    txtSUrgency.setText(s.getLevel());
                    txtSecurityDesc.setText(s.getDescription());

                    for (UserAccount userAccount : propertyEnterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getRole().toString().equals("Business.Role.SecurityRole")) {
                            comboAPPGuard.addItem(userAccount.getEmployee().getName());
                        }
                    }
                } else {
                    btnRequestSAssign1.setVisible(false);
                    comboAPPGuard.setVisible(false);
                    
                    ApplicationNull.setVisible(false);
                    AppSecurity.setVisible(true);
                    AppMaintenance.setVisible(false);

                    txtRequestLocationS.setText(s.getLocation());
                    txtRequestTypeS.setText(s.getType());
                    txtSUrgency.setText(s.getLevel());
                    txtSecurityDesc.setText(s.getDescription());
                }

            } else {
                if (s.getStatus().equals("Awaiting processing")) {
                    ApplicationNull.setVisible(false);
                    AppSecurity.setVisible(false);
                    AppMaintenance.setVisible(true);

                    txtRequestApartment.setText(s.getApartmentNum());
                    txtRequestIssueType.setText(s.getType());
                    txtMUrgency.setText(s.getLevel());
                    txtMDesc.setText(s.getDescription());

                    for (UserAccount userAccount : propertyEnterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (userAccount.getRole().toString().equals("Business.Role.RepairManRole")) {
                            comboAPPReapairman.addItem(userAccount.getEmployee().getName());
                        }
                    }
                } else {
                    ApplicationNull.setVisible(false);
                    AppSecurity.setVisible(false);
                    AppMaintenance.setVisible(true);

                    txtRequestApartment.setText(s.getApartmentNum());
                    txtRequestIssueType.setText(s.getType());
                    txtMUrgency.setText(s.getLevel());
                    txtMDesc.setText(s.getDescription());
                    
                    btnRequestMAssign1.setVisible(false);
 
                    comboAPPReapairman.setVisible(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Payment order.");
        }
    }//GEN-LAST:event_btnAppViewActionPerformed

    private void AComboAppTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AComboAppTypeActionPerformed
        // TODO add your handling code here:
        if (AComboAppType.getSelectedItem().equals("Security Request")) {
            populateSAppRequestTable();
        } else if (AComboAppType.getSelectedItem().equals("Maintenance Request")) {
            populateRAppRequestTable();
        } else {
            populateAppRequestTable();
        }
    }//GEN-LAST:event_AComboAppTypeActionPerformed

    private void btnRequestMAssign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestMAssign1ActionPerformed
        // TODO add your handling code here:
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            for (SRRequest m : resident.getSRRequestList()) {
                if (m.getPropertyName().equals(propertyEnterprise.getName())) {
                    //if (m.toString().equals(selectedRequest.toString())&& m.getSender().equals(selectedRequest.getSender())) {
                    if (m == selectedRequest) {
                        if (m == selectedRequest) {

                            btnRequestMAssign1.setEnabled(false);
                            comboAPPReapairman.setEnabled(false);

                            m.setReceiver(comboAPPReapairman.getSelectedItem().toString());
                            m.setStatus("Processing");

                            Message message1 = new Message();
                            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd  hh:mm");
                            Date dNow = new Date();
                            message1.setReceiver(comboAPPReapairman.getSelectedItem().toString());
                            message1.setContent("You received a new maintenance request");
                            message1.setRequestDate(dateformat.format(dNow));
                            ecoSystem.getMessageList().getMessageList().add(message1);

                            Message message2 = new Message();
                            message2.setReceiver(m.getSender());
                            message2.setContent("Your maintenance order (id" + m.toString() + ") is processing.");
                            message2.setRequestDate(dateformat.format(dNow));
                            ecoSystem.getMessageList().getMessageList().add(message2);

                            AComboAppType.setSelectedIndex(0);
                            comboAPPReapairman.setSelectedIndex(0);
                            populateAppRequestTable();
                            JOptionPane.showMessageDialog(null, "Assign successfully!!");
                            ApplicationNull.setVisible(true);
                            AppSecurity.setVisible(false);
                            AppMaintenance.setVisible(false);

                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRequestMAssign1ActionPerformed

    private void btnMarkreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkreadActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableNotification.getSelectedRow();
        if (selectedRow >= 0) {
            Message s = (Message) TableNotification.getValueAt(selectedRow, 0);
            for (Message message : ecoSystem.getMessageList().getMessageList()) {
                if (message == s) {
                    ecoSystem.getMessageList().getMessageList().remove(message);
                    populateMessageTable();
                }
                jLabel30.setText("You have " + TableNotification.getRowCount() + " new Notifications:");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Message.");
        }
    }//GEN-LAST:event_btnMarkreadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AComboAppType;
    private javax.swing.JTextField APaymentFee;
    private javax.swing.JTextField APaymentType;
    private javax.swing.JPanel AppMaintenance;
    private javax.swing.JPanel AppSecurity;
    private javax.swing.JPanel ApplicationJPanel;
    private javax.swing.JPanel ApplicationNull;
    private javax.swing.JPanel ApplicationPanel;
    private javax.swing.JPanel ComplaintPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JComboBox PComboStatus;
    private javax.swing.JPanel PaymentPanel;
    private javax.swing.JPanel PaymentView;
    private javax.swing.JButton RAdd;
    private javax.swing.JPanel RepairPanel;
    private javax.swing.JPanel Repairman;
    private javax.swing.JPanel RepairmanAdd;
    private javax.swing.JPanel RepairmanNull;
    private javax.swing.JPanel RepairmanView;
    private javax.swing.JComboBox ResidentCombox;
    private javax.swing.JPanel SecurityAdd;
    private javax.swing.JPanel SecurityJpanel;
    private javax.swing.JPanel SecurityNull;
    private javax.swing.JPanel SecurityPanel;
    private javax.swing.JPanel SecurityView;
    private javax.swing.JTable TableNotification;
    private javax.swing.JTable TableRepairman;
    private javax.swing.JTable TableSecurity;
    private javax.swing.JTextField VPAmount;
    private javax.swing.JTextField VPRdate;
    private javax.swing.JTextField VPRname;
    private javax.swing.JTextField VPRphone;
    private javax.swing.JTextField VPType;
    private javax.swing.JTextField aRName;
    private javax.swing.JTextField aRPassword;
    private javax.swing.JTextField aRUserName;
    private javax.swing.JTextField aSName;
    private javax.swing.JTextField aSPassword;
    private javax.swing.JTextField aSUserName;
    private javax.swing.JButton btnAPAdd;
    private javax.swing.JButton btnAppView;
    private javax.swing.JButton btnApplicaiton;
    private javax.swing.JButton btnCompalint;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnPAdd;
    private javax.swing.JButton btnPDelete;
    private javax.swing.JButton btnPView;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnRAdd;
    private javax.swing.JButton btnRDelete;
    private javax.swing.JButton btnRSave;
    private javax.swing.JButton btnRUpload;
    private javax.swing.JButton btnRView;
    private javax.swing.JButton btnRepairman;
    private javax.swing.JButton btnRequestMAssign1;
    private javax.swing.JButton btnRequestSAssign1;
    private javax.swing.JButton btnSAdd;
    private javax.swing.JButton btnSDelete;
    private javax.swing.JButton btnSSave;
    private javax.swing.JButton btnSView;
    private javax.swing.JButton btnSecurity;
    private javax.swing.JButton btnSubmitSecurity;
    private javax.swing.JButton btnSupload;
    private javax.swing.JComboBox comboAPPGuard;
    private javax.swing.JComboBox comboAPPReapairman;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel labAdminName;
    private javax.swing.JLabel labTime;
    private javax.swing.JPanel payment;
    private javax.swing.JPanel paymentAdd;
    private javax.swing.JPanel paymentNull;
    private javax.swing.JTable tabApplication;
    private javax.swing.JTable tabDoctor1;
    private javax.swing.JTable tabPayment;
    private javax.swing.JTextArea txtMDesc;
    private javax.swing.JTextField txtMUrgency;
    private javax.swing.JTextField txtRequestApartment;
    private javax.swing.JTextField txtRequestIssueType;
    private javax.swing.JTextField txtRequestLocationS;
    private javax.swing.JTextField txtRequestTypeS;
    private javax.swing.JTextField txtSUrgency;
    private javax.swing.JTextArea txtSecurityDesc;
    private javax.swing.JTextField txtViewBus;
    private javax.swing.JTextField txtViewBus1;
    private javax.swing.JTextField txtViewBus2;
    private javax.swing.JTextField txtViewBus3;
    private javax.swing.JTextField vRName;
    private javax.swing.JTextField vRPassword;
    private javax.swing.JTextField vRPhoneNumber;
    private javax.swing.JTextField vRUserName;
    private javax.swing.JTextField vSName;
    private javax.swing.JTextField vSPassword;
    private javax.swing.JTextField vSPhoneNumber;
    private javax.swing.JTextField vSUserName;
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
