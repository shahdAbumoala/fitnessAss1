package com.example.fitnessass1;

public class Item {

        private final int imageResource;
        private final String text;

        public Item(int imageResource, String text) {
            this.imageResource = imageResource;
            this.text = text;
        }

        public int getImageResource() {
            return imageResource;
        }

        public String getText() {
            return text;
        }

}
