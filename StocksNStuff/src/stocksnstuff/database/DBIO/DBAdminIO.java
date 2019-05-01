/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import javax.swing.table.DefaultTableModel;
import stocksnstuff.generalResources.StringFormatter;

/**
 *
 * @author Mitchell
 */
public class DBAdminIO {
    //class responsible for handling all admin DB relations
    private DefaultTableModel banTable = new DefaultTableModel();
    private DBReader dbr;
    private String[] banList;
    public DBAdminIO(){
        dbr = new DBReader("register.txt");
        banList = dbr.getBanList();
    }
    
    public String[] getBanList(){
        return this.banList;
    }
    
    public DefaultTableModel formatJTable(String[] banList){
        
        StringFormatter sf = new StringFormatter();
        String[] columnNames = sf.segmentLine("Username, Email, Report Count, Previous Ban, Ban Status, Warn Status");
        String[][] rowData = new String[banList.length][6];
        for(int i = 0; i <= banList.length-1; i++){
            String[] lData = sf.segmentLine(banList[i]);
            String banData = lData[1]+", "+lData[0]+", "+lData[10]+", "+lData[11]+", "+lData[8]+", "+lData[9];
            rowData[i] = sf.segmentLine(banData);
        }
        DefaultTableModel model = new DefaultTableModel(columnNames,0);
        for(int i = 0; i <= rowData.length-1; i++){
            model.addRow(rowData[i]);
        }
        return model;
    }
    
    public DefaultTableModel getBanTable(){
        return this.banTable;
    }
}
