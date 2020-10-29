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
 * @author edmond
 */
public class AirlinerCatalog {
    private List <Airliner> airlinerCatalog;
    
    public AirlinerCatalog(){
        airlinerCatalog = new ArrayList<Airliner>();
    }

    public List<Airliner> getAirlinerCatalog() {
        return airlinerCatalog;
    }
   
    public Airliner addAirliner(){
        Airliner a = new Airliner();
        airlinerCatalog.add(a);
        return a;
    }
    
    public void removeAirliner(Airliner a){
        airlinerCatalog.remove(a);
    }
    
    public Airliner searchAirliner(String fleet){
        for(Airliner a : airlinerCatalog){
            if(a.getFleet() == fleet){
                return a;
            }
        }
        return null;
    }
    
}
