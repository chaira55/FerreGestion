package ferregestion.entities;

import java.util.Objects;

public class Credito {

    //atrubutos
    private int id_credito;
    private int id_venta;
    private int cedula;
    private double monto_total;
    private double saldo_pendiente;
    private boolean imprimir_estado;

    //constructor vacio
    public Credito(){
    }

    // constructor para el registro
    public Credito(int id_venta, int cedula, double monto_total, double saldo_pendiente, boolean imprimir_estado) {
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.monto_total = monto_total;
        this.saldo_pendiente = saldo_pendiente;
        this.imprimir_estado = imprimir_estado;
    }

    //constructor para la lectura de la base de datos
    public Credito(int id_credito, double monto_total, int id_venta, int cedula, boolean imprimir_estado, double saldo_pendiente) {
        this.id_credito = id_credito;
        this.monto_total = monto_total;
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.imprimir_estado = imprimir_estado;
        this.saldo_pendiente = saldo_pendiente;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public double getSaldo_pendiente() {
        return saldo_pendiente;
    }

    public void setSaldo_pendiente(double saldo_pendiente) {
        this.saldo_pendiente = saldo_pendiente;
    }

    public boolean isImprimir_estado() {
        return imprimir_estado;
    }

    public void setImprimir_estado(boolean imprimir_estado) {
        this.imprimir_estado = imprimir_estado;
    }


    @Override
    public String toString() {
        return "Credito{" +
                "id_credito=" + id_credito +
                ", id_venta=" + id_venta +
                ", cedula=" + cedula +
                ", monto_total=" + monto_total +
                ", saldo_pendiente=" + saldo_pendiente +
                ", imprimir_estado=" + imprimir_estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credito credito = (Credito) o;
        return id_credito == credito.id_credito && id_venta == credito.id_venta && cedula == credito.cedula && Double.compare(monto_total, credito.monto_total) == 0 && Double.compare(saldo_pendiente, credito.saldo_pendiente) == 0 && imprimir_estado == credito.imprimir_estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_credito, id_venta, cedula, monto_total, saldo_pendiente, imprimir_estado);
    }
}
