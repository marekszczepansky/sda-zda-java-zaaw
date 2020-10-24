package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Package;
import sda.szczepanski.java.zaaw.project.entity.Plan;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public interface PlanDao {
    void create(Plan plan);
    List<Plan> getAll();
    List<Plan> findPlanContainingPackages(Set<Package> packages);
    List<Plan> findPlanForDurationShorterOrEqual(Duration duration);
}
