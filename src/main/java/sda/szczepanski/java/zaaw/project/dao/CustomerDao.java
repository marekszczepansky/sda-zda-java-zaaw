package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.List;

public interface CustomerDao {
    void create(Customer customer);
    List<Customer> getAll();
    List<Customer> findByName(String name);
    Customer findByEmail(String email);
}
