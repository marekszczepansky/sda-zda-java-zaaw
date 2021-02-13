package sda.szczepanski.java.zaaw.project.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sda.szczepanski.java.zaaw.project.dao.memory.MemoryCustomerDao;
import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Test testujący implementację {@link CustomerDao} poprzez klasę {@link MemoryCustomerDao}
 */
@ExtendWith(MockitoExtension.class)
class MemoryCustomerDaoTest {

    public static final String TEST_NAME = "Marek Szczepański";
    public static final Customer TEST_CUSTOMER_1 = new Customer("1", TEST_NAME, "marek@sda.test", 18, null);
    public static final String TEST_EMAIL = "tomasz@sda.test";
    public static final Customer TEST_CUSTOMER_2 = new Customer("2", "Tomasz Wojtkowiak", TEST_EMAIL, 13, null);
    public static final Customer TEST_CUSTOMER_3 = new Customer("3", TEST_NAME, "marek2@sda.test", 35, null);

    /**
     * Mockowanie w tym miejscu do celów dydaktycznych
     * zastępuje przypisanie <code>mock(Customer.class)</code>
     */
    @Mock
    private Customer customerMock;

    @Mock
    private Set<Customer> customerDb;
    private Set<Customer> internalCustomerDb;
    /**
     * dostęp bezpośredni do implementacji
     * {@link InjectMocks} zapewnia wywołanie konstruktora z mockiem atrybutu
     * <br><code>memoryCustomerDao = new MemoryCustomerDao(customerDb)</code>
     */
    @InjectMocks
    private MemoryCustomerDao memoryCustomerDao;

    /**
     * dostęp do testowanej implementacji poprzez interfejs (widoczne metody publiczne)
     */
    private CustomerDao customerDao;

    /**
     * Stworzenie testowej bazy danych
     */
    @BeforeEach
    void setUp() {
        internalCustomerDb = new HashSet<>();
        internalCustomerDb.add(TEST_CUSTOMER_1);
        internalCustomerDb.add(TEST_CUSTOMER_2);
        internalCustomerDb.add(TEST_CUSTOMER_3);

        lenient().when(customerDb.stream()).thenReturn(internalCustomerDb.stream());

        customerDao = memoryCustomerDao;
    }

    @Test
    void shouldCreateCustomer() {

        customerDao.create(customerMock);

        verify(customerDb,times(1)).add(customerMock);
        verifyNoMoreInteractions(customerDb);
    }

    @Test
    void shouldFindByName() {

        final List<Customer> customerDaoByName = customerDao.findByName(TEST_NAME);

        assertEquals(2, customerDaoByName.size());
        assertEquals(TEST_NAME, customerDaoByName.get(0).getName());
        assertEquals(TEST_NAME, customerDaoByName.get(1).getName());
    }

    @Test
    void shouldFindByName2() {
        final List<Customer> expectedCustomers = Arrays.asList(TEST_CUSTOMER_1, TEST_CUSTOMER_3);

        final List<Customer> customerDaoByName = customerDao.findByName(TEST_NAME);

        assertEquals(expectedCustomers.size(), customerDaoByName.size());
        assertTrue(customerDaoByName.containsAll(expectedCustomers));
    }

    @Test
    void shouldGetAll() {

        final List<Customer> allCustomers = customerDao.getAll();

        assertEquals(internalCustomerDb.size(), allCustomers.size());
        assertTrue(internalCustomerDb.containsAll(allCustomers));
    }

    @Test
    void shouldFindByEmail() {

        final Optional<Customer> customerDaoByEmail = customerDao.findByEmail(TEST_EMAIL);

        assertEquals(Optional.of(TEST_CUSTOMER_2), customerDaoByEmail);
    }
}
