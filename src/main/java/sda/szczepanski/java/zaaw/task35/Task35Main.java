package sda.szczepanski.java.zaaw.task35;

public class Task35Main {
    public static void main(String[] args) throws InterruptedException {
        final MyRunnable myRunnable = new MyRunnable();
        final Thread thread = new Thread(myRunnable);
        thread.start();
        final Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " declared as lambda is running..."));
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("All threads finished");
    }
}
