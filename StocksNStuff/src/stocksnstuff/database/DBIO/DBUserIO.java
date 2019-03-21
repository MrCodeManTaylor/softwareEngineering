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
public class DBUserIO {

    File userDB;
    ArrayList<String> userDBData = new ArrayList<>();

    public DBUserIO(String userID) {
        try {
            String s = new File(".").getCanonicalPath();
            userDB = new File(s + "\\dbs\\users\\" + userID + ".txt");
            if (!detectValidity()) {
                Logger.getLogger(DBUserIO.class.getName()).log(Level.SEVERE, null, "User DB error");
                System.exit(1);
            }else{
                fillData();
            }
            //DB Initialized and has correct perms for IO

        } catch (IOException ex) {
            Logger.getLogger(DBUserIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean detectValidity() {
        if (userDB.exists()) {
            return !(!userDB.canRead() || !userDB.canWrite());
        }
        return false;
    }
    
    private boolean isAlreadyTracked(String stockName) throws FileNotFoundException, IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(userDB));
        StringFormatter sf = new StringFormatter();
        String line = br.readLine();
        String[] l = new String[7];
        
        while(line != null){
            l = sf.segmentLine(line);
            if(l[0].equals(stockName)){
                //Stock already tracked
                return true;
            }
            line = br.readLine();
        }
        
        return false;
    }
    
    public void trackStock(String stockData) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(userDB,true));
            StringFormatter sf = new StringFormatter();
            if(!isAlreadyTracked(sf.segmentLine(stockData)[0])){
                bw.write(stockData);
                bw.newLine();
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(DBUserIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public final void fillData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(userDB));
            String l = br.readLine();
            while(l != null){
                userDBData.add(l);
                l = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBUserIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBUserIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeStock(String stockData){
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(userDB));
            StringFormatter sf = new StringFormatter();
            String[] l = new String[7];
            for(String line : userDBData){
                l = sf.segmentLine(line);
                if(!l[0].equals(sf.segmentLine(stockData)[0])){
                    bw.write(line);
                    bw.newLine();
                }
            }
            bw.close();
            
        }catch (IOException ex){
        }
    }
}
