package sda.szczepanski.java.zaaw.threads;

public class SimpleLogger {
    public void println(String text) {
        System.out.println(text);
    }

    public void printf(String format, Object... arguments) {
        System.out.printf(format, arguments);
    }
}
