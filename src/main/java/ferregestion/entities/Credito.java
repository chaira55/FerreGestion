package ferregestion.entities;

import java.util.Objects;

public class Credito {

    //atributos
    private int id_credito;
    private int id_venta;
    private int cedula;
    private String nombre;
    private double monto_total;
    private double saldo_pendiente;

    //constructor vacio
    public Credito(){
    }

    // constructor para el registro
    public Credito(int id_venta, int cedula, String nombre, double monto_total, double saldo_pendiente) {
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.nombre = nombre;
        this.monto_total = monto_total;
        this.saldo_pendiente = saldo_pendiente;
    }

    //constructor para la lectura de la base de datos
    public Credito(int id_credito, int id_venta, int cedula, String nombre, double monto_total, double saldo_pendiente) {
        this.id_credito = id_credito;
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.nombre = nombre;
        this.monto_total = monto_total;
        this.saldo_pendiente = saldo_pendiente;
    }

    //metodos getters and setters
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    //metodo toString
    @Override
    public String toString() {
        return "Credito{" +
                "id_credito=" + id_credito +
                ", id_venta=" + id_venta +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", monto_total=" + monto_total +
                ", saldo_pendiente=" + saldo_pendiente +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credito credito = (Credito) o;
        return id_credito == credito.id_credito && id_venta == credito.id_venta && cedula == credito.cedula && Double.compare(monto_total, credito.monto_total) == 0 && Double.compare(saldo_pendiente, credito.saldo_pendiente) == 0 && Objects.equals(nombre, credito.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_credito, id_venta, cedula, nombre, monto_total, saldo_pendiente);
    }
}
