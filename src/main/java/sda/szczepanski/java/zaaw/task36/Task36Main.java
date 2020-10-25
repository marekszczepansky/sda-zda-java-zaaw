package sda.szczepanski.java.zaaw.task36;

public class Task36Main {
    private static Thread thread1;
    private static Thread thread2;

    public static void main(String[] args) throws InterruptedException {
        thread1 = new Thread(new ThreadPlaygroundRunnable("test 1"));
        thread2 = new Thread(new ThreadPlaygroundRunnable("test 2"));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("All threads finished");
    }
}
