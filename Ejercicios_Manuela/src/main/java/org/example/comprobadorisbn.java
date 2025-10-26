import java.util.Scanner;

public class comprobadorisbn {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        boolean seguirEnMenu = true;

        // Menú principal
        while (seguirEnMenu == true) {

            // Mensaje de bienvenida
            System.out.println("***** COMPROBADOR DE ISBN *****");

            // Mostrar menú de operaciones
            System.out.println("------------------------------");
            System.out.println("[1] --> Validar nº ISBN");
            System.out.println("[2] --> Reparar nº ISBN");
            System.out.println("[3] --> Salir del programa");
            System.out.println("------------------------------");
            // Pedir opción con control de errores
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                // OPCION 1: VALIDAR ISBN
                if (opcion == 1) {

                    System.out.println("--- VALIDAR ISBN ---");
                    System.out.print("Introduce el ISBN (10 caracteres): ");
                    String isbn = teclado.nextLine();

                    // Comprobar que tiene 10 caracteres
                    if (isbn.length() == 10) {

                        int suma = 0;
                        int peso = 10;
                        boolean hayError = false;

                        // Recorrer cada carácter del ISBN
                        for (int i = 0; i < 10; i++) {

                            char caracter = isbn.charAt(i);
                            int valor = 0;

                            // Comprobar si es X (solo en última posición)
                            if (caracter == 'X' || caracter == 'x') {
                                if (i == 9) {
                                    valor = 10;
                                } else {
                                    System.out.println("ERROR: X solo puede estar al final");
                                    hayError = true;
                                    break;
                                }
                            }
                            // Comprobar si es un número del 0 al 9
                            else if (caracter >= '0' && caracter <= '9') {
                                valor = caracter - '0';
                            }
                            // Si no es ni X ni número, es inválido
                            else {
                                System.out.println("ERROR: Caracter invalido en posicion " + (i + 1));
                                hayError = true;
                                break;
                            }

                            // Sumar al total
                            suma = suma + (valor * peso);
                            peso = peso - 1;
                        }

                        // Mostrar resultado solo si no hubo errores
                        if (hayError == false) {
                            if (suma % 11 == 0) {
                                System.out.println("Resultado: ISBN VALIDO");
                                System.out.println("Suma = " + suma);
                            } else {
                                System.out.println("Resultado: ISBN NO VALIDO");
                                System.out.println("Suma = " + suma + " (no es multiplo de 11)");
                            }
                        }

                    } else {
                        System.out.println("ERROR: El ISBN debe tener 10 caracteres");
                    }
                }

                // OPCION 2: REPARAR ISBN
                else if (opcion == 2) {

                    System.out.println("--- REPARAR ISBN ---");
                    System.out.print("Introduce el ISBN: ");
                    String isbn = teclado.nextLine();

                    // Comprobar que tiene 10 caracteres
                    if (isbn.length() == 10) {

                        // Buscar la posición del carácter inválido
                        int posicion = -1;
                        for (int i = 0; i < 10; i++) {
                            char c = isbn.charAt(i);
                            // Si NO es un número (y tampoco es X en última posición)
                            if ((c < '0' || c > '9') && !(i == 9 && (c == 'X' || c == 'x'))) {
                                posicion = i;
                                break;
                            }
                        }

                        // Si no hay ningún carácter inválido
                        if (posicion == -1) {
                            System.out.println("ERROR: No hay ningun caracter para reparar");
                            System.out.println("El ISBN parece estar completo");
                        }
                        // Si hay un carácter inválido, buscar el dígito correcto
                        else {

                            int sumaBase = 0;
                            int peso = 10;
                            boolean hayError = false;

                            // Calcular la suma de los dígitos que SÍ conocemos
                            for (int i = 0; i < 10; i++) {

                                // Saltar la posición del carácter inválido
                                if (i == posicion) {
                                    peso = peso - 1;
                                    continue;
                                }

                                char caracter = isbn.charAt(i);
                                int valor = 0;

                                if (caracter == 'X' || caracter == 'x') {
                                    if (i == 9) {
                                        valor = 10;
                                    } else {
                                        System.out.println("ERROR: X solo puede estar al final");
                                        hayError = true;
                                        break;
                                    }
                                } else if (caracter >= '0' && caracter <= '9') {
                                    valor = caracter - '0';
                                } else {
                                    System.out.println("ERROR: Hay mas de un caracter invalido");
                                    hayError = true;
                                    break;
                                }

                                sumaBase = sumaBase + (valor * peso);
                                peso = peso - 1;
                            }

                            // Si no hubo errores, buscar el dígito que falta
                            if (hayError == false) {

                                // Calcular el peso del carácter inválido
                                int pesoDeLaInterrogante = 10 - posicion;

                                // Determinar hasta qué número probar
                                int maximo = 9;
                                if (posicion == 9) {
                                    maximo = 10;
                                }

                                // Probar valores del 0 al 9 (o 10 si es última posición)
                                boolean seEncontro = false;

                                for (int numero = 0; numero <= maximo; numero = numero + 1) {

                                    int sumaTotal = sumaBase + (numero * pesoDeLaInterrogante);

                                    // Si la suma es múltiplo de 11, este es el dígito correcto
                                    if (sumaTotal % 11 == 0) {

                                        System.out.println("Resultado: ISBN REPARADO");
                                        System.out.print("El digito correcto en posicion " + (posicion + 1) + " es: ");

                                        if (numero == 10) {
                                            System.out.println("X");
                                        } else {
                                            System.out.println(numero);
                                        }

                                        // Construir el ISBN completo
                                        String isbnCompleto = "";
                                        for (int i = 0; i < 10; i++) {
                                            if (i == posicion) {
                                                if (numero == 10) {
                                                    isbnCompleto = isbnCompleto + "X";
                                                } else {
                                                    isbnCompleto = isbnCompleto + numero;
                                                }
                                            } else {
                                                isbnCompleto = isbnCompleto + isbn.charAt(i);
                                            }
                                        }

                                        System.out.println("ISBN completo: " + isbnCompleto);
                                        seEncontro = true;
                                        break;
                                    }
                                }

                                // Si después de probar todos no encontró nada
                                if (seEncontro == false) {
                                    System.out.println("ERROR: No se pudo reparar el ISBN");
                                }
                            }
                        }

                    } else {
                        System.out.println("ERROR: El ISBN debe tener 10 caracteres");
                    }
                }

                // OPCION 3: SALIR
                else if (opcion == 3) {
                    System.out.println("¡Hasta pronto!");
                    seguirEnMenu = false;
                }

                // Opción no válida
                else {
                    System.out.println("ERROR: Elige 1, 2 o 3");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Debes escribir un numero");
                teclado.nextLine();
            }
        }
    }
}