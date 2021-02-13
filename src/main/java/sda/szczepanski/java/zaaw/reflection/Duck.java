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

    public String getDescription(){
        return "Kaczka to miłe zwierze";
    }

    public String getSpecificDescription(){
        return "Kaczka posiada kolor " + colour;
    }
}
