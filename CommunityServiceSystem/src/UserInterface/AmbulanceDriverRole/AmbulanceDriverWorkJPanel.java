package UserInterface.AmbulanceDriverRole;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Business.AmbulanceDriver.AmbulanceDriver;
import Business.AmbulanceRequest.AmbulanceRequest;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.Organization.EmergencyOrganization;
import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
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
public class AmbulanceDriverWorkJPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;

    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    HospitalEnterprise hospitalEnterprise;
    EmergencyOrganization emergencyOrganization;
    Network network;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

//    private Hospital hospital;
//    private Doctor student;
//    private Ambulance schoolBus;
//    private Patient teacher;
    private String imagePath;

    public AmbulanceDriverWorkJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = account;
        this.emergencyOrganization = (EmergencyOrganization) organization;
        this.hospitalEnterprise = (HospitalEnterprise) enterprise;
        this.network = network;
        labWelcome.setText("Hi, " + userAccount.getEmployee().getName() + "!");

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

    public void populateRequest() {
        DefaultTableModel model = (DefaultTableModel) tabRequest.getModel();
        model.setRowCount(0);
        for (AmbulanceRequest ar : ecoSystem.getAmbulanceRequestDirectory().getAmbulanceRequestList()) {
            System.out.println("UserInterface.AmbulanceDriverRole.AmbulanceDriverWorkJPanel.populateRequest()");
            if (userAccount.getUsername().equals(ar.getReceiver())) {
                Object[] row = new Object[9];
                row[0] = ar;
                row[1] = ar.getUrgencyLevel();
                row[2] = ar.getInjuredNum();
                row[3] = ar.getLocation();
                row[4] = ar.getPhoneNum();
                row[5] = ar.getRequestDate();
                row[6] = ar.getStatus();
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
        labWelcome = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnRquestList = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableNotification1 = new javax.swing.JTable();
        btnMarkread1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        RequestList = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabRequest = new javax.swing.JTable();
        MRBtnAccept = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        ViewLocation = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        map_panel = new javax.swing.JPanel();
        txtSLocation1 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        btnSLocationConfirm1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 291, 45));

        labWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        labWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labWelcome.setText("Hi,*** ");
        add(labWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

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
        add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 240, 40));

        btnRquestList.setBackground(new java.awt.Color(58, 83, 155));
        btnRquestList.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnRquestList.setForeground(new java.awt.Color(255, 255, 255));
        btnRquestList.setText("Request List");
        btnRquestList.setBorder(null);
        btnRquestList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRquestList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRquestListActionPerformed(evt);
            }
        });
        add(btnRquestList, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 240, 40));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

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

        Dashboard.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 630, 280));

        btnMarkread1.setBackground(new java.awt.Color(255, 255, 255));
        btnMarkread1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnMarkread1.setForeground(new java.awt.Color(58, 83, 155));
        btnMarkread1.setText("Markread");
        btnMarkread1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMarkread1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarkread1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkread1ActionPerformed(evt);
            }
        });
        Dashboard.add(btnMarkread1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 620, 170, 40));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("You have * new Notifications:");
        Dashboard.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 330, 30));

        jLabel36.setBackground(new java.awt.Color(58, 83, 155));
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(58, 83, 155));
        jLabel36.setText("DASHBOARD");
        Dashboard.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, -1));

        ContentPanel.add(Dashboard, "card5");

        RequestList.setBackground(new java.awt.Color(255, 255, 255));
        RequestList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(58, 83, 155));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(58, 83, 155));
        jLabel52.setText("Request List");
        RequestList.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        tabRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Incident Type", "Urgency level", "Number of Injured", "Location", "Phone #", "Request time", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRequest.setFocusable(false);
        tabRequest.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabRequest.setRowHeight(30);
        tabRequest.setSelectionBackground(new java.awt.Color(68, 68, 147));
        tabRequest.setShowVerticalLines(false);
        tabRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabRequest);
        if (tabRequest.getColumnModel().getColumnCount() > 0) {
            tabRequest.getColumnModel().getColumn(0).setResizable(false);
            tabRequest.getColumnModel().getColumn(1).setResizable(false);
            tabRequest.getColumnModel().getColumn(5).setResizable(false);
            tabRequest.getColumnModel().getColumn(5).setPreferredWidth(150);
            tabRequest.getColumnModel().getColumn(6).setResizable(false);
        }

        RequestList.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 1020, 370));

        MRBtnAccept.setBackground(new java.awt.Color(255, 255, 255));
        MRBtnAccept.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        MRBtnAccept.setForeground(new java.awt.Color(58, 83, 155));
        MRBtnAccept.setText("Accept");
        MRBtnAccept.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        MRBtnAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MRBtnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRBtnAcceptActionPerformed(evt);
            }
        });
        RequestList.add(MRBtnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 520, 132, 36));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(58, 83, 155));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        jButton3.setText("View Location");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        RequestList.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 180, 30));

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-siren.png"))); // NOI18N
        RequestList.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, 590, 470));

        ContentPanel.add(RequestList, "card4");

        ViewLocation.setBackground(new java.awt.Color(255, 255, 255));
        ViewLocation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setBackground(new java.awt.Color(58, 83, 155));
        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(58, 83, 155));
        jLabel125.setText("View the Rescue location");
        ViewLocation.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, 30));

        map_panel.setLayout(new java.awt.BorderLayout());
        ViewLocation.add(map_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 950, 500));

        txtSLocation1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtSLocation1.setForeground(new java.awt.Color(2, 2, 69));
        txtSLocation1.setToolTipText("");
        txtSLocation1.setEnabled(false);
        ViewLocation.add(txtSLocation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 410, 30));

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(58, 83, 155));
        jLabel127.setText("Location Latlng:");
        jLabel127.setToolTipText("");
        ViewLocation.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, -1, -1));

        btnSLocationConfirm1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSLocationConfirm1.setForeground(new java.awt.Color(58, 83, 155));
        btnSLocationConfirm1.setText("Back");
        btnSLocationConfirm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSLocationConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLocationConfirm1ActionPerformed(evt);
            }
        });
        ViewLocation.add(btnSLocationConfirm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 770, 200, 40));

        ContentPanel.add(ViewLocation, "card6");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 128, 1450, 1080));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-list.png"))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 50, 60));

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
        add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 30, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(true);
        RequestList.setVisible(false);

    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnRquestListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRquestListActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(true);
        populateRequest();
    }//GEN-LAST:event_btnRquestListActionPerformed

    public void refreshTeacherTable() {
    }
    private void btnMarkread1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkread1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnMarkread1ActionPerformed

    private void MRBtnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRBtnAcceptActionPerformed
        // TODO add your handling code here:
        int selectedClass = tabRequest.getSelectedRow();

        if (selectedClass < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            AmbulanceRequest ar = (AmbulanceRequest) tabRequest.getValueAt(selectedClass, 0);
            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
            Date dNow = new Date();
            ar.setResolveDate(dateformat.format(dNow));
            ar.setStatus("On the way");
            JOptionPane.showMessageDialog(null, "Request Accpeted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateRequest();
            for (UserAccount u : hospitalEnterprise.getUserAccountDirectory().getUserAccountList()) {
                if (u.getRole().toString().equals("Business.Role.HospitalManagerRole")) {
                    for (AmbulanceDriver ad : u.getAmbulanceDriverDirectoy().getAmbulanceDriverList()) {
                        ad.setAvailability("Not available");
                    }
                }
            }
        }

    }//GEN-LAST:event_MRBtnAcceptActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedClass = tabRequest.getSelectedRow();

        if (selectedClass < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
           Dashboard.setVisible(false);
           RequestList.setVisible(false);
            ViewLocation.setVisible(true);
            AmbulanceRequest ar = (AmbulanceRequest) tabRequest.getValueAt(selectedClass, 0);
            txtSLocation1.setText(ar.getLocation());
            BrowserUtil.setVersion(Version.V6_22);
            Browser browser = new Browser();
            BrowserView view = new BrowserView(browser);

            map_panel.add(view, BorderLayout.CENTER);
            browser.loadURL("file:///D:/Courses/2020Fall/INFO5100/Aassignements/FinalProject/CommunityServiceSystem_2.2/test.html");

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSLocationConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLocationConfirm1ActionPerformed
        // TODO add your handling code here:
        Dashboard.setVisible(false);
        RequestList.setVisible(true);

        ViewLocation.setVisible(false);
    }//GEN-LAST:event_btnSLocationConfirm1ActionPerformed

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
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JButton MRBtnAccept;
    private javax.swing.JPanel RequestList;
    private javax.swing.JTable TableNotification1;
    private javax.swing.JPanel ViewLocation;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMarkread1;
    private javax.swing.JButton btnRquestList;
    private javax.swing.JButton btnSLocationConfirm1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labTime;
    private javax.swing.JLabel labWelcome;
    private javax.swing.JPanel map_panel;
    private javax.swing.JTable tabRequest;
    private javax.swing.JTextField txtSLocation1;
    // End of variables declaration//GEN-END:variables
}
