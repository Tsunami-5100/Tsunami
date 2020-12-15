/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AmbulanceDriver;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class AmbulanceDriverDirectoy {
    private ArrayList<AmbulanceDriver> ambulanceDriverList;

    public ArrayList<AmbulanceDriver> getAmbulanceDriverList() {
        if (this.ambulanceDriverList == null) {
            this.ambulanceDriverList = new ArrayList<>();
        }
        return ambulanceDriverList;
    }

    public void setAmbulanceDriverList(ArrayList<AmbulanceDriver> ambulanceDriverList) {
        this.ambulanceDriverList = ambulanceDriverList;
    }
    
    public  AmbulanceDriver addAmbulanceDriver(int emplyeeId, String availability) {
        AmbulanceDriver ad = new AmbulanceDriver();
        ad.setEmployeeId(emplyeeId);
        ad.setAvailability(availability);
        if (this.ambulanceDriverList == null) {
            this.ambulanceDriverList = new ArrayList<>();
        }
        ambulanceDriverList.add(ad);
        return ad;
    }
}
