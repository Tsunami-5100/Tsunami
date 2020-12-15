/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BookTickets;

import Business.AirlinerCatalog;
import Business.Business;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Ticket;
import UserInterface.AgencyManagerRole.AddAirliner;
import UserInterface.AirlinerRole.ManageFlight;
import UserInterface.AirlinerRole.ViewTicketDetail;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yaozhi
 */
public class ManageCustomer extends javax.swing.JPanel {
private JPanel Container;
private CustomerDirectory customerDirectory;
private AirlinerCatalog ac;
    /**
     * Creates new form ticketsManagement
     */



    public ManageCustomer(JPanel Container, CustomerDirectory cd, AirlinerCatalog airlinerCatalog) {
        initComponents();
        customerDirectory = cd;
        this.Container = Container;
        ac = airlinerCatalog;
        refreshTable();
    }
    
       public void refreshTable(){

        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();

        model.setRowCount(0);

        for (Customer c : customerDirectory.getCustomerDirectory()) {
            Object row[] = new Object[2];
            row[0] = c;
            row[1] = c.getSSN();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        btnBook1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnViewSchedule = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("Customers Dictionary");

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Customer Name", "SSN"
            }
        ));
        jScrollPane1.setViewportView(CustomerTable);

        btnBook1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnBook1.setText("Book Tickets >>");
        btnBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBook1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton2.setText("Add New customer >>");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnViewSchedule.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnViewSchedule.setText("View Travel Schedule >>");
        btnViewSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewScheduleActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton4.setText("<< Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(234, 234, 234))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton4)
                                .addGap(464, 464, 464))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(468, 468, 468)
                        .addComponent(btnViewSchedule)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnBook1)
                .addGap(18, 18, 18)
                .addComponent(btnViewSchedule)
                .addGap(62, 62, 62)
                .addComponent(jButton4)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddCustomer al = new AddCustomer(Container, customerDirectory);
        Container.add("AddCustomer", al);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        Container.remove(this);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBook1ActionPerformed

        int row = CustomerTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }    
        Customer c = (Customer)CustomerTable.getValueAt(row,0);
        SearchFlight bt = new SearchFlight(Container, ac,c);
        Container.add("SearchFlight", bt);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnBook1ActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = CustomerTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }    
        Customer c = (Customer)CustomerTable.getValueAt(row,0);
        ViewTravelSchedule vts = new ViewTravelSchedule(Container,c);
        Container.add("ViewTravelSchedule", vts);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnViewActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AddCustomer al = new AddCustomer(Container, customerDirectory);
        Container.add("AddCustomer", al);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnViewScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewScheduleActionPerformed
        // TODO add your handling code here:
        int row = CustomerTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }    
        Customer c = (Customer)CustomerTable.getValueAt(row,0);
        ViewTravelSchedule vts = new ViewTravelSchedule(Container,c);
        Container.add("ViewTravelSchedule", vts);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnViewScheduleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Container.remove(this);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_jButton4ActionPerformed

       

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerTable;
    private javax.swing.JButton btnBook1;
    private javax.swing.JButton btnViewSchedule;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}