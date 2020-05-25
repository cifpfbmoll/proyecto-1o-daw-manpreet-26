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
public class JavaProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        Scanner lector = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Iniciar Sesion");
            System.out.println("Registrar");
            System.out.println("Actualizar");
            System.out.println("Reporte");
            System.out.println("Salida");

            System.out.println("Escribe una de las opciones");  //para hacer un input a opcion de menu
            opcion = lector.nextInt();
            switch (opcion) {

                case 1:
                    break;
                case 2:
                    int opcions;
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("AgregarNuevo Empleado");
                        System.out.println("Salario del Empleado");
                        System.out.println("Lista de Empleados");
                        opcions = lector.nextInt();
                        switch (opcions) {
                            case 1:

                                break;

                        }
                    }

                    break;
                case 3:
                    int alternativa;
                    boolean salida = false;
                    while (!salida) {
                        System.out.println("Actualizar salario");
                        System.out.println("Actualizar los datos de los empleados");
                        System.out.println("Asistencia");
                        alternativa = lector.nextInt();
                        switch (alternativa) {
                            case 1:

                                break;

                        }
                    }

                    break;
                case 4:
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

                case 5:
                    salir = true;
                    break;
            }

        }
    }
}
