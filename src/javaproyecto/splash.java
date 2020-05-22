/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author luban
 */
public class splash {
    public static void main (String s[]){
        sframe f1 = new sframe("Sistema de Calcular nominas");
    }
    
    class sframe extends JFrame implements Runnable{
        Thread t1;
        sframe (String s){
            super(s);
            setLayout (new FlowLayout());
            
    }
}
}
