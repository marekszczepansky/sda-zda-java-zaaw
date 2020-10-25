package sda.szczepanski.java.zaaw.task34;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running...");
    }
}
