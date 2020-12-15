/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AmbulanceRequest;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class AmbulanceRequestDirectory {
    private ArrayList<AmbulanceRequest> ambulanceRequestList;

    public ArrayList<AmbulanceRequest> getAmbulanceRequestList() {
        if (this.ambulanceRequestList == null) {
            this.ambulanceRequestList = new ArrayList<>();
        }
        return ambulanceRequestList;
    }

    public void setAmbulanceRequestList(ArrayList<AmbulanceRequest> ambulanceRequestList) {
        this.ambulanceRequestList = ambulanceRequestList;
    }
    
}
