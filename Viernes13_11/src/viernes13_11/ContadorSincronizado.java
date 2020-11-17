/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viernes13_11;

/**
 *
 * @author alumno
 */
public class ContadorSincronizado {
    private int c = 0;
    
    ContadorSincronizado(int c){
        this.c = c;
    }
    
    public synchronized void incrementa(){
        c++;
    }
    
    public synchronized int valor(){
        return c;
    }
}
