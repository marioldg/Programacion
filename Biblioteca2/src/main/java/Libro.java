
import java.util.ArrayList;

public class Libro {
    private ArrayList<Prestamo> prestamos;
    private String titulo;

    public Libro(ArrayList<Prestamo> prestamos, String nombreLibro) {
        this.prestamos = prestamos;
        this.titulo = nombreLibro;
    }

    public Prestamo iniciarPrestamo(String cliente, int fechaInicio) {
        boolean existe = false;
        Prestamo ret = null;
        for (Prestamo i : prestamos) {
            if (!(i.isFinalizado())) {
                existe = true;
                ret = i;
            }
        }

        if (existe) {
            return ret;

        } else {
            Prestamo p = new Prestamo(cliente, fechaInicio, 0, false);
            prestamos.add(p);
            return p;

        }


    }

    public Prestamo finalizarPrestamo(int fechFin){
        boolean existe = false;
        Prestamo ret = null;
        for (Prestamo i : prestamos) {
            if (!(i.isFinalizado())) {
                existe = true;
                ret = i;
            }
        }

        if (!existe) {
            return ret;

        } else {
            ret.setFinalizado(true);
            return ret;
        }

    }



    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "prestamos=" + prestamos +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
