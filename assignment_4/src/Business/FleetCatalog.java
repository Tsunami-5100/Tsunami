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
    private List <Fleet> fleetList;
    
    public FleetCatalog(){
        fleetList = new ArrayList<Fleet>();
//        Fleet f = new Fleet(1 , 2);
//        fleetList.add(f);               
    }
    
    

    public List<Fleet> getFleetList() {
        return fleetList;
    }
   
    public Fleet addFleet(){
        Fleet a = new Fleet();
        fleetList.add(a);
        return a;
    }
    
    public void removeFleet(Fleet a){
        fleetList.remove(a);
    }
    
    public Fleet searchremoveFleet(int fleet){
        for(Fleet a : fleetList){
            if(a.getFleetId() == fleet){
                return a;
            }
        }
        return null;
    }
    
}
