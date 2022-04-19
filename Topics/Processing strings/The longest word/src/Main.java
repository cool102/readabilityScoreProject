import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        String result = Arrays.stream(arr)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .findFirst()
                .get();
        System.out.println(result);
    }
}