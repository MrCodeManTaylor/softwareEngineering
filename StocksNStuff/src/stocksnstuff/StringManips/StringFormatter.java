/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.StringManips;

/**
 *
 * @author mtaylo35
 */

public class StringFormatter {
 
    
    /**
     * 
     * Default Constructor
     */
    public StringFormatter(){
        
    }
    
    public String[] segmentLine(String line){
        if(line!=null){
            String[] segmentedLine = line.split(", ");
            return segmentedLine;
        }
        return null;
    }
    
    public String formatLine(String[] lineData){
        String dataLine = "";
        for(String s : lineData){
            dataLine += s + ", ";
        }
        dataLine = dataLine.substring(0,dataLine.length()-2);
        return dataLine;
    }
}
