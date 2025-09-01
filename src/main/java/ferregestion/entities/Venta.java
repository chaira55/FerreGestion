package ferregestion.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Venta {

    //atrubutos
    private int id_venta;
    private int cedula;
    private String nombre;
    private int id_cotizacion;
    private LocalDate fecha;
    private double total;
    private String tipo_pago; //contado-credito

    //cosntructor vacio
    public Venta() {
    }

    //constructor para el registro
    public Venta(int cedula, String nombre, int id_cotizacion, LocalDate fecha, double total, String tipo_pago) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.id_cotizacion = id_cotizacion;
        this.fecha = fecha;
        this.total = total;
        this.tipo_pago = tipo_pago;
    }

    //cosntructor para la lectura en la base de datos
    public Venta(int id_venta, int cedula, String nombre, int id_cotizacion, LocalDate fecha, double total, String tipo_pago) {
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.nombre = nombre;
        this.id_cotizacion = id_cotizacion;
        this.fecha = fecha;
        this.total = total;
        this.tipo_pago = tipo_pago;
    }

    //getters and setter
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

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
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

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", id_cotizacion=" + id_cotizacion +
                ", fecha=" + fecha +
                ", total=" + total +
                ", tipo_pago='" + tipo_pago + '\'' +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id_venta == venta.id_venta && cedula == venta.cedula && id_cotizacion == venta.id_cotizacion && Double.compare(total, venta.total) == 0 && Objects.equals(nombre, venta.nombre) && Objects.equals(fecha, venta.fecha) && Objects.equals(tipo_pago, venta.tipo_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_venta, cedula, nombre, id_cotizacion, fecha, total, tipo_pago);
    }
}
