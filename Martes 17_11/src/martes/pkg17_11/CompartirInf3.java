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
public class CompartirInf3 {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(40);
        SacarDinero h1 = new SacarDinero("Ana", c);
        SacarDinero h2 = new SacarDinero("Carlos", c);
        h1.start();
        h2.start();
    }
}
