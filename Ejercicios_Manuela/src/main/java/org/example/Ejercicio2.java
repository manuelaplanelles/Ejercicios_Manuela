package org.example;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int JORNADA_SIN_EXTRA = 40;
        double PLUS_TARIFA_EXTRA = (double)1.5F;
        System.out.println("Introduce numero de horas:");
        int HORAS = teclado.nextInt();
        System.out.println("Introduce la tarifa por horas:");
        double TARIFA = teclado.nextDouble();
        if (HORAS > 40) {
            double HORAS_EXTRAS = (double)(HORAS - 40);
            double TARIFA_EXTRA = TARIFA * (double)1.5F;
            double SALARIO_EXTRA = HORAS_EXTRAS * TARIFA_EXTRA;
            System.out.println("El resultado es:" + (SALARIO_EXTRA + (double)40.0F * TARIFA) + "€");
        } else {
            double SALARIO = (double)HORAS * TARIFA;
            System.out.println("El resultado es:" + SALARIO + "€");
        }

    }
}
