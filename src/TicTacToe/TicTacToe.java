package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static String fieldText = "_________";
    static char[] field = fieldText.toCharArray();
    static boolean notFinished;
    static boolean xWin = false;
    static boolean oWin = false;
    static String coord;
    static boolean xTurn = false;
    static int sumNotFinished = 0;

    static StringBuffer letters = new StringBuffer("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm");

    public static void main(String[] args) {
        showField();
        getWinner();
    }

    public static void showField() {
        System.out.println("-----------");
        System.out.println("|  " + field[0] + " " + field[1] + " " + field[2] + "  |" + "\n" +
                "|  " + field[3] + " " + field[4] + " " + field[5] + "  |" + "\n" +
                "|  " + field[6] + " " + field[7] + " " + field[8] + "  |");
        System.out.println("-----------");
    }

    public static void setWinner(char winner) {
        switch ( winner ){
            case 'X': {
                xWin = true;
                break;
            }
            case 'O': {
                oWin = true;
                break;
            }
        }
    }

    public static void getWinner() {
        if( field[0] == 'X' && field[3] == 'X' && field[6] == 'X') setWinner('X');
        else if( field[0] == 'X' && field[1] == 'X' && field[2] == 'X') setWinner('X');
        else if( field[3] == 'X' && field[4] == 'X' && field[5] == 'X') setWinner('X');
        else if( field[6] == 'X' && field[7] == 'X' && field[8] == 'X') setWinner('X');
        else if( field[1] == 'X' && field[4] == 'X' && field[7] == 'X') setWinner('X');
        else if( field[2] == 'X' && field[5] == 'X' && field[8] == 'X') setWinner('X');
        else if( field[0] == 'X' && field[4] == 'X' && field[8] == 'X') setWinner('X');
        else if( field[2] == 'X' && field[4] == 'X' && field[6] == 'X') setWinner('X');

        if( field[0] == 'O' && field[3] == 'O' && field[6] == 'O') setWinner('O');
        else if( field[0] == 'O' && field[1] == 'O' && field[2] == 'O') setWinner('O');
        else if( field[3] == 'O' && field[4] == 'O' && field[5] == 'O') setWinner('O');
        else if( field[6] == 'O' && field[7] == 'O' && field[8] == 'O') setWinner('O');
        else if( field[1] == 'O' && field[4] == 'O' && field[7] == 'O') setWinner('O');
        else if( field[2] == 'O' && field[5] == 'O' && field[8] == 'O') setWinner('O');
        else if( field[0] == 'O' && field[4] == 'O' && field[8] == 'O') setWinner('O');
        else if( field[2] == 'O' && field[4] == 'O' && field[6] == 'O') setWinner('O');

        if ( !xWin && !oWin){
            sumNotFinished = 0;
            for( int i = 0; i < 9; i++ ) {
                if( field[i] == '_' ) {
                    notFinished = true;
                }
                else {
                    sumNotFinished++;
                    if( sumNotFinished >= 9 ) notFinished = false;
                }
            }

            if( notFinished ) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");
                coord = scan.nextLine();
                if( coord.contains("1 1") || coord.contains("1 2") || coord.contains("1 3")
                || coord.contains("2 1") || coord.contains("2 2") || coord.contains("2 3")
                || coord.contains("3 1") || coord.contains("3 2") || coord.contains("3 3") ) {
                    sendCoord(coord);
                }

                else if ( letters.indexOf(coord) != -1 )  {
                    System.out.println("You should enter numbers!");
                    getWinner();
                }

                else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    getWinner();
                }
            }
            else System.out.println("Draw");
        }
        else if( xWin ) System.out.println("X wins");
        else if( oWin ) System.out.println("O wins");
    }

    public static char getTurn() {
        if( xTurn ) {
            xTurn = false;
            return 'O';
        }
        else {
            xTurn = true;
            return 'X';
        }
    }

    public static void sendCoord(String coord) {
        switch( coord ) {
            case "1 1": {
                if( field[0] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[0] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "1 2": {
                if( field[1] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[1] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "1 3": {
                if( field[2] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[2] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "2 1": {
                if( field[3] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[3] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "2 2": {
                if( field[4] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[4] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "2 3": {
                if( field[5] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[5] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "3 1": {
                if( field[6] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[6] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "3 2": {
                if( field[7] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[7] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            case "3 3": {
                if( field[8] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[8] = getTurn();
                    showField();
                    getWinner();
                    break;
                }
                break;
            }
            default: showField();
        }
    }
}
