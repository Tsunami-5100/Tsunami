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
public class KAppicationDirectory {
    private ArrayList<KApplication> kApplicationList;

    public ArrayList<KApplication> getkApplicationList() {
        return kApplicationList;
    }

    public void setkApplicationList(ArrayList<KApplication> kApplicationList) {
        this.kApplicationList = kApplicationList;
    }
    
}
