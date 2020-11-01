/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author edmond
 */
public class Flight {
    private String flightNumber;
    private String departureLocation;
    private String arrivalLocation;
    private String dateofDay;
    private String time;
    private TicketCatalog ticketCatalog;
    
    public int count = 150;

    public Flight(){
    ticketCatalog = new TicketCatalog();
    }

    public Flight(String flightNumber, String departureLocation, String arrivalLocation, String dateofDay, String time) {
        this.flightNumber = flightNumber;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.dateofDay = dateofDay;
        this.time = time;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
         
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getDateofDay() {
        return dateofDay;
    }

    public void setDateofDay(String dateofDay) {
        this.dateofDay = dateofDay;
    }

    public TicketCatalog getTicketCatalog() {
        return ticketCatalog;
    }

    public void setTicketCatalog(TicketCatalog ticketCatalog) {
        this.ticketCatalog = ticketCatalog;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String toString(){
            return flightNumber;
        }
}
