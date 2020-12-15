/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.KApplication.KApplication;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Resident.Resident;
import Business.Resident.ResidentDirectory;
import Business.UserAccount.UserAccount;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import Business.KApplication.KApplicationDirectory;

/**
 *
 * @author Unicorn
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }

    public EcoSystem() {
        super(null);
        this.networkList = networkList;
    }
    
//    
//    private EcoSystem(){
//        super(null);
//        networkList = new ArrayList<Network>();
//        kAppicationDirectory = new KApplicationDirectory();
//    }
    
    public Network createAndAddNetwork(){
        Network network = new Network();
        networkList.add(network);
        return network;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public ArrayList<Network> getNetworkList() {
        if (this.networkList == null) {
            this.networkList = new ArrayList<>();
        }
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
        
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
    
}
