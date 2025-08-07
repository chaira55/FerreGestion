package ferregestion.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Venta {

    //atrubutos
    private int id_venta;
    private int cedula;
    private int id_cotizacion;
    private LocalDate fecha;
    private double total;
    private double tipo_pago;

    //cosntructor vacio
    public Venta(){
    }

    //constructor para el registro
    public Venta(int cedula, double total, LocalDate fecha, int id_cotizacion, double tipo_pago) {
        this.cedula = cedula;
        this.total = total;
        this.fecha = fecha;
        this.id_cotizacion = id_cotizacion;
        this.tipo_pago = tipo_pago;
    }

    //cosntructor para la lectura en la base de datos
    public Venta(int id_venta, int cedula, int id_cotizacion, double total, LocalDate fecha, double tipo_pago) {
        this.id_venta = id_venta;
        this.cedula = cedula;
        this.id_cotizacion = id_cotizacion;
        this.total = total;
        this.fecha = fecha;
        this.tipo_pago = tipo_pago;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", cedula=" + cedula +
                ", id_cotizacion=" + id_cotizacion +
                ", fecha=" + fecha +
                ", total=" + total +
                ", tipo_pago=" + tipo_pago +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id_venta == venta.id_venta && cedula == venta.cedula && id_cotizacion == venta.id_cotizacion && Double.compare(total, venta.total) == 0 && Double.compare(tipo_pago, venta.tipo_pago) == 0 && Objects.equals(fecha, venta.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_venta, cedula, id_cotizacion, fecha, total, tipo_pago);
    }
}
