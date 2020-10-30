/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AgencyManagerRole;

import Business.Airliner;
import Business.AirlinerCatalog;
import Business.FleetCatalog;
import java.awt.CardLayout;
import java.util.function.Supplier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class ManageAirliners extends javax.swing.JPanel {
    
    private JPanel Container;
    private AirlinerCatalog airlinerCatalog;
   
    public ManageAirliners(JPanel c, AirlinerCatalog ac) {
        initComponents();
        this.Container = c;
        this.airlinerCatalog = ac;
        refreshTable();
    }
    
    public void refreshTable(){
//        int rowCount = supplierTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tableAirliner.getModel();
        /*for(int i=rowCount-1;i>=0;i--){
        model.removeRow(i);
        }*/
        model.setRowCount(0);
//        if(model==null) {
        for (Airliner a : airlinerCatalog.getAirlinerList()) {
            Object row[] = new Object[1];
            row[0] = a;
            model.addRow(row);
        }
//        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAirliner = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel1.setText("Manage Airliners");

        tableAirliner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Airliner Name"
            }
        ));
        jScrollPane1.setViewportView(tableAirliner);

        btnView.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnView.setText("View Airliner");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnAdd.setText("Add Airliner");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRemove)
                                    .addGap(303, 303, 303)
                                    .addComponent(btnView))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBack)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnRemove))
                .addGap(55, 55, 55)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddAirliner al = new AddAirliner(Container, airlinerCatalog);
        Container.add("AddAirliner", al);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Container.remove(this);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableAirliner.getSelectedRow();
        if(selectedRow>=0) {
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to remove??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                Airliner a = (Airliner) tableAirliner.getValueAt(selectedRow, 0);
                airlinerCatalog.removeAirliner(a);
                refreshTable();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
        
//        int row = AirlinerTable.getSelectedRow();
//        if(row<0){
//            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        Airliner a = (Airliner) AirlinerTable.getValueAt(row, 0);
//        airlinerCatalog.removeAirliner(a);
//        refreshTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int row = tableAirliner.getSelectedRow();
        
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Airliner a = (Airliner)tableAirliner.getValueAt(row,0);
        ViewAirliner va = new ViewAirliner(Container, a);
        Container.add("ViewSupplier", va);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.next(Container);
        
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAirliner;
    // End of variables declaration//GEN-END:variables
}
