/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.PropertyAdminRole.PropertyAdminWorkPanel;
import javax.swing.JPanel;

/**
 *
 * @author Unicorn
 */
public class PropertyManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new PropertyAdminWorkPanel(userProcessContainer, account, organization, enterprise, business);
    }

    
    
}
