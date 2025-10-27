import java.util.Random;

public class ejerciciorandom1 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int numero1 = aleatorio.nextInt(5)+1; //para decirle desde donde tienes que empezar le suma 1
        System.out.println(numero1);


        int numero2 = aleatorio.nextInt(5)+1; //para decirle desde donde tienes que empezar le suma 1
        System.out.println(numero2);

        System.out.println(numero1+numero2);
    }
}
