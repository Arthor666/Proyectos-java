/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author arturo briones
 */
public class RSA implements Serializable{
    private KeyPair llaves;
    private static final long serialVersionUID = 42L;
    public RSA() throws NoSuchAlgorithmException{
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048, new SecureRandom());
        this.llaves = generator.generateKeyPair();
    }

    public String enciptar(String text) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE,llaves.getPublic());

        byte[] cipherText = encryptCipher.doFinal(text.getBytes(UTF_8));

        return Base64.getEncoder().encodeToString(cipherText);
    }
    
    public static String desencriptar(String ruta) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(ruta));
        Mensaje m = new Mensaje();
        RSA llave = new RSA();
                m=(Mensaje)archivo.readObject();
        archivo.close();
        byte[] bytes = Base64.getDecoder().decode(m.getMensaje());
        Cipher decriptCipher = Cipher.getInstance("RSA");
        decriptCipher.init(Cipher.DECRYPT_MODE, m.getllave().llaves.getPrivate());
        
        return new String(decriptCipher.doFinal(bytes), UTF_8);
    }
}
