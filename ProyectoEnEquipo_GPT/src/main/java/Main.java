import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear habilidades para tareas
        ArrayList<String> habilidadesT1 = new ArrayList<>();
        habilidadesT1.add("programacion");

        ArrayList<String> habilidadesT2 = new ArrayList<>();
        habilidadesT2.add("diseño");
        habilidadesT2.add("uxui");

        // Crear tareas
        Tarea tarea1 = new Tarea("T1", 8, habilidadesT1); // Complejidad 8 (nivel mínimo requerido: 4)
        Tarea tarea2 = new Tarea("T2", 10, habilidadesT2); // Complejidad 10 (nivel mínimo requerido: 5)

        // Crear equipo
        EquipoProyecto equipo = new EquipoProyecto();

        // Agregar miembros al equipo
        ArrayList<String> habilidadesAna = new ArrayList<>();
        habilidadesAna.add("diseño");
        equipo.agregarMiembro("Ana", habilidadesAna, 6); // Puede hacer T2

        ArrayList<String> habilidadesLuis = new ArrayList<>();
        habilidadesLuis.add("programacion");
        equipo.agregarMiembro("Luis", habilidadesLuis, 3); // Nivel insuficiente para T1 (necesita 4)

        ArrayList<String> habilidadesMarta = new ArrayList<>();
        habilidadesMarta.add("uxui");
        equipo.agregarMiembro("Marta", habilidadesMarta, 7); // Habilidad parcial para T2

        // Asignar tareas
        equipo.asignarTarea(tarea1);
        equipo.asignarTarea(tarea2);
        equipo.asignarTarea(tarea1); // Intento duplicado (debe fallar)

        System.out.println("=== Estado inicial del equipo ===");
        System.out.println(equipo);

        // Completar tareas
        System.out.println("\n=== Intentando completar T1 ===");
        boolean exitoT1 = equipo.completarTarea("T1");
        System.out.println("T1 completada: " + exitoT1); // Debe ser false (Luis tiene nivel 3 < 4)

        System.out.println("\n=== Intentando completar T2 ===");
        boolean exitoT2 = equipo.completarTarea("T2");
        System.out.println("T2 completada: " + exitoT2); // Debe ser true (Ana cumple)

        System.out.println("\n=== Estado final del equipo ===");
        System.out.println(equipo);

        // Verificar capacidades
        System.out.println("\n=== Análisis final ===");
        System.out.println("¿Puede completar todas las tareas?: " + equipo.puedeCompletarTodas());
        System.out.println("Tareas críticas: " + equipo.tareasCriticas());
    }
}