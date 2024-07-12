package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] sorted = new int[100];
        for (int n : numbers){
            sorted[n]++;
        }
        for (int i = 0; i < sorted.length; i++){
            if (sorted[i] != 0){
                for (int j = 0; j < sorted[i]; j++){
                    System.out.print(i + " ");
                }
            }
        }
    }
}
