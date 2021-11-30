package CoffeMachine;

public class coffemachine {
    enum Stage {START, GRIND, BOIL, MIX, POURCOFFE, POURMILK, READY}

    public static void main(String[] args) {
        sendStatus(Stage.START);
        sendStatus(Stage.GRIND);
        sendStatus(Stage.BOIL);
        sendStatus(Stage.MIX);
        sendStatus(Stage.POURCOFFE);
        sendStatus(Stage.POURMILK);
        sendStatus(Stage.READY);
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
