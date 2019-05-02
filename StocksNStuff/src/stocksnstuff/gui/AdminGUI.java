/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import stocksnstuff.SessionControl.BanUpdateThread;
import stocksnstuff.SessionControl.Logout;
import stocksnstuff.database.DBIO.DBAdminIO;
import stocksnstuff.database.DBIO.DBReader;
import stocksnstuff.database.DBIO.DBWriter;

/**
 *
 * @author Mitchell
 */
public class AdminGUI extends javax.swing.JFrame {

    private File regDB;

    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {

        initComponents();
        setup();
        liveUpdate(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accActions = new javax.swing.ButtonGroup();
        postActions = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        banU = new javax.swing.JRadioButton();
        warnU = new javax.swing.JRadioButton();
        clearU = new javax.swing.JRadioButton();
        eaButton1 = new javax.swing.JButton();
        unbanU = new javax.swing.JRadioButton();
        unwarnU = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pReportTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        clearP = new javax.swing.JRadioButton();
        deleteP = new javax.swing.JRadioButton();
        reportU = new javax.swing.JRadioButton();
        warnU2 = new javax.swing.JRadioButton();
        eaButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stocks N Stuff | Administrator");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(425, 391));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pending Reports");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Email", "Report count", "Previous Ban", "Ban Status", "Warn Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(425, 391));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Account Actions");

        accActions.add(banU);
        banU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        banU.setText("Ban User");
        banU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banUActionPerformed(evt);
            }
        });

        accActions.add(warnU);
        warnU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        warnU.setText("Warn User");
        warnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warnUActionPerformed(evt);
            }
        });

        accActions.add(clearU);
        clearU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clearU.setText("Clear User");
        clearU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearUActionPerformed(evt);
            }
        });

        eaButton1.setText("Enforce Action");
        eaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eaButton1ActionPerformed(evt);
            }
        });

        accActions.add(unbanU);
        unbanU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        unbanU.setText("Unban User");
        unbanU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unbanUActionPerformed(evt);
            }
        });

        accActions.add(unwarnU);
        unwarnU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        unwarnU.setText("Unwarn User");
        unwarnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unwarnUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eaButton1)
                    .addComponent(unbanU)
                    .addComponent(unwarnU)
                    .addComponent(clearU)
                    .addComponent(banU)
                    .addComponent(jLabel3)
                    .addComponent(warnU))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(banU)
                .addGap(5, 5, 5)
                .addComponent(warnU)
                .addGap(5, 5, 5)
                .addComponent(clearU)
                .addGap(5, 5, 5)
                .addComponent(unbanU)
                .addGap(5, 5, 5)
                .addComponent(unwarnU)
                .addGap(9, 9, 9)
                .addComponent(eaButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("Reported Users", jPanel2);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Pending Reports");

        pReportTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Created by", "Stock code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pReportTable.setRowHeight(24);
        jScrollPane2.setViewportView(pReportTable);
        if (pReportTable.getColumnModel().getColumnCount() > 0) {
            pReportTable.getColumnModel().getColumn(0).setResizable(false);
            pReportTable.getColumnModel().getColumn(1).setResizable(false);
            pReportTable.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Post Actions");

        postActions.add(clearP);
        clearP.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clearP.setText("Clear Post");
        clearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPActionPerformed(evt);
            }
        });

        postActions.add(deleteP);
        deleteP.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deleteP.setText("Delete Post");
        deleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePActionPerformed(evt);
            }
        });

        postActions.add(reportU);
        reportU.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        reportU.setText("Report User");
        reportU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportUActionPerformed(evt);
            }
        });

        postActions.add(warnU2);
        warnU2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        warnU2.setText("Warn User");
        warnU2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warnU2ActionPerformed(evt);
            }
        });

        eaButton2.setText("Enforce Action");
        eaButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eaButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(eaButton2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(warnU2))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteP)
                            .addComponent(reportU)
                            .addComponent(clearP)
                            .addComponent(jLabel6))))
                .addGap(53, 53, 53))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearP)
                .addGap(18, 18, 18)
                .addComponent(deleteP)
                .addGap(18, 18, 18)
                .addComponent(reportU)
                .addGap(18, 18, 18)
                .addComponent(warnU2)
                .addGap(40, 40, 40)
                .addComponent(eaButton2)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reported Posts", jPanel4);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Control Center");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/StocksnStuffLogoCompact1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(logout)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(logout)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:

        //We need to terminate the session...
        Logout logoutObj = new Logout(this);
        logoutObj.endSession();

        //restore to default state...
        GuestGUI gG = new GuestGUI();
        gG.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void unwarnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unwarnUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unwarnUActionPerformed

    private void unbanUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unbanUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unbanUActionPerformed

    private void eaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eaButton1ActionPerformed
        // TODO add your handling code here:
        DBReader dbR = new DBReader("\\dbs\\register.txt");
        DBWriter dbW = new DBWriter("register.txt");
        if (banU.isSelected()) {
            if (jTable1.getSelectedRow() != -1) {
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "1", 8, dbR.getDBData());
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "1", 11, dbR.getDBData());
            }
        } else if (clearU.isSelected()) {
            if (jTable1.getSelectedRow() != -1) {
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "0", 8, dbR.getDBData());
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "0", 9, dbR.getDBData());
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "0", 10, dbR.getDBData());
            }
        } else if (warnU.isSelected()) {
            if (jTable1.getSelectedRow() != -1) {
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "1", 9, dbR.getDBData());
            }
        } else if (unbanU.isSelected()) {
            if (jTable1.getSelectedRow() != -1) {
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "0", 8, dbR.getDBData());
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "1", 11, dbR.getDBData());
            }
        } else if (unwarnU.isSelected()) {
            if (jTable1.getSelectedRow() != -1) {
                dbW.updateField(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString(), "0", 9, dbR.getDBData());
            }
        } else {
            //Do nothing
        }
    }//GEN-LAST:event_eaButton1ActionPerformed

    private void clearUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearUActionPerformed

    private void warnUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warnUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warnUActionPerformed

    private void banUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_banUActionPerformed

    private void clearPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearPActionPerformed

    private void deletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deletePActionPerformed

    private void reportUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportUActionPerformed

    private void warnU2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warnU2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warnU2ActionPerformed

    private void eaButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eaButton2ActionPerformed
        // Enforce action post button
        DBReader dbR = new DBReader("\\dbs\\threads\\"+pReportTable.getValueAt(pReportTable.getSelectedRow(),2)+"\\main.txt");
        DBWriter dbW = new DBWriter("\\threads\\"+pReportTable.getValueAt(pReportTable.getSelectedRow(),2)+"\\main.txt");
        String poster = pReportTable.getValueAt(pReportTable.getSelectedRow(),0).toString();
        String title = pReportTable.getValueAt(pReportTable.getSelectedRow(),1).toString();
        String thread = pReportTable.getValueAt(pReportTable.getSelectedRow(),2).toString();
        if(clearP.isSelected()){
            if(pReportTable.getSelectedRow() != -1){
                dbW.updatePost(poster, thread, "0");
            }
        }else if(deleteP.isSelected()){
            if(pReportTable.getSelectedRow() != -1){
                //Delete post!
                dbW.deleteLine(poster, title);
            }
        }else if(reportU.isSelected()){
            if(pReportTable.getSelectedRow() != -1){
                dbR = new DBReader("\\dbs\\register.txt");
                dbW = new DBWriter("register.txt");
                dbW.updateField(poster, "1", 10, dbR.getDBData());
            }
        }else if(warnU2.isSelected()){
            if(pReportTable.getSelectedRow() != -1){
                dbR = new DBReader("\\dbs\\register.txt");
                dbW = new DBWriter("register.txt");
                dbW.updateField(poster, "1", 9, dbR.getDBData());
            }
        }
    }//GEN-LAST:event_eaButton2ActionPerformed

    private void setup() {

        DBAdminIO dbA = new DBAdminIO("\\dbs\\register.txt", true);
        jTable1.setModel(dbA.formatJTable(dbA.getBanList()));
        jTable1.setDefaultEditor(Object.class, null);
        dbA.setPath("\\dbs\\threads\\");
        dbA.populatePostList(dbA.getPath());
        pReportTable.setModel(dbA.formatJTable(dbA.getPostList()));
        pReportTable.setDefaultEditor(Object.class, null);
        pReportTable.getTableHeader().setResizingAllowed(false);

    }

    private void liveUpdate(Boolean val) {

        if (val) {
            Timer timer = new Timer(15000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BanUpdateThread but = new BanUpdateThread("\\dbs\\register.txt", true);
                    but.run();
                    jTable1.setModel(but.getStockTableUpdate());
                    jTable1.setDefaultEditor(Object.class, null);
                    but.setLoc("\\dbs\\threads\\");
                    but.setType(false);
                    but.run();
                    pReportTable.setModel(but.getStockTableUpdate());
                    pReportTable.setDefaultEditor(Object.class, null);
                    pReportTable.getTableHeader().setResizingAllowed(false);
                }
            });
            timer.setRepeats(this.isEnabled());
            timer.start();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup accActions;
    private javax.swing.JRadioButton banU;
    private javax.swing.JRadioButton clearP;
    private javax.swing.JRadioButton clearU;
    private javax.swing.JRadioButton deleteP;
    private javax.swing.JButton eaButton1;
    private javax.swing.JButton eaButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logout;
    private javax.swing.JTable pReportTable;
    private javax.swing.ButtonGroup postActions;
    private javax.swing.JRadioButton reportU;
    private javax.swing.JRadioButton unbanU;
    private javax.swing.JRadioButton unwarnU;
    private javax.swing.JRadioButton warnU;
    private javax.swing.JRadioButton warnU2;
    // End of variables declaration//GEN-END:variables
}
