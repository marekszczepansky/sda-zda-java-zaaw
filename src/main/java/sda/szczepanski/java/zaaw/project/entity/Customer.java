package sda.szczepanski.java.zaaw.project.entity;

import java.util.Objects;

public class Customer {
    private String id;
    private String name;
    private String email;
    private int age;
    private Plan plan;

    public Customer(String id, String name, String email, int age, Plan plan) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.plan = plan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age &&
                Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(plan, customer.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age, plan);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", plan=" + plan +
                '}';
    }
}
