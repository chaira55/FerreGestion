package ferregestion.entities;

import java.util.Objects;

public class DetalleVenta {

    //atributos
    private int id_detalle_venta;
    private int id_enta;
    private int id_producto;
    private String descripcion_producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;

    //constructor vacio
    public DetalleVenta(){
    }

    //constructor para el registro

    public DetalleVenta(int id_enta, String descripcion_producto, int id_producto, int cantidad, double precio_unitario, double subtotal) {
        this.id_enta = id_enta;
        this.descripcion_producto = descripcion_producto;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    //constructor para la lectura de la base de datos

    public DetalleVenta(int id_detalle_venta, int id_enta, int id_producto, String descripcion_producto, double subtotal, int cantidad, double precio_unitario) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_enta = id_enta;
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle_venta=" + id_detalle_venta +
                ", id_enta=" + id_enta +
                ", id_producto=" + id_producto +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", subtotal=" + subtotal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleVenta that = (DetalleVenta) o;
        return id_detalle_venta == that.id_detalle_venta && id_enta == that.id_enta && id_producto == that.id_producto && cantidad == that.cantidad && Double.compare(precio_unitario, that.precio_unitario) == 0 && Double.compare(subtotal, that.subtotal) == 0 && Objects.equals(descripcion_producto, that.descripcion_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_detalle_venta, id_enta, id_producto, descripcion_producto, cantidad, precio_unitario, subtotal);
    }
}

