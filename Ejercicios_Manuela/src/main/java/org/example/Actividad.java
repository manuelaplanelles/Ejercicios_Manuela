package org.example;
import java.util.Scanner;

public class Actividad {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("¿Cómo te llamas?: ");
        String nombre = teclado.nextLine();

        System.out.println("¿A que curso vas?: ");
        String curso = teclado.nextLine();

        System.out.println("Introduce un numero:");
        int num1 = teclado.nextByte();

        System.out.println("Introduce otro numero:");
        int num2 = teclado.nextByte();

        System.out.println("El resultado es:" + (num1 + num2));
    }
}
