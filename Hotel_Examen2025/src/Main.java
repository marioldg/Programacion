public class Main {
    public static void main(String[] args) {



        Habitacion h1 = new Habitacion(100,20.0,false,false);
        Habitacion h2 = new Habitacion(220,40.0,false,false);
        Habitacion h3 = new Habitacion(210,50.0,true,false);
        Habitacion h4 = new Habitacion(400,10.0,false,false);

        Hotel hot = new Hotel();


        hot.anadir(h1);
        hot.anadir(h2);
        hot.anadir(h3);
        hot.anadir(h4);

        System.out.println(hot.buscar1(30,true));

        System.out.println(hot.buscarN(25,false,1));



    }
}
