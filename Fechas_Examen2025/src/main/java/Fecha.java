public class Fecha {
    private int dia;
    private int mes;
    private int ano;

    // Constructor: Si la fecha es válida se asigna; de lo contrario se asigna 1/1/1901.
    public Fecha(int dia, int mes, int ano) {
        if (esFechaValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1901;
        }
    }

    // Getters
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Setter: Solo actualiza si la nueva fecha es válida.
    public void set(int dia, int mes, int ano) {
        if (esFechaValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
    }

    // Avanza al día siguiente.
    public void avanzarDia() {
        int diasMes = getDiasDelMes(mes, ano);
        if (dia < diasMes) {
            dia++;
        } else {
            // Fin de mes
            if (mes < 12) {
                mes++;
                dia = 1;
            } else {
                // Fin de año: sólo avanza si no es 31/12/2099
                if (ano < 2099) {
                    ano++;
                    mes = 1;
                    dia = 1;
                }
                // Si ya es 31/12/2099 no se hace nada.
            }
        }
    }

    // Retrocede al día anterior.
    public void retrocederDia() {
        if (dia > 1) {
            dia--;
        } else {
            // dia == 1
            if (mes == 1) {
                // Si es 1 de enero y no es 1901, retrocede al 31 de diciembre del año anterior.
                if (ano > 1901) {
                    ano--;
                    mes = 12;
                    dia = 31;
                }
                // Si ya es 1/1/1901 no se hace nada.
            } else {
                mes--;
                dia = getDiasDelMes(mes, ano);
            }
        }
    }

    // Avanza al mismo día del mes siguiente.
    // Si ese día no existe, se avanza al 1 del mes siguiente (salta el mes donde no existe el día).
    // Si la fecha está en diciembre de 2099, se fija al último día permitido.
    public void avanzarMes() {
        if (ano == 2099 && mes == 12) {
            // Último mes permitido: se fija el día al 31.
            dia = 31;
            return;
        }

        int newMes = mes + 1;
        int newAno = ano;
        if (newMes > 12) {
            newMes = 1;
            newAno++;
        }

        if (esFechaValida(dia, newMes, newAno)) {
            // El mismo día existe en el mes siguiente.
            mes = newMes;
            ano = newAno;
        } else {
            // Si no existe, se salta ese mes y se pone el día 1 del mes siguiente.
            newMes++;
            if (newMes > 12) {
                newMes = 1;
                newAno++;
            }
            if (newAno > 2099) {
                // Si se excede el límite, no se hace nada.
                return;
            }
            dia = 1;
            mes = newMes;
            ano = newAno;
        }
    }

    // Retrocede al mismo día del mes anterior.
    // Si ese día no existe, se fija al último día del mes anterior.
    public void retrocederMes() {
        if (ano == 1901 && mes == 1) {
            // Primer mes permitido.
            return;
        }

        int newMes = mes - 1;
        int newAno = ano;
        if (newMes < 1) {
            newMes = 12;
            newAno--;
        }

        if (esFechaValida(dia, newMes, newAno)) {
            mes = newMes;
            ano = newAno;
        } else {
            // Si el mismo día no existe, se pone el último día del mes anterior.
            dia = getDiasDelMes(newMes, newAno);
            mes = newMes;
            ano = newAno;
        }
    }

    // Compara la fecha actual con la fecha pasada como parámetro.
    // Devuelve -1 si this es anterior, 1 si es posterior y 0 si son iguales o si la fecha pasada es null.
    public int comparar(Fecha fecha) {
        if (fecha == null) {
            return 0;
        }
        if (this.ano < fecha.ano) return -1;
        if (this.ano > fecha.ano) return 1;
        // Mismo año
        if (this.mes < fecha.mes) return -1;
        if (this.mes > fecha.mes) return 1;
        // Mismo mes
        if (this.dia < fecha.dia) return -1;
        if (this.dia > fecha.dia) return 1;
        return 0;
    }

    // Ordena cronológicamente el array de fechas recibido.
    // Si el array es null, no se hace nada.
    public static void ordenar(Fecha[] fechas) {
        if (fechas == null) {
            return;
        }
        int n = fechas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (fechas[j].comparar(fechas[j + 1]) > 0) {
                    Fecha temp = fechas[j];
                    fechas[j] = fechas[j + 1];
                    fechas[j + 1] = temp;
                }
            }
        }
    }

    // Método privado que devuelve true si el año es bisiesto (múltiplo de 4 en el rango indicado).
    private boolean esBisiesto(int ano) {
        return (ano % 4 == 0);
    }

    // Devuelve el número de días que tiene el mes 'mes' del año 'ano'.
    private int getDiasDelMes(int mes, int ano) {
        switch (mes) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(ano) ? 29 : 28;
            default:
                return 0; // Nunca debería ocurrir si se valida correctamente.
        }
    }

    // Valida que la fecha (día, mes, año) esté dentro de los rangos permitidos y sea correcta.
    private boolean esFechaValida(int dia, int mes, int ano) {
        if (ano < 1901 || ano > 2099) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        int diasMes = getDiasDelMes(mes, ano);
        if (dia < 1 || dia > diasMes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
