package sda.szczepanski.java.zaaw.project.dao;

import sda.szczepanski.java.zaaw.project.entity.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.Film;
import sda.szczepanski.java.zaaw.project.entity.Package;
import sda.szczepanski.java.zaaw.project.entity.Language;

import java.util.List;

public class MemoryFilmDao extends MemoryEntityDao<Film> implements FilmDao {
    @Override
    public List<Film> findByTitle(String title) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Film> findByLanguage(Language language) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Film> findByPackage(Package aPackage) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Film> findByAgeAndLanguage(AgeCategory ageCategory, Language language) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<Film> findByGenre(String genre) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
