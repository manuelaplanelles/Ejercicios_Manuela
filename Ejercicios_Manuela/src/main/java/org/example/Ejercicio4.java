package org.example;

import java.util.Scanner;

public class Ejercicio4 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        int numero1 = teclado.nextInt();

        System.out.println("Introduce otro numero: ");
        int numero2 = teclado.nextInt();

        System.out.println("Introduce otro número: ");
        int numero3 = teclado.nextInt();


        if (numero1==numero2 && numero2==numero3 && numero1==numero3){
            System.out.println("ERROR: hay números introducidos que son iguales");
        }

        if (numero1>=numero2)



    }
}
