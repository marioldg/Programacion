import java.util.ArrayList;

public class Carrito {
    private ArrayList<Item> items;
    private ArrayList<Item> itemsMasSolicitados;

    public Carrito() {
        this.items = new ArrayList<>();
        this.itemsMasSolicitados= new ArrayList<>();
    }

    public void vaciar() {
        items.clear();
    }

    public void agregar(String nombre, int cantidad, double precio) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNombre().equals(nombre)) {
                int cantidadNueva = items.get(i).getCantidad() + cantidad;
                items.get(i).setCantidad(cantidadNueva);
                items.get(i).setPrecio(precio);
                return;
            }
        }
        items.add(new Item(nombre, cantidad, precio));
    }

    public boolean quitar(int cantidad, String nombre) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getNombre().equals(nombre)&& items.get(i).getCantidad()>cantidad) {
                int cantidadNueva2 = items.get(i).getCantidad()-cantidad;
                items.get(i).setCantidad(cantidadNueva2);
                return true;
            } else if (items.get(i).getNombre().equals(nombre)&& items.get(i).getCantidad()==cantidad) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public double getPrecioTotalCarrito(){
        double contador=0;
        for (int i = 0; i< items.size();i++){
            contador+=items.get(i).getPrecioTotal();
        }
        return contador;
    }

    public Item getItem(String nombre){
        for(int i= 0;i< items.size();i++){
            if(items.get(i).getNombre().equals(nombre) && items.get(i).getCantidad()>0){
                Item itemR = new Item(items.get(i).getNombre(),items.get(i).getCantidad(),items.get(i).getPrecio());
                return itemR;
            }
        }
        return null;
    }

    public Item getItemMasCaro() {
        if (items.isEmpty()) {
            return null;
        }

        Item itemMasCaro = items.get(0);
        for (Item i : items) {
            if (i.getPrecioTotal() > itemMasCaro.getPrecioTotal()) {
                itemMasCaro = i;
            }
        }


        return itemMasCaro;
    }



    public Item[] getItemMasSolicitados() {

        if (items.isEmpty()) {
            return new Item[0];
        }


        Item itemMasCantidad = items.get(0);
        itemsMasSolicitados.add(itemMasCantidad);


        for (Item i : items) {
            if (i.getCantidad() > itemMasCantidad.getCantidad()) {
                itemsMasSolicitados.clear();
                itemsMasSolicitados.add(i);
                itemMasCantidad = i;
            } else if (i.getCantidad() == itemMasCantidad.getCantidad() && !itemsMasSolicitados.contains(i)) {
                itemsMasSolicitados.add(i);
            }
        }

        return itemsMasSolicitados.toArray(new Item[0]);
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "El carrito está vacío.";
        }

        StringBuilder sb = new StringBuilder("Contenido del carrito:\n");
        for (Item item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

}