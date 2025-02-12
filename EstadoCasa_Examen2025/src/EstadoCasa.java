import java.util.Arrays;

public class EstadoCasa {
    private final boolean puertaAbierta;
    private final boolean [] ventanasAbiertas;
    private final int personasDentro;
    private final int gatosDentro;
    private final int personasCaben;
    private final int gatosCaben;


    public EstadoCasa(boolean puertaAbierta, boolean[] ventanasAbiertas, int personasDentro, int gatosDentro, int personasCaben, int gatosCaben) {
        this.puertaAbierta = puertaAbierta;
        this.ventanasAbiertas = ventanasAbiertas;
        this.personasDentro = personasDentro;
        this.gatosDentro = gatosDentro;
        this.personasCaben = personasCaben;
        this.gatosCaben = gatosCaben;

    }

    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }

    public boolean[] getVentanasAbiertas() {
        return ventanasAbiertas;
    }

    public int getPersonasDentro() {
        return personasDentro;
    }

    public int getGatosDentro() {
        return gatosDentro;
    }

    public int getPersonasCaben() {
        return personasCaben;
    }

    public int getGatosCaben() {
        return gatosCaben;
    }

    @Override
    public String toString() {
        return "EstadoCasa{" +
                "puertaAbierta=" + puertaAbierta +
                ", ventanasAbiertas=" + Arrays.toString(ventanasAbiertas) +
                ", personasDentro=" + personasDentro +
                ", gatosDentro=" + gatosDentro +
                ", personasCaben=" + personasCaben +
                ", gatosCaben=" + gatosCaben +
                '}';
    }
}
