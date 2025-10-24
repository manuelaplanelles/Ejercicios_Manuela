import java.util.Scanner;

public class comprobadorisbn {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Mensaje de bienvenida
        System.out.println("***** COMPROBADOR DE ISBN *****");

        // Mostrar menú de operaciones
        System.out.println("------------------------------");
        System.out.println("[1] --> Validar nº ISBN");
        System.out.println("[2] --> Reparar nº ISBN");
        System.out.println("[3] --> Salir del programa");
        System.out.println("------------------------------");

        //variable


        System.out.println("Introduce ISBN");
        String isbn = teclado.nextLine();
        do {
            if (isbn.length()==10){
                continue;

            }else{
                System.out.println("El ISBN mo es válido");

            }

        }while ();
    }
}
