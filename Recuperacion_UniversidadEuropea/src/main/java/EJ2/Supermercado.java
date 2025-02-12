package EJ2;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado {
    private ArrayList<Producto> compra = new ArrayList<>();

    public Supermercado() {
        int cuenta=0;
        while(true){
            System.out.println("INGRESA EL NOMBRE DEL PRODUCTO");
            Scanner sc = new Scanner(System.in);
            String nomProducto = sc.next();
            System.out.println("INGRESA CANTIDAD DEL PRODUCTO");
            int cantidad = sc.nextInt();

            Producto p1 = new Producto(cantidad, nomProducto);
            compra.add(p1);
            cuenta += cantidad * p1.getPrecio();
            System.out.println("Producto ingresado: " + nomProducto + " " + cantidad);
            System.out.println("DESEA CONTINUAR?");
            String seguir = sc.next();

            if(!(seguir.equalsIgnoreCase("Si"))){
                break;
            }
        }
        System.out.println("A PAGAR :" + cuenta);
    }
}
