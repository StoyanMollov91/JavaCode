package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] tokens = scan.nextLine().split("\\s+");
        for (String token : tokens){
            if (token.charAt(0) >= 48){
                queue.offer(token);
            }
            else if (stack.isEmpty()){
                stack.push(token);
            }
            else {
                if (token.equals("-") || token.equals("+")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        if (stack.peek().equals("/") || stack.peek().equals("*")
                                || stack.peek().equals("-") || stack.peek().equals("+")) {
                            queue.offer(stack.pop());
                        }
                    }
                    stack.push(token);
                }
                else if (token.equals("/") || token.equals("*")){
                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        if (stack.peek().equals("/") || stack.peek().equals("*")){
                            queue.offer(stack.pop());
                        }
                        else{
                            break;
                        }
                    }
                    stack.push(token);
                }
                else if (token.equals("(")){
                    stack.push(token);
                }
                else if (token.equals(")")){
                    while(!stack.isEmpty() && !stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }
}
