/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdminRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.HospitalManagementOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;

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
    
    public HospitalAdminWorkPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        this.hospitalEnterprise = (HospitalEnterprise)enterprise;
        this.hospitalManagementOrganization = (HospitalManagementOrganization) organization;
        
        Thread t = new Thread(this);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        labTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnDriver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnComplaint = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        DriverPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabDoctor = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        DTxtUserName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        DTxtPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        DTxtName = new javax.swing.JTextField();
        DBtnSubmit = new javax.swing.JButton();
        RequestPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabPatient = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        DComboDriver = new javax.swing.JComboBox();
        ABtnSubmit = new javax.swing.JButton();
        ComplaintPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabDoctor1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        labAdminName = new javax.swing.JLabel();
        btnRequest = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance.png"))); // NOI18N

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

        btnDriver.setBackground(new java.awt.Color(58, 83, 155));
        btnDriver.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnDriver.setForeground(new java.awt.Color(255, 255, 255));
        btnDriver.setText("Driver Management");
        btnDriver.setBorder(null);
        btnDriver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDriverActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-strike.png"))); // NOI18N

        btnComplaint.setBackground(new java.awt.Color(58, 83, 155));
        btnComplaint.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnComplaint.setForeground(new java.awt.Color(255, 255, 255));
        btnComplaint.setText("Complaint Management");
        btnComplaint.setBorder(null);
        btnComplaint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComplaintActionPerformed(evt);
            }
        });

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

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
                .addContainerGap(432, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(416, 416, 416))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(877, Short.MAX_VALUE))
        );

        ContentPanel.add(DashboardPanel, "card2");

        DriverPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(58, 83, 155));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(58, 83, 155));
        jLabel14.setText("MANAGE DRIVER");

        tabDoctor.setModel(new javax.swing.table.DefaultTableModel(
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
                "Driver Id", "User Name", "Driver Name"
            }
        ));
        tabDoctor.setFocusable(false);
        tabDoctor.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabDoctor.setName("abc"); // NOI18N
        tabDoctor.setRowHeight(25);
        tabDoctor.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabDoctor.setShowVerticalLines(false);
        tabDoctor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabDoctor);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(58, 83, 155));
        jLabel15.setText("User Name:");

        DTxtUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtUserName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(58, 83, 155));
        jLabel16.setText("Password:");

        DTxtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("Name:");

        DTxtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DTxtName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        DBtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        DBtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        DBtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        DBtnSubmit.setText("Submit");
        DBtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        DBtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout DriverPanelLayout = new javax.swing.GroupLayout(DriverPanel);
        DriverPanel.setLayout(DriverPanelLayout);
        DriverPanelLayout.setHorizontalGroup(
            DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DriverPanelLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DriverPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DriverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(389, 389, 389))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DriverPanelLayout.createSequentialGroup()
                        .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DriverPanelLayout.createSequentialGroup()
                                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(92, 92, 92)
                                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DTxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DriverPanelLayout.createSequentialGroup()
                                .addComponent(DBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)))
                        .addGap(304, 304, 304))))
        );
        DriverPanelLayout.setVerticalGroup(
            DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DriverPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DTxtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DTxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(DriverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(DBtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        ContentPanel.add(DriverPanel, "card3");

        RequestPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(58, 83, 155));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 83, 155));
        jLabel18.setText("MANAGE REQUEST");

        tabPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Name", "Gender", "Age", "Address", "note", "Request Time", "Status"
            }
        ));
        tabPatient.setFocusable(false);
        tabPatient.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabPatient.setName("abc"); // NOI18N
        tabPatient.setRowHeight(25);
        tabPatient.setSelectionBackground(new java.awt.Color(216, 232, 249));
        tabPatient.setShowVerticalLines(false);
        tabPatient.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tabPatient);
        if (tabPatient.getColumnModel().getColumnCount() > 0) {
            tabPatient.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabPatient.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabPatient.getColumnModel().getColumn(3).setPreferredWidth(40);
            tabPatient.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 83, 155));
        jLabel19.setText("Assign to Driver:");

        DComboDriver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DComboDriver.setBorder(null);

        ABtnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        ABtnSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ABtnSubmit.setForeground(new java.awt.Color(58, 83, 155));
        ABtnSubmit.setText("Refuse");
        ABtnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        ABtnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout RequestPanelLayout = new javax.swing.GroupLayout(RequestPanel);
        RequestPanel.setLayout(RequestPanelLayout);
        RequestPanelLayout.setHorizontalGroup(
            RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequestPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(389, 389, 389))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequestPanelLayout.createSequentialGroup()
                        .addGroup(RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(RequestPanelLayout.createSequentialGroup()
                                .addComponent(ABtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel19)
                                .addGap(92, 92, 92)
                                .addComponent(DComboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))))
        );
        RequestPanelLayout.setVerticalGroup(
            RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(RequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DComboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ABtnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(540, Short.MAX_VALUE))
        );

        ContentPanel.add(RequestPanel, "card4");

        ComplaintPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(58, 83, 155));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(58, 83, 155));
        jLabel20.setText("MANAGE COMPLAINT");

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
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComplaintPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(363, 363, 363))
        );
        ComplaintPanelLayout.setVerticalGroup(
            ComplaintPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComplaintPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(624, Short.MAX_VALUE))
        );

        ContentPanel.add(ComplaintPanel, "card5");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome,");

        labAdminName.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labAdminName.setForeground(new java.awt.Color(255, 255, 255));
        labAdminName.setText("xxx");

        btnRequest.setBackground(new java.awt.Color(58, 83, 155));
        btnRequest.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRequest.setText("Request Management");
        btnRequest.setBorder(null);
        btnRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labAdminName))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(btnRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnComplaint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labTime, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labAdminName))
                .addGap(38, 38, 38)
                .addComponent(ContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(true);
        DriverPanel.setVisible(false);
        RequestPanel.setVisible(false);
        ComplaintPanel.setVisible(false);
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDriverActionPerformed
        // TODO add your handling code here:        
        DriverPanel.setVisible(true);
        DashboardPanel.setVisible(false);
        RequestPanel.setVisible(false);
        ComplaintPanel.setVisible(false);
    }//GEN-LAST:event_btnDriverActionPerformed

    private void btnComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComplaintActionPerformed
        // TODO add your handling code here:
        ComplaintPanel.setVisible(true);
        DriverPanel.setVisible(false);
        DashboardPanel.setVisible(false);
        RequestPanel.setVisible(false);
    }//GEN-LAST:event_btnComplaintActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        RequestPanel.setVisible(true);
        ComplaintPanel.setVisible(false);
        DriverPanel.setVisible(false);
        DashboardPanel.setVisible(false);
    }//GEN-LAST:event_btnRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ABtnSubmit;
    private javax.swing.JPanel ComplaintPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JButton DBtnSubmit;
    private javax.swing.JComboBox DComboDriver;
    private javax.swing.JTextField DTxtName;
    private javax.swing.JTextField DTxtPassword;
    private javax.swing.JTextField DTxtUserName;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel DriverPanel;
    private javax.swing.JPanel RequestPanel;
    private javax.swing.JButton btnComplaint;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnDriver;
    private javax.swing.JButton btnRequest;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labAdminName;
    private javax.swing.JLabel labTime;
    private javax.swing.JTable tabDoctor;
    private javax.swing.JTable tabDoctor1;
    private javax.swing.JTable tabPatient;
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