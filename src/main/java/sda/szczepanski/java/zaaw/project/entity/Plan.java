package sda.szczepanski.java.zaaw.project.entity;

import java.time.Duration;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plan {
    private String name;
    private Set<Package> packages = new HashSet<>();
    private Duration duration;

    public Plan(String name, Duration duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Set<Package> getPackages() {
        return packages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(name, plan.name) &&
                Objects.equals(packages, plan.packages) &&
                Objects.equals(duration, plan.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, packages, duration);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}
