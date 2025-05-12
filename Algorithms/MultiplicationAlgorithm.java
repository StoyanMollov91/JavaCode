package Algorithms2;

import java.util.Scanner;
import java.util.Arrays;

public class MultiplicationAlgorithm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToLong(l -> Long.parseLong(l)).toArray();
        long a = arr[0];
        long b = arr[1];
        System.out.println(multiply(a, b));
    }
    public static long multiply(long a, long b){
        long c = 0;
        while (a > 0){
            c = c + b;
            a = a - 1;
        }
        return c;
    }
}
