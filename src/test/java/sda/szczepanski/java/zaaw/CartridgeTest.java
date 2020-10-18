package sda.szczepanski.java.zaaw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartridgeTest {

    private static String[] TEST_LOAD = new String[]{"Bardzo", "szybkostrzelny", "karabin", "testowy"};
    private static int cartridgeSize = TEST_LOAD.length;
    private Cartridge emptyCartridge;
    private Cartridge loadedCartridge;

    @BeforeEach
    void setUp() {
        emptyCartridge = new Cartridge(cartridgeSize);
        loadedCartridge = new Cartridge(cartridgeSize);
        for (String bullet : TEST_LOAD) {
            loadedCartridge.loadBullet(bullet);
        }
    }

    @Test
    void shouldCheckIfLoadedWhenEmpty() {
        assertFalse(emptyCartridge.isLoaded());
    }

    @Test
    void shouldCheckIfLoadedWhenNotEmpty() {
        assertTrue(loadedCartridge.isLoaded());
    }

    @Test
    void shouldThrowExceptionWhenLoadFull() {
        assertThrows(Exception.class, () -> {
           loadedCartridge.loadBullet("test bullet");
        });
    }

    @Test
    void shouldShotWhenEmpty() {
        assertEquals("pusty magazynek", emptyCartridge.shot());
    }

    @Test
    void shouldShotWhenLoaded() {
        assertEquals(TEST_LOAD[TEST_LOAD.length-1], loadedCartridge.shot());
    }

    @Test
    void shouldShotManyWhenLoaded() {
        loadedCartridge.shot();
        loadedCartridge.shot();
        assertEquals(TEST_LOAD[TEST_LOAD.length-3], loadedCartridge.shot());
    }
}
