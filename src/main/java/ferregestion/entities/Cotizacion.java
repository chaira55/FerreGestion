package ferregestion.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Cotizacion {

    //atributos
    private int id_cotizacion;
    private int cedula;
    private String nombre;
    private LocalDate fecha;
    private double total;

    //constructor vacio
    public Cotizacion() {
    }

    //constructor para el registro
    public Cotizacion(int cedula, String nombre, LocalDate fecha, double total) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
    }

    //constructor para la lectura de la base de datos
    public Cotizacion(int id_cotizacion, int cedula, String nombre, LocalDate fecha, double total) {
        this.id_cotizacion = id_cotizacion;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fecha = fecha;
        this.total = total;
    }

    //getters and setters
    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    //metodo toString
    @Override
    public String toString() {
        return "Cotizacion{" +
                "id_cotizacion=" + id_cotizacion +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cotizacion that = (Cotizacion) o;
        return id_cotizacion == that.id_cotizacion && cedula == that.cedula && Double.compare(total, that.total) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cotizacion, cedula, nombre, fecha, total);
    }
}