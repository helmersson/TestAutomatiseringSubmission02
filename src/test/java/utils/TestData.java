package utils;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + faker.internet().domainName();
    public static String password = faker.internet().password(10, 15, true, true);
    public static String dob = faker.date().birthday().toString();
}