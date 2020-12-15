/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Resident;

import Business.Market.MerchandiseOrder;
import Business.Property.Payment;
import Business.Property.SRRequest;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class Resident {
    private int employeeId;
    private String networkName;
    private String fullname;
    private String ssn;
    private String email;
    private String phoneNum;
    private String username;
    private String password;
    private ArrayList<Payment> paymentList; 
    private ArrayList<MerchandiseOrder> merchandiseOrderList;
    private ArrayList<SRRequest> SRRequestList;

    public Resident() {
        this.paymentList = new ArrayList<>();
        this.merchandiseOrderList = new ArrayList<>();
        this.SRRequestList = new ArrayList<>();
    }
    
    
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
   
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
    
    public ArrayList<Payment> getPaymentList() {
        if(paymentList == null){
            paymentList = new ArrayList<Payment>();
        }
        return paymentList;
    }

    public void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public ArrayList<MerchandiseOrder> getMerchandiseOrderList() {
        if(merchandiseOrderList == null){
            merchandiseOrderList = new ArrayList<>();
        }
        return merchandiseOrderList;
    }

    public void setMerchandiseOrderList(ArrayList<MerchandiseOrder> merchandiseOrderList) {
        this.merchandiseOrderList = merchandiseOrderList;
    }

    public ArrayList<SRRequest> getSRRequestList() {
        if(this.SRRequestList == null) {
            this.SRRequestList = new ArrayList<>();
        }
        return SRRequestList;
    }

    public void setSRRequestList(ArrayList<SRRequest> SRRequestList) {
        this.SRRequestList = SRRequestList;
    }

    @Override
    public String toString() {
        return fullname;
    }
       
}
