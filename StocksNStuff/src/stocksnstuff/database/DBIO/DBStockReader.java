/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Mitchell
 */
public class DBStockReader {

    private File stockDB;
    private String path;
    private String[] stockData;
    private DefaultTableModel stockTable;
    private int tSize;
    private DBFuncs dbf = new DBFuncs();
    
    public DBStockReader(String path) {
        try {
            this.path = new File(".").getCanonicalPath();
            this.path = this.path + path;
            this.stockDB = new File(this.path);
            this.tSize = dbf.findTableSize(this.path);
        } catch (IOException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void formatData(File stockDB, int tSize) {
        this.stockData = dbf.formatData(stockDB, tSize);
    }
    public void formatJTable(String[] stockData, int tSize, int cols){
        this.stockTable = dbf.formatJTable(stockData, tSize, cols);
    }
    public String[] getStockData(){
        return this.stockData;
    }
    public File getStockDB(){
        return this.stockDB;
    }
    public DefaultTableModel getStockTable(){    
        return this.stockTable;
    }
    public int getTSize(){
        return this.tSize;
    }
    
}
