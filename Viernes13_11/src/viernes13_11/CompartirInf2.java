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
public class CompartirInf2 {
    public static void main(String[] args) {
        
        ContadorSincronizado cont = new ContadorSincronizado(100);
        HiloA1 a = new HiloA1("HiloA", cont);
        HiloB1 b = new HiloB1("HiloB", cont);
        System.out.println("Iniciando los hilos");
        a.start();
        b.start();
        
       while(!a.isAlive() || !b.isAlive()){
            ;
        }
       System.out.println(" contador vale " + cont.valor());

    }
}
