package sda.szczepanski.java.zaaw.project.dao.memory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MemoryEntityDao<T> {
    protected final Set<T> entityDB;

    public MemoryEntityDao(Set<T> entityDB) {
        this.entityDB = entityDB;
    }

    public void create(T entity) {
        entityDB.add(entity);
    }

    public List<T> getAll() {
        //noinspection SimplifyStreamApiCallChains
        return entityDB.stream().collect(Collectors.toList());
    }
}
