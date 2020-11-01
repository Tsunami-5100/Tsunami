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
public class AirplaneCatalog {
    
    private List<Airplane> airplaneCatalog;
        
    public AirplaneCatalog(){
            airplaneCatalog = new ArrayList<Airplane>();
//            Airplane airp = new Airplane("A-11", "1", "1");
//            airplaneCatalog.add(airp);
    }
    
    
    public List<Airplane> getAirplaneCatalog() {
        return airplaneCatalog;
    }

    public void setAirplaneCatalog(List<Airplane> airplaneCatalog) {
        this.airplaneCatalog = airplaneCatalog;
    }
        
    
    public Airplane addAirplane(){
        Airplane a = new Airplane();
        airplaneCatalog.add(a);
        return a;
    }
    
    public void removeAirplane(Airplane a){
        airplaneCatalog.remove(a);
    }
    
    public Airplane searchAirplane(String id){
        for(Airplane a : airplaneCatalog){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
}
