package Algorithms;

import java.util.Scanner;

public class RecursiveFactorial {
    private static long factorial(int n){
        if (n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(factorial(n));
    }
}
