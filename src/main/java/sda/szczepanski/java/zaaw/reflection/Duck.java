package sda.szczepanski.java.zaaw.reflection;

public class Duck {
    public String name;
    private String colour;

    public Duck(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
