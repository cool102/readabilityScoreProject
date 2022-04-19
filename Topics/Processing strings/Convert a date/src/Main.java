import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr= sc.nextLine().split("-");
        System.out.printf("%s/%s/%s",arr[1],arr[2],arr[0]);
    }
}