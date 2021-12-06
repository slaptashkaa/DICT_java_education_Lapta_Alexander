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
        System.out.print("Write action (buy, fill, take):\n> ");
        switch ( scan.nextLine() ) {
            case "buy":
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:\n> ");
                switch ( scan.nextInt() ) {
                    case 1:
                        water -= 250;
                        beans -= 16;
                        money += 4;
                        checkStatistics();
                        break;
                    case 2:
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        checkStatistics();
                        break;
                    case 3:
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        money += 6;
                        checkStatistics();
                        break;
                    default:
                        startMachine();
                }
                break;
            case "fill":
                System.out.print("Write how many ml of water you want to add:\n> ");
                water += scan.nextInt();
                System.out.print("Write how many ml of milk you want to add:\n> ");
                milk += scan.nextInt();
                System.out.print("Write how many grams of coffee beans you want to add:\n> ");
                beans += scan.nextInt();
                System.out.print("Write how many disposable coffee cups you want to add:\n> ");
                cups += scan.nextInt();
                checkStatistics();
                break;
            case "take":
                System.out.println("I gave you " + money + "\n");
                money = 0;
                checkStatistics();
                break;
            default:
                startMachine();
        }
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
