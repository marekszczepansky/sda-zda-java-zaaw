package sda.szczepanski.java.zaaw.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> language = new HashMap<>();
        language.put("JavaScript", 2);
        language.put("Java", 3);
        language.put("C", 5);
        language.put("Python", 1);
        language.put("C#", 4);

        final Set<String> keySet = language.keySet();
        int toGo = keySet.size();
        for (String key : keySet) {
            final String separator = --toGo == 0 ? "." : ",";
            System.out.println("Klucz: " + key + ", Wartość: " + language.get(key) + separator);
        }

        System.out.println("---");
        final Set<Map.Entry<String, Integer>> entries = language.entrySet();
        entries.forEach(entry -> System.out.println("Klucz: " + entry.getKey() + ", Wartość: " + entry.getValue()));

        System.out.println("---");
        language.forEach((key, value) -> System.out.println("Klucz: " + key + ", Wartość: " + value));

        System.out.println("---lambda---");
        giveEntityString(language, System.out::println);
    }

    private static void giveEntityString(Map<String, Integer> someMap, Consumer<String> consumer) {
        final Set<String> keySet = someMap.keySet();
        for (String key : keySet) {
            final String text = "Klucz: " + key + ", Wartość: " + someMap.get(key);
            consumer.accept(text);
        }


    }


}
