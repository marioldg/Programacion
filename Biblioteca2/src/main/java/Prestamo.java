public class Prestamo {
    private String nombreCliente;
    private int fechaInicio;
    private int fechaFin;
    private boolean finalizado;

    public Prestamo(String nombreCliente, int fechaInicio, int fechaFin, boolean finalizado) {
        this.nombreCliente = nombreCliente;

        if(fechaInicio<31121975){
            this.fechaInicio=31121975;
        }else if(fechaInicio>30122025){
            this.fechaInicio = 30122025;

        }else{
            this.fechaInicio=fechaInicio;
        }

        if(!finalizado){
            this.fechaFin=0;
        }else if (fechaFin<31121975){
            this.fechaFin=31121975;
        }else if(fechaFin>31122025){
            this.fechaFin=31122025;
        }

        else{
            this.fechaFin=fechaFin;
        }
        this.finalizado = finalizado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", finalizado=" + finalizado +
                '}';
    }
}
