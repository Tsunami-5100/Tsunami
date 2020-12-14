/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Property;

import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Unicorn
 */
public class Payment extends WorkRequest {

    private int amount;
    private String type;
    private String Phone;
    private String RequestTime;
    private String ResolveTime;
    private int id;
    private static int count = 1;
    
    public Payment(){
        id = count;
        count++;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public void setRequestTime(String RequestTime) {
        this.RequestTime = RequestTime;
    }

    public String getResolveTime() {
        return ResolveTime;
    }

    public void setResolveTime(String ResolveTime) {
        this.ResolveTime = ResolveTime;
    }
    
    @Override
    public String toString() {
        return Integer.toString(id);
    }

}
