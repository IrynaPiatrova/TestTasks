package udemy.java.blackbelt.collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Irina");
        linkedList.add("Kostya");
        linkedList.add("Vera");
        linkedList.add("Luba");
        System.out.println("linkedList = " + linkedList);

        System.out.println(linkedList.get(2));
    }
}
