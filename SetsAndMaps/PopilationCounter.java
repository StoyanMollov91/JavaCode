package SetsAndMapsAdvanced;
//The task involves collection of data for countries and cities and their populations.
// At the end, all countries with their total populations (sum of all cities in a country) have to be printed in descending order
// and for each country, all cities have to be printed by their populations in descending order.
//(If two countries or cities have the same number of people, their order of appearance in the input determines
//their printing order.)

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Long>> map = new LinkedHashMap<>();
        String input = scan.nextLine();
      
        while(!input.equals("report")){
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);
            map.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> innerMap = map.get(country);
            innerMap.putIfAbsent(city, 0L);
            innerMap.put(city, innerMap.get(city) + population);
            input = scan.nextLine();
        }
      
        map.entrySet().stream().sorted((e1, e2) -> {
            Map<String, Long> mapFirst = e1.getValue();
            Map<String, Long> mapSecond = e2.getValue();
            long total1 = mapFirst.values().stream().mapToLong(Long::longValue).sum();
            long total2 = mapSecond.values().stream().mapToLong(Long::longValue).sum();
            return Long.compare(total2, total1);
        }).forEach(e -> {
          String country = e.getKey();
          long total = e.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)%n", country, total);
            Map<String, Long> innerMap = e.getValue();
            innerMap.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).
                    forEach(a -> System.out.printf("=>%s: %d%n", a.getKey(), a.getValue()));
        });
    }
}
