/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Arturo
 */
public class polinomio {
    int pedro [] = new int [7];
    final float resultados[] = new float[6];
    public void polinomio(){
        Random r = new Random();
        for(int i=0;i<7;i++){
            pedro[i]=r.nextInt(10);
            System.out.println(pedro[i]);
        }
        System.out.println("-----------");
    }
    public void polinomio(int a[]){
        for(int i=0;i<7;i++){
            this.pedro[i]=a[i];
        }
    }
    public static polinomio division(polinomio A,polinomio B){
        System.out.println("HOla");
        Random r = new Random();
        polinomio p = new polinomio();
        polinomio p2 = new polinomio();
        polinomio m1,m2,m3,m4,m5,m6;
        int aux [] = new int [7];
         for(int i=0;i<7;i++){
             aux[i]=r.nextInt(5);
         }
         int a0=aux[0];
         int a=aux[1];
         int b=aux[2];
         int c=aux[3];
         int d=aux[4];
         int e=aux[5];
         int f=aux[6];
         m1=new polinomio();
         for(int i=0;i<5;i++){
            m1.pedro[i]=0;
        } 
         m1.pedro[5]=a0;
         m1.pedro[6]=a;
         m2=new polinomio();
         for(int i=0;i<5;i++){
            m2.pedro[i]=0;
        } 
         m2.pedro[5]=1;
         m2.pedro[6]=b;
         m3=new polinomio();
         for(int i=0;i<5;i++){
            m3.pedro[i]=0;
        } 
         m3.pedro[5]=1;
         m3.pedro[6]=c;
         m4=new polinomio();
         for(int i=0;i<5;i++){
            m4.pedro[i]=0;
        } 
         m4.pedro[5]=1;
         m4.pedro[6]=d;
         m5=new polinomio();
         for(int i=0;i<5;i++){
            m5.pedro[i]=0;
        } 
         m5.pedro[5]=1;
         m5.pedro[6]=e;
         m6=new polinomio();
         for(int i=0;i<5;i++){
            m6.pedro[i]=0;
        } 
         m6.pedro[5]=1;
         m6.pedro[6]=f;
         p2=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m4,Polinomiodoble.multiplicacion(m3,Polinomiodoble.multiplicacion(m1, m2).topolinomio()).topolinomio()).topolinomio()).topolinomio()).topolinomio();   
         for(int i=0;i<5;i++){
                        B.pedro[i]=0;
            }
         switch(r.nextInt(4)){
             case 1:
                if(r.nextBoolean()){
                    B.pedro[5]=a0;
                    B.pedro[6]=a;
                    p=Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m4,Polinomiodoble.multiplicacion(m3,Polinomiodoble.multiplicacion(m1, m2).topolinomio()).topolinomio()).topolinomio()).topolinomio();
                    
                }else{
                 B.pedro[5]=1;
                 B.pedro[6]=d;
                 p=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m3,Polinomiodoble.multiplicacion(m1,m2).topolinomio()).topolinomio()).topolinomio()).topolinomio();
                }
             break;
             case 2:
                 if(r.nextBoolean()){
                    B.pedro[4]=a0;
                    B.pedro[5]=a0*b+a;
                    B.pedro[6]=a*b;
                    p=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m3, m4).topolinomio()).topolinomio()).topolinomio();
                }else{
                 B.pedro[4]=1;
                 B.pedro[5]=d+e;
                 B.pedro[6]=d*e;
                 p=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m3,Polinomiodoble.multiplicacion(m1,m2).topolinomio()).topolinomio()).topolinomio();
                }
             break;
             case 3:
                 if(r.nextBoolean()){
                    B.pedro[3]=a0;
                    B.pedro[4]=a0+a0*b+a;
                    B.pedro[5]=f*(a0*b+a)+a*b;
                    B.pedro[6]=a*b*f;
                    p=Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m3, m4).topolinomio()).topolinomio();
                }else{
                 B.pedro[3]=1;
                    B.pedro[4]=a+b+c;
                    B.pedro[5]=c*((a+b))+a*b;
                    B.pedro[6]=a*b*c;
                    p=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m4, m5).topolinomio()).topolinomio();
                }
                 break;
                 
         }
         for(int i=0;i<7;i++){
             A.pedro[i]=p2.pedro[i];
         }
         System.out.println(A);
         System.out.println(B);
         System.out.println(p);
         return p;
         
    }
    @Override
    public String toString(){
        String s="";
        if(this.pedro[0]!=0){
            s=s+this.pedro[0]+"X^6";
        }
        if(this.pedro[1]!=0){
            s=s+"+"+this.pedro[1]+"X^5";
        }
        if(this.pedro[2]!=0){
            s=s+"+"+this.pedro[2]+"X^4";
        }
        if(this.pedro[3]!=0){
            s=s+"+"+this.pedro[3]+"X^3";
        }
        if(this.pedro[4]!=0){
            s=s+"+"+this.pedro[4]+"X^2";
        }
        if(this.pedro[5]!=0){
            s=s+"+"+this.pedro[5]+"X";
        }
        if(this.pedro[6]!=0){
            s=s+"+"+this.pedro[6];
        }
        return s;
    }
    static polinomio suma(polinomio a, polinomio b){
        polinomio c= new polinomio();
        for(int i=0; i<7;i++){
            c.pedro[i]=a.pedro[i]+b.pedro[i];
        }
        return c;
    }
    public  void polinomio(int a,float j[]){
        for(int i=0;i<6;i++){
            this.resultados[i]=j[i];
        }
    }
    
    public boolean equals(polinomio j){
        DecimalFormat formato1 = new DecimalFormat("#.00");
        boolean h=true;
        for(int i=0;i<7;i++){
            if(formato1.format(this.pedro[i])!=formato1.format(j.pedro[i])){
                h=false;
            }
        }
        return h;
    }
    static polinomio resta(polinomio a, polinomio b){
        polinomio c = new polinomio();
        for(int i=0;i<7;i++){
            c.pedro[i]=a.pedro[i]-b.pedro[i];
        }
        return c;
    }
    static polinomio multiplicacion(polinomio a, polinomio b){
        polinomio c = new polinomio();
        
        return c;
    }
    public boolean esMayor(polinomio a){
        boolean edo=false;
        if(this.pedro[0]>a.pedro[0]){
            edo=true;
        }
        return edo;
    }
    public static polinomio dameec(polinomio o){
        Random r = new Random();
        polinomio p2 = new polinomio();
        polinomio m1,m2,m3,m4,m5,m6;
        int aux [] = new int [7];
         for(int i=0;i<7;i++){
             do{
              aux[i]=r.nextInt(5);   
             }while(aux[i]==0);
         }
         int a0=aux[0];
         int a=aux[1];
         int b=aux[2];
         int c=aux[3];
         int d=aux[4];
         int e=aux[5];
         int f=aux[6];
         m1=new polinomio();
         for(int i=0;i<5;i++){
            m1.pedro[i]=0;
        } 
         m1.pedro[5]=a0;
         m1.pedro[6]=a;
         if(a0!= 0){
         o.resultados[0]=a/a0;    
         } 
         m2=new polinomio();
         for(int i=0;i<5;i++){
            m2.pedro[i]=0;
        } 
         m2.pedro[5]=1;
         m2.pedro[6]=b;
         o.resultados[1]=-b;
         m3=new polinomio();
         for(int i=0;i<5;i++){
            m3.pedro[i]=0;
        } 
         m3.pedro[5]=1;
         m3.pedro[6]=c;
         o.resultados[2]=-c;
         m4=new polinomio();
         for(int i=0;i<5;i++){
            m4.pedro[i]=0;
        } 
         m4.pedro[5]=1;
         m4.pedro[6]=d;
         o.resultados[3]=-d;
         m5=new polinomio();
         for(int i=0;i<5;i++){
            m5.pedro[i]=0;
        } 
         m5.pedro[5]=1;
         m5.pedro[6]=e;
         o.resultados[4]=-e;
         m6=new polinomio();
         for(int i=0;i<5;i++){
            m6.pedro[i]=0;
        } 
         m6.pedro[5]=1;
         m6.pedro[6]=f;
         o.resultados[5]=-f;
         p2=Polinomiodoble.multiplicacion(m6,Polinomiodoble.multiplicacion(m5,Polinomiodoble.multiplicacion(m4,Polinomiodoble.multiplicacion(m3,Polinomiodoble.multiplicacion(m1, m2).topolinomio()).topolinomio()).topolinomio()).topolinomio()).topolinomio();
         System.out.println(p2);
        return p2; 
    }
    public boolean esigual(polinomio o){
        boolean hoja=true;
        int ayudante=0;
        for(int i=0;i<6;i++){
            for(int x=0;x<6;x++){
                if(this.resultados[i]==o.resultados[x]){
                    ayudante++;
                }
            }
            if(ayudante<=0){
                hoja= false;   
            }
            ayudante=0;
            System.out.println(o.resultados[i]);
        }
        return hoja;
    }
    
}
