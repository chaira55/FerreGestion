package ferregestion.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pago {

    //atributos
    private int id_pago;
    private int id_credito;
    private int cedula;
    private LocalDate fecha_pago;
    private double monto;

    //constructor vacio
    public Pago(){
    }

    //constructor para el registro
    public Pago(int id_credito, int cedula, LocalDate fecha_pago, double monto) {
        this.id_credito = id_credito;
        this.cedula = cedula;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    //constructor para la lectura
    public Pago(int id_pago, int id_credito, int cedula, LocalDate fecha_pago, double monto) {
        this.id_pago = id_pago;
        this.id_credito = id_credito;
        this.cedula = cedula;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id_pago=" + id_pago +
                ", id_credito=" + id_credito +
                ", cedula=" + cedula +
                ", fecha_pago=" + fecha_pago +
                ", monto=" + monto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pago pago = (Pago) o;
        return id_pago == pago.id_pago && id_credito == pago.id_credito && cedula == pago.cedula && Double.compare(monto, pago.monto) == 0 && Objects.equals(fecha_pago, pago.fecha_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pago, id_credito, cedula, fecha_pago, monto);
    }
}
