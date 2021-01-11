package udemy.java.blackbelt.generics;

public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> stringInfo = new Info<>("hi!");
        System.out.println(stringInfo);

        Info<Integer> integerInfo = new Info<>(1);
        System.out.println(integerInfo);
    }
}

class Info<T> { // can use <V>, <V1, V2> instead of <T>
    private T value; //can't be static
    //private T value2;
    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }
}
