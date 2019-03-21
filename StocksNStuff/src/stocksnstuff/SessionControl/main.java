/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.database.DBIO.DBStockReader;
import stocksnstuff.database.UpdateStockDB.Update;
import stocksnstuff.gui.GuestGUI;

/**
 *
 * @author Mitchell
 */
public class main extends Thread{
 
    private File stockData;
    //Quite literally responsible for maintaining everything...
    public static void main(String[] args){
        
        GuestGUI gG = new GuestGUI();
        gG.setVisible(true);
        updateDB();
        while(true){
            try {
                UpdateThread ut = new UpdateThread();
                ut.run();
                main.sleep(150000);
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static void updateDB() {
        Update u = new Update();
        u.updateDB();
    }
    
    
}
