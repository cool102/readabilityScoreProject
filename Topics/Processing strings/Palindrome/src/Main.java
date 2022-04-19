import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);
        String result = sb.reverse().toString().equals(input) ? "yes" : "no";
        System.out.println(result);

    }
}