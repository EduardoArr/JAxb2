/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.victor;

/**
 *
 * @author victor
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    
    static Hilo h;
    static Label l;
    
    
    public static void main(String[] args) throws InterruptedException{
        String version = System.getProperty("java.version");
        l = new Label("Hello, javaFX 11, running on " + version);
        h = new Hilo(l);
        h.start();
        launch();
        h.finaliza();
    }
    
    @Override
    public void start(Stage stage) {
        //String version = System.getProperty("java.version");
        //l = new Label("Hello, javaFX 11, running on " + version);
        Scene scene = new Scene(new StackPane(l), 300, 200);
        stage.setScene(scene);
        stage.show();
    }
    
    
}