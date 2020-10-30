/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edmond
 */
public class CustomerDirectory {
    
    private List<Customer> customerDirectory;
       
    public CustomerDirectory(){
        customerDirectory =  new ArrayList<Customer>();
    }  

    public List<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(List<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
}
