/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martes.pkg17_11;

/**
 *
 * @author alumno
 */
public class SacarDinero extends Thread{
    private Cuenta c;
    private String nom;
    
    public SacarDinero(String n, Cuenta c){
        super(n);
        this.c = c;
    }
    
    @Override
    public void run(){
        for(int x = 1; x<=4; x++){
            c.RetirarDinero(10, getName());
            yield();
        }
    }
}
