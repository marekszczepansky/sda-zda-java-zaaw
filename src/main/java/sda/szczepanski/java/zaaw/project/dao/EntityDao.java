package sda.szczepanski.java.zaaw.project.dao;

import java.util.List;

/**
 * Interfejs wspólny dla wszystkich interfejsów DAO
 *
 * @param <T> parametr typu generycznego wskazujący jakiego
 *           typu dotyczyć bedzie użycie
 *
 */
public interface EntityDao<T> {
    void create(T customer);
    List<T> getAll();
}
