/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Arturo
 */
public class Practica1 extends JFrame implements ActionListener {
    JButton btn[] = new JButton[5];
    JLabel jbla = new JLabel();
    JLabel jblb = new JLabel();
    JLabel principal = new JLabel();
    ArrayList <JTextField> respuesta = new ArrayList();
    ArrayList <JLabel> equis = new ArrayList();
    public Practica1 (){
        super("Practica1");
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
        principal.setLayout(null);
        principal.setBounds(50,0,1000, 30);
        principal.setText("Bienvenido, Selecciona la opción que desees practicar");
        principal.setVisible(true);
        jbla.setLayout(null);
        jbla.setBounds(100,30,500,30);
        jblb.setLayout(null);
        jblb.setBounds(100,70,500,30);
        jbla.setFont(new Font("Arial", Font.PLAIN, 15));
        jblb.setFont(new Font("Arial", Font.PLAIN, 15));
        principal.setFont(new Font("Arial", Font.PLAIN, 15));
        for (int i = 0; i < 5; i++) {
            add(btn[i]);
        }
        add(principal);
        add(jbla);
        add(jblb);
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
        Object opc = ae.getSource();
        if(opc==btn[0]){
            polinomio A = new polinomio();
            polinomio B = new polinomio();
            jbla.setText("A="+A.toString());
            jbla.setVisible(true);
            jblb.setText("B="+B.toString());
            jblb.setVisible(true);
            for (int i = 0; i < 5; i++) {
                btn[i].setVisible(false);
            }
            principal.setText("Escogiste suma, entonces suma A+B");
            muestra_campos(8);
        }
        
    }
    public void muestra_campos(int num){
        for (int i = 0; i < num; i++) {
                equis.add(new JLabel());
                respuesta.add(new JTextField());
                equis.get(i).setLayout(null);
                respuesta.get(i).setLayout(null);
                respuesta.get(i).setBounds(i, i, i, i);
                equis.get(i).setBounds(i, i, i, i);
                add(equis.get(i));
                add(respuesta.get(i));
            }
    }
}
