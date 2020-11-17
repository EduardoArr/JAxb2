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
public class CompartirInf1 {
    public static void main(String[] args) {
        
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        
        a.start();
        b.start();
        
       while(!a.isAlive() || !b.isAlive()){
            ;
        }
       System.out.println(" contador vale " + cont.valor());
    }
}
