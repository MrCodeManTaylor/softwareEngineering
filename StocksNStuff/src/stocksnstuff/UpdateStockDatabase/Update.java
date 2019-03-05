/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.UpdateStockDatabase;

import java.io.IOException;
import stocksnstuff.UpdateStockDatabase.HtmlScraper;

/**
 *
 * @author mtaylo35
 */
public class Update {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        HtmlScraper scraper = new HtmlScraper();
        scraper.getRawHtmlData();
        scraper.filterRawStockData();
        scraper.segmentStockData();
        
    }

}
