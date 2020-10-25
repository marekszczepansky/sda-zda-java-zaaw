package sda.szczepanski.java.zaaw.task37;

import sda.szczepanski.java.zaaw.task36.ThreadPlaygroundRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task37Main {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ThreadPlaygroundRunnable("Test runnable no: " + i));
        }
        executorService.shutdown();

        System.out.println("Shutdown called");
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Executor finished");
    }
}
