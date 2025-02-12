import EJ2.Producto;
import EJ2.Supermercado;
import EJ3.Alumno;
import EJ3.MediaAlumnos;

public class Main {
    public static void main(String[] args) {

        Alumno al1= new Alumno("Pepe");
        Alumno al2= new Alumno("Paco");
        Alumno al3= new Alumno("Elena");
        Alumno al4= new Alumno("Nuria");

        MediaAlumnos m1 = new MediaAlumnos();
        m1.mediaActividades();
    }
}
