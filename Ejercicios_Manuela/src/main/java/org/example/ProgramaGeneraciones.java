import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProgramaGeneraciones {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        //variables
        int anyo_actual = LocalDateTime.now().getYear();
        final int ANYO_MINIMO = 1990;
        int anyo_nacimiento_int = 1;


        System.out.println("elige un modo..");
        System.out.println("[1] - Año de naciemiento");
        System.out.println("[2]- Edad");
        System.out.println("---------------------------");

        //desarrollamos el modul 1.
        LocalDateTime fecha = LocalDateTime.now();
        int anyo_actual = fecha.getYear();

        if (anyo_nacimiento_int >= ANYO_MINIMO && anyo_nacimiento_int <= anyo_actual){
            if (anyo_nacimiento_int <= 1927) {
                System.out.println("Generacion no bautizada");
            }else if{
            }
        }


        //desarrollamos el modulo 2
        int edad = 0;           //solicitamos la edad y comprobamos que sea formato correcto
        System.out.println("Introduce tu edad...");
        if (teclado.hasNextInt()) {
            edad = teclado.nextInt();
        }else{
            System.out.println("Formota incorecto. no es numerico.");
            return;
        }
    }
}
