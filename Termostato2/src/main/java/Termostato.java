public class Termostato {
    // Atributos:
    // modo: 0 = manual-apagado, 1 = manual-encendido, cualquier otro valor = automático.
    private int modo;
    private int temperaturaDeseada;
    private int temperaturaReal;
    private boolean caldera;

    /**
     * Constructor.
     * - Se inicia en modo automático (se utiliza el valor 2, por ejemplo).
     * - La temperatura real se asigna según el parámetro recibido.
     * - La temperatura deseada se ajusta para estar entre 5 y 26 grados:
     *     * Si la temperatura está entre 5 y 26, se iguala a la real.
     *     * Si es menor de 5, se fija a 5.
     *     * Si es mayor de 26, se fija a 26.
     * - Finalmente, se actualiza el estado de la caldera:
     *     * En modo automático, se enciende si la temperatura real es menor que la deseada,
     *       se apaga si es mayor; y si son iguales, conserva el estado (por defecto, se deja como está).
     *     * En modo manual, se forza según 0 o 1.
     */
    public Termostato(int temperatura) {
        this.modo = 2; // Modo automático.
        this.temperaturaReal = temperatura;

        // Establecer la temperatura deseada según el rango permitido.
        if (temperatura < 5) {
            this.temperaturaDeseada = 5;
        } else if (temperatura > 26) {
            this.temperaturaDeseada = 26;
        } else {
            this.temperaturaDeseada = temperatura;
        }

        // Actualizar el estado de la caldera según las reglas establecidas.
        actualizarEstadoCaldera();
    }

    /**
     * Método privado que actualiza el estado de la caldera según:
     * - Si el modo es manual-apagado (0): caldera apagada.
     * - Si el modo es manual-encendido (1): caldera encendida.
     * - Si el modo es automático:
     *     * Se enciende si la temperatura real es menor que la deseada.
     *     * Se apaga si la temperatura real es mayor que la deseada.
     *     * Si son iguales, conserva el estado actual.
     */
    private void actualizarEstadoCaldera() {
        if (modo == 0) {
            caldera = false;
        } else if (modo == 1) {
            caldera = true;
        } else {
            if (temperaturaReal < temperaturaDeseada) {
                caldera = true;
            } else if (temperaturaReal > temperaturaDeseada) {
                caldera = false;
            }
        }
    }


    public boolean getEstadoCaldera() {
        return caldera;
    }


    public void setModo(int modo) {
        this.modo = modo;
        actualizarEstadoCaldera();
    }


    public void setTemperaturaReal(int temperaturaReal) {
        this.temperaturaReal = temperaturaReal;
        actualizarEstadoCaldera();
    }
    public void setTemperaturaDeseada(int temperaturaDeseada) {
        if (temperaturaDeseada < 5) {
            this.temperaturaDeseada = 5;
        } else if (temperaturaDeseada > 26) {
            this.temperaturaDeseada = 26;
        } else {
            this.temperaturaDeseada = temperaturaDeseada;
        }
        actualizarEstadoCaldera();
    }

    public int getTemperaturaReal() {
        return temperaturaReal;
    }

    public int getModo() {
        return modo;
    }

    public int getTemperaturaDeseada() {
        return temperaturaDeseada;
    }

    @Override
    public String toString() {
        return "Termostato{" +
                "modo=" + modo +
                ", temperaturaDeseada=" + temperaturaDeseada +
                ", temperaturaReal=" + temperaturaReal +
                ", caldera=" + caldera +
                '}';
    }
}
