import java.util.Scanner;

public class calculadorasimple2 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        //valiables
        double num1 =0;
        boolean numero1Valido;                                   // Declaración de la variable

        //bienvenida
        System.out.println("***** BIENVENIDO A LA CALCULADORA RÁPIDA *****");

        //leer primer número + con control de errores)
        do {
            numero1Valido = true;                                // Asumimos que será válido
            System.out.println("Introduce el primer número: ");
            if (teclado.hasNextDouble()) {                      // comprobamos si es un número decimal
                num1 = teclado.nextDouble();
            } else {
                System.out.println("Valor no válido. Introduce un número.");
                teclado.next();                                 // limpiamos el buffer
                numero1Valido = false;                           // Marcamos que NO es válido
            }
        } while (numero1Valido == false);                        // Continuar hasta que el número sea válido

        //variable signo
        char signo = 0;
        boolean simboloValido;

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
            simboloValido = false;                          // Asumimos que no es válido
            System.out.print("Elige una operación: ");
            String input = teclado.nextLine();              // leemos la entrada como String

            if (input.length() == 1) {                      // Verificamos si la entrada es un único carácter y no un número
                signo = input.charAt(0);                    // Obtenemos el primer carácter

                // Convertimos 'r' minúscula a 'R' mayúscula
                if (signo == 'r') {
                    signo = 'R';
                }

                if (signo == '+' || signo == '-' || signo == 'x' || signo == '/' || signo == 'R') {
                    simboloValido = true;                   // Es válido
                } else {
                    System.out.println("Símbolo no válido. Usa: +, -, x, / o R");
                }
            } else {
                System.out.println("Debes introducir solo un carácter.");
            }

        } while (simboloValido == false);                   // Repetir mientras no sea válido

        // variable
        double num2 =0;
        boolean numero2Valido;

        //leer segundo número + con control de errores)
        do {
            numero2Valido = true;                                // Asumimos que será válido
            System.out.println("Introduce el segundo número: ");
            if (teclado.hasNextDouble()) {                      // comprobamos si es un número decimal
                num2 = teclado.nextDouble();
            } else {
                System.out.println("Valor no válido. Introduce un número.");
                teclado.next();
                numero2Valido = false;                           // Marcamos que NO es válido
            }
        } while (numero2Valido == false);                        // Continuar hasta que el número sea válido


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
                if (num2 == 0) {
                    System.out.println("Error: No se puede dividir entre 0.");
                } else {
                    resultado = num1 / num2;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            case 'R':
                if (num1 < 0) {
                    System.out.println("Error: No se puede calcular la raíz de un número negativo.");
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
