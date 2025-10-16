import java.util.Scanner;
import java.util.InputMismatchException;
public class Multiplicacion3Cifras {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int num1 = 0, num2 = 0;

        //validar num1
        boolean repetir = true;
        while (repetir) {
            try {
                System.out.print("Introduce el multiplicando (3 cifras): ");
                num1 = teclado.nextInt();

                if (num1 < 0) {
                    System.out.println("No se permiten números negativos.");
                } else if (num1 < 100 || num1 > 999) {
                    System.out.println("Debe tener exactamente 3 cifras (entre 100 y 999).");
                } else {
                    repetir = false; // ya es correcto → salimos del bucle
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero.");
                teclado.next(); // limpia el valor no válido
            }
        }

        //validar num2
        repetir = true;
        while (repetir) {
            try {
                System.out.print("Introduce el multiplicador (3 cifras): ");
                num2 = teclado.nextInt();

                if (num2 < 0) {
                    System.out.println("No se permiten números negativos.");
                } else if (num2 < 100 || num2 > 999) {
                    System.out.println("Debe tener exactamente 3 cifras (entre 100 y 999).");
                } else {
                    repetir = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero.");
                teclado.next();
            }
        }


        //Descomponer cifras
        String num_sring = Integer.toString(num2); //multiplicador

        String num_izquierda = num_sring.substring(0, 1);
        int izquierda = Integer.parseInt(num_izquierda);
        System.out.println(izquierda * num1);

        String num_centro  = num_sring.substring(1, 2);
        int centro = Integer.parseInt(num_centro);
        System.out.println(centro * num1);

        String num_derecha = num_sring.substring(2, 3);
        int derecha = Integer.parseInt(num_derecha);
        System.out.println(derecha * num1);

        //calcular y mostrar
        System.out.println();
        System.out.println("      " + num1);
        System.out.println("x     " + num2);
        System.out.println("___________");

        System.out.println( ("     " + num1 * derecha) );
        System.out.println( ("     " + num1 * centro) );
        System.out.println( ("     " + num1 * izquierda) );
        System.out.println("___________");

        System.out.println("   " + (num1 * num2));

    }
}
