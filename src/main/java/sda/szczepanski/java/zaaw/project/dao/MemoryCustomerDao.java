package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.VisibleForTests;
import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MemoryCustomerDao implements CustomerDao {

    @VisibleForTests
    Set<Customer> customerDB = new HashSet<>();

    @Override
    public void create(Customer customer) {
        customerDB.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Customer> findByName(String name) {
        if (name == null) {
            return Collections.emptyList();
        }
        return customerDB.stream()
                .filter(customer -> name.equalsIgnoreCase(customer.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Customer findByEmail(String email) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
