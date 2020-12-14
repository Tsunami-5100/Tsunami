/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Property.Payment;
import Business.Property.SRRequest;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class PropertyEnterprise extends Enterprise{
    
    private ArrayList<Payment> paymentList;
    private ArrayList<SRRequest> SRRrequestList;
    
    public PropertyEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Property);
        paymentList = new ArrayList<Payment>();
        SRRrequestList = new ArrayList<SRRequest>();
    }

    public ArrayList<Payment> getPaymentList() {
        if (this.paymentList == null) {
            this.paymentList = new ArrayList<Payment>();
        }
        return paymentList;
    }

    public void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public ArrayList<SRRequest> getSRRrequestList() {
       if (this.SRRrequestList == null) {
            this.SRRrequestList = new ArrayList<SRRequest>();
        }
        return SRRrequestList;
    }

    public void setSRRrequestList(ArrayList<SRRequest> SRRrequestList) {
        this.SRRrequestList = SRRrequestList;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
