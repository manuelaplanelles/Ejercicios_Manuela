import java.util.Scanner;

public class Multiplicacion3Cifras {
    static void main() {

        //preguntamos cifras
        System.out.print("Introduce el multiplicando (3 cifras): ");
        int num1 = sc.nextInt();
        System.out.print("Introduce el multiplicador (3 cifras): ");
        int num2 = sc.nextInt();

        //Descomponer cifras
        String num_sring = Integer.toString(num2);

        String num_izquierda = num_sring.substring(0, 1);
        int num_izquierda = Integer.parseInt(num_izquierda);
        System.out.println(num_izquierda * num1 + "00");

        String num_centro  = num_sring.substring(1, 2);
        int num_centro = Integer.parseInt(num_centro);
        System.out.println(num_centro * num1 + "0");

        String num_derecha = num_sring.substring(2, 3);
        int num_derecha = Integer.parseInt(num_derecha);
        System.out.println(num_derecha * num1);

    }
}
