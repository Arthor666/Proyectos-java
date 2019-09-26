/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuariomatriz;

/**
 *
 * @author Arturo
 */
public class UsuarioMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz M1 = new Matriz(3,4,"M1");
        Matriz M2 = new Matriz(3,4,"M3",10);
        M2.imp();
        Matriz suma = new Matriz(3,4,"Sumar");
        suma=Matriz.sumar(M1,M2);
        suma.imp();
    }
    
}
