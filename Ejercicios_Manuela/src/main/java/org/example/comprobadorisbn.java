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
                            break;
                        }
                        // Calcular suma
                        int suma = 0;
                        boolean todoCorrecto = true;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            char letra = isbnMayus.charAt(posicion);
                            int multiplicador = 10 - posicion;
                            int valor;

                            // Si es X en ultima posicion
                            if (letra == 'X' && posicion == 9) {
                                valor = 10;
                            }
                            // Si es X en otra posicion, error
                            else if (letra == 'X' && posicion != 9) {
                                System.out.println("ERROR: X solo puede estar en la ultima posicion");
                                todoCorrecto = false;
                                break;
                            }
                            // Si es un numero del 0 al 9
                            else if (letra >= '0' && letra <= '9') {
                                valor = letra - '0';
                            }
                            // Si no es ni numero ni X, error
                            else {
                                System.out.println("ERROR: Caracter invalido en posicion " + (posicion + 1));
                                todoCorrecto = false;
                                break;
                            }

                            int resultado = valor * multiplicador;
                            suma = suma + resultado;

                        }

                        // Mostrar resultado final
                        if (todoCorrecto == true) {

                            if (suma % 11 == 0) {
                                System.out.println("ISBN VALIDO");
                            } else {
                                System.out.println("ISBN NO VALIDO");
                            }
                        }
                        break;


                    case 2:                                                 // CASO 2: REPARAR ISBN
                        System.out.println("--- REPARAR ISBN ---");
                        System.out.print("Introduce ISBN con caracter invalido: ");
                        String isbn2 = teclado.nextLine();
                        String isbn2Mayus = isbn2.toUpperCase();

                        // Comprobar longitud
                        if (isbn2Mayus.length() != 10) {
                            System.out.println("ERROR: Debe tener 10 caracteres");
                            break;
                        }

                        // Buscar donde esta el caracter invalido
                        int dondeEstaElError = -1;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            char letra = isbn2Mayus.charAt(posicion);

                            // Comprobar si es valido
                            boolean esNumero = (letra >= '0' && letra <= '9');
                            boolean esXAlFinal = (posicion == 9 && letra == 'X');

                            // Si NO es numero Y NO es X al final, es invalido
                            if (esNumero == false && esXAlFinal == false) {
                                dondeEstaElError = posicion;
                                System.out.println("Caracter invalido encontrado en posicion " + (posicion + 1) + ": '" + letra + "'");
                                break;
                            }
                        }

                        // Si no hay nada invalido
                        if (dondeEstaElError == -1) {
                            System.out.println("ERROR: No hay ningun caracter para reparar");
                            System.out.println("El ISBN parece estar completo");
                            break;
                        }

                        // Calcular suma de los digitos buenos
                        int sumaBase = 0;

                        for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                            // Saltar la posicion que tiene el error
                            if (posicion == dondeEstaElError) {
                                continue;
                            }

                            char letra = isbn2Mayus.charAt(posicion);
                            int multiplicador = 10 - posicion;
                            int valor;

                            if (letra == 'X') {
                                valor = 10;
                            } else {
                                valor = letra - '0';
                            }

                            sumaBase = sumaBase + (valor * multiplicador);
                        }

                        // Probar numeros del 0 al 9 (o 10 si es ultima posicion)
                        int multiplicadorDelError = 10 - dondeEstaElError;
                        int hastaQueNumero = 9;

                        if (dondeEstaElError == 9) {
                            hastaQueNumero = 10;
                        }

                        boolean loEncontre = false;

                        for (int numeroProbar = 0; numeroProbar <= hastaQueNumero; numeroProbar = numeroProbar + 1) {
                            int sumaTotal = sumaBase + (numeroProbar * multiplicadorDelError);

                            if (sumaTotal % 11 == 0) {
                                System.out.println("ISBN REPARADO");
                                System.out.print("El digito correcto en posicion " + (dondeEstaElError + 1) + " es: ");

                                if (numeroProbar == 10) {
                                    System.out.println("X");
                                } else {
                                    System.out.println(numeroProbar);
                                }

                                // Construir ISBN completo
                                String isbnReparado = "";
                                for (int posicion = 0; posicion < 10; posicion = posicion + 1) {
                                    if (posicion == dondeEstaElError) {
                                        if (numeroProbar == 10) {
                                            isbnReparado = isbnReparado + "X";
                                        } else {
                                            isbnReparado = isbnReparado + numeroProbar;
                                        }
                                    } else {
                                        isbnReparado = isbnReparado + isbn2Mayus.charAt(posicion);
                                    }
                                }

                                System.out.println("ISBN completo: " + isbnReparado);
                                loEncontre = true;
                                break;
                            }
                        }

                        if (loEncontre == false) {
                            System.out.println("ERROR: No se pudo reparar el ISBN");
                        }
                        break;


                    case 3:                                                         // CASO 3: SALIR
                        System.out.println("Gracias por usar el validador de ISBN");
                        System.out.println("Hasta pronto!");
                        break;


                    // OPCION INVALIDA
                    default:
                        System.out.println("ERROR: Elige una opcion valida (1, 2 o 3)");
                        break;
                }

            } catch (Exception e) {
                System.out.println("ERROR: Debes introducir un numero");
                teclado.nextLine();
                opcion = 0; // Para no salir del menu
            }
        } while (opcion != 3);
    }
}