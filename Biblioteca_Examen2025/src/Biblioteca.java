import java.time.LocalDate;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;


    public Biblioteca() {
        libros = new ArrayList<>();
    }


    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public Libro[] librosPrestados() {
        ArrayList<Libro> librosPrestados = new ArrayList<>();
        for (Libro i : libros) {
            if (i.tienePrestamoActivo()) {
                librosPrestados.add(i);
            }
        }
        return librosPrestados.toArray(new Libro[0]);
    }

    public String cliente(Libro libro) {
        if(libro.obtenerPrestamoActivo() != null){
            return  libro.obtenerPrestamoActivo().getNomCliente();
        }
       return null;
    }

    public Libro[] librosPrestadosEnFecha(LocalDate fecha) {
        ArrayList<Libro> librosPrestadosEnFecha = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.estuvoPrestadoEnFecha(fecha)) {
                librosPrestadosEnFecha.add(libro);
            }
        }
        return librosPrestadosEnFecha.toArray(new Libro[0]);
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }
}
