/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pfears
 */
public class readWrite {

    private String path;
    private File userDB;
    private String[] userInfo;

    public readWrite() {
        try {
            this.path = new File(".").getCanonicalPath() + "\\database\\forumContent";
        } catch (IOException ex) {
            Logger.getLogger(readWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
