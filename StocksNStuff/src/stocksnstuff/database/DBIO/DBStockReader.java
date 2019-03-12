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
import stocksnstuff.StringManips.StringFormatter;

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
    
    public DBStockReader() {
        try {
            this.path = new File(".").getCanonicalPath();
            this.stockDB = new File(path + "\\stockDat\\stockData.txt");
        } catch (IOException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean formatStockDB() {

        try {
            if (!stockDB.canRead()) {
                return false;
            } else {
                tSize = findTableSize();
                stockData = new String[tSize];
                BufferedReader br = new BufferedReader(new FileReader(stockDB));
                String line = br.readLine();
                stockData[0] = line;
                int i = 0;
                while(i < tSize - 1){
                    i++;
                    line = br.readLine();
                    stockData[i] = line;
                }
                return true;
            }

        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }

    }
    
    private int findTableSize() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(stockDB));
        int i = 0;
        while(br.readLine()!=null){
            i++;
        }
        return i;
    }
    
    
    public boolean formatJTable(String[] stockData){
        
        if(stockData.length == 0)
            return false;
        StringFormatter sf = new StringFormatter();
        String[] columnNames = sf.segmentLine(stockData[0]);
        String[][] rowData = new String[tSize][8];
        for(int i = 0; i < stockData.length-1; i++){
            rowData[i] = sf.segmentLine(stockData[i+1]);
        }
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(int i = 0; i < rowData.length-1; i++)
            model.addRow(rowData[i]);
        this.stockTable = model;
        return true;
    }
    
    public String[] getStockData(){
        return this.stockData;
    }
    public DefaultTableModel getStockTable(){
        
        return this.stockTable;
    }
    
}
