/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksnstuff.generalResources;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mitchell
 */
public class focusListener {

    private FocusListener fl;
    private JTextField field;
    private String dText;
    
    public focusListener(JTextField fieldName, String defaultText) {
        this.field = fieldName;
        this.dText = defaultText;
        create();

    }
    
    public focusListener(JPasswordField fieldName, String defaultText) {
        this.field = fieldName;
        this.dText = defaultText;
        create();

    }

    private void create() {
        //Create FocusListenero obj and set overrides
        {
            fl = new FocusListener() {
                public void focusGained(FocusEvent e) {
                    field.setText("");
                }

                public void focusLost(FocusEvent e) {
                    //nothing
                }
            };
        }
    }

    public JTextField getField(){
        return this.field;
    }
    public FocusListener getFocusListener() {
        return this.fl;
    }
}
