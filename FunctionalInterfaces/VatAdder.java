package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.Arrays;

public class VatAdder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Prices with VAT:");
        UnaryOperator<String> priceWithVat = s -> String.format("%.2f", Double.parseDouble(s) * 1.2);
        Arrays.stream(scan.nextLine().split(", ")).map(priceWithVat).forEach(System.out::println);
    }
}
