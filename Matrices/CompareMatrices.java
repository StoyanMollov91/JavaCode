package MultidimensionalArrays;

import java.util.Scanner;
import java.util.Arrays;

public class CompareMatrices {
    static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix){
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++){
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++){
                if (firstMatrix[row][col] != secondMatrix[row][col]){
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] firstDimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstMatrixRows = firstDimensions[0];
        int firstMatrixCols = firstDimensions[1];
        int[][] firstMatrix = new int [firstMatrixRows][firstMatrixCols];
        for (int i = 0; i < firstMatrixRows; i++){
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }
        int[] secondDimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRows = secondDimensions[0];
        int secondMatrixCols = secondDimensions[1];
        int[][] secondMatrix = new int [secondMatrixRows][secondMatrixCols];
        for (int i = 0; i < secondMatrixRows; i++){
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }
        if (matricesAreEqual(firstMatrix, secondMatrix)){
            System.out.println("equal");
        }
        else{
            System.out.println("not equal");
        }
    }
}
