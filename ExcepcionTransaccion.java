package org.example;

/**
 * Excepción para manejar errores en las transacciones.
 */
public class ExcepcionTransaccion extends Exception {
    /**
     * Constructor con un mensaje personalizado.
     * @param mensaje Descripción del error.
     */
    public ExcepcionTransaccion(String mensaje) {
        super(mensaje);
    }
}