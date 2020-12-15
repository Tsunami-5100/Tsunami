/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KApplication;

import Business.KClass.KClass;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KApplicationDirectory {
    private ArrayList<KApplication> kApplicationList;

    public ArrayList<KApplication> getkApplicationList() {
        if (this.kApplicationList == null) {
            this.kApplicationList = new ArrayList<KApplication>();
        }
        return kApplicationList;
    }

    public void setkApplicationList(ArrayList<KApplication> kApplicationList) {
        this.kApplicationList = kApplicationList;
    }
    
}
