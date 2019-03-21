/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import stocksnstuff.database.DBIO.DBStockReader;

/**
 *
 * @author Mitchell
 */
public class TableUpdateThread implements Runnable {

    public DefaultTableModel tb = new DefaultTableModel();
    
    @Override
    public void run() {
        System.out.println("Table update start");
        DBStockReader dbS;
        dbS = new DBStockReader();
        if (!dbS.formatStockDB()) {
            System.exit(0);
        } else {
            if (!dbS.formatJTable(dbS.getStockData())) {
                System.exit(0);
            } else {
                try {
                    this.tb = dbS.getStockTable();
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TableUpdateThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    
    public DefaultTableModel getStockTableUpdate(){
        return this.tb;
    }
}
