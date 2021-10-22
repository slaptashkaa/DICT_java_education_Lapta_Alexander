package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        final String name = "Amogus";
        final int year = 2021;
        System.out.println("Hello! My name is " + name + ".\n" +
                "I was created in " + year + ".\n" + "Please, remind me your name.");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        System.out.println("What a great name you have, " + user + "!\nLet me guess your age.\n" +
                "Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = scan.nextInt();
        int remainder5 = scan.nextInt();
        int remainder7 = scan.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + " that`s a good time to start programming!");
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int number = scan.nextInt();

        int i = 0;
        while ( i <= number ) {
            System.out.println(i + "!");
            i++;
        }

        int hi = 0;
        while ( hi == 0 ) {
            System.out.println("Подскажи-ка мне.\nКто ты?\n1. ABOBA\n2. ABOBUS\n3. GLOTUS\n4. " + user);
            int answer = scan.nextInt();
            if(answer == 4) {
                System.out.println(user + ", ты молодец. Пока!");
                hi = 1;
            } else {
                System.out.print("Попробуй ещё раз!");
            }
        }
    }
}
