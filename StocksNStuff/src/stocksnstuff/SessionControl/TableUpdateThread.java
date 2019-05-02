/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import javax.swing.table.DefaultTableModel;
import stocksnstuff.database.DBIO.DBStockReader;

/**
 *
 * @author Mitchell
 */
public class TableUpdateThread implements Runnable {
    private String loc;
    public DefaultTableModel tb = new DefaultTableModel();
    
    @Override
    public void run() {
        DBStockReader dbS;
        dbS = new DBStockReader(this.loc);
        dbS.formatData(dbS.getStockDB(), dbS.getTSize());
        dbS.formatJTable(dbS.getStockData(), dbS.getTSize(), 8);
        this.tb = dbS.getStockTable();

    }
    
    public void setLoc(String loc){
        this.loc = loc;
    }
    
    public DefaultTableModel getStockTableUpdate() {
        return this.tb;
    }
}
