/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victo;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Ejemplo7 {
    
     public static void main(String args[]) throws IOException {
    ProcessBuilder pb = new ProcessBuilder("CMD","/C" ,"DIR");
    
    File fOut = new File("salida.txt");
    File fErr = new File("error.txt");
 
    pb.redirectOutput(fOut);
    pb.redirectError(fErr); 
    pb.start(); 
  }
}
