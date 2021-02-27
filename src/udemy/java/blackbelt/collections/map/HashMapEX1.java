package udemy.java.blackbelt.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapEX1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10000,"Irina Petrpova");
        map.put(10001,"Rita Petrpova");
        map.put(10002,"Karina Petrpova");
        map.put(10003,"Diana Petrpova");
        map.put(10004,"Masha Petrpova");

        // "Irina Petrpova" -> "Masha Petrpova" ключ останется, а значение перезапишется
        map.put(10000,"Masha Petrpova");

        map.put(null,"Kate Petrpova");
        map.put(10005,null);

        map.putIfAbsent(10005,"Kirill");

        System.out.println(map);

        System.out.println(map.get(10000));//Masha Petrpova
        System.out.println(map.get(0)); //null
    }
}
