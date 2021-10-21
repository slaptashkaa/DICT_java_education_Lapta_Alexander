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

        StringBuffer hideword = new StringBuffer(trueword);

        for (int i = 0; i < trueword.length(); i++) {
            hideword.setCharAt(i, '-');
        }

        System.out.println("Guess the word " + hideword + ":");

        int attempts = 8;
        while ( attempts != 0) {
            System.out.print("Input a letter: > ");
            Scanner scan = new Scanner(System.in);
            String letter = scan.nextLine();
            if ( letter == "" ) {
                continue;
            }

            if ( trueword.contains(letter) ) {
                char[] chtrueword = trueword.toCharArray();

                for (int i=0; i<trueword.length(); i++) {
                    if( chtrueword[i] == letter.charAt(0) )
                        hideword.setCharAt(i, letter.charAt(0));
                }

                System.out.println("\n" + hideword);
            } else {
                System.out.println("That letter doesn`t appear in the word\n\n" + hideword);
            }
            attempts--;
        }

        System.out.println("\nThanks for playing!\n" +
                "We`ll see how well you did in the next stage");

        /*if ( hideword.equals(trueword) ) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }*/
    }
}
