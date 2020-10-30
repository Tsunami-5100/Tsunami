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
public class Fleet {
    private int fleetId;
    private int airplaneNum;
    private AirplaneCatalog airplaneCatalog;
    
    public Fleet(){
        airplaneCatalog = new AirplaneCatalog();
    }
    public Fleet(int fleetID, int airplaneNum){
        this.fleetId = fleetId;
        this.airplaneNum = airplaneNum;
    }

    public int getFleetId() {
        return fleetId;
    }

    public void setFleetId(int fleetId) {
        this.fleetId = fleetId;
    }

    public int getAirplaneNum() {
        return airplaneNum;
    }

    public void setAirplaneNum(int airplaneNum) {
        this.airplaneNum = airplaneNum;
    }
    

    public AirplaneCatalog getAirplaneCatalog() {
        return airplaneCatalog;
    }

    public void setAirplaneCatalog(AirplaneCatalog airplaneCatalog) {
        this.airplaneCatalog = airplaneCatalog;
    }

    
}
