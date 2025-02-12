public class Main {
    public static void main(String[] args) {
        // Crear un termostato con temperatura inicial de 10 grados
        Termostato termostato = new Termostato(2);
        System.out.println("=== Termostato creado con temperatura inicial 10 ===");
        System.out.println("Temperatura real: " + termostato.getTempReal());
        System.out.println("Temperatura deseada: " + termostato.getTempDeseada());
        System.out.println("Modo: " + termostato.getModo() + " (0: manual-apagado, 1: manual-encendido, 2: automático)");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar a modo manual-encendido
        termostato.setModo(1);
        System.out.println("=== Modo cambiado a manual-encendido ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar a modo manual-apagado
        termostato.setModo(0);
        System.out.println("=== Modo cambiado a manual-apagado ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar a modo automático
        termostato.setModo(2);
        System.out.println("=== Modo cambiado a automático ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar la temperatura real a 15 grados
        termostato.setTemperaturaReal(15);
        System.out.println("=== Temperatura real cambiada a 15 ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar la temperatura deseada a 20 grados
        termostato.setTemperaturaDeseada(20);
        System.out.println("=== Temperatura deseada cambiada a 20 ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();

        // Cambiar la temperatura deseada a 10 grados (menor que la real)
        termostato.setTemperaturaDeseada(10);
        System.out.println("=== Temperatura deseada cambiada a 10 ===");
        System.out.println("Estado caldera: " + (termostato.getEstadoCaldera() ? "Encendida" : "Apagada"));
        System.out.println();
    }
}