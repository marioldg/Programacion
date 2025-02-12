package EJ3;

public class Alumno {
    private String nom;

    public Alumno(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "nom='" + nom ;

    }
}
