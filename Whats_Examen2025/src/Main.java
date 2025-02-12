public class Main {
    public static void main(String[] args) {
        Persona p1= new Persona("pepe","1",false);
        Persona p2= new Persona("jose","2",false);
        Persona p3= new Persona("raul","3",false);
        Persona p4 = new Persona("kike","4",false);
        Grupo g1 = new Grupo(p1);
        System.out.println(g1);


        g1.addPersona(p2);
        g1.addPersona(p3);
        g1.addPersona(p4);
        System.out.println(g1);

        g1.deletePersona("4");
        System.out.println(g1);
        g1.setEstado("2",true);


        g1.pertenece("2");

        for(Persona x : g1.administradores()){
            System.out.println(x);
        }


    }
}
