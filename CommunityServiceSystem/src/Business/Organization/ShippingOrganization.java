/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DeliveryManRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class ShippingOrganization extends Organization{

    public ShippingOrganization() {
        super(Organization.Type.DeliveryMan.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeliveryManRole());
        return roles;
    }
     
   
    
    
}
