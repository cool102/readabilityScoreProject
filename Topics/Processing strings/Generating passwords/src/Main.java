import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");

        int upper = Integer.parseInt(numbers[0]);
        int lower = Integer.parseInt(numbers[1]);
        int dig = Integer.parseInt(numbers[2]);
        int length = Integer.parseInt(numbers[3]);

        Random rand = new Random();
        String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abc = ABC.toLowerCase(Locale.ROOT);
        String numeric = "1234567890";

        String password = "ff";
        while (isBadPass(password)) {
            password = getResult(upper, lower, dig, rand, ABC, abc, numeric);
            while (password.length() < length) {
                StringBuilder sb = new StringBuilder(password);
                sb.append(abc.charAt(rand.nextInt(26)));
                password = sb.toString();
            }
        }

        System.out.println(password);
    }

    private static String getResult(int upper, int lower, int dig, Random rand, String ABC, String abc, String numeric) {
        return getUpperString(upper, rand, ABC) + getLowerString(lower, rand, abc) +
                getDigString(dig, rand, numeric);
    }
    public static boolean isBadPass(String word) {
        for (int i = 0; i < word.length(); i++) {
            int firstIdx = word.indexOf(word.charAt(i));
            // int secondIdx = word.indexOf(word.charAt(i))+1;
            int lastIndex = word.lastIndexOf(word.charAt(i));
            if (lastIndex - firstIdx == 1) {
                return true;
            }
        }
        return false;
    }

    private static String getDigString(int dig, Random rand, String numeric) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dig; i++) {
            sb.append(numeric.charAt(rand.nextInt(9) + 1));
        }
        return sb.toString();
    }


    private static String getLowerString(int lower, Random rand, String abc) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lower; i++) {
            sb.append(abc.charAt(rand.nextInt(26)));
        }
        return sb.toString();
    }

    private static String getUpperString(int upper, Random rand, String ABC) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < upper; i++) {
            sb.append(ABC.charAt(rand.nextInt(26)));
        }
        return sb.toString();
    }
}