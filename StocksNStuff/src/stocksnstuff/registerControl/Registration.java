/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.registerControl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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

    public String formatUserInfo(String email, String username, String password, String sq1, String sqr1, String sq2, String sqr2) {
        String userInfo = "";
        userInfo = email + ", " + username + ", " + password + ", " + sq1 + ", " + sqr1 + ", " + sq2 + ", " + sqr2;
        
        return userInfo;
    }
    
    public boolean verifyEmail(String email){
        boolean isValid = false;
        
        try {
            
            InternetAddress ia = new InternetAddress(email);
            ia.validate();
            return true;
            
        } catch (AddressException ex) {
            //Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return isValid;
    }
    
    public boolean checkMatch(String str1, String str2){
        
        if(str1.equals(str2)){
            return true;
        }
        
        return false;
    }
    
    public boolean detectValidity(String emailAddress, String username) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(regDB));
            String line = br.readLine();
            String[] segments;
            while(line != null){
                segments = line.split(", ");
                if(segments[0].equals(emailAddress)){
                    this.regFailCode = 1;
                    return false;
                }
                else if(segments[1].equals(username)){
                    this.regFailCode = 2;
                    return false;
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find DB file register.txt");
        } catch (IOException ex) {
            System.out.println("Unable to read line, end of file detected.");
        }
        
        
        return true;
    }
    
    public void updateDB(String userData){
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(regDB, true));
            bw.write(userData);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getRegFailCode(){
        
        return this.regFailCode;
    }
}
