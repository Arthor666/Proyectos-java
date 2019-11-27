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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author arturo briones
 */
public class Grafica extends JFrame implements ActionListener {
    private static JButton enviar;
    private static JTextField receptor = new JTextField();
    private static TextArea txt = new TextArea();
    private static JButton Desencriptar = new JButton("Desencriptar");
    private static JButton original= new JButton("Ver mensaje Original");
   private static String ip;
    
    public Grafica(){
         ip ="";
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
        Desencriptar.addActionListener(this);
        original.addActionListener(this);
        
        //Coordenadas
        tuip.setBounds(0,0, 500, 20);
        txt.setBounds(100, 100, 300,200);
        receptor.setBounds(550, 50,100,20);
        enviar.setBounds(550, 300, 100, 20);
        paraip.setBounds(450, 50, 200, 20);
        Desencriptar.setBounds(700, 300, 120,20);
        original.setBounds(600, 400, 150, 20);
        
        //Hacerlos visibles
        txt.setVisible(true);
        tuip.setVisible(true);
        receptor.setVisible(true);
        enviar.setVisible(true);
        paraip.setVisible(true);
        Desencriptar.setVisible(true);
        original.setVisible(true);
        
        //Layout
        paraip.setLayout(null);
        tuip.setLayout(null);
        receptor.setLayout(null);
        enviar.setLayout(null);
        Desencriptar.setLayout(null);
        original.setLayout(null);
     
        //Agregar al JFrame
        add(paraip);
        add(tuip);
        add(txt);
        add(receptor);
        add(enviar);
        add(Desencriptar);
        add(original);
        
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
                Mensaje m =  new Mensaje(msj_rsa,receptor.getText(),r,ip);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
        if(opc==Desencriptar){
            JFileChooser buscador = new JFileChooser();
            buscador.setCurrentDirectory(new File(System.getProperty("user.dir")));
            buscador.setFileFilter(new FileNameExtensionFilter("DDR","ddr"));
            Scanner scn=null;
            String ruta="";
            int valor = buscador.showOpenDialog(buscador);
            if (valor == JFileChooser.APPROVE_OPTION) {
                 ruta = buscador.getSelectedFile().getAbsolutePath();
                    try {
                        File f = new File(ruta);
                        scn = new Scanner(f);
                        while (scn.hasNext()) {
                            System.out.println(scn.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                } finally {
                    if (scn != null) {
                        scn.close();
                    }
                }
            } else {
                System.out.println("No se ha seleccionado ningún fichero");
            }
            String mensaje_desencriptado="";
            try {
                mensaje_desencriptado=RSA.desencriptar(ruta);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt.setText(mensaje_desencriptado);
        }
        if(opc==original){
            JFileChooser buscador = new JFileChooser();
            buscador.setFileFilter(new FileNameExtensionFilter("DDR","ddr"));
            buscador.setCurrentDirectory(new File(System.getProperty("user.dir")));
            Scanner scn=null;
            String ruta="";
            int valor = buscador.showOpenDialog(buscador);
            if (valor == JFileChooser.APPROVE_OPTION) {
                 ruta = buscador.getSelectedFile().getAbsolutePath();
                    try {
                        File f = new File(ruta);
                        scn = new Scanner(f);
                        while (scn.hasNext()) {
                            System.out.println(scn.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                } finally {
                    if (scn != null) {
                        scn.close();
                    }
                }
            } else {
                System.out.println("No se ha seleccionado ningún fichero");
            }
            String mensaje_encriptado="";
            try {
                mensaje_encriptado=RSA.sacar_mensaje(ruta);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt.setText(mensaje_encriptado);
        }
    }
    
    
}
