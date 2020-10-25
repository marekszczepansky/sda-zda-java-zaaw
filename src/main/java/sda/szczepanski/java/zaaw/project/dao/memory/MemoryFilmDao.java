package sda.szczepanski.java.zaaw.project.dao.memory;

import sda.szczepanski.java.zaaw.project.dao.FilmDao;
import sda.szczepanski.java.zaaw.project.entity.type.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.Film;
import sda.szczepanski.java.zaaw.project.entity.Package;
import sda.szczepanski.java.zaaw.project.entity.type.Language;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MemoryFilmDao extends MemoryEntityDao<Film> implements FilmDao {

    public MemoryFilmDao(Set<Film> entityDB) {
        super(entityDB);
    }

    @Override
    public List<Film> findByTitle(String title) {
        if (title == null) {
            return Collections.emptyList();
        }
        return entityDB.stream()
                .filter(film -> title.equalsIgnoreCase(film.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> findByLanguage(Language language) {
        if (language == null) {
            return Collections.emptyList();
        }
        return entityDB.stream()
                .filter(film -> film.getLanguages().contains(language))
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> findByPackage(Package aPackage) {
        if (aPackage == null) {
            return Collections.emptyList();
        }
        return entityDB.stream()
                .filter(film -> aPackage.equals(film.getaPackage()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> findByAgeAndLanguage(AgeCategory ageCategory, Language language) {
        if (ageCategory == null || language == null) {
            return Collections.emptyList();
        }

        return entityDB.stream()
                .filter(film -> ageCategory.equals(film.getAgeCategory()) && film.getLanguages().contains(language))
                .collect(Collectors.toList());
    }

    @Override
    public List<Film> findByGenre(String genre) {
        if (genre == null) {
            return Collections.emptyList();
        }
        return entityDB.stream()
                .filter(film -> genre.equalsIgnoreCase(film.getGenre()))
                .collect(Collectors.toList());
    }
}
