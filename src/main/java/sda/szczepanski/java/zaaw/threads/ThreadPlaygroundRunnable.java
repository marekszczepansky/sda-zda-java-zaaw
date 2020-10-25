package sda.szczepanski.java.zaaw.threads;

public class ThreadPlaygroundRunnable implements Runnable {
    private final String name;
    private final SimpleLogger simpleLogger;

    public ThreadPlaygroundRunnable(String name, SimpleLogger simpleLogger) {
        this.name = name;
        this.simpleLogger = simpleLogger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            simpleLogger.printf("Thread: %s, name: %s, iteration: %d\n",
                    Thread.currentThread().getName(), name, i);
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                simpleLogger.printf("Thread named %s interrupted\n", name);
                return;
            }
        }
    }
}
