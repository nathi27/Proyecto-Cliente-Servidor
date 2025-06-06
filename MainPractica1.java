package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main que gestiona todo el sistema
 */
public class MainPractica1 {
    public static double capital = 1500.0; // Capital inicial
    private static ArrayList<Transaccion> transacciones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    /**
     * Muestra el menú principal y maneja las opciones del usuario.
     */
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN FINANCIERA ===");
            System.out.println("Capital actual: $" + String.format("%.2f", capital));
            System.out.println("1. Realizar transacción de Ingreso");
            System.out.println("2. Realizar transacción de Egreso");
            System.out.println("3. Mostrar todas las transacciones");
            System.out.println("4. Eliminar una transacción");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        realizarIngreso();
                        break;
                    case 2:
                        realizarEgreso();
                        break;
                    case 3:
                        mostrarTransacciones();
                        break;
                    case 4:
                        eliminarTransaccion();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = 0;
            }
        } while (opcion != 5);
    }

    /**
     * Realiza una transacción de ingreso, capturando los datos necesarios.
     */
    private static void realizarIngreso() {
        try {
            System.out.println("\n--- NUEVO INGRESO ---");
            System.out.print("Monto: ");
            double monto = Double.parseDouble(scanner.nextLine());

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Fecha (DD/MM/AAAA): ");
            String fecha = scanner.nextLine();

            Ingreso ingreso = new Ingreso(monto, descripcion, fecha);
            ingreso.procesarTransaccion(); // Validar la transacción

            transacciones.add(ingreso);
            capital += monto; // Aumentar el capital
            System.out.println("Ingreso registrado exitosamente!");
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un número válido.");
        } catch (ExcepcionTransaccion e) {
            System.out.println("Error en la transacción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Realiza una transacción de egreso, capturando los datos necesarios.
     */
    private static void realizarEgreso() {
        try {
            System.out.println("\n--- NUEVO EGRESO ---");
            System.out.print("Monto: ");
            double monto = Double.parseDouble(scanner.nextLine());

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Fecha (DD/MM/AAAA): ");
            String fecha = scanner.nextLine();

            Egreso egreso = new Egreso(monto, descripcion, fecha);
            egreso.procesarTransaccion(); // Validar la transacción

            transacciones.add(egreso);
            capital -= monto; // Disminuir el capital
            System.out.println("Egreso registrado exitosamente!");
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un número válido.");
        } catch (ExcepcionTransaccion e) {
            System.out.println("Error en la transacción: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    /**
     * Muestra todas las transacciones registradas en el sistema.
     */
    private static void mostrarTransacciones() {
        if (transacciones.isEmpty()) {
            System.out.println("\nNo hay transacciones registradas.");
            return;
        }

        System.out.println("\n--- LISTA DE TRANSACCIONES ---");
        for (int i = 0; i < transacciones.size(); i++) {
            System.out.println("\nTransacción #" + (i + 1));
            System.out.println(transacciones.get(i));
            System.out.println("----------------------------");
        }
    }

    /**
     * Elimina una transacción seleccionada por el usuario.
     */
    private static void eliminarTransaccion() {
        if (transacciones.isEmpty()) {
            System.out.println("\nNo hay transacciones para eliminar.");
            return;
        }

        mostrarTransacciones();
        System.out.print("\nIngrese el número de transacción a eliminar: ");

        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            if (index >= 0 && index < transacciones.size()) {
                Transaccion t = transacciones.get(index);

                // Ajustar el capital según el tipo de transacción
                if (t instanceof Ingreso) {
                    capital -= t.getMonto();
                } else if (t instanceof Egreso) {
                    capital += t.getMonto();
                }

                transacciones.remove(index);
                System.out.println("Transacción eliminada exitosamente!");
            } else {
                System.out.println("Número de transacción no válido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}