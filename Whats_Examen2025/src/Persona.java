public class Persona {
    private String nombre;
    private String numero;
    private boolean admin;

    public Persona(String nombre, String numero, boolean admin) {
        this.nombre = nombre;
        this.numero = numero;
        this.admin = admin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", numero='" + numero + '\'' +
                ", admin=" + admin +
                '}';
    }
}
