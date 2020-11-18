/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author alumno
 */
public class PrimerHilo extends Thread{
    private int x;
    
    public PrimerHilo(int x){
        this.x=x;
    }
    public void run(){
        for(int i = 0; i<x; i++){
            System.out.println("En el Hilo... " + i);
        }
    }
}
