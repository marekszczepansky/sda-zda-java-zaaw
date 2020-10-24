package sda.szczepanski.java.zaaw.project.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sda.szczepanski.java.zaaw.project.entity.Customer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryCustomerDaoTest {

    public static final String TEST_NAME = "Marek Szczepański";
    public static final Customer TEST_CUSTOMER_1 = new Customer("1", TEST_NAME, "marek@sda.test", 18, null);
    public static final String TEST_EMAIL = "tomasz@sda.test";
    public static final Customer TEST_CUSTOMER_2 = new Customer("2", "Tomasz Wojtkowiak", TEST_EMAIL, 13, null);
    public static final Customer TEST_CUSTOMER_3 = new Customer("3", TEST_NAME, "marek2@sda.test", 35, null);
    private MemoryCustomerDao memoryCustomerDao;
    private CustomerDao customerDao;

    @BeforeEach
    void setUp() {
        memoryCustomerDao = new MemoryCustomerDao();
        customerDao = memoryCustomerDao;

        memoryCustomerDao.customerDB.add(TEST_CUSTOMER_1);
        memoryCustomerDao.customerDB.add(TEST_CUSTOMER_2);
        memoryCustomerDao.customerDB.add(TEST_CUSTOMER_3);
    }

    @Test
    void ShouldCreateCustomer() {
        final Customer customer = new Customer("4", "Michał Anioł", "michal@sda.test", 33, null);

        customerDao.create(customer);

        assertTrue(memoryCustomerDao.customerDB.contains(customer));
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

        assertEquals(memoryCustomerDao.customerDB.size(), allCustomers.size());
        assertTrue(memoryCustomerDao.customerDB.containsAll(allCustomers));
    }

    @Test
    void shouldFindByEmail() {

        final Customer customerDaoByEmail = customerDao.findByEmail(TEST_EMAIL);

        assertEquals(TEST_CUSTOMER_2, customerDaoByEmail);
    }
}
