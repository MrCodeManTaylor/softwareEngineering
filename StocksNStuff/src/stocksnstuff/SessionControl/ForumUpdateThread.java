/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import javax.swing.table.DefaultTableModel;
import stocksnstuff.database.DBIO.DBForumReader;

/**
 *
 * @author Mitchell
 */
public class ForumUpdateThread implements Runnable {

    public DefaultTableModel tb = new DefaultTableModel();
    private String target;
    @Override
    public void run() {
        DBForumReader dbf;
        dbf = new DBForumReader(target,0);
        dbf.formatData(dbf.getForumDB(), dbf.getTSize());
        dbf.formatJTable(dbf.getForumData(), dbf.getTSize(), 2);
        this.tb = dbf.getForumTable();

    }

    public void setTarget(String target){
        this.target = target;
    }
    public DefaultTableModel getForumTableUpdate() {
        return this.tb;
    }
}
