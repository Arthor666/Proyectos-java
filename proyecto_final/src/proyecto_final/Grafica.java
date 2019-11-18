/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author arturo briones
 */
public class Grafica extends JFrame implements ActionListener {
    private static JButton enviar;
    private static JTextField receptor = new JTextField();
    private static TextArea txt = new TextArea();
    
    public Grafica(){
        String ip ="";
        try {
          ip=InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
        }
        enviar = new JButton("Enviar");
        JLabel paraip= new JLabel("Ip del receptor:");
        JLabel tuip=new JLabel("Tu ip es: "+ip);
        JScrollPane scrollPane = new JScrollPane(txt); 
        txt.setEditable(true);
        //ActionListener
        enviar.addActionListener(this);
        
        //Coordenadas
        tuip.setBounds(0,0, 500, 20);
        txt.setBounds(100, 100, 300,200);
        receptor.setBounds(550, 50,100,20);
        enviar.setBounds(550, 300, 100, 20);
        paraip.setBounds(450, 50, 200, 20);
        
        //Hacerlos visibles
        txt.setVisible(true);
        tuip.setVisible(true);
        receptor.setVisible(true);
        enviar.setVisible(true);
        paraip.setVisible(true);
        
        //Layout
        paraip.setLayout(null);
        tuip.setLayout(null);
        receptor.setLayout(null);
        enviar.setLayout(null);
     
        //Agregar al JFrame
        add(paraip);
        add(tuip);
        add(txt);
        add(receptor);
        add(enviar);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setBounds(width/2-300,height/2-200,width/2,height/2);
        setLayout(null);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object opc = ae.getSource();
        if(opc==enviar){
            RSA r = null;
            try {
                r = new RSA();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
            String msj_rsa="";
            
            try {
                msj_rsa=r.enciptar(txt.getText());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Mensaje m =  new Mensaje(msj_rsa,receptor.getText(),r);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
    }
    
    
}
