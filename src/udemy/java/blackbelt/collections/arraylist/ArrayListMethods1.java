package udemy.java.blackbelt.collections.arraylist;

import java.util.ArrayList;

public class ArrayListMethods1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(0,2);
        list.add(0);
        System.out.println(list); // [2, 1, 2, 3, 2, 0, 0]
        list.remove(1);
        System.out.println(list);// [2, 2, 3, 2, 0, 0]
        list.remove(Integer.valueOf(2));
        System.out.println(list); // [2, 2, 3, 2, 0, 0] -> [2, 3, 2, 0, 0]

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        list.removeAll(integers);// [2, 3, 2, 0, 0] -> [2, 3, 2]
        System.out.println(list);

        list.removeIf(l -> l.equals(2));// [2, 3, 2] -> [3]
        System.out.println(list);

        list.set(0, 2); //[3] -> [2]
        System.out.println(list);
    }
}
