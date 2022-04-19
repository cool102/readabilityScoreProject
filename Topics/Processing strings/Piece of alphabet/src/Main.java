import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String alphabet = "abcdefjhijklmopqrstuvwxyz";
        //String result = alphabet.contains(pattern)?"true":"false";
        //System.out.println(result);
        Pattern pattern = Pattern.compile(input);
        Matcher matcher = pattern.matcher(alphabet);
        System.out.println(matcher.find());

    }
}