package sda.szczepanski.java.zaaw.project;

import sda.szczepanski.java.zaaw.project.dao.CustomerDao;
import sda.szczepanski.java.zaaw.project.dao.FilmDao;
import sda.szczepanski.java.zaaw.project.di.Context;
import sda.szczepanski.java.zaaw.project.entity.type.AgeCategory;
import sda.szczepanski.java.zaaw.project.entity.Customer;
import sda.szczepanski.java.zaaw.project.entity.type.Language;

import static sda.szczepanski.java.zaaw.project.entity.Film.FilmBuilder.aFilm;

public class MainProgram {

    private static final Context context = Context.getInstance();
    private static final CustomerDao customerDao = context.getDaoImplementation(CustomerDao.class);
    private static final FilmDao filmDao = context.getDaoImplementation(FilmDao.class);

    public static void main(String[] args) {
        System.out.println("Witam na zajęciach java zaawansowana - programowanie");
        System.out.println("Grupa ZDJAVApol33");
        System.out.println("Pracujemy na branch zgodnym z nazwą grupy");
        System.out.println("Testujemy sobie patch");

        Customer customer = new Customer("P1", "Jarosław Dudek", "jarek@dudek.home", 43, null);
        customerDao.create(customer);

        System.out.println("Lista klientów");
        System.out.println(customerDao.getAll());

        filmDao.create(aFilm()
                .withTitle("Roszpunka")
                .withAgeCategory(AgeCategory.CHILD)
                .withLanguages(Language.ENGLISH, Language.POLISH)
                .withGenre("Bajka")
                .withProductionCountry("USA")
                .withYear(2010)
                .build()
        );
        System.out.println("Lista filmów");
        System.out.println(filmDao.getAll());

    }
}
