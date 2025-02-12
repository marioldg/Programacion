public class Vaca {
    private int leche;
    private int peso;
    private int talla;
    private String nombre;

    public Vaca(int leche, int peso, int talla, String nombre) {
        this.leche = leche;
        this.peso = peso;
        this.talla = talla;
        this.nombre = nombre;
    }

    public int getLeche() {
        return leche;
    }

    public void setLeche(int leche) {
        this.leche = leche;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
