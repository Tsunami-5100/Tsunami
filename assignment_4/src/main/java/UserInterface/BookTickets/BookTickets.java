/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BookTickets;

import Business.Airliner;
import Business.Airplane;
import Business.Customer;
import Business.Fleet;
import UserInterface.AirlinerRole.*;
import Business.Flight;
import Business.Ticket;
import Business.TicketCatalog;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmond
 */
public class BookTickets extends javax.swing.JPanel {

    /**
     * Creates new form ViewTicket
     */
    private JPanel Container;
    private Flight flight;
    private TicketCatalog ticketCatalog;
    private Customer customer;



    BookTickets(JPanel container, Flight a, TicketCatalog ticketCatalog, Customer customer) {
        initComponents();
        this.Container = container;
        this.flight = a;
        this.ticketCatalog = ticketCatalog;
        this.customer = customer;
        txtFlightNUm.setText(a.getFlightNumber());
        refreshTable();
    }
    
   public void refreshTable(){
        System.out.println("UserInterface.BookTickets.ManageTickets.refreshTable()");
        System.out.println(tableTickets);
        DefaultTableModel model = (DefaultTableModel) tableTickets.getModel();
//        DefaultTableModel model = (DefaultTableModel) getModel();
        model.setRowCount(0);
        System.out.println("Manage Tickets:51." + flight.getTicketCatalog().getTicketCatalog());
        for(Ticket t : flight.getTicketCatalog().getTicketCatalog()){
            Object row[] = new Object[6];
            row[0] = t;
            row[1] = t.getColumnNum()+ "-" + t.getLocation();
            row[2] = flight.getArrivalLocation();
            row[3] = flight.getDepartureLocation();
            row[4] = flight.getDateofDay();
            row[5] = t.getPrice();
            model.addRow(row);
        }
    }
   
   private void refreshTicketTable() {
        DefaultTableModel model = (DefaultTableModel) tableTickets.getModel();
        model.setRowCount(0);
        
        for(Ticket t : flight.getTicketCatalog().getTicketCatalog()){
            boolean rowNum = comboRow.getSelectedItem().equals(t.getRowNum())||comboRow.getSelectedItem().equals("All");
            boolean column = comboColumn.getSelectedItem().equals(t.getColumnNum()) || comboColumn.getSelectedItem().equals("All");
            boolean location = comboLocation.getSelectedItem().equals(t.getLocation()) || comboLocation.getSelectedItem().equals("All");
            if(rowNum && column && location) {     
                Object row[] = new Object[6];
                row[0] = t;
                row[1] = t.getColumnNum()+ "-" + t.getLocation();
                row[2] = flight.getArrivalLocation();
                row[3] = flight.getDepartureLocation();
                row[4] = flight.getDateofDay();
                row[5] = t.getPrice();
                model.addRow(row);
            }
        }
        
//        for(Airliner al : airlinerCatalog.getAirlinerList()){
//        for(Fleet a : al.getFleetCatalog().getFleetList()){
//            for(Airplane ap: a.getAirplaneCatalog().getAirplaneCatalog()){
//                for(Flight f : ap.getFlightCatalog().getFlightCatalog()){             
//                    boolean arrival = txtALocation.getText().equalsIgnoreCase(f.getArrivalLocation())||txtALocation.getText().equals("")||txtALocation.getText()==null;
//                    System.out.println("81." + f.getArrivalLocation());
//                    System.out.println("82." + txtALocation.getText());
//                    System.out.println("searchFlight: 83." + arrival);
//                    boolean day = f.getDateofDay().equalsIgnoreCase(txtDate.getText()) || txtDate.getText().equalsIgnoreCase("") || txtDate.getText()==null;
//                    System.out.println("searchFlight: 85." + day);
//                    boolean departure = f.getDepartureLocation().equalsIgnoreCase(txtDlocation.getText()) || txtDlocation.getText().equalsIgnoreCase("")|| txtDlocation.getText()==null;
//                    System.out.println("searchFlight: 87." + departure);
//                    boolean time = comboTime.getSelectedItem().equals(f.getTime()) || comboTime.getSelectedItem().equals("All");
//                    System.out.println("searchFlight: 89." + time);
////                    System.out.println("searchFlight: 87." + arrival && day && departure && time);
//                    if(arrival && day && departure && time){
//                      Object row[] = new Object[5];
//                      row[0] = f;
//                      row[1] = f.getDepartureLocation();
//                      row[2] = f.getArrivalLocation();
//                      row[3] = f.getDateofDay();
//                      row[4] = f.getTime();
//                      model.addRow(row);  
//                    } 
//                    }
//                }
            }
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFlightNUm = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTickets = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboRow = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboColumn = new javax.swing.JComboBox<>();
        comboLocation = new javax.swing.JComboBox<>();
        benSearch = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Book Tickets");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Flight Number:");

        txtFlightNUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFlightNUmActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBook.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnBook.setText("Book Ticket");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        tableTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Row Number", "Seat Location", "Arrival Location", "Departure Location", "Date", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableTickets);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Row:");

        comboRow.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        comboRow.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("Location:");

        comboColumn.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        comboColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));

        comboLocation.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        comboLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Window", "Middle", "Aisle" }));

        benSearch.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        benSearch.setText("Search");
        benSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBack)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(467, 467, 467)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnBook)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(48, 48, 48)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(txtFlightNUm, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(comboRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(comboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(benSearch)))
                .addContainerGap(585, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFlightNUm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(benSearch))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableTickets.getSelectedRow();
        if(selectedRow>=0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to Book this ticket??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                Ticket t = (Ticket) tableTickets.getValueAt(selectedRow, 0);                        
                    flight.getTicketCatalog().removeTicket(t);
                    flight.count--;
                    customer.getFlightCatalog().addFlight(flight);                    
                    refreshTable();
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Container.remove(this);
        Component [] componentArray = Container.getComponents();
        Component c = componentArray[componentArray.length-1];
        SearchFlight m = (SearchFlight) c;
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtFlightNUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFlightNUmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFlightNUmActionPerformed

    private void benSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_benSearchActionPerformed
        // TODO add your handling code here:
        refreshTicketTable();
        
    }//GEN-LAST:event_benSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton benSearch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JComboBox<String> comboColumn;
    private javax.swing.JComboBox<String> comboLocation;
    private javax.swing.JComboBox<String> comboRow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableTickets;
    private javax.swing.JTextField txtFlightNUm;
    // End of variables declaration//GEN-END:variables

 
}
