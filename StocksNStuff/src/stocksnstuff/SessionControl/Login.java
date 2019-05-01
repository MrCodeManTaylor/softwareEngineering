/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
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
        DBReader dbR = new DBReader("register.txt");
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
        DBReader dbR = new DBReader("register.txt");
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
