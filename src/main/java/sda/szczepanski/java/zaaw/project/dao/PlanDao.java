package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.Package;
import sda.szczepanski.java.zaaw.project.entity.Plan;

import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * Interfejs dostępu do bazy obiektów planów
 * Interfejs jest uzywany przez konsumenta
 * Implementacje można wymieniać zależnie od potrzeb
 * - pamięć
 * - JDBC
 * - Hibernate
 */
public interface PlanDao {
    void create(Plan plan);
    List<Plan> getAll();
    List<Plan> findPlanContainingPackages(Set<Package> packages);
    List<Plan> findPlanForDurationShorterOrEqual(Duration duration);
}
