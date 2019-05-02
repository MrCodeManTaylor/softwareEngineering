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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import stocksnstuff.generalResources.StringFormatter;

/**
 *
 * @author Mitchell
 */
public class DBAdminIO {

    //class responsible for handling all admin DB relations
    private DefaultTableModel banTable = new DefaultTableModel();
    private DBReader dbr;
    private String path;
    private String[] banList;
    private ArrayList<String> postList;

    public DBAdminIO(String loc, Boolean type) {
        this.path = loc;
        dbr = new DBReader(path);
        if(type)
            banList = dbr.getBanList();
    }

    public void setPath(String path) {
        try {
            this.path = new File(".").getCanonicalPath() + path;
        } catch (IOException ex) {
            Logger.getLogger(DBAdminIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getPostList() {
        return this.postList;
    }

    public String[] getBanList() {
        return this.banList;
    }

    public String getPath() {
        return this.path;
    }

    public void populatePostList(String path) {
        ArrayList<String> reportedPosts = new ArrayList<>();
        for (File f : new File(path).listFiles()) {
            try {
                reportedPosts.addAll(populatePosts(f.getCanonicalPath() + "\\main.txt"));
            } catch (IOException ex) {
                Logger.getLogger(DBAdminIO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        this.postList = reportedPosts;
    }

    private ArrayList<String> populatePosts(String dir) {
        BufferedReader br = null;
        try {
            ArrayList<String> reportedPosts = new ArrayList<>();
            br = new BufferedReader(new FileReader(dir));
            StringFormatter sf = new StringFormatter();
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] data = sf.segmentLine(line);
                if (data[11].equals("1")) {
                    String directory = dir.substring(dir.indexOf("\\threads\\")+9,dir.indexOf("\\main.txt"));
                    String postData = data[1] + ", " + data[2] + ", " + directory;
                    reportedPosts.add(postData);
                }
                line = br.readLine();
            }
            br.close();
            return reportedPosts;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    public DefaultTableModel formatJTable(ArrayList<String> reportedList) {

        StringFormatter sf = new StringFormatter();
        String[] columnNames = sf.segmentLine("User, Post Title, Thread");
        String[][] rowData = new String[reportedList.size()][3];
        int i = 0;
        for (String s : reportedList) {

            rowData[i] = sf.segmentLine(s);

        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (i = 0; i <= rowData.length - 1; i++) {
            model.addRow(rowData[i]);
        }
        return model;
    }

    public DefaultTableModel formatJTable(String[] banList) {

        StringFormatter sf = new StringFormatter();
        String[] columnNames = sf.segmentLine("Username, Email, Report Count, Previous Ban, Ban Status, Warn Status");
        String[][] rowData = new String[banList.length][6];
        for (int i = 0; i <= banList.length - 1; i++) {
            String[] lData = sf.segmentLine(banList[i]);
            String banData = lData[1] + ", " + lData[0] + ", " + lData[10] + ", " + lData[11] + ", " + lData[8] + ", " + lData[9];
            rowData[i] = sf.segmentLine(banData);
        }
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (int i = 0; i <= rowData.length - 1; i++) {
            model.addRow(rowData[i]);
        }
        return model;
    }

    public DefaultTableModel getBanTable() {
        return this.banTable;
    }
}
