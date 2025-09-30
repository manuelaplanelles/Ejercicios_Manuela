package org.example;

public class Ejercicio5 {
    static void main() {
        try{
            int resultado = (0/0);
            }catch (Exception err){
            System.out.println("No dividas entre 0 !!!, no se puede");

        }
        try{
            int numero = teclado.nextInt();
        }catch (Exception err){
            System.out.println("ERROR: hay números introducidos que son iguales");
        }

    }
}
