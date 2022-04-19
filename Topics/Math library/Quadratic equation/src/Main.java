import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();


        double D = Math.pow(b, 2) - 4 * a * c;
        double d = Math.sqrt(D);
        double x1 = (-b + d) / (2 * a);
        double x2 = (-b - d) / (2 * a);
        Double[] arr = new Double[]{x1,x2};
        Arrays.stream(arr).sorted().forEach(x->System.out.print(x+" "));


    }
}