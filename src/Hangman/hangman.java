package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");

        menuGame();

    }

    public static void startGame() {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<String>();
        words.add("java");
        words.add("python");
        words.add("kotlin");
        words.add("javascript");

        ArrayList<Character> enteredLetter = new ArrayList<Character>();

        final String trueword = words.get(new Random().nextInt(words.size()));

        StringBuffer hideWord = new StringBuffer(trueword);
        StringBuffer lowercaseLetter = new StringBuffer("qwertyuiopasdfghjklzxcvbnm");


        for (int i = 0; i < trueword.length(); i++) {
            hideWord.setCharAt(i, '-');
        }

        System.out.println("Guess the word " + hideWord + ":");

        int attempts = 8;
        while ( attempts != 0) {
            System.out.print("Input a letter: > ");
            String letter = scan.nextLine();

            if ( letter.equals("") ) continue;
            if ( letter.length() > 1 ) {
                System.out.println("You should input a single letter.\n\n" + hideWord);
                continue;
            }
            if ( lowercaseLetter.indexOf(letter) == -1 ) {
                System.out.println("Please enter a lowercase English letter.\n\n" + hideWord);
                continue;
            }

            if ( trueword.contains(letter) ) {
                char[] chtrueword = trueword.toCharArray();

                if ( hideWord.indexOf(letter) != -1 || hideWord.lastIndexOf(letter) != -1 ) {
                    System.out.println("You`ve already guessed this letter.");
                }

                for (int i=0; i<trueword.length(); i++) {
                    if( chtrueword[i] == letter.charAt(0))
                        hideWord.setCharAt(i, letter.charAt(0));
                }

                System.out.println("\n" + hideWord);
            } else {
                if ( enteredLetter.contains(letter.charAt(0)) ) {
                    System.out.println("You`ve already guessed this letter.\n\n" + hideWord);
                } else {
                    System.out.println("That letter doesn`t appear in the word.\n\n" + hideWord);
                    enteredLetter.add(letter.charAt(0));
                    attempts--;
                }
            }

            if ( hideWord.indexOf("-") == -1) {
                System.out.println("You guessed the word!");
                break;
            }
        }

        if ( hideWord.indexOf("-") == -1 ) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        menuGame();
    }

    public static void menuGame() {
        System.out.print("\nType \"play\" to play the game, \"exit\" to quit: > ");
        Scanner scan = new Scanner(System.in);
        while ( true ) {
            String menu = scan.nextLine();

            if( menu.equals("play") ) {
                System.out.println("\n");
                startGame();
                break;
            }

            if( menu.equals("exit") ) System.exit(0);
            else continue;
        }
    }
}
