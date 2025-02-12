import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        Libro l1 = new Libro("CR");
        Libro l2 = new Libro("Messi");
        Prestamo p1 = new Prestamo("Pepe", LocalDate.parse("2025-01-22"), null);
        Prestamo p2 = new Prestamo("Jose", LocalDate.parse("2025-01-24"), null);

        l1.iniciarPrestamo(p1.getNomCliente(),p1.getFechaInicio());
        l2.iniciarPrestamo(p2.getNomCliente(),p2.getFechaInicio());
        b.agregarLibro(l1);
        b.agregarLibro(l2);

        for (Libro i : b.librosPrestados()) {
            System.out.println(b);
        }


    }
}
