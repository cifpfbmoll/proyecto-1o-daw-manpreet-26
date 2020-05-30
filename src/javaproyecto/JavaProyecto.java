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

    /**
     * @param args the command line arguments
     *
     */
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, IOException {
        boolean salir = false;
        ListaEmpleado.listaDeEmpleado();
        
        while (!salir) {

            Connection miConexion = establecerConexion();
            if (Sesion.iniciarSesion(miConexion)) {
                salir = mostrarMenuUsuarioRegistrado(miConexion, salir);
            }

        }
    }

    public static boolean mostrarMenuUsuarioRegistrado(Connection miConexion, boolean salir) throws SQLException, IOException {

        while (miConexion != null) {

            switch (pedirMenu()) {

                case 1:
                    int opcions;
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("1. AgregarNuevo Empleado");
                        System.out.println("2. Salario del Empleado");
                        System.out.println("3. Lista de Empleados");
                        opcions = lector.nextInt();
                        switch (opcions) {
                            case 1:
                                Empleado newEmp = new Empleado();
                                newEmp.agregarNuevoEmpleado();
                                break;
                            case 2:
                                SalarioEmpleado salEmp = new SalarioEmpleado();
                                salEmp.salarioSql();
                                break;
                            case 3:
                                //ListaEmpleado.listaDeEmpleado();
                                break;

                        }
                    }

                    break;
                case 2:
                    int alternativa;
                    boolean salida = false;
                    while (!salida) {
                        System.out.println("1. Actualizar salario");
                        System.out.println("2. Actualizar los datos de los empleados");
                        System.out.println("3. Asistencia");
                        alternativa = lector.nextInt();
                        switch (alternativa) {
                            case 1:

                                break;

                        }
                    }

                    break;
                case 3:
                    int opciones;
                    boolean dejar = false;
                    while (!dejar) {
                        System.out.println("Generar Nomina");
                        System.out.println("Lista de asistencia de los empleados");
                        opciones = lector.nextInt();
                        switch (opciones) {
                            case 1:

                                break;

                        }
                    }

                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        }
        return salir;
    }

    private static int pedirMenu() {
        int opcion;

        System.out.println("-----MENU-------");
        System.out.println("Registrar");
        System.out.println("Actualizar");
        System.out.println("Reporte");
        System.out.println("Salida");
        System.out.println("Escribe una de las opciones");
        opcion = lector.nextInt();

        return lector.nextInt();

    }

}
