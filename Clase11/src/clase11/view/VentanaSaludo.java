/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clase11.view;

import clase11.dao.DAOException;
import clase11.dao.VehiculoDAO;
import clase11.dao.VehiculoDAOFileImpl;
import clase11.entidades.Automovil;
import clase11.entidades.Vehiculo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author george
 */
public class VentanaSaludo extends JFrame{
    
    private final JTextField txtPatente, txtMarcaModelo;
    private final JSpinner spnModelo;
    private final JButton btnPrincipal;
    private final VehiculoDAO dao;
    
    public VentanaSaludo(){
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        this.txtPatente = new JTextField();
        this.txtMarcaModelo = new JTextField();
        this.spnModelo = new JSpinner();
        this.spnModelo.setValue(2000);
        
        this.btnPrincipal = new JButton("Apretame!");
        
        this.add(txtPatente);
        this.add(txtMarcaModelo);
        this.add(this.spnModelo);
        this.add(btnPrincipal, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 200);
        
        this.dao = new VehiculoDAOFileImpl();
       
        
        btnPrincipal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String patente = txtPatente.getText();
                String descrip = txtMarcaModelo.getText();
                int modelo = Integer.parseInt(spnModelo.getValue().toString());
                
                
                try{
                    Vehiculo v = new Automovil(modelo, descrip, patente);
                    dao.store(v);
                    JOptionPane.showMessageDialog(rootPane, "Éxito!");
                } catch(DAOException de){
                    JOptionPane.showMessageDialog(
                            rootPane, 
                            de.getMessage(), 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                
                
            }
            
        });
    }
    
}
