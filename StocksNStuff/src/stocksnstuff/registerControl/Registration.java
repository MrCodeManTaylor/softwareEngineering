/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.registerControl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class responsible for handling registration events
 *
 * @author mtaylo35
 */
public class Registration {

    private File regDB;
    private int regFailCode;
    
    //default constructor requires no input
    public Registration() {
        try {
            String dbLoc = new java.io.File(".").getCanonicalPath() + "\\dbs\\register.txt";
            this.regDB = new File(dbLoc);
            if (!regDB.exists()) { //Upon first registration, create register db
                regDB.createNewFile();
            } else {
                if (!regDB.canRead()) {
                    System.out.println("DBfile register.txt has invalid READ perms");
                    System.exit(0);
                } else if (!regDB.canWrite()) {
                    System.out.println("DBfile register.txt has invalid WRITE perms");
                    System.exit(0);
                }
            }
        } catch (IOException E) {
            System.out.println("unable to locate regDB file");
        }
    }

    public String formatUserInfo() {
        String userInfo = "";

        return userInfo;
    }

    public boolean detectValidity(String emailAddress, String username) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(regDB));
            String line = br.readLine();
            while(line != null){
                if(line.contains(emailAddress)){
                    
                    this.regFailCode = 1;
                    return false;
                }
                else if(line.contains(username)){
                    this.regFailCode = 2;
                    return false;
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find DB file register.txt");
        } catch (IOException ex) {
            System.out.println("Unable to read line, end of file detected.");
        }
        
        
        return true;
    }
    public int getRegFailCode(){
        
        return this.regFailCode;
    }
}
