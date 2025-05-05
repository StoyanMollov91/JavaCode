package SetsAndMapsAdvanced;
//The task involves collecting data about dragons and their stats. If the same dragon is added twice, the stats should be overridden.
//If a null value is given for a stat, a default value is assigned.
// In the end, dragons should be printed by type in input order (with average stats for each type) and by name alphabetically.
import java.util.*;

public class DragonArmy2 {
    private static class Dragon{
        String name;
        double damage;
        double health;
        double armor;
        public Dragon(String name, String damage, String health, String armor){
            setName(name);
            setDamage(damage);
            setHealth(health);
            setArmor(armor);
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setDamage(String damage) {
            if (damage.equals("null")){
                this.damage = 45;
            }
            else {
                this.damage = Double.parseDouble(damage);
            }
        }
        public void setHealth(String health) {
            if (health.equals("null")){
                this.health = 250;
            }
            else {
                this.health = Double.parseDouble(health);
            }
        }
        public void setArmor(String armor) {
            if (armor.equals("null")){
                this.armor = 10;
            }
            else {
                this.armor = Double.parseDouble(armor);
            }
        }
        public String getName() {
            return name;
        }
        public double getDamage() {
            return damage;
        }
        public double getHealth() {
            return health;
        }
        public double getArmor() {
            return armor;
        }
        public String toString(){
            return String.format("-%s -> damage: %.0f, health: %.0f, armor: %.0f", name, damage, health, armor);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Dragon>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        while(n-- > 0){
            String[] data = scan.nextLine().split("\\s+");
            String type = data[0];
            Dragon dragon = new Dragon(data[1], data[2], data[3], data[4]);
            map.putIfAbsent(type, new ArrayList<>());
            List<Dragon> list = map.get(type);
            list.removeIf(d -> d.getName().equals(data[1]));
            list.add(dragon);
        }
        map.forEach((k, v) -> {
            StringBuilder sb = new StringBuilder();
            double avgDamage = v.stream().mapToDouble(d -> d.getDamage()).average().getAsDouble();
            double avgHealth = v.stream().mapToDouble(d -> d.getHealth()).average().getAsDouble();
            double avgArmor = v.stream().mapToDouble(d -> d.getArmor()).average().getAsDouble();
            sb.append(String.format("%s::(%.2f/%.2f/%.2f)%n", k, avgDamage, avgHealth, avgArmor));
            v.stream().sorted((d1, d2) -> d1.getName().compareTo(d2.getName())).
                    forEach(d -> sb.append(d.toString()).append(System.lineSeparator()));
            System.out.println(sb.toString().trim());
        });

    }
}
