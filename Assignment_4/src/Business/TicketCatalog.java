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
        ticketCatalog.remove(t);
    }

    public ArrayList<Ticket> getTicketCatalog() {
        Ticket ticket1 = new Ticket("1A","window","500","availability","null");
        Ticket ticket2 = new Ticket("1B","middle","500","availability","null");
        Ticket ticket3 = new Ticket("1C","Aisle","500","availability","null");
        Ticket ticket4 = new Ticket("1D","Aisle","500","availability","null");
        Ticket ticket5 = new Ticket("1E","middle","500","availability","null");
        Ticket ticket6 = new Ticket("1F","window","500","availability","null");
        
        Ticket ticket7 = new Ticket("2A","window","500","availability","null");
        Ticket ticket8 = new Ticket("2B","middle","500","availability","null");
        Ticket ticket9 = new Ticket("2C","Aisle","500","availability","null");
        Ticket ticket10 = new Ticket("2D","Aisle","500","availability","null");
        Ticket ticket11 = new Ticket("2E","middle","500","availability","null");
        Ticket ticket12 = new Ticket("2F","window","500","availability","null");
        
        Ticket ticket13 = new Ticket("3A","window","500","availability","null");
        Ticket ticket14 = new Ticket("3B","middle","500","availability","null");
        Ticket ticket15 = new Ticket("3C","Aisle","500","availability","null");
        Ticket ticket16 = new Ticket("3D","Aisle","500","availability","null");
        Ticket ticket17 = new Ticket("3E","middle","500","availability","null");
        Ticket ticket18 = new Ticket("3F","window","500","availability","null");
        
        Ticket ticket19 = new Ticket("4A","window","500","availability","null");
        Ticket ticket20 = new Ticket("4B","middle","500","availability","null");
        Ticket ticket21 = new Ticket("4C","Aisle","500","availability","null");
        Ticket ticket22 = new Ticket("4D","Aisle","500","availability","null");
        Ticket ticket23 = new Ticket("4E","middle","500","availability","null");
        Ticket ticket24 = new Ticket("4F","window","500","availability","null");
        
        Ticket ticket25 = new Ticket("5A","window","500","availability","null");
        Ticket ticket26 = new Ticket("5B","middle","500","availability","null");
        Ticket ticket27 = new Ticket("5C","Aisle","500","availability","null");
        Ticket ticket28 = new Ticket("5D","Aisle","500","availability","null");
        Ticket ticket29 = new Ticket("5E","middle","500","availability","null");
        Ticket ticket30 = new Ticket("5F","window","500","availability","null");
        
        Ticket ticket31 = new Ticket("6A","window","400","availability","null");
        Ticket ticket32 = new Ticket("6B","middle","400","availability","null");
        Ticket ticket33 = new Ticket("6C","Aisle","400","availability","null");
        Ticket ticket34 = new Ticket("6D","Aisle","400","availability","null");
        Ticket ticket35 = new Ticket("6E","middle","400","availability","null");
        Ticket ticket36 = new Ticket("6F","window","400","availability","null");
        
        Ticket ticket37 = new Ticket("7A","window","400","availability","null");
        Ticket ticket38 = new Ticket("7B","middle","400","availability","null");
        Ticket ticket39 = new Ticket("7C","Aisle","400","availability","null");
        Ticket ticket40 = new Ticket("7D","Aisle","400","availability","null");
        Ticket ticket41 = new Ticket("7E","middle","400","availability","null");
        Ticket ticket42 = new Ticket("7F","window","400","availability","null");
        
        Ticket ticket43 = new Ticket("8A","window","400","availability","null");
        Ticket ticket44 = new Ticket("8B","middle","400","availability","null");
        Ticket ticket45 = new Ticket("8C","Aisle","400","availability","null");
        Ticket ticket46 = new Ticket("8D","Aisle","400","availability","null");
        Ticket ticket47 = new Ticket("8E","middle","400","availability","null");
        Ticket ticket48 = new Ticket("8F","window","400","availability","null");
        
        Ticket ticket49 = new Ticket("9A","window","400","availability","null");
        Ticket ticket50 = new Ticket("9B","middle","400","availability","null");
        Ticket ticket51 = new Ticket("9C","Aisle","400","availability","null");
        Ticket ticket52 = new Ticket("9D","Aisle","400","availability","null");
        Ticket ticket53 = new Ticket("9E","middle","400","availability","null");
        Ticket ticket54 = new Ticket("9F","window","400","availability","null");
        
        Ticket ticket55 = new Ticket("10A","window","400","availability","null");
        Ticket ticket56 = new Ticket("10B","middle","400","availability","null");
        Ticket ticket57 = new Ticket("10C","Aisle","400","availability","null");
        Ticket ticket58 = new Ticket("10D","Aisle","400","availability","null");
        Ticket ticket59 = new Ticket("10E","middle","400","availability","null");
        Ticket ticket60 = new Ticket("10F","window","400","availability","null");
        
        Ticket ticket61 = new Ticket("11A","window","300","availability","null");
        Ticket ticket62 = new Ticket("11B","middle","300","availability","null");
        Ticket ticket63 = new Ticket("11C","Aisle","300","availability","null");
        Ticket ticket64 = new Ticket("11D","Aisle","300","availability","null");
        Ticket ticket65 = new Ticket("11E","middle","300","availability","null");
        Ticket ticket66 = new Ticket("11F","window","300","availability","null");
        
        Ticket ticket67 = new Ticket("12A","window","300","availability","null");
        Ticket ticket68 = new Ticket("12B","middle","300","availability","null");
        Ticket ticket69 = new Ticket("12C","Aisle","300","availability","null");
        Ticket ticket70 = new Ticket("12D","Aisle","300","availability","null");
        Ticket ticket71 = new Ticket("12E","middle","300","availability","null");
        Ticket ticket72 = new Ticket("12F","window","300","availability","null");
        
        Ticket ticket73 = new Ticket("13A","window","300","availability","null");
        Ticket ticket74 = new Ticket("13B","middle","300","availability","null");
        Ticket ticket75 = new Ticket("13C","Aisle","300","availability","null");
        Ticket ticket76 = new Ticket("13D","Aisle","300","availability","null");
        Ticket ticket77 = new Ticket("13E","middle","300","availability","null");
        Ticket ticket78 = new Ticket("13F","window","300","availability","null");
        
        Ticket ticket79 = new Ticket("14A","window","300","availability","null");
        Ticket ticket80 = new Ticket("14B","middle","300","availability","null");
        Ticket ticket81 = new Ticket("14C","Aisle","300","availability","null");
        Ticket ticket82 = new Ticket("14D","Aisle","300","availability","null");
        Ticket ticket83 = new Ticket("14E","middle","300","availability","null");
        Ticket ticket84 = new Ticket("14F","window","300","availability","null");
        
        Ticket ticket85 = new Ticket("15A","window","300","availability","null");
        Ticket ticket86 = new Ticket("15B","middle","300","availability","null");
        Ticket ticket87 = new Ticket("15C","Aisle","300","availability","null");
        Ticket ticket88 = new Ticket("15D","Aisle","300","availability","null");
        Ticket ticket89 = new Ticket("15E","middle","300","availability","null");
        Ticket ticket90 = new Ticket("15F","window","300","availability","null");
        
        Ticket ticket91 = new Ticket("16A","window","300","availability","null");
        Ticket ticket92 = new Ticket("16B","middle","300","availability","null");
        Ticket ticket93 = new Ticket("16C","Aisle","300","availability","null");
        Ticket ticket94 = new Ticket("16D","Aisle","300","availability","null");
        Ticket ticket95 = new Ticket("16E","middle","300","availability","null");
        Ticket ticket96 = new Ticket("16F","window","300","availability","null");
        
        Ticket ticket97 = new Ticket("17A","window","300","availability","null");
        Ticket ticket98 = new Ticket("17B","middle","300","availability","null");
        Ticket ticket99 = new Ticket("17C","Aisle","300","availability","null");
        Ticket ticket100 = new Ticket("17D","Aisle","300","availability","null"); 
        Ticket ticket101 = new Ticket("17E","middle","300","availability","null");
        Ticket ticket102 = new Ticket("17F","window","300","availability","null");
        
        Ticket ticket103 = new Ticket("18A","window","300","availability","null");
        Ticket ticket104 = new Ticket("18B","middle","300","availability","null");
        Ticket ticket105 = new Ticket("18C","Aisle","300","availability","null");
        Ticket ticket106 = new Ticket("18D","Aisle","300","availability","null");
        Ticket ticket107 = new Ticket("18E","middle","300","availability","null");
        Ticket ticket108 = new Ticket("18F","window","300","availability","null");
        
        Ticket ticket109 = new Ticket("19A","window","300","availability","null");
        Ticket ticket110 = new Ticket("19B","middle","300","availability","null");
        Ticket ticket111 = new Ticket("19C","Aisle","300","availability","null");
        Ticket ticket112 = new Ticket("19D","Aisle","300","availability","null");
        Ticket ticket113 = new Ticket("19E","middle","300","availability","null");
        Ticket ticket114 = new Ticket("19F","window","300","availability","null");
        
        Ticket ticket115 = new Ticket("20A","window","300","availability","null");
        Ticket ticket116 = new Ticket("20B","middle","300","availability","null");
        Ticket ticket117 = new Ticket("20C","Aisle","300","availability","null");
        Ticket ticket118 = new Ticket("20D","Aisle","300","availability","null");
        Ticket ticket119 = new Ticket("20E","middle","300","availability","null");
        Ticket ticket120 = new Ticket("20F","window","300","availability","null");
        
        Ticket ticket121 = new Ticket("21A","window","300","availability","null");
        Ticket ticket122 = new Ticket("21B","middle","300","availability","null");
        Ticket ticket123 = new Ticket("21C","Aisle","300","availability","null");
        Ticket ticket124 = new Ticket("21D","Aisle","300","availability","null");
        Ticket ticket125 = new Ticket("21E","middle","300","availability","null");
        Ticket ticket126 = new Ticket("21F","window","300","availability","null");
        
        Ticket ticket127 = new Ticket("22A","window","300","availability","null");
        Ticket ticket128 = new Ticket("22B","middle","300","availability","null");
        Ticket ticket129 = new Ticket("22C","Aisle","300","availability","null");
        Ticket ticket130 = new Ticket("22D","Aisle","300","availability","null");
        Ticket ticket131 = new Ticket("22E","middle","300","availability","null");
        Ticket ticket132 = new Ticket("22F","window","300","availability","null");
        
        Ticket ticket133 = new Ticket("23A","window","300","availability","null");
        Ticket ticket134 = new Ticket("23B","middle","300","availability","null");
        Ticket ticket135 = new Ticket("23C","Aisle","300","availability","null");
        Ticket ticket136 = new Ticket("23D","Aisle","300","availability","null");
        Ticket ticket137 = new Ticket("23E","middle","300","availability","null");
        Ticket ticket138 = new Ticket("23F","window","300","availability","null");
        
        Ticket ticket139 = new Ticket("24A","window","300","availability","null");
        Ticket ticket140 = new Ticket("24B","middle","300","availability","null");
        Ticket ticket141 = new Ticket("24C","Aisle","300","availability","null");
        Ticket ticket142 = new Ticket("24D","Aisle","300","availability","null");
        Ticket ticket143 = new Ticket("24E","middle","300","availability","null");
        Ticket ticket144 = new Ticket("24F","window","300","availability","null");
        
        Ticket ticket145 = new Ticket("25A","window","300","availability","null");
        Ticket ticket146 = new Ticket("25B","middle","300","availability","null");
        Ticket ticket147 = new Ticket("25C","Aisle","300","availability","null");
        Ticket ticket148 = new Ticket("25D","Aisle","300","availability","null");
        Ticket ticket149 = new Ticket("25E","middle","300","availability","null");
        Ticket ticket150 = new Ticket("25F","window","300","availability","null");
        
        
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
