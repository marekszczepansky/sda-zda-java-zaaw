package sda.szczepanski.java.zaaw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Reflections {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        List<Duck> ducks = new ArrayList<>();

        final Duck whiteDuck = new Duck("Biały");
        final Constructor<Duck> constructor = Duck.class.getConstructor(String.class);
        final Duck blackDuck = constructor.newInstance("Czarny");
        ducks.add(whiteDuck);
        ducks.add(blackDuck);

        final Field[] publicFields = Duck.class.getFields();
        for (Field field : publicFields) {
            System.out.println("Public field: " +  field.getName() + ", Type: " + field.getType().getSimpleName());
        }
        System.out.println("---");
        final Field[] declaredFields = Duck.class.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("Declared field: " +  field.getName() + ", Type: " + field.getType().getSimpleName());
        }
        System.out.println("---");
        ducks.forEach(duck -> System.out.println("Kaczka koloru: " + duck.getColour()));

    }
}
