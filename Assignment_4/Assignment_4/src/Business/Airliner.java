/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.List;

/**
 *
 * @author Unicorn
 */
public class Airliner {
    
    private String AirlineName;
    public FleetCatalog fleetCatalog;

    public Airliner() {
       fleetCatalog = new FleetCatalog();
    }

    public Airliner(String AirlineName) {
        this.AirlineName = AirlineName;
    }
    
    
    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String AirlineName) {
        this.AirlineName = AirlineName;
    }

    public FleetCatalog getFleetCatalog() {
        return fleetCatalog;
    }

    public void setFleetCatalog(FleetCatalog fleetCatalog) {
        this.fleetCatalog = fleetCatalog;
    }    

    @Override
    public String toString() {
        return AirlineName;
    }
    
    
}
