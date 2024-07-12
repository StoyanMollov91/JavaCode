package AdvancedExamPreparation;
//The task involves two pawns randomly placed on a chessboard. White has the first move. If the pawns intersect diagonally,
//the pawn to move captures and a message with the capture coordinates is printed. Else if they do not intersect diagonally
//at a certain point, the first pawn to reach the last rank is promoted to a queen and an appropriate message with the coordinates
//is printed.
//It is assumed that the pawns always have valid indices in the matrix.
import java.util.Scanner;

public class Pawns {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] board = new String[8][8];
        int whiteRowIndex = 0;
        int whiteColIndex = 0;
        int blackRowIndex = 0;
        int blackColIndex = 0;
        for (int i = 0; i < 8; i++) {
            String input = scan.nextLine();
            if (input.contains("w")){
                whiteRowIndex = i;
                whiteColIndex = input.indexOf("w");
            }
            if (input.contains("b")){
                blackRowIndex = i;
                blackColIndex = input.indexOf("b");
            }
            int start = 97;
            for (int j = 0; j < 8; j++){
                board[7 - i][j] = Character.toString(start) + (i + 1);
                start++;
            }
        }
        int toMeet = board.length - 1 - blackRowIndex - (Math.abs(whiteRowIndex - (board.length - 1)));
        if (Math.abs(whiteColIndex - blackColIndex) > 1 || toMeet <= 0){
            int whiteDistance = board.length - 1 - (Math.abs(whiteRowIndex - (board.length - 1)));
            int blackDistance = board.length - 1 - blackRowIndex;
            if (whiteDistance < blackDistance){
                System.out.printf("Game over! White pawn is promoted to a queen at %s.", board[0][whiteColIndex]);
            }
            else{
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.", board[7][blackColIndex]);
            }
        }
        else{
                int length = Math.abs(whiteRowIndex - blackRowIndex);
                if (length == 1){
                    System.out.printf("Game over! White capture on %s.", board[blackRowIndex][blackColIndex]);
                }
                else{
                    int whiteMoves = 0;
                    int blackMoves = 0;
                    int count = 0;
                    while (length > 1){
                        if (count % 2 == 0){
                            whiteMoves++;
                            whiteRowIndex--;
                        }
                        else{
                            blackMoves++;
                            blackRowIndex++;
                        }
                        count++;
                        length--;
                    }
                    if (whiteMoves - blackMoves == 0){
                        System.out.printf("Game over! White capture on %s.", board[blackRowIndex][blackColIndex]);
                    }
                    else{
                        System.out.printf("Game over! Black capture on %s.", board[whiteRowIndex][whiteColIndex]);
                    }
                }
        }
    }
}
