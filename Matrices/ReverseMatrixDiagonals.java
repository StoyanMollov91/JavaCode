package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//The task involves printing each diagonal in the matrix starting from the lower right corner of the matrix and ending at its top left corner.
public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            matrix[i] = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int startCol = cols - 1;
        int endCol = startCol;
        int startRow = rows - 1;
        int row = startRow;
        while (startCol >= 0){
            for (int i = startCol; i <= endCol; i++){
                if (row >= 0) {
                    System.out.print(matrix[row--][i] + " ");
                }
            }
            System.out.println();
            if (row == -1){
                endCol--;
            }
            row = startRow;
            startCol--;
        }
        row = startRow - 1;
        while (row >= 0) {
            if (row < endCol){
                endCol--;
            }
            int index = row;
            for (int i = 0; i <= endCol; i++) {
                System.out.print(matrix[index--][i] + " ");
                }
            System.out.println();
            row--;
            }
        }
    }

