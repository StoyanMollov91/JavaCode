package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String regex = "(?<name>[A-Za-z\\d!?@$#]+)=(?<length>\\d+)<<(?<geohash>[\\w\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scan.nextLine();
        while(!"Last note".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()){
                String name = matcher.group("name").replaceAll("[!?@$#]", "");
                int length = Integer.parseInt(matcher.group("length"));
                String geohash = matcher.group("geohash");

                if (length == geohash.length()){
                    System.out.printf("Coordinates found! %s -> %s%n", name, geohash);
                }
                else{
                    System.out.println("Nothing found!");
                }
            }
            else{
                System.out.println("Nothing found!");
            }

            input = scan.nextLine();
        }
    }
}
