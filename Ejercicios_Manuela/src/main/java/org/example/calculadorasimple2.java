import java.util.Scanner;

public class calculadorasimple2 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        //valiables
        double num1 =0, num2 =0;
        char signo;

        //bienvenida
        System.out.println("***** BIENVENIDO A LA CALCULADORA RÁPIDA *****");

        //leer primer número + con control de errores)
        do {
            System.out.println("Introduce el primer número: ");

            if (teclado.hasNextDouble()) {                    // comprobamos si es un número decimal
                num1 = teclado.nextDouble();

                if (num1 > 0) {                              // comprobamos si es positivo
                    break;                                  // Si el número es válido, salimos del bucle
                } else {
                    System.out.println("Valor no válido. El número debe ser positivo.");
                }
            } else {
                System.out.println("Valor no válido. Introduce un número.");
                teclado.next();                            // comprobamos que no es una letra
            }
        } while (true);                                    // Continuar hasta que el número sea válido

        // menú operaciones
        System.out.println("------------------------------");
        System.out.println("[+] --> suma");
        System.out.println("[-] --> resta");
        System.out.println("[x] --> multiplicar");
        System.out.println("[/] --> dividir");
        System.out.println("[R] --> raíz cuadrada");
        System.out.println("------------------------------");

        // leer el signo de la operación
        do {
            System.out.print("Elige una operación: ");
            String input = teclado.nextLine();              // leemos la entrada como String

            if (input.length() == 1) {                      // Verificamos si la entrada es un único carácter y no un número
                signo = input.charAt(0);                    // Obtenemos el primer carácter
                if ("+-x/r".indexOf(signo) != -1) {         // Verificamos si el signo es válido
                    break;                                  // Si la operación es válida, salimos del bucle
                } else {
                    System.out.println("Operación no válida. Solo se permiten los siguientes signos: +, -, x, /, R.");
                }
            } else {
                System.out.println("Operación no válida. Debes ingresar solo un carácter.");
            }

        } while (true); // Continuar hasta que el usuario ingrese un carácter válido




                                                            //leer segundo número + con control de errores)
        do {
            System.out.println("Introduce el segundo número: ");

            if (teclado.hasNextDouble()) {                    // comprobamos si es un número decimal
                num2 = teclado.nextDouble();

                if (num2 > 0) {                              // comprobamos si es positivo
                    break;                                  // Si el número es válido, salimos del bucle
                } else {
                    System.out.println("Valor no válido. El número debe ser positivo.");
                }
            } else {
                System.out.println("Valor no válido. Introduce un número.");
                teclado.next();                            // comprobamos que no es una letra
            }
        } while (true);                                    // Continuar hasta que el número sea válido

        // Calcular el resultado según la operación
        double resultado = 0;
        switch (signo) {
            case '+':
                resultado = num1 + num2;
                System.out.println("Resultado: " + resultado);
                break;

            case '-':
                resultado = num1 - num2;
                System.out.println("Resultado: " + resultado);
                break;

            case 'x':
                resultado = num1 * num2;
                System.out.println("Resultado: " + resultado);
                break;

            case '/':
                resultado = num1 / num2;
                System.out.println("Resultado: " + resultado);
                break;

            case 'r':
                if (num1 < 0) {
                    System.out.println("No se puede calcular la raíz de un número negativo.");
                } else {
                    resultado = Math.sqrt(num1);
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Operación no válida.");
        }

        // Fin del programa
        System.out.println("----- GRACIAS POR USAR LA CALCULADORA -----");
    }
}
