package udemy.java.blackbelt.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortPersonObjectsByComparator {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "Zina", "Kukushkina", 20));
        userList.add(new User(1, "Arina", "Petrova", 23));
        userList.add(new User(3, "Arina", "Anyuhovskaya", 22));

        System.out.print("List before sorting:");
        System.out.println(userList);

        userList.sort(new IdComparator());

        System.out.print("List after sorting:");
        System.out.println(userList);
    }
}

class User {
    int id;
    String name;
    String surname;
    int age;

    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n User {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

class IdComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return Integer.compare(user1.id, user2.id);
    }
}

class NameComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        int result = user1.name.compareTo(user2.name);
        return result == 0 ? user1.surname.compareTo(user2.surname) : result;
    }
}

class AgeComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return Integer.compare(user1.age, user2.age);
    }
}