import java.util.ArrayList;

public class Vecino {
    private ArrayList<Item> itemsVecino;
    private ArrayList<Item> misItems;

    public Vecino() {
        this.itemsVecino = new ArrayList<>();
        this.misItems = new ArrayList<>();
    }

    public boolean fisgarCompra(String nombreItem, int precioItem) {
        return itemsVecino.add(new Item(nombreItem, precioItem));
    }

    public boolean fisgarDestruccion(String nombreItem, int precioItem) {
        for (int i = 0; i < itemsVecino.size(); i++) {
            if (itemsVecino.get(i).getNombre().equalsIgnoreCase(nombreItem) &&
                    itemsVecino.get(i).getPrecio() == precioItem) {
                itemsVecino.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean comprar(String nombreItem, int precioItem) {
        return misItems.add(new Item(nombreItem, precioItem));
    }

    public boolean destruir(String nombreItem, int precioItem) {
        for (int i = 0; i < misItems.size(); i++) {
            if (misItems.get(i).getNombre().equalsIgnoreCase(nombreItem) &&
                    misItems.get(i).getPrecio() == precioItem) {
                misItems.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean voyGanando() {
        for (Item itemVecino : itemsVecino) {
            boolean encontrado = false;
            int precioRequerido = (int) (itemVecino.getPrecio() * 1.2);

            for (Item miItem : misItems) {
                if (miItem.getNombre().equalsIgnoreCase(itemVecino.getNombre()) &&
                        miItem.getPrecio() >= precioRequerido) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }


    public Item[] comprasPendientes() {
        ArrayList<Item> comprasReturn = new ArrayList<>();
        ArrayList<Item> itemsMaximos = new ArrayList<>();

        for (Item item : itemsVecino) {
            boolean encontrado = false;
            for (int j = 0; j < itemsMaximos.size(); j++) {
                if (itemsMaximos.get(j).getNombre().equalsIgnoreCase(item.getNombre())) {
                    if (itemsMaximos.get(j).getPrecio() < item.getPrecio()) {
                        itemsMaximos.set(j, item);
                    }
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                itemsMaximos.add(item);
            }
        }

        for (Item itemVecino : itemsMaximos) {
            int precioRequerido = (int) (itemVecino.getPrecio() * 1.2);
            boolean encontrado = false;

            for (Item miItem : misItems) {
                if (miItem.getNombre().equalsIgnoreCase(itemVecino.getNombre()) &&
                        miItem.getPrecio() >= precioRequerido) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                comprasReturn.add(new Item(itemVecino.getNombre(), precioRequerido));
            }
        }

        return comprasReturn.toArray(new Item[0]);
    }




}


