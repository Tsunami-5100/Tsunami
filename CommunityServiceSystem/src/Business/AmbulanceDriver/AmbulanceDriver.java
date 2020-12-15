/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AmbulanceDriver;

/**
 *
 * @author Unicorn
 */
public class AmbulanceDriver {
    private int employeeId;
    private String availability;

//    public AmbulanceDriver(int employeeId, String availability) {
//        this.employeeId = employeeId;
//        this.availability = availability;
//    }

    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
}
