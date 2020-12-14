/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AgencyManagerRole;
import Business.Airliner;
import Business.Fleet;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Unicorn
 */
public class ViewAirliner extends javax.swing.JPanel {
    private JPanel Container;
    private Airliner airliner;
    /**
     * Creates new form ViewAirliner
     */
    public ViewAirliner(JPanel Container, Airliner airliner) {
        initComponents();
        this.airliner = airliner;
        this.Container = Container;
        txtAirlinerName.setText(airliner.getAirlineName());
        refreshTable();
    }

    public void refreshTable(){
//        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) tableFleet.getModel();
        /*for(int i=rowCount - 1;i>=0;i--){
        model.removeRow(i);
        }*/
        model.setRowCount(0);
        
        for(Fleet f: airliner.getFleetCatalog().getFleetList()){
            Object row[] = new Object[2];
            row[0] = f.getFleetId();
            row[1] = f.getAirplaneCatalog().getAirplaneCatalog().size();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAirlinerName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFleet = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel1.setText("View Airliner");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Airliner Name:");

        txtAirlinerName.setEditable(false);
        txtAirlinerName.setBackground(new java.awt.Color(204, 204, 204));
        txtAirlinerName.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        tableFleet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "FleetId", "Airplane Numbers"
            }
        ));
        jScrollPane1.setViewportView(tableFleet);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(353, 353, 353)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAirlinerName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBack)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAirlinerName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
      Container.remove(this);
      CardLayout layout = (CardLayout) Container.getLayout();
      layout.previous(Container);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFleet;
    private javax.swing.JTextField txtAirlinerName;
    // End of variables declaration//GEN-END:variables
}
