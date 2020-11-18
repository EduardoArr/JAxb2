/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victo;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author alumno
 */
public class Prueba {
    public static void main(String[] args) throws IOException{
        ProcessBuilder pb = new ProcessBuilder("ls", "-l");
        Process p;
        p= pb.start();
        
        InputStream is = p.getInputStream();
        
        System.out.println("Hi");
        
        try{
            int c;
            do{
                c = is.read();
                if(c!=-1){
                    System.out.print((char)c);
                }
               
            }while(c!=-1);
             is.close();
             
             try{
                 int exitVal;
                 exitVal = p.waitFor();
                 System.out.println("Valor de salida: " + exitVal);
                         
             }catch(Exception e){
                e.printStackTrace();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
}
