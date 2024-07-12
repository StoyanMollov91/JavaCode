package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    private static int sum(int[] arr, int index){
        if (index == arr.length - 1){
            return arr[arr.length - 1];
        }
        return arr[index] + sum(arr, index + 1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sum(arr, 0));

    }
}
