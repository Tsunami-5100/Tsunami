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
public class Airplane {
    private String model;
    private String id;
    private String manufacturedYear;
    private int flightNum;
    

    
    private FlightCatalog flightCatalog;
    
    
    public Airplane(){
        flightCatalog = new FlightCatalog();
    }
    
    public Airplane(String model, String id, String manufacturedYear){
        this.model = model;
        this.id = id;
        this.manufacturedYear = manufacturedYear;
            
    }
 
    
    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }
    
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public FlightCatalog getFlightCatalog() {
        return flightCatalog;
    }

    public void setFlightCatalog(FlightCatalog flightCatalog) {
        this.flightCatalog = flightCatalog;
    }
     public String toString(){
        return id;
    }
}
