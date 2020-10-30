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
public class FleetCatalog {
    private List <Fleet> fleetCatalog;
    
    public FleetCatalog(){
        fleetCatalog = new ArrayList<Fleet>();
    }

    public List<Fleet> getAirlinerCatalog() {
        return fleetCatalog;
    }
   
    public Fleet addFleet(){
        Fleet a = new Fleet();
        fleetCatalog.add(a);
        return a;
    }
    
    public void removeAirliner(Fleet a){
        fleetCatalog.remove(a);
    }
    
    public Fleet searchAirliner(int fleet){
        for(Fleet a : fleetCatalog){
            if(a.getFleetId() == fleet){
                return a;
            }
        }
        return null;
    }
    
}
