/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PropertyManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class PropertyManagementOrganization extends Organization {

    public PropertyManagementOrganization() {
        super(Organization.Type.PropertyManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PropertyManagerRole());
        return roles;
    }

}
