package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Package;

import java.util.List;

public interface PackageDao {
    void create(Package aPackage);
    List<Package> getAll();
    List<Package> findPriceLowerOrEqual(double price);
}
