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
public class Customer {
    private String Name;
    private String SSN;
    private FlightCatalog flightCatalog;
    
    public Customer(){
        flightCatalog = new FlightCatalog();
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public FlightCatalog getFlightCatalog() {
        return flightCatalog;
    }

    public void setFlightCatalog(FlightCatalog flightCatalog) {
        this.flightCatalog = flightCatalog;
    }
    
    @Override
    public String toString() {
        return Name;
    }
}
