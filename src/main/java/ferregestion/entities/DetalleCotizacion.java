package ferregestion.entities;

import java.util.Objects;

public class DetalleCotizacion {

    //atributos
    private int id_detalle_cotizacion;
    private int id_cotizacion;
    private int id_producto;
    private String descripcion_producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal_produto;

    //constructor vacio
    public DetalleCotizacion(){
    }

    //constructor para su registro
    public DetalleCotizacion(int id_producto, String descripcion_producto, int cantidad, double precio_unitario, double subtotal_produto, int id_cotizacion) {
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal_produto = subtotal_produto;
        this.id_cotizacion = id_cotizacion;
    }

    //constructor para la lectura de la base de datos

    public DetalleCotizacion(int id_detalle_cotizacion, int id_cotizacion, int id_producto, String descripcion_producto, int cantidad, double precio_unitario, double subtotal_produto) {
        this.id_detalle_cotizacion = id_detalle_cotizacion;
        this.id_cotizacion = id_cotizacion;
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal_produto = subtotal_produto;
    }

    @Override
    public String toString() {
        return "DetalleCotizacion{" +
                "id_detalle_cotizacion=" + id_detalle_cotizacion +
                ", id_cotizacion=" + id_cotizacion +
                ", id_producto=" + id_producto +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", subtotal_produto=" + subtotal_produto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleCotizacion that = (DetalleCotizacion) o;
        return id_detalle_cotizacion == that.id_detalle_cotizacion && id_cotizacion == that.id_cotizacion && id_producto == that.id_producto && cantidad == that.cantidad && Double.compare(precio_unitario, that.precio_unitario) == 0 && Double.compare(subtotal_produto, that.subtotal_produto) == 0 && Objects.equals(descripcion_producto, that.descripcion_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_detalle_cotizacion, id_cotizacion, id_producto, descripcion_producto, cantidad, precio_unitario, subtotal_produto);
    }
}
