public class Main {
    public static void main(String[] args) {
        Termostato t = new Termostato(4);
        System.out.println( t.getEstadoCaldera());
        t.setModo(3);
        t.setTemperaturaReal(7);
        t.setTemperaturaDeseada(9);
        System.out.println(t);

    }
}
