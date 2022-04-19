import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int counter = 0;
        for (int i = 0; i < input.length()-2; i++) {
            if (isVowel(String.valueOf(input.charAt(i)))
                    && isVowel(String.valueOf(input.charAt(i + 1))) &&
                    isVowel(String.valueOf(input.charAt(i + 2)))) {
                counter++;
                i++;
            } else if (
                    !isVowel(String.valueOf(input.charAt(i)))
                            && !isVowel(String.valueOf(input.charAt(i + 1))) &&
                            !isVowel(String.valueOf(input.charAt(i + 2)))) {
                counter++;
                i++;

            }

        }
        System.out.println(counter);
    }

    public static boolean isVowel(String ch) {
        return "aeiouy".contains(ch);
    }

    public static boolean isEuphonious(String word) {
        Pattern consonants = Pattern.compile("[^aeiouy]{3,}");
        Pattern vowels = Pattern.compile("[aeiouy]{3,}");
        Matcher consonantsMatcher = consonants.matcher(word);
        Matcher vowelsMatcher = vowels.matcher(word);
        long count3C = consonantsMatcher.results().count();
        long count3V = vowelsMatcher.results().count();

        if (count3V == 0 && count3C == 0) {
            return true;
        } else {
            return false;
        }
    }
}


