/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AirlinerRole;

import Business.Fleet;
import Business.Airplane;
import Business.AirplaneCatalog;
import Business.Business;
import Business.Flight;
import Business.FlightCatalog;
import Business.TicketCatalog;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmond
 */
public class ManageFlight extends javax.swing.JPanel {

    /**
     * Creates new form ManageFlight
     */
    private JPanel Container;
    private FlightCatalog fc;
    private Airplane airplane;
    private TicketCatalog ticketCatalog;
    

    ManageFlight(JPanel aContainer, Airplane a, FlightCatalog flightCatalog) {
        initComponents();
        Container = aContainer;
        fc = flightCatalog;
        airplane = a;
        txtAirplane.setText(a.getId());
        refreshTable();
        Business business = new Business();
        this.ticketCatalog = business.getTicketCatalog();
    }
    
    public void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) FlightCatalogTable.getModel();
        model.setRowCount(0);
        for(Flight f: airplane.getFlightCatalog().getFlightCatalog() ){
            Object row[] = new Object[6];
            row[0] = f;
            row[1] = f.getDepartureLocation();
            row[2] = f.getArrivalLocation();
            row[3] = f.getDateofDay();
            row[4] = f.getTime();
            row[5] = f.count;
            model.addRow(row);
        }
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
        txtAirplane = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnManageTickets = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        FlightCatalogTable = new javax.swing.JTable();
        btnViewDetails = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Manage Flights");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Airplane ID:");

        txtAirplane.setEditable(false);
        txtAirplane.setEnabled(false);
        txtAirplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAirplaneActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnDelete.setText("Remove");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnCreate.setText("Create New Flight>>");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnManageTickets.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnManageTickets.setText("Manage Tickets>>");
        btnManageTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageTicketsActionPerformed(evt);
            }
        });

        btnDelete1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnDelete1.setText("<<Back");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        FlightCatalogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Departure Location", "Arrival Location", "Date", "Time", "Seating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(FlightCatalogTable);
        if (FlightCatalogTable.getColumnModel().getColumnCount() > 0) {
            FlightCatalogTable.getColumnModel().getColumn(0).setResizable(false);
            FlightCatalogTable.getColumnModel().getColumn(1).setResizable(false);
            FlightCatalogTable.getColumnModel().getColumn(1).setPreferredWidth(130);
            FlightCatalogTable.getColumnModel().getColumn(2).setResizable(false);
            FlightCatalogTable.getColumnModel().getColumn(2).setPreferredWidth(125);
            FlightCatalogTable.getColumnModel().getColumn(3).setResizable(false);
            FlightCatalogTable.getColumnModel().getColumn(4).setResizable(false);
        }

        btnViewDetails.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnViewDetails.setText("View Flight Details>>");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 75, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAirplane, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(300, 300, 300))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAirplane, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnManageTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int row = FlightCatalogTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Flight a = (Flight)FlightCatalogTable.getValueAt(row,0);
        ViewFlightDetail ma = new ViewFlightDetail(Container,a,ticketCatalog);
        Container.add("ViewFlightDetail", ma);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateFlight createFlight = new CreateFlight(Container,fc,airplane);
        Container.add("CreateFlight",createFlight);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnManageTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageTicketsActionPerformed
        // TODO add your handling code here:
        int row = FlightCatalogTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Flight a = (Flight)FlightCatalogTable.getValueAt(row,0);
        ViewTickets ma = new ViewTickets(Container,a,ticketCatalog);
        Container.add("ManageTicket", ma);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnManageTicketsActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = FlightCatalogTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Flight s = (Flight) FlightCatalogTable.getValueAt(row, 0);
        airplane.getFlightCatalog().removeFlight(s);
        refreshTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        Container.remove(this);
        Component [] componentArray = Container.getComponents();
        Component c = componentArray[componentArray.length-1];
        ManageAirplane m = (ManageAirplane) c;
        m.refreshTable();
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void txtAirplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAirplaneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAirplaneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FlightCatalogTable;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnManageTickets;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAirplane;
    // End of variables declaration//GEN-END:variables
}
