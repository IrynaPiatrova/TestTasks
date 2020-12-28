package udemy.java.blackbelt.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPersonObjects {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(2, "Zina", "Kukushkina", 20));
        personList.add(new Person(1, "Arina", "Petrova", 23));
        personList.add(new Person(3, "Arina", "Anyuhovskaya", 22));

        System.out.print("List before sorting:");
        System.out.println(personList);

        Collections.sort(personList);

        System.out.print("List after sorting:");
        System.out.println(personList);
    }
}

class Person implements Comparable<Person> {
    int id;
    String name;
    String surname;
    int age;

    public Person(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\n Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.id, person.id);  //1 variant by id
        //return this.id - person.id; //2 variant by id
        /*int result = this.name.compareTo(person.name); //3 variant by name
        return result == 0 ? this.surname.compareTo(person.surname) : result;*/
    }
}