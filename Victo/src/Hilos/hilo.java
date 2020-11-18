
package Hilos;


public class hilo {
    public static void main(String[] args) {
        
        PrimerHilo p = new PrimerHilo(10);
        p.start();
        
        HijoEjemplo1 h1 = new HijoEjemplo1("Hilo 1");
        HijoEjemplo1 h2 = new HijoEjemplo1("Hilo 2");
        HijoEjemplo1 h3 = new HijoEjemplo1("Hilo 3");
        
        h1.start();
        h2.start();
        h3.start();
    }
}
