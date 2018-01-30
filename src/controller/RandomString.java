package controller;

import java.util.Random;

public class RandomString {

    private String consonant;
    private String vowel;
    private Random random;

    public RandomString() {
        this.consonant = "bcdfghjklmnpqrstvwxyz";
        this.vowel = "aeiou";
        this.random = new Random();
    }

    public String generatePersonName(int sizeFirstName, int sizeSecondName) {
        StringBuilder builder = new StringBuilder();
        String[] consonantArray = this.consonant.split("");
        String[] vowelArray = this.vowel.split("");

        for (int index = 0; index < sizeFirstName; index++) {
            String n;
            if (index % 2 == 0) {
                n = consonantArray[random.nextInt(this.consonant.length())];
            } else {
                n = vowelArray[random.nextInt(this.vowel.length())];
            }

            if (index == 0) {
                n = n.toUpperCase();
            }
            builder.append(n);
        }

        builder.append(" ");

        for (int index = 0; index < sizeSecondName; index++) {
            String n;
            if (index % 2 == 0) {
                n = consonantArray[random.nextInt(this.consonant.length())];
            } else {
                n = vowelArray[random.nextInt(this.vowel.length())];
            }

            if (index == 0) {
                n = n.toUpperCase();
            }
            builder.append(n);
        }

        return builder.toString();
    }

    public String generateName(int size) {
        StringBuilder builder = new StringBuilder();
        String[] consonantArray = this.consonant.split("");
        String[] vowelArray = this.vowel.split("");

        for (int index = 0; index < size; index++) {
            String n;
            if (index % 2 == 0) {
                n = consonantArray[random.nextInt(this.consonant.length())];
            } else {
                n = vowelArray[random.nextInt(this.vowel.length())];
            }

            if (index == 0) {
                n = n.toUpperCase();
            }
            builder.append(n);
        }

        return builder.toString();
    }
}
