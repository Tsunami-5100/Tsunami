/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KindergartenStudent;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KindergartenStudentDirectory {
    private ArrayList<KindergartenStudent> kindergartenStudentList;

    public ArrayList<KindergartenStudent> getKindergartenStudentList() {
        if(this.kindergartenStudentList == null) {
            this.kindergartenStudentList = new ArrayList<>();
        }
        return kindergartenStudentList;
    }

    public void setKindergartenStudentList(ArrayList<KindergartenStudent> kindergartenStudentList) {
        this.kindergartenStudentList = kindergartenStudentList;
    }
    
}
