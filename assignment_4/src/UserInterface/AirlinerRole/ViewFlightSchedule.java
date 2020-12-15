/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AirlinerRole;

import Business.Airliner;
import Business.Fleet;
import Business.FleetCatalog;
import Business.Airplane;
import Business.AirplaneCatalog;
import Business.Business;
import Business.Flight;
import Business.FlightCatalog;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edmond
 */
public class ViewFlightSchedule extends javax.swing.JPanel {

    /**
     * Creates new form ManageAirplane
     */
    private JPanel Container;
    private AirplaneCatalog airplaneCatalog;
    private FlightCatalog flightCatalog;
    private Airliner al;
    

    ViewFlightSchedule(JPanel Container, Airliner airliner) {
        initComponents();
        
        this.Container = Container;
        al = airliner;
        txtAirliner.setText(al.getAirlineName());
        refreshTable();
    }

    public void refreshTable(){
        
        DefaultTableModel model = (DefaultTableModel) AirplaneCatalogTable.getModel();
        model.setRowCount(0);
        
        for(Fleet a : al.getFleetCatalog().getFleetList()){
            for(Airplane ap: a.getAirplaneCatalog().getAirplaneCatalog()){
                for(Flight f : ap.getFlightCatalog().getFlightCatalog()){
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

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AirplaneCatalogTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtAirliner = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        AirplaneCatalogTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(AirplaneCatalogTable);
        if (AirplaneCatalogTable.getColumnModel().getColumnCount() > 0) {
            AirplaneCatalogTable.getColumnModel().getColumn(0).setResizable(false);
            AirplaneCatalogTable.getColumnModel().getColumn(1).setResizable(false);
            AirplaneCatalogTable.getColumnModel().getColumn(1).setPreferredWidth(125);
            AirplaneCatalogTable.getColumnModel().getColumn(2).setResizable(false);
            AirplaneCatalogTable.getColumnModel().getColumn(2).setPreferredWidth(110);
            AirplaneCatalogTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setText("View Flight Schedule");

        txtAirliner.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        txtAirliner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAirlinerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Airliner name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:Container.remove(this);
        Container.remove(this);
        CardLayout layout = (CardLayout) Container.getLayout();
        layout.previous(Container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAirlinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAirlinerActionPerformed
        
    }//GEN-LAST:event_txtAirlinerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AirplaneCatalogTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAirliner;
    // End of variables declaration//GEN-END:variables
}