import java.util.ArrayList;

public class Hotel {
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Integer> habs ;


    public Hotel() {

    }

    public boolean anadir(Habitacion h) {
        for (Habitacion i : habitaciones) {
            if ((i.getNum() == h.getNum())) {
                return false;
            }
        }

        habitaciones.add(h);
        return true;
    }

    public boolean borrar(int numero) {
        for (Habitacion i : habitaciones) {
            if ((i.getNum() == numero)) {
                habitaciones.remove(i);
                return true;
            }
        }
        return false;
    }

    public double totalMetros() {
        double ret = 0.0;

        for (Habitacion i : habitaciones) {
            ret += i.getMetros();
        }
        return ret;
    }

    public boolean reservar(int numero) {
        for (Habitacion i : habitaciones) {
            if (!i.isReservada() && i.getNum() == numero) {
                i.setReservada(true);
                return true;
            }
        }
        return false;
    }

    public boolean anular(int numero) {
        for (Habitacion i : habitaciones) {
            if (i.isReservada() && i.getNum() == numero) {
                i.setReservada(false);
                return true;
            }
        }
        return false;

    }

    public int buscar1(double metrosMinimo, boolean baño) {
        for (Habitacion i : habitaciones) {
            if ((!i.isReservada() && i.getMetros() >= metrosMinimo && baño == true && i.isBanio() == true)) {
                return i.getNum();

            } else if ((!i.isReservada() && i.getMetros() >= metrosMinimo && baño == false)) {
                return i.getNum();
            }
        }

        return -1;

    }

    public ArrayList<Integer> buscarN(double metrosMinimo, boolean baño, int cuantas) {
        ArrayList<Habitacion> habitacionesLibres = new ArrayList<>();
        ArrayList<Integer> habs = new ArrayList<>();


        for (Habitacion i : habitaciones) {
            if ((!i.isReservada() && i.getMetros() >= metrosMinimo && baño == true && i.isBanio() == true)) {
                habitacionesLibres.add(i);
            } else if ((!i.isReservada() && i.getMetros() >= metrosMinimo && baño == false)) {
                habitacionesLibres.add(i);
            }
        }
        Habitacion ret = habitacionesLibres.get(0);
        for (Habitacion i : habitacionesLibres) {
            if (i.getNum() / 100 == ret.getNum() / 100) {
                habs.add(i.getNum());
                ret = i;
            }
        }
        if (habs.size() < cuantas) {
            return null;
        } else {
            return habs;
        }
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "habs=" + habs +
                '}';
    }
}
