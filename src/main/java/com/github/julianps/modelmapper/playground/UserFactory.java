package com.github.julianps.modelmapper.playground;

import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UserFactory {

    private static Random random = new Random();

    public static final int MAX_SIZE = 1000;

    public static List<User> generateRandomUsers() {
        final List<User> result = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; i++) {
           result.add(generateUser());
        }
        return result;
    }

    private static User generateUser() {
        int randomNumber = random.nextInt(100);
        return User.of(
                UUID.randomUUID(),
                LocalDate.now(),
                (randomNumber % 2) == 0 ? UserType.ADMIN : UserType.USER,
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                Address.of(
                        RandomStringUtils.randomAlphabetic(15).concat(" " + randomNumber),
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10)));
    }
}
