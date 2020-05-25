/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.util.Scanner;



/**
 *
 * @author luban
 */
public class iniciar_sesion {
    Scanner lector = new Scanner (System.in);
    
    private String usuario;
    private String contraseña;

    public iniciar_sesion(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public iniciar_sesion() {
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void inicia () {
        System.out.println("Usuario : ");
        this.setUsuario(lector.next());
        System.out.println("Contraseña : ");
        this.setContraseña(lector.next());
        
       
    }
}
