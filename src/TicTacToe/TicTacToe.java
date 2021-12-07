package TicTacToe;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TicTacToe {
    static String fieldText;
    static char[] field;
    static boolean notFinished;
    static boolean xWin = false;
    static boolean oWin = false;
    static int xSum = 0;
    static int oSum = 0;
    static String coord;
    static boolean impossible = false;

    static StringBuffer letters = new StringBuffer("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm");

    public static void main(String[] args) {
        getFieldText();
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

    public static void getFieldText() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter cells: ");
        fieldText = scan.nextLine();
        if( fieldText.length() != 9) getFieldText();
        for( int i = 0; i < 9; i++ ) {
            if(fieldText.charAt(i) == 'X' ) continue;
            else if (fieldText.charAt(i) == 'O') continue;
            else if (fieldText.charAt(i) == '_') continue;
            else getFieldText();
        }
        field = fieldText.toCharArray();
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

        else if( xWin && oWin){
            System.out.println("Impossible");
            impossible = true;
        }

        for( int i = 0; i < 9; i++) {
            if( field[i] == 'X' && field[i] != '_') {
                xSum++;
            }
            if( field[i] == 'O' && field[i] != '_') {
                oSum++;
            }
        }

        if( oSum > xSum ) {
            if( oSum - xSum >= 2 ) {
                System.out.println("Impossible");
                impossible = true;
            }
        }
        else if( xSum > oSum ) {
            if( xSum - oSum >= 2 ) {
                System.out.println("Impossible");
                impossible = true;
            }
        }

        if ( !xWin && !oWin && !impossible){
            for( int i = 0; i < 9; i++ ) {
                if( field[i] == '_' ) {
                    notFinished = true;
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

        if( xWin ) System.out.println("X wins");
        else if( oWin ) System.out.println("O wins");
    }

    public static void sendCoord(String coord) {
        switch( coord ) {
            case "1 1": {
                if( field[0] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[0] = 'X';
                    showField();
                }
                break;
            }
            case "1 2": {
                if( field[1] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[1] = 'X';
                    showField();
                }
                break;
            }
            case "1 3": {
                if( field[2] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[2] = 'X';
                    showField();
                }
                break;
            }
            case "2 1": {
                if( field[3] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[3] = 'X';
                    showField();
                }
                break;
            }
            case "2 2": {
                if( field[4] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[4] = 'X';
                    showField();
                }
                break;
            }
            case "2 3": {
                if( field[5] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[5] = 'X';
                    showField();
                }
                break;
            }
            case "3 1": {
                if( field[6] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[6] = 'X';
                    showField();
                }
                break;
            }
            case "3 2": {
                if( field[7] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[7] = 'X';
                    showField();
                }
                break;
            }
            case "3 3": {
                if( field[8] != '_' ) {
                    System.out.println("This cell is occupied! Choose another one!");
                    getWinner();
                }
                else {
                    field[8] = 'X';
                    showField();
                }
                break;
            }
            default: showField();
        }
    }
}
