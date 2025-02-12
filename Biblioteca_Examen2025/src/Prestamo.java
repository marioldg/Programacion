import java.time.LocalDate;

public class Prestamo {
    private String nomCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Prestamo(String nomCliente, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nomCliente = nomCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "nomCliente='" + nomCliente + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + (fechaFin != null ? fechaFin : "Pendiente") +
                '}';
    }
}
