/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.database.DBIO.DBReader;
import stocksnstuff.gui.UserGUI;
import stocksnstuff.gui.AdminGUI;

/**
 *
 * @author mtaylo35
 */
public class Login {

    private File userDB;
    private String[] userData;
    private int banStatus;
    private int accType = 1;
    
    public Login(File userDB) {
        this.userDB = userDB;
    }

    public boolean loginEmail(String email, String password) {
        
        //friendly easter egg for the curious
        if(email.equals("hotdog@picture.jpeg")&&password.equals("goddang")){
            try {
                URI url = new URI("https://www.youtube.com/watch?v=ZXVhOPiM4mk");
                java.awt.Desktop.getDesktop().browse(url);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        DBReader dbR = new DBReader("\\dbs\\register.txt");
        if (!dbR.validatePerms()) {
            return false;
        } else {
            if (!dbR.scanDB(email, 0) || !dbR.validatePWord(password)) {
                return false;
            } else {
                userData = dbR.getUserInfo();
                setAccType();
                isBanned();
                return true;
            }
        }
    }

    public boolean loginUsername(String username, String password) {
        DBReader dbR = new DBReader("\\dbs\\register.txt");
        
        //Friendly easter egg for the curious
        if(username.equals("hotdog")&&password.equals("goddang")){
            try {
                URI url = new URI("https://www.youtube.com/watch?v=ZXVhOPiM4mk");
                java.awt.Desktop.getDesktop().browse(url);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (!dbR.validatePerms()) {
            return false;
        } else {
            if (!dbR.scanDB(username, 1) || !dbR.validatePWord(password)) {
                return false;
            } else {
                userData = dbR.getUserInfo();
                setAccType();
                isBanned();
                return true;
            }
        }
    }

    public void startSession(String name) {

        if(accType == 0){
            AdminGUI aG = new AdminGUI();
            aG.setVisible(true);
        }else{
            UserGUI uG = new UserGUI(name);
            uG.setVisible(true);
        }
    }
    
    public void isBanned(){
        
        if(userData[8].equals("1")){
            this.banStatus = 1;
        }else{
            this.banStatus = 0;
        }
    }
    
    public void setAccType(){
        if(userData[7].equals("0"))
            this.accType = 0;
        else
            this.accType = 1;
    }
    
    public int getBanStatus(){
        return this.banStatus;
    }
    
    public int getAccType(){
        return this.accType;
    }
}
