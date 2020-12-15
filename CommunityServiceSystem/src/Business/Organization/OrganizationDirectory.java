/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.BusDiver.getValue())){
            organization = new BusOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.AmbulanceDriver.getValue())){
            organization = new EmergencyOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HospitalManager.getValue())){
            organization = new HospitalManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.KindergartenManager.getValue())){
            organization = new KindergartenManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.RepairMan.getValue())){
            organization = new MaintenanceOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.MarketManager.getValue())){
            organization = new MarketManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.PropertyManager.getValue())){
            organization = new PropertyManagementOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Resident.getValue())){
            organization = new ResidentOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Security.getValue())){
            organization = new SecurityOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DeliveryMan.getValue())){
            organization = new ShippingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Teacher.getValue())){
            organization = new TeacherOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.BillCollector.getValue())){
            organization = new TollBoothOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}