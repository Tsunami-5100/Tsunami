/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Market.Merchandise;
import Business.Market.MerchandiseDirectory;
import Business.Market.MerchandiseOrder;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class MarketEnterprise extends Enterprise{
    
    private ArrayList<Merchandise> merchandiseList;
    private ArrayList<MerchandiseOrder> merchandiseOrderList;
    
    public MarketEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Market);
        merchandiseList = new ArrayList<Merchandise>();
        merchandiseOrderList = new ArrayList<MerchandiseOrder>();
    }

    public ArrayList<Merchandise> getMerchandiseList() {
        if (this.merchandiseList == null) {
            this.merchandiseList = new ArrayList<Merchandise>();
        }
        return merchandiseList;
    }

    public void setMerchandiseList(ArrayList<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }
    
    public void removeMerchandise(Merchandise merchandise){
        merchandiseList.remove(merchandise);
    }

    public ArrayList<MerchandiseOrder> getMerchandiseOrderList() {
        return merchandiseOrderList;
    }

    public void setMerchandiseOrderList(ArrayList<MerchandiseOrder> merchandiseOrderList) {
        this.merchandiseOrderList = merchandiseOrderList;
    }
 
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
