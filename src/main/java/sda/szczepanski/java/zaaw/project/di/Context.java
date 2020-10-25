package sda.szczepanski.java.zaaw.project.di;

import sda.szczepanski.java.zaaw.project.dao.MemoryCustomerDao;
import sda.szczepanski.java.zaaw.project.dao.MemoryFilmDao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Context {

    private static final Context INSTANCE = new Context();
    private static final Map<Class<?>, Object> components = new HashMap<>();

    private Context() {
    }

    public static Context getInstance() {
        return INSTANCE;
    }

    public <K> K getDaoImplementation(Class<K> daoInterface) {
        if (daoInterface.isAssignableFrom(MemoryFilmDao.class)) {
            //noinspection unchecked
            return (K) components
                    .computeIfAbsent(daoInterface, aClass -> new MemoryFilmDao(new HashSet<>()));
        }
        if (daoInterface.isAssignableFrom(MemoryCustomerDao.class)) {
            //noinspection unchecked
            return (K) components
                    .computeIfAbsent(daoInterface, aClass -> new MemoryCustomerDao(new HashSet<>()));
        }
        return null;
    }
}
