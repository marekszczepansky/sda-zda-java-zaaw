package sda.szczepanski.java.zaaw;

import java.util.Stack;

public class Cartridge {
    private final int cartridgeSize;
    private final Stack<String> content;

    public Cartridge(int cartridgeSize) {
        this.cartridgeSize = cartridgeSize;
        content = new Stack<>();
    }

    void loadBullet(String bullet) {
        if (content.size() >= cartridgeSize)
            throw new CartridgeSizeExceeded();
        content.push(bullet);
    }

    Boolean isLoaded() {
        return !content.empty();
    }

    String shot() {
        return content.empty() ? "pusty magazynek" : content.pop();
    }
}
