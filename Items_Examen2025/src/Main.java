public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("chaqueta",3,10.50);
        Item item2 = new Item("sudadera",6,11);
        Item item3 = new Item("bufanda",3,6.60);
        Item item4 = new Item("pantalon",2,16.60);
        Item item5 = new Item("gorra",6,12.0);

        Carrito carrito1 = new Carrito();
        System.out.println(carrito1);

        carrito1.agregar(item1.getNombre(), item1.getCantidad(), item1.getPrecio());
        carrito1.agregar(item2.getNombre(), item2.getCantidad(), item2.getPrecio());
        carrito1.agregar(item3.getNombre(), item3.getCantidad(), item3.getPrecio());
        carrito1.agregar(item4.getNombre(), item4.getCantidad(), item4.getPrecio());
        carrito1.agregar(item5.getNombre(), item5.getCantidad(), item5.getPrecio());
        System.out.println(carrito1);

        carrito1.agregar("puffer",1,70.0);
        System.out.println(carrito1);

        System.out.println(carrito1.quitar(10,"calcetos"));
        System.out.println(carrito1.quitar(1,"puffer"));
        System.out.println(carrito1.getPrecioTotalCarrito());
        System.out.println(carrito1.getItem("pantalon"));

        System.out.println(carrito1);
        System.out.println(carrito1.getItemMasCaro());


        Item[] itemsMasSolicitados = carrito1.getItemMasSolicitados();


        System.out.println("ITEMS MAS SOLICITADOS:");
        for(Item item : itemsMasSolicitados){
            System.out.println(item);
        }

    }
}
