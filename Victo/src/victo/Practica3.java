/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


public class Practica3 {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\bin");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo2");
        
        pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n", pb.directory());
        
        Process p = pb.start();
        
        try{
            InputStream is = p.getInputStream();
            
            int c;
            do{
                c = is.read();
                System.out.println((char) c);
                
            }while(c!=-1);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
