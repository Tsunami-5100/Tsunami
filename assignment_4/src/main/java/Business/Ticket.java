/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author edmond
 */
public class Ticket {
    private String location;
    private String rowNum;
    private String price;
    private String orderStaus;
    private String orderPeople;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderStaus() {
        return orderStaus;
    }

    public void setOrderStaus(String orderStaus) {
        this.orderStaus = orderStaus;
    }

    public String getOrderPeople() {
        return orderPeople;
    }

    public void setOrderPeople(String orderPeople) {
        this.orderPeople = orderPeople;
    }

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }
    
    public Ticket(String rowNum, String location, String price,String orderStaus, String orderPeople){
        this.location = location;
        this.orderPeople = orderPeople;
        this.orderStaus = orderStaus;
        this.price = price;
        this.rowNum = rowNum;
    }
      public String toString(){
            return rowNum;
        }
}
