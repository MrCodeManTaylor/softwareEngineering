/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

/**
 *
 * @author mtaylo35
 */

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class DBForumReader {
    
    private File forumDB;
    private String path;
    private String[] forumData;
    private DefaultTableModel forumTable;
    private int tSize;
    private DBFuncs dbf = new DBFuncs();
    
    //Default Constructor
    public DBForumReader(String loc, int type){
        try {
            if(type == 0){
                this.path = new File(".").getCanonicalPath();
                path = path + "\\dbs\\"+loc;
                this.forumDB = new File(path);
                this.tSize = dbf.findTableSize(path);
            }else{
                this.path = new File(".").getCanonicalPath() + "\\dbs\\threads\\"+loc+"\\main.txt";
                this.forumDB = new File(path);
                this.tSize = dbf.findTableSize(path);
            }
        } catch (IOException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void formatData(File forumDB, int tSize) {
        this.forumData = dbf.formatData(forumDB, tSize);
    }
    public void formatJTable(String[] forumData, int tSize, int cols){
        this.forumTable = dbf.formatJTable(forumData, tSize, cols);
    }
    public String[] getForumData(){
        return this.forumData;
    }
    public File getForumDB(){
        return this.forumDB;
    }
    public DefaultTableModel getForumTable(){    
        return this.forumTable;
    }
    public int getTSize(){
        return this.tSize;
    }
    
}
