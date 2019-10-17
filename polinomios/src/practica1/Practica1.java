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
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Arturo
 */
public class Practica1 extends JFrame implements ActionListener {
    JButton btn[] = new JButton[7];
    JLabel jbla = new JLabel();
    JLabel jblb = new JLabel();
    JLabel principal = new JLabel();
    ArrayList <JTextField> respuesta = new ArrayList();
    ArrayList <JLabel> equis = new ArrayList();
    JButton revisar = new JButton();
    ArrayList <monomio> monomios = new ArrayList();
    ArrayList <polinomio> binomios = new ArrayList();
    polinomio A ;
    polinomio B;
    polinomio Res_verdadero= new polinomio();
    polinomio Res_usuario;
    String adicion="Escogiste suma, entonces suma A+B",sustraccion="Escogiste resta, entonces Resta A-B"
      ,multiplicacion="Escogiste Multiplicacion, entonces Multiplica (A)(B)"
      ,division="Escogiste Division, entonces Divide A/B"
      ,teoremaff="Escogiste Teorema Fundamental del Algebra. Encuentra las raices de la siguiente ecuacion",
            menup="Bienvenido, Selecciona la opción que desees practicar";
    JButton regresar = new JButton("Regresar");
    ArrayList <complejo> resultados_verdaderos = new ArrayList();
    ArrayList <String> resultados_usuario = new ArrayList();
    JButton revisar2 = new JButton();
    public Practica1 (){
        super("Practica1");
        for (int i = 0; i < 7; i++) {
            btn[i]= new JButton();
            btn[i].setLayout(null);
            btn[i].addActionListener(this);
        }
        regresar.setLayout(null);
        regresar.addActionListener(this);
        regresar.setBounds(230, 200, 100, 30);
        add(regresar);
        regresar.setVisible(false);
        revisar.setLayout(null);
        revisar.addActionListener(this);
        revisar.setText("Revisar");
        revisar.setBounds(100,200,100,30);
        revisar2.setLayout(null);
        revisar2.addActionListener(this);
        revisar2.setText("Revisar");
        revisar2.setBounds(230,100,100,30);
        btn[0].setText("Suma");
        btn[1].setText("Resta");
        btn[2].setText("Multiplicación");
        btn[3].setText("División");
        btn[4].setText("Teorema Fundamental del calculo");
        btn[5].setText("Diferencial");
        btn[6].setText("Integral");
        btn[0].setBounds(30,30,100, 30);
        btn[1].setBounds(30,70,100, 30);
        btn[2].setBounds(30,110,140, 30);
        btn[3].setBounds(30,150,100, 30);
        btn[4].setBounds(30,190,100, 30);
        btn[5].setBounds(30,230,100, 30);
        btn[6].setBounds(30,270,100, 30);
        principal.setLayout(null);
        principal.setBounds(50,0,1000, 30);
        principal.setText(menup);
        principal.setVisible(true);
        jbla.setLayout(null);
        jbla.setBounds(100,30,500,30);
        jblb.setLayout(null);
        jblb.setBounds(100,70,500,30);
        jbla.setFont(new Font("Arial", Font.PLAIN, 15));
        jblb.setFont(new Font("Arial", Font.PLAIN, 15));
        principal.setFont(new Font("Arial", Font.PLAIN, 15));
        for (int i = 0; i < 7; i++) {
            add(btn[i]);
        }
        add(principal);
        add(jbla);
        add(jblb);
        add(revisar);
        add(revisar2);
        revisar2.setVisible(false);
        revisar.setVisible(false);
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
            A = new polinomio();
            B = new polinomio();
            jbla.setText("A="+A.toString());
            jbla.setVisible(true);
            jblb.setText("B="+B.toString());
            jblb.setVisible(true);
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText(adicion);
            muestra_campos(7);
            Res_verdadero=polinomio.suma(A,B);
            System.out.println(Res_verdadero);
        }
        if(opc==btn[1]){
            A = new polinomio();
            B = new polinomio();
            jbla.setText("A="+A.toString());
            jbla.setVisible(true);
            jblb.setText("B="+B.toString());
            jblb.setVisible(true);
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText(sustraccion);
            muestra_campos(7);
            Res_verdadero=polinomio.resta(A,B);
            System.out.println(Res_verdadero);
        }
        if(opc==btn[2]){
            A=new polinomio();
            B=new polinomio();
            jbla.setText("A="+A.toString());
            jbla.setVisible(true);
            jblb.setText("B="+B.toString());
            jblb.setVisible(true);
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText(multiplicacion);
            muestra_campos(13);
            Res_verdadero=polinomio.multiplica(A,B);
            System.out.println("A "+A);
            System.out.println("B "+B);
            System.out.println(Res_verdadero);
        }
        if(opc==btn[3]){
            Random r = new Random();
            int pab=0,pares=0;
            do{
                pab=r.nextInt(4);
            }while(pab<1);
            do{
                pares=r.nextInt(4);
            }while(pares<1);
            Res_verdadero=polinomio.div_res(pares);
            B=polinomio.div_res(pab);
            A=polinomio.multiplica(B, Res_verdadero);
            jbla.setText("A="+A.toString());
            jbla.setVisible(true);
            jblb.setText("B="+B.toString());
            jblb.setVisible(true);
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText(division);
            muestra_campos(7);
            System.out.println("A "+A);
            System.out.println("B "+B);
            System.out.println(Res_verdadero);
        }
        if(opc==btn[4]){
            jbla.setVisible(true);
            for (int i = 0; i < 3; i++) {
                binomios.add(new polinomio(2));
                System.out.println(binomios.get(i));
            }
            A=polinomio.multiplica(binomios.get(0),binomios.get(1));
            A=polinomio.multiplica(A,binomios.get(2));
            jbla.setText(A.toString()+"=0");
            muestra_campos(A.mon.get(0).exponente);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            for (int i = 0; i < binomios.size(); i++) {
             resuelve(binomios.get(i));
                
            }
            for (int i = 0; i <resultados_verdaderos.size(); i++) {
                System.out.println(resultados_verdaderos.get(i));
            }
            principal.setText(teoremaff);
            regresar.setVisible(true);
            revisar2.setVisible(true);
            
            
        }
        if(opc==btn[5]){
            jbla.setVisible(true);
             A=new polinomio();
            jbla.setText("A="+A.toString());
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText("Escogiste Diferencial, entonces diferencia A");
            muestra_campos(7);
            Res_verdadero=polinomio.deriva(A);
            System.out.println(Res_verdadero);
        }
        if(opc==btn[6]){
            jbla.setVisible(true);
             A=new polinomio();
            jbla.setText("A="+A.toString());
            regresar.setVisible(true);
            for (int i = 0; i < 7; i++) {
                btn[i].setVisible(false);
            }
            principal.setText("Escogiste Integral, entonces Integra A");
            muestra_campos(7);
            Res_verdadero=polinomio.integra(A);
            System.out.println(Res_verdadero);
        }
        
        if(opc==revisar){
            for (int i = 0; i <respuesta.size(); i++) {
                monomios.add(new monomio(Integer.parseInt(respuesta.get(i).getText()),(respuesta.size()-i-1)));
            }
            Res_usuario = new polinomio(monomios);
            if(polinomio.equals(Res_usuario,Res_verdadero)){
                JOptionPane.showMessageDialog(null,"Felicidades, el resultado es correcto");
                back(1);
            }else{
                JOptionPane.showMessageDialog(null,"Siguelo intentando");    
            }
            limpiar();
        }
        if(opc==revisar2){
            boolean estado=false;
            for (int i = 0; i <respuesta.size(); i++) {
                resultados_usuario.add(respuesta.get(i).getText());
            }
            for (int i = 0; i < respuesta.size(); i++) {
                for (int j = 0; j < respuesta.size(); j++) {
                    if(resultados_usuario.get(i).equals(resultados_verdaderos.get(j).toString())){
                       estado=true;
                       j=respuesta.size();
                    }
                }
                if(!estado){
                    break;
                }
            }
            if(estado){
                JOptionPane.showMessageDialog(null,"Felicidades, el resultado es correcto");
                back(0);
            }else{
                JOptionPane.showMessageDialog(null,"Siguelo intentando");
            }
            limpiar2();
        }
        if(opc==regresar){
            back(0);
        }
    }
    public void muestra_campos(int num){
        int x=10;
        for (int i = 0; i < num; i++) {
                equis.add(new JLabel());
                respuesta.add(new JTextField());
                equis.get(i).setLayout(null);
                respuesta.get(i).setLayout(null);
                respuesta.get(i).setBounds(x, 110,30,30);
                equis.get(i).setBounds(x+30,110, 30, 30);
                add(equis.get(i));
                add(respuesta.get(i));
                equis.get(i).setVisible(true);
                respuesta.get(i).setVisible(true);
                x+=50;
                equis.get(i).setFont(new Font("Arial", Font.PLAIN, 15));
            }
        
        String s="";
        if(num==7){
            equis.get(0).setText("x"+"\u2076");
            equis.get(1).setText("x"+"\u2075");
            equis.get(2).setText("x"+"\u2074");
            equis.get(3).setText("x"+"\u00B3");
            equis.get(4).setText("x"+"\u00B2");
            equis.get(5).setText("x");
            equis.get(6).setText("");
            revisar.setVisible(true);
        }
        if(num==13){
            equis.get(0).setText("x"+"\u00B9"+"\u00B2");
            equis.get(1).setText("x"+"\u00B9"+"\u00B9");
            equis.get(2).setText("x"+"\u00B9"+"\u2070");
            equis.get(3).setText("x"+"\u2079");
            equis.get(4).setText("x"+"\u2078");
            equis.get(5).setText("x"+"\u2077");
            equis.get(6).setText("x"+"\u2076");
            equis.get(7).setText("x"+"\u2075");
            equis.get(8).setText("x"+"\u2074");
            equis.get(9).setText("x"+"\u00B3");
            equis.get(10).setText("x"+"\u00B2");
            equis.get(11).setText("x");
            equis.get(12).setText("");
            revisar.setVisible(true);
            
        }
        if(num!=13&&num!=7){
            int t=110;
            for (int i = 0; i <num; i++) {
                equis.get(i).setBounds(10,t, 50,30);
                respuesta.get(i).setBounds(50, t, 50,30);
                equis.get(i).setText("X"+(i+1)+"=");
                t+=30;
            }
        }
        
        
        
    }
    public void back(int a){
        for (int i = 0; i < respuesta.size(); i++) {
           equis.get(i).setVisible(false);
           respuesta.get(i).setVisible(false);
           
        }
        jbla.setVisible(false);
        jblb.setVisible(false);
       revisar.setVisible(false);
       regresar.setVisible(false);
       revisar2.setVisible(false);
       principal.setText(menup);
        for (int i = 0; i < btn.length; i++) {
            btn[i].setVisible(true);
        }
        respuesta.clear();
        equis.clear();
        if(a==0){
            limpiar2();
        }else{
         limpiar();   
        }
    }
    public void limpiar(){
        Res_usuario.mon.clear();
        monomios.clear();
    }
    public void limpiar2(){
        binomios.clear();
        resultados_usuario.clear();
        resultados_verdaderos.clear();
        
    }
    public void resuelve(polinomio aux){
        double real=0;
        double compleja=0;
        double  auxiliar=0,auxiliar2=0;
        if(aux.mon.get(0).exponente==2&&aux.mon.get(0).coeficiente!=0){
            auxiliar=Math.pow(aux.mon.get(1).coeficiente,2);
            auxiliar-=4*aux.mon.get(0).coeficiente*aux.mon.get(2).coeficiente;
            auxiliar2=-aux.mon.get(1).coeficiente;
            auxiliar2/=(2*aux.mon.get(0).coeficiente);
            
            if(auxiliar<0){
                auxiliar*=-1;
                compleja=Math.sqrt(auxiliar)/(2*aux.mon.get(0).coeficiente);
                real=auxiliar2;
                resultados_verdaderos.add(new complejo(real,compleja));
                resultados_verdaderos.add(new complejo(real, -compleja));
            }else{
                auxiliar=Math.sqrt(auxiliar)/(2*aux.mon.get(0).coeficiente);
                resultados_verdaderos.add(new complejo(auxiliar2-auxiliar , 0));
                resultados_verdaderos.add(new complejo(auxiliar2+auxiliar , 0));
            }
        }else if(aux.mon.get(1).coeficiente==0){
            resultados_verdaderos.add(new complejo(0 , 0));
        }else{
            if(aux.mon.get(0).coeficiente!=0){
                real=-aux.mon.get(1).coeficiente;
                real/=aux.mon.get(0).coeficiente;
                resultados_verdaderos.add(new complejo(real, 0));   
            }
        }
        
    }
    

}
