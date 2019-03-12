/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.SessionControl;

import java.io.File;
import stocksnstuff.database.DBIO.DBReader;
import stocksnstuff.gui.UserGUI;

/**
 *
 * @author mtaylo35
 */
public class Login {

    private File userDB;

    public Login(File userDB) {
        this.userDB = userDB;
    }

    public boolean loginEmail(String email, String password) {
        DBReader dbR = new DBReader();
        if (!dbR.validatePerms()) {
            return false;
        } else {
            if (!dbR.scanDB(email, 0) || !dbR.scanDB(password, 2)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean loginUsername(String username, String password) {

        DBReader dbR = new DBReader();
        if (!dbR.validatePerms()) {
            return false;
        } else {
            if (!dbR.scanDB(username, 1) || !dbR.scanDB(password, 2)) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void startSession(String name) {

        UserGUI uG = new UserGUI(name);
        uG.setVisible(true);

    }
}
