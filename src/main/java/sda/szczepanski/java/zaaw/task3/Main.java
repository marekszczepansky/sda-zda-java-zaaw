package sda.szczepanski.java.zaaw.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> language = new HashMap<>();
        language.put("JavaScript", 2);
        language.put("Java", 3);
        language.put("C", 5);
        language.put("Python", 1);
        language.put("C#", 4);

        final Set<String> keySet = language.keySet();
        for (String key : keySet) {
            System.out.println("Klucz: " + key + ", Wartość: " + language.get(key));
        }


    }
}
