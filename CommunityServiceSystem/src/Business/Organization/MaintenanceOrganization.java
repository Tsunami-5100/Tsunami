/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.TeacherRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class MaintenanceOrganization extends Organization{

    public MaintenanceOrganization() {
        super(Organization.Type.RepairMan.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TeacherRole());
        return roles;
    }
    
}
