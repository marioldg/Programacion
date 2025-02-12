public class Termostato {
    private int tempReal;
    private int tempD;
    private boolean encendida;
    private int modo;

    public Termostato(int temperatura) {
        this.modo = 2; // Modo automático
        this.tempReal = temperatura;

        if (temperatura >= 5 && temperatura <= 26) {
            this.tempD = temperatura;
        } else if (temperatura > 26) {
            this.tempD = 26;
        } else {
            this.tempD = 5;
        }

        // Actualizar el estado de la caldera
        actualizarEstadoCaldera();
    }

    public boolean getEstadoCaldera() {
        return encendida;
    }

    public void setModo(int modo) {
        this.modo = modo;
        actualizarEstadoCaldera();
    }

    public void setTemperaturaReal(int temperatura) {
        this.tempReal = temperatura;
        actualizarEstadoCaldera();
    }

    public void setTemperaturaDeseada(int temperatura) {
        if (temperatura < 5) {
            this.tempD = 5;
        } else if (temperatura > 26) {
            this.tempD = 26;
        } else {
            this.tempD = temperatura;
        }
        actualizarEstadoCaldera();
    }

    private void actualizarEstadoCaldera() {
        if (modo == 0) { // Manual-apagado
            encendida = false;
        } else if (modo == 1) { // Manual-encendido
            encendida = true;
        } else { // Automático
            if (tempD > tempReal) {
                encendida = true;
            } else if (tempD < tempReal) {
                encendida = false;
            }

        }
    }


    public int getTempReal() {
        return tempReal;
    }

    public int getTempDeseada() {
        return tempD;
    }

    public int getModo() {
        return modo;
    }
}