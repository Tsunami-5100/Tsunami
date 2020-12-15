/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Market;

import java.util.ArrayList;

/**
 *
 * @author edmond
 */
public class MerchandiseDirectory {
    private ArrayList<Merchandise> merchandiseList;
    
    public MerchandiseDirectory(){
        merchandiseList = new ArrayList();
    }

    public Merchandise addMerchandise(){
        Merchandise merchandise = new Merchandise();
        merchandiseList.add(merchandise);
        return merchandise;
    }
    
    public Merchandise addMerchandise(Merchandise a){
        merchandiseList.add(a);
        return a;
    }
    
    public void removeMerchandise(Merchandise merchandise){
        merchandiseList.remove(merchandise);
    }

    public ArrayList<Merchandise> getMerchandiseList() {
        return merchandiseList;
    }

    public void setMerchandiseList(ArrayList<Merchandise> merchandiseList) {
        this.merchandiseList = merchandiseList;
    }

  
}
