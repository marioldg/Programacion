public class Casa {
    private int nVentanas;
    private int nHabitaciones;
    private boolean puertaAbierta;
    private boolean[] ventanasAbiertas;
    private int personasDentro;
    private int gatosDentro;
    private int personasCaben;
    private int gatosCaben;
    private boolean ventanas[];






    public Casa(int nVentanas, int nHabitaciones) {
        if(nVentanas<=0){
            nVentanas=1;
        }else{
            this.nVentanas=nVentanas;
        }
        if(nHabitaciones<=0){
            nHabitaciones=1;
        }else{
            this.nHabitaciones=nHabitaciones;
        }

        this.puertaAbierta = false;

        if(personasDentro<0){
            personasDentro=0;
        }else{
            this.personasDentro=0;
        }

        if(gatosDentro<0){
            gatosDentro=0;
        }else{
            this.gatosDentro=0;
        }

        this.gatosCaben=gatosCaben;
        this.personasCaben=personasCaben;
        this.ventanas= new boolean[nVentanas];
        for(int i=0; i<nVentanas; i++){
            ventanas[i]=true;
        }
    }

    public boolean abrirVentana(int n) {
        if (n >= 0 && n < ventanasAbiertas.length && !ventanasAbiertas[n]) {
            ventanasAbiertas[n] = true;
            return true;
        }
        return false;
    }


    public boolean cerrarVentana(int n) {
        if (n >= 0 && n < ventanasAbiertas.length && ventanasAbiertas[n]) {
            ventanasAbiertas[n] = false;
            return true;
        }
        return false;
    }

    public boolean abrirPuerta() {
        if (!puertaAbierta) {
            puertaAbierta = true;
            return true;
        }
        return false;
    }

    public boolean cerrarPuerta() {
        if (puertaAbierta) {
            puertaAbierta = false;
            return true;
        }
        return false;
    }

    public boolean aforoLleno() {
        int personasPorHabitacion = personasDentro / nHabitaciones;
        int gatosPorHabitacion = gatosDentro / nHabitaciones;

        if (personasPorHabitacion > 2) {
            return true;
        } else if (personasPorHabitacion == 1 && gatosPorHabitacion > 3) {
            return true;
        } else if (gatosPorHabitacion > 6) {
            return true;
        }

        return false;
    }

    public boolean meterPersona() {
        if (puertaAbierta && !aforoLleno()) {
            personasDentro++;
            personasCaben--;
            return true;
        }
        return false;
    }

    public boolean sacarPersona() {
        if (puertaAbierta && personasDentro > 0) {
            personasDentro--;
            personasCaben++;
            return true;
        }
        return false;
    }

    public boolean meterGato() {
        if (puertaAbierta && !aforoLleno() || hayVentanasAbiertas() && !aforoLleno()) {
            gatosDentro++;
            gatosCaben--;
            return true;
        }
        return false;
    }
    public boolean sacarGato() {
        if (puertaAbierta && gatosDentro > 0 || hayVentanasAbiertas() && gatosDentro > 0) {
            gatosDentro--;
            gatosCaben++;
            return true;
        }
        return false;
    }

    public boolean hayVentanasAbiertas(){
        for(int i= 0; i< nVentanas; i++){
            if(ventanasAbiertas[i]=true){
                return true;
            }
        }
        return false;
    }

    public EstadoCasa getEstadoCasa() {
        return new EstadoCasa(puertaAbierta, ventanasAbiertas, personasDentro, gatosDentro, personasCaben, gatosCaben);
    }

    public int getnHabitaciones() {
        return nHabitaciones;
    }

    public int getnVentanas() {
        return nVentanas;
    }

    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }

    public void setPuertaAbierta(boolean puertaAbierta) {
        this.puertaAbierta = puertaAbierta;
    }

    public boolean[] getVentanasAbiertas() {
        return ventanasAbiertas;
    }

    public void setVentanasAbiertas(boolean[] ventanasAbiertas) {
        this.ventanasAbiertas = ventanasAbiertas;
    }

    public int getPersonasDentro() {
        return personasDentro;
    }

    public void setPersonasDentro(int personasDentro) {
        this.personasDentro = personasDentro;
    }

    public int getGatosDentro() {
        return gatosDentro;
    }

    public void setGatosDentro(int gatosDentro) {
        this.gatosDentro = gatosDentro;
    }

    public int getPersonasCaben() {
        return personasCaben;
    }

    public void setPersonasCaben(int personasCaben) {
        this.personasCaben = personasCaben;
    }

    public int getGatosCaben() {
        return gatosCaben;
    }

    public void setGatosCaben(int gatosCaben) {
        this.gatosCaben = gatosCaben;
    }
}
