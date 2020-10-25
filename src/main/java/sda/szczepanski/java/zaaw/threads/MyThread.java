package sda.szczepanski.java.zaaw.threads;

public class MyThread extends Thread {

    private final SimpleLogger out;

    public MyThread(SimpleLogger out) {
        this.out = out;
    }

    @Override
    public void run() {
        out.println(Thread.currentThread().getName() + " is running...");
    }
}
