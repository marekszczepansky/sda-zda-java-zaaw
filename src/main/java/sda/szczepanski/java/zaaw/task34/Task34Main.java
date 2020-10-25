package sda.szczepanski.java.zaaw.task34;

public class Task34Main {
    public static void main(String[] args) {
        final MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main finished");
    }
}
