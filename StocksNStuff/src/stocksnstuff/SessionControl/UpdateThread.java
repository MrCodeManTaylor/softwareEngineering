/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import stocksnstuff.database.UpdateStockDB.Update;

/**
 *
 * @author Mitchell
 */
public class UpdateThread implements Runnable {

    @Override
    public void run() {
        Update u = new Update();
        u.updateDB();
    }
    
}
