/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import stocksnstuff.SessionControl.Login;
import stocksnstuff.SessionControl.TableUpdateThread;
import stocksnstuff.database.DBIO.DBStockReader;
import stocksnstuff.generalResources.STFilter;
import stocksnstuff.generalResources.focusListener;

/**
 *
 * @author mtaylo35
 */
public final class GuestGUI extends javax.swing.JFrame {

    private File regDB;
    private DBStockReader dbS;

    /**
     * Creates new form guestGui
     */
    public GuestGUI() {
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

        main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        login = new javax.swing.JButton();
        userID = new javax.swing.JTextField();
        uPass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockData = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        searchFilter = new javax.swing.JToggleButton();
        recoverUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stocks N Stuff");
        setResizable(false);

        main.setBackground(new java.awt.Color(102, 153, 255));
        main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        main.setForeground(new java.awt.Color(51, 153, 255));
        main.setPreferredSize(new java.awt.Dimension(996, 558));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/StocksnStuffLogoCompact1.png"))); // NOI18N

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        userID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        uPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        uPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uPassActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Live Stock Tracker");

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
        if (stockData.getColumnModel().getColumnCount() > 0) {
            stockData.getColumnModel().getColumn(0).setResizable(false);
            stockData.getColumnModel().getColumn(1).setResizable(false);
            stockData.getColumnModel().getColumn(2).setResizable(false);
            stockData.getColumnModel().getColumn(3).setResizable(false);
            stockData.getColumnModel().getColumn(4).setResizable(false);
            stockData.getColumnModel().getColumn(5).setResizable(false);
            stockData.getColumnModel().getColumn(6).setResizable(false);
        }

        searchField.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        searchField.setText("Search...");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        recoverUser.setText("Recover User");
        recoverUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoverUserActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username/Email");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                                .addComponent(recoverUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(userID, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(14, 14, 14)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(uPass, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uPass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(register)
                                .addComponent(recoverUser))
                            .addComponent(login))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockDataMouseClicked
    }//GEN-LAST:event_stockDataMouseClicked

    private void searchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFilterActionPerformed
        // TODO add your handling code here:

        if (!searchField.getText().isEmpty()) {
            //We need to rebuild the stock table now, utilizing the searchField as a basis
            String searchFilter = searchField.getText();
            STFilter sTF = new STFilter(searchField.getText(), "\\stockDat\\stockData.txt");
            stockData.setModel(sTF.getTModel());
            stockData.setDefaultEditor(Object.class, null);
            stockData.getTableHeader().setResizingAllowed(false);
        } else {
            //Revert to default table state.
            stockData.setModel(dbS.getStockTable());
            stockData.setDefaultEditor(Object.class, null);
            stockData.getTableHeader().setResizingAllowed(false);
        }

    }//GEN-LAST:event_searchFilterActionPerformed

    private void recoverUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoverUserActionPerformed
        // TODO add your handling code here:

        RecoverUserGUI ruG = new RecoverUserGUI();
        ruG.setVisible(true);
    }//GEN-LAST:event_recoverUserActionPerformed

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        // TODO add your handling code here:

        RegistrationFormGUI rf = new RegistrationFormGUI();
        rf.setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        Login loginObj = new Login(regDB);
        if (userID.getText().isEmpty() || uPass.getText().isEmpty()) {

            JOptionPane.showMessageDialog(rootPane, "Username/Password Field Empty...", "Login Error", HEIGHT);
            userID.setText("");
            uPass.setText("");

        } else {
            if (userID.getText().contains("@")) {

                if (loginObj.loginEmail(userID.getText(), uPass.getText())) {
                    if (loginObj.getBanStatus() != 0) {
                        JOptionPane.showMessageDialog(rootPane, "Your account has been suspended...", "User Banned!", HEIGHT);
                        uPass.setText("");
                        userID.setText("");

                    } else if (loginObj.getBanStatus() == 0) {
                        this.dispose();
                        loginObj.startSession(userID.getText());
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid username/password", "Login Error", HEIGHT);
                    uPass.setText("");
                }

            } else {

                if (loginObj.loginUsername(userID.getText(), uPass.getText())) {
                    if (loginObj.getBanStatus() != 0) {
                        JOptionPane.showMessageDialog(rootPane, "Your account has been suspended...", "User Banned!", HEIGHT);
                        uPass.setText("");
                        userID.setText("");

                    } else if (loginObj.getBanStatus() == 0) {
                        this.dispose();
                        loginObj.startSession(userID.getText());
                    }
                } else {
                    if (loginObj.getBanStatus() == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Invalid username/password", "Login Error", HEIGHT);
                        uPass.setText("");
                    }
                }
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    private void uPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uPassActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void setup() {

        try {
            String f = new File(".").getCanonicalPath() + "\\src\\resources\\searchIcon.bmp";
            File file = new File(f);

            Image img;
            img = ImageIO.read(file);
            focusListener fL = new focusListener(searchField, "Search...");
            searchField.addFocusListener(fL.getFocusListener());
            searchFilter.setIcon(new ImageIcon(img));
            try {

                String userDB = new java.io.File(".").getCanonicalPath() + "\\dbs\\register.txt";
                this.regDB = new File(userDB);
                if (!regDB.exists() || !regDB.canRead()) {
                    //user DB doesnt exist (This shouldnt happen)
                    regDB.createNewFile();
                }

                //initialize jtable data
                dbS = new DBStockReader("\\stockDat\\stockData.txt");
                dbS.formatData(dbS.getStockDB(), dbS.getTSize());
                dbS.formatJTable(dbS.getStockData(), dbS.getTSize(), 8);
                stockData.setModel(dbS.getStockTable());
                stockData.setDefaultEditor(Object.class, null);
                stockData.getTableHeader().setResizingAllowed(false);

            } catch (IOException ex) {
                Logger.getLogger(GuestGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(GuestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void liveUpdate(Boolean val) {
        if (val) {
            Timer timer = new Timer(15000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TableUpdateThread tut = new TableUpdateThread();
                    tut.setLoc("\\stockDat\\stockData.txt");
                    tut.run();
                    stockData.setModel(tut.getStockTableUpdate());
                    stockData.setDefaultEditor(Object.class, null);
                    stockData.getTableHeader().setResizingAllowed(false);
                }
            });
            timer.setRepeats(this.isEnabled());
            timer.start();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton login;
    private javax.swing.JPanel main;
    private javax.swing.JButton recoverUser;
    private javax.swing.JButton register;
    private javax.swing.JTextField searchField;
    private javax.swing.JToggleButton searchFilter;
    private javax.swing.JTable stockData;
    private javax.swing.JPasswordField uPass;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
}
