package Hangman;

import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN\n" +
                "Guess the word:");

        Scanner scan = new Scanner(System.in);
        String trueword = "java";
        String word = scan.nextLine();

        if ( word.equals(trueword) ) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
