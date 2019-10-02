/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Arturo
 */
public class Practica1 extends JFrame implements ActionListener {
    public Practica1 (){
        super("Practica1");
        JButton btn[] = new JButton[5];
        for (int i = 0; i < 5; i++) {
            btn[i]= new JButton();
            btn[i].setLayout(null);
            btn[i].addActionListener(this);
        }
        btn[0].setText("Suma");
        btn[1].setText("Resta");
        btn[2].setText("Multiplicación");
        btn[3].setText("División");
        btn[4].setText("Teorema Fundamental del calculo");
        btn[0].setBounds(30,30,100, 30);
        btn[1].setBounds(30,70,100, 30);
        btn[2].setBounds(30,110,140, 30);
        btn[3].setBounds(30,150,100, 30);
        btn[4].setBounds(30,190,100, 30);
        for (int i = 0; i < 5; i++) {
            add(btn[i]);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setBounds(width/2-300,height/2-200,width/2,height/2);
        setLayout(null);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        Practica1 p = new Practica1();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
