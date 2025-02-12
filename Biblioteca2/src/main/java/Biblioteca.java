import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> libros= new ArrayList<>();

    public Biblioteca(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public Biblioteca() {
    }

    public Libro[] librosPrestados() {
        ArrayList<Libro> librosConPrestamoPendiente = new ArrayList<>();

        for (Libro libro : libros) {
            ArrayList<Prestamo> prestamos = libro.getPrestamos();


            for (Prestamo prestamo : prestamos) {
                if (!prestamo.isFinalizado()) {
                    librosConPrestamoPendiente.add(libro);
                    break;
                }
            }
        }


        return librosConPrestamoPendiente.toArray(new Libro[0]);
    }

    public String cliente(Libro libro){
        String ret = null;
        for(Prestamo i : libro.getPrestamos()){
            if(!(i.isFinalizado())){
                ret= i.getNombreCliente();
            }
        }
        return ret;
    }

    public  Libro [] librosPrestadosEnFecha(int fecha){
        ArrayList<Libro> enFecha= new ArrayList<>();
        for(Libro libros : libros){
          for(Prestamo p : libros.getPrestamos()){
              if(fecha>=p.getFechaInicio() && fecha<= p.getFechaFin() || !p.isFinalizado() && p.getFechaInicio()<=fecha){
                  enFecha.add(libros);
                  break;
              }
          }
        }
        return enFecha.toArray(new Libro[0]);

    }


    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                '}';
    }
}
