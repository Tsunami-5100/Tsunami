/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.MaintenanceOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.RepairmanRole.RepairmanwWorkJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Unicorn
 */
public class RepairManRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new RepairmanwWorkJPanel(userProcessContainer, account, (MaintenanceOrganization)organization, enterprise, network, business);
    }
    
    
}
