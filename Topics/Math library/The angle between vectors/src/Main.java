import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int u1 = sc.nextInt();
        int u2 = sc.nextInt();

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        //System.out.println(u1+u2+v1+v2);

        double u = Math.sqrt(Math.pow(u1,2)+Math.pow(u2,2)); // взять под корень
        double v = Math.sqrt(Math.pow(v1,2)+Math.pow(v2,2));

        double up = (u1*v1)+(u2*v2);
        double down = u*v;
        double cos = up/down;

        double degrees = Math.toDegrees(Math.acos(cos)); //радианы перевести в градусы
        System.out.println((int)(degrees));



    }
}