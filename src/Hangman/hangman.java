package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        ArrayList<String> words = new ArrayList<String>();
        words.add("java");
        words.add("python");
        words.add("kotlin");
        words.add("javascript");

        String trueword = words.get(new Random().nextInt(words.size()));

        String cap = trueword;
        StringBuffer sb = new StringBuffer(cap);

        for (int i = 0; i < trueword.length(); i++) {
            if ( i > 1 ) {
                sb.setCharAt(i, '-');
            }
        }

        System.out.println("Guess the word " + sb + ":");

        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        if ( word.equals(trueword) ) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
