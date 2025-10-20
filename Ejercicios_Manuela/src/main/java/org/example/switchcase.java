import java.util.Scanner;

public class switchcase {
    public static void main(String[] args){
        int dia_de_la_semana =1;  // donde empieza. int para numeros y char para letras pero entre comillas


        switch (dia_de_la_semana){
            case 1:
                System.out.println("Lunes");

            case 2:
                System.out.println("Martes");

            case 3:
                System.out.println("Miercoles");

            case 4:
                System.out.println("Jueves");

            case 5:
                System.out.println("Viernes");
                System.out.println("Entre semana");
                break;
            case 6:

            case 7:
                System.out.println("Fin de semana");
                break;
            default:
                System.out.println("Dia no valido");
        }
    }
}
