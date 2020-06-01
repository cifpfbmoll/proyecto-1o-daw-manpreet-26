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
            System.out.println("1. Registrar");
            System.out.println("2. Actualizar");
            System.out.println("3. Reporte");
            System.out.println("4. Salida");
            System.out.println("Escribe una de las opciones");
            opcion = lector.nextInt();
            switch (opcion) {

                case 1:
                    int opcions;
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("1. AgregarNuevo Empleado");
                        System.out.println("2. Salario del Empleado");
                        System.out.println("3. Lista de Empleados");
                        System.out.println("4. Volver Menu principal");
                        opcions = lector.nextInt();
                        switch (opcions) {
                            case 1:
                                Empleado emp = new Empleado();
                                emp.agregarNuevoEmpleado();
                                break;
                            case 2:
                                SalarioEmpleado salEmp = new SalarioEmpleado();
                                salEmp.salarioSql();
                                break;
                            case 3:
                                ListaEmpleado listEmp = new ListaEmpleado();
                                listEmp.listaDeEmpleado();
                                break;
                            case 4:
                                System.out.println("Has selecionado opcion de volver a menu principal");
                                exit = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
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
                        System.out.println("Volver a menu principal");
                        alternativa = lector.nextInt();
                        switch (alternativa) {
                            case 1:
                                actualitzarSalario salarioEmp = new actualitzarSalario();
                                salarioEmp.actulitzaSalarioDeEmpleado();
                                break;
                            case 2:
                                actualitzarEmpleados actEmp = new actualitzarEmpleados();
                                actEmp.actualizarEmpleado();
                                break;
                            case 3:
                                asistencia asis = new asistencia();
                                asis.asistenciaEmp();
                                break;
                            case 4:
                                System.out.println("Has selecionado opcion de volver a menu principal");
                                salida = true;
                                break;
                            default:
                                System.out.println("Opción no válida");

                        }
                    }

                    break;
                case 3:
                    int opciones;
                    boolean dejar = false;
                    while (!dejar) {
                        System.out.println("Generar Nomina");
                        System.out.println("Lista de asistencia de los empleados");
                        System.out.println("Volver al Menu principal");
                        opciones = lector.nextInt();
                        switch (opciones) {
                            case 1:
                                generarNomina nomina = new generarNomina();
                                nomina.generaNomina();
                                break;
                            case 2:
                                listaDeAsistencia listAsistencia = new listaDeAsistencia();
                                listAsistencia.listaDeAsistencia();
                                break;
                            case 3:
                                System.out.println("Has selecionado la opcion para Vover menu principal");
                                dejar = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
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

}
