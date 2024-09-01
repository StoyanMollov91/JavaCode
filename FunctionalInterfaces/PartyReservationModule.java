package FunctionalProgramming;
//The task involves filtering a list of party guests, based on specific predicates. While the input doesn't equal "Print"
//predicates should be added or removed. At the end, guests should be removed, if they match the predicate
//and the final list should be printed. 
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> invitations = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicatesMap = new HashMap<>();
        String input = scan.nextLine();
        while(!input.equals("Print")){
            String[] data = input.split(";");
            String name = "";
            Predicate<String> currentPredicate = null;
            switch (data[1]) {
                case "Starts with" -> {
                    name = "Starts with" + " " + data[2];
                    currentPredicate = s -> s.startsWith(data[2]);
                }
                case "Ends with" -> {
                    name = "Ends with" + " " + data[2];
                    currentPredicate = s -> s.endsWith(data[2]);
                }
                case "Length" -> {
                    name = "Length" + " " + data[2];
                    currentPredicate = s -> s.length() == Integer.parseInt(data[2]);
                }
                case "Contains" -> {
                    name = "Contains" + " " + data[2];
                    currentPredicate = s -> s.contains(data[2]);
                }
            }
            if (data[0].equals("Add filter")){
                predicatesMap.put(name, currentPredicate);
            }
            else{
                predicatesMap.remove(name);
            }
            input = scan.nextLine();
            }

        predicatesMap.forEach((k, v) -> invitations.removeIf(v));
        System.out.println(invitations.toString().replaceAll("[\\[\\],]",  ""));
        }
    }

