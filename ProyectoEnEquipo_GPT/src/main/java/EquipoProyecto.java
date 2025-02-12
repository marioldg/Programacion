import java.util.ArrayList;

public class EquipoProyecto {
    private ArrayList<Miembro> miembros = new ArrayList<>();
    private ArrayList<Tarea> pendientes = new ArrayList<>();

    // Constructor
    public EquipoProyecto() {}

    // Método para agregar un miembro al equipo
    public void agregarMiembro(String nombre, ArrayList<String> habilidades, int nivel) {
        // Verificar si el miembro ya existe por nombre
        for (Miembro m : miembros) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Error: El miembro " + nombre + " ya existe.");
                return;
            }
        }
        // Crear y añadir el nuevo miembro
        Miembro nuevoMiembro = new Miembro(nombre, habilidades, nivel);
        miembros.add(nuevoMiembro);
        System.out.println("Miembro " + nombre + " agregado correctamente.");
    }

    // Método para eliminar un miembro por nombre
    public boolean eliminarMiembro(String nombre) {
        return miembros.removeIf(m -> m.getNombre().equalsIgnoreCase(nombre));
    }

    // Método para asignar una tarea al equipo (evita duplicados por ID)
    public boolean asignarTarea(Tarea tarea) {
        for (Tarea t : pendientes) {
            if (t.getId().equals(tarea.getId())) {
                System.out.println("Error: La tarea " + tarea.getId() + " ya está asignada.");
                return false;
            }
        }
        pendientes.add(tarea);
        System.out.println("Tarea " + tarea.getId() + " asignada correctamente.");
        return true;
    }

    // Método para completar una tarea por ID
    public boolean completarTarea(String idTarea) {
        ArrayList<Tarea> nuevasPendientes = new ArrayList<>();
        boolean completada = false;

        for (Tarea tarea : pendientes) {
            if (tarea.getId().equals(idTarea) && !completada) {
                for (Miembro m : miembros) {
                    boolean tieneHabilidad = false;
                    for (String i : m.getHabilidades()) {
                        if (tarea.getHabilidadesRequeridas().contains(i)) {
                            tieneHabilidad = true;
                            break;
                        }
                    }
                    if (tieneHabilidad && m.getNivel() >= tarea.getComplejidad() / 2) {
                        completada = true;
                        break;
                    }
                }
                if (!tarea.getId().equals(idTarea) || !completada) {
                    nuevasPendientes.add(tarea);
                }

            }


        }
        pendientes = nuevasPendientes;
        return completada;
    }


        // Método para verificar si todas las tareas pueden ser completadas
        public boolean puedeCompletarTodas () {
            for (Tarea t : pendientes) {
                boolean puede = false;
                for (Miembro m : miembros) {
                    boolean tieneHabilidad = false;
                    for (String habilidad : m.getHabilidades()) {
                        if (t.getHabilidadesRequeridas().contains(habilidad)) {
                            tieneHabilidad = true;
                            break;
                        }
                    }
                    if (tieneHabilidad && m.getNivel() >= t.getComplejidad() / 2) {
                        puede = true;
                        break;
                    }
                }
                if (!puede) return false;
            }
            return true;
        }


    // Método para obtener tareas críticas (sin miembros capaces)
    public ArrayList<Tarea> tareasCriticas() {
        ArrayList<Tarea> criticas = new ArrayList<>();
        for (Tarea t : pendientes) {
            boolean puede = false;
            for (Miembro m : miembros) {
                boolean tieneHabilidad = false;
                for (String habilidad : m.getHabilidades()) {
                    if (t.getHabilidadesRequeridas().contains(habilidad)) {
                        tieneHabilidad = true;
                        break;
                    }
                }
                if (tieneHabilidad && m.getNivel() >= t.getComplejidad() / 2) {
                    puede = true;
                    break;
                }
            }
            if (!puede) criticas.add(t);
        }
        return criticas;
    }

    @Override
    public String toString() {
        return "EquipoProyecto{\n" +
                "  miembros=" + miembros + ",\n" +
                "  pendientes=" + pendientes + "\n" +
                '}';
    }
}