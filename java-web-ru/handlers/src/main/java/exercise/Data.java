package exercise;

import net.datafaker.Faker;

import java.util.Random;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

public class Data {
    private static final int ITEMS_COUNT = 10;
    private static final Random RANDOM = new Random(123);

    public static List<String> getPhones() {
        var faker = new Faker(new Locale("en"), RANDOM);
        List<String> phones = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            phones.add(faker.phoneNumber().cellPhone());
        }

        return phones;
    }

    public static List<String> getDomains() {
        var faker = new Faker(new Locale("en"), RANDOM);
        List<String> domains = new ArrayList<>();
        for (int i = 0; i < ITEMS_COUNT; i++) {
            domains.add(faker.internet().domainName());
        }

        return domains;
    }
}
