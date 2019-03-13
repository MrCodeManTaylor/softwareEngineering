/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.gui;

import javax.swing.JOptionPane;
import stocksnstuff.SessionControl.Logout;
import stocksnstuff.StringManips.StringFormatter;
import stocksnstuff.database.DBIO.DBReader;
import stocksnstuff.database.DBIO.DBStockReader;
import stocksnstuff.database.DBIO.DBUserIO;
import stocksnstuff.database.UpdateStockDB.Update;

/**
 *
 * @author mtaylo35
 */
public class UserGUI extends javax.swing.JFrame {

    private String name;

    /**
     * Creates new form UserGUI
     *
     * @param name User identification string
     */
    //Specified Constructor
    public UserGUI(String name) {
        Update u = new Update();
        u.updateDB();
        switch (detectType(name)) {
            case 0:
                DBReader dbR = new DBReader();
                dbR.scanDB(name, 0);
                String[] userDat = dbR.getUserInfo();
                this.name = userDat[1];
                break;
            case 1:
                this.name = name;
                break;
        }
        initComponents();
        DBStockReader dbS = new DBStockReader();
        if (!dbS.formatStockDB()) {
            JOptionPane.showMessageDialog(rootPane, "Something went wrong, quitting...");
        } else {
            if (!dbS.formatStockDB()) {
                JOptionPane.showMessageDialog(rootPane, "Something went wrong, quitting...");
            } else {
                if (!dbS.formatJTable(dbS.getStockData())) {
                    JOptionPane.showMessageDialog(rootPane, "Something went wrong, quitting...");
                } else {
                    stockData.setModel(dbS.getStockTable());
                    stockData.setDefaultEditor(Object.class, null);
                }
            }
        }
    }

    public String formatTitle() {
        return "Stocks N Stuff | " + this.name;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(formatTitle());

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        stockData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Symbol", "Open", "High", "Low", "Close", "Net Change", "Net Change %"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        stockData.getTableHeader().setReorderingAllowed(false);
        stockData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stockData);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logout)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:

        //We need to terminate the session...
        Logout logoutObj = new Logout(this);
        logoutObj.endSession();

        //restore to default state...
        GuestGUI uG = new GuestGUI();
        uG.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    public int detectType(String data) {
        if (data.contains("@")) {
            return 0;
        } else {
            return 1;
        }
    }

    public String[] getRowData(int row) {
        String[] stockDat = new String[7];
        for (int i = 0; i < 7; i++) {
            stockDat[i] = stockData.getValueAt(row, i).toString();
        }
        return stockDat;
    }

    private void stockDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockDataMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int row = stockData.rowAtPoint(evt.getPoint());
            String[] stockDat = getRowData(row);
            String msg = stockData.getValueAt(row, 0).toString();
            String[] options = {"Yes", "No", "Untrack"};
            int response = JOptionPane.showOptionDialog(rootPane, "Add " + msg + " to your tracked stocks?", "Track | " + msg,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (response) {
                case 0:
                    //They wish to track the stock
                    switch (detectType(name)) {
                        case 0:
                            //Email type
                            DBReader dbR = new DBReader();
                            dbR.scanDB(name, 0);
                            String[] userDat = dbR.getUserInfo();
                            StringFormatter sf = new StringFormatter();
                            DBUserIO uIO = new DBUserIO(userDat[1]);
                            uIO.trackStock(sf.formatLine(stockDat));
                            break;
                        case 1:
                            //Username type
                            uIO = new DBUserIO(name);
                            sf = new StringFormatter();
                            uIO.trackStock(sf.formatLine(stockDat));
                            break;
                    }
                    break;
                case 1:
                    //They do not wish to track the stock
                    break;
                case 2:
                    //They wish to untrack the stock
                    switch (detectType(name)) {
                        case 0:
                            DBReader dbR = new DBReader();
                            dbR.scanDB(name, 0);
                            String[] userDat = dbR.getUserInfo();
                            StringFormatter sf = new StringFormatter();
                            DBUserIO uIO = new DBUserIO(userDat[1]);
                            uIO.removeStock(sf.formatLine(stockDat));
                            break;
                        case 1:
                            uIO = new DBUserIO(name);
                            sf = new StringFormatter();
                            uIO.removeStock(sf.formatLine(stockDat));
                            break;
                    }
            }
        }
    }//GEN-LAST:event_stockDataMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JTable stockData;
    // End of variables declaration//GEN-END:variables
}
