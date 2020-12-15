/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.KClass.KClass;
import Business.KindergartenStudent.KindergartenStudentDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KindergartenEnterprise extends Enterprise{
    
    private ArrayList<KClass> allClassList;
    private KindergartenStudentDirectory kindergartenStudentDirectory;

    public KindergartenEnterprise(String name) {
        super(name, EnterpriseType.Kindergarten);
        allClassList = new ArrayList<KClass>();
    }

    public ArrayList<KClass> getAllClassList() {
        if (this.allClassList == null) {
            this.allClassList = new ArrayList<KClass>();
        }
        return allClassList;
    }

    public void setAllClassList(ArrayList<KClass> allClassList) {
        this.allClassList = allClassList;
    }

    public KindergartenStudentDirectory getKindergartenStudentDirectory() {
        if (this.kindergartenStudentDirectory == null) {
            this.kindergartenStudentDirectory = new KindergartenStudentDirectory();
        }
        return kindergartenStudentDirectory;
    }

    public void setKindergartenStudentDirectory(KindergartenStudentDirectory kindergartenStudentDirectory) {
        this.kindergartenStudentDirectory = kindergartenStudentDirectory;
    }
       
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
