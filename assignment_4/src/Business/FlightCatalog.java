/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edmond
 */
public class FlightCatalog {
    
    private List<Flight> flightCatalog;
    
    public FlightCatalog(){
        flightCatalog = new ArrayList<Flight>();
//        Flight t = new Flight("1" , "s", "b", "1/1/1", "morning");
//        flightCatalog.add(t);
    }

    public List<Flight> getFlightCatalog() {
        return flightCatalog;
    }

    public void setFlightCatalog(List<Flight> flightCatalog) {
        this.flightCatalog = flightCatalog;
    }
    
    
    public Flight addFlight(){
        Flight a = new Flight();
        flightCatalog.add(a);
        return a;
    }
    
    public void removeFlight(Flight a){
        flightCatalog.remove(a);
    }
    
    public Flight searchFlight(String flightNumber){
        for(Flight a : flightCatalog){
            if(a.getFlightNumber()== flightNumber){
                return a;
            }
        }
        return null;
    }

    public void addFlight(Flight flight) {
        flightCatalog.add(flight);
    }
}
