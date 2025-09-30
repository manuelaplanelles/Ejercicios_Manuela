package org.example;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce numero de horas:");
        int HORAS = teclado.nextInt();
        System.out.println("Introduce la tarifa por horas:");
        double TARIFA = teclado.nextDouble();
        double SALARIO = (double)HORAS + TARIFA;
        System.out.println("El resultado es:" + SALARIO + "€");
    }
}
