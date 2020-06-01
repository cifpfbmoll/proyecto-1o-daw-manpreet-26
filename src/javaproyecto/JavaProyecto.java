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
  
        boolean salida = false;
        while (miConexion != null) {
            int opcion;
            System.out.println("-----MENU-------");
            System.out.println("1. Agregar Nuevo Empleado");
            System.out.println("2. Agregar Nuevo Departamento");
            System.out.println("3. Actualizar Datos de Empleado");
            System.out.println("4. Actualizar Salario De Empleado");
            System.out.println("5. Generar Nomina");
            System.out.println("6. Salida");
            System.out.println("Escribe una de las opciones");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    Empleado emp = new Empleado();
                    emp.agregarEmpleado();
                    salarioEmpleado salEmp = new salarioEmpleado();
                    salEmp.agregarEmpleado();
                    break;
                case 2:
                    Departamentos dep = new Departamentos();
                    dep.agregarDepartamento();
                    break;
                case 3:
                    Empleado actEmp = new Empleado();
                    actEmp.actualizarEmpleado();
                    break;
                case 4:
                    salarioEmpleado actualizarSalario = new salarioEmpleado();
                    actualizarSalario.actualizarEmpleado();
                    break;
                case 5:
                    salarioEmpleado nominaSalario = new salarioEmpleado();
                    nominaSalario.generarNomina();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        return salir;
    }
}
