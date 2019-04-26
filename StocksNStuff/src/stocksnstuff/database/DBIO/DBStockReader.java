/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import stocksnstuff.generalResources.StringFormatter;

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
    
    public DBStockReader() {
        try {
            this.path = new File(".").getCanonicalPath();
            path = path + "\\stockDat\\stockData.txt";
            this.stockDB = new File(path);
            this.tSize = dbf.findTableSize(path);
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
