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

    private String rowNum;
    private String ColumnNum;
    private String location;
    private String price;

    public Ticket(String rowNum, String ColumnNum, String location, String price) {
        this.rowNum = rowNum;
        this.ColumnNum = ColumnNum;
        this.location = location;
        this.price = price;
    }
    
    
    
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

    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getColumnNum() {
        return ColumnNum;
    }

    public void setColumnNum(String ColumnNum) {
        this.ColumnNum = ColumnNum;
    }
      
    @Override
    public String toString() {
        return rowNum;
    }

      
}
