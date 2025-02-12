public class Habitacion {
    private final int num;
    private final double metros;
    private final boolean banio;
    private boolean reservada;

    public Habitacion(int num, double metros, boolean banio,boolean reservada) {
        this.num = num;
        this.metros = metros;
        this.banio = banio;
        this.reservada=reservada;
    }

    public int getNum() {
        return num;
    }

    public double getMetros() {
        return metros;
    }

    public boolean isBanio() {
        return banio;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "num=" + num +
                ", metros=" + metros +
                ", banio=" + banio +
                ", reservada=" + reservada +
                '}';
    }
}
