/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Unicorn
 */
public class Employee {
    
    private String name;
    private int id;
    private static int count = 1;
    private ArrayList<Integer> subIdList = new ArrayList<>();

    public Employee() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getSubIdList() {
        if (this.subIdList == null) {
            this.subIdList = new ArrayList<>();
        }
        return subIdList;
    }

    public void setSubIdList(ArrayList<Integer> subIdList) {
        this.subIdList = subIdList;
    }

    @Override
    public String toString() {
        return '{' + name + id + '}';
    }   
    
}
