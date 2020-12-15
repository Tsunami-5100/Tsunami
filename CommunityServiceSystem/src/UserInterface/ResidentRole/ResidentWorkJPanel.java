/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ResidentRole;


import Business.AmbulanceRequest.AmbulanceRequest;
import Business.KBApplication.KBApplication;
import Business.KindergartenBus.KindergartenBus;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.ResidentOrganization;
import Business.Resident.Resident;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.KindergartenEnterprise;
import Business.Enterprise.MarketEnterprise;
import Business.KApplication.KApplication;
import Business.KClass.KClass;
import Business.Market.Merchandise;
import Business.Market.MerchandiseOrder;
import Business.Message.Message;
import Business.Property.Payment;
import Business.Property.SRRequest;
import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

/**
 *
 * @author Unicorn
 */
public class ResidentWorkJPanel extends javax.swing.JPanel implements Runnable{

    /**
     * Creates new form SysadminWorkArea
     */
    int hour, minute, second;
    
    JPanel userProcessContainer;
    EcoSystem ecoSystem;
    UserAccount userAccount;
    ResidentOrganization residentOrganization;
    Network network;
    DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private MerchandiseOrder merchandiseOrder;
    
//    private Hospital hospital;
//    private Doctor student;
//    private Ambulance schoolBus;
//    private Patient teacher;
    public ResidentWorkJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Network network, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        ecoSystem = dB4OUtil.retrieveSystem();
        this.userAccount = account;
        this.residentOrganization = (ResidentOrganization) organization;
        this.network = network;
        txtWelcome.setText("Welcome, " +userAccount.getUsername() + "!");
        
        DashboardPanel.setVisible(true);
        KindergardenPanel.setVisible(false);
        HospitalPanel.setVisible(false);
        PropertyPanel.setVisible(false);
        MarketPanel.setVisible(false);
        ManageInformationPanel.setVisible(false);
        Thread t = new Thread(this);
        t.start();
        /*TableUI(TableNotification);
        TableUI(TableStudent);
        TableUI(tableWaitList);
        TableUI(TableDriver);
        TableUI(TablePatient);
        TableUI(TableComplaint);
       
        
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
    
    public void populateClassTable() {
        DefaultTableModel model = (DefaultTableModel) AKtabKClass.getModel();

        model.setRowCount(0);
        for (Network network: ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getName() == AKcomboKG.getSelectedItem()) {
                    KindergartenEnterprise kindergarten = (KindergartenEnterprise) enterprise;
                    for (KClass kclass : kindergarten.getAllClassList()) {
                        Object[] row = new Object[8];
                        row[0] = kclass;
                        row[1] = kclass.getClassType();
                        row[2] = kclass.getTeacherName();
                        row[3] = kclass.getCapacity();
                        row[4] = kclass.getRemainPlaces();
                        row[5] = kclass.getDeadline();
                        row[6] = kclass.getStartDate();
                        row[7] = kclass.getEndDate();

                        model.addRow(row);
                    }
                }
                    
            }
        }
    }
    
    public void populateKApplicaitonTable() {
        DefaultTableModel model = (DefaultTableModel) AKtabApplication.getModel();
        model.setRowCount(0);

            for (KApplication ka : ecoSystem.getkAppicationDirectory().getkApplicationList()) {
                if (userAccount.getUsername().equals(ka.getSender())) {
                Object[] row = new Object[8];
                row[0] = ka;
                row[1] = ka.getClassName();
                row[2] = ka.getSender();
                row[3] = ka.getEmail();
                row[4] = ka.getKidName();
                row[5] = ka.getKidAge();               
                row[6] = ka.getStatus();
                row[7] = ka.getResolveDate();
                model.addRow(row);
                }
            }
    }
    
    public void populateRequestHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) HTabRequestHistory.getModel();
        model.setRowCount(0);
        if (userAccount.getAmbulanceRequestList() != null){
            for (AmbulanceRequest ar : userAccount.getAmbulanceRequestList()) {
//                System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.populateRequestHistoryTable() 162. " + userAccount.getAmbulanceRequestList());
                Object[] row = new Object[6];
                row[0] = ar;
                row[1] = ar.getHospital();
                row[2] = ar.getRequestId();
                row[3] = ar.getStatus();
                row[4] = ar.getResolveDate();
                row[5] = ar.getMessage();
                model.addRow(row);
            }
        }
    }
    
    public void populateYouClassList() {
        DefaultTableModel model = (DefaultTableModel) AKBtabYourClass.getModel();
        model.setRowCount(0);

            for (KApplication ka : ecoSystem.getkAppicationDirectory().getkApplicationList()) {
                if (userAccount.getUsername().equals(ka.getSender()) && ka.getStatus().equals("Accepted")) {
                Object[] row = new Object[6];
                row[0] = ka;
                row[1] = ka.getClassName();
                row[2] = ka.getSender();
                row[3] = ka.getKidName();
                row[4] = ka.getKidAge();               
                row[5] = ka.getStatus();
                model.addRow(row);
                }
            }
    }
    
    public void populateKBApplication() {
        DefaultTableModel model = (DefaultTableModel) AKBtabApplication.getModel();
        model.setRowCount(0);

            for (KBApplication kba : userAccount.getkBApplicationDirectory().getkBApplicationList()) {
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
    
    public void merchandiseTable() {
        DefaultTableModel model = (DefaultTableModel) MListTable.getModel();

        model.setRowCount(0);
        for (Network network : ecoSystem.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise.getName() == marketCombo.getSelectedItem()) {
                    MarketEnterprise market = (MarketEnterprise) enterprise;
                    for (Merchandise merchandise : market.getMerchandiseList()) {
                        Object[] row = new Object[3];
                        row[0] = merchandise;
                        row[1] = merchandise.getPrice();
                        row[2] = merchandise.getQuantity();
                        model.addRow(row);
                    }
                }

            }
        }
    }

    public void MOrderListTable() {
        DefaultTableModel model = (DefaultTableModel) OListTable.getModel();

        model.setRowCount(0);
        for (Merchandise merchandise : merchandiseOrder.getMerchandiseList()) {
            Object[] row = new Object[3];
            row[0] = merchandise;
            row[1] = merchandise.getPrice();
            row[2] = merchandise.getQuantity();
            model.addRow(row);
        }

    }

    public void SRequestHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) TableSecurityHistory.getModel();
        model.setRowCount(0);

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (SRRequest Request : resident.getSRRequestList()) {
                    if (Request.getRequestType().equals("Security Request")) {
                        Object[] row = new Object[6];
                        row[0] = Request;
                        row[1] = Request.getType();
                        row[2] = Request.getStatus();
                        row[3] = Request.getRequestTime();
                        row[4] = Request.getResolveTime();
                        row[5] = Request.getPropertyName();
                        model.addRow(row);
                    }
                }
            }

        }
    }

    public void RRequestHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) TableMRhistory.getModel();
        model.setRowCount(0);

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (SRRequest Request : resident.getSRRequestList()) {
                    if (Request.getRequestType().equals("Maintenance Request")) {
                        Object[] row = new Object[6];
                        row[0] = Request;
                        row[1] = Request.getType();
                        row[2] = Request.getStatus();
                        row[3] = Request.getRequestTime();
                        row[4] = Request.getResolveTime();
                        row[5] = Request.getPropertyName();
                        model.addRow(row);
                    }
                }
            }

        }
    }

    public void DeliveryMerchandiseTable() {
        DefaultTableModel model = (DefaultTableModel) TableDO.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (MerchandiseOrder merchandiseOrder : resident.getMerchandiseOrderList()) {
                    if (merchandiseOrder.getStatus().equalsIgnoreCase("Payment completed")) {
                        Object[] row = new Object[5];
                        row[0] = merchandiseOrder;
                        row[1] = merchandiseOrder.getReceiver();
                        row[2] = merchandiseOrder.getStatus();
                        row[3] = merchandiseOrder.getRequestTime();
                        row[4] = merchandiseOrder.getResolveTime();
                        model.addRow(row);
                    }
                }
            }
        }
    }

    public void AllMerchandiseOrderTable() {
        DefaultTableModel model = (DefaultTableModel) TableSpOrderList.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (MerchandiseOrder merchandiseOrder : resident.getMerchandiseOrderList()) {
                    Object[] row = new Object[4];
                    row[0] = merchandiseOrder;
                    row[1] = merchandiseOrder.getMarketName();
                    row[2] = merchandiseOrder.getRequestTime();
                    row[3] = merchandiseOrder.getStatus();
                    model.addRow(row);
                }
            }
        }

    }

    public void HistoryDetailOrderTable() {
        DefaultTableModel model = (DefaultTableModel) OrderInformationTable.getModel();
        model.setRowCount(0);

        for (Merchandise merchandise : merchandiseOrder.getMerchandiseList()) {
            Object[] row = new Object[3];
            row[0] = merchandise;
            row[1] = merchandise.getPrice();
            row[2] = merchandise.getQuantity();
            model.addRow(row);

        }

    }

    public void PaymentTable() {
        DefaultTableModel model = (DefaultTableModel) TablePayment.getModel();
        model.setRowCount(0);
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Payment payment : resident.getPaymentList()) {
                    Object[] row = new Object[5];
                    row[0] = payment;
                    row[1] = payment.getType();
                    row[2] = payment.getAmount();
                    row[3] = payment.getStatus();
                    row[4] = payment.getRequestTime();
                    model.addRow(row);
                }
            }
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
        txtWelcome = new javax.swing.JLabel();
        btnProperty = new javax.swing.JButton();
        btnSupermarket = new javax.swing.JButton();
        btnKindergarden = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        KindergardenPanel = new javax.swing.JPanel();
        KindergardenJPanel = new javax.swing.JPanel();
        KdMenu = new javax.swing.JPanel();
        btnKgApply = new javax.swing.JButton();
        btnSBApply = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        ShoolBusApply = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        AKBtabApplication = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        AKBBtnApply = new javax.swing.JButton();
        AKBTxtLiense = new javax.swing.JTextField();
        AKBTxtDriverName = new javax.swing.JTextField();
        AKBTxtCapacity = new javax.swing.JTextField();
        AKBTxtReaminSeats = new javax.swing.JTextField();
        jLabel179 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        AKBtabYourClass = new javax.swing.JTable();
        jLabel181 = new javax.swing.JLabel();
        AKBComboSchoolBusList = new javax.swing.JComboBox();
        KindergartenApply = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        AKcomboKG = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        AKtabKClass = new javax.swing.JTable();
        AKBtnApply = new javax.swing.JButton();
        AKBtnRefresh = new javax.swing.JButton();
        jLabel185 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        AKTxtKidAge = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        AKTxtKidName = new javax.swing.JTextField();
        jScrollPane19 = new javax.swing.JScrollPane();
        AKtabApplication = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        AKTxtEMail = new javax.swing.JTextField();
        HospitalPanel = new javax.swing.JPanel();
        HospitalJPanel = new javax.swing.JPanel();
        AmbulanceRequest = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        btnAmbulanceLocation = new javax.swing.JButton();
        jScrollPane17 = new javax.swing.JScrollPane();
        ARtxtDesc = new javax.swing.JTextArea();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        ARBtnSumit = new javax.swing.JButton();
        jLabel140 = new javax.swing.JLabel();
        ARSpinnerInjuredNum = new javax.swing.JSpinner();
        jLabel141 = new javax.swing.JLabel();
        HMouseClickARBack = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        ARComboReciever = new javax.swing.JComboBox();
        ARComboUrgencyLevel = new javax.swing.JComboBox();
        ARTxtIncidentType = new javax.swing.JTextField();
        ARTxtLocation = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        ARTxtPhoneNum = new javax.swing.JTextField();
        RequestHistory = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        HTabRequestHistory = new javax.swing.JTable();
        jLabel48 = new javax.swing.JLabel();
        RequestListJPanel = new javax.swing.JPanel();
        RequestListNull = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        RequestListView = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel134 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        HpMenu = new javax.swing.JPanel();
        btnAmbulanceRequest = new javax.swing.JButton();
        btnDelivery2 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        SetLocationH = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        map_panel2 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        btnSLocationConfirm2 = new javax.swing.JButton();
        txtHLocation = new javax.swing.JTextField();
        DashboardPanel = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        TableNotification = new javax.swing.JTable();
        btnMarkread = new javax.swing.JButton();
        ManageInformationPanel = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        btnphotoUpload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        txtEntName = new javax.swing.JTextField();
        txtEntLocation = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtKidAmount = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        txtUserAccount = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtDepartmentId = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        PropertyPanel = new javax.swing.JPanel();
        PropertyJPanel = new javax.swing.JPanel();
        PropertyMenu = new javax.swing.JPanel();
        btnSecurity = new javax.swing.JButton();
        btnMaintenance = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SecurityMenu = new javax.swing.JPanel();
        btnSR = new javax.swing.JButton();
        btnSRHistory = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        SecurityRequest = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        txtSecurityType = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSecurityLocation = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtSecurityDesc = new javax.swing.JTextArea();
        jLabel50 = new javax.swing.JLabel();
        ComboxProperty = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        comboxSecurityLevel = new javax.swing.JComboBox();
        btnSecuritySubmit = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        rbtnSecurityGuar = new javax.swing.JRadioButton();
        jLabel88 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        SetLocationS = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        map_panel = new javax.swing.JPanel();
        txtSLocationSet = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        btnSLocationConfirm = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        SecurityRequestHistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSecurityHistory = new javax.swing.JTable();
        DetailsJPanel = new javax.swing.JPanel();
        txtSecurityHistoryRequestType = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtSecurityHistoryGuardName = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSecurityHistoryDesc = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btnSecurityHistoryView = new javax.swing.JButton();
        MaintenanceMenu = new javax.swing.JPanel();
        btnMR = new javax.swing.JButton();
        btnMRHistory = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        MaintenanceRequest = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TxtAreaDescription = new javax.swing.JTextArea();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtApartment = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtIssueType = new javax.swing.JTextField();
        btnRRSubmit = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        ComboxMProperty = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        comboxMLevel = new javax.swing.JComboBox();
        jLabel105 = new javax.swing.JLabel();
        MaintenanceRequestHistory = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableMRhistory = new javax.swing.JTable();
        MHDetailsJPanel = new javax.swing.JPanel();
        MHrequestType = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        MHrequestName = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        MHrequestDesc = new javax.swing.JTextArea();
        jLabel95 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        btnRepairmentHistoryView = new javax.swing.JButton();
        Dailypayment = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TablePayment = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        MarketPanel = new javax.swing.JPanel();
        MarketJPanel = new javax.swing.JPanel();
        MarketMenu = new javax.swing.JPanel();
        btnMList = new javax.swing.JButton();
        btnMDelivery = new javax.swing.JButton();
        btnMOrder = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        MerchandiseList = new javax.swing.JPanel();
        marketCombo = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MListTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        OListTable = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labName1 = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        BackToProperty = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        btnOLAdd = new javax.swing.JButton();
        btnOLRemove = new javax.swing.JButton();
        SetLocationD = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        map_panel1 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        btnSLocationConfirm1 = new javax.swing.JButton();
        txtDLocation = new javax.swing.JTextField();
        Delivery = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableDO = new javax.swing.JTable();
        btnAskDelivery = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        DeliveryJPanel = new javax.swing.JPanel();
        DeliveryInformation = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtADLocation = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtADOID = new javax.swing.JTextField();
        txtDPhone = new javax.swing.JTextField();
        btnLocation = new javax.swing.JButton();
        btnDeliverySubmit = new javax.swing.JButton();
        jLabel97 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        OrderHistory = new javax.swing.JPanel();
        SPOrderView = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        SPOrderHistory = new javax.swing.JPanel();
        OInformation = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtVDDeliveryman = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtDOrderID = new javax.swing.JTextField();
        txtVDSupermarket = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        OrderInformationTable = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TableSpOrderList = new javax.swing.JTable();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        btnHospital = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnProperty1 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(58, 83, 155));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labTime.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        labTime.setForeground(new java.awt.Color(255, 255, 255));
        labTime.setText("Time");
        add(labTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 290, 45));

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
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1623, 27, 140, 40));

        txtWelcome.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        txtWelcome.setForeground(new java.awt.Color(255, 255, 255));
        txtWelcome.setText("Welcome, XXX! ");
        add(txtWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 238, -1));

        btnProperty.setBackground(new java.awt.Color(58, 83, 155));
        btnProperty.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnProperty.setForeground(new java.awt.Color(255, 255, 255));
        btnProperty.setText("Property Service");
        btnProperty.setBorder(null);
        btnProperty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPropertyActionPerformed(evt);
            }
        });
        add(btnProperty, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 240, 50));

        btnSupermarket.setBackground(new java.awt.Color(58, 83, 155));
        btnSupermarket.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnSupermarket.setForeground(new java.awt.Color(255, 255, 255));
        btnSupermarket.setText("Supermarket Service");
        btnSupermarket.setBorder(null);
        btnSupermarket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupermarket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupermarketActionPerformed(evt);
            }
        });
        add(btnSupermarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 240, 50));

        btnKindergarden.setBackground(new java.awt.Color(58, 83, 155));
        btnKindergarden.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnKindergarden.setForeground(new java.awt.Color(255, 255, 255));
        btnKindergarden.setText("Kindergarden Service");
        btnKindergarden.setBorder(null);
        btnKindergarden.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKindergarden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKindergardenActionPerformed(evt);
            }
        });
        add(btnKindergarden, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 240, 50));

        ContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ContentPanel.setLayout(new java.awt.CardLayout());

        KindergardenPanel.setBackground(new java.awt.Color(255, 255, 255));
        KindergardenPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        KindergardenJPanel.setBackground(new java.awt.Color(255, 255, 255));
        KindergardenJPanel.setLayout(new java.awt.CardLayout());

        KdMenu.setBackground(new java.awt.Color(255, 255, 255));

        btnKgApply.setBackground(new java.awt.Color(255, 255, 255));
        btnKgApply.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnKgApply.setForeground(new java.awt.Color(58, 83, 155));
        btnKgApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-school.png"))); // NOI18N
        btnKgApply.setText("     Apply for Kindergarden");
        btnKgApply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnKgApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKgApplyActionPerformed(evt);
            }
        });

        btnSBApply.setBackground(new java.awt.Color(255, 255, 255));
        btnSBApply.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSBApply.setForeground(new java.awt.Color(58, 83, 155));
        btnSBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-school_bus.png"))); // NOI18N
        btnSBApply.setText("        Apply for SchoolBus");
        btnSBApply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSBApplyActionPerformed(evt);
            }
        });

        jLabel118.setBackground(new java.awt.Color(58, 83, 155));
        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(58, 83, 155));
        jLabel118.setText("Welcome to Kindergarten Service");

        jLabel119.setBackground(new java.awt.Color(58, 83, 155));
        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(58, 83, 155));
        jLabel119.setText("Kindergarden Service");

        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N

        javax.swing.GroupLayout KdMenuLayout = new javax.swing.GroupLayout(KdMenu);
        KdMenu.setLayout(KdMenuLayout);
        KdMenuLayout.setHorizontalGroup(
            KdMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KdMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel120)
                .addGap(32, 32, 32)
                .addComponent(jLabel119)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KdMenuLayout.createSequentialGroup()
                .addContainerGap(435, Short.MAX_VALUE)
                .addGroup(KdMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KdMenuLayout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addGap(409, 409, 409))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KdMenuLayout.createSequentialGroup()
                        .addGroup(KdMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSBApply, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKgApply, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(508, 508, 508))))
        );
        KdMenuLayout.setVerticalGroup(
            KdMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KdMenuLayout.createSequentialGroup()
                .addGroup(KdMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120)
                    .addGroup(KdMenuLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(jLabel118)
                .addGap(244, 244, 244)
                .addComponent(btnKgApply, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(btnSBApply, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        KindergardenJPanel.add(KdMenu, "card4");

        ShoolBusApply.setBackground(new java.awt.Color(255, 255, 255));
        ShoolBusApply.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setForeground(new java.awt.Color(255, 255, 255));
        jLabel174.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        ShoolBusApply.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        jLabel175.setBackground(new java.awt.Color(58, 83, 155));
        jLabel175.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel175.setText("Apply for SchoolBus");
        ShoolBusApply.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(58, 83, 155));
        jLabel176.setText("SchoolBus List:");
        ShoolBusApply.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 468, -1, 30));

        jLabel187.setBackground(new java.awt.Color(58, 83, 155));
        jLabel187.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(58, 83, 155));
        jLabel187.setText("Kindergarden Service > ");
        jLabel187.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel187MouseClicked(evt);
            }
        });
        ShoolBusApply.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel180.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(58, 83, 155));
        jLabel180.setText("License Plate:");
        jLabel180.setToolTipText("");
        ShoolBusApply.add(jLabel180, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 555, -1, 30));

        jLabel182.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(58, 83, 155));
        jLabel182.setText("Driver Name:");
        jLabel182.setToolTipText("");
        ShoolBusApply.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 603, -1, 30));

        jLabel184.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(58, 83, 155));
        jLabel184.setText("Capacity:");
        jLabel184.setToolTipText("");
        ShoolBusApply.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 651, -1, 30));

        jLabel186.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(58, 83, 155));
        jLabel186.setText("Remaining Seats:");
        jLabel186.setToolTipText("");
        ShoolBusApply.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 699, -1, 30));

        AKBtabApplication.setModel(new javax.swing.table.DefaultTableModel(
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
        AKBtabApplication.setFocusable(false);
        AKBtabApplication.setIntercellSpacing(new java.awt.Dimension(0, 0));
        AKBtabApplication.setRowHeight(30);
        AKBtabApplication.setSelectionBackground(new java.awt.Color(68, 68, 147));
        AKBtabApplication.setShowVerticalLines(false);
        AKBtabApplication.getTableHeader().setReorderingAllowed(false);
        AKBtabApplication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AKBtabApplicationMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(AKBtabApplication);
        if (AKBtabApplication.getColumnModel().getColumnCount() > 0) {
            AKBtabApplication.getColumnModel().getColumn(1).setPreferredWidth(70);
            AKBtabApplication.getColumnModel().getColumn(4).setPreferredWidth(20);
            AKBtabApplication.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        ShoolBusApply.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 820, 760, 230));

        jLabel17.setBackground(new java.awt.Color(58, 83, 155));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(58, 83, 155));
        jLabel17.setText("APPLY FOR KINDERGARTEN BUS");
        ShoolBusApply.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 56, -1, -1));

        jLabel178.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(58, 83, 155));
        jLabel178.setText("Application for kindergarten bus:");
        ShoolBusApply.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 770, -1, 40));

        AKBBtnApply.setBackground(new java.awt.Color(255, 255, 255));
        AKBBtnApply.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        AKBBtnApply.setForeground(new java.awt.Color(58, 83, 155));
        AKBBtnApply.setText("Apply");
        AKBBtnApply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        AKBBtnApply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AKBBtnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AKBBtnApplyActionPerformed(evt);
            }
        });
        ShoolBusApply.add(AKBBtnApply, new org.netbeans.lib.awtextra.AbsoluteConstraints(931, 700, 128, -1));

        AKBTxtLiense.setEditable(false);
        AKBTxtLiense.setBackground(new java.awt.Color(242, 239, 239));
        AKBTxtLiense.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKBTxtLiense.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShoolBusApply.add(AKBTxtLiense, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 555, 182, -1));

        AKBTxtDriverName.setEditable(false);
        AKBTxtDriverName.setBackground(new java.awt.Color(242, 239, 239));
        AKBTxtDriverName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKBTxtDriverName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShoolBusApply.add(AKBTxtDriverName, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 605, 182, -1));

        AKBTxtCapacity.setEditable(false);
        AKBTxtCapacity.setBackground(new java.awt.Color(242, 239, 239));
        AKBTxtCapacity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKBTxtCapacity.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShoolBusApply.add(AKBTxtCapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 653, 182, -1));

        AKBTxtReaminSeats.setEditable(false);
        AKBTxtReaminSeats.setBackground(new java.awt.Color(242, 239, 239));
        AKBTxtReaminSeats.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKBTxtReaminSeats.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ShoolBusApply.add(AKBTxtReaminSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 701, 182, -1));

        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(58, 83, 155));
        jLabel179.setText("Your Class List:");
        ShoolBusApply.add(jLabel179, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 134, -1, 30));

        AKBtabYourClass.setModel(new javax.swing.table.DefaultTableModel(
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
                "Kindergarten", "Class Name", "Applicant", "Kid Name", "Age", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AKBtabYourClass.setFocusable(false);
        AKBtabYourClass.setIntercellSpacing(new java.awt.Dimension(0, 0));
        AKBtabYourClass.setRowHeight(30);
        AKBtabYourClass.setSelectionBackground(new java.awt.Color(68, 68, 147));
        AKBtabYourClass.setShowVerticalLines(false);
        AKBtabYourClass.getTableHeader().setReorderingAllowed(false);
        AKBtabYourClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AKBtabYourClassMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(AKBtabYourClass);
        if (AKBtabYourClass.getColumnModel().getColumnCount() > 0) {
            AKBtabYourClass.getColumnModel().getColumn(1).setPreferredWidth(50);
            AKBtabYourClass.getColumnModel().getColumn(4).setPreferredWidth(20);
        }

        ShoolBusApply.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 170, 777, 220));

        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(58, 83, 155));
        jLabel181.setText("Please select a bus:");
        ShoolBusApply.add(jLabel181, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, 30));

        AKBComboSchoolBusList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKBComboSchoolBusList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AKBComboSchoolBusListMouseClicked(evt);
            }
        });
        AKBComboSchoolBusList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AKBComboSchoolBusListActionPerformed(evt);
            }
        });
        ShoolBusApply.add(AKBComboSchoolBusList, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 449, 182, 71));

        KindergardenJPanel.add(ShoolBusApply, "card6");

        KindergartenApply.setBackground(new java.awt.Color(255, 255, 255));
        KindergartenApply.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setForeground(new java.awt.Color(255, 255, 255));
        jLabel177.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        KindergartenApply.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(58, 83, 155));
        jLabel183.setText("Please input your kid's information:");
        KindergartenApply.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, -1, 30));

        jLabel188.setBackground(new java.awt.Color(58, 83, 155));
        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(58, 83, 155));
        jLabel188.setText("<< Kindergarden Service");
        jLabel188.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel188MouseClicked(evt);
            }
        });
        KindergartenApply.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 15, -1, 30));

        KindergartenApply.add(AKcomboKG, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 160, 30));

        jLabel7.setBackground(new java.awt.Color(58, 83, 155));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(58, 83, 155));
        jLabel7.setText("APPLY FOR KINDERGARTEN");
        KindergartenApply.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, -1));

        AKtabKClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Class Name", "Class Type", "Teacher", "Capacity", "Reamining Seats", "Deadline", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AKtabKClass.setFocusable(false);
        AKtabKClass.setIntercellSpacing(new java.awt.Dimension(0, 0));
        AKtabKClass.setRowHeight(30);
        AKtabKClass.setSelectionBackground(new java.awt.Color(68, 68, 147));
        AKtabKClass.setShowVerticalLines(false);
        AKtabKClass.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(AKtabKClass);

        KindergartenApply.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 870, 210));

        AKBtnApply.setBackground(new java.awt.Color(255, 255, 255));
        AKBtnApply.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        AKBtnApply.setForeground(new java.awt.Color(58, 83, 155));
        AKBtnApply.setText("Apply");
        AKBtnApply.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        AKBtnApply.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AKBtnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AKBtnApplyActionPerformed(evt);
            }
        });
        KindergartenApply.add(AKBtnApply, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 590, 140, 30));

        AKBtnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        AKBtnRefresh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        AKBtnRefresh.setForeground(new java.awt.Color(58, 83, 155));
        AKBtnRefresh.setText("Refresh");
        AKBtnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        AKBtnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AKBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AKBtnRefreshActionPerformed(evt);
            }
        });
        KindergartenApply.add(AKBtnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 150, 30));

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(58, 83, 155));
        jLabel185.setText("Kindergarden List");
        KindergartenApply.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(58, 83, 155));
        jLabel12.setText("Age:");
        KindergartenApply.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, -1, 30));

        AKTxtKidAge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKTxtKidAge.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KindergartenApply.add(AKTxtKidAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 200, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(58, 83, 155));
        jLabel47.setText("Kid Name:");
        KindergartenApply.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, -1, -1));

        AKTxtKidName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKTxtKidName.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KindergartenApply.add(AKTxtKidName, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 200, -1));

        AKtabApplication.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Kindergarten", "Class Name", "Guardian", "Email", "Kid Name", "Age", "Status", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AKtabApplication.setFocusable(false);
        AKtabApplication.setIntercellSpacing(new java.awt.Dimension(0, 0));
        AKtabApplication.setRowHeight(30);
        AKtabApplication.setSelectionBackground(new java.awt.Color(68, 68, 147));
        AKtabApplication.setShowVerticalLines(false);
        AKtabApplication.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(AKtabApplication);
        if (AKtabApplication.getColumnModel().getColumnCount() > 0) {
            AKtabApplication.getColumnModel().getColumn(1).setPreferredWidth(50);
            AKtabApplication.getColumnModel().getColumn(5).setPreferredWidth(20);
            AKtabApplication.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        KindergartenApply.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 710, 870, 210));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(58, 83, 155));
        jLabel27.setText("Email:");
        KindergartenApply.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, -1, 30));

        AKTxtEMail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AKTxtEMail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KindergartenApply.add(AKTxtEMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 640, 200, -1));

        KindergardenJPanel.add(KindergartenApply, "card6");

        KindergardenPanel.add(KindergardenJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 960));

        ContentPanel.add(KindergardenPanel, "card4");

        HospitalPanel.setBackground(new java.awt.Color(255, 255, 255));
        HospitalPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HospitalJPanel.setBackground(new java.awt.Color(255, 255, 255));
        HospitalJPanel.setLayout(new java.awt.CardLayout());

        AmbulanceRequest.setBackground(new java.awt.Color(255, 255, 255));
        AmbulanceRequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(58, 83, 155));
        jLabel73.setText("Incident type:");
        jLabel73.setToolTipText("");
        AmbulanceRequest.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 30));

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(58, 83, 155));
        jLabel84.setText("Location:");
        jLabel84.setToolTipText("");
        AmbulanceRequest.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, -1, 30));

        btnAmbulanceLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        btnAmbulanceLocation.setBorder(null);
        btnAmbulanceLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbulanceLocationActionPerformed(evt);
            }
        });
        AmbulanceRequest.add(btnAmbulanceLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, 80, -1));

        ARtxtDesc.setColumns(20);
        ARtxtDesc.setForeground(new java.awt.Color(58, 83, 155));
        ARtxtDesc.setRows(5);
        jScrollPane17.setViewportView(ARtxtDesc);

        AmbulanceRequest.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 630, 190));

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(58, 83, 155));
        jLabel132.setText("Sent to:");
        jLabel132.setToolTipText("");
        AmbulanceRequest.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 680, -1, 30));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(58, 83, 155));
        jLabel133.setText("Description of Incident:");
        jLabel133.setToolTipText("");
        AmbulanceRequest.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, 30));

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(58, 83, 155));
        jLabel139.setText("Urgency level:");
        jLabel139.setToolTipText("");
        AmbulanceRequest.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 680, -1, 30));

        ARBtnSumit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ARBtnSumit.setForeground(new java.awt.Color(58, 83, 155));
        ARBtnSumit.setText("SUBMIT");
        ARBtnSumit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARBtnSumitActionPerformed(evt);
            }
        });
        AmbulanceRequest.add(ARBtnSumit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 810, 180, 40));

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(58, 83, 155));
        jLabel140.setText("Number of injured:");
        jLabel140.setToolTipText("");
        AmbulanceRequest.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, 50));

        ARSpinnerInjuredNum.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        AmbulanceRequest.add(ARSpinnerInjuredNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 60, 30));

        jLabel141.setBackground(new java.awt.Color(58, 83, 155));
        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(58, 83, 155));
        jLabel141.setText("Ambulance Request");
        AmbulanceRequest.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        HMouseClickARBack.setBackground(new java.awt.Color(58, 83, 155));
        HMouseClickARBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        HMouseClickARBack.setForeground(new java.awt.Color(58, 83, 155));
        HMouseClickARBack.setText("<< Hospital Service");
        HMouseClickARBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HMouseClickARBackMouseClicked(evt);
            }
        });
        AmbulanceRequest.add(HMouseClickARBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        AmbulanceRequest.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        ARComboReciever.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AmbulanceRequest.add(ARComboReciever, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 710, 210, -1));

        ARComboUrgencyLevel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ARComboUrgencyLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Medium", "High" }));
        AmbulanceRequest.add(ARComboUrgencyLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 710, 210, -1));

        ARTxtIncidentType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ARTxtIncidentType.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AmbulanceRequest.add(ARTxtIncidentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 164, -1));

        ARTxtLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ARTxtLocation.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AmbulanceRequest.add(ARTxtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 179, -1));

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(58, 83, 155));
        jLabel135.setText("Phone Number:");
        jLabel135.setToolTipText("");
        AmbulanceRequest.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, 30));

        ARTxtPhoneNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ARTxtPhoneNum.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AmbulanceRequest.add(ARTxtPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 261, -1));

        HospitalJPanel.add(AmbulanceRequest, "card7");

        RequestHistory.setBackground(new java.awt.Color(255, 255, 255));

        HTabRequestHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
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
                "Incident Type", "Hospital", "Request ID", "Status", "Resolve Time", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        HTabRequestHistory.setFocusable(false);
        HTabRequestHistory.setIntercellSpacing(new java.awt.Dimension(0, 0));
        HTabRequestHistory.setRowHeight(30);
        HTabRequestHistory.setSelectionBackground(new java.awt.Color(68, 68, 147));
        HTabRequestHistory.setShowVerticalLines(false);
        HTabRequestHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane15.setViewportView(HTabRequestHistory);
        if (HTabRequestHistory.getColumnModel().getColumnCount() > 0) {
            HTabRequestHistory.getColumnModel().getColumn(0).setResizable(false);
            HTabRequestHistory.getColumnModel().getColumn(2).setResizable(false);
            HTabRequestHistory.getColumnModel().getColumn(2).setPreferredWidth(50);
            HTabRequestHistory.getColumnModel().getColumn(3).setResizable(false);
            HTabRequestHistory.getColumnModel().getColumn(3).setPreferredWidth(50);
            HTabRequestHistory.getColumnModel().getColumn(4).setResizable(false);
            HTabRequestHistory.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jLabel48.setBackground(new java.awt.Color(58, 83, 155));
        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(58, 83, 155));
        jLabel48.setText("Request List");

        RequestListJPanel.setBackground(new java.awt.Color(255, 255, 255));
        RequestListJPanel.setLayout(new java.awt.CardLayout());

        RequestListNull.setBackground(new java.awt.Color(255, 255, 255));
        RequestListNull.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance 2.png"))); // NOI18N
        RequestListNull.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 570, 450));

        RequestListJPanel.add(RequestListNull, "card5");

        RequestListView.setBackground(new java.awt.Color(255, 255, 255));
        RequestListView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(58, 83, 155));
        jLabel129.setText("Request Detailed Information");
        RequestListView.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 20));

        jLabel55.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(58, 83, 155));
        jLabel55.setText("Incident type:");
        RequestListView.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 30));

        jLabel130.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(58, 83, 155));
        jLabel130.setText("Description of accident：");
        jLabel130.setToolTipText("");
        RequestListView.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 200, 30));

        jTextField7.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jTextField7.setToolTipText("");
        RequestListView.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 60, 30));

        jLabel131.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(58, 83, 155));
        jLabel131.setText("Number of injured：");
        jLabel131.setToolTipText("");
        RequestListView.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, 30));

        jTextField8.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jTextField8.setToolTipText("");
        RequestListView.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 180, 30));

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
        RequestListView.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 180, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane16.setViewportView(jTextArea1);

        RequestListView.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 590, 200));

        jLabel134.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance 2.png"))); // NOI18N
        RequestListView.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 570, 450));

        RequestListJPanel.add(RequestListView, "card3");

        jLabel137.setBackground(new java.awt.Color(58, 83, 155));
        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(58, 83, 155));
        jLabel137.setText("<< Kindergarden Service");
        jLabel137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel137MouseClicked(evt);
            }
        });

        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N

        javax.swing.GroupLayout RequestHistoryLayout = new javax.swing.GroupLayout(RequestHistory);
        RequestHistory.setLayout(RequestHistoryLayout);
        RequestHistoryLayout.setHorizontalGroup(
            RequestHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestHistoryLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel138)
                .addGap(10, 10, 10)
                .addComponent(jLabel137)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(RequestHistoryLayout.createSequentialGroup()
                .addGroup(RequestHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RequestHistoryLayout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(jLabel48))
                    .addGroup(RequestHistoryLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(381, Short.MAX_VALUE))
            .addComponent(RequestListJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RequestHistoryLayout.setVerticalGroup(
            RequestHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestHistoryLayout.createSequentialGroup()
                .addGroup(RequestHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel138)
                    .addGroup(RequestHistoryLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(RequestListJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        HospitalJPanel.add(RequestHistory, "card4");

        HpMenu.setBackground(new java.awt.Color(255, 255, 255));
        HpMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAmbulanceRequest.setBackground(new java.awt.Color(255, 255, 255));
        btnAmbulanceRequest.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAmbulanceRequest.setForeground(new java.awt.Color(58, 83, 155));
        btnAmbulanceRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-ambulance.png"))); // NOI18N
        btnAmbulanceRequest.setText("    Ambulance Request");
        btnAmbulanceRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnAmbulanceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbulanceRequestActionPerformed(evt);
            }
        });
        HpMenu.add(btnAmbulanceRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 390, 70));

        btnDelivery2.setBackground(new java.awt.Color(255, 255, 255));
        btnDelivery2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelivery2.setForeground(new java.awt.Color(58, 83, 155));
        btnDelivery2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        btnDelivery2.setText("     Request History");
        btnDelivery2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnDelivery2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelivery2ActionPerformed(evt);
            }
        });
        HpMenu.add(btnDelivery2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 390, 70));

        jLabel121.setBackground(new java.awt.Color(58, 83, 155));
        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(58, 83, 155));
        jLabel121.setText("Welcome to *");
        HpMenu.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, -1));

        jLabel122.setBackground(new java.awt.Color(58, 83, 155));
        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(58, 83, 155));
        jLabel122.setText("Hospital Service");
        HpMenu.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 30));

        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        HpMenu.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        HospitalJPanel.add(HpMenu, "card4");

        SetLocationH.setBackground(new java.awt.Color(255, 255, 255));
        SetLocationH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setBackground(new java.awt.Color(58, 83, 155));
        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(58, 83, 155));
        jLabel155.setText("Please Select the Rescue location");
        SetLocationH.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 430, 30));

        map_panel2.setLayout(new java.awt.BorderLayout());
        SetLocationH.add(map_panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 950, 490));

        jLabel156.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(58, 83, 155));
        jLabel156.setText("Location Latlng:");
        jLabel156.setToolTipText("");
        SetLocationH.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, -1, 30));

        btnSLocationConfirm2.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnSLocationConfirm2.setForeground(new java.awt.Color(58, 83, 155));
        btnSLocationConfirm2.setText("Confirm");
        btnSLocationConfirm2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSLocationConfirm2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLocationConfirm2ActionPerformed(evt);
            }
        });
        SetLocationH.add(btnSLocationConfirm2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 790, 200, 40));

        txtHLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtHLocation.setForeground(new java.awt.Color(2, 2, 69));
        txtHLocation.setToolTipText("");
        SetLocationH.add(txtHLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, 350, 30));

        HospitalJPanel.add(SetLocationH, "card6");

        HospitalPanel.add(HospitalJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, -1));

        ContentPanel.add(HospitalPanel, "card4");

        DashboardPanel.setBackground(new java.awt.Color(255, 255, 255));
        DashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(58, 83, 155));
        jLabel42.setText("You have * new Notifications:");
        DashboardPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 330, 30));

        jLabel46.setBackground(new java.awt.Color(58, 83, 155));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(58, 83, 155));
        jLabel46.setText("DASHBOARD");
        DashboardPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, -1, -1));

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
        jScrollPane22.setViewportView(TableNotification);

        DashboardPanel.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 660, 280));

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
        DashboardPanel.add(btnMarkread, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 210, 40));

        ContentPanel.add(DashboardPanel, "card5");

        ManageInformationPanel.setBackground(new java.awt.Color(255, 255, 255));
        ManageInformationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setForeground(new java.awt.Color(58, 83, 155));
        image.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Profile photo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 14), new java.awt.Color(58, 83, 155))); // NOI18N
        ManageInformationPanel.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 210, 270));

        btnphotoUpload.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnphotoUpload.setForeground(new java.awt.Color(58, 83, 155));
        btnphotoUpload.setText("Upload");
        btnphotoUpload.setEnabled(false);
        btnphotoUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphotoUploadActionPerformed(evt);
            }
        });
        ManageInformationPanel.add(btnphotoUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 110, 40));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(58, 83, 155));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        ManageInformationPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 810, 200, 40));

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
        ManageInformationPanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 810, 200, 40));

        jLabel71.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(58, 83, 155));
        jLabel71.setText(" Name:");
        jLabel71.setToolTipText("");
        ManageInformationPanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, 30));

        txtEntName.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtEntName.setForeground(new java.awt.Color(58, 83, 155));
        txtEntName.setToolTipText("");
        txtEntName.setEnabled(false);
        ManageInformationPanel.add(txtEntName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 180, 30));

        txtEntLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtEntLocation.setForeground(new java.awt.Color(58, 83, 155));
        txtEntLocation.setToolTipText("");
        txtEntLocation.setEnabled(false);
        ManageInformationPanel.add(txtEntLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 180, 30));

        jLabel72.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(58, 83, 155));
        jLabel72.setText("Location:");
        jLabel72.setToolTipText("");
        ManageInformationPanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 90, 30));

        txtKidAmount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtKidAmount.setForeground(new java.awt.Color(58, 83, 155));
        txtKidAmount.setToolTipText("");
        txtKidAmount.setEnabled(false);
        ManageInformationPanel.add(txtKidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 180, 30));

        jLabel74.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(58, 83, 155));
        jLabel74.setText("Kid Amount:");
        jLabel74.setToolTipText("");
        ManageInformationPanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 100, 30));

        jLabel75.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(58, 83, 155));
        jLabel75.setText("Password:");
        jLabel75.setToolTipText("");
        ManageInformationPanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 90, 30));

        txtPassword.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(58, 83, 155));
        txtPassword.setToolTipText("");
        txtPassword.setEnabled(false);
        ManageInformationPanel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 180, 30));

        jLabel76.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(58, 83, 155));
        jLabel76.setText("User Account:");
        jLabel76.setToolTipText("");
        ManageInformationPanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 120, 30));

        txtUserAccount.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtUserAccount.setForeground(new java.awt.Color(58, 83, 155));
        txtUserAccount.setToolTipText("");
        txtUserAccount.setEnabled(false);
        ManageInformationPanel.add(txtUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 180, 30));

        jButton9.setForeground(new java.awt.Color(58, 83, 155));
        jButton9.setText("SET LOCATION");
        jButton9.setEnabled(false);
        ManageInformationPanel.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 230, -1, -1));

        jLabel77.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(58, 83, 155));
        jLabel77.setText("Department Id:");
        jLabel77.setToolTipText("");
        ManageInformationPanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 130, 30));

        txtPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(58, 83, 155));
        txtPhoneNumber.setToolTipText("");
        txtPhoneNumber.setEnabled(false);
        ManageInformationPanel.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 180, 30));

        txtDepartmentId.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtDepartmentId.setForeground(new java.awt.Color(58, 83, 155));
        txtDepartmentId.setToolTipText("");
        txtDepartmentId.setEnabled(false);
        ManageInformationPanel.add(txtDepartmentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 180, 30));

        jLabel83.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(58, 83, 155));
        jLabel83.setText("Phone Number:");
        jLabel83.setToolTipText("");
        ManageInformationPanel.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 140, 30));

        jLabel85.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-profile.png"))); // NOI18N
        ManageInformationPanel.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 680, 670));

        jLabel86.setBackground(new java.awt.Color(58, 83, 155));
        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(58, 83, 155));
        jLabel86.setText("Manage Information");
        ManageInformationPanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        ContentPanel.add(ManageInformationPanel, "card8");

        PropertyPanel.setBackground(new java.awt.Color(255, 255, 255));
        PropertyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PropertyJPanel.setBackground(new java.awt.Color(255, 255, 255));
        PropertyJPanel.setLayout(new java.awt.CardLayout());

        PropertyMenu.setBackground(new java.awt.Color(255, 255, 255));
        PropertyMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSecurity.setBackground(new java.awt.Color(255, 255, 255));
        btnSecurity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSecurity.setForeground(new java.awt.Color(58, 83, 155));
        btnSecurity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-favorites_shield.png"))); // NOI18N
        btnSecurity.setText("     Security service");
        btnSecurity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSecurity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecurityActionPerformed(evt);
            }
        });
        PropertyMenu.add(btnSecurity, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 390, 70));

        btnMaintenance.setBackground(new java.awt.Color(255, 255, 255));
        btnMaintenance.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMaintenance.setForeground(new java.awt.Color(58, 83, 155));
        btnMaintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-maintenance.png"))); // NOI18N
        btnMaintenance.setText("     Maintenance service");
        btnMaintenance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaintenanceActionPerformed(evt);
            }
        });
        PropertyMenu.add(btnMaintenance, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 390, 70));

        btnPayment.setBackground(new java.awt.Color(255, 255, 255));
        btnPayment.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPayment.setForeground(new java.awt.Color(58, 83, 155));
        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-card_payment.png"))); // NOI18N
        btnPayment.setText("     Daily payment");
        btnPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });
        PropertyMenu.add(btnPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 390, 70));

        jLabel23.setBackground(new java.awt.Color(58, 83, 155));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(58, 83, 155));
        jLabel23.setText("Welcome to Property Service");
        PropertyMenu.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel2.setBackground(new java.awt.Color(58, 83, 155));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(58, 83, 155));
        jLabel2.setText("Property Service");
        PropertyMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        PropertyMenu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        PropertyJPanel.add(PropertyMenu, "card4");

        SecurityMenu.setBackground(new java.awt.Color(255, 255, 255));
        SecurityMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSR.setBackground(new java.awt.Color(255, 255, 255));
        btnSR.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSR.setForeground(new java.awt.Color(58, 83, 155));
        btnSR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-security_guard.png"))); // NOI18N
        btnSR.setText("     Security Request");
        btnSR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRActionPerformed(evt);
            }
        });
        SecurityMenu.add(btnSR, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 390, 70));

        btnSRHistory.setBackground(new java.awt.Color(255, 255, 255));
        btnSRHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSRHistory.setForeground(new java.awt.Color(58, 83, 155));
        btnSRHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        btnSRHistory.setText("     Request History");
        btnSRHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSRHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRHistoryActionPerformed(evt);
            }
        });
        SecurityMenu.add(btnSRHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 390, 70));

        jLabel25.setBackground(new java.awt.Color(58, 83, 155));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(58, 83, 155));
        jLabel25.setText("Welcome to Security Center");
        SecurityMenu.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        SecurityMenu.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel16.setBackground(new java.awt.Color(58, 83, 155));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Security Service");
        SecurityMenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel18.setBackground(new java.awt.Color(58, 83, 155));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(58, 83, 155));
        jLabel18.setText("Property Service > ");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        SecurityMenu.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-protect.png"))); // NOI18N
        SecurityMenu.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 590, 470));

        PropertyJPanel.add(SecurityMenu, "card4");

        SecurityRequest.setBackground(new java.awt.Color(255, 255, 255));
        SecurityRequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(58, 83, 155));
        jLabel33.setText("Incident type:");
        jLabel33.setToolTipText("");
        SecurityRequest.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, 30));

        txtSecurityType.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtSecurityType.setForeground(new java.awt.Color(2, 2, 69));
        txtSecurityType.setToolTipText("");
        SecurityRequest.add(txtSecurityType, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 180, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(58, 83, 155));
        jLabel13.setText("Location:");
        jLabel13.setToolTipText("");
        SecurityRequest.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, -1, 30));

        txtSecurityLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtSecurityLocation.setForeground(new java.awt.Color(2, 2, 69));
        txtSecurityLocation.setToolTipText("");
        SecurityRequest.add(txtSecurityLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 180, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        SecurityRequest.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 80, 30));

        txtSecurityDesc.setColumns(20);
        txtSecurityDesc.setRows(5);
        jScrollPane10.setViewportView(txtSecurityDesc);

        SecurityRequest.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, 600, 280));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(58, 83, 155));
        jLabel50.setText("Sent to");
        jLabel50.setToolTipText("");
        SecurityRequest.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 680, -1, 30));

        ComboxProperty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboxProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxPropertyActionPerformed(evt);
            }
        });
        SecurityRequest.add(ComboxProperty, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 720, 200, -1));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(58, 83, 155));
        jLabel82.setText("Description of Incident:");
        jLabel82.setToolTipText("");
        SecurityRequest.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, 30));

        comboxSecurityLevel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboxSecurityLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOW", "MEDIUM", "HIGH" }));
        comboxSecurityLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxSecurityLevelActionPerformed(evt);
            }
        });
        SecurityRequest.add(comboxSecurityLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 730, 200, -1));

        btnSecuritySubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSecuritySubmit.setForeground(new java.awt.Color(58, 83, 155));
        btnSecuritySubmit.setText("Submit");
        btnSecuritySubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSecuritySubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecuritySubmitActionPerformed(evt);
            }
        });
        SecurityRequest.add(btnSecuritySubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 850, 180, 40));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(58, 83, 155));
        jLabel87.setText("Urgency level");
        jLabel87.setToolTipText("");
        SecurityRequest.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 680, -1, 30));

        rbtnSecurityGuar.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        rbtnSecurityGuar.setForeground(new java.awt.Color(58, 83, 155));
        rbtnSecurityGuar.setText(" Guarantee the authenticity of the description");
        rbtnSecurityGuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSecurityGuarActionPerformed(evt);
            }
        });
        SecurityRequest.add(rbtnSecurityGuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 780, 440, -1));

        jLabel88.setBackground(new java.awt.Color(58, 83, 155));
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(58, 83, 155));
        jLabel88.setText("Security Request");
        SecurityRequest.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        jLabel52.setBackground(new java.awt.Color(58, 83, 155));
        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(58, 83, 155));
        jLabel52.setText("Property Service > ");
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        SecurityRequest.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        SecurityRequest.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel54.setBackground(new java.awt.Color(58, 83, 155));
        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel54.setText("Security Request");
        SecurityRequest.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jLabel57.setBackground(new java.awt.Color(58, 83, 155));
        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(58, 83, 155));
        jLabel57.setText("Security Service > ");
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        SecurityRequest.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        PropertyJPanel.add(SecurityRequest, "card6");

        SetLocationS.setBackground(new java.awt.Color(255, 255, 255));
        SetLocationS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setBackground(new java.awt.Color(58, 83, 155));
        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(58, 83, 155));
        jLabel148.setText("Select the incident location");
        SetLocationS.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, 30));

        map_panel.setLayout(new java.awt.BorderLayout());
        SetLocationS.add(map_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 890, 430));

        txtSLocationSet.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtSLocationSet.setForeground(new java.awt.Color(2, 2, 69));
        txtSLocationSet.setToolTipText("");
        SetLocationS.add(txtSLocationSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 670, 410, 30));

        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(58, 83, 155));
        jLabel149.setText("Location Latlng:");
        jLabel149.setToolTipText("");
        SetLocationS.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 670, -1, 30));

        btnSLocationConfirm.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSLocationConfirm.setForeground(new java.awt.Color(58, 83, 155));
        btnSLocationConfirm.setText("Confirm");
        btnSLocationConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSLocationConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLocationConfirmActionPerformed(evt);
            }
        });
        SetLocationS.add(btnSLocationConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 770, 170, 40));

        jLabel150.setBackground(new java.awt.Color(58, 83, 155));
        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(58, 83, 155));
        jLabel150.setText("Property Service > ");
        jLabel150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel150MouseClicked(evt);
            }
        });
        SetLocationS.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel151.setBackground(new java.awt.Color(58, 83, 155));
        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(58, 83, 155));
        jLabel151.setText("Security Service > ");
        jLabel151.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel151MouseClicked(evt);
            }
        });
        SetLocationS.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel152.setBackground(new java.awt.Color(58, 83, 155));
        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel152.setText("Security Request");
        SetLocationS.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        SetLocationS.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel154.setBackground(new java.awt.Color(58, 83, 155));
        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(58, 83, 155));
        jLabel154.setText("Security Request >");
        jLabel154.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel154MouseClicked(evt);
            }
        });
        SetLocationS.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        PropertyJPanel.add(SetLocationS, "card6");

        SecurityRequestHistory.setBackground(new java.awt.Color(255, 255, 255));
        SecurityRequestHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableSecurityHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Id", "Incident Type", "Status", "Request date", "Resolve date", "Property Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableSecurityHistory.setFocusable(false);
        TableSecurityHistory.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableSecurityHistory.setRowHeight(30);
        TableSecurityHistory.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableSecurityHistory.setShowVerticalLines(false);
        TableSecurityHistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TableSecurityHistory);

        SecurityRequestHistory.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 730, 290));

        DetailsJPanel.setBackground(new java.awt.Color(255, 255, 255));
        DetailsJPanel.setForeground(new java.awt.Color(255, 255, 255));
        DetailsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSecurityHistoryRequestType.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtSecurityHistoryRequestType.setEnabled(false);
        txtSecurityHistoryRequestType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecurityHistoryRequestTypeActionPerformed(evt);
            }
        });
        DetailsJPanel.add(txtSecurityHistoryRequestType, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 210, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(58, 83, 155));
        jLabel11.setText("Incident Type:");
        DetailsJPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 140, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(58, 83, 155));
        jLabel21.setText("Incident description:");
        DetailsJPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 200, 30));

        txtSecurityHistoryGuardName.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        txtSecurityHistoryGuardName.setEnabled(false);
        txtSecurityHistoryGuardName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSecurityHistoryGuardNameActionPerformed(evt);
            }
        });
        DetailsJPanel.add(txtSecurityHistoryGuardName, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 210, 30));

        txtSecurityHistoryDesc.setColumns(20);
        txtSecurityHistoryDesc.setRows(5);
        txtSecurityHistoryDesc.setEnabled(false);
        jScrollPane4.setViewportView(txtSecurityHistoryDesc);

        DetailsJPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 740, 210));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(58, 83, 155));
        jLabel22.setText("Guard Name:");
        DetailsJPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 120, 30));

        jLabel93.setBackground(new java.awt.Color(58, 83, 155));
        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(58, 83, 155));
        jLabel93.setText("Request Details Information");
        DetailsJPanel.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        SecurityRequestHistory.add(DetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 480, 1180, 470));

        jLabel89.setBackground(new java.awt.Color(58, 83, 155));
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(58, 83, 155));
        jLabel89.setText("Manage My Security Request History");
        SecurityRequestHistory.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jLabel58.setBackground(new java.awt.Color(58, 83, 155));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(58, 83, 155));
        jLabel58.setText("Security Service > ");
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        SecurityRequestHistory.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jLabel59.setBackground(new java.awt.Color(58, 83, 155));
        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel59.setText("Request History");
        SecurityRequestHistory.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel60.setBackground(new java.awt.Color(58, 83, 155));
        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(58, 83, 155));
        jLabel60.setText("Property Service > ");
        jLabel60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel60MouseClicked(evt);
            }
        });
        SecurityRequestHistory.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        SecurityRequestHistory.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        btnSecurityHistoryView.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSecurityHistoryView.setForeground(new java.awt.Color(58, 83, 155));
        btnSecurityHistoryView.setText("View");
        btnSecurityHistoryView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSecurityHistoryViewActionPerformed(evt);
            }
        });
        SecurityRequestHistory.add(btnSecurityHistoryView, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 130, 40));

        PropertyJPanel.add(SecurityRequestHistory, "card5");

        MaintenanceMenu.setBackground(new java.awt.Color(255, 255, 255));
        MaintenanceMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMR.setBackground(new java.awt.Color(255, 255, 255));
        btnMR.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMR.setForeground(new java.awt.Color(58, 83, 155));
        btnMR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-plumber.png"))); // NOI18N
        btnMR.setText("     Maintenance Request");
        btnMR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMRActionPerformed(evt);
            }
        });
        MaintenanceMenu.add(btnMR, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 390, 70));

        btnMRHistory.setBackground(new java.awt.Color(255, 255, 255));
        btnMRHistory.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMRHistory.setForeground(new java.awt.Color(58, 83, 155));
        btnMRHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        btnMRHistory.setText("     Request History");
        btnMRHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMRHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMRHistoryActionPerformed(evt);
            }
        });
        MaintenanceMenu.add(btnMRHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, 390, 70));

        jLabel30.setBackground(new java.awt.Color(58, 83, 155));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(58, 83, 155));
        jLabel30.setText("Welcome to Maintenance Center");
        MaintenanceMenu.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        MaintenanceMenu.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel38.setBackground(new java.awt.Color(58, 83, 155));
        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel38.setText("Maintenance Center");
        MaintenanceMenu.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel44.setBackground(new java.awt.Color(58, 83, 155));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(58, 83, 155));
        jLabel44.setText("Property Service > ");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        MaintenanceMenu.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel51.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-printer_maintenance.png"))); // NOI18N
        MaintenanceMenu.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 590, 470));

        PropertyJPanel.add(MaintenanceMenu, "card4");

        MaintenanceRequest.setBackground(new java.awt.Color(255, 255, 255));
        MaintenanceRequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(58, 83, 155));
        jLabel65.setToolTipText("");
        MaintenanceRequest.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, 30));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(58, 83, 155));
        jLabel66.setToolTipText("");
        MaintenanceRequest.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, 30));

        TxtAreaDescription.setColumns(20);
        TxtAreaDescription.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtAreaDescription.setRows(5);
        TxtAreaDescription.setText("Dear Management,\nI have a maintenance request that needs your attention.\nPlease schedule maintenance to make the following repairs.");
        jScrollPane5.setViewportView(TxtAreaDescription);

        MaintenanceRequest.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 680, 270));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(58, 83, 155));
        jLabel67.setToolTipText("");
        MaintenanceRequest.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(58, 83, 155));
        jLabel68.setText("Apartment #");
        jLabel68.setToolTipText("");
        MaintenanceRequest.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, -1, 30));

        txtApartment.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtApartment.setForeground(new java.awt.Color(2, 2, 69));
        txtApartment.setToolTipText("");
        MaintenanceRequest.add(txtApartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, 180, 30));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(58, 83, 155));
        jLabel69.setText("Issue type");
        jLabel69.setToolTipText("");
        MaintenanceRequest.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 610, 100, 30));

        txtIssueType.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtIssueType.setForeground(new java.awt.Color(2, 2, 69));
        txtIssueType.setToolTipText("");
        MaintenanceRequest.add(txtIssueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 200, 30));

        btnRRSubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnRRSubmit.setForeground(new java.awt.Color(58, 83, 155));
        btnRRSubmit.setText("SUBMIT");
        btnRRSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRRSubmitActionPerformed(evt);
            }
        });
        MaintenanceRequest.add(btnRRSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 740, 200, 40));

        jLabel90.setBackground(new java.awt.Color(58, 83, 155));
        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(58, 83, 155));
        jLabel90.setText("Maintenance Request");
        MaintenanceRequest.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 270, 40));

        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        MaintenanceRequest.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel78.setBackground(new java.awt.Color(58, 83, 155));
        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(58, 83, 155));
        jLabel78.setText("Property Service > ");
        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel78MouseClicked(evt);
            }
        });
        MaintenanceRequest.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel79.setBackground(new java.awt.Color(58, 83, 155));
        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(58, 83, 155));
        jLabel79.setText("Maintenance Service > ");
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
        });
        MaintenanceRequest.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel80.setBackground(new java.awt.Color(58, 83, 155));
        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel80.setText("Maintenance Request");
        MaintenanceRequest.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        ComboxMProperty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ComboxMProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboxMPropertyActionPerformed(evt);
            }
        });
        MaintenanceRequest.add(ComboxMProperty, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 560, 200, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(58, 83, 155));
        jLabel56.setText("Sent to");
        jLabel56.setToolTipText("");
        MaintenanceRequest.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, -1, 30));

        comboxMLevel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboxMLevel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LOW", "MEDIUM", "HIGH" }));
        comboxMLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxMLevelActionPerformed(evt);
            }
        });
        MaintenanceRequest.add(comboxMLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 200, -1));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(58, 83, 155));
        jLabel105.setText("Urgency level");
        jLabel105.setToolTipText("");
        MaintenanceRequest.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, -1, 30));

        PropertyJPanel.add(MaintenanceRequest, "card7");

        MaintenanceRequestHistory.setBackground(new java.awt.Color(255, 255, 255));
        MaintenanceRequestHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaintenanceRequestHistoryMouseClicked(evt);
            }
        });
        MaintenanceRequestHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableMRhistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Issue Type", "Status", "Request date", "Resolve date", "Property Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableMRhistory.setFocusable(false);
        TableMRhistory.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableMRhistory.setRowHeight(30);
        TableMRhistory.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableMRhistory.setShowVerticalLines(false);
        TableMRhistory.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TableMRhistory);

        MaintenanceRequestHistory.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 800, 290));

        MHDetailsJPanel.setBackground(new java.awt.Color(255, 255, 255));
        MHDetailsJPanel.setForeground(new java.awt.Color(255, 255, 255));
        MHDetailsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MHrequestType.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        MHrequestType.setEnabled(false);
        MHrequestType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHrequestTypeActionPerformed(evt);
            }
        });
        MHDetailsJPanel.add(MHrequestType, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 210, 30));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(58, 83, 155));
        jLabel81.setText("Issue Type:");
        MHDetailsJPanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 120, 30));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(58, 83, 155));
        jLabel92.setText("Issue description:");
        MHDetailsJPanel.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 230, 30));

        MHrequestName.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        MHrequestName.setEnabled(false);
        MHrequestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHrequestNameActionPerformed(evt);
            }
        });
        MHDetailsJPanel.add(MHrequestName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 210, 30));

        MHrequestDesc.setColumns(20);
        MHrequestDesc.setRows(5);
        MHrequestDesc.setEnabled(false);
        jScrollPane12.setViewportView(MHrequestDesc);

        MHDetailsJPanel.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 610, 140));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(58, 83, 155));
        jLabel95.setText("Repairman Name:");
        MHDetailsJPanel.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 170, 30));

        jLabel104.setBackground(new java.awt.Color(58, 83, 155));
        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(58, 83, 155));
        jLabel104.setText("Request Details Information");
        MHDetailsJPanel.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        MaintenanceRequestHistory.add(MHDetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 1260, 460));

        jLabel106.setBackground(new java.awt.Color(58, 83, 155));
        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(58, 83, 155));
        jLabel106.setText("Manage My Maintenance Request History");
        MaintenanceRequestHistory.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));

        jLabel107.setBackground(new java.awt.Color(58, 83, 155));
        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(58, 83, 155));
        jLabel107.setText("Maintenance Service > ");
        jLabel107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel107MouseClicked(evt);
            }
        });
        MaintenanceRequestHistory.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel108.setBackground(new java.awt.Color(58, 83, 155));
        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel108.setText("Maintenance History");
        MaintenanceRequestHistory.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, -1));

        jLabel109.setBackground(new java.awt.Color(58, 83, 155));
        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(58, 83, 155));
        jLabel109.setText("Property Service > ");
        jLabel109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel109MouseClicked(evt);
            }
        });
        MaintenanceRequestHistory.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        MaintenanceRequestHistory.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        btnRepairmentHistoryView.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnRepairmentHistoryView.setForeground(new java.awt.Color(58, 83, 155));
        btnRepairmentHistoryView.setText("View");
        btnRepairmentHistoryView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairmentHistoryViewActionPerformed(evt);
            }
        });
        MaintenanceRequestHistory.add(btnRepairmentHistoryView, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 130, 30));

        PropertyJPanel.add(MaintenanceRequestHistory, "card5");

        Dailypayment.setBackground(new java.awt.Color(255, 255, 255));
        Dailypayment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TablePayment.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        TablePayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Payment Id", "Types of fee", "Fee Amount", "Status", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(TablePayment);

        Dailypayment.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 800, 320));

        btnPay.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnPay.setForeground(new java.awt.Color(58, 83, 155));
        btnPay.setText("Pay For It");
        btnPay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        Dailypayment.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, 210, 40));

        jLabel111.setBackground(new java.awt.Color(0, 0, 0));
        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel111.setText("Daily Payment");
        Dailypayment.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel112.setBackground(new java.awt.Color(58, 83, 155));
        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(58, 83, 155));
        jLabel112.setText("Property Service > ");
        jLabel112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel112MouseClicked(evt);
            }
        });
        Dailypayment.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        Dailypayment.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel114.setBackground(new java.awt.Color(58, 83, 155));
        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(58, 83, 155));
        jLabel114.setText("My Daily-Payment List");
        Dailypayment.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-expensive.png"))); // NOI18N
        Dailypayment.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 510, 590, 410));

        PropertyJPanel.add(Dailypayment, "card9");

        PropertyPanel.add(PropertyJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 950));

        ContentPanel.add(PropertyPanel, "card4");

        MarketPanel.setBackground(new java.awt.Color(255, 255, 255));
        MarketPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MarketJPanel.setBackground(new java.awt.Color(255, 255, 255));
        MarketJPanel.setLayout(new java.awt.CardLayout());

        MarketMenu.setBackground(new java.awt.Color(255, 255, 255));
        MarketMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMList.setBackground(new java.awt.Color(255, 255, 255));
        btnMList.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMList.setForeground(new java.awt.Color(58, 83, 155));
        btnMList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-basket.png"))); // NOI18N
        btnMList.setText("     Merchandise List");
        btnMList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMListActionPerformed(evt);
            }
        });
        MarketMenu.add(btnMList, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, 390, 70));

        btnMDelivery.setBackground(new java.awt.Color(255, 255, 255));
        btnMDelivery.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMDelivery.setForeground(new java.awt.Color(58, 83, 155));
        btnMDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-delivery.png"))); // NOI18N
        btnMDelivery.setText("     Delivery Service");
        btnMDelivery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMDeliveryActionPerformed(evt);
            }
        });
        MarketMenu.add(btnMDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 390, 70));

        btnMOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnMOrder.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMOrder.setForeground(new java.awt.Color(58, 83, 155));
        btnMOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-purchase_order.png"))); // NOI18N
        btnMOrder.setText("     Order History");
        btnMOrder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnMOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMOrderActionPerformed(evt);
            }
        });
        MarketMenu.add(btnMOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 690, 390, 70));

        jLabel115.setBackground(new java.awt.Color(58, 83, 155));
        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(58, 83, 155));
        jLabel115.setText("Welcome to SuperMarket Service");
        MarketMenu.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, -1, -1));

        jLabel116.setBackground(new java.awt.Color(58, 83, 155));
        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(58, 83, 155));
        jLabel116.setText("Supermarket Service");
        MarketMenu.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 30));

        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        MarketMenu.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        MarketJPanel.add(MarketMenu, "card4");

        MerchandiseList.setBackground(new java.awt.Color(255, 255, 255));
        MerchandiseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        marketCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marketComboActionPerformed(evt);
            }
        });
        MerchandiseList.add(marketCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 47, 130, 30));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(58, 83, 155));
        jLabel19.setText("SuperMarket:");
        jLabel19.setToolTipText("");
        MerchandiseList.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 40, -1, 40));

        MListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise Name", "Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(MListTable);

        MerchandiseList.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 550, 200));

        OListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(OListTable);

        MerchandiseList.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 550, 220));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(58, 83, 155));
        jLabel20.setText("Quantity:");
        MerchandiseList.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, -1, 30));

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        MerchandiseList.add(quantitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, -1, 30));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 2, 69));
        jLabel3.setText("Order Details:");
        MerchandiseList.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(58, 83, 155));
        jLabel1.setText("Merchandise List:");
        MerchandiseList.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        labName1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labName1.setForeground(new java.awt.Color(58, 83, 155));
        labName1.setText("Total price:");
        MerchandiseList.add(labName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 840, -1, -1));

        labPrice.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        labPrice.setForeground(new java.awt.Color(58, 83, 155));
        labPrice.setText("0");
        MerchandiseList.add(labPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 840, -1, -1));

        btnConfirm.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(58, 83, 155));
        btnConfirm.setText("Confirm");
        btnConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        MerchandiseList.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 880, 140, 40));

        jLabel91.setBackground(new java.awt.Color(58, 83, 155));
        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(58, 83, 155));
        jLabel91.setText("Welcome ! *");
        MerchandiseList.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 270, 40));

        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        MerchandiseList.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        BackToProperty.setBackground(new java.awt.Color(58, 83, 155));
        BackToProperty.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        BackToProperty.setForeground(new java.awt.Color(58, 83, 155));
        BackToProperty.setText("Supermarket Service > ");
        BackToProperty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackToPropertyMouseClicked(evt);
            }
        });
        MerchandiseList.add(BackToProperty, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel94.setBackground(new java.awt.Color(58, 83, 155));
        jLabel94.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel94.setText("Merchandise List");
        MerchandiseList.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        btnOLAdd.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnOLAdd.setForeground(new java.awt.Color(58, 83, 155));
        btnOLAdd.setText("Add");
        btnOLAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnOLAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOLAddActionPerformed(evt);
            }
        });
        MerchandiseList.add(btnOLAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 420, 110, 30));

        btnOLRemove.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnOLRemove.setForeground(new java.awt.Color(58, 83, 155));
        btnOLRemove.setText("Remove");
        btnOLRemove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnOLRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOLRemoveActionPerformed(evt);
            }
        });
        MerchandiseList.add(btnOLRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, 110, 30));

        MarketJPanel.add(MerchandiseList, "card10");

        SetLocationD.setBackground(new java.awt.Color(255, 255, 255));
        SetLocationD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setBackground(new java.awt.Color(58, 83, 155));
        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(58, 83, 155));
        jLabel157.setText("Please select the Shipping address");
        SetLocationD.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 430, 30));

        map_panel1.setLayout(new java.awt.BorderLayout());
        SetLocationD.add(map_panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 950, 490));

        jLabel158.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(58, 83, 155));
        jLabel158.setText("Location Latlng:");
        jLabel158.setToolTipText("");
        SetLocationD.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 670, -1, 30));

        btnSLocationConfirm1.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        btnSLocationConfirm1.setForeground(new java.awt.Color(58, 83, 155));
        btnSLocationConfirm1.setText("Confirm");
        btnSLocationConfirm1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnSLocationConfirm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSLocationConfirm1ActionPerformed(evt);
            }
        });
        SetLocationD.add(btnSLocationConfirm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 790, 200, 40));

        txtDLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtDLocation.setForeground(new java.awt.Color(2, 2, 69));
        txtDLocation.setToolTipText("");
        SetLocationD.add(txtDLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, 350, 30));

        MarketJPanel.add(SetLocationD, "card6");

        Delivery.setBackground(new java.awt.Color(255, 255, 255));
        Delivery.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableDO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Delivery Man", "Status", "Request Date", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableDO.setFocusable(false);
        TableDO.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableDO.setRowHeight(30);
        TableDO.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableDO.setShowVerticalLines(false);
        TableDO.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(TableDO);

        Delivery.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 850, 200));

        btnAskDelivery.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnAskDelivery.setForeground(new java.awt.Color(58, 83, 155));
        btnAskDelivery.setText("Ask Deliverying");
        btnAskDelivery.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnAskDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAskDeliveryActionPerformed(evt);
            }
        });
        Delivery.add(btnAskDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 390, 190, 30));

        jLabel34.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(58, 83, 155));
        jLabel34.setText("Order List:");
        Delivery.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        DeliveryJPanel.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryJPanel.setLayout(new java.awt.CardLayout());

        DeliveryInformation.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 83, 155));
        jLabel4.setText("Order Id:");
        DeliveryInformation.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 70, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(58, 83, 155));
        jLabel24.setText("Phone Number:");
        jLabel24.setToolTipText("");
        DeliveryInformation.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 140, 30));

        txtADLocation.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtADLocation.setToolTipText("");
        DeliveryInformation.add(txtADLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 180, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(58, 83, 155));
        jLabel29.setText("Location:");
        jLabel29.setToolTipText("");
        DeliveryInformation.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, -1, 30));

        txtADOID.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtADOID.setToolTipText("");
        txtADOID.setEnabled(false);
        DeliveryInformation.add(txtADOID, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 180, 30));

        txtDPhone.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtDPhone.setToolTipText("");
        DeliveryInformation.add(txtDPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 180, 30));

        btnLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-user_location.png"))); // NOI18N
        btnLocation.setBorder(null);
        btnLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationActionPerformed(evt);
            }
        });
        DeliveryInformation.add(btnLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 80, 30));

        btnDeliverySubmit.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDeliverySubmit.setForeground(new java.awt.Color(58, 83, 155));
        btnDeliverySubmit.setText("SUBMIT");
        btnDeliverySubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(58, 83, 155)));
        btnDeliverySubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliverySubmitActionPerformed(evt);
            }
        });
        DeliveryInformation.add(btnDeliverySubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 40));

        jLabel97.setBackground(new java.awt.Color(58, 83, 155));
        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(58, 83, 155));
        jLabel97.setText("Input your information to finish the delivery request");
        DeliveryInformation.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 500, 40));

        jLabel31.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-flower_delivery.png"))); // NOI18N
        DeliveryInformation.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 590, 460));

        DeliveryJPanel.add(DeliveryInformation, "card3");

        Delivery.add(DeliveryJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 860, 550));

        jLabel96.setBackground(new java.awt.Color(58, 83, 155));
        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(58, 83, 155));
        jLabel96.setText("Delivery Service");
        Delivery.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 220, 40));

        jLabel102.setBackground(new java.awt.Color(58, 83, 155));
        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(58, 83, 155));
        jLabel102.setText("Supermarket Service > ");
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        Delivery.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel103.setBackground(new java.awt.Color(58, 83, 155));
        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel103.setText("Delivery Service");
        Delivery.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        Delivery.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        MarketJPanel.add(Delivery, "card11");

        OrderHistory.setBackground(new java.awt.Color(255, 255, 255));
        OrderHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SPOrderView.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        SPOrderView.setForeground(new java.awt.Color(58, 83, 155));
        SPOrderView.setText("View");
        SPOrderView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPOrderViewActionPerformed(evt);
            }
        });
        OrderHistory.add(SPOrderView, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 170, 30));

        jLabel36.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(58, 83, 155));
        jLabel36.setText("Order List:");
        OrderHistory.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        SPOrderHistory.setBackground(new java.awt.Color(255, 255, 255));
        SPOrderHistory.setLayout(new java.awt.CardLayout());

        OInformation.setBackground(new java.awt.Color(255, 255, 255));
        OInformation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(58, 83, 155));
        jLabel32.setText("Order ID:");
        OInformation.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(58, 83, 155));
        jLabel39.setText("Supermarket:");
        jLabel39.setToolTipText("");
        OInformation.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 130, 30));

        txtVDDeliveryman.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVDDeliveryman.setToolTipText("");
        OInformation.add(txtVDDeliveryman, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 180, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(58, 83, 155));
        jLabel40.setText("Deliveryman:");
        jLabel40.setToolTipText("");
        OInformation.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, 30));

        txtDOrderID.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtDOrderID.setToolTipText("");
        OInformation.add(txtDOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, 30));

        txtVDSupermarket.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        txtVDSupermarket.setToolTipText("");
        OInformation.add(txtVDSupermarket, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 180, 30));

        jLabel98.setBackground(new java.awt.Color(58, 83, 155));
        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(58, 83, 155));
        jLabel98.setText("Order Detailed Information:");
        OInformation.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 40));

        OrderInformationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Merchandise", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(OrderInformationTable);

        OInformation.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 660, 210));

        jLabel43.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-small_business 2.png"))); // NOI18N
        OInformation.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 590, 460));

        SPOrderHistory.add(OInformation, "card3");

        OrderHistory.add(SPOrderHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 1020, 510));

        jLabel99.setBackground(new java.awt.Color(58, 83, 155));
        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(58, 83, 155));
        jLabel99.setText("Order History");
        OrderHistory.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 190, 40));

        TableSpOrderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Market", "Order date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableSpOrderList.setFocusable(false);
        TableSpOrderList.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableSpOrderList.setRowHeight(30);
        TableSpOrderList.setSelectionBackground(new java.awt.Color(68, 68, 147));
        TableSpOrderList.setShowVerticalLines(false);
        TableSpOrderList.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(TableSpOrderList);

        OrderHistory.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 830, 240));

        jLabel100.setBackground(new java.awt.Color(58, 83, 155));
        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(58, 83, 155));
        jLabel100.setText("Supermarket Service > ");
        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel100MouseClicked(evt);
            }
        });
        OrderHistory.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel101.setBackground(new java.awt.Color(58, 83, 155));
        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel101.setText("Order History");
        OrderHistory.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-menu.png"))); // NOI18N
        OrderHistory.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        MarketJPanel.add(OrderHistory, "card11");

        MarketPanel.add(MarketJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 970));

        ContentPanel.add(MarketPanel, "card4");

        add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 133, 1450, 1070));

        btnHospital.setBackground(new java.awt.Color(58, 83, 155));
        btnHospital.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnHospital.setForeground(new java.awt.Color(255, 255, 255));
        btnHospital.setText("Hospital Service");
        btnHospital.setBorder(null);
        btnHospital.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHospitalActionPerformed(evt);
            }
        });
        add(btnHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 240, 50));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-small_business.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-boy.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-hospital.png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 60));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-property.png"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 60, -1));

        btnProperty1.setBackground(new java.awt.Color(58, 83, 155));
        btnProperty1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        btnProperty1.setForeground(new java.awt.Color(255, 255, 255));
        btnProperty1.setText("Dashboard");
        btnProperty1.setBorder(null);
        btnProperty1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProperty1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProperty1ActionPerformed(evt);
            }
        });
        add(btnProperty1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 238, 50));

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/icons8-dashboard.png"))); // NOI18N
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPropertyActionPerformed
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyJPanel.setVisible(true);
        PropertyMenu.setVisible(true);
        DashboardPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        MarketPanel.setVisible(false);
        SecurityRequest.setVisible(false);
        PropertyPanel.setVisible(true);
        PropertyMenu.setVisible(true);
        HospitalPanel.setVisible(false);
        ManageInformationPanel.setVisible(false);

    }//GEN-LAST:event_btnPropertyActionPerformed

    private void btnSupermarketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupermarketActionPerformed
        // TODO add your handling code here:
        Delivery.setVisible(false);
        MarketJPanel.setVisible(true);
        MarketMenu.setVisible(true);
        DashboardPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        KdMenu.setVisible(false);
        MarketPanel.setVisible(true);
        HospitalPanel.setVisible(false);
        SecurityRequest.setVisible(false);
        PropertyPanel.setVisible(false);
        ManageInformationPanel.setVisible(false);
    }//GEN-LAST:event_btnSupermarketActionPerformed
    

    private void btnKindergardenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKindergardenActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(false);
        KdMenu.setVisible(true);
        ShoolBusApply.setVisible(false);
        KindergartenApply.setVisible(false);
        KindergardenPanel.setVisible(true);
        MarketPanel.setVisible(false);
        HospitalPanel.setVisible(false);
        PropertyPanel.setVisible(false);
        MarketJPanel.setVisible(false);
        MarketMenu.setVisible(false);
        ManageInformationPanel.setVisible(false);
    }//GEN-LAST:event_btnKindergardenActionPerformed
    
    private void btnHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(false);
        RequestHistory.setVisible(false);
        AmbulanceRequest.setVisible(false);
        MarketPanel.setVisible(false);
        SecurityRequest.setVisible(false);
        PropertyPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        HospitalPanel.setVisible(true);
        HpMenu.setVisible(true);
        KindergardenJPanel.setVisible(false);
        ManageInformationPanel.setVisible(false);
    }//GEN-LAST:event_btnHospitalActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnKgApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKgApplyActionPerformed
        // TODO add your handling code here:
        KdMenu.setVisible(false);
        ShoolBusApply.setVisible(false);
        KindergartenApply.setVisible(true);
//        System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnKgApplyActionPerformed() 2951." + ecoSystem.getNetworkList());
//        System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnKgApplyActionPerformed() 2952. " + ecoSystem.getResidentDirectory().getResidentList());
        AKcomboKG.removeAllItems();
        for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
//            System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnKgApplyActionPerformed() 3041." + resident.getNetworkName());
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network: ecoSystem.getNetworkList()){
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (enterprise.getEnterpriseType().toString().equals("Kindergarten")) {
                                    AKcomboKG.addItem(enterprise.getName());
                            }               
                        }                    
                    }
                }           
            }            
        }
        
        for(Resident r: ecoSystem.getResidentDirectory().getResidentList()) {
                    if (r.getEmployeeId() == userAccount.getEmployee().getId()) {
                        AKTxtEMail.setText(r.getEmail());
                    }
                }
        populateKApplicaitonTable();
    }//GEN-LAST:event_btnKgApplyActionPerformed

    private void btnSBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSBApplyActionPerformed
        // TODO add your handling code here:
        KdMenu.setVisible(false);
        ShoolBusApply.setVisible(true);
        KindergartenApply.setVisible(false);
        populateYouClassList();
        populateKBApplication();
        AKBComboSchoolBusList.removeAllItems();
    }//GEN-LAST:event_btnSBApplyActionPerformed

    private void jLabel187MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel187MouseClicked
        // TODO add your handling code here:
        KdMenu.setVisible(false);
        ShoolBusApply.setVisible(false);
        KindergartenApply.setVisible(false);
        KindergardenPanel.setVisible(true);
        MarketPanel.setVisible(false);
        HospitalPanel.setVisible(false);
        PropertyPanel.setVisible(false);
    }//GEN-LAST:event_jLabel187MouseClicked

    private void AKBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AKBtnRefreshActionPerformed
        // TODO add your handling code here:
        populateClassTable();
    }//GEN-LAST:event_AKBtnRefreshActionPerformed

    private void AKBtnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AKBtnApplyActionPerformed
        // TODO add your handling code here:
        
    String kidName = AKTxtKidName.getText();
    String age = AKTxtKidAge.getText();
    int selectedClass = AKtabKClass.getSelectedRow();
            
    if (selectedClass < 0){
        JOptionPane.showMessageDialog(null, "Please select a class!", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    else if (kidName.equals("") || age.equals("")){
        JOptionPane.showMessageDialog(null, "Please input your kid's name and age", "Warning", JOptionPane.WARNING_MESSAGE);           
    }           
    else {
        KClass kclass = (KClass)AKtabKClass.getValueAt(selectedClass, 0);
        if (kclass.getRemainPlaces()>0) {
            int selectionResult = JOptionPane.showConfirmDialog(null, "Do you confirm the application?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(selectionResult == JOptionPane.YES_OPTION){
                KApplication kApplication = new KApplication();
                SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
                Date dNow = new Date();
                kApplication.setKindergartenName(String.valueOf(AKcomboKG.getSelectedItem()));
                kApplication.setClassName(kclass.getClassName());
                kApplication.setKidName(kidName);
                kApplication.setKidAge(Integer.parseInt(age));
                kApplication.setSender(userAccount.getUsername());
                kApplication.setReceiver(kclass.getTeacherUserName());
                for(Resident r: ecoSystem.getResidentDirectory().getResidentList()) {
                    if (r.getEmployeeId() == userAccount.getEmployee().getId()) {
                    kApplication.setPhoneNum(r.getPhoneNum());
                    }
                }

                kApplication.setRequestDate(dateformat.format(dNow));
                kApplication.setEmail(AKTxtEMail.getText());
                kApplication.setStatus("Applied");
                
                ecoSystem.getkAppicationDirectory().getkApplicationList().add(kApplication);
                System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.AKBtnApplyActionPerformed() 118. " + ecoSystem.getkAppicationDirectory().getkApplicationList());
                populateKApplicaitonTable();
                AKTxtKidName.setText("");
                AKTxtKidAge.setText("");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "No remaining seats! Please select another class.", "Warning", JOptionPane.WARNING_MESSAGE);
            AKTxtKidName.setText("");
            AKTxtKidAge.setText("");
        }

//        for (KApplication ka : ecoSystem.getkAppicationDirectory().getkApplicationList()) {
//            if (userAccount.getUsername().equals(ka.getSender())) {
//                boolean a = ka.getKidName().equals(kidName);
//                boolean b = kclass.getClassName().equals(ka.getClassName());
//                System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.AKBtnApplyActionPerformed() 3108. " + "a: " + a + " b: " + b);
//                System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.AKBtnApplyActionPerformed()3109. " + "kclass.getClassName(): " + kclass.getClassName() + " ka.getClassName(): " + ka.getClassName());
//                if (ka.getKidName().equals(kidName) && ka.getClassName().equals(kclass.getClassName())) {
//                    JOptionPane.showMessageDialog(null, kidName+" has applied for this class, please wait for confirmation.", "Warning", JOptionPane.WARNING_MESSAGE);
//                    AKTxtKidName.setText("");
//                    AKTxtKidAge.setText("");
//                }
//                else {
                                        
//                }
//            }
//        }
//        
    }             
                   
    }//GEN-LAST:event_AKBtnApplyActionPerformed

    private void jLabel188MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel188MouseClicked
        // TODO add your handling code here:
        KdMenu.setVisible(false);
        ShoolBusApply.setVisible(false);
        KindergartenApply.setVisible(false);
        KindergardenPanel.setVisible(true);
        MarketPanel.setVisible(false);
        HospitalPanel.setVisible(false);
        PropertyPanel.setVisible(false);
    }//GEN-LAST:event_jLabel188MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        dB4OUtil.storeSystem(ecoSystem);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnAmbulanceRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbulanceRequestActionPerformed
        // TODO add your handling code here:
        PropertyJPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        MarketPanel.setVisible(false);
        HpMenu.setVisible(false);
        AmbulanceRequest.setVisible(true);
        
        ARComboReciever.removeAllItems();
        for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
//            System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnKgApplyActionPerformed() 3041." + resident.getNetworkName());
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network: ecoSystem.getNetworkList()){
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                            System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnAmbulanceRequestActionPerformed() 3764. " + network.getEnterpriseDirectory().getEnterpriseList());
                            if (enterprise.getEnterpriseType().toString().equals("Hospital")) {
                                    ARComboReciever.addItem(enterprise.getName());
                            }               
                        }                    
                    }
                }           
            }            
        }
        
    }//GEN-LAST:event_btnAmbulanceRequestActionPerformed

    private void btnDelivery2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelivery2ActionPerformed
        // TODO add your handling code here:
        PropertyJPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        MarketPanel.setVisible(false);
        HpMenu.setVisible(false);
        RequestHistory.setVisible(true);
        populateRequestHistoryTable();
    }//GEN-LAST:event_btnDelivery2ActionPerformed

    private void jLabel137MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel137MouseClicked
        // TODO add your handling code here:
        RequestHistory.setVisible(false);
        MarketPanel.setVisible(false);
        SecurityRequest.setVisible(false);
        PropertyPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        HospitalPanel.setVisible(true);
    }//GEN-LAST:event_jLabel137MouseClicked

    private void HMouseClickARBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HMouseClickARBackMouseClicked
        // TODO add your handling code here:
        AmbulanceRequest.setVisible(false);
        MarketPanel.setVisible(false);
        SecurityRequest.setVisible(false);
        PropertyPanel.setVisible(false);
        KindergardenPanel.setVisible(false);
        HospitalPanel.setVisible(true);
    }//GEN-LAST:event_HMouseClickARBackMouseClicked

    private void ARBtnSumitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ARBtnSumitActionPerformed
        // TODO add your handling code here:
    String incidentType = ARTxtIncidentType.getText();
    String location = ARTxtLocation.getText();
    int injuredNum = (int) ARSpinnerInjuredNum.getValue();
    String desc = ARtxtDesc.getText();
    String phoneNum = ARTxtPhoneNum.getText();
    String urgencyLevel = String.valueOf(ARComboUrgencyLevel.getSelectedItem());
    String hospital = String.valueOf(ARComboReciever.getSelectedItem());
           
    int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to send the request?","Confirmation",JOptionPane.YES_NO_OPTION);
    if(selectionResult == JOptionPane.YES_OPTION){
        AmbulanceRequest ar = new AmbulanceRequest();
        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
        Date dNow = new Date();
        ar.setRequestDate(dateformat.format(dNow));
        ar.setIncidentType(incidentType);
        ar.setLocation(location);
        ar.setInjuredNum(injuredNum);
        ar.setPhoneNum(phoneNum);
        ar.setDescription(desc);
        ar.setUrgencyLevel(urgencyLevel);
        ar.setSender(userAccount.getEmployee().getName());
        ar.setHospital(hospital);
        ar.setStatus("waiting");
        ar.setRequestId(ecoSystem.getAmbulanceRequestDirectory().getAmbulanceRequestList().size()+1);
        for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
//            System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.btnKgApplyActionPerformed() 3041." + resident.getNetworkName());
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network: ecoSystem.getNetworkList()){
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                                for (UserAccount userAccount : enterprise.getUserAccountDirectory().getUserAccountList()) {
                                    if (userAccount.getRole().toString().equals("Business.Role.HospitalManagerRole") && enterprise.getName().equals(hospital)){
                                        ar.setReceiver(userAccount.getUsername());
                                    }
                                }             
                        }                    
                    }
                }           
            }            
        }
        userAccount.getAmbulanceRequestList().add(ar);
        ecoSystem.getAmbulanceRequestDirectory().getAmbulanceRequestList().add(ar);
//        ARTxtIncidentType.setText("");
//        ARTxtLocation.setText("");
//        ARtxtDesc.setText("");
        
    }
    }//GEN-LAST:event_ARBtnSumitActionPerformed

    private void AKBBtnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AKBBtnApplyActionPerformed
        // TODO add your handling code here:
        int selectedClass = AKBtabYourClass.getSelectedRow();
        if (selectedClass < 0){
            JOptionPane.showMessageDialog(null, "Please select a class!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            if (Integer.parseInt(AKBTxtReaminSeats.getText()) > 0) {
                int selectionResult = JOptionPane.showConfirmDialog(null, "Do you confirm the application?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(selectionResult == JOptionPane.YES_OPTION){
                    KApplication ka = (KApplication)AKBtabYourClass.getValueAt(selectedClass, 0);
                    KBApplication kba = new KBApplication();
                    kba.setKindergartenName(ka.getKindergartenName());
                    kba.setLicenseNum(AKBTxtLiense.getText());
                    kba.setKidName(ka.getKidName());
                    kba.setKidAge(ka.getKidAge());
                    kba.setSender(userAccount.getUsername());
                    for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
                        if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                            for (Network network: ecoSystem.getNetworkList()){
                                if (resident.getNetworkName().equals(network.toString())) {
                                    for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                                        for (UserAccount u : enterprise.getUserAccountDirectory().getUserAccountList()) {
                                            if (u.getRole().toString().equals("Business.Role.BusDriverRole") && enterprise.getName().equals(ka.getKindergartenName())) {
                                                for (KindergartenBus kb: u.getKindergartenBusDirectory().getBusList()) {
                                                    kba.setReceiver(kb.getDriverUsername());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    kba.setStatus("Applied");
                    userAccount.getkBApplicationDirectory().getkBApplicationList().add(kba);
                    ecoSystem.getkBApplicationDirectory().getkBApplicationList().add(kba);
                    System.out.println("UserInterface.ResidentRole.ResidentWorkJPanel.AKBBtnApplyActionPerformed() 3068. " + kba.getLicenseNum());
                    populateKBApplication();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "No remaining seats! Please select another kindergarten bus.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
                
         
        }
    }//GEN-LAST:event_AKBBtnApplyActionPerformed

    private void AKBtabApplicationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AKBtabApplicationMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AKBtabApplicationMouseClicked

    private void btnProperty1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProperty1ActionPerformed
        // TODO add your handling code here:
        DashboardPanel.setVisible(true);
        KindergardenPanel.setVisible(false);
        MarketPanel.setVisible(false);
        PropertyPanel.setVisible(false);
        HospitalPanel.setVisible(false);
        ManageInformationPanel.setVisible(false);
    }//GEN-LAST:event_btnProperty1ActionPerformed

    private void AKBtabYourClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AKBtabYourClassMouseClicked
        // TODO add your handling code here:
        int selectedClass = AKBtabYourClass.getSelectedRow();
        KApplication ka = (KApplication)AKBtabYourClass.getValueAt(selectedClass, 0);

        AKBComboSchoolBusList.removeAllItems();
        for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network: ecoSystem.getNetworkList()){
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                            for (UserAccount u : enterprise.getUserAccountDirectory().getUserAccountList()) {
                                if (u.getRole().toString().equals("Business.Role.BusDriverRole") && enterprise.getName().equals(ka.getKindergartenName())) {
                                    for (KindergartenBus kd: u.getKindergartenBusDirectory().getBusList()) {
                                        AKBComboSchoolBusList.addItem(kd.getLicenseNum());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network: ecoSystem.getNetworkList()){
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                            for (UserAccount u : enterprise.getUserAccountDirectory().getUserAccountList()) {
                                for (KindergartenBus kb: u.getKindergartenBusDirectory().getBusList()) {
                                    if (kb.getLicenseNum().equals(String.valueOf(AKBComboSchoolBusList.getSelectedItem()))) {
                                        AKBTxtLiense.setText(kb.getLicenseNum());
                                        AKBTxtDriverName.setText(kb.getDriverName());
                                        AKBTxtReaminSeats.setText(String.valueOf(kb.getRemainSeats()));
                                        AKBTxtCapacity.setText(String.valueOf(kb.getCapacity()));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_AKBtabYourClassMouseClicked

    private void AKBComboSchoolBusListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AKBComboSchoolBusListMouseClicked
        // TODO add your handling code here:
    if (AKBComboSchoolBusList.getSelectedItem()==null) {
    JOptionPane.showConfirmDialog(null, "Please select a row!","Warning",JOptionPane.WARNING_MESSAGE);
    }
    else {
        AKBComboSchoolBusList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                Object selectedItem = event.getItem();
                if (selectedItem == AKBComboSchoolBusList.getSelectedItem()) {
                    for(Resident resident: ecoSystem.getResidentDirectory().getResidentList()) {
                        if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                            for (Network network: ecoSystem.getNetworkList()){
                                if (resident.getNetworkName().equals(network.toString())) {
                                    for (Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()) {
                                        for (UserAccount u : enterprise.getUserAccountDirectory().getUserAccountList()) {
                                            for (KindergartenBus kb: u.getKindergartenBusDirectory().getBusList()) {
                                                if (kb.getLicenseNum().equals(String.valueOf(AKBComboSchoolBusList.getSelectedItem()))) {
                                                    AKBTxtLiense.setText(kb.getLicenseNum());
                                                    AKBTxtDriverName.setText(kb.getDriverName());
                                                    AKBTxtReaminSeats.setText(String.valueOf(kb.getRemainSeats()));
                                                    AKBTxtCapacity.setText(String.valueOf(kb.getCapacity()));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }            
            }
        });
    }
    }//GEN-LAST:event_AKBComboSchoolBusListMouseClicked

    private void AKBComboSchoolBusListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AKBComboSchoolBusListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AKBComboSchoolBusListActionPerformed

    private void btnMarkreadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkreadActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableNotification.getSelectedRow();
        if (selectedRow >= 0) {
            Message s = (Message) TableNotification.getValueAt(selectedRow, 0);
            for(Message message : ecoSystem.getMessageList().getMessageList()){
                if(message == s){
                    ecoSystem.getMessageList().getMessageList().remove(message);
                    jLabel27.setText("You have " + TableNotification.getRowCount()+  " new Notifications:");
                    populateMessageTable();
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a Message.");
        }
    }//GEN-LAST:event_btnMarkreadActionPerformed

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

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtEntName.setEnabled(true);
        txtEntLocation.setEnabled(true);
        txtKidAmount.setEnabled(true);
        txtEntName.setEnabled(true);

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

    private void btnSecurityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecurityActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_btnSecurityActionPerformed

    private void btnMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaintenanceActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(true);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_btnMaintenanceActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(true);
        PaymentTable();
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnSRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(true);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network : ecoSystem.getNetworkList()) {
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (enterprise.getEnterpriseType().toString().equals("Property")) {
                                ComboxProperty.addItem(enterprise.getName());
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSRActionPerformed

    private void btnSRHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRHistoryActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(true);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        DetailsJPanel.setVisible(false);
        SRequestHistoryTable();
    }//GEN-LAST:event_btnSRHistoryActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void ComboxPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxPropertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboxPropertyActionPerformed

    private void comboxSecurityLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxSecurityLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxSecurityLevelActionPerformed

    private void btnSecuritySubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecuritySubmitActionPerformed
        // TODO add your handling code here:
        if (rbtnSecurityGuar.isSelected()) {
            SRRequest request = new SRRequest();
            request.setDescription(txtSecurityDesc.getText());
            request.setLevel(comboxSecurityLevel.getSelectedItem().toString());
            request.setLocation(txtSecurityLocation.getText());
            request.setType(txtSecurityType.getText());

            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
            Date dNow = new Date();
            request.setRequestTime(dateformat.format(dNow));
            request.setSender(userAccount.getEmployee().getName());
            request.setRequestType("Security Request");
            request.setStatus("Awaiting processing");
            request.setPropertyName(ComboxProperty.getSelectedItem().toString());

            Message message = new Message();
            message.setReceiver(ComboxProperty.getSelectedItem().toString());
            message.setContent("You received a new security request");
            message.setRequestDate(dateformat.format(dNow));
            ecoSystem.getMessageList().getMessageList().add(message);

            for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
                if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                    request.setSender(resident.getFullname());
                    resident.getSRRequestList().add(request);
                    JOptionPane.showMessageDialog(this, "Submit successfully", "Information Message", JOptionPane.INFORMATION_MESSAGE);
                    txtSecurityDesc.setText("");
                    comboxSecurityLevel.setSelectedIndex(0);
                    ComboxProperty.setSelectedIndex(0);
                    txtSecurityType.setText("");
                    txtSecurityLocation.setText("");
                    rbtnSecurityGuar.setSelected(false);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "You have to guarantee the autheicity of the description", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSecuritySubmitActionPerformed

    private void rbtnSecurityGuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSecurityGuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnSecurityGuarActionPerformed

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(true);
        PropertyMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel57MouseClicked

    private void btnSecurityHistoryViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSecurityHistoryViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableSecurityHistory.getSelectedRow();

        if (selectedRow >= 0) {
            DetailsJPanel.setVisible(true);
            SRRequest s = (SRRequest) TableSecurityHistory.getValueAt(selectedRow, 0);
            //txt
            txtSecurityHistoryRequestType.setText(s.getType());
            txtSecurityHistoryGuardName.setText(s.getReceiver());
            txtSecurityHistoryDesc.setText(s.getDescription());

        } else {
            JOptionPane.showMessageDialog(null, "Please select a security request.");
        }
    }//GEN-LAST:event_btnSecurityHistoryViewActionPerformed

    private void txtSecurityHistoryRequestTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecurityHistoryRequestTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecurityHistoryRequestTypeActionPerformed

    private void txtSecurityHistoryGuardNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSecurityHistoryGuardNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSecurityHistoryGuardNameActionPerformed

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(true);
        PropertyMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        DetailsJPanel.setVisible(false);
    }//GEN-LAST:event_jLabel58MouseClicked

    private void jLabel60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel60MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        DetailsJPanel.setVisible(false);
    }//GEN-LAST:event_jLabel60MouseClicked

    private void btnMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMRActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(true);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network : ecoSystem.getNetworkList()) {
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (enterprise.getEnterpriseType().toString().equals("Property")) {
                                ComboxMProperty.addItem(enterprise.getName());
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnMRActionPerformed

    private void btnMRHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMRHistoryActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(true);
        Dailypayment.setVisible(false);
        MHDetailsJPanel.setVisible(false);
        RRequestHistoryTable();
    }//GEN-LAST:event_btnMRHistoryActionPerformed

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel44MouseClicked

    private void btnRRSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRRSubmitActionPerformed
        // TODO add your handling code here:
        SRRequest request = new SRRequest();
        SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
        Date dNow = new Date();
        request.setRequestTime(dateformat.format(dNow));

        request.setDescription(TxtAreaDescription.getText());
        request.setApartmentNum(txtApartment.getText());
        request.setSender(userAccount.getEmployee().getName());
        request.setRequestType("Maintenance Request");
        request.setType(txtIssueType.getText());
        request.setStatus("Awaiting processing");
        request.setPropertyName(ComboxMProperty.getSelectedItem().toString());
        request.setLevel(comboxMLevel.getSelectedItem().toString());

        Message message = new Message();
        message.setReceiver(ComboxMProperty.getSelectedItem().toString());
        message.setContent("You received a new Maintenance request");
        message.setRequestDate(dateformat.format(dNow));
        ecoSystem.getMessageList().getMessageList().add(message);

        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                request.setSender(resident.getFullname());
                resident.getSRRequestList().add(request);

                JOptionPane.showMessageDialog(this, "Submit successfully", "Information Message", JOptionPane.INFORMATION_MESSAGE);
                TxtAreaDescription.setText("");
                txtApartment.setText("");
                txtIssueType.setText("");
                ComboxMProperty.setSelectedIndex(0);
                comboxMLevel.setSelectedItem(0);
            }
        }
    }//GEN-LAST:event_btnRRSubmitActionPerformed

    private void jLabel78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel78MouseClicked

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(true);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel79MouseClicked

    private void ComboxMPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboxMPropertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboxMPropertyActionPerformed

    private void comboxMLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxMLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxMLevelActionPerformed

    private void btnRepairmentHistoryViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairmentHistoryViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableMRhistory.getSelectedRow();

        if (selectedRow >= 0) {
            MHDetailsJPanel.setVisible(true);
            SRRequest s = (SRRequest) TableMRhistory.getValueAt(selectedRow, 0);
            //txt
            MHrequestType.setText(s.getType());
            MHrequestName.setText(s.getReceiver());
            MHrequestDesc.setText(s.getDescription());

        } else {
            JOptionPane.showMessageDialog(null, "Please select a Maintenance request.");
        }
    }//GEN-LAST:event_btnRepairmentHistoryViewActionPerformed

    private void MHrequestTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHrequestTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MHrequestTypeActionPerformed

    private void MHrequestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHrequestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MHrequestNameActionPerformed

    private void jLabel107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel107MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(true);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        MHDetailsJPanel.setVisible(false);
    }//GEN-LAST:event_jLabel107MouseClicked

    private void jLabel109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel109MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        MHDetailsJPanel.setVisible(false);
    }//GEN-LAST:event_jLabel109MouseClicked

    private void MaintenanceRequestHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaintenanceRequestHistoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MaintenanceRequestHistoryMouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        int selectedRow = TablePayment.getSelectedRow();
        if (selectedRow >= 0) {
            Payment payment = (Payment) TablePayment.getValueAt(selectedRow, 0);
            for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
                for (Payment p : resident.getPaymentList()) {
                    if (p.toString().equals(payment.toString())) {
                        p.setStatus("Compeleted");
                        PaymentTable();
                        JOptionPane.showMessageDialog(null, "Pay Successfully.");
                    }
                }
            }
            //txt
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Order.");
        }
    }//GEN-LAST:event_btnPayActionPerformed

    private void jLabel112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel112MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        PropertyMenu.setVisible(true);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
    }//GEN-LAST:event_jLabel112MouseClicked

    private void btnMListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMListActionPerformed
        // TODO add your handling code here:
        MerchandiseList.setVisible(true);
        MarketMenu.setVisible(false);
        Delivery.setVisible(false);
        OrderHistory.setVisible(false);
        marketCombo.removeAllItems();
        marketCombo.addItem("null");
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (Network network : ecoSystem.getNetworkList()) {
                    if (resident.getNetworkName().equals(network.toString())) {
                        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                            if (enterprise.getEnterpriseType().toString().equals("Market")) {
                                marketCombo.addItem(enterprise.getName());
                            }
                        }
                    }
                }
            }
        }
        labPrice.setText("0");
    }//GEN-LAST:event_btnMListActionPerformed

    private void btnMDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMDeliveryActionPerformed
        // TODO add your handling code here:
        MerchandiseList.setVisible(false);
        MarketMenu.setVisible(false);
        Delivery.setVisible(true);
        OrderHistory.setVisible(false);
        DeliveryMerchandiseTable();
    }//GEN-LAST:event_btnMDeliveryActionPerformed

    private void btnMOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMOrderActionPerformed
        // TODO add your handling code here:
        MerchandiseList.setVisible(false);
        MarketMenu.setVisible(false);
        Delivery.setVisible(false);
        OrderHistory.setVisible(true);
        AllMerchandiseOrderTable();
    }//GEN-LAST:event_btnMOrderActionPerformed

    private void marketComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marketComboActionPerformed
        // TODO add your handling code here:
        merchandiseTable();
        merchandiseOrder = new MerchandiseOrder();
        MOrderListTable();
    }//GEN-LAST:event_marketComboActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        if (merchandiseOrder.getMerchandiseList().size() > 0) {
            SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy  KK:mm:ss a");
            Date dNow = new Date();
            merchandiseOrder.setRequestTime(dateformat.format(dNow));
            merchandiseOrder.setStatus("Payment completed");
            merchandiseOrder.setMarketName(marketCombo.getSelectedItem().toString());
            for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
                if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                    merchandiseOrder.setSender(resident.getFullname());
                    resident.getMerchandiseOrderList().add(merchandiseOrder);
                }
            }

            Message message = new Message();
            message.setReceiver(marketCombo.getSelectedItem().toString());
            message.setContent("You received a new order");
            message.setRequestDate(dateformat.format(dNow));
            ecoSystem.getMessageList().getMessageList().add(message);

            JOptionPane.showMessageDialog(null, "Order placed successfully!!");
            merchandiseOrder = new MerchandiseOrder();
            MOrderListTable();
            marketCombo.setSelectedItem("null");
            merchandiseTable();

        } else {
            JOptionPane.showMessageDialog(null, "no order placed");
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void BackToPropertyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackToPropertyMouseClicked
        // TODO add your handling code here:
        MerchandiseList.setVisible(false);
        MarketMenu.setVisible(true);
        Delivery.setVisible(false);
        OrderHistory.setVisible(false);
    }//GEN-LAST:event_BackToPropertyMouseClicked

    private void btnOLAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOLAddActionPerformed
        // TODO add your handling code here:
        int selectedRow = MListTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Merchandise !");
            return;
        }

        Merchandise selectedMerchandise = (Merchandise) MListTable.getValueAt(selectedRow, 0);

        int fetchQty = (Integer) quantitySpinner.getValue();
        if (fetchQty <= 0) {
            JOptionPane.showMessageDialog(null, "Quatity cannot be less than equal to 0 !");
            return;
        }

        if (fetchQty <= selectedMerchandise.getQuantity()) {
            boolean alreadyPresent = false;

            for (Merchandise merchandise : merchandiseOrder.getMerchandiseList()) {
                if (merchandise.getName() == selectedMerchandise.getName()) {
                    int oldAvail = selectedMerchandise.getQuantity();
                    int newAvail = oldAvail - fetchQty;
                    selectedMerchandise.setQuantity(newAvail);
                    merchandise.setQuantity(fetchQty + merchandise.getQuantity());
                    alreadyPresent = true;
                    MOrderListTable();
                    merchandiseTable();
                    break;
                }
            }
            if (!alreadyPresent) {
                int oldAvail = selectedMerchandise.getQuantity();
                int newAvail = oldAvail - fetchQty;
                selectedMerchandise.setQuantity(newAvail);

                String name = selectedMerchandise.getName();
                double price = selectedMerchandise.getPrice();

                merchandiseOrder.addMerchandise(name, price, fetchQty);//input merchandise

                MOrderListTable();
                merchandiseTable();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Quantity > Availiblity!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        int totalPrice = 0;
        for (Merchandise merchandise : merchandiseOrder.getMerchandiseList()) {
            totalPrice += merchandise.getQuantity() * merchandise.getPrice();
        }

        labPrice.setText(Integer.toString(totalPrice));
    }//GEN-LAST:event_btnOLAddActionPerformed

    private void btnOLRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOLRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = OListTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select a Merchandise to remove!");
            return;
        }

        Merchandise selectedMerchandise = (Merchandise) OListTable.getValueAt(selectedRow, 0);
        merchandiseOrder.removeMerchandise(selectedMerchandise);
        MOrderListTable();
    }//GEN-LAST:event_btnOLRemoveActionPerformed

    private void btnAskDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAskDeliveryActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableDO.getSelectedRow();
        if (selectedRow >= 0) {
            DeliveryInformation.setVisible(true);
            merchandiseOrder = (MerchandiseOrder) TableDO.getValueAt(selectedRow, 0);
            txtADOID.setText(merchandiseOrder.toString());
            //txt
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Order.");
        }
    }//GEN-LAST:event_btnAskDeliveryActionPerformed

    private void btnDeliverySubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliverySubmitActionPerformed
        // TODO add your handling code here:
        for (Resident resident : ecoSystem.getResidentDirectory().getResidentList()) {
            if (resident.getEmployeeId() == userAccount.getEmployee().getId()) {
                for (MerchandiseOrder m : resident.getMerchandiseOrderList()) {
                    if (m.toString().equals(merchandiseOrder.toString())) {
                        m.setPhoneNumber(txtDPhone.getText());
                        m.setLocation(txtADLocation.getText());
                        m.setStatus("Waiting for delivery");
                    }
                }
            }
        }
        DeliveryMerchandiseTable();
        JOptionPane.showMessageDialog(null, "Submit successfully!!");
        
        DeliveryInformation.setVisible(false);
        txtDPhone.setText("");
        txtADLocation.setText("");
    }//GEN-LAST:event_btnDeliverySubmitActionPerformed

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        // TODO add your handling code here:
        MerchandiseList.setVisible(false);
        MarketMenu.setVisible(true);
        Delivery.setVisible(false);
        OrderHistory.setVisible(false);

        DeliveryInformation.setVisible(false);
    }//GEN-LAST:event_jLabel102MouseClicked

    private void SPOrderViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPOrderViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = TableSpOrderList.getSelectedRow();

        if (selectedRow >= 0) {

            OInformation.setVisible(true);
            merchandiseOrder = (MerchandiseOrder) TableSpOrderList.getValueAt(selectedRow, 0);
            //txt
            txtDOrderID.setText(merchandiseOrder.toString());
            txtVDSupermarket.setText(merchandiseOrder.getMarketName());
            txtVDDeliveryman.setText(merchandiseOrder.getReceiver());
            HistoryDetailOrderTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Order.");
        }
    }//GEN-LAST:event_SPOrderViewActionPerformed

    private void jLabel100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseClicked
        // TODO add your handling code here:
        MerchandiseList.setVisible(false);
        MarketMenu.setVisible(true);
        Delivery.setVisible(false);
        OrderHistory.setVisible(false);

        OInformation.setVisible(false);
    }//GEN-LAST:event_jLabel100MouseClicked

    private void btnSLocationConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLocationConfirmActionPerformed
        // TODO add your handling code here:
        txtSecurityLocation.setText(txtSLocationSet.getText());
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(true);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        SetLocationS.setVisible(false);
    }//GEN-LAST:event_btnSLocationConfirmActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        PropertyMenu.setVisible(false);
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        Dailypayment.setVisible(false);
        SetLocationS.setVisible(true);
        
        BrowserUtil.setVersion(Version.V6_22);
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        map_panel.add(view, BorderLayout.CENTER);
        
        browser.loadURL("file:///D:/Courses/2020Fall/INFO5100/Aassignements/FinalProject/CommunityServiceSystem_2.2/test2.html");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel150MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel150MouseClicked
        // TODO add your handling code here:
        SecurityMenu.setVisible(false);
        SecurityRequest.setVisible(false);
        SecurityRequestHistory.setVisible(false);
        MaintenanceMenu.setVisible(false);
        Dailypayment.setVisible(false);
        MaintenanceRequest.setVisible(false);
        MaintenanceRequestHistory.setVisible(false);
        PropertyMenu.setVisible(true);
    }//GEN-LAST:event_jLabel150MouseClicked

    private void jLabel151MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel151MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel151MouseClicked

    private void jLabel154MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel154MouseClicked
        // TODO add your handling code here:
        SetLocationS.setVisible(false);
        SecurityRequest.setVisible(true);
    }//GEN-LAST:event_jLabel154MouseClicked

    private void btnSLocationConfirm2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLocationConfirm2ActionPerformed
        // TODO add your handling code here:
        ARTxtLocation.setText(txtHLocation.getText());
        HpMenu.setVisible(false);
        AmbulanceRequest.setVisible(true);
        RequestHistory.setVisible(false);
        SetLocationH.setVisible(false);
    }//GEN-LAST:event_btnSLocationConfirm2ActionPerformed

    private void btnAmbulanceLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbulanceLocationActionPerformed
        // TODO add your handling code here:
        HpMenu.setVisible(false);
        AmbulanceRequest.setVisible(false);
        RequestHistory.setVisible(false);
        SetLocationH.setVisible(true);

        BrowserUtil.setVersion(Version.V6_22);
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        map_panel2.add(view, BorderLayout.CENTER);
        
        browser.loadURL("file:///D:/Courses/2020Fall/INFO5100/Aassignements/FinalProject/CommunityServiceSystem_2.2/test2.html");
    }//GEN-LAST:event_btnAmbulanceLocationActionPerformed

    private void btnSLocationConfirm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSLocationConfirm1ActionPerformed
        // TODO add your handling code here:
        txtADLocation.setText(txtDLocation.getText());
        MarketMenu.setVisible(false);
        MerchandiseList.setVisible(false);
        Delivery.setVisible(true);
        OrderHistory.setVisible(false);
        SetLocationD.setVisible(false);
    }//GEN-LAST:event_btnSLocationConfirm1ActionPerformed

    private void btnLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationActionPerformed
        // TODO add your handling code here:
        MarketMenu.setVisible(false);
        MerchandiseList.setVisible(false);
        Delivery.setVisible(false);
        OrderHistory.setVisible(false);
        SetLocationD.setVisible(true);

        BrowserUtil.setVersion(Version.V6_22);
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        map_panel1.add(view, BorderLayout.CENTER);
        
        browser.loadURL("file:///D:/Courses/2020Fall/INFO5100/Aassignements/FinalProject/CommunityServiceSystem_2.2/test2.html");
    }//GEN-LAST:event_btnLocationActionPerformed
    
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
    private javax.swing.JButton AKBBtnApply;
    private javax.swing.JComboBox AKBComboSchoolBusList;
    private javax.swing.JTextField AKBTxtCapacity;
    private javax.swing.JTextField AKBTxtDriverName;
    private javax.swing.JTextField AKBTxtLiense;
    private javax.swing.JTextField AKBTxtReaminSeats;
    private javax.swing.JTable AKBtabApplication;
    private javax.swing.JTable AKBtabYourClass;
    private javax.swing.JButton AKBtnApply;
    private javax.swing.JButton AKBtnRefresh;
    private javax.swing.JTextField AKTxtEMail;
    private javax.swing.JTextField AKTxtKidAge;
    private javax.swing.JTextField AKTxtKidName;
    private javax.swing.JComboBox AKcomboKG;
    private javax.swing.JTable AKtabApplication;
    private javax.swing.JTable AKtabKClass;
    private javax.swing.JButton ARBtnSumit;
    private javax.swing.JComboBox ARComboReciever;
    private javax.swing.JComboBox ARComboUrgencyLevel;
    private javax.swing.JSpinner ARSpinnerInjuredNum;
    private javax.swing.JTextField ARTxtIncidentType;
    private javax.swing.JTextField ARTxtLocation;
    private javax.swing.JTextField ARTxtPhoneNum;
    private javax.swing.JTextArea ARtxtDesc;
    private javax.swing.JPanel AmbulanceRequest;
    private javax.swing.JLabel BackToProperty;
    private javax.swing.JComboBox<String> ComboxMProperty;
    private javax.swing.JComboBox<String> ComboxProperty;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JPanel Dailypayment;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel Delivery;
    private javax.swing.JPanel DeliveryInformation;
    private javax.swing.JPanel DeliveryJPanel;
    private javax.swing.JPanel DetailsJPanel;
    private javax.swing.JLabel HMouseClickARBack;
    private javax.swing.JTable HTabRequestHistory;
    private javax.swing.JPanel HospitalJPanel;
    private javax.swing.JPanel HospitalPanel;
    private javax.swing.JPanel HpMenu;
    private javax.swing.JPanel KdMenu;
    private javax.swing.JPanel KindergardenJPanel;
    private javax.swing.JPanel KindergardenPanel;
    private javax.swing.JPanel KindergartenApply;
    private javax.swing.JPanel MHDetailsJPanel;
    private javax.swing.JTextArea MHrequestDesc;
    private javax.swing.JTextField MHrequestName;
    private javax.swing.JTextField MHrequestType;
    private javax.swing.JTable MListTable;
    private javax.swing.JPanel MaintenanceMenu;
    private javax.swing.JPanel MaintenanceRequest;
    private javax.swing.JPanel MaintenanceRequestHistory;
    private javax.swing.JPanel ManageInformationPanel;
    private javax.swing.JPanel MarketJPanel;
    private javax.swing.JPanel MarketMenu;
    private javax.swing.JPanel MarketPanel;
    private javax.swing.JPanel MerchandiseList;
    private javax.swing.JPanel OInformation;
    private javax.swing.JTable OListTable;
    private javax.swing.JPanel OrderHistory;
    private javax.swing.JTable OrderInformationTable;
    private javax.swing.JPanel PropertyJPanel;
    private javax.swing.JPanel PropertyMenu;
    private javax.swing.JPanel PropertyPanel;
    private javax.swing.JPanel RequestHistory;
    private javax.swing.JPanel RequestListJPanel;
    private javax.swing.JPanel RequestListNull;
    private javax.swing.JPanel RequestListView;
    private javax.swing.JPanel SPOrderHistory;
    private javax.swing.JButton SPOrderView;
    private javax.swing.JPanel SecurityMenu;
    private javax.swing.JPanel SecurityRequest;
    private javax.swing.JPanel SecurityRequestHistory;
    private javax.swing.JPanel SetLocationD;
    private javax.swing.JPanel SetLocationH;
    private javax.swing.JPanel SetLocationS;
    private javax.swing.JPanel ShoolBusApply;
    private javax.swing.JTable TableDO;
    private javax.swing.JTable TableMRhistory;
    private javax.swing.JTable TableNotification;
    private javax.swing.JTable TablePayment;
    private javax.swing.JTable TableSecurityHistory;
    private javax.swing.JTable TableSpOrderList;
    private javax.swing.JTextArea TxtAreaDescription;
    private javax.swing.JButton btnAmbulanceLocation;
    private javax.swing.JButton btnAmbulanceRequest;
    private javax.swing.JButton btnAskDelivery;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelivery2;
    private javax.swing.JButton btnDeliverySubmit;
    private javax.swing.JButton btnHospital;
    private javax.swing.JButton btnKgApply;
    private javax.swing.JButton btnKindergarden;
    private javax.swing.JButton btnLocation;
    private javax.swing.JButton btnMDelivery;
    private javax.swing.JButton btnMList;
    private javax.swing.JButton btnMOrder;
    private javax.swing.JButton btnMR;
    private javax.swing.JButton btnMRHistory;
    private javax.swing.JButton btnMaintenance;
    private javax.swing.JButton btnMarkread;
    private javax.swing.JButton btnOLAdd;
    private javax.swing.JButton btnOLRemove;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnProperty;
    private javax.swing.JButton btnProperty1;
    private javax.swing.JButton btnRRSubmit;
    private javax.swing.JButton btnRepairmentHistoryView;
    private javax.swing.JButton btnSBApply;
    private javax.swing.JButton btnSLocationConfirm;
    private javax.swing.JButton btnSLocationConfirm1;
    private javax.swing.JButton btnSLocationConfirm2;
    private javax.swing.JButton btnSR;
    private javax.swing.JButton btnSRHistory;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSecurity;
    private javax.swing.JButton btnSecurityHistoryView;
    private javax.swing.JButton btnSecuritySubmit;
    private javax.swing.JButton btnSupermarket;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnphotoUpload;
    private javax.swing.JComboBox comboxMLevel;
    private javax.swing.JComboBox comboxSecurityLevel;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
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
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel labName1;
    private javax.swing.JLabel labPrice;
    private javax.swing.JLabel labTime;
    private javax.swing.JPanel map_panel;
    private javax.swing.JPanel map_panel1;
    private javax.swing.JPanel map_panel2;
    private javax.swing.JComboBox marketCombo;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JRadioButton rbtnSecurityGuar;
    private javax.swing.JTextField txtADLocation;
    private javax.swing.JTextField txtADOID;
    private javax.swing.JTextField txtApartment;
    private javax.swing.JTextField txtDLocation;
    private javax.swing.JTextField txtDOrderID;
    private javax.swing.JTextField txtDPhone;
    private javax.swing.JTextField txtDepartmentId;
    private javax.swing.JTextField txtEntLocation;
    private javax.swing.JTextField txtEntName;
    private javax.swing.JTextField txtHLocation;
    private javax.swing.JTextField txtIssueType;
    private javax.swing.JTextField txtKidAmount;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtSLocationSet;
    private javax.swing.JTextArea txtSecurityDesc;
    private javax.swing.JTextArea txtSecurityHistoryDesc;
    private javax.swing.JTextField txtSecurityHistoryGuardName;
    private javax.swing.JTextField txtSecurityHistoryRequestType;
    private javax.swing.JTextField txtSecurityLocation;
    private javax.swing.JTextField txtSecurityType;
    private javax.swing.JTextField txtUserAccount;
    private javax.swing.JTextField txtVDDeliveryman;
    private javax.swing.JTextField txtVDSupermarket;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables
}
