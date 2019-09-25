/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import javax.swing.JOptionPane;

/**
 *
 * @author Arturo
 */
public class Practica1 {
//Hola, estoy modificando el cdeigazo
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc=0;
        int ayudante [] = new int  [7];
        int ayudante2 []= new int[13];
        String operacion="";
        boolean importante=false;
        float sol [] = new float [6];
        String mensaje;
        do{
       opc=Integer.parseInt(JOptionPane.showInputDialog(null,"hola, dime que te gustaria practicar\n1) Suma o adición"
                + "\n2)Resta o sustracción \n3) Multipliacación o producto\n4) División o cociente\n5) Teorema fundamnetal del algebra"));
        polinomio A = new polinomio();
        polinomio B= new polinomio();
        polinomio otra = new polinomio();
        Polinomiodoble res2 = new Polinomiodoble();
        polinomio res= new polinomio();
        A.polinomio();
        B.polinomio();
        switch(opc){
            case 1:
                operacion="Escogiste suma, entonces Suma el polinomio:"+A+"\nal polinomio"+B+"\nanota tu resultado y a continuación teclealo";
            break;
            case 2:
            operacion="Escogiste Resta, entonces Resta el polinomio:"+A+"\nal polinomio"+B+"\nanota tu resultado y a continuación teclealo";    
            break;
            case 3:
            operacion="Escogiste Multiplicacion, entonces multiplica el polinomio"+A+"\nal polinomio"+B+"\nanota tu resultado y a continuación"; 
            JOptionPane.showMessageDialog(null,operacion);
            ayudante2[0]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^12"));
            ayudante2[1]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^11"));
            ayudante2[2]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^10"));
            ayudante2[3]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^9"));
            ayudante2[4]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^8"));
            ayudante2[5]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^7"));
            ayudante2[6]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^6"));
            ayudante2[7]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^5"));
            ayudante2[8]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^4"));
            ayudante2[9]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^3"));
            ayudante2[10]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^2"));
            ayudante2[11]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X"));
            ayudante2[12]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el termino lineal"));
            res2.Polinomiodoble(ayudante2);
            break;
            case 4:
                otra=polinomio.division(A, B);
                System.out.println(otra);
                operacion="Escogiste Division, entonces Divide el polinomio"+A+"\nal polinomio"+B+"\nanota tu resultado y a continuación";
            break;
            case 5:
                otra=polinomio.dameec(otra);
                operacion="Escogiste Teorema fundamental del algebra, entonces resuelve esto "+otra+"=0";
                JOptionPane.showMessageDialog(null,operacion);
                sol[0]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X1="));
                sol[1]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X2="));
                sol[2]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X3="));
                sol[3]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X4="));
                sol[4]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X5="));
                sol[5]=Float.parseFloat(JOptionPane.showInputDialog(null,"Teclea X6="));
                res.polinomio(1,sol);
            break;
        }
               if(opc==1||opc==2||opc==4){
               JOptionPane.showMessageDialog(null,operacion);
               ayudante[0]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^6"));
               ayudante[1]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^5"));
               ayudante[2]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^4"));
               ayudante[3]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^3"));
               ayudante[4]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X^2"));
               ayudante[5]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el coeficiente de X"));
               ayudante[6]=Integer.parseInt(JOptionPane.showInputDialog(null,"Teclea el termino lineal"));
               res.polinomio(ayudante);
              }
        switch(opc){
            case 1:
                importante=res.equals(polinomio.suma(A, B));
            break;
            case 2:
                importante=res.equals(polinomio.resta(A,B));
            break;
            case 3:
               importante=res.equals(Polinomiodoble.multiplicacion(A,B));
            case 4:
                importante=res.equals(otra);
            break;
            case 5:
                importante=res.esigual(otra);
                break;
        }
        if(importante){
            mensaje="Ayyy caramba, lo hiciste bien";
        }else{
            mensaje="Intentalo de nuevo, estas cerca";
        }
        JOptionPane.showMessageDialog(null,mensaje);
                    break;

     }while(opc!=5);
    
    }
}
