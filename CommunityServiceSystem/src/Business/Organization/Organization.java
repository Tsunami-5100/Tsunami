/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.KApplication.KAppicationDirectory;
import Business.Message.Message;
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
    private KAppicationDirectory kAppicationDirectory;
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
        kAppicationDirectory = new KAppicationDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public ResidentDirectory getResidentDirectory() {
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

    public KAppicationDirectory getkAppicationDirectory() {
        return kAppicationDirectory;
    }

    public void setkAppicationDirectory(KAppicationDirectory kAppicationDirectory) {
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
