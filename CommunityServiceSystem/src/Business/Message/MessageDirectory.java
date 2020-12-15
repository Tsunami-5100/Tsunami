/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Message;

import java.util.ArrayList;

/**
 *
 * @author edmond
 */
public class MessageDirectory {
    private ArrayList<Message> MessageList;
    
    public MessageDirectory(){
        MessageList = new ArrayList();
    }

    public ArrayList<Message> getMessageList() {
        return MessageList;
    }

    public void setMessageList(ArrayList<Message> MessageList) {
        this.MessageList = MessageList;
    }
}
