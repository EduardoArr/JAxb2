/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.victor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author victor
 */
import javafx.application.Application;
public class Hilo extends Thread{
    
    Label l;
    int s, m, h;
    boolean fin;
    
    Hilo(Label l){
        this.l=l;
        s=0;
        m=0;
        h=0;
        fin=true;
    }
    
    public void finaliza(){
        fin=false;
    }
    
    private String generaEtiqueta(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String horaActual = sdf.format(cal.getTime());       
        return horaActual;
    }
    
    public void run(){
        try {
            sleep(2000);
            while(fin){
                //Platform.runLater(()-> {l.setText(h+":"+m+":"+s);});
                Platform.runLater(()-> {l.setText(generaEtiqueta());});
                sleep(1000);
                s++;
                if(s%60==0){
                    s=0;
                    m++;
                    if(m%60==0){
                        m=0;
                        h++;
                        if(h%24==0){
                            h=0;
                        }
                    }
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }    
        
    }
}
