public class Main {
    public static void main(String[] args) {

        Autobus a1 = new Autobus(0);
        System.out.println(a1.pasajeros());
        System.out.println(a1.plazasLibres());
        a1.subir(46);
        a1.subir(-2);
        a1.bajar(-2);
        System.out.println(a1.pasajeros());
        System.out.println(a1.plazasLibres());

       /*
            a1.subir(11);
            System.out.println(a1.pasajeros());
            System.out.println(a1.plazasLibres());

        a1.subir(-2);
        System.out.println(a1.pasajeros());
        System.out.println(a1.plazasLibres());
        a1.bajar(1);
        System.out.println(a1.pasajeros());
        System.out.println(a1.plazasLibres());
        a1.bajar(-3);
        System.out.println(a1.pasajeros());
        System.out.println(a1.plazasLibres());
        */

    }
}
