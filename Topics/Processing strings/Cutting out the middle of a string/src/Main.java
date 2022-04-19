import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int middleIdx = (input.length() / 2);
        String resultWithOutMiddleChar;
        if (input.length() % 2 == 1) {
            resultWithOutMiddleChar = input.substring(0, middleIdx) + input.substring(middleIdx + 1);

        } else {
            resultWithOutMiddleChar = input.substring(0, middleIdx - 1) + input.substring(middleIdx + 1);
        }
        System.out.println(resultWithOutMiddleChar);
    }
}