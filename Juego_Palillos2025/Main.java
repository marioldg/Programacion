package juego_pailillos;

public class Main {

    public static void main(String[] args) {
        Nim a=new Nim();

        System.out.println(a.turno());
        System.out.println(a.cuantosQuedan());
        a.coger(2);
        System.out.println(a.turno());
        System.out.println(a.cuantosQuedan());
        a.coger(3);
        System.out.println(a.turno());
        System.out.println(a.cuantosQuedan());
        a.coger(2);
        System.out.println(a.turno());
        System.out.println(a.cuantosQuedan());
        a.coger(1);
        System.out.println(a.turno());
        System.out.println(a.cuantosQuedan());

    }



}
