package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<Customer>%[A-Z][a-z]+%)([^\\$\\%\\.\\|]*)(?<Product><\\w+>)([^\\$\\%\\.\\|]*)(?<Count>\\|\\d+\\|)([^\\$\\%\\.\\|0-9])*(?<Price>(\\d+\\$)|(\\d+\\.\\d+\\$))";
        Pattern pattern = Pattern.compile(regex);
        String input = scan.nextLine();
        double totalIncome = 0;
        while(!input.equals("end of shift")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                double count = Double.parseDouble(matcher.group("Count").replaceAll("\\|", ""));
                double price = Double.parseDouble(matcher.group("Price").replaceAll("\\$", ""));
                double total = count * price;
                String customer = matcher.group("Customer").replaceAll("%", "");
                String product = matcher.group("Product").replaceAll("[<>]","");
                System.out.printf("%s: %s - %.2f%n", customer, product, total);
                totalIncome += total;
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
