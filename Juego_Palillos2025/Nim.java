public class Nim {
    private int palillos;
    private boolean turno; // true = jugador 1, false = jugador 2

    public Nim() {
        palillos = 13;
        turno = true;
    }

    public boolean coger(int n) {
        if (n > 0 && n < 4 && n <= palillos) { // Verifica si es una jugada válida
            palillos -= n;
            turno = !turno; // Cambia el turno solo si la jugada fue válida
            return true;
        }
        return false; // Movimiento inválido
    }

    public int cuantosQuedan() {
        return palillos;
    }

    public boolean turno() {
        return turno;
    }

    public boolean juegoTerminado() {
        return palillos == 0;
    }
}

