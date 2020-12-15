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
public class MerchandiseOrderList {

    private ArrayList<MerchandiseOrder> orderList;

    public MerchandiseOrderList() {
        orderList = new ArrayList<MerchandiseOrder>();
    }

    public MerchandiseOrder addOrder() {
        MerchandiseOrder order = new MerchandiseOrder();
        orderList.add(order);
        return order;
    }

    public MerchandiseOrder addOrder(MerchandiseOrder a) {
        orderList.add(a);
        return a;
    }

    public void removeMerchandise(MerchandiseOrder order) {
        orderList.remove(order);
    }

    public ArrayList<MerchandiseOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<MerchandiseOrder> orderList) {
        this.orderList = orderList;
    }

}
