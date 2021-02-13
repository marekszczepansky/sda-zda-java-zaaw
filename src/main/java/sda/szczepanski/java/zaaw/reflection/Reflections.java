package sda.szczepanski.java.zaaw.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        final Method[] methods = Duck.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName() + ", returns: " + method.getReturnType().getSimpleName());
        }

        final List<Method> stringMethodList = Arrays.stream(methods)
                .filter(method -> String.class.equals(method.getReturnType()))
                .collect(Collectors.toList());

        System.out.println("---");
        ducks.forEach(duck -> {
            System.out.println("Kaczka posiada: ");
            stringMethodList.forEach(method -> {
                try {
                    System.out.println(" * " + method.getName() + ": " + method.invoke(duck));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Wywołanie metody " + method.getName() + " nie powiodło się");
                }
            });
        });

    }
}
