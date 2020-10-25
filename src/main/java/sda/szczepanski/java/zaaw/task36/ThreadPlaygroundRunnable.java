package sda.szczepanski.java.zaaw.task36;

public class ThreadPlaygroundRunnable implements Runnable {
    private final String name;

    public ThreadPlaygroundRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Thread: %s, name: %s, iteration: %d\n",
                    Thread.currentThread().getName(), name, i);
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {
                System.out.printf("Thread named %s interrupted\n", name);
                return;
            }
        }
    }
}
