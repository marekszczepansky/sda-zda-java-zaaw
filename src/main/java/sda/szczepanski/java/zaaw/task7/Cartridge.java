package sda.szczepanski.java.zaaw.task7;

import java.util.Stack;

public class Cartridge {
    private final int cartridgeSize;
    private final Stack<String> content;

    public Cartridge(int cartridgeSize) {
        this.cartridgeSize = cartridgeSize;
        content = new Stack<>();
    }

    public void loadBullet(String bullet) {
        if (content.size() >= cartridgeSize)
            throw new CartridgeSizeExceeded();
        content.push(bullet);
    }

    public Boolean isLoaded() {
        return !content.empty();
    }

    public String shot() {
        return content.empty() ? "pusty magazynek" : content.pop();
    }
}
