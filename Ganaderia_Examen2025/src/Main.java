import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vaca> listavacas= new ArrayList<>();


        Vaca vaca1 = new Vaca(10, 10, 90, "Pepa");
        Vaca vaca2 = new Vaca(7, 15, 50, "Fina");
        Vaca vaca3 = new Vaca(10, 9, 67, "Bella");
        Vaca vaca4 = new Vaca(90, 1, 55, "Kika");
        Vaca vaca5 = new Vaca(11, 4, 14, "Nuna");

        listavacas.add(vaca1);
        listavacas.add(vaca2);
        listavacas.add(vaca3);
        listavacas.add(vaca4);
        listavacas.add(vaca5);
        Ganaderia g = new Ganaderia(listavacas);
        System.out.println(g.masLeche());
        System.out.println(g.masPeso());
        System.out.println(g.masTalla());
        System.out.println(g.masLechePesoTalla());
        System.out.println(g.masConTopes(10,9,67));

    }
}
