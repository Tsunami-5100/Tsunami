/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Property;

import Business.WorkQueue.WorkRequest;

/**
 *
 * @author edmond
 */
public class SRRequest extends WorkRequest {

    private String type;
    private String Location;
    private String Level;
    private String description;
    private String RequestType;
    private String RequestTime;
    private String ResolveTime;
    private String apartmentNum;
    private String propertyName;
    private int id;
    private static int count = 1;
    
    public SRRequest(){
        id = count;
        count++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String RequestType) {
        this.RequestType = RequestType;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public void setRequestTime(String RequestTime) {
        this.RequestTime = RequestTime;
    }

    public String getResolveTime() {
        return ResolveTime;
    }

    public void setResolveTime(String ResolveTime) {
        this.ResolveTime = ResolveTime;
    }

    public String getApartmentNum() {
        return apartmentNum;
    }

    public void setApartmentNum(String apartmentNum) {
        this.apartmentNum = apartmentNum;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    
    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
