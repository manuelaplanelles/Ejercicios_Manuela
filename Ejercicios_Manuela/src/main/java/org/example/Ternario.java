import java.util.Scanner;
public class Ternario {
    public static void main(String[] args){

        int a = 1, b = 2, c = 3;
        int resultado = a++ == 1 && a < b++ ? a += c :
                        a > 0 && a == b ? a -= b :
                        b == c ? a++ : a--;

        System.out.println("Resultado = " + resultado);
        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        }
}