package udemy.java.blackbelt.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEX1 {

    /**
     * Result:
     * arrayList = [Irina 1, Kostya 1]
     * arrayList1 = [Irina 2, Kostya 2]
     * arrayList3 = [Irina 1, Kostya 1]
     * false
     * arrayList = [Irina 1, Kostya 1]
     * arrayList3 = [Irina 1, Kostya 1, Luba 3]
     */
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Irina 1");
        arrayList.add("Kostya 1");
        System.out.println("arrayList = " + arrayList);


        List<String> arrayList1 = new ArrayList<>(30);
        arrayList1.add("Irina 2");
        arrayList1.add("Kostya 2");
        System.out.println("arrayList1 = " + arrayList1);

        ArrayList<String> arrayList3 = new ArrayList<>(arrayList);
        System.out.println("arrayList3 = " + arrayList3);
        System.out.println(arrayList == arrayList3);
        arrayList3.add("Luba 3");
        System.out.println("arrayList = " + arrayList);
        System.out.println("arrayList3 = " + arrayList3);
    }
}
