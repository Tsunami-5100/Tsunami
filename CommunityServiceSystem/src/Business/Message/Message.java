/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Message;

/**
 *
 * @author edmond
 */
public class Message {
    private String RequestDate;
    private String Content;
    private String Receiver;
    
    public String getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(String RequestDate) {
        this.RequestDate = RequestDate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }
    
    @Override
    public String toString(){
        return Content;
    }
}
