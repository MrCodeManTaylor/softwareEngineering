/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import stocksnstuff.gui.AdminGUI;
import stocksnstuff.gui.UserGUI;

/**
 *
 * @author mtaylo35
 */
public class Logout {
    
    UserGUI uG;
    AdminGUI aG;
    
    public Logout(UserGUI uG){
        this.uG = uG;
    }
    public Logout(AdminGUI aG){
        this.aG = aG;
    }
    public void endSession(){
        if(uG != null)
            uG.dispose();
        else if(aG != null)
            aG.dispose();
    }
}
