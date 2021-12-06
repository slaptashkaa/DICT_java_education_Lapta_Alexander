package TicTacToe;

public class TicTacToe {
    public static void main(String[] args) {
        showField();
    }

    public static void showField() {
        String[] field = {"X", "O", "X", "O", "X", "O", "X", "O", "X"};
        System.out.println(field[0] + " " + field[1] + " " + field[2] + "\n" +
                field[3] + " " + field[4] + " " + field[5] + "\n" +
                field[6] + " " + field[7] + " " + field[8]);
    }
}
