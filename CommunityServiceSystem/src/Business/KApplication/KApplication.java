/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KApplication;

import Business.WorkQueue.WorkRequest;

/**
 *
 * @author Unicorn
 */
public class KApplication extends WorkRequest{
    private String kidName;
    private int kidAge;
    private String className;
    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public int getKidAge() {
        return kidAge;
    }

    public void setKidAge(int kidAge) {
        this.kidAge = kidAge;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return kidName;
    }

}
