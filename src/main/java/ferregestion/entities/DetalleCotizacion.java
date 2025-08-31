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
    public DetalleCotizacion(int id_cotizacion, int id_producto, String descripcion_producto, int cantidad, double precio_unitario, double subtotal_produto) {
        this.id_cotizacion = id_cotizacion;
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

    public int getId_detalle_cotizacion() {
        return id_detalle_cotizacion;
    }

    public void setId_detalle_cotizacion(int id_detalle_cotizacion) {
        this.id_detalle_cotizacion = id_detalle_cotizacion;
    }

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
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

    public double getSubtotal_produto() {
        return subtotal_produto;
    }

    public void setSubtotal_produto(double subtotal_produto) {
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
