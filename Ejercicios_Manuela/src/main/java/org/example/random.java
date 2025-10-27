import java.util.Random;

public class random {
    static void main() {
        Random aleatorio = new Random();
        int numero1 = aleatorio.nextInt(5)+1; //para decirle desde donde tienes que empezar le suma 1
        System.out.println(numero1);

        double numero2 = aleatorio.nextDouble()*100+1;
        System.out.println(numero2);

    }
}
