/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TeacherRole;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class KindergartenManagementOrganization extends Organization{
    public KindergartenManagementOrganization() {
        super(Organization.Type.KindergartenManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TeacherRole());
        return roles;
    }
    
}
