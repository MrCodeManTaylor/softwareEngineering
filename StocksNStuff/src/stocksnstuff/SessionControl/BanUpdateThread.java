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
public class BanUpdateThread implements Runnable{
    private DefaultTableModel tb = new DefaultTableModel();
    private String loc;
    private Boolean type;
    public BanUpdateThread(String loc, Boolean type){
        this.loc = loc;
        this.type = type;
    }
    @Override
    public void run() {
        if(type){
            DBAdminIO dbA = new DBAdminIO(loc, true);
            tb = dbA.formatJTable(dbA.getBanList());
        }
        else{
            DBAdminIO dbA = new DBAdminIO(loc, false);
            dbA.setPath(loc);
            dbA.populatePostList(dbA.getPath());
            tb = dbA.formatJTable(dbA.getPostList());
        }
    }
    public Boolean getType(){
        return this.type;
    }
    public void setType(Boolean type){
            this.type = type;
    }
    
    public void setLoc(String loc){
        this.loc = loc;
    }
    public DefaultTableModel getStockTableUpdate(){
        return this.tb;
    }
}
