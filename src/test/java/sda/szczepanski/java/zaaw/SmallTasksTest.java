package sda.szczepanski.java.zaaw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmallTasksTest {

    @Test
    void shouldAlphabeticSortList() {
        List<String> givenList = Arrays.asList("Marek", "Agata", "Tomek", "przemek");
        List<String> expectedResult = Arrays.asList("przemek", "Tomek", "Marek", "Agata");

        final List<String> resultList = SmallTasks.alphabetZtoASortedList(givenList);

        assertEquals(expectedResult, resultList);
    }

    @Test
    void shouldAlphabeticCISortList() {
        List<String> givenList = Arrays.asList("Marek", "Agata", "Tomek", "przemek");
        List<String> expectedResult = Arrays.asList("Tomek", "przemek", "Marek", "Agata");

        final List<String> resultList = SmallTasks.alphabetZtoACISortedList(givenList);

        assertEquals(expectedResult, resultList);
    }
}
