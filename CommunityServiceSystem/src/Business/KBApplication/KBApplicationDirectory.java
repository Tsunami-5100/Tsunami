/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KBApplication;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KBApplicationDirectory {
    private ArrayList<KBApplication> kBApplicationList;

    public ArrayList<KBApplication> getkBApplicationList() {
        if (this.kBApplicationList == null) {
            this.kBApplicationList = new ArrayList<>();
        }
        return kBApplicationList;
    }

    public void setkBApplicationList(ArrayList<KBApplication> kBApplicationList) {
        this.kBApplicationList = kBApplicationList;
    }
}
