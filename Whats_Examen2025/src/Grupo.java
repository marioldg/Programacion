import java.util.ArrayList;

public class Grupo {
    ArrayList<Persona> listaPersonas = new ArrayList<>();


    public Grupo(Persona administrador) {
        administrador.setAdmin(true);
        listaPersonas.add(administrador);
    }

    public void addPersona(Persona p) {
        boolean noExiste = true;
        for (Persona i : listaPersonas) {
            if (i.getNumero().equals(p.getNumero())) {
                noExiste = false;
            }
        }
        if (noExiste && p.isAdmin()) {
            p.setAdmin(false);
            listaPersonas.add(p);

        } else if (noExiste && !(p.isAdmin())) {
            {
                listaPersonas.add(p);
            }

        } else {
            System.out.println("No se ha podido añadir a dicha persona");
        }
    }


    public void deletePersona(String telefono) {
        Persona personaABorrar = null;

        for (Persona x : listaPersonas) {
            if (x.getNumero().equals(telefono)) {
                personaABorrar = x;
            }
        }

        if (personaABorrar != null) {
            if (personaABorrar.isAdmin() && AdminsHay() == 1) {
                System.out.println("No se puede eliminar, es el único administrador.");
            } else {
                listaPersonas.remove(personaABorrar);
                System.out.println("Persona eliminada.");
            }
        } else {
            System.out.println("Persona no encontrada en el grupo.");
        }
    }


    public void setEstado(String telefono, boolean administrador) {
        for (Persona x : listaPersonas) {
            if (x.getNumero().equals(telefono) && x.isAdmin() && AdminsHay() >= 2) {
                x.setAdmin(false);
                System.out.println("Administrador cambiado a user");
                return;
            } else if (x.getNumero().equals(telefono) && !(x.isAdmin())) {
                x.setAdmin(true);
                System.out.println("User cambiado a administrador");
                return;
            }
        }
        System.out.println("No es posible setear el estado");
    }

    public int pertenece(String telefono) {
        for (Persona x : listaPersonas) {
            if (x.getNumero().equals(telefono) && x.isAdmin()) {
                System.out.println("La persona es admin");
                return 2;
            } else if (x.getNumero().equals(telefono) && !(x.isAdmin())) {
                System.out.println("La persona es user");
                return 1;
            }
        }
        System.out.println("La persona no ha sido encontrada");
        return 0;
    }

    public Persona[] miembros() {
        Persona[] personas = listaPersonas.toArray(new Persona[0]);
        return personas;
    }

    public Persona[] administradores() {
        ArrayList<Persona> adminsArrayList = new ArrayList<>();
        for (Persona x : listaPersonas) {
            if (x.isAdmin()) {
                adminsArrayList.add(x);
            }
        }
        return adminsArrayList.toArray(new Persona[0]);

    }

    public int AdminsHay() {
        int nAdmin = 0;
        for (Persona i : listaPersonas) {
            if (i.isAdmin()) {
                nAdmin++;
            }
        }
        return nAdmin;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "listaPersonas=" + listaPersonas +
                '}';
    }


}
