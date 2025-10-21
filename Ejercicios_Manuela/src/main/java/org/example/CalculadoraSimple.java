import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args){
        // Crear el lector del teclado
        Scanner teclado = new Scanner(System.in);

        // Variables principales
        double num1 = 0;
        double num2 = 0;
        double resultado = 0;
        boolean valido = false;
        char signo;

        // Mensaje de bienvenida
        System.out.println("***** BIENVENIDO A LA CALCULADORA RÁPIDA *****");

        // Leer primer número (con control de errores)

            System.out.print("Introduce el primer número: ");
            if (teclado.hasNextDouble()) {
                num1 = teclado.nextDouble();
                valido = true;
            } else {
                System.out.println("Valor no válido. Introduce un número.");
                teclado.next();
            }

        // Mostrar menú de operaciones
        System.out.println("------------------------------");
        System.out.println("[+] --> suma");
        System.out.println("[-] --> resta");
        System.out.println("[x] --> multiplicar");
        System.out.println("[/] --> dividir");
        System.out.println("[R] --> raíz cuadrada");
        System.out.println("------------------------------");

        // Leer el signo de la operación
        System.out.print("Elige una operación: ");
        signo = teclado.next().charAt(0); // lee solo el primer carácter escrito
        signo = Character.toLowerCase(signo); // convierte mayúscula en minúscula

        // Si la operación no es raíz, pedimos segundo número
        if (signo != 'r') {
            valido = false; // reiniciamos la validación

           System.out.print("Introduce el segundo número: ");
                if (teclado.hasNextDouble()) {
                    num2 = teclado.nextDouble();

                    // Control: evitar dividir entre cero
                    if (signo == '/' && num2 == 0) {
                        System.out.println("No se puede dividir entre 0.");
                    } else {
                        valido = true;
                    }

                } else {
                    System.out.println("Valor no válido. Introduce un número.");
                    teclado.next(); // limpia el valor incorrecto
                }

        }


        // Calcular el resultado según la operación
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

        // -------------------------------
        // Fin del programa
        // -------------------------------
        System.out.println("----- GRACIAS POR USAR LA CALCULADORA -----");

        teclado.close();
    }
}
