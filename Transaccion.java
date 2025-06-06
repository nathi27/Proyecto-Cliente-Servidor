package org.example;
/**
 * Clase abstracta que representa una transacción financiera genérica
 */
public abstract class Transaccion {

    protected double monto;
    protected String descripcion;
    protected String fecha;

    /**
     * Constructor
     * @param monto Cantidad de dinero de la transacción.
     * @param descripcion Descripción de la transacción.
     * @param fecha Fecha en que se realiza la transacción.
     */
    public Transaccion(double monto, String descripcion, String fecha) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    /**
     * Método abstracto para calcular el impuesto de la transacción.
     * @return El valor del impuesto calculado.
     */
    public abstract double calcularImpuesto();

    /**
     * Método abstracto para procesar la transacción.
     * @throws ExcepcionTransaccion Si hay un problema con los datos de la transacción.
     */
    public abstract void procesarTransaccion() throws ExcepcionTransaccion;

    // Getters
    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    /**
     * Método para mostrar los detalles de la transacción.
     * @return String con la información formateada.
     */
    @Override
    public String toString() {
        return "Fecha: " + fecha +
                "\nDescripción: " + descripcion +
                "\nMonto: $" + String.format("%.2f", monto) +
                "\nImpuesto: $" + String.format("%.2f", calcularImpuesto());
    }
}
