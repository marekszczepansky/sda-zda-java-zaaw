package sda.szczepanski.java.zaaw.threads;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ThreadPlaygroundRunnableTest {

    @Mock
    private SimpleLogger simpleLogger;
    @InjectMocks
    private Task37Service task37Service;

    @Test
    void shouldPrint100Times() {
        final ExecutorService executorService = task37Service.execute();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MICROSECONDS);
            verify(simpleLogger, times(100)).printf(anyString(), any());
        } catch (InterruptedException e) {
            fail("awaitTermination interrupted");
        }
    }

    @Test
    void shouldPrintEachThreadName10Times() {
        final ExecutorService executorService = task37Service.execute();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MICROSECONDS);
            for (int i = 0; i < 10; i++) {
                verify(simpleLogger, times(10))
                        .printf(anyString(), anyString(), eq("Test runnable no: " + i), anyInt());
            }
        } catch (InterruptedException e) {
            fail("awaitTermination interrupted");
        }
    }
}
