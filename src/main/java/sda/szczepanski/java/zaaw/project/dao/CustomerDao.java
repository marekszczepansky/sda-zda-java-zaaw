package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * Interfejs dostępu do bazy obiektów klientów
 * Interfejs jest uzywany przez konsumenta
 * Implementacje można wymieniać zależnie od potrzeb
 * - pamięć
 * - JDBC
 * - Hibernate
 */
public interface CustomerDao extends EntityDao<Customer> {
    List<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);
}
