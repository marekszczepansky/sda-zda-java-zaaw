package sda.szczepanski.java.zaaw.threads;

public class MyRunnable implements Runnable {
    private final SimpleLogger simpleLogger;

    public MyRunnable(SimpleLogger simpleLogger) {
        this.simpleLogger = simpleLogger;
    }

    @Override
    public void run() {
        simpleLogger.println(Thread.currentThread().getName() + " is running...");
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            return;
        }
    }
}
