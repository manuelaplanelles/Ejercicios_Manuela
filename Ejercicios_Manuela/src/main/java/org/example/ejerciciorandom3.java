import java.util.Random;
import java.util.Scanner;

public class ejerciciorandom3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();


        System.out.println("Introduce el rango minimo");
        int nummin = teclado.nextInt();
        System.out.println("Introduce el rango maximo");
        int nummax = teclado.nextInt();
        System.out.println("¿Cuantos nº aleatorios quieres?");
        int numerosaleatorios = teclado.nextInt();

        if (nummax > nummin) {
            for (int i = 0; i < numerosaleatorios; i++) {
                int numero = aleatorio.nextInt(nummax - nummin + 1) + nummin;
                System.out.println("Tu numero aleatorio es: " + numero);
            }
        } else {
            System.out.println("ERROR: El maximo debe ser mayor que el minimo");
        }
    }
}
