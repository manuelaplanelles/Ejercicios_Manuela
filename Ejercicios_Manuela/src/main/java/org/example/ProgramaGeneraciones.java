import java.time.LocalDateTime;
import java.util.Scanner;

public class ProgramaGeneraciones {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        final int ANYO_MINIMO = 1990;
        int anyo_nacimiento_int = 1;


        System.out.println("elige un modo..");
        System.out.println("[1] - Año de naciemiento");
        System.out.println("[2]- Edad");
        System.out.println("---------------------------");

        int nodo = 0
        if (teclado.hasNextInt()) {
            nodo = teclado.nextInt();
        }else{
            System.out.println("Introduce un valor valido");
            return;
        }
        LocalDateTime fecha = LocalDateTime.now();
        int anyo_actual = fecha.getYear();

        if (anyo_nacimiento_int >= ANYO_MINIMO && anyo_nacimiento_int <= anyo_actual){
            if (anyo_nacimiento_int <= 1927) {
                System.out.println("Generacion no bautizada");
            }else if
            }
        }

    }
}
