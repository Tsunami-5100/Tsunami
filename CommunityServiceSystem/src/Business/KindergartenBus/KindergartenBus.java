/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.KindergartenBus;

/**
 *
 * @author Unicorn
 */
public class KindergartenBus {
    private String kindergartenName;
    private String licenseNum;
    private int capacity;
    private int studentNum;
    private int remainSeats;
    private String driverName;
    private int driverId;
    private String driverUsername;
    
    public int busStudentNum = 0;

    public String getKindergartenName() {
        return kindergartenName;
    }

    public void setKindergartenName(String kindergartenName) {
        this.kindergartenName = kindergartenName;
    }
    
    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getRemainSeats() {
        return remainSeats;
    }

    public void setRemainSeats(int remainSeats) {
        this.remainSeats = remainSeats;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }    
    
    public int getBusStudentNum() {
        return busStudentNum;
    }

    public void setBusStudentNum(int busStudentNum) {
        this.busStudentNum = busStudentNum;
    }
    
    @Override
    public String toString() {
        return licenseNum;
    }  
    
}
