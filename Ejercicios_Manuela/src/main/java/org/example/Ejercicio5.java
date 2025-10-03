package org.example;

import java.util.Scanner;

public class Ejercicio5 {
    static void main() {
      Scanner teclado = new Scanner(System.in);
      int dividendo, divisor, res=0;
      System.out.println("Introduce el dividendo:");
      dividendo = teclado.nextInt();
      System.out.println("Introduce el divisor:");
      divisor = teclado.nextInt();
        try{
            res = dividendo/divisor;
            System.out.println("El resultado es:" + res );
        }catch (Exception err){
            System.out.println("No dividas entre 0 !!!, no se puede");
        }
    }
}