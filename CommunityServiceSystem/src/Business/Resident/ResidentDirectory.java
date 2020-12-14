/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Resident;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class ResidentDirectory {
    private ArrayList<Resident> residentList;
    private ArrayList<UserAccount> residentAccountList;

    public ResidentDirectory() {
        residentList = new ArrayList();
        residentAccountList = new ArrayList();
    }    
    
    public ArrayList<Resident> getResidentList() {
        return residentList;
    }

    public  Resident addResident(int employeeId, String networkName, String fullname, String ssn, String email, String phoneNum) {
        Resident resident = new Resident();
        resident.setFullname(fullname);
        resident.setEmployeeId(employeeId);
        resident.setNetworkName(networkName);
        resident.setSsn(ssn);
        resident.setEmail(email);
        resident.setPhoneNum(phoneNum);
        residentList.add(resident);
        System.out.println("Business.Resident.ResidentDirectory.addResident() 40. " + resident.getNetworkName());
        return resident;
    }

    public ArrayList<UserAccount> getResidentAccountList() {
        return residentAccountList;
    }
    
    public UserAccount createResidentAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        residentAccountList.add(userAccount);
        return userAccount;       
    }
    
}
