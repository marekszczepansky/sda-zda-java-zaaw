package sda.szczepanski.java.zaaw.threads;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MyThreadTest {

    @Mock
    private SimpleLogger simpleLogger;
    @InjectMocks
    private MyThread myThread;

    @Test
    void shouldPrintToLogger() {
        myThread.start();

        try {
            myThread.join();
            verify(simpleLogger).println(myThread.getName() + " is running...");
        } catch (InterruptedException e) {
            fail("Thread execution interrupted");
        }
    }
}
