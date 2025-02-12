import java.time.LocalDate;
import java.util.ArrayList;

public class Libro {
    private String titulo;
    private ArrayList<Prestamo> prestamos;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.prestamos = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public Prestamo iniciarPrestamo(String cliente, LocalDate fechaInicio) {
        if (tienePrestamoActivo()) {
            return obtenerPrestamoActivo();
        }
        Prestamo nuevoPrestamo = new Prestamo(cliente, fechaInicio, null);
        prestamos.add(nuevoPrestamo);
        return nuevoPrestamo;
    }

    public Prestamo finalizarPrestamo(LocalDate fechaFin) {
        Prestamo activo = obtenerPrestamoActivo();
        if (activo != null) {
            activo.setFechaFin(fechaFin);
            return activo;
        }
        return null;
    }

    public boolean tienePrestamoActivo() {
        if(obtenerPrestamoActivo()!=null){
            return true;
        }else{
            return false;
        }
    }

    public Prestamo obtenerPrestamoActivo() {
        for (Prestamo p : prestamos) {
            if (p.getFechaFin() == null) {
                return p;
            }
        }
        return null;
    }

    public boolean estuvoPrestadoEnFecha(LocalDate fecha) {
        for (Prestamo p : prestamos) {
            if (p.getFechaFin() != null) { // Si tiene fecha de devolución
                if (p.getFechaFin().isAfter(fecha)) {
                    return false;
                }
            } else {
                // Si la fecha de fin es null, el préstamo aún no se ha devuelto
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", prestamos=" + prestamos +
                '}';
    }
}
