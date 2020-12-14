/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Child.Child;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Role.HospitalManagerRole;
import Business.KClass.KClass;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String name;
    private String password;
    private String emails;
    private String Phone;
    private String workArea;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private ArrayList<KClass> classList;
    private ArrayList<Child> childList; 
    private ImageIcon myimage;
    
    public UserAccount() {
        workQueue = new WorkQueue();
        classList = new ArrayList<KClass>();
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
            this.classList = new ArrayList<KClass>();
        }
        
        return classList;
    }

    public void setClassList(ArrayList<KClass> classList) {
        this.classList = classList;
    }

    public ArrayList<Child> getChildList() {
        
        if (this.childList == null) {
            this.childList = new ArrayList<Child>();
        }
        
        return childList;
    }

    public void setChildList(ArrayList<Child> childList) {
        this.childList = childList;
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
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}