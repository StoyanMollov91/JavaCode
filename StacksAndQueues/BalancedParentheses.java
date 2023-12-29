package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BalancedParentheses {
    static boolean isBalanced (List<String> list){
        ArrayDeque<String> openParentheses = new ArrayDeque<>();
        String openBrace = "";
        for (String string : list){
            switch (string){
                case "}":
                    if (openParentheses.isEmpty()){
                        return false;
                    }
                    openBrace = openParentheses.pop();
                    if (!openBrace.equals("{"))
                        return false;
                    break;
                case "]":
                    if (openParentheses.isEmpty()){
                        return false;
                    }
                    openBrace = openParentheses.pop();
                    if (!openBrace.equals("["))
                        return false;
                    break;
                case ")":
                    if (openParentheses.isEmpty()){
                        return false;
                    }
                    openBrace = openParentheses.pop();
                    if (!openBrace.equals("("))
                        return false;
                    break;
                default:
                    openParentheses.push(string);
                    break;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("")).collect(Collectors.toList());
        String result = isBalanced(input) ? "YES" : "NO";
        System.out.println(result);
    }
}
