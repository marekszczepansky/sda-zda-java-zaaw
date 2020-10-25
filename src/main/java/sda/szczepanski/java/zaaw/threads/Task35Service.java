package sda.szczepanski.java.zaaw.threads;


import java.util.Arrays;
import java.util.List;

public class Task35Service {
    private final SimpleLogger simpleLogger;

    public Task35Service(SimpleLogger simpleLogger) {
        this.simpleLogger = simpleLogger;
    }

    List<Thread> execute(){
        final MyRunnable myRunnable = new MyRunnable(simpleLogger);
        Thread thread0 = new Thread(myRunnable);
        thread0.start();
        Thread thread1 = new Thread(() -> simpleLogger.println(Thread.currentThread().getName() + " declared as lambda is running..."));
        thread1.start();
        return Arrays.asList(thread0, thread1);
    }
}
