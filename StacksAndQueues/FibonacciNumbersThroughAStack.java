package StacksNQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FibonacciNumbersThroughAStack {
    public static void main(String[] args) {
       //Assuming Fibonacci numbers start from 1
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Deque<Long> fibonacciStack = new ArrayDeque<>();
        fibonacciStack.push(0L);
        fibonacciStack.push(1L);
        if (n < 2){
            System.out.println(1);
            return;
        }
        for (int i = 0; i < n; i++){
            long num1 = fibonacciStack.pop();
            long num2 = fibonacciStack.pop();
            fibonacciStack.push(num1);
            fibonacciStack.push(num1 + num2);
        }
        System.out.println(fibonacciStack.pop());

    }
}
