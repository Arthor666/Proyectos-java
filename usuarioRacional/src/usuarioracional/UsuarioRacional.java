
package usuarioracional;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Arturo
 */
public class UsuarioRacional {

    public static void main(String[] args) {
        Random rand = new Random();
        int j=0,k=0;
        ArrayList <Racional> dinamico= new ArrayList <>();
        for (int i = 0; i < 6; i++) {
            j=rand.nextInt(10);
            k=rand.nextInt(10);
            dinamico.add( new Racional(j,k));
        }
       

    }
    
}
