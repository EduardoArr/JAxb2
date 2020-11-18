/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victo;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alumno
 */
public class Ejemplo6 {
    public static void main(String args[]) {
		
		File directorio = new File("/home/alumno/NetBeansProjects/Victo/build/classes/");
		File fOut = new File("salida.txt");
                File fErr = new File("error.txt");
                File fIn = new File("entrada.txt");
                
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		System.out.println("Variables de entorno:");
		System.out.println(entorno);

		//test = new ProcessBuilder("java", "Espera", "Pepe");
                test = new ProcessBuilder("java", "Espera");
                test.directory(directorio);
                test.redirectOutput(fOut);
                test.redirectError(fErr);
                test.redirectInput(fIn);
		
		// devuelve el nombre del proceso y sus argumentos
		List l = test.command();
		Iterator iter = l.iterator();
		System.out.println("\nArgumentos del comando:");
		while (iter.hasNext())
			System.out.println(iter.next());

		// ejecutamos el comando DIR
		//test = test.command("pwd");
		try {
			Process p = test.start();
			InputStream is = p.getInputStream();
		    
			System.out.println();
			// mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1)
				System.out.print((char) c);
			 is.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}