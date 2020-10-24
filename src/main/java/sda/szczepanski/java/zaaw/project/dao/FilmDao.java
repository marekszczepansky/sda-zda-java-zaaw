package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.Film;
import sda.szczepanski.java.zaaw.project.entity.Language;

import java.util.List;

public interface FilmDao {
    void create(Film film);
    List<Film> getAll();
    List<Film> findByTitle(String title);
    List<Film> findByLanguage(Language language);
    List<Film> findByPackage(Package aPackage);
    List<Film> findByAgeAndLanguage(AgeCategory ageCategory, Language language);
    List<Film> findByGenre(String genre);
}
