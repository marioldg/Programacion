public class Item {
    private String nombre;
    private int cantidad;
    private double precio;

    public Item(String nombre, int cantidad, double precio) {
        if(nombre==null){
            nombre=" ";
        }else{
            this.nombre = nombre;
        }

        if (cantidad <= 0) {
            cantidad = 1;
        } else {
            this.cantidad = cantidad;
        }

        if (precio < 0) {
            precio = 0;
        }else{
            this.precio=precio;
        }

    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPrecioTotal(){
        return precio * cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
