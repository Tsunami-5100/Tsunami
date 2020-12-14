/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author edmond
 */
public class MerchandiseOrder extends WorkRequest {

    private String MarketName;
    private int id;
    private static int count = 1;
    private String RequestTime;
    private String ResolveTime;
    private String PhoneNumber;
    private String Location;
    private ArrayList<Merchandise> merchandiseList;
    
    public MerchandiseOrder(){
        merchandiseList = new ArrayList<Merchandise>();
        id = count;
        count++;
    }

    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String MarketName) {
        this.MarketName = MarketName;
    }
    
    public ArrayList<Merchandise> getMerchandiseList() {
        if (this.merchandiseList == null) {
            this.merchandiseList = new ArrayList<Merchandise>();
        }
        return merchandiseList;
    }

    public void setMerchandiseList(ArrayList<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }
    
    public void removeMerchandise(Merchandise merchandise){
        merchandiseList.remove(merchandise);
    }
    
    public Merchandise addMerchandise(String name, int price ,int quantity){
        Merchandise merchandise = new Merchandise();
        merchandise.setName(name);
        merchandise.setQuantity(quantity);
        merchandise.setPrice(price);
        merchandiseList.add(merchandise);
        return merchandise;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
    @Override
    public String toString() {
        return Integer.toString(id);
    }
    
}
