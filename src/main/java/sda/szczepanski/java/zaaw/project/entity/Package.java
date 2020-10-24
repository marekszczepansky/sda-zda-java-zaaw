package sda.szczepanski.java.zaaw.project.entity;

import java.util.Objects;

public class Package {
    private String name;
    private double price;

    public Package(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Double.compare(aPackage.price, price) == 0 &&
                Objects.equals(name, aPackage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
