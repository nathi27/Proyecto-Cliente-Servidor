package org.example;

/**
 * Clase que representa una transacción de ingreso de dinero
 * Hereda de la clase abstracta Transaccion
 */
public class Ingreso extends Transaccion {
    /**
     * Constructor
     * @param monto Cantidad de dinero ingresada.
     * @param descripcion Descripción del ingreso.
     * @param fecha Fecha del ingreso.
     */
    public Ingreso(double monto, String descripcion, String fecha) {
        super(monto, descripcion, fecha);
    }

    /**
     * Calcula el impuesto para un ingreso con un 15% del monto
     * @return Valor del impuesto.
     */
    @Override
    public double calcularImpuesto() {
        return monto * 0.15; // 15% de impuesto
    }

    /**
     * Procesa la transacción de ingreso, validando que el monto no sea negativo
     * @throws ExcepcionTransaccion Si el monto es negativo.
     */
    @Override
    public void procesarTransaccion() throws ExcepcionTransaccion {
        if (monto < 0) {
            throw new ExcepcionTransaccion("El monto no puede ser negativo para un ingreso");
        }
    }

    /**
     * Método para mostrar los detalles específicos del ingreso.
     * @return String con la información formateada.
     */
    @Override
    public String toString() {
        return "[INGRESO]\n" + super.toString();
    }
}