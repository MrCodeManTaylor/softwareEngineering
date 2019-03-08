/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.StringManips.StringFormatter;
import stocksnstuff.UserGuiMain.UserGUI;

/**
 *
 * @author mtaylo35
 */
public class Login {
    
    private File userDB;
    
    public Login(File userDB){
        this.userDB = userDB;
    }
    
   public boolean loginEmail(String email, String password) {
       
        try {
            StringFormatter sf = new StringFormatter();
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            String line = br.readLine();
            String[] lineData = sf.segmentLine(line);
            while(line != null){
                if(lineData[0].equals(email) && lineData[2].equals(password)){
                    //Credentials validated, allow session creation
                    return true;
                }
                line = br.readLine();
                lineData = sf.segmentLine(line);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
       return false;
   } 
    public boolean loginUsername(String username, String password) {
       
        try {
            StringFormatter sf = new StringFormatter();
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            String line = br.readLine();
            String[] lineData = sf.segmentLine(line);
            while(line != null){
                if(lineData[1].equals(username) && lineData[2].equals(password)){
                    //Credentials validated, allow session creation
                    return true;
                }
                line = br.readLine();
                lineData = sf.segmentLine(line);
            }
            
            //Terminate request
            return false;
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
       return false;
   } 

    public void startSession(String name){
        
        UserGUI uG = new UserGUI(name);
        uG.setVisible(true);
        
        
    }
}
