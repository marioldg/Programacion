package EJ1;

public class Persona {
    private int edad;
    private String nombre;

    public Persona(int edad, String nombre) {
        if(edad<18){
            this.edad=18;
        }else{
            this.edad = edad;

        }
        this.nombre = nombre;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean jubilada(Persona p){
        boolean ret=false;
        if(p.getEdad()>65){
            ret=true;
        }
        return ret;
    }

    public int cuantoJubilada(Persona p){
        if(p.jubilada(p)){
            return edad-65;

        }else{
            return 0;
        }
    }
}
