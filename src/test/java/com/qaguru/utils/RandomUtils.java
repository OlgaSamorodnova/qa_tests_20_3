package com.qaguru.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomString(int len) {
        //      String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getFakerFirstName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName();
    }
    public static String getFakerLastName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@" + getRandomString(5) + ".com";
    }
    public static String getFakerEmail() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().emailAddress();
    }
    public static String getRandomAddress(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz -/";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getFakerAddress() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.address().fullAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(111, 999));
    }

    public static String getFakerPhone() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomDay() {
        return String.valueOf(getRandomInt(14, 21));

    }

    public static String getRandomMonth() {
        Faker faker = new Faker();
        return faker.options().option("January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }

    public static String getRandomYear() {
        return String.valueOf(getRandomInt(1910, 2024));

    }
    public static String getRandomSubject() {
        Faker faker = new Faker();
        return faker.options().option("Maths",
                "Chemistry",
                "Economics",
                "Social Studies",
                "Computer Science",
                "Commerce");
    }
    public static String getRandomHobbie() {
        Faker faker = new Faker();
        return faker.options().option("Sports",
                "Reading",
                "Music");
    }
    public static String getRandomState() {
        Faker faker = new Faker();
        return faker.options().option("NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan");
    }

    public static String getRandomCity(String state){
        Faker faker = new Faker();
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> state;
        };
    }
}

