package EJ3;

import java.util.Scanner;

public class MediaAlumnos {
    public MediaAlumnos() {
    }

    public void mediaActividades() {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cuántos alumnos hay? ");
        int cuantos = sc.nextInt();
        for (int i = 0; i < cuantos; i++) {
            System.out.println("Alumno " + (i + 1));
            double act = 0;
            System.out.print("Ingrese nota actividad 1: ");
            act += sc.nextDouble();
            System.out.print("Ingrese nota actividad 2: ");
            act += sc.nextDouble();
            System.out.print("Ingrese nota actividad 3: ");
            act += sc.nextDouble();
            System.out.print("Ingrese nota actividad 4: ");
            act += sc.nextDouble();
            double promedioAct = act / 4.0;
            System.out.print("Ingrese nota examen: ");
            double exam = sc.nextDouble();
            System.out.print("Ingrese nota actitud: ");
            double actitud = sc.nextDouble();
            double notaFinal = promedioAct * 0.60 + exam * 0.30 + actitud * 0.10;
            System.out.println("La nota final es: " + notaFinal);
        }
        sc.close();
    }
}
