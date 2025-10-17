import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProgramaGeneraciones {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        // Año actual
        LocalDateTime fecha = LocalDateTime.now();
        int anyo_actual = fecha.getYear();

        // Variable para el año mínimo
        final int ANYO_MINIMO = 1900;

        // Variables
        int edad = 0;
        int anyo_nacimiento = 0;

        // Mostrar opciones
            System.out.println("Elige un modo:");
            System.out.println("[1] - Año de nacimiento");
            System.out.println("[2] - Edad");
            System.out.println("--------------------------");

        //comprobar valores
            int modo = 0;
            if (teclado.hasNextInt()) {
                modo = teclado.nextInt();
            }else{
                System.out.println("Introduce un valor válido.");
                return;
            }

            //modo 2: Introducir edad y calcular año de nacimiento
            if (modo == 2) {
                System.out.print("Introduce tu edad: ");

                if (teclado.hasNextInt()) {
                edad = teclado.nextInt();
                if (edad < 0) {
                System.out.println("La edad no puede ser negativa.");
                    return;
                }

anyo_nacimiento = anyo_actual - edad;
                System.out.println("Tu año de nacimiento es: " + anyo_nacimiento);

            // Comprobar generación según el año
                    if (anyo_nacimiento < 1928)
                        System.out.println("Generación no bautizada");
                    else if (anyo_nacimiento <= 1944)
                        System.out.println("Generación Silent");
                    else if (anyo_nacimiento <= 1964)
                       System.out.println("Baby Boomers");
                    else if (anyo_nacimiento <= 1981)
                       System.out.println("Generación X");
                    else if (anyo_nacimiento <= 1994)
                      System.out.println("Generación Millennials, la mejor");
                   else
                        System.out.println("Generación Z o Centennials");

                } else {
                    System.out.println("Error: debes introducir un número entero.");
                    return;
                }

                }else if (modo == 1) {
                    System.out.println("Modo 1 aún no implementado en este ejemplo.");
                } else {
                     System.out.println("Opción no válida. Elige 1 o 2.");
        }
    }
}
