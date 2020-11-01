/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Unicorn
 */
public class AirlinerCatalog {
    private List<Airliner> airlinerList;

    public AirlinerCatalog() {
        
        airlinerList = new ArrayList<Airliner>();
//        Airliner a = new Airliner("a");
//        airlinerList.add(a);
    }

    public List<Airliner> getAirlinerList() {
        return airlinerList;
    }
    
     public Airliner addAirliner(){
        Airliner a = new Airliner();
        airlinerList.add(a);
        return a;
    }
    
    public void removeAirliner(Airliner a){
        airlinerList.remove(a);
    }
    
    public Airliner searchAirliner(String keyword){
        for (Airliner airliner : airlinerList) {
            if(airliner.getAirlineName().equals(keyword)){
                return airliner;
            }
        }
        return null;
    }
    
}
