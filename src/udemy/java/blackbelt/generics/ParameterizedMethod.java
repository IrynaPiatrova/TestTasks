package udemy.java.blackbelt.generics;

import java.util.ArrayList;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListInteger = new ArrayList<>();
        arrayListInteger.add(1);
        arrayListInteger.add(2);
        arrayListInteger.add(3);

        Integer secondElement = GenMethod.getSecondElement(arrayListInteger);
        if(secondElement != null)
        System.out.println(secondElement);
    }


}

class GenMethod {
    //public static <T> T getSecondElement(ArrayList<T> arrayList) { //All elements
    public static <T extends Number> T getSecondElement(ArrayList<T> arrayList) {
        //return arrayList.size() >= 2 ? arrayList.get(1) : null;
        try {
            return arrayList.get(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
