import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("");
        int first3 = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .limit(3)
                .reduce((i1,i2)->i1+i2)
                .getAsInt();

        int last3 = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .skip(3)
                .reduce((i1,i2)->i1+i2)
                .getAsInt();
       String res = last3==first3? "Lucky":"Regular";
        System.out.println(res);

    }
}