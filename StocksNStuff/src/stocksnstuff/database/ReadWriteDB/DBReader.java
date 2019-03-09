/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.ReadWriteDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.StringManips.StringFormatter;

/**
 *
 * @author Mitchell
 */
public class DBReader {
    
    private String path;
    private File userDB;
    private String[] userInfo;
    
    public DBReader(){
        try {
            this.path = new File(".").getCanonicalPath()+"\\dbs\\register.txt";
            this.userDB = new File(path);
        } catch (IOException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public boolean validatePerms(){
        if(!userDB.canRead()||!userDB.canWrite()){
            System.out.println("\nFailure to read/write to DB: "+userDB.toString());
            return false;
        }else{
            return true;
        }
    }
    
    public int scanDBLine(String scanParam, int scanID){
        try {
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            String l = br.readLine();
            int lineNum = 0;
            while(l != null) {
                String[] lDat = l.split(", ");
                if (lDat[scanID].equals(scanParam)) {
                    return lineNum;
                }
                
                
                l = br.readLine();
                lineNum++;
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            //do nuffin
        }
        
        
        return -1;
    }
    
    public boolean scanDB(String scanParam, int scanID){
        try {
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            String l = br.readLine();
            while(l != null) {
                String[] lDat = l.split(", ");
                if (lDat[scanID].equals(scanParam)) {
                    this.userInfo = lDat;
                    return true; 
                }
                
                
                l = br.readLine();
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            //do nuffin
        }
        
        
        return false;
    }
    public String[] getUserIdentity(){
        String[] uID = {userInfo[0],userInfo[1]};
        
        return uID;
    }
    public String[] getSecurityQuestions(){
        
        String[] secDat = {userInfo[3],userInfo[4],userInfo[5],userInfo[6]};
        
        return secDat;
    }
}
