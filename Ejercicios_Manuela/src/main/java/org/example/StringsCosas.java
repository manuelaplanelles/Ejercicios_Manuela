public class Lop {
    public static void main(String[] args) {
        String frase = "Metanyahu le regala una paloma de oro a Trum";
        int tamanyo=frase.length(); //para indicar cuantos caracteres

        //quiero obtener cierto caracter en cierta posición
        System.out.println(frase.charAt(35)); //que pòsicion quiero coger
        String trozo = frase.substring(38,45); //que trozo quiero coger
        System.out.println(trozo);

        String trozo2 = frase.substring(38); //para que coja desde el inicio hasta la posicion que indiques
        int posicion_oro = frase.indexOf("oro");
        //int posiicion_oro2 =
        //int posicion_oro_ultima = frase.lastIndexOf( );//dime en que posicion esta


        //pasa pasar de minuscula a mayuscula
        String frase_mayusculas = frase.toUpperCase();
        System.out.println(frase_mayusculas);
        String frase_minusculas = frase.toLowerCase();
        System.out.println(frase_minusculas);

        //para escribir sin espacios
        String nombre = "Manuela       ";
        System.out.println(nombre.trim() + "-" + nombre + "#");

        //comparar dos textos, tu le preguntas  el contesta si o no
        boolean iguales = nombre.equals("Manuela");

        String nombre3 = "Iván       ";
        boolean iguales2 = nombre.trim().equals("Iván"); // pàra acentos
        System.out.println(iguales2);

        String nobre_mayus = nombre.toUpperCase();
        boolean iguales3 = nobre_mayus.trim().equals("IVÁN"); //pàra mayuscula

        //para obviar mayusculas y minusculas
        boolean iguales4 = nombre.trim().equalsIgnoreCase( "IVÁN");
        System.out.println(iguales4);

        //para remplazar cosas
        String cambiada = frase.replace("paloma", "palOma");

        //para conctaenar
        String frsase_concatenada = frase.concat(" de EEUU");
        System.out.println();

    }





}
