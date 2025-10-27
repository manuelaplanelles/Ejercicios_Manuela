import java.util.Random;
import java.util.Scanner;

public class ejerciciorandom3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generador = new Random();  // Nombre diferente

        // Pedir el mínimo
        System.out.print("Indica un rango minimo: ");
        int nummin = teclado.nextInt();

        // Pedir el máximo
        System.out.print("Indica rango maximo: ");
        int nummax = teclado.nextInt();

        // Validar que el máximo sea mayor que el mínimo
        if (nummin > nummax) {
            System.out.println("ERROR: El minimo no puede ser mayor que el maximo");
            return;  // Salir del programa
        }

        // Pedir cuántos números quiere
        System.out.print("¿Cuantos numeros aleatorios quieres?: ");
        int cantidad = teclado.nextInt();

        // Validar que sea positivo
        if (cantidad <= 0) {
            System.out.println("ERROR: Debe ser un numero positivo");
            return;
        }

        // Generar y mostrar los números
        System.out.println("Numeros generados:");
        System.out.println("-------------------");

        for (int i = 0; i < cantidad; i = i + 1) {
            int numeroAleatorio = generador.nextInt(nummax - nummin + 1) + nummin;
            System.out.println("Numero " + (i + 1) + ": " + numeroAleatorio);
        }

        teclado.close();
    }
}
