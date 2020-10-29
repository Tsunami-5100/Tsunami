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
public class Business {
    private AirlinerCatalog airlinerCatalog;
    private CustomerDirectory customerDirectory;
    private AirplaneCatalog airplaneCatalog;
    private FlightCatalog flightCatalog;
    private TicketCatalog ticketCatalog;
    
    public Business(){
        airlinerCatalog = new AirlinerCatalog();
        customerDirectory = new CustomerDirectory();
        airplaneCatalog = new AirplaneCatalog();
        flightCatalog = new FlightCatalog();
        ticketCatalog = new TicketCatalog();
    }
    
    public AirlinerCatalog getAirlinerCatalog() {
        return airlinerCatalog;
    }
    
    public void setAirlinerCatalog(AirlinerCatalog airlinerCatalog) {
        this.airlinerCatalog = airlinerCatalog;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public AirplaneCatalog getAirplaneCatalog() {
        return airplaneCatalog;
    }

    public void setAirplaneCatalog(AirplaneCatalog airplaneCatalog) {
        this.airplaneCatalog = airplaneCatalog;
    }

    public FlightCatalog getFlightCatalog() {
        return flightCatalog;
    }

    public void setFlightCatalog(FlightCatalog flightCatalog) {
        this.flightCatalog = flightCatalog;
    }

    public TicketCatalog getTicketCatalog() {
        return ticketCatalog;
    }

    public void setTicketCatalog(TicketCatalog ticketCatalog) {
        this.ticketCatalog = ticketCatalog;
    }
    
    
}
