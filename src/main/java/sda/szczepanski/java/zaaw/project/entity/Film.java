package sda.szczepanski.java.zaaw.project.entity;

import sda.szczepanski.java.zaaw.project.entity.type.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.type.Language;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Film {
    private String title;
    private int year;
    private AgeCategory ageCategory;
    private String genre;
    private String productionCountry;
    private List<Language> languages;
    private Package aPackage;

    public Film(String title, int year, AgeCategory ageCategory, String genre, String productionCountry, List<Language> languages, Package aPackage) {
        this.title = title;
        this.year = year;
        this.ageCategory = ageCategory;
        this.genre = genre;
        this.productionCountry = productionCountry;
        this.languages = languages;
        this.aPackage = aPackage;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public String getGenre() {
        return genre;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public Package getaPackage() {
        return aPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return year == film.year &&
                Objects.equals(title, film.title) &&
                ageCategory == film.ageCategory &&
                Objects.equals(genre, film.genre) &&
                Objects.equals(productionCountry, film.productionCountry) &&
                Objects.equals(languages, film.languages) &&
                Objects.equals(aPackage, film.aPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, ageCategory, genre, productionCountry, languages, aPackage);
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", ageCategory=" + ageCategory +
                '}';
    }

    public static final class FilmBuilder {
        private String title;
        private int year;
        private AgeCategory ageCategory;
        private String genre;
        private String productionCountry;
        private List<Language> languages;
        private Package aPackage;

        private FilmBuilder() {
        }

        public static FilmBuilder aFilm() {
            return new FilmBuilder();
        }

        public FilmBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public FilmBuilder withYear(int year) {
            this.year = year;
            return this;
        }

        public FilmBuilder withAgeCategory(AgeCategory ageCategory) {
            this.ageCategory = ageCategory;
            return this;
        }

        public FilmBuilder withGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public FilmBuilder withProductionCountry(String productionCountry) {
            this.productionCountry = productionCountry;
            return this;
        }

        public FilmBuilder withLanguages(List<Language> languages) {
            this.languages = languages;
            return this;
        }

        public FilmBuilder withLanguages(Language... languages) {
            this.languages = Arrays.asList(languages);
            return this;
        }

        public FilmBuilder withAPackage(Package aPackage) {
            this.aPackage = aPackage;
            return this;
        }

        public Film build() {
            return new Film(title, year, ageCategory, genre, productionCountry, languages, aPackage);
        }
    }
}
