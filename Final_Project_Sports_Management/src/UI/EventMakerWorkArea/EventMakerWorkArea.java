/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.EventMakerWorkArea;

import Project.MainSystem;
import Project.Enterprise.Enterprise;
import Project.EventMaker.EventMaker;
import Project.Organization.EventMakerOrganization;
import Project.Organization.Organization;
import Project.UserAccount.UserAccount;
import Project.WorkQueue.VictimWorkRequest;
import Project.WorkQueue.WorkRequestQueue;
import Project.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vedant
 */
public class EventMakerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form EventMakerWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private MainSystem system;
    EventMaker em;
    
    public EventMakerWorkArea(JPanel userProcessContainer,UserAccount account,Organization organization,Enterprise enterprise,MainSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.enterprise=enterprise;
        this.system=system;
        
        for (EventMaker eventmaker : ((EventMakerOrganization)organization).getChangemakerlist().getChangeMakerDirectory()) {
            if (account.getEmployee().getPersonName().equals(eventmaker.getEventMakerName())) {
                 em=eventmaker;
            }
        }
        if (em.getEventMakerWorkQueue() == null) {
            WorkRequestQueue w = new WorkRequestQueue();
            em.setEventMakerWorkQueue(w);
        }
        
        populateTableWorkQueue();
    }
    //populate all the requests from victim work request queue
    public void populateTableWorkQueue(){
         DefaultTableModel model = (DefaultTableModel) tblEvent.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest work : system.getOrgWorkQueue().getWorkRequestList()){
           if(work instanceof VictimWorkRequest){ 
            Object[] row = new Object[10];
            row[0] = work.getSender().getEmployee().getPersonName();
            row[1] = work.getSubject();
            row[2] = ((VictimWorkRequest) work).getDescription();
            row[3] = ((VictimWorkRequest) work).getLocation();
            row[4] = work.getRequestDate();
            row[5] = work;
            row[6] = work.getReciever();
            
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEvent = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnAssignTo = new javax.swing.JButton();
        btnComplete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        txtSubject = new javax.swing.JTextField();
        txtLoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPolice = new javax.swing.JButton();
        btnHealth = new javax.swing.JButton();
        btnFire = new javax.swing.JButton();
        btnNGO = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 235, 255));

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Event Maker Work Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );

        tblEvent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Event Name", "Subject", "Description", "Location", "Date", "Status", "Event Maker"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEvent);

        btnView.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnAssignTo.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnAssignTo.setText("Acknowledge");
        btnAssignTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToActionPerformed(evt);
            }
        });

        btnComplete.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel4.setText("Location");

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        txtSubject.setEditable(false);
        txtSubject.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        txtSubject.setForeground(new java.awt.Color(153, 0, 153));

        txtLoc.setEditable(false);
        txtLoc.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        txtLoc.setForeground(new java.awt.Color(153, 0, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel2.setText("Subject");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel3.setText("Description");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubject)
                    .addComponent(txtLoc)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        jPanel3.setOpaque(false);

        btnPolice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnPolice.setText("Police Department");
        btnPolice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoliceActionPerformed(evt);
            }
        });

        btnHealth.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHealth.setText("Health Department");
        btnHealth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHealthActionPerformed(evt);
            }
        });

        btnFire.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFire.setText("Fire Department");
        btnFire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPolice, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(btnFire, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnNGO.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNGO.setText("NGO");
        btnNGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNGOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnNGO, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNGO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnAssignTo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssignTo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    //assign the request to me
    private void btnAssignToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "To allocate the account, please choose the row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            VictimWorkRequest cswr = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            
            if(cswr.getStatus().equalsIgnoreCase("Requested")){

            cswr.setStatus("Pending");
            cswr.setReciever(account);

            populateTableWorkQueue();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnAssignToActionPerformed
    //view the request 
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "To allocate the account, please choose the row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            
            
            VictimWorkRequest p = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            
            txtSubject.setText(p.getSubject());
            txtDesc.setText(p.getDescription());
            txtLoc.setText(p.getLocation());
        }
    }//GEN-LAST:event_btnViewActionPerformed
    //complete the assigned request
    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "To allocate the account, please choose the row", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            VictimWorkRequest p = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
           
            if(p.getStatus().equalsIgnoreCase("Pending")){


                    p.setStatus("Complete");
                    JOptionPane.showMessageDialog(null, "You have completed the request successfully");
                    populateTableWorkQueue();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnCompleteActionPerformed
    //assign request to NGO
    private void btnNGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNGOActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please choose the row to forward request to the NGO", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            

            VictimWorkRequest cswr = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            if(cswr.getStatus().equalsIgnoreCase("Requested")){
            cswr.setStatus("Assigned To NGO");
            populateTableWorkQueue();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btnNGOActionPerformed
    //assign request to healthcare
    private void btnHealthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHealthActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please choose the row to forward request to the Doctor", "Warning", JOptionPane.WARNING_MESSAGE);
        } else{
            
            VictimWorkRequest cswr = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            if(cswr.getStatus().equals("Assigned To Doctor")){
                JOptionPane.showMessageDialog(null, "This request is already assigned to Doctor", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            
            else{
                
            if(cswr.getStatus().equalsIgnoreCase("Requested")){
            JOptionPane.showMessageDialog(null, "Assigned to the Doctor");
            cswr.setStatus("Assigned To Doctor");

            populateTableWorkQueue();
            }
            else{
                JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
            }
    } 
        }
    }//GEN-LAST:event_btnHealthActionPerformed
    //assign request to police
    private void btnPoliceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoliceActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please choose the row to forward request to the Police", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            VictimWorkRequest cswr = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            if(cswr.getStatus().equals("Assigned to the Police")){
                JOptionPane.showMessageDialog(null, "This request is already assigned to Police", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
               if(cswr.getStatus().equalsIgnoreCase("Requested")){ 
            JOptionPane.showMessageDialog(null, "Assigned to the Police", "Warning", JOptionPane.WARNING_MESSAGE);
            cswr.setStatus("Assigned To Police");
            populateTableWorkQueue();
            }
               else{
                   JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
               }
            }
            
        }
    }//GEN-LAST:event_btnPoliceActionPerformed
    //assign request to fire department
    private void btnFireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFireActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEvent.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please choose the row to forward request to the FireMan", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            VictimWorkRequest cswr = (VictimWorkRequest) tblEvent.getValueAt(selectedRow, 5);
            if(cswr.getStatus().equals("Assigned to the FireMan")){
                JOptionPane.showMessageDialog(null, "This request is already assigned to FireMan", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                if(cswr.getStatus().equalsIgnoreCase("Requested")){ 
                   
                JOptionPane.showMessageDialog(null, "Assigned to the FireMan", "Warning", JOptionPane.WARNING_MESSAGE);
                cswr.setStatus("Assigned To FireMan");
                populateTableWorkQueue();
            }
                else{
                     JOptionPane.showMessageDialog(null, "Wrong Request", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnFireActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignTo;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnFire;
    private javax.swing.JButton btnHealth;
    private javax.swing.JButton btnNGO;
    private javax.swing.JButton btnPolice;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEvent;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtLoc;
    private javax.swing.JTextField txtSubject;
    // End of variables declaration//GEN-END:variables
}
