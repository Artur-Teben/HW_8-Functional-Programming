package com.java.streams.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class UserService {
    public Collection<User> initUserCollection() {
        return Arrays.asList(
                new User("Вася", 16, "Днепр"),
                new User("Петя", 23, "Днепр"),
                new User("Елена", 42, "Луцк"),
                new User("Елена", 92, "Чернигов"),
                new User("Сергей", 5, "Киев"),
                new User("Марина", 32, "Киев"),
                new User("Иван Иванович", 69, "Львов"));
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
