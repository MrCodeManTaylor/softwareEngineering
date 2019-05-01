/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.database.DBIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import stocksnstuff.generalResources.StringFormatter;

/**
 *
 * @author mtaylo35
 */
public class DBFuncs {

    public DBFuncs() {

    }

    public int findTableSize(String db) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(db));
        int i = 0;
        while (br.readLine() != null) {
            i++;
        }
        br.close();
        return i;
    }

    public String[] formatData(File DB, int tSize) {
        try {
            String[] forumData = new String[tSize];
            BufferedReader br = new BufferedReader(new FileReader(DB));
            String line = br.readLine();
            forumData[0] = line;
            int i = 0;
            while (i < tSize - 1) {
                i++;
                line = br.readLine();
                forumData[i] = line;
            }
            br.close();
            return forumData;

        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public DefaultTableModel formatJTable(String[] data, int tSize, int cols) {

        if (data.length == 0) {
            return null;
        }
        tSize--;
        StringFormatter sf = new StringFormatter();
        String[] columnNames = sf.segmentLine(data[0]);
        String[][] rowData = new String[tSize][cols];
        for (int i = 0; i < data.length - 1; i++) {
            rowData[i] = sf.segmentLine(data[i + 1]);
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (int i = 0; i <= rowData.length - 1; i++) {
            model.addRow(rowData[i]);
        }
        return model;
    }
}
