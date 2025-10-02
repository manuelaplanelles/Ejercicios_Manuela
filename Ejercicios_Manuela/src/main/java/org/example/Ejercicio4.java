package org.example;

import java.util.Scanner;

public class Ejercicio4 {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        int res;
        System.out.println("Introduce un numero: ");
        int num1 = teclado.nextInt();

        System.out.println("Introduce otro numero: ");
        int num2 = teclado.nextInt();

        System.out.println("Introduce otro número: ");
        int num3 = teclado.nextInt();


        if (num1==num2 || num2==num3 || num1==num3){
            System.out.println("ERROR: hay números introducidos que son iguales");
        }else{
            if (num1<num2 && num1<num3){
                res=num1;
            }else{
                if (num2<num3){
                    res = num2;
                }else{
                    res = num3;
                }
            }
            System.out.println("El número menor es: " + res);
        }

    }
}
