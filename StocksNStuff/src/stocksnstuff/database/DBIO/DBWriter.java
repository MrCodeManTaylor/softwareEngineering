/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import stocksnstuff.generalResources.StringFormatter;

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
    
    public boolean updateField(String uID, String param, int fieldNum, ArrayList<String> dbData) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(userDB));
            StringFormatter sf = new StringFormatter();
            for(String line : dbData){
                String[] lineData = sf.segmentLine(line);
                if(uID.equals(lineData[0])||uID.equals(lineData[1])){
                    //Correct line, now update
                    lineData[fieldNum] = param;
                    bw.write(sf.formatLine(lineData));
                    bw.newLine();
                    
                }else{
                    bw.write(line);
                    bw.newLine();
                }
            }
            bw.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException e){
            return false;
        }
        
    }
    
}
