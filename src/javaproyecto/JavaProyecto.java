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

        while (!salir) {

            Connection miConexion = establecerConexion();
            if (Sesion.iniciarSesion(miConexion)) {
                salir = mostrarMenuUsuarioRegistrado(miConexion, salir);
            }

        }
    }

    public static boolean mostrarMenuUsuarioRegistrado(Connection miConexion, boolean salir) throws SQLException, IOException {
  
        
        boolean salida = false;
        while (miConexion != null);
{
            
            int opcion;
            System.out.println("-----MENU-------");
            System.out.println("1. Agregar Nuevo Empleado");
            System.out.println("2. Agregar Nuevo salario");
            System.out.println("3. Agregar nuevo Departamento");
            System.out.println("4. Actualizar Datos de Empleado");
            System.out.println("5. Actualizar Salario De Empleado");
            System.out.println("6. Generar Nomina");
            System.out.println("7. Salida");
            System.out.println("Escribe una de las opciones");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    Empleado emp = new Empleado();
                    emp.agregarEmpleado();
                    break;
                case 2:
                    salarioEmpleado salEmp = new salarioEmpleado();
                    salEmp.agregarEmpleado();
                    break;
                case 3 :
                    Departamentos dep = new Departamentos();
                    dep.agregarDepartamento();
                    break;
                case 4:
                    Empleado actEmp = new Empleado();
                    actEmp.mostrarDatosDeEmpleados();
                    actEmp.actualizarEmpleado();
                    break;
                case 5:
                    salarioEmpleado actualizarSalario = new salarioEmpleado();
                    actualizarSalario.mostrarSalario();
                    actualizarSalario.actualizarEmpleado();
                    break;
                case 6:
                    generarNomina generaNomi = new generarNomina();
                    generaNomi.generaNomina();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        return salir;
    }
}
