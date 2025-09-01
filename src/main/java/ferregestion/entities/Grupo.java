package ferregestion.entities;

import java.util.Objects;

public class Grupo {

    //atributos
    private String codigo_grupo;
    private String nombre;
    private double iva;

    //constructor vacio
    public Grupo(){
    }

    //constructor de registro y de lectura para la base de datos
    public Grupo(String codigo_grupo, String nombre, double iva) {
        this.codigo_grupo = codigo_grupo;
        this.nombre = nombre;
        this.iva = iva;
    }

    // getters and setters
    public String getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(String codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Grupo{" +
                "codigo_grupo='" + codigo_grupo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", iva=" + iva +
                '}';
    }

    //metodos equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Double.compare(iva, grupo.iva) == 0 && Objects.equals(codigo_grupo, grupo.codigo_grupo) && Objects.equals(nombre, grupo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_grupo, nombre, iva);
    }
}
