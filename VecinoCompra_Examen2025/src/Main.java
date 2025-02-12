import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Vecino yo = new Vecino();

        // Vecinos compran cosas
        yo.fisgarCompra("Coche", 50);
        yo.fisgarCompra("Coche", 80);
        yo.fisgarCompra("Bicicleta", 20);
        yo.fisgarCompra("Móvil", 200);

        // Yo compro algunos objetos
        yo.comprar("Coche", 90); // No supera a 80 + 20%
        yo.comprar("Móvil", 250); // Supera a 200 + 20% (ok)
        yo.comprar("Bicicleta", 30); // Supera a 20 + 20% (ok)

        // Comprobar compras pendientes
        System.out.println("Compras pendientes:");
        for (Item item : yo.comprasPendientes()) {
            System.out.println(item.getNombre() + " -> " + item.getPrecio());
        }

        // Ver si voy ganando
        System.out.println("¿Voy ganando? " + yo.voyGanando());

        // Destruir un objeto mío y comprobar de nuevo
        yo.destruir("Móvil", 250);
        System.out.println("¿Voy ganando tras perder el móvil? " + yo.voyGanando());

        // Eliminar un objeto de mis vecinos y comprobar de nuevo
        yo.fisgarDestruccion("Coche", 80);
        System.out.println("¿Voy ganando tras perder el coche vecino? " + yo.voyGanando());
    }
}
