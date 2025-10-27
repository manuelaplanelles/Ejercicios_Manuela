import java.util.Random;
import java.util.Scanner;

public class ejerciciorandom3 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int nummax, nummin;

        Random aleaatorio = new Random();

        System.out.println("Indica un rango mínimo: ");
        nummax = teclado.nextInt();

        System.out.println("Indica rango máximo: ");
        nummin = teclado.nextInt();

        System.out.println("¿Cuantas nº aleatorios quieres?:");
        int aleatorio = teclado.nextInt();
        for (int ){
            if (nummin>nummax) {
                int aleatorio = aleatorio.nextInt(nummax-nummin+1)+nummin;
            }else{
                System.out.println("Los numeros introducidor no son correctos");
            }
        }
    }
}
