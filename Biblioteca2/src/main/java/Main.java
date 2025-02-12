import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Prestamo prestamo1 = new Prestamo("Cliente1", 10122023, 0, false);
        Prestamo prestamo2 = new Prestamo("Cliente2", 11122023, 12122023, true);
        Prestamo prestamo3 = new Prestamo("Cliente3", 12122023, 0, false);



        ArrayList<Prestamo> prestamosLibro1 = new ArrayList<>();
        prestamosLibro1.add(prestamo1);
        prestamosLibro1.add(prestamo2);
        Libro libro1 = new Libro(prestamosLibro1, "Libro Uno");


        ArrayList<Prestamo> prestamosLibro2 = new ArrayList<>();
        Prestamo prestamoFinalizado = new Prestamo("Cliente4", 10122023, 11122023, true);
        prestamosLibro2.add(prestamoFinalizado);
        Libro libro2 = new Libro(prestamosLibro2, "Libro Dos");


        ArrayList<Prestamo> prestamosLibro3 = new ArrayList<>();
        prestamosLibro3.add(prestamo3);
        Libro libro3 = new Libro(prestamosLibro3, "Libro Tres");


        ArrayList<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);


        Biblioteca biblioteca = new Biblioteca(listaLibros);


        Libro[] librosConPrestamoPendiente = biblioteca.librosPrestados();
        System.out.println( biblioteca.cliente(libro1));
    }
}

