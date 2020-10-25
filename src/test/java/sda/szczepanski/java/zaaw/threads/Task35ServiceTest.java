package sda.szczepanski.java.zaaw.threads;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class Task35ServiceTest {

    @Mock
    SimpleLogger simpleLogger;
    @InjectMocks
    Task35Service task35Service;

    @Test
    void shouldWriteToLogTwice() {

        final List<Thread> threadList = task35Service.execute();

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                fail("Thread " + thread.getName() + " interrupted");
            }
        }
        final int numberOfInvocations = 2;
        verify(simpleLogger, times(numberOfInvocations)).println(anyString());
        verify(simpleLogger)
                .println(startsWith(threadList.get(0).getName()));
        verify(simpleLogger)
                .println(startsWith(threadList.get(1).getName()));
        verify(simpleLogger).println(contains("declared as lambda"));
    }
}
