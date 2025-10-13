import java.util.Scanner;
public class CosasNumeritos {
    public static void main(String[] args) {
        int num1=124;
        int num2=212;

        String num_sring=Integer.toString(num1); // este es al que se hace los substring

        String num_izquierda=num_sring.substring(0,1);
        int num_izquierda_int=Integer.parseInt(num_izquierda);
        System.out.println(num_izquierda_int*num1);

        String num_centro=num_sring.substring(0,2);
        int num_centro_int=Integer.parseInt(num_centro);
        System.out.println(num_centro_int*num1);

        String num_derecha=num_sring.substring(2,3);
        int num_derecha_int=Integer.parseInt(num_derecha);
        System.out.println(num_derecha_int*num1);
    }
}