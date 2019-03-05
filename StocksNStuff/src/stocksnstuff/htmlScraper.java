/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.*;
import org.jsoup.nodes.Document;

/**
 *
 * @author mtaylo35
 */
public class htmlScraper {

    private File rawDataFile;
    private File filteredDataFile;
    private File stockDataFile;
    private Document doc;

    public htmlScraper() throws IOException {
        instantiateFiles();
    }

    private void instantiateFiles() throws IOException {
        doc = Jsoup.connect("http://www.wsj.com/mdc/public/page/2_3024-NYSE.html").get(); // URL shortened!
        String current = new java.io.File(".").getCanonicalPath();// gets user specific file locations
        File outputDirectory = new File(current + "\\stockDat");
        this.rawDataFile = new File(outputDirectory.toPath() + "\\rawData.txt");
        if (!rawDataFile.exists()) {
            rawDataFile.createNewFile();
        }
        this.filteredDataFile = new File(outputDirectory.toPath() + "\\filteredData.txt");
        if (!filteredDataFile.exists()) {
            filteredDataFile.createNewFile();
        }
        this.stockDataFile = new File(outputDirectory.toPath() + "\\stockData.txt");
        if (!stockDataFile.exists()) {
            stockDataFile.createNewFile();
        }
    }

    public void getRawHtmlData() throws IOException {
        doc = Jsoup.connect("http://www.wsj.com/mdc/public/page/2_3024-NYSE.html").maxBodySize(0).get(); // URL shortened!
        doc.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
        doc.select("br").append("\\n");
        doc.select("p").prepend("\\n\\n");
        String s = doc.html().replaceAll("\\\\n", "\n");

        if (!rawDataFile.canWrite()) {
            System.out.println("Bad WRITE Perms for: " + rawDataFile.toString());
            System.exit(0);
        } else {
            BufferedWriter bw = new BufferedWriter(new FileWriter(rawDataFile));
            bw.write(s);
            bw.close();
            System.out.println("Done writing raw data.");
        }
    }
    public void filterRawStockData() throws IOException {

        Boolean snipFlag = false;
        if (!rawDataFile.canRead() || !filteredDataFile.canWrite()) {
            System.out.println("Bad read/write perms for: " + rawDataFile.toString() + " or " + filteredDataFile.toString());
        } else {
            try {

                BufferedReader br = new BufferedReader(new FileReader(rawDataFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(filteredDataFile));
                String line = br.readLine().trim();
                while (line != null) {
                    if (line.startsWith("<td style=\"padding-left: 5px;\" align=\"left\" height=\"18\"><b>")) {
                        while (!snipFlag) {
                            if (line.endsWith("</span></nobr>&nbsp;</td>")) {
                                bw.write(line);
                                bw.newLine();
                                bw.write("-+-");
                                bw.newLine();
                                bw.flush();
                                snipFlag = true;
                            } else {
                                bw.write(line);
                                bw.newLine();
                                line = br.readLine().trim();
                            }
                        }
                        snipFlag = false;
                    } else {
                        line = br.readLine().trim();
                    }
                }
                bw.close();
            } catch (NullPointerException e) {
                System.out.println("Done filtering raw data.");
            }

        }
    }
    public void segmentStockData() throws IOException {

        if (!filteredDataFile.canRead() || !stockDataFile.canWrite()) {
            System.out.println("Bad READ/WRITE perms for: " + filteredDataFile.toString() + " or " + stockDataFile.toString());
        } else {
            boolean stockDataFlag = false;
            ArrayList<String> formattedData = new ArrayList<String>();
            formattedData.add("Symbol");
            formattedData.add("Open");
            formattedData.add("High");
            formattedData.add("Low");
            formattedData.add("Close");
            formattedData.add("Net Change");
            formattedData.add("Net Change (%)");
            BufferedReader br = new BufferedReader(new FileReader(filteredDataFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(stockDataFile));
            bw.write(generateString(formattedData));
            bw.newLine();
            String line = br.readLine();
            while (line != null) {
                formattedData.clear();
                stockDataFlag = false;
                while (!stockDataFlag) {
                    line = br.readLine();
                    formattedData.add(line.substring(line.lastIndexOf("\">")+2, line.lastIndexOf("</a")));              //Symbol
                    line = br.readLine();
                    formattedData.add(line.substring(10,line.lastIndexOf("</n")));                                      //Open
                    line = br.readLine();
                    formattedData.add(line.substring(10,line.lastIndexOf("</n")));                                      //Close
                    line = br.readLine();
                    formattedData.add(line.substring(10,line.lastIndexOf("</n")));                                      //High
                    line = br.readLine();
                    formattedData.add(line.substring(10,line.lastIndexOf("</n")));                                      //Low
                    line = br.readLine();
                    formattedData.add(line.substring(line.lastIndexOf("\">")+2,line.lastIndexOf("</s")));
                    line = br.readLine();
                    if(line.endsWith("-+-")){
                        bw.write(generateString(formattedData));
                        bw.newLine();
                        bw.flush();
                        stockDataFlag = true;
                    }
                }

                line = br.readLine();
            }
        }
        System.out.println("Done segmenting stock data.");
    }
    private String generateString(ArrayList<String> stringComponents){
        String outputString = "";
        
        for(String s : stringComponents){
            outputString += s + ", ";
        }
        outputString = outputString.substring(0,outputString.length()-2);
        
        return outputString;
    }
}
