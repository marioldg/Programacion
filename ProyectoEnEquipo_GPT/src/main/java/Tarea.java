import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tarea {
    private final String id;
    private final int complejidad;
    private final ArrayList<String>habilidadesRequeridas;
    public Tarea(String id, int complejidad,ArrayList<String> habilidadesRequeridas) {
        this.id = id;
        this.complejidad = complejidad;
        this.habilidadesRequeridas = habilidadesRequeridas;
    }

    public String getId() {
        return id;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public ArrayList<String> getHabilidadesRequeridas() {
        return habilidadesRequeridas;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id='" + id + '\'' +
                ", complejidad=" + complejidad +
                ", habilidadesRequeridas=" + habilidadesRequeridas +
                '}';
    }
}
