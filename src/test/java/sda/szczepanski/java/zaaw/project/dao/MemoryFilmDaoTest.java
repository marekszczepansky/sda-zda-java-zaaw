package sda.szczepanski.java.zaaw.project.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.szczepanski.java.zaaw.project.dao.memory.MemoryFilmDao;
import sda.szczepanski.java.zaaw.project.entity.Film;
import sda.szczepanski.java.zaaw.project.entity.type.Language;
import sda.szczepanski.java.zaaw.project.entity.Package;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static sda.szczepanski.java.zaaw.project.entity.type.AgeCategory.CHILD;
import static sda.szczepanski.java.zaaw.project.entity.type.AgeCategory.PLUS16;
import static sda.szczepanski.java.zaaw.project.entity.type.Language.CHINA;
import static sda.szczepanski.java.zaaw.project.entity.type.Language.ENGLISH;
import static sda.szczepanski.java.zaaw.project.entity.type.Language.GERMAN;
import static sda.szczepanski.java.zaaw.project.entity.type.Language.POLISH;

@ExtendWith(MockitoExtension.class)
class MemoryFilmDaoTest {

    public static final String TEST_TITLE = "test title 2";
    public static final Language TEST_LANGUAGE = POLISH;
    public static final String TEST_GENRE = "test genre 3";
    public static final Package TEST_PACKAGE_1 = mock(Package.class);
    public static final Package TEST_PACKAGE_2 = mock(Package.class);
    public static final Film TEST_FILM_1 = new Film(
            "test title 1",
            1999,
            CHILD,
            "test genre 1",
            "test country 1",
            List.of(ENGLISH, TEST_LANGUAGE),
            TEST_PACKAGE_1
    );
    public static final Film TEST_FILM_2 = new Film(
            TEST_TITLE,
            2020,
            CHILD,
            "test genre 2",
            "test country 2",
            List.of(TEST_LANGUAGE, GERMAN),
            TEST_PACKAGE_2
    );
    public static final Film TEST_FILM_3 = new Film(
            "test title 3",
            2020,
            PLUS16,
            TEST_GENRE,
            "test country 3",
            List.of(TEST_LANGUAGE),
            TEST_PACKAGE_1
    );
    public static final Film TEST_FILM_4 = new Film(
            "test title 4",
            2020,
            PLUS16,
            "test genre 4",
            "test country 4",
            List.of(CHINA, ENGLISH),
            TEST_PACKAGE_2
    );
    private FilmDao filmDao;
    @Mock
    private Set<Film> mockFilmDb;
    private Set<Film> internalFilmDB;
    @InjectMocks
    MemoryFilmDao memoryFilmDao;

    @BeforeEach
    void setUp() {
        internalFilmDB = new HashSet<>();
        internalFilmDB.add(TEST_FILM_1);
        internalFilmDB.add(TEST_FILM_2);
        internalFilmDB.add(TEST_FILM_3);
        internalFilmDB.add(TEST_FILM_4);
        lenient().when(mockFilmDb.stream()).thenReturn(internalFilmDB.stream());

        filmDao = memoryFilmDao;
    }

    @Test
    void shouldCreate() {
        Film newFilm = mock(Film.class);

        filmDao.create(newFilm);

        verify(mockFilmDb, times(1)).add(newFilm);
    }

    @Test
    void shouldGetAll() {

        final List<Film> allFilms = filmDao.getAll();

        assertEquals(internalFilmDB.size(), allFilms.size());
        assertTrue(allFilms.containsAll(internalFilmDB));
    }

    @Test
    void shouldFindByTitle() {

        final List<Film> filmDaoByTitle = filmDao.findByTitle(TEST_TITLE);

        assertEquals(1, filmDaoByTitle.size());
        assertEquals(TEST_FILM_2, filmDaoByTitle.get(0));
    }

    @Test
    void shouldFindByLanguage() {
        final List<Film> expectedFilms = Arrays.asList(TEST_FILM_1, TEST_FILM_2, TEST_FILM_3);

        final List<Film> filmDaoByLanguage = filmDao.findByLanguage(TEST_LANGUAGE);

        assertListsIgnoreOrder(expectedFilms, filmDaoByLanguage);
    }

    @Test
    void shouldFindByPackage() {
        final List<Film> expectedFilms = Arrays.asList(TEST_FILM_2, TEST_FILM_4);

        final List<Film> filmDaoByPackage = filmDao.findByPackage(TEST_PACKAGE_2);

        assertListsIgnoreOrder(expectedFilms, filmDaoByPackage);
    }

    @Test
    void shouldFindByAgeAndLanguage() {
        final List<Film> expectedFilms = Arrays.asList(TEST_FILM_1, TEST_FILM_2);

        final List<Film> filmDaoByAgeAndLanguage = filmDao.findByAgeAndLanguage(CHILD, POLISH);

        assertListsIgnoreOrder(expectedFilms, filmDaoByAgeAndLanguage);
    }

    @Test
    void shouldFindByGenre() {
        final List<Film> expectedFilms = Collections.singletonList(TEST_FILM_3);

        final List<Film> filmDaoByGenre = filmDao.findByGenre(TEST_GENRE);

        assertListsIgnoreOrder(expectedFilms, filmDaoByGenre);
    }

    private void assertListsIgnoreOrder(List<Film> expectedFilms, List<Film> actualFilms) {
        assertEquals(expectedFilms.size(), actualFilms.size());
        assertTrue(expectedFilms.containsAll(actualFilms));
    }
}
