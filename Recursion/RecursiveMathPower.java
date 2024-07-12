package Algorithms;

import java.util.Scanner;

public class RecursiveMathPower {
    private static double pow(double number, long power){
        if (power == 1){
            return number;
        }
        return number * pow(number, power - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.parseDouble(scan.nextLine());
        long power = Long.parseLong(scan.nextLine());
        System.out.println(pow(number, power));
    }
}
