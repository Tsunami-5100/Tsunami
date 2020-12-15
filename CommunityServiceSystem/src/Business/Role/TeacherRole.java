/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.TeacherOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.TeacherRole.TeacherWorkJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Unicorn
 */
public class TeacherRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new TeacherWorkJPanel(userProcessContainer, account, (TeacherOrganization)organization, enterprise, network, business);
    }   
}
