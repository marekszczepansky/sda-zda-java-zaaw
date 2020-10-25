package sda.szczepanski.java.zaaw.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task37Service {
    private final SimpleLogger simpleLogger;

    public Task37Service(SimpleLogger simpleLogger) {
        this.simpleLogger = simpleLogger;
    }

    ExecutorService execute(){
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ThreadPlaygroundRunnable("Test runnable no: " + i, simpleLogger));
        }
        executorService.shutdown();
        return executorService;
    }
}
