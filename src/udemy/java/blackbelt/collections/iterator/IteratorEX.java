package udemy.java.blackbelt.collections.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEX {

    /**
     * Result:
     * iterator = Irina
     * iterator = Kostya
     * iterator = Vera
     * iterator = Luba
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Irina");
        arrayList.add("Kostya");
        arrayList.add("Vera");
        arrayList.add("Luba");


        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator = " + iterator.next());
        }
    }
}
