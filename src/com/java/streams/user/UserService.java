package com.java.streams.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class UserService {
    public Collection<User> initUserCollection() {
        return Arrays.asList(
                new User("Vasya", 16, "Dnipro"),
                new User("Petya", 23, "Dnipro"),
                new User("Lena", 42, "Lutsk"),
                new User("Lena", 92, "Chernigiv"),
                new User("Sergei", 5, "Kyiv"),
                new User("Marina", 32, "Kyiv"),
                new User("Ivan Ivanovich", 69, "Lviv"));
    }

    public Collection<User> getUsersOverAge(Collection<User> userCollection, int age) {
        return userCollection.stream()
                                .filter(p -> p.getAge() > age)
                                .collect(Collectors.toList());
    }

    public Collection<User> getUsersUnderAgeAndFromCity(Collection<User> userCollection, int age, String city) {
        return userCollection.stream()
                                .filter(p -> (p.getAge() < age && p.getCity().equals(city)))
                                .collect(Collectors.toList());
    }

    public Double getAverageAgeUsersFromCity(Collection<User> userCollection, String city) {
        return userCollection.stream()
                                .filter(p -> (p.getCity().equals(city)))
                                .mapToInt(User::getAge)
                                .average()
                                .getAsDouble();
    }

    public Collection<User> getUsersNotFromCity(Collection<User> userCollection, String city) {
        return userCollection.stream()
                                .filter(p -> (!p.getCity().equals(city)))
                                .collect(Collectors.toList());
    }

    public void printUsers(Collection<User> userCollection) {
        userCollection.forEach(System.out::println);
    }

    public Collection<User> getNumUsersSortedByAge(Collection<User> userCollection, int num) {
        return userCollection.stream()
                                .sorted(Comparator.comparing(User::getAge))
                                .limit(num)
                                .collect(Collectors.toList());
    }
}
