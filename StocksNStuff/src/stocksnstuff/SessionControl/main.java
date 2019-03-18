/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.gui.GuestGUI;

/**
 *
 * @author Mitchell
 */
public class main {
 
    public File stockData;
    
    //Quite literally responsible for maintaining everything...
    public static void main(String[] args){
        
        GuestGUI gG = new GuestGUI();
        while(true){
            try {
                //update DB after timer sequence | note 300,000 = 5 minutes
                Thread.sleep(1000);
                System.out.println("1 second");
                
            } catch (InterruptedException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
