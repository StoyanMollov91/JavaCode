package Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<String> furniture = new ArrayList<>();
        double totalPrice = 0;
        String regex = ">>(?<Name>[A-Za-z]+)<<(?<Price>\\d+|\\d+\\.\\d+)!(?<Quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        while(!input.equals("Purchase")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                furniture.add(matcher.group("Name"));
                totalPrice += Double.parseDouble(matcher.group("Price")) * Integer.parseInt(matcher.group("Quantity"));
            }
            input = scan.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
