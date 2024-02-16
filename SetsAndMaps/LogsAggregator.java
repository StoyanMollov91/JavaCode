package SetsAndMapsAdvanced;
//The task involves aggregation of user login data. The input consists of strings in the format
// "IP user duration". In the end, the data for each user should be printed in the format
//"user: totalDurationOfAllLogins [IP1, IP2...]"
//The input consists of n lines.
//The users and IPs need to be ordered alphabetically.
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        int n = Integer.parseInt(scan.nextLine());
        
        while (n-- > 0){
            String[] data = scan.nextLine().split("\\s+");
            String IP = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);
            users.putIfAbsent(user, new TreeMap<>());
            Map<String, Integer> innerMap = users.get(user);
            innerMap.putIfAbsent(IP, 0);
            innerMap.put(IP, innerMap.get(IP) + duration);
        }

        users.forEach((key, value) -> {
            int sum = value.values().stream().mapToInt(Integer::intValue).sum();
            String IPs = value.keySet().toString();
            System.out.printf("%s: %d %s%n", key, sum, IPs);
        });
    }

}
