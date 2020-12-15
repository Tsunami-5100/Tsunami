/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Property;

import Business.KApplication.*;
import Business.KClass.KClass;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class PaymentDirectory {
    private ArrayList<Payment> PaymentList;

    public ArrayList<Payment> getPaymentList() {
        return PaymentList;
    }

    public void setPaymentList(ArrayList<Payment> PaymentList) {
        this.PaymentList = PaymentList;
    }

}
