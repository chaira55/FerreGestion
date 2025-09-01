package ferregestion.entities;

import java.util.Objects;

public class Producto {

    //atributos
    private int id_producto;
    private String descripcion;
    private String codigo_clase;
    private String codigo_grupo;
    private double iva;
    private double precio_compra;
    private double precio_venta;
    private int stock;

    //constructor vacio
    public Producto(){
    }

    //constructor para el registro
    public Producto(String descripcion, String codigo_clase, String codigo_grupo, double iva, double precio_compra, double precio_venta, int stock) {
        this.descripcion = descripcion;
        this.codigo_clase = codigo_clase;
        this.codigo_grupo = codigo_grupo;
        this.iva = iva;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }

    //constructo para la lectura de la base de datos
    public Producto(int id_producto, String descripcion, String codigo_clase, String codigo_grupo, double iva, double precio_compra, double precio_venta, int stock) {
        this.id_producto = id_producto;
        this.descripcion = descripcion;
        this.codigo_clase = codigo_clase;
        this.codigo_grupo = codigo_grupo;
        this.iva = iva;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }

    //getters and setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_clase() {
        return codigo_clase;
    }

    public String getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(String codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public void setCodigo_clase(String codigo_clase) {
        this.codigo_clase = codigo_clase;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", descripcion='" + descripcion + '\'' +
                ", codigo_clase='" + codigo_clase + '\'' +
                ", codigo_grupo='" + codigo_grupo + '\'' +
                ", iva=" + iva +
                ", precio_compra=" + precio_compra +
                ", precio_venta=" + precio_venta +
                ", stock=" + stock +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id_producto == producto.id_producto && Double.compare(iva, producto.iva) == 0 && Double.compare(precio_compra, producto.precio_compra) == 0 && Double.compare(precio_venta, producto.precio_venta) == 0 && stock == producto.stock && Objects.equals(descripcion, producto.descripcion) && Objects.equals(codigo_clase, producto.codigo_clase) && Objects.equals(codigo_grupo, producto.codigo_grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_producto, descripcion, codigo_clase, codigo_grupo, iva, precio_compra, precio_venta, stock);
    }
}
