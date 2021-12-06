package CoffeMachine;

import java.util.Arrays;
import java.util.Scanner;

public class coffemachine {
    enum Stage {START, GRIND, BOIL, MIX, POURCOFFE, POURMILK, READY}

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        checkStatistics();
        startMachine();
    }

    public static void startMachine() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
        switch ( scan.nextLine() ) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                checkStatistics();
                startMachine();
                break;
            case "take":
                takeMoney();
                checkStatistics();
                startMachine();
                break;
            case "remaining":
                checkStatistics();
                startMachine();
                break;
            case "exit":
                break;
            default:
                startMachine();
        }
    }

    public static void takeMoney() {
        System.out.println("I gave you " + money + "\n");
        money = 0;
    }

    public static void fillMachine() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Write how many ml of water you want to add:\n> ");
        water += scan.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n> ");
        milk += scan.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n> ");
        beans += scan.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add:\n> ");
        cups += scan.nextInt();
    }

    public static void buyCoffee() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:\n> ");
        switch ( scan.nextLine() ) {
            case "1":
                makeEspresso();
                checkStatistics();
                startMachine();
                break;
            case "2":
                makeLatte();
                checkStatistics();
                startMachine();
                break;
            case "3":
                makeCappuccino();
                checkStatistics();
                startMachine();
                break;
            case "back":
                startMachine();
            default:
                startMachine();
        }
    }

    public static void makeEspresso() {
        if( water < 250 || beans < 16 || cups < 1 ) {
            System.out.println("I have enough resources, making you a coffee!");
            startMachine();
        }
        water -= 250;
        beans -= 16;
        money += 4;
        cups -= 1;
    }
    public static void makeLatte() {
        if( water < 350 || beans < 20 || milk < 75 || cups < 1 ) {
            System.out.println("I have enough resources, making you a coffee!");
            startMachine();
        }
        water -= 350;
        milk -= 75;
        beans -= 20;
        money += 7;
        cups -= 1;
    }
    public static void makeCappuccino() {
        if( water < 200 || beans < 12 || milk < 100 || cups < 1 ) {
            System.out.println("I have enough resources, making you a coffee!");
            startMachine();
        }
        water -= 200;
        milk -= 100;
        beans -= 12;
        money += 6;
        cups -= 1;
    }
    /*public static void makeCoffe() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has:\n> ");
        water = scan.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has:\n> ");
        milk = scan.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has:\n> ");
        beans = scan.nextInt();
        System.out.print("Write how many cups of coffee you will need:\n> ");
        cups = scan.nextInt();
        int cWater = water/200;
        int cMilk = milk/50;
        int cBeans = beans/15;
        int[] MinCups = {cWater, cMilk, cBeans};
        Arrays.sort(MinCups);
        int minCup = MinCups[0];
        if(cups == minCup) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            if (cups > minCup) {
                System.out.println("No, I can make only "+ minCup + " cups of coffee.");
            } else {
                if (cups < minCup) {
                    System.out.println("Yes, I can make that amount of coffee (and even " + (minCup - cups) + " more than that)");
                }
            }
        }
    }*/

    public static void checkStatistics() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups +" of disposable cups\n" +
                money + " of money");
    }

    public static void checkQuantity() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Write how many cups of coffe you will need:\n> ");
        int cups = scan.nextInt();
        System.out.println("For " + cups + " cups of coffee you will need:\n" +
                200*cups + " ml of water\n" +
                50*cups + " ml of milk\n" +
                15*cups + " g of coffee beans");
    }

    public static void sendStatus(Stage stage) {
        switch (stage) {
            case START: {
                System.out.println("Starting to make a coffee");
                break;
            }
            case GRIND: {
                System.out.println("Grinding coffe beans");
                break;
            }
            case BOIL: {
                System.out.println("Boiling water");
                break;
            }
            case MIX: {
                System.out.println("Mixing boiled water with crushed coffee beans");
                break;
            }
            case POURCOFFE: {
                System.out.println("Pouring coffee into the cup");
                break;
            }
            case POURMILK: {
                System.out.println("Pouring some milk into the cup");
                break;
            }
            case READY : {
                System.out.println("Coffe is ready!");
                break;
            }
            default: {
                System.out.println("ERROR!!!");
                break;
            }
        }
    }
}
