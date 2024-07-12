package StacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci {
    static long[] memory;
    static long fib (int n){
        if (n < 2){
            return 1;
        }
        if (memory[n] != 0){
            return memory[n];
        }
        memory[n] = fib(n - 1) + fib(n - 2);
        return memory[n];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        memory = new long[n + 1];
        long result = fib(n);
        System.out.println(result);//1 1 2 3 5 8

    }
}
