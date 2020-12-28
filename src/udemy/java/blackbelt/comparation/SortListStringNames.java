package udemy.java.blackbelt.comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListStringNames {
    public static void main(String[] args) {
        List <String> listNames = new ArrayList<>();
        listNames.add("Zina");
        listNames.add("Arina");
        listNames.add("Marta");

        System.out.println("Before sort:");
        System.out.println(listNames);

        Collections.sort(listNames);

        System.out.println("After sort:");
        System.out.println(listNames);
    }
}
