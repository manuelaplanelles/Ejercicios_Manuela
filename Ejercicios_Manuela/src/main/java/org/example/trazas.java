import java.util.Scanner;

public class trazas {
    public static void main(String[] args) {
        int a, b, c, d;
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=0;
        c=1;
        while (a!=0){
            b++;
            c=c*a/b;
            a= sc.nextInt();
        }
        d=b+c;
        System.out.println(d);

    }
}
