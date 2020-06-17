/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author george
 */
public class BotonApretameListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("Se apretó el botón!!!!");
        System.out.println(e);
        
    }
    
    
    
}
