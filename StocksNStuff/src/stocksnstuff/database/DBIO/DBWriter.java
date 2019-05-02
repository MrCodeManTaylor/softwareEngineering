/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
    private File DB;
    private String[] userInfo;
    private ArrayList<String> data;
    
    public DBWriter(String loc){
        try {
            this.path = new File(".").getCanonicalPath()+"\\dbs\\"+loc;
            this.DB = new File(path);
            readDat();
        } catch (IOException ex) {
            Logger.getLogger(DBReader.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void readDat(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            data = new ArrayList<>();
            String l = br.readLine();
            while(l!=null){
                data.add(l);
                l = br.readLine();
            }
            br.close();
        }catch(IOException E){
            
        }
    }

    public void writeLine(String lineData){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for(String line : data){
                bw.write(line);
                bw.newLine();
            }
            bw.write(lineData);
            bw.close();
            
        }catch(IOException e){
            
        }
    }
    
    public boolean validatePerms(){
        if(!DB.canRead()||!DB.canWrite()){
            System.out.println("\nFailure to read/write to DB: "+DB.toString());
            return false;
        }else{
            return true;
        }
    }
    public void updatePost(String poster, String title, String flag){
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DB));
            StringFormatter sf = new StringFormatter();
            for(String line : data){
                String[] lineData = sf.segmentLine(line);
                if(lineData[1].equals(poster)&&lineData[2].equals(title))
                    lineData[11] = flag;
                bw.write(sf.formatLine(lineData));
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(DBWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public boolean updateField(String uID, String param, int fieldNum, ArrayList<String> dbData) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(DB));
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
