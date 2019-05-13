package com.corschdi.spring.json.stream.model;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty
    private int id;

    @JsonProperty
    private Color color;

    @JsonProperty
    private Dimensions dimensions;

    public Car(int id) {
        Random random = new Random(id);

        this.id = id;
        this.color = Color.getRandomColor(random);
        this.dimensions = new Dimensions(random.nextInt(300) + 400, random.nextInt(50) + 185,
                random.nextInt(100) + 150);
    }

    public class Dimensions {

        @JsonProperty
        private int length;

        @JsonProperty
        private int width;

        @JsonProperty
        private int height;

        public Dimensions(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

    }

}
