/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.AmbulanceRequest.AmbulanceRequestDirectory;
import Business.Employee.EmployeeDirectory;
import Business.KApplication.KApplicationDirectory;
import Business.KBApplication.KBApplicationDirectory;
import Business.Message.MessageDirectory;
import Business.Resident.ResidentDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private ResidentDirectory residentDirectory;
    private KApplicationDirectory kAppicationDirectory;
    private AmbulanceRequestDirectory ambulanceRequestDirectory;
    private KBApplicationDirectory kBApplicationDirectory;
    private MessageDirectory messageList;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        BusDiver("Bus Organization"), 
        AmbulanceDriver("Emergency Organization"), 
        HospitalManager ("HospitalManagement Organization"),
        KindergartenManager("KindergartenManagement Organization"),
        RepairMan("Maintenance Organization"),
        MarketManager("MarketManagement Organization"),
        PropertyManager("PropertyManagement Organization"),
        Resident("Resident Organization"),
        Security("Security Organization"),
        Teacher("Teacher Organization"),
        DeliveryMan("Shipping Organization"),
        BillCollector("TollBooth Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        kAppicationDirectory = new KApplicationDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public ResidentDirectory getResidentDirectory() {
        if (this.residentDirectory == null) {
            this.residentDirectory = new ResidentDirectory();
        }
        return residentDirectory;
    }

    public void setResidentDirectory(ResidentDirectory residentDirectory) {
        this.residentDirectory = residentDirectory;
    }
     
    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public KApplicationDirectory getkAppicationDirectory() {
        if (this.kAppicationDirectory == null) {
            this.kAppicationDirectory = new KApplicationDirectory();
        }
        return kAppicationDirectory;
    }

    public void setkAppicationDirectory(KApplicationDirectory kAppicationDirectory) {
        this.kAppicationDirectory = kAppicationDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public AmbulanceRequestDirectory getAmbulanceRequestDirectory() {
        if (this.ambulanceRequestDirectory == null) {
            this.ambulanceRequestDirectory = new AmbulanceRequestDirectory();
        }
        return ambulanceRequestDirectory;
    }

    public void setAmbulanceRequestDirectory(AmbulanceRequestDirectory ambulanceRequestDirectory) {
        this.ambulanceRequestDirectory = ambulanceRequestDirectory;
    }

    public KBApplicationDirectory getkBApplicationDirectory() {
        if (this.kBApplicationDirectory == null) {
            this.kBApplicationDirectory = new KBApplicationDirectory();
        }
        return kBApplicationDirectory;
    }

    public void setkBApplicationDirectory(KBApplicationDirectory kBApplicationDirectory) {
        this.kBApplicationDirectory = kBApplicationDirectory;
    }
    
    public MessageDirectory getMessageList() {
        if(messageList == null){
            messageList = new MessageDirectory();
        }
        return messageList;
    }

    public void setMessageList(MessageDirectory messageList) {
        this.messageList = messageList;
    }
           
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
