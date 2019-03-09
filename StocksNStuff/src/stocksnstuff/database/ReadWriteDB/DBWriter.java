/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.ReadWriteDB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mitchell
 */
public class DBWriter {
 
    private String path;
    private File userDB;
    private String[] userInfo;
    
    public DBWriter(){
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
    
    public void updateField(String param, int fieldNum) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            BufferedWriter bw = new BufferedWriter(new FileWriter(userDB));
            DBReader dbR = new DBReader();
            skipToLine(dbR.scanDBLine(param, fieldNum),br);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e){
            
        }
        
    }
    
    public void skipToLine(int lineNum, BufferedReader br) throws IOException{
        for(int i = 0; i < lineNum; i++){
            br.readLine();
        }
    }
    
}
