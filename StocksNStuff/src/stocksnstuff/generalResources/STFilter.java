/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.generalResources;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import stocksnstuff.database.DBIO.DBStockReader;

/**
 *
 * @author Mitchell
 */
public class STFilter {
    
    private ArrayList<String> fDat = new ArrayList<>();
    private int tSize;
    private DefaultTableModel tModel;
    
    public STFilter(String filterParam){
        filterStock(filterParam.toUpperCase());
        formatJTable();
    }
    
    private void filterStock(String filterParam){
        DBStockReader db = new DBStockReader();
        StringFormatter sf = new StringFormatter();
        db.formatData(db.getStockDB(),db.getTSize());
        String[] rawData = db.getStockData();
        for(int i = 0; i < rawData.length-1; i++){
            String[] lDat = sf.segmentLine(rawData[i]);
            if(lDat[0].contains(filterParam)){
                fDat.add(rawData[i]);
                tSize++;
            }
        }
    }
    
    private void formatJTable(){
        
        StringFormatter sf = new StringFormatter();
        String[] columnNames = new String[7];
        columnNames[0] = "Symbol";
        columnNames[1] = "Open";
        columnNames[2] = "High";
        columnNames[3] = "Low";
        columnNames[4] = "Close";
        columnNames[5] = "Net Change";
        columnNames[6] = "Net Change %";
        String[][] rowData = new String[tSize][8];
        int i = 0;
        for(String s : fDat){
            rowData[i] = sf.segmentLine(s);
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(i = 0; i <= rowData.length-1; i++){
            model.addRow(rowData[i]);
        }
        this.tModel = model;
    }
    
    public DefaultTableModel getTModel(){
        
        return this.tModel;
    }
    
    public ArrayList<String> getFDat(){
        return this.fDat;
    }
}
