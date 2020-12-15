/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.AmbulanceDriver.AmbulanceDriverDirectoy;
import Business.AmbulanceRequest.AmbulanceRequest;
import Business.Employee.Employee;
import Business.KBApplication.KBApplicationDirectory;
import Business.KClass.KClass;
import Business.KindergartenBus.KindergartenBusDirectory;
import Business.KindergartenStudent.KindergartenStudentDirectory;
import Business.Market.MerchandiseOrder;
import Business.Property.Payment;
import Business.Property.SRRequest;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author raunak
 */
public class UserAccount {
//    private String 
    private String username;
    private String name;
    private String password;
    private Employee employee;
    private String emails;
    private String Phone;
    private Role role;
    private WorkQueue workQueue;
    private ArrayList<KClass> classList;
    private ArrayList<AmbulanceRequest> ambulanceRequestList;
    private AmbulanceDriverDirectoy ambulanceDriverDirectoy;
    private KindergartenBusDirectory kindergartenBusDirectory;
    private KBApplicationDirectory kBApplicationDirectory;
    private KindergartenStudentDirectory kindergartenStudentDirectory;
    private ArrayList<MerchandiseOrder> merchandiseOrderList;
    private ArrayList<SRRequest> SRRequestList;
    private ArrayList<Payment> PaymentList;
    private ImageIcon myimage;
    
    public UserAccount() {
        workQueue = new WorkQueue();
        classList = new ArrayList<>();
        ambulanceRequestList = new ArrayList<>();
        merchandiseOrderList = new ArrayList<MerchandiseOrder>();
        SRRequestList = new ArrayList<SRRequest>();
        PaymentList = new ArrayList<Payment>();
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public ArrayList<KClass> getClassList() {
        if (this.classList == null) {
            this.classList = new ArrayList<>();
        }
        
        return classList;
    }

    public void setClassList(ArrayList<KClass> classList) {
        this.classList = classList;
    }   

    public ArrayList<AmbulanceRequest> getAmbulanceRequestList() {
        if (this.ambulanceRequestList == null) {
            this.ambulanceRequestList = new ArrayList<AmbulanceRequest>();
        }
        return ambulanceRequestList;
    }

    public void setAmbulanceRequestList(ArrayList<AmbulanceRequest> ambulanceRequestList) {
        this.ambulanceRequestList = ambulanceRequestList;
    }

    public AmbulanceDriverDirectoy getAmbulanceDriverDirectoy() {
        if (this.ambulanceDriverDirectoy == null) {
            this.ambulanceDriverDirectoy = new AmbulanceDriverDirectoy();
        }
        return ambulanceDriverDirectoy;
    }

    public void setAmbulanceDriverDirectoy(AmbulanceDriverDirectoy ambulanceDriverDirectoy) {
        this.ambulanceDriverDirectoy = ambulanceDriverDirectoy;
    }

    public KindergartenBusDirectory getKindergartenBusDirectory() {
        if (this.kindergartenBusDirectory == null) {
            this.kindergartenBusDirectory = new KindergartenBusDirectory();
        }
        return kindergartenBusDirectory;
    }

    public void setKindergartenBusDirectory(KindergartenBusDirectory kindergartenBusDirectory) {
        this.kindergartenBusDirectory = kindergartenBusDirectory;
    }

    public KBApplicationDirectory getkBApplicationDirectory() {
        if (this.kBApplicationDirectory==null) {
            kBApplicationDirectory = new KBApplicationDirectory();
        }
        return kBApplicationDirectory;
    }

    public void setkBApplicationDirectory(KBApplicationDirectory kBApplicationDirectory) {
        this.kBApplicationDirectory = kBApplicationDirectory;
    }

    public KindergartenStudentDirectory getKindergartenStudentDirectory() {
        if (this.kindergartenStudentDirectory == null) {
            this.kindergartenStudentDirectory = new KindergartenStudentDirectory();
        }
        return kindergartenStudentDirectory;
    }

    public void setKindergartenStudentDirectory(KindergartenStudentDirectory kindergartenStudentDirectory) {
        this.kindergartenStudentDirectory = kindergartenStudentDirectory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public ImageIcon getMyimage() {
        return myimage;
    }

    public void setMyimage(ImageIcon myimage) {
        this.myimage = myimage;
    }

    public ArrayList<MerchandiseOrder> getMerchandiseOrderList() {
        return merchandiseOrderList;
    }

    public void setMerchandiseOrderList(ArrayList<MerchandiseOrder> merchandiseOrderList) {
        this.merchandiseOrderList = merchandiseOrderList;
    }

    public ArrayList<SRRequest> getSRRequestList() {
        return SRRequestList;
    }

    public void setSRRequestList(ArrayList<SRRequest> SRRequestList) {
        this.SRRequestList = SRRequestList;
    }

    public ArrayList<Payment> getPaymentList() {
        return PaymentList;
    }

    public void setPaymentList(ArrayList<Payment> PaymentList) {
        this.PaymentList = PaymentList;
    }
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}