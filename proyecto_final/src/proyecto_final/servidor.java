/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author arturo briones
 */
public class servidor {
    private ServerSocket servidor = null;
    public servidor() throws IOException{
        servidor = new ServerSocket( 4400 );
        System.out.println( "Esperando recepcion de archivos..." ); 
    }
    
    public void Iniciarserver(){
        while( true )
          {
 
            try
            {
               // Creamos el socket que atendera el servidor
               Socket cliente = servidor.accept(); 
 
               // Creamos flujo de entrada para leer los datos que envia el cliente 
               DataInputStream dis = new DataInputStream( cliente.getInputStream() );
        
               // Obtenemos el nombre del archivo
               String nombreArchivo = dis.readUTF().toString(); 
 
               // Obtenemos el tamaño del archivo
               int tam = dis.readInt(); 
 
               System.out.println( "Recibiendo archivo "+nombreArchivo );
        
               // Creamos flujo de salida, este flujo nos sirve para 
               // indicar donde guardaremos el archivo
               FileOutputStream fos = new FileOutputStream("C:/Users/ale_m/Downloads/"+nombreArchivo );
               BufferedOutputStream out = new BufferedOutputStream(fos);
               BufferedInputStream in = new BufferedInputStream(cliente.getInputStream());
 
               // Creamos el array de bytes para leer los datos del archivo
               byte[] buffer = new byte[ tam ];
 
               // Obtenemos el archivo mediante la lectura de bytes enviados
               for( int i = 0; i < buffer.length; i++ )
               {
                  buffer[ i ] = ( byte )in.read( ); 
               }
 
               // Escribimos el archivo 
               out.write( buffer ); 
 
               // Cerramos flujos
               out.flush(); 
               in.close();
               out.close(); 
               cliente.close();
 
               System.out.println( "Archivo Recibido "+nombreArchivo );
        
           }
           catch( Exception e )
           {
              System.out.println( "Recibir: "+e.toString() ); 
           }
         } 
    }
}
