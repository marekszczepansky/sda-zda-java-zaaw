package sda.szczepanski.java.zaaw.task1and2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmallTasks {

    public static List<String> alphabetZtoASortedList(List<String> list){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> alphabetZtoACISortedList(List<String> list){
        return list.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());
    }
}
