/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proyecto_final extends Thread{

     static servidor s=null;
    public static void main(String[] args) throws UnknownHostException {
        Thread hilo = new Proyecto_final();
        hilo.start();
        try {
            s = new servidor();
        } catch (IOException ex) {
            Logger.getLogger(Proyecto_final.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        Grafica g = new Grafica();
        s.Iniciarserver();
    }
    
}
