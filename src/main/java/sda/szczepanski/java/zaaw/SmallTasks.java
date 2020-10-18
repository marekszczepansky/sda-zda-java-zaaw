package sda.szczepanski.java.zaaw;

import java.util.List;

public class SmallTasks {
    public static List<String> alphabeticSort(List<String> inputList){

        return null;
    }

    public static List<String> alphabetZtoACISortedList(List<String> list){
        return list.stream().sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());
    }
}
