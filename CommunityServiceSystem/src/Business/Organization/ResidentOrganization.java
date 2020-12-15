/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.RepairManRole;
import Business.Role.ResidentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class ResidentOrganization extends Organization{

    public ResidentOrganization() {
        super(Organization.Type.Resident.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RepairManRole());
        return roles;
    }
     
}