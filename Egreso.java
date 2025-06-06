package org.example;

/**
 * Clase que representa una transacción de la salida de dinero
 * Hereda de la clase abstracta Transaccion
 */
public class Egreso extends Transaccion {
    /**
     * Constructor
     * @param monto Cantidad de dinero egresada.
     * @param descripcion Descripción del egreso.
     * @param fecha Fecha del egreso.
     */
    public Egreso(double monto, String descripcion, String fecha) {
        super(monto, descripcion, fecha);
    }

    /**
     * Calcula el impuesto para un egreso del 5% del monto
     * @return Valor del impuesto.
     */
    @Override
    public double calcularImpuesto() {
        return monto * 0.05; // 5% de impuesto
    }

    /**
     * Procesa la transacción de egreso, validando que no exceda el capital disponible
     * @throws ExcepcionTransaccion Si el monto excede el capital disponible
     */
    @Override
    public void procesarTransaccion() throws ExcepcionTransaccion {
        if (monto > MainPractica1.capital) {
            throw new ExcepcionTransaccion("El egreso excede el capital disponible");
        }
    }

    /**
     * Método que muestra los detalles específicos del egreso
     * @return String con la información formateada
     */
    @Override
    public String toString() {
        return "[EGRESO]\n" + super.toString();
    }
}