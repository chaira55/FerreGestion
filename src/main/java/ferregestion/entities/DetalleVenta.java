package ferregestion.entities;

import java.util.Objects;

public class DetalleVenta {

    //atributos
    private int id_detalle_venta;
    private int id_venta;
    private int id_producto;
    private String descripcion_producto;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;

    //constructor vacio
    public DetalleVenta(){
    }

    //constructor para el registro
    public DetalleVenta(int id_venta, int id_producto, String descripcion_producto, int cantidad, double precio_unitario, double subtotal) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    //constructor para la lectura de la base de datos
    public DetalleVenta(int id_detalle_venta, int id_venta, int id_producto, String descripcion_producto, double subtotal, int cantidad, double precio_unitario) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.descripcion_producto = descripcion_producto;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    //getters and setters
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    //metodo toString
    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle_venta=" + id_detalle_venta +
                ", id_enta=" + id_venta +
                ", id_producto=" + id_producto +
                ", descripcion_producto='" + descripcion_producto + '\'' +
                ", cantidad=" + cantidad +
                ", precio_unitario=" + precio_unitario +
                ", subtotal=" + subtotal +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DetalleVenta that = (DetalleVenta) o;
        return id_detalle_venta == that.id_detalle_venta && id_venta == that.id_venta && id_producto == that.id_producto && cantidad == that.cantidad && Double.compare(precio_unitario, that.precio_unitario) == 0 && Double.compare(subtotal, that.subtotal) == 0 && Objects.equals(descripcion_producto, that.descripcion_producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_detalle_venta, id_venta, id_producto, descripcion_producto, cantidad, precio_unitario, subtotal);
    }
}

