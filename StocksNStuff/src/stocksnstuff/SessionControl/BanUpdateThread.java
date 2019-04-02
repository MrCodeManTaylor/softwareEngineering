/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import javax.swing.table.DefaultTableModel;
import stocksnstuff.database.DBIO.DBAdminIO;

/**
 *
 * @author Mitchell
 */
public class BanUpdateThread {
    private DefaultTableModel tb = new DefaultTableModel();
    
    public void run() {
        DBAdminIO dbA = new DBAdminIO();
        tb = dbA.formatJTable(dbA.getBanList());
    }
    
    
    public DefaultTableModel getStockTableUpdate(){
        return this.tb;
    }
}
