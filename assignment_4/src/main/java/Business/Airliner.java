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
public class Airliner {
    private String Fleet;
    private String travelAgency;
    private AirplaneCatalog airplaneCatalog;
    
    public Airliner(){
        airplaneCatalog = new AirplaneCatalog();
    }
    public Airliner(String Fleet, String travelAgency){
        this.Fleet = Fleet;
        this.travelAgency = travelAgency;
    }
    
    public String getFleet() {
        return Fleet;
    }

    public void setFleet(String Fleet) {
        this.Fleet = Fleet;
    }

    public String getTravelAgency() {
        return travelAgency;
    }

    public void setTravelAgency(String travelAgency) {
        this.travelAgency = travelAgency;
    }

    public AirplaneCatalog getAirplaneCatalog() {
        return airplaneCatalog;
    }

    public void setAirplaneCatalog(AirplaneCatalog airplaneCatalog) {
        this.airplaneCatalog = airplaneCatalog;
    }
    
    public String toString(){
        return Fleet;
    }
    
    
}
