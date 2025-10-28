import java.util.Scanner;

public class comprobadorisbn {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Menú principal con do-while para repetir
        do {
            System.out.println("***** COMPROBADOR DE ISBN *****");

            // Mostrar menú de operaciones
            System.out.println("------------------------------");
            System.out.println("[1] --> Validar nº ISBN");
            System.out.println("[2] --> Reparar nº ISBN");
            System.out.println("[3] --> Salir del programa");
            System.out.println("------------------------------");
            System.out.print("Elige opcion: ");

            // Control de errores al pedir opción
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {

                    case 1:                                         // CASO 1: VALIDAR ISBN
                        System.out.println("--- VALIDAR ISBN ---");
                        System.out.print("Introduce ISBN (10 caracteres): ");
                        String isbn = teclado.nextLine();
                        String isbnMayus = isbn.toUpperCase();

                        // Comprobar longitud
                        if (isbnMayus.length() != 10) {
                            System.out.println("ERROR: Debe tener 10 caracteres");
                        }

                        // Calcular suma
                        int suma = 0;
                        boolean correcto = true;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            char letra = isbnMayus.charAt(posicion);
                            int multiplicador = 10 - posicion;
                            int valor = 0;

                            // X en ultima posicion
                            if (letra == 'X' && posicion == 9) {
                                valor = 10;
                            }
                            // X en otra posicion, error
                            else if (letra == 'X' && posicion != 9) {
                                System.out.println("ERROR: X solo puede estar en la ultima posicion");
                                correcto = false;
                            }
                            // Si es un numero del 0 al 9
                            else if (letra >= '0' && letra <= '9') {
                                valor = letra - '0';
                            }
                            // Si no es ni numero ni X, error
                            else {
                                System.out.println("ERROR: Caracter invalido en posicion " + (posicion + 1));
                                correcto = false;
                            }

                            int resultado = valor * multiplicador;
                            suma = suma + resultado;
                        }

                        // Mostrar resultado final
                        if (correcto == true) {
                            if (suma % 11 == 0) {
                                System.out.println("ISBN VALIDO");
                            } else {
                                System.out.println("ISBN NO VALIDO");
                            }
                        }

                    case 2:                                                 // CASO 2: REPARAR ISBN
                        System.out.println("--- REPARAR ISBN ---");
                        System.out.print("Introduce ISBN con caracter invalido: ");
                        String isbn2 = teclado.nextLine();
                        String mayuscula = isbn2.toUpperCase();

                        // Comprobar longitud
                        if (mayuscula.length() != 10) {
                            System.out.println("ERROR: Debe tener 10 caracteres");
                        }

                        // Buscar donde esta el caracter invalido
                        int caracterinvalido = -1;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            char letra = mayuscula.charAt(posicion);

                            // Comprobar si es valido
                            boolean num = (letra >= '0' && letra <= '9');
                            boolean xfinal = (posicion == 9 && letra == 'X');

                            // Si NO es numero Y NO es X al final, es invalido
                            if (num == false && xfinal == false) {
                                caracterinvalido = posicion;
                                System.out.println("Caracter invalido encontrado en posicion " + (posicion + 1) + ": '" + letra + "'");
                            }
                        }

                        // Si no hay nada invalido
                        if (caracterinvalido == -1) {
                            System.out.println("ERROR: No hay ningun caracter para reparar");
                            System.out.println("El ISBN parece estar completo");
                        }

                        // Calcular suma de los digitos buenos
                        int suma2 = 0;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            // Saltar la posicion que tiene el error
                            if (posicion == caracterinvalido) {
                            }

                            char letra = mayuscula.charAt(posicion);
                            int multiplicador = 10 - posicion;
                            int valor;

                            if (letra == 'X') {
                                valor = 10;
                            } else {
                                valor = letra - '0';
                            }

                            suma2 = suma2 + (valor * multiplicador);
                        }

                        // Probar numeros del 0 al 9 (o 10 si es ultima posicion)
                        int multiplicador = 10 - caracterinvalido;
                        int hastanum = 9;

                        if (caracterinvalido == 9) {
                            hastanum = 10;
                        }

                        boolean solucion = false;
                        int digitocorrecto = -1;

                        for (int prueba = 0; prueba <= hastanum; prueba = prueba + 1) {
                            int totalsuma2 = suma2 + (prueba * multiplicador);

                            if (totalsuma2 % 11 == 0) {
                                digitocorrecto = prueba;
                                solucion = true;
                            }
                        }

                        // Mostrar resultado
                        if (solucion == true) {
                            System.out.println("ISBN REPARADO");
                            System.out.print("El digito correcto en posicion " + (caracterinvalido + 1) + " es: ");

                            if (digitocorrecto == 10) {
                                System.out.println("X");
                            } else {
                                System.out.println(digitocorrecto);
                            }

                            // Construir ISBN completo
                            String parte1 = mayuscula.substring(0, caracterinvalido);
                            String parte2 = "";

                            if (caracterinvalido + 1 < mayuscula.length()) {
                                parte2 = mayuscula.substring(caracterinvalido + 1);
                            }

                            String digitoString = "";
                            if (digitocorrecto == 10) {
                                digitoString = "X";
                            } else {
                                digitoString = String.valueOf(digitocorrecto);
                            }

                            String isbnReparado = parte1 + digitoString + parte2;
                            System.out.println("ISBN completo: " + isbnReparado);

                        } else {
                            System.out.println("ERROR: No se pudo reparar el ISBN");
                        }


                    case 3:                                                         // CASO 3: SALIR
                        System.out.println("Gracias por usar el validador de ISBN");
                        System.out.println("Hasta pronto!");


                                                                                    // OPCION INVALIDA
                    default:
                        System.out.println("ERROR: Elige una opcion valida (1, 2 o 3)");
                }

            } catch (Exception e) {
                System.out.println("ERROR: Debes introducir un numero");
                teclado.nextLine();
                opcion = 0; // Para no salir del menu
            }
        } while (opcion != 3);
    }
}