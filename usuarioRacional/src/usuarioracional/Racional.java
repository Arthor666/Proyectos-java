/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioracional;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Arturo
 */
public class Racional {
   private int num;
   private int den;
   private static int contador=0;
   public Racional(){
       num=1;
       den=1;
       contador++;
   }
   public Racional(int num,int den){
       this.num=num;
       this.den=den;
       if (den==0){
           this.den=1;
       }
      contador++;
   }
   public Racional (Racional f){//Constructor por copia
       this(f.num,f.den);
       contador++;
   }
   public void imprimir(){
       System.out.println("["+num+"."+den+ "]");
   }
   public void establecer(int num, int den){
    this.num=num;
    if (den==0){
       this.den=1;
    }else{
    this.den=den;
   }
  }
  public void establecer(int num){
      this.establecer(num,1);
  }
  public void establecer(Racional f){
      this.establecer(f.num,f.den);
  }
  public int obtenerNum(){
      int n=this.num;
      return n;
  }
  /*public void multiplicar(Racional x,Racional y){
      this.den=x.den*y.den;
      this.num=x.num*y.num;
      
  }
  public void multiplicar(Racional x){
      this.den=this.den*x.den;
      this.num=this.num*x.num;
      
  }*/
  public Racional multiplicar(Racional h){
      this.den=this.den*h.den;
      this.num=this.num*h.num;
      return this;
  }
  
  public String toString(){
      
      return this.num+","+this.den;
  }
  public boolean equals(Racional R){
      boolean f=false;
      if(this.num==R.num&&this.den==R.num){
          f=true;
      }
   return f;   
  }
  public Racional elMayorEs(Racional []x){
      Racional mayor = new Racional();
      mayor=x[0];
      for(int i=0;i<x.length;i++){
          if(x[i].esMayorQue(mayor)){
              mayor=x[i];
          }
      }
    return mayor; 
  }
  public Racional elMayorEs(ArrayList<Racional>x){
      Racional mayor = new Racional();
      mayor=x.get(0);
      for(int i=0;i<x.size();i++){
          if(x.get(i).esMayorQue(mayor)){
              mayor=x.get(i);
          }
      }
    return mayor; 
  }
  public boolean esMayorQue(Racional f){
      if((double)(this.num/this.den)>(double)(f.num/f.den)){
          return true;
      }else {
          return false;
      }
      
  } 
  public  boolean sonIguales(ArrayList <Racional> t,Racional [] g ){
      boolean r=false;
      if(t.size()==g.length){
          for(int i=0;i<t.size();i++){
              if(t.get(i).equals(g[i])){
                  System.out.println(t.size()+"   "+g.length);
                  r=true;
              }else{
                  r=false;
                  i=t.size();
              }
          }
      }
      return r;
  }
  public Racional sumar( Racional b){
      Racional aux = new Racional();
      
      
      return aux;
  }
  public static int totalRacionales(){
      return contador;
  }
  
}

