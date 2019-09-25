/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author Arturo
 */
public class Polinomiodoble {
    int g [] = new int [13];
    public void Polinomiodoble(int a[]){
        System.arraycopy(a, 0, this.g, 0, 13);
    }
    public  boolean equals(Polinomiodoble p){
        boolean h=true;
        for(int i=0;i<13;i++){
            if(this.g[i]!=p.g[i]){
                h=false;
            }
            
        }
        return h;
    }
    
    @Override
    public String toString(){
        String s="";
        if(this.g[0]!=0){
            s=s+this.g[0]+"X^12";
        }
        if(this.g[1]!=0){
            s=s+"+"+this.g[1]+"X^11";
        }
        if(this.g[2]!=0){
            s=s+"+"+this.g[2]+"X^10";
        }
        if(this.g[3]!=0){
            s=s+"+"+this.g[3]+"X^9";
        }
        if(this.g[4]!=0){
            s=s+"+"+this.g[4]+"X^8";
        }
        if(this.g[5]!=0){
            s=s+"+"+this.g[5]+"X^7";
        }
        if(this.g[6]!=0){
            s=s+"+"+this.g[6]+"X^6";
        }
        if(this.g[7]!=0){
            s=s+"+"+this.g[7]+"X^5";
        }
        if(this.g[8]!=0){
            s=s+"+"+this.g[8]+"X^4";
        }
        if(this.g[9]!=0){
            s=s+"+"+this.g[9]+"X^3";
        }
        if(this.g[10]!=0){
            s=s+"+"+this.g[10]+"X^2";
        }
        if(this.g[11]!=0){
            s=s+"+"+this.g[11]+"X";
        }
        if(this.g[12]!=0){
            s=s+"+"+this.g[12];
        }        
        return s;
    }
    public static Polinomiodoble multiplicacion (polinomio m,polinomio s){
      Polinomiodoble y = new Polinomiodoble();
      for(int x=0;x<6;x++){
          int i =0;
           for(int z=x;z>=0;z--){
              y.g[x]=y.g[x]+m.pedro[i]*s.pedro[z];
              i++;
           }   
      }
      
      for(int x=12;x>=6;x--){
          int i=6;
          int aux=x-6;
           for(int z=aux;z<=6;z++){
              y.g[x]=y.g[x]+m.pedro[z]*s.pedro[i];
              i--;
           }
           
      }
      return y;  
    }
    public polinomio topolinomio(){
        polinomio a = new polinomio();
        for(int i=0; i<7;i++){
            a.pedro[i]=this.g[i+6];
        }
        return a;
    }
}
