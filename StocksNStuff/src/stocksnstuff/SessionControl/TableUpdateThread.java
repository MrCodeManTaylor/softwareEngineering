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
        DBStockReader dbS;
        dbS = new DBStockReader();
        if (!dbS.formatStockDB()) {
            System.exit(0);
        } else {
            if (!dbS.formatJTable(dbS.getStockData())) {
                System.exit(0);
            } else {
                this.tb = dbS.getStockTable();
            }

        }
    }
    
    
    public DefaultTableModel getStockTableUpdate(){
        return this.tb;
    }
}
