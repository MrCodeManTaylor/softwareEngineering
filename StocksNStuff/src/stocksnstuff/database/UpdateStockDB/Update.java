/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.UpdateStockDB;

import java.io.IOException;

/**
 *
 * @author mtaylo35
 */
public class Update {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){

    }

    public void updateDB() {
        try {
            HtmlScraper scraper = new HtmlScraper();
            scraper.getRawHtmlData();
            scraper.filterRawStockData();
            scraper.segmentStockData();
        } catch (IOException ex) {
            //Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
