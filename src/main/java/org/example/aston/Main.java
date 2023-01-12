package org.example.aston;

import org.example.aston.collections.MyArrayList;
import org.example.aston.entity.User;

import java.util.ArrayList;
import java.util.List;

import static org.example.aston.collections.MyArrayList.bubbleSort;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ivan", "Ivanov", 21);
        User user2 = new User("Oleg", "Ivanov", 25);
        User user3 = new User("Yuriy", "Ivanov", 35);
        User user4 = new User("Mick", "Ivanov", 46);
        User user5 = new User("Sergey", "Ivanov", 34);

        MyArrayList<User> myArrayList = new MyArrayList<>();
        myArrayList.add(user1);
        myArrayList.add(user2);
        myArrayList.add(user3);
        myArrayList.add(user4);
        myArrayList.add(user5);

        myArrayList.remove(0);

        myArrayList.add(user1);

        System.out.println("Before sorting: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        bubbleSort(myArrayList);

        System.out.println("After sorting: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        List<User> testList = new ArrayList<>();
        User user6 = new User("Stat", "Ivanov", 66);
        User user7 = new User("Nikita", "Ivanov", 44);
        User user8 = new User("Valera", "Ivanov", 25);
        User user9 = new User("Ken", "Ivanov", 55);
        User user10 = new User("Boris", "Ivanov", 44);
        testList.add(user6);
        testList.add(user7);
        testList.add(user8);
        testList.add(user9);
        testList.add(user10);

        myArrayList.addAll(testList);

        System.out.println("After addAll: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

    }
}