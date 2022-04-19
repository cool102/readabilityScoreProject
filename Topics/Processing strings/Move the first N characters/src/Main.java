import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] sArr= input.split(" ");
        int n =Integer.parseInt(sArr[1]);
        String word =sArr[0];

        if (n>word.length()) {
            System.out.println(word);

        }
        else {
            String firstNelements = input.substring(0,n);
            String otherLements = input.substring(n,word.length());
            System.out.println(otherLements+firstNelements);

        }

    }
}