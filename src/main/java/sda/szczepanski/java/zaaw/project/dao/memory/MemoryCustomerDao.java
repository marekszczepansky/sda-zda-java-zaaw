package sda.szczepanski.java.zaaw.project.dao.memory;

import sda.szczepanski.java.zaaw.project.dao.CustomerDao;
import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementacja {@link CustomerDao} z uzyciem {@link HashSet}
 * przechowującego dane w pamięci
 */
public class MemoryCustomerDao extends MemoryEntityDao<Customer> implements CustomerDao {

    public MemoryCustomerDao(Set<Customer> entityDB) {
        super(entityDB);
    }

    @Override
    public List<Customer> findByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        return entityDB.stream()
                .filter(customer -> name.equalsIgnoreCase(customer.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        if (email == null) {
            return Optional.empty();
        }
        return entityDB.stream()
                .filter(customer -> email.equalsIgnoreCase(customer.getEmail()))
                .findFirst();
    }
}
