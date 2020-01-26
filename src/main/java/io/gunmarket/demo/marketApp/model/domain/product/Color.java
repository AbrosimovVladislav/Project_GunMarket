package io.gunmarket.demo.marketApp.model.domain.product;

import java.util.Random;

public enum Color {
    Черный;

    public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
