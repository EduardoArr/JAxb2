/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author alumno
 */
public class Ejemplo4 {
    public static void main(String[] args) throws IOException {
        
               File dir= new File("./build/classes/victo");
		//ProcessBuilder pb = new ProcessBuilder("java", "Espera");
                ProcessBuilder pb = new ProcessBuilder("pwd");
                pb.directory(dir);
                
                
                Process p = pb.start(); 

		// escritura -- envia entrada a DATE
		//OutputStream os = p.getOutputStream();
		//os.write("01-12-17".getBytes());
		//os.flush(); // vacía el buffer de salida

		// lectura -- obtiene la salida de DATE
		InputStream is = p.getInputStream();		
		 int c;
		 while ((c = is.read()) != -1)
			System.out.print((char) c);
		 is.close();
		 
		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
  }
