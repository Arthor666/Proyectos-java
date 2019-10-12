/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.text.DecimalFormat;

/**
 *
 * @author Arturo
 */
public class complejo {
    double real;
    double imaginario;
    public complejo(double r, double i){
        real=r;
        imaginario=i;
    }
    @Override
    public String toString(){
        DecimalFormat formato2 = new DecimalFormat("#.##");
        String s="";
        s=""+formato2.format(real);
        if(imaginario!=0){
            if (imaginario>0){
                s+="+i"+formato2.format(imaginario);
            }else{
                s+="-i"+formato2.format((imaginario*-1));    
            }
            
        }
        return s;
    }
    
}
