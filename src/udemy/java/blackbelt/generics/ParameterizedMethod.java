package udemy.java.blackbelt.generics;

import java.util.ArrayList;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("Privat");
        /*arrayListString.add("Ira");
        arrayListString.add("Minsk");*/

        String secondElementString = GenMethod.getSecondElement(arrayListString);
        if(secondElementString != null)
        System.out.println(secondElementString);
    }


}

class GenMethod {
    public static <T> T getSecondElement(ArrayList<T> arrayList) {
        //return arrayList.size() >= 2 ? arrayList.get(1) : null;
        try {
            return arrayList.get(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
