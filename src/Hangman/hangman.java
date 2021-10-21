package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN\n" +
                "Guess the word:");

        ArrayList<String> words = new ArrayList<String>();
        words.add("java");
        words.add("python");
        words.add("kotlin");
        words.add("javascript");

        String trueword = words.get(new Random().nextInt(words.size()));

        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        if ( word.equals(trueword) ) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
