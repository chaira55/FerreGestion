package ferregestion.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pago {

    //atributos
    private int id_pago;
    private int id_credito;
    private int cedula;
    private String nombre;
    private LocalDate fecha_pago;
    private double monto;

    //constructor vacio
    public Pago(){
    }

    //constructor para el registro
    public Pago(int id_credito, int cedula, String nombre, LocalDate fecha_pago, double monto) {
        this.id_credito = id_credito;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    //constructor para la lectura en la base de datos
    public Pago(int id_pago, int id_credito, int cedula, String nombre, LocalDate fecha_pago, double monto) {
        this.id_pago = id_pago;
        this.id_credito = id_credito;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    //getters and setters
    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
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

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Pago{" +
                "id_pago=" + id_pago +
                ", id_credito=" + id_credito +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", fecha_pago=" + fecha_pago +
                ", monto=" + monto +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pago pago = (Pago) o;
        return id_pago == pago.id_pago && id_credito == pago.id_credito && cedula == pago.cedula && Double.compare(monto, pago.monto) == 0 && Objects.equals(nombre, pago.nombre) && Objects.equals(fecha_pago, pago.fecha_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pago, id_credito, cedula, nombre, fecha_pago, monto);
    }
}
