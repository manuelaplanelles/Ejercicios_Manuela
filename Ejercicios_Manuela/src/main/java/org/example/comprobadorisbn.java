import java.util.Scanner;

public class comprobadorisbn {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Variable menú
        int opcion;

        // Mensaje de bienvenida
        System.out.println("***** COMPROBADOR DE ISBN *****");

        // Mostrar menú de operaciones
        System.out.println("------------------------------");
        System.out.println("[1] --> Validar nº ISBN");
        System.out.println("[2] --> Reparar nº ISBN");
        System.out.println("[3] --> Salir del programa");
        System.out.println("------------------------------");

        do {
            System.out.println("Selecciona una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1){
                System.out.println("Introduce ISBN: ");
                String isbn = teclado.nextLine();

                //comprobamos que tiene 10 cracteres
                if (isbn.length()==10){
                    System.out.println("Error: El ISBN debe tener 10 digitos");
                }else{
                    //calculo
                    int suma = 0;
                    boolean esValido=true;

                    for (int i = 0; i <10; i++){
                        char caracter =isbn.charAt(i);
                    }
            }






            }

        }while ();
    }
}
