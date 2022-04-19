import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Set<Character> pattern = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            pattern.add(current);
        }
        List<Character> collect = pattern.stream().collect(Collectors.toList());
        String result="";
        int counter=0;
        for (int i = 0; i < pattern.size(); i++) {
            for (int j = 0; j <input.length() ; j++) {
                char currentChar = input.charAt(j);
                if (currentChar==collect.get(i)){
                    counter++;
                }
            }
            result=result+collect.get(i)+counter;
            counter=0;
        }
        System.out.println(result);
    }
}