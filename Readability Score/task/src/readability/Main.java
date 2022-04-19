package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> content = Files.readAllLines(Paths.get(args[0]));
        // List<String> content = Files.readAllLines(Path.of("D:\\devel\\Readability Score\\Readability Score\\task\\src\\readability\\in.txt"));
        String joinedString = String.join(" ", content);
        String[] splitByWords = joinedString.split("\\s");
        double words = splitByWords.length;
        double characters = joinedString.replaceAll("\\s", "").length();
        String[] splitBySentences1 = joinedString.split("\\.");
        double sentences = splitBySentences1.length;
        for (int i = 0; i < joinedString.length(); i++) {
            if (joinedString.charAt(i) == '!' || joinedString.charAt(i) == '?') {
                sentences++;
            }
        }
        //ARI
        double preScoreARI = 4.71 * (characters / words) + (0.5 * (words / sentences)) - 21.43;
        DecimalFormat df = new DecimalFormat("0.00");
        double scoreARI = Double.parseDouble(df.format(preScoreARI));


        int syllables = 0;
        for (int i = 0; i < splitByWords.length; i++) {
            syllables = syllables + countSyllables(splitByWords[i]);
        }

        int polysyllables = 0;

        for (int i = 0; i < splitByWords.length; i++) {
            int syll = countSyllables(splitByWords[i]);
            if (syll > 2) {
                polysyllables++;
            }
        }
        //FK
        double fkPreScore = 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
        double scoreFK = Double.parseDouble(df.format(fkPreScore));


        //SMOG
        double SMOGPreScore = 1.043 * Math.sqrt(polysyllables * 30 / sentences) + 3.1291;
        double smogScore = Double.parseDouble(df.format(SMOGPreScore));


        //CL
        double L = characters / words * 100;
        double S = sentences / words * 100;
        double clPreScore = 0.0588 * L - 0.296 * S - 15.8;
        double clScore = Double.parseDouble(df.format(clPreScore));


        String result = String.format("Words: %d\nSentences: %d\nCharacters: %d\nSyllables: %d\nPolysyllables: %d\n",
                (int) words, (int) sentences, (int) characters, syllables, polysyllables);

        System.out.println(result);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().trim();
        System.out.println();
        String answer = "";
        int delitel = 1;
        double age = 0;
        switch (choice) {

            case "ARI":
                answer = String.format("Automated Readability Index: %.2f (about %s-year-olds).", scoreARI, getAge(scoreARI));
                age = getAge(scoreARI);
                break;
            case "FK":
                answer = String.format("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).", scoreFK, getAge(scoreFK));
                age = getAge(scoreFK);
                break;
            case "SMOG":
                answer = String.format("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).", smogScore, getAge(smogScore));
                age = getAge(smogScore);
                break;
            case "CL":
                answer = String.format("Coleman–Liau index: %.2f (about %s-year-olds).", clScore, getAge(clScore));
                age = getAge(clScore);
                break;
            case "all":
                answer = String.format("Automated Readability Index: %.2f (about %d-year-olds).", scoreARI, getAge(scoreARI)) + "\n"
                        + String.format("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).", scoreFK, getAge(scoreFK)) + "\n"
                        + String.format("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).", smogScore, getAge(smogScore)) + "\n"
                        + String.format("Coleman–Liau index: %.2f (about %d-year-olds).", clScore, getAge(clScore))
                ;
                delitel = 4;
                age = getAge(scoreARI) + getAge(scoreFK) + getAge(smogScore) + getAge(clScore);

        }
        System.out.println(answer);
        double average = age / delitel;
        System.out.println();
        System.out.printf("This text should be understood in average by %.2f-year-olds.", average);

    }

    public static boolean isVowel(String letter) {
        String vowels = "AEIOUYaeiouy";
        return vowels.contains(letter);

    }

    public static int getAge(double score) {
        switch ((int) Math.ceil(score)) {
            case 1:
                return 6;

            case 2:
                return 7;

            case 3:
                return 8;

            case 4:
                return 9;

            case 5:
                return 10;

            case 6:
                return 11;

            case 7:
                return 12;

            case 8:
                return 13;

            case 9:
                return 14;

            case 10:
                return 15;

            case 11:
                return 17;

            case 12:

            case 13:
                return 19;

            case 14:
                return 22;
        }
        return 0;
    }


    public static int countSyllables(String word) {

        String deleteEOnTheEnd = word.replaceAll("e\\b", "t");
        String withYinbegin = deleteEOnTheEnd.replaceAll("\\Ay", "t");
        String withYinbeginY = withYinbegin.replaceAll("\\AY", "t");

        int vowels = 0;
        for (int i = 0; i < withYinbeginY.length(); i++) {
            char ch = withYinbeginY.charAt(i);
            if (isVowel(String.valueOf(ch))) {
                vowels++;
            }
        }


        for (int i = 0; i < withYinbeginY.length() - 1; i++) {
            char previous = withYinbeginY.charAt(i);
            char next = withYinbeginY.charAt(i + 1);
            if (isVowel(String.valueOf(previous)) &&
                    isVowel(String.valueOf(next))) {
                vowels = vowels - 1;
                i = i + 1;
            }
        }


        if (vowels == 0) {
            return 1;
        } else {
            return vowels;
        }

    }
}

