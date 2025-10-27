import java.util.Random;
public class ejerciciorandom4 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String contrasenya = "";

        int longitud = aleatorio.nextInt(5) + 8;
        System.out.println("Longitud de la contraseña: " + longitud);

        for (int i = 0; i < longitud; i++) {
            contrasenya += caracteres.charAt(aleatorio.nextInt(caracteres.length()));
        }

        int mayusculas = 0;
        int minusculas = 0;
        int numeros = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            char c = contrasenya.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                mayusculas++;
            } else if (c >= 'a' && c <= 'z') {
                minusculas++;
            } else if (c >= '0' && c <= '9') {
                numeros++;
            }
        }
        System.out.println("Tu contraseña es: " + contrasenya);
        System.out.println("Mayusculas: " + mayusculas);
        System.out.println("Minusculas: " + minusculas);
        System.out.println("Numeros: " + numeros);

        if (mayusculas > 0 && minusculas > 0 && numeros > 0) {
            System.out.println("La contraseña es valida");
        } else {
            System.out.println("La contraseña NO es valida");
        }
    }
}