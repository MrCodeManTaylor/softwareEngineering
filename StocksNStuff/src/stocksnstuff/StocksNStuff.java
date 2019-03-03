/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff;

import java.io.IOException;
import stocksnstuff.htmlScraper;

/**
 *
 * @author mtaylo35
 */
public class StocksNStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        htmlScraper scraper = new htmlScraper();
        scraper.getRawHtmlData();
        scraper.filterRawStockData();
        scraper.segmentStockData();
        
    }

}
