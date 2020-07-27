package com.java.streams.executor;

import com.java.streams.numbers.RandomNumbers;
import com.java.streams.user.User;
import com.java.streams.user.UserService;

import java.util.Collection;
import java.util.List;


public class Application {

    public void runApplication() {
        UserService usServ = new UserService();
        Collection<User> usColl = usServ.initUserCollection();

        System.out.println("Our users: ");
        usServ.printUsers(usColl);

        System.out.println("\nUsers older forty years: ");
        usServ.printUsers(usServ.getUsersOverAge(usColl, 40));

        System.out.println("\nUsers under fifty years and from Dnipro: ");
        usServ.printUsers(usServ.getUsersUnderAgeAndFromCity(usColl, 50, "Днепр"));

        System.out.println("\nAvarage age users from Lviv: ");
        System.out.println(usServ.getAverageAgeUsersFromCity(usColl, "Львов"));

        System.out.println("\nUsers that are not from Kyiv: ");
        usServ.printUsers(usServ.getUsersNotFromCity(usColl, "Киев"));

        System.out.println("\nFirst three users sorted by age: ");
        usServ.printUsers(usServ.getNumUsersSortedByAge(usColl, 3));

        RandomNumbers randNum = new RandomNumbers();
        List<Integer> integers = randNum.generateIntStream(15,1, 30);

        System.out.println("\nRandom numbers: ");
        randNum.printList(integers);

        System.out.print("\n\nSmallest number: ");
        System.out.println(randNum.getMinInt(integers));

        System.out.print("\nLargest number: ");
        System.out.println(randNum.getMaxInt(integers));

        System.out.print("\nMultiples of two: ");
        randNum.printList(randNum.getMultiplesOfNum(integers, 2));

        System.out.print("\n\nAdd ten: ");
        randNum.printList(randNum.addNum(integers, 10));
    }
}
