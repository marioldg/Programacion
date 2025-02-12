import java.util.ArrayList;

// CLASE MIEMBRO (corregida)
public class Miembro {
    private String nombre;
    private ArrayList<String> habilidades; // Ahora es una lista
    private int nivel;

    public Miembro(String nombre, ArrayList<String> habilidades, int nivel) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>(habilidades);
        this.nivel = nivel;
    }

    // Getters ajustados
    public ArrayList<String> getHabilidades() {
        return new ArrayList<>(habilidades);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }
}