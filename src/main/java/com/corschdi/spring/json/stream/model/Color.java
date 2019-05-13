package com.corschdi.spring.json.stream.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Color {

    RED, BLUE, GREEN, BLACK, WHITE, YELLOW, ORANGE, BROWN, SILVER;

    private static final List<Color> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();

    public static Color getRandomColor(Random random) {
        return VALUES.get(random.nextInt(SIZE));
    }

}
