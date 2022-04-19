import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int inputLenght = input.length();
        String inputFormatted = input.toLowerCase();
        int counterG=0;
        int counterC=0;
        for (int i = 0; i < inputLenght; i++) {
          if (inputFormatted.charAt(i)=='g') {
              counterG++;
          }
        }

        for (int i = 0; i < inputLenght; i++) {
            if (inputFormatted.charAt(i)=='c') {
                counterC++;
            }
        }
        System.out.println((double) counterG/inputLenght*100+
        (double) counterC/inputLenght*100);


    }
}