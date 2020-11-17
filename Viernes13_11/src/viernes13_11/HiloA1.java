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
public class HiloA1 extends Thread{
    private ContadorSincronizado contador;
    
    public HiloA1(String n, ContadorSincronizado c){
        setName(n);
        contador = c;
    }
    
    public void run(){
        for(int j = 0; j<300; j++){
        contador.incrementa();  
        try{
            sleep(1);
            
        }catch (InterruptedException e){
        }
      } 
        //System.out.println(getName() + " contador vale " + contador.valor());
    }

   
}
