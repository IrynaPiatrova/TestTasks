package udemy.java.blackbelt.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeEX1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();

        Student student1 = new Student("Irina", "Mitskevich", 5);
        Student student2 = new Student("Kostya", "Petrova", 3);
        Student student3 = new Student("Luba", "Eremeeva", 1);
        Student student4 = new Student("Dasha", "Danilova", 2);

        map.put(student1, 7.1);
        map.put(student2, 6.9);
        map.put(student3, 9.0);
        map.put(student4, 8.5);

        System.out.println(map);

        Student student4Copy = new Student("Dasha", "Danilova", 2);

        System.out.println("IS containsKey = " + map.containsKey(student4Copy));
        System.out.println("IS equals = " + student4.equals(student4Copy));
        System.out.println("student4 hashCode = " + student4.hashCode());
        System.out.println("student4Copy hashCode = " + student4Copy.hashCode());
    }
}

class Student {
    String name;
    String secondName;
    int course;

    public Student(String name, String secondName, int course) {
        this.name = name;
        this.secondName = secondName;
        this.course = course;
    }

    @Override
    public String toString() {
        return '\n' + "Student{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(secondName, student.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondName, course);
    }
}
