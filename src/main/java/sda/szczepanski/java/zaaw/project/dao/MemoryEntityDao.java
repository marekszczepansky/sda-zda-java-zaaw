package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.VisibleForTests;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class MemoryEntityDao<T> {
    @VisibleForTests
    Set<T> entityDB = new HashSet<>();

    public void create(T entity) {
        entityDB.add(entity);
    }

    public List<T> getAll() {
        return List.copyOf(entityDB);
    }
}
