package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Package;

import java.util.List;

/**
 * Interfejs dostępu do bazy obiektów pakietów
 * Interfejs jest uzywany przez konsumenta
 * Implementacje można wymieniać zależnie od potrzeb
 * - pamięć
 * - JDBC
 * - Hibernate
 */
public interface PackageDao extends EntityDao<Package> {
    List<Package> findPriceLowerOrEqual(double price);
}
