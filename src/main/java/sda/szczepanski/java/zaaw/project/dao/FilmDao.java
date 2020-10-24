package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.Film;
import sda.szczepanski.java.zaaw.project.entity.Package;
import sda.szczepanski.java.zaaw.project.entity.Language;

import java.util.List;

/**
 * Interfejs dostępu do bazy obiektów filmy
 * Interfejs jest uzywany przez konsumenta
 * Implementacje można wymieniać zależnie od potrzeb
 * - pamięć
 * - JDBC
 * - Hibernate
 */
public interface FilmDao extends EntityDao<Film> {
    List<Film> findByTitle(String title);
    List<Film> findByLanguage(Language language);
    List<Film> findByPackage(Package aPackage);
    List<Film> findByAgeAndLanguage(AgeCategory ageCategory, Language language);
    List<Film> findByGenre(String genre);
}
