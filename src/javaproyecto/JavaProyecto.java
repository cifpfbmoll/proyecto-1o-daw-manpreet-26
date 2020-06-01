/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import static javaproyecto.conecion_bbdd.establecerConexion;

/**
 *
 * @author luban
 */
public class JavaProyecto {

    static Scanner lector = new Scanner(System.in);

    /**
     * metodo main del proyecto que primero hace conecion con base de dato,si
     * establece conecion, despues de esto podemos trabajar con el proyecto y
     * ejecuta el menu.....
     *
     * @param args the command line arguments
     * @throws SQLException excepcion de sql
     * @throws IOException excepcion de io
     */
    public static void main(String[] args) throws SQLException, IOException {
        boolean salir = false;

        while (!salir) {

            Connection miConexion = establecerConexion();
            if (Sesion.iniciarSesion(miConexion)) {
                salir = mostrarMenuUsuarioRegistrado(miConexion, salir);
            }

        }
    }

    public static boolean mostrarMenuUsuarioRegistrado(Connection miConexion, boolean salir) throws SQLException, IOException {

        while (miConexion != null) {
            int opcion;
            System.out.println("-----MENU-------");
            System.out.println("1. Agregar Empleados");
            System.out.println("2. Actualizar Los datos de los Empleados");
            System.out.println("3. Generar Nomina");
            System.out.println("4. Lista De Empleados");
            System.out.println("5. Salida");
            System.out.println("Escribe una de las opciones");
            opcion = lector.nextInt();
            switch (opcion) {

                case 1:
                    Empleado emp = new Empleado();
                    emp.agregarNuevoEmpleado();
                            
                    break;
                case 2:
                    actualitzarEmpleados actEmp = new actualitzarEmpleados();
                    actEmp.actualizarEmpleado();
                    break;
                case 3:
                    generarNomina generNomina = new generarNomina();
                    generNomina.generaNomina();
                    break;
                case 4:
                    ListaEmpleado listaEmp = new ListaEmpleado();
                    
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        }
        return salir;
    }

}
