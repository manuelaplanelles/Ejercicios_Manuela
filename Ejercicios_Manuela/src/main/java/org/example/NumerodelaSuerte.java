import java.util.Scanner;
import java.util.InputMismatchException;
public class NumerodelaSuerte {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean valido = false;                             //controlamos que el valor sea correcto
        int dia = 0, mes = 0, anyio = 0;                    //variables


        while (valido == false) {                           // Repetimos mientras la fecha no sea válida
                                                            // Pedimos la fecha al usuario en formato dd/mm/aaaa
            System.out.print("Introduce tu fecha de nacimiento (dd/mm/aaaa): ");
            String fecha = teclado.nextLine();

            try {
                                                            // Verificamos si la cadena contiene "/"
                if (fecha.contains("/") == false) {
                    System.out.println("Error: formato incorrecto. Usa dd/mm/aaaa.");
                    continue;
                }
                                                            // Dividimos el texto en 3 partes: día, mes y año
                String[] partes = fecha.split("/");

                                                            // Comprobamos que existan exactamente tres partes
                if (partes.length != 3) {
                    System.out.println("Error: formato incompleto. Usa dd/mm/aaaa.");
                    continue;
                }

                                                            // Convertimos cada parte del texto a número entero
                dia = Integer.parseInt(partes[0]);
                mes = Integer.parseInt(partes[1]);
                anyio = Integer.parseInt(partes[2]);

                                                            // Verificamos que no haya ceros o números negativos
                if (dia <= 0 || mes <= 0 || anyio <= 0) {
                    System.out.println("No se permiten valores negativos ni ceros.");
                    continue;
                }

                                                            // Comprobamos que el día y el mes estén en rangos válidos
                if (dia > 31 || mes > 12) {
                    System.out.println("Día o mes fuera de rango.");
                    continue;
                }

                                                            // Si todas las condiciones son correctas, la fecha es válida
                valido = true;

            } catch (NumberFormatException e) {             // Si el usuario introduce letras u otros símbolos, mostramos error
                System.out.println("Error: introduce solo números en el formato dd/mm/aaaa.");
            }
        }

        // Realizamos el cálculo del número de la suerte


    }
}