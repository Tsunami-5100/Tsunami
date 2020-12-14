/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ShippingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DeliveryManRole.DeliveryManWorkJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Unicorn
 */
public class DeliveryManRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new DeliveryManWorkJPanel(userProcessContainer, account, (ShippingOrganization)organization, enterprise, network, business);
    }    
}
