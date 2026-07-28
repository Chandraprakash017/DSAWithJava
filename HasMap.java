import java.util.HashMap;

public class HasMap {
    public static void main(String[] args) {
        HashMap<String, Integer> ages = new HashMap<>();

        ages.put("Raj", 250);
        ages.put("Raja", 300);
        ages.put("Ram", 350);

        System.out.println(ages);
        System.out.println(ages.get("Raja"));

        ages.remove("Ram");
        System.out.println(ages.containsKey("Raj"));

        String[] names = {"Raj", "Raja", "Raj", "Ram", "Raja"};
        HashMap<String, Integer> freq = new HashMap<>();

        for (String name : names) {
            if (freq.containsKey(name)) {
                freq.put(name, freq.get(name) + 1);
            } else {
                freq.put(name, 1);
            }
        }

        System.out.println(freq);
    }
}
