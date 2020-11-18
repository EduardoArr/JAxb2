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
public class HijoEjemplo1 extends Thread{
    
    public HijoEjemplo1(String nombre){
        super(nombre);
        System.out.println("Creado Hilo: " + getName());
    }
    
    public void run() {
        for(int i=0; i<5; i++){
            System.out.println("Hilo: " + getName() + " C = " + i);
        }
    }
}

