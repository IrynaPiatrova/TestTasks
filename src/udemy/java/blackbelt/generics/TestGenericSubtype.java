package udemy.java.blackbelt.generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenericSubtype {
    public static void main(String[] args) {
        X x = new Y();
        List<X> list = new ArrayList<>();
        //List<X> list1 = new ArrayList<Y>(); // wrong example

        Element<X> element1 = new Element<>(new X());// error in ex with interfaces
        System.out.println(element1);

        Element<Y> element2 = new Element<>(new Y());
        System.out.println(element2);

        Element<X> element3 = new Element<>(new Y());// error in ex with interfaces
        System.out.println(element3);

        //Element<Z> element4 = new Element<>(new Z()); // wrong example
    }
}

class X {

}

class Y extends X implements I1, I2 {

}

class Z {

}

interface I1 {
}

interface I2 {
}

class Element<T extends X> {
    // class Element<T extends X&I1&I2> { ex with interfaces
    private T value;

    public Element(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                '}';
    }
}
