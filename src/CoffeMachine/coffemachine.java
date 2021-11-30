package CoffeMachine;

import java.util.Scanner;

public class coffemachine {
    enum Stage {START, GRIND, BOIL, MIX, POURCOFFE, POURMILK, READY}

    public static void main(String[] args) {
        checkQuantity();
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
