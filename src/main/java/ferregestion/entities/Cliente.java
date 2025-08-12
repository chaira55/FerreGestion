package ferregestion.entities;

import java.util.Objects;

public class Cliente {
    private int cedula;
    private String nombre;
    private String celular;
    private String direccion;
    private String correo;

    public Cliente(){
    }

    public Cliente(int cedula, String nombre, String celular, String direccion, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cedula=" + cedula +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cedula == cliente.cedula && Objects.equals(nombre, cliente.nombre) && Objects.equals(celular, cliente.celular) && Objects.equals(direccion, cliente.direccion) && Objects.equals(correo, cliente.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula, nombre, celular, direccion, correo);
    }
}
