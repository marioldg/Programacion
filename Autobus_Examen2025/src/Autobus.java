public class Autobus {
    private int capacidad;
    private int plazasOcupadas;
    private int plazasLibres;

    public Autobus(int capacidad) {
        if (capacidad <= 0) {
            this.capacidad = 45;
        } else {
            this.capacidad = capacidad;
        }


        this.plazasOcupadas = 0;
        this.plazasLibres = this.capacidad;

    }

    public int subir(int personas) {
        int ret = 0;
        if (personas < 0) {
            ret = bajar(Math.abs(personas));
        } else if (personas >= 0 && plazasLibres >= personas) {
            plazasLibres-=personas;
            plazasOcupadas+=personas;
            ret = personas;
        } else if (personas >= 0 && plazasLibres < personas) {
            plazasOcupadas=capacidad;
            ret = plazasLibres;
            plazasLibres=0;

        }

        return ret;

    }


    public int bajar(int personas) {
        int ret = 0;
        if (personas < 0) {
            ret = subir(Math.abs(personas));
        } else if (personas >= 0 && plazasOcupadas >= personas) {
            plazasOcupadas-=personas;
            plazasLibres+=personas;
            ret = personas;
        } else if (personas >= 0 && plazasOcupadas < personas) {
            plazasLibres=capacidad;
            ret = plazasOcupadas;
            plazasOcupadas=0;
        }
        return ret;
    }


    public int pasajeros() {
        return plazasOcupadas;
    }

    public int plazasLibres(){
        return plazasLibres;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(int plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public int getPlazasLibres() {
        return plazasLibres;
    }

    public void setPlazasLibres(int plazasLibres) {
        this.plazasLibres = plazasLibres;
    }
}

