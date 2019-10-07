/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Random;

public class monomio {
     int coeficiente;
     int exponente;
    public monomio(){
        Random r = new Random();
        coeficiente=r.nextInt(10);
        exponente=r.nextInt(7);
    }
    public monomio(int c,int ex){
        coeficiente=c;
        exponente=ex;
    }
    public static boolean notequals(monomio a, monomio b){
        boolean estado=true;
        if(a.coeficiente==b.coeficiente||a.exponente==b.exponente){
            estado=false;
        }
        return estado;
    }
    
}
