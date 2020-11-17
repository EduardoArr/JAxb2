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
public class Cuenta {

    private int saldo;
    
    Cuenta (int s) {
        saldo = s;
    }
    
    int getSaldo(){
        return saldo;
    }
    
   void restar(int cantidad){
       saldo = saldo - cantidad;
       
   }
   synchronized void RetirarDinero(int cant, String nombre){
       if(getSaldo() >= cant){
           System.out.println(nombre + " va a retirar saldo (Actual Es:) " + getSaldo() + " )" );
           
                try{
                 Thread.sleep(500);
                }catch (InterruptedException ex){}
           
                restar(cant); //Resta la cantidad del saldo
                
                
            System.out.println("\t" + nombre + " retira -> " + cant + " Actual(" + getSaldo() + ")");
            
            
                
                
      }else{
           
           System.out.println(nombre + " No puede retirar dinero, No Hay Saldo (" + getSaldo() + ")");
        
       }
       
       if(getSaldo() < 0){
           System.out.println("Saldo negativo => " + getSaldo());
       }
      
   }
    
}
