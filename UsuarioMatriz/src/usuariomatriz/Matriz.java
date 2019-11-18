/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariomatriz;

import java.util.Random;
import usuarioracional.Racional;

/**
 *
 * @author Arturo
 */
public class Matriz {
    private String nombre;
    private int col;
    private int ren;
    private Racional [][] a;

    public  Matriz(int r, int c, String nombre){
        if(r>0){
            ren=r;
        }else{
           ren=10;
        }
        if(c>0){
            col=c;
        }else{
           col=10;
        }
        a = new Racional[r][c];
        for (int i = 0; i <ren; i++) {
            for(int x=0;x<col;x++){
                a [i][x]= new Racional(1,1);
            }
        }
        this.nombre=nombre;
    }
    public Matriz(int r, int c, String nombre, int m){
        Random rand = new Random ();
        if(r>0){
            ren=r;
        }else{
           ren=10;
        }
        if(c>0){
            col=c;
        }else{
           col=10;
        }
        a = new Racional[ren][col];
        for (int i = 0; i <ren; i++) {
            for (int j = 0; j <col; j++) {
                a[i][j]= new Racional(rand.nextInt(m),rand.nextInt(m));
            }
            
        }
        this.nombre=nombre;
        
    }
    public void imp(){
        for (int i = 0; i < ren; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static Matriz sumar(Matriz a, Matriz b){
        if(a.ren==b.ren&&a.col==b.col){
         Matriz auxiliar = new Matriz(a.ren,a.col, "Resultado");
            for (int i = 0; i < a.ren; i++) {
                for (int j = 0; j <a.col; j++) {
                    auxiliar.a[i][j]=a.a[i][j].sumar(b.a[i][j]);
                }
            }
            return auxiliar;
        }
        return null;
    }
}
