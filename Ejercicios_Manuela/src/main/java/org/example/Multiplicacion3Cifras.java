import java.util.Scanner;

public class Multiplicacion3Cifras {
    public static void main(String[] args) {

        //lector del teclado
        Scanner teclado = new Scanner(System.in);

        int num1, num2;

        //validar num1
        do {
            System.out.print("Introduce el multiplicando (3 cifras): ");
            num1 = teclado.nextInt();

            if (num1 < 0) {
                System.out.println("No se permiten números negativos.");
            } else if (num1 < 100 || num1 > 999) {
                System.out.println("Debe tener exactamente 3 cifras (entre 100 y 999).");
            }
        } while (num1 < 100 || num1 > 999);

        //validar num2
        do {                                                        //repite el numero hasta que cumpla las condiciones
            System.out.print("Introduce el multiplicador (3 cifras): ");
            num2 = teclado.nextInt();

            if (num2 < 0) {                                         //condicion numero positivo
                System.out.println("No se permiten números negativos.");
            } else if (num2 < 100 || num2 > 999) {                  //condicion 3cifras
                System.out.println("Debe tener exactamente 3 cifras (entre 100 y 999).");
            }
        } while (num2 < 100 || num2 > 999);


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

        System.out.println(num1 * num2);

    }
}
