/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edmond
 */
public class TicketCatalog {
    private ArrayList<Ticket> ticketCatalog;
    
    public TicketCatalog(){
        ticketCatalog = new ArrayList<Ticket>();
    }
    
    public void removeTicket(Ticket t){
        System.out.println("TicketCata: 23."+ticketCatalog.get(0));
        System.out.println("TicketCata: 24."+ticketCatalog.contains(t));
        ticketCatalog.remove(t);
        System.out.println("TicketCata: 25."+ticketCatalog.contains(t));
        System.out.println("TicketCata: 26."+ticketCatalog.get(0));
    }

    public ArrayList<Ticket> getTicketCatalog() {
        Ticket ticket1 = new Ticket("1","1","Window","1000");
        Ticket ticket2 = new Ticket("1","1","Middle","1000");
        Ticket ticket3 = new Ticket("1","1","Aisle","1000");
        Ticket ticket4 = new Ticket("1","2","Window","1000");
        Ticket ticket5 = new Ticket("1","2","Middle","1000");
        Ticket ticket6 = new Ticket("1","2","Aisle","1000");
        Ticket ticket7 = new Ticket("1","3","Window","1000");
        Ticket ticket8 = new Ticket("1","3","Middle","1000");
        Ticket ticket9 = new Ticket("1","3","Aisle","1000");
        Ticket ticket10 = new Ticket("1","4","Window","1000");
        Ticket ticket11 = new Ticket("1","4","Middle","1000");
        Ticket ticket12 = new Ticket("1","4","Aisle","1000");
        Ticket ticket13 = new Ticket("1","5","Window","1000");
        Ticket ticket14 = new Ticket("1","5","Middle","1000");
        Ticket ticket15 = new Ticket("1","5","Aisle","1000");
        Ticket ticket16 = new Ticket("1","6","Window","1000");
        Ticket ticket17 = new Ticket("1","6","Middle","1000");
        Ticket ticket18 = new Ticket("1","6","Aisle","1000");
        Ticket ticket19 = new Ticket("1","7","Window","1000");
        Ticket ticket20 = new Ticket("1","7","Middle","1000");
        Ticket ticket21 = new Ticket("1","7","Aisle","1000");
        Ticket ticket22 = new Ticket("1","8","Window","1000");
        Ticket ticket23 = new Ticket("1","8","Middle","1000");
        Ticket ticket24 = new Ticket("1","8","Aisle","1000");
        Ticket ticket25 = new Ticket("1","9","Window","1000");
        Ticket ticket26 = new Ticket("1","9","Middle","1000");
        Ticket ticket27 = new Ticket("1","9","Aisle","1000");
        Ticket ticket28 = new Ticket("1","10","Window","1000");
        Ticket ticket29 = new Ticket("1","10","Middle","1000");
        Ticket ticket30 = new Ticket("1","10","Aisle","1000");
        Ticket ticket31 = new Ticket("1","11","Window","1000");
        Ticket ticket32 = new Ticket("1","11","Middle","1000");
        Ticket ticket33 = new Ticket("1","11","Aisle","1000");
        Ticket ticket34 = new Ticket("1","12","Window","1000");
        Ticket ticket35 = new Ticket("1","12","Middle","1000");
        Ticket ticket36 = new Ticket("1","12","Aisle","1000");
        Ticket ticket37 = new Ticket("1","13","Window","1000");
        Ticket ticket38 = new Ticket("1","13","Middle","1000");
        Ticket ticket39 = new Ticket("1","13","Aisle","1000");
        Ticket ticket40 = new Ticket("1","14","Window","1000");
        Ticket ticket41 = new Ticket("1","14","Middle","1000");
        Ticket ticket42 = new Ticket("1","14","Aisle","1000");
        Ticket ticket43 = new Ticket("1","15","Window","1000");
        Ticket ticket44 = new Ticket("1","15","Middle","1000");
        Ticket ticket45 = new Ticket("1","15","Aisle","1000");
        Ticket ticket46 = new Ticket("1","16","Window","1000");
        Ticket ticket47 = new Ticket("1","16","Middle","1000");
        Ticket ticket48 = new Ticket("1","16","Aisle","1000");
        Ticket ticket49 = new Ticket("1","17","Window","1000");
        Ticket ticket50 = new Ticket("1","17","Middle","1000");
        Ticket ticket51 = new Ticket("1","17","Aisle","1000");
        Ticket ticket52 = new Ticket("1","18","Window","1000");
        Ticket ticket53 = new Ticket("1","18","Middle","1000");
        Ticket ticket54 = new Ticket("1","18","Aisle","1000");
        Ticket ticket55 = new Ticket("1","19","Window","1000");
        Ticket ticket56 = new Ticket("1","19","Middle","1000");
        Ticket ticket57 = new Ticket("1","19","Aisle","1000");
        Ticket ticket58 = new Ticket("1","20","Window","1000");
        Ticket ticket59 = new Ticket("1","20","Middle","1000");
        Ticket ticket60 = new Ticket("1","20","Aisle","1000");
        Ticket ticket61 = new Ticket("1","21","Window","1000");
        Ticket ticket62 = new Ticket("1","21","Middle","1000");
        Ticket ticket63 = new Ticket("1","21","Aisle","1000");
        Ticket ticket64 = new Ticket("1","22","Window","1000");
        Ticket ticket65 = new Ticket("1","22","Middle","1000");
        Ticket ticket66 = new Ticket("1","22","Aisle","1000");
        Ticket ticket67 = new Ticket("1","23","Window","1000");
        Ticket ticket68 = new Ticket("1","23","Middle","1000");
        Ticket ticket69 = new Ticket("1","23","Window","1000");
        Ticket ticket70 = new Ticket("1","24","Window","1000");
        Ticket ticket71 = new Ticket("1","24","Middle","1000");
        Ticket ticket72 = new Ticket("1","24","Aisle","1000");
        Ticket ticket73 = new Ticket("1","25","Window","1000");
        Ticket ticket74 = new Ticket("1","25","Middle","1000");
        Ticket ticket75 = new Ticket("1","25","Aisle","1000");
        
        Ticket ticket76 = new Ticket("2","1","Window","1000");
        Ticket ticket77= new Ticket("2","1","Middle","1000");
        Ticket ticket78 = new Ticket("2","1","Aisle","1000");
        Ticket ticket79= new Ticket("2","2","Window","1000");
        Ticket ticket80 = new Ticket("2","2","Middle","1000");
        Ticket ticket81 = new Ticket("2","2","Aisle","1000");
        Ticket ticket82 = new Ticket("2","3","Window","1000");
        Ticket ticket83 = new Ticket("2","3","Middle","1000");
        Ticket ticket84 = new Ticket("2","3","Aisle","1000");
        Ticket ticket85 = new Ticket("2","4","Window","1000");
        Ticket ticket86 = new Ticket("2","4","Middle","1000");
        Ticket ticket87 = new Ticket("2","4","Aisle","1000");
        Ticket ticket88 = new Ticket("2","5","Window","1000");
        Ticket ticket89= new Ticket("2","5","Middle","1000");
        Ticket ticket90 = new Ticket("2","5","Aisle","1000");
        Ticket ticket91 = new Ticket("2","6","Window","1000");
        Ticket ticket92 = new Ticket("2","6","Middle","1000");
        Ticket ticket93 = new Ticket("2","6","Aisle","1000");
        Ticket ticket94 = new Ticket("2","7","Window","1000");
        Ticket ticket95 = new Ticket("2","7","Middle","1000");
        Ticket ticket96 = new Ticket("2","7","Aisle","1000");
        Ticket ticket97 = new Ticket("2","8","Window","1000");
        Ticket ticket98 = new Ticket("2","8","Middle","1000");
        Ticket ticket99 = new Ticket("2","8","Aisle","1000");
        Ticket ticket100 = new Ticket("2","9","Window","1000");
        Ticket ticket101 = new Ticket("2","9","Middle","1000");
        Ticket ticket102 = new Ticket("2","9","Aisle","1000");
        Ticket ticket103 = new Ticket("2","10","Window","1000");
        Ticket ticket104= new Ticket("2","10","Middle","1000");
        Ticket ticket105 = new Ticket("2","10","Aisle","1000");
        Ticket ticket106 = new Ticket("2","11","Window","1000");
        Ticket ticket107 = new Ticket("2","11","Middle","1000");
        Ticket ticket108= new Ticket("2","11","Aisle","1000");
        Ticket ticket109= new Ticket("2","12","Window","1000");
        Ticket ticket110 = new Ticket("2","12","Middle","1000");
        Ticket ticket111 = new Ticket("2","12","Aisle","1000");
        Ticket ticket112 = new Ticket("2","13","Window","1000");
        Ticket ticket113= new Ticket("2","13","Middle","1000");
        Ticket ticket114= new Ticket("2","13","Aisle","1000");
        Ticket ticket115= new Ticket("2","14","Window","1000");
        Ticket ticket116 = new Ticket("2","14","Middle","1000");
        Ticket ticket117= new Ticket("2","14","Aisle","1000");
        Ticket ticket118= new Ticket("2","15","Window","1000");
        Ticket ticket119 = new Ticket("2","15","Middle","1000");
        Ticket ticket120 = new Ticket("2","15","Aisle","1000");
        Ticket ticket121 = new Ticket("2","16","Window","1000");
        Ticket ticket122 = new Ticket("2","16","Middle","1000");
        Ticket ticket123 = new Ticket("2","16","Aisle","1000");
        Ticket ticket124 = new Ticket("2","17","Window","1000");
        Ticket ticket125= new Ticket("2","17","Middle","1000");
        Ticket ticket126= new Ticket("2","17","Aisle","1000");
        Ticket ticket127= new Ticket("2","18","Window","1000");
        Ticket ticket128= new Ticket("2","18","Middle","1000");
        Ticket ticket129= new Ticket("2","18","Aisle","1000");
        Ticket ticket130= new Ticket("2","19","Window","1000");
        Ticket ticket131 = new Ticket("2","19","Middle","1000");
        Ticket ticket132 = new Ticket("2","19","Aisle","1000");
        Ticket ticket133 = new Ticket("2","20","Window","1000");
        Ticket ticket134 = new Ticket("2","20","Middle","1000");
        Ticket ticket135 = new Ticket("2","20","Aisle","1000");
        Ticket ticket136 = new Ticket("2","21","Window","1000");
        Ticket ticket137 = new Ticket("2","21","Middle","1000");
        Ticket ticket138 = new Ticket("2","21","Aisle","1000");
        Ticket ticket139 = new Ticket("2","22","Window","1000");
        Ticket ticket140 = new Ticket("2","22","Middle","1000");
        Ticket ticket141 = new Ticket("2","22","Aisle","1000");
        Ticket ticket142 = new Ticket("2","23","Window","1000");
        Ticket ticket143 = new Ticket("2","23","Middle","1000");
        Ticket ticket144 = new Ticket("2","23","Aisle","1000");
        Ticket ticket145 = new Ticket("2","24","Window","1000");
        Ticket ticket146 = new Ticket("2","24","Middle","1000");
        Ticket ticket147 = new Ticket("2","24","Aisle","1000");
        Ticket ticket148 = new Ticket("2","25","Window","1000");
        Ticket ticket149 = new Ticket("2","25","Middle","1000");
        Ticket ticket150 = new Ticket("2","25","Aisle","1000");
        
        
        
        ticketCatalog.add(ticket1);
        ticketCatalog.add(ticket2);
        ticketCatalog.add(ticket3);
        ticketCatalog.add(ticket4);
        ticketCatalog.add(ticket5);
        ticketCatalog.add(ticket6);
        ticketCatalog.add(ticket7);
        ticketCatalog.add(ticket8);
        ticketCatalog.add(ticket9);
        ticketCatalog.add(ticket10);
        ticketCatalog.add(ticket11);
        ticketCatalog.add(ticket12);
        ticketCatalog.add(ticket13);
        ticketCatalog.add(ticket14);
        ticketCatalog.add(ticket15);
        ticketCatalog.add(ticket16);
        ticketCatalog.add(ticket17);
        ticketCatalog.add(ticket18);
        ticketCatalog.add(ticket19);
        ticketCatalog.add(ticket20);
        ticketCatalog.add(ticket21);
        ticketCatalog.add(ticket22);
        ticketCatalog.add(ticket23);
        ticketCatalog.add(ticket24);
        ticketCatalog.add(ticket25);
        ticketCatalog.add(ticket26);
        ticketCatalog.add(ticket27);
        ticketCatalog.add(ticket28);
        ticketCatalog.add(ticket29);
        ticketCatalog.add(ticket30);
        ticketCatalog.add(ticket31);
        ticketCatalog.add(ticket32);
        ticketCatalog.add(ticket33);
        ticketCatalog.add(ticket34);
        ticketCatalog.add(ticket35);
        ticketCatalog.add(ticket36);
        ticketCatalog.add(ticket37);
        ticketCatalog.add(ticket38);
        ticketCatalog.add(ticket39);
        ticketCatalog.add(ticket40);
        ticketCatalog.add(ticket41);
        ticketCatalog.add(ticket42);
        ticketCatalog.add(ticket43);
        ticketCatalog.add(ticket44);
        ticketCatalog.add(ticket45);
        ticketCatalog.add(ticket46);
        ticketCatalog.add(ticket47);
        ticketCatalog.add(ticket48);
        ticketCatalog.add(ticket49);
        ticketCatalog.add(ticket50);
        ticketCatalog.add(ticket51);
        ticketCatalog.add(ticket52);
        ticketCatalog.add(ticket53);
        ticketCatalog.add(ticket54);
        ticketCatalog.add(ticket55);
        ticketCatalog.add(ticket56);
        ticketCatalog.add(ticket57);
        ticketCatalog.add(ticket58);
        ticketCatalog.add(ticket59);
        ticketCatalog.add(ticket60);
        ticketCatalog.add(ticket61);
        ticketCatalog.add(ticket62);
        ticketCatalog.add(ticket63);
        ticketCatalog.add(ticket64);
        ticketCatalog.add(ticket65);
        ticketCatalog.add(ticket66);
        ticketCatalog.add(ticket67);
        ticketCatalog.add(ticket68);
        ticketCatalog.add(ticket69);
        ticketCatalog.add(ticket70);
        ticketCatalog.add(ticket71);
        ticketCatalog.add(ticket72);
        ticketCatalog.add(ticket73);
        ticketCatalog.add(ticket74);
        ticketCatalog.add(ticket75);
        ticketCatalog.add(ticket76);
        ticketCatalog.add(ticket77);
        ticketCatalog.add(ticket78);
        ticketCatalog.add(ticket79);
        ticketCatalog.add(ticket80);
        ticketCatalog.add(ticket81);
        ticketCatalog.add(ticket82);
        ticketCatalog.add(ticket83);
        ticketCatalog.add(ticket84);
        ticketCatalog.add(ticket85);
        ticketCatalog.add(ticket86);
        ticketCatalog.add(ticket87);
        ticketCatalog.add(ticket88);
        ticketCatalog.add(ticket89);
        ticketCatalog.add(ticket90);
        ticketCatalog.add(ticket91);
        ticketCatalog.add(ticket92);
        ticketCatalog.add(ticket93);
        ticketCatalog.add(ticket94);
        ticketCatalog.add(ticket95);
        ticketCatalog.add(ticket96);
        ticketCatalog.add(ticket97);
        ticketCatalog.add(ticket98);
        ticketCatalog.add(ticket99);
        ticketCatalog.add(ticket100);
        ticketCatalog.add(ticket101);
        ticketCatalog.add(ticket102);
        ticketCatalog.add(ticket103);
        ticketCatalog.add(ticket104);
        ticketCatalog.add(ticket105);
        ticketCatalog.add(ticket106);
        ticketCatalog.add(ticket107);
        ticketCatalog.add(ticket108);
        ticketCatalog.add(ticket109);
        ticketCatalog.add(ticket110);
        ticketCatalog.add(ticket111);
        ticketCatalog.add(ticket112);
        ticketCatalog.add(ticket113);
        ticketCatalog.add(ticket114);
        ticketCatalog.add(ticket115);
        ticketCatalog.add(ticket116);
        ticketCatalog.add(ticket117);
        ticketCatalog.add(ticket118);
        ticketCatalog.add(ticket119);
        ticketCatalog.add(ticket120);
        ticketCatalog.add(ticket121);
        ticketCatalog.add(ticket122);
        ticketCatalog.add(ticket123);
        ticketCatalog.add(ticket124);
        ticketCatalog.add(ticket125);
        ticketCatalog.add(ticket126);
        ticketCatalog.add(ticket127);
        ticketCatalog.add(ticket128);
        ticketCatalog.add(ticket129);
        ticketCatalog.add(ticket130);
        ticketCatalog.add(ticket131);
        ticketCatalog.add(ticket132);
        ticketCatalog.add(ticket133);
        ticketCatalog.add(ticket134);
        ticketCatalog.add(ticket135);
        ticketCatalog.add(ticket136);
        ticketCatalog.add(ticket137);
        ticketCatalog.add(ticket138);
        ticketCatalog.add(ticket139);
        ticketCatalog.add(ticket140);
        ticketCatalog.add(ticket141);
        ticketCatalog.add(ticket142);
        ticketCatalog.add(ticket143);
        ticketCatalog.add(ticket144);
        ticketCatalog.add(ticket145);
        ticketCatalog.add(ticket146);
        ticketCatalog.add(ticket147);
        ticketCatalog.add(ticket148);
        ticketCatalog.add(ticket149);
        ticketCatalog.add(ticket150);
        return ticketCatalog;
    }

    public void setTicketCatalog(ArrayList<Ticket> ticketCatalog) {
        this.ticketCatalog = ticketCatalog;
    }


    
    
    
    

}
