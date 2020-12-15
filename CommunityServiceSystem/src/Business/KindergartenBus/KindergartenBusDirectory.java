/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KindergartenBus;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KindergartenBusDirectory {
    private ArrayList<KindergartenBus> busList;

    public ArrayList<KindergartenBus> getBusList() {
        if (this.busList == null) {
            this.busList = new ArrayList<>();
        }
        return busList;
    }

    public void setBusList(ArrayList<KindergartenBus> busList) {
        this.busList = busList;
    }
    
}
