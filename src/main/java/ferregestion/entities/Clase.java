package ferregestion.entities;

import java.util.Objects;

public class Clase {

    //atributos
    private String codigo_clase;
    private String nombre;

    //constructor vacio
    public Clase(){
    }

    //constructor para la lectura
    public Clase(String codigo_clase, String nombre) {
        this.codigo_clase = codigo_clase;
        this.nombre = nombre;
    }

    //getters and setters
    public String getCodigo_clase() {
        return codigo_clase;
    }

    public void setCodigo_clase(String codigo_clase) {
        this.codigo_clase = codigo_clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Clase{" +
                "codigo_clase='" + codigo_clase + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    //metodo equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clase clase = (Clase) o;
        return Objects.equals(codigo_clase, clase.codigo_clase) && Objects.equals(nombre, clase.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_clase, nombre);
    }
}