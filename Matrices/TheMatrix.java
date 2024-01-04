package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;
//The task involves changing a character at a specified starting position to another character and then changing all adjacent characters
//equal to the original character to the new character. This excludes diagonally adjacent matrix cells.
//This resembles the fill tool in MS Paint.
public class TheMatrix {
    private static void fill(String[][] matrix, String fillChar, String startChar, int row, int col){
        int up = row - 1;
        int down = row + 1;
        int left = col - 1;
        int right = col + 1;
        matrix[row][col] = fillChar;
        if (inBounds(matrix, up, col) && matrix[up][col].equals(startChar)){
            matrix[up][col] = fillChar;
            fill(matrix, fillChar, startChar, up, col);
        }
        if (inBounds(matrix, down, col) && matrix[down][col].equals(startChar)){
            matrix[down][col] = fillChar;
            fill(matrix, fillChar, startChar, down, col);
        }
        if (inBounds(matrix, row, left) && matrix[row][left].equals(startChar)){
            matrix[row][left] = fillChar;
            fill(matrix, fillChar, startChar, row, left);
        }
        if (inBounds(matrix, row, right) && matrix[row][right].equals(startChar)){
            matrix[row][right] = fillChar;
            fill(matrix, fillChar, startChar, row, right);
        }
    }
    private static boolean inBounds(String[][] matrix, int row, int col){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
    private static void printMatrix(String[][] matrix){
        for (String[] arr : matrix){
            for (String str : arr){
                System.out.print(str);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = arr[0];
        int cols = arr[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++){
            matrix[i] = scan.nextLine().split("\\s+");
        }
        String fillChar = scan.nextLine();
        int[] position = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = position[0];
        int col = position[1];
        String startChar = matrix[row][col];
        fill(matrix, fillChar, startChar, row, col);
        printMatrix(matrix);

    }
}
