import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String sub = sc.nextLine();
    char[] arr = input.replaceAll(sub, "2").toCharArray();
    int counter=0;
        for (Character candidate :arr
             ) {
            if (candidate == '2') {
                counter++;
            }
        }
        System.out.println(counter);
    }
}