package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FormLargestIntegerWithDigitsThatAddUpToTarget {
    protected static int[] costs = {4,3,2,5,6,7,2,5,5};
    protected static int price = 9;

    public static void main(String[] args) {
        String largestNumber = largestNumber(costs, price);
        System.out.println("result: " + largestNumber);
    }

    public static String largestNumber(int[] costs, int target) {
        List<Element> elements = getElements(costs);
        System.out.println("sorted elements = " + elements);
        List<Integer> resultValues = new ArrayList<>();
        resultValues = getResultValues(target, elements, resultValues);
        System.out.println("resultValues = " + resultValues);

        Collections.sort(resultValues);
        Collections.reverse(resultValues);

        return resultValues.stream().map(Object::toString).collect(Collectors.joining(""));
    }


    private static List<Integer> getResultValues(int target, List<Element> elements, List<Integer> resultValues) {
        int newTarget = target;
        for (Element element : elements) {
            int price = element.getPrice();
            int value = element.value;

            while (newTarget > 0) {
                int intermediateValue = newTarget - price;

                if (intermediateValue != 0 && (intermediateValue < 0 || intermediateValue < price)) {
                    break;
                }

                newTarget = intermediateValue;
                resultValues.add(value);

                if (newTarget == 0) {
                    return resultValues;
                }
            }
        }

        if(elements.size() > 0 && resultValues.size() > 0){

            resultValues.remove(elements.get(0).value);
            newTarget += elements.get(0).price;
            elements.remove(0);

           return getResultValues(newTarget, elements, resultValues);
        }

        resultValues = new ArrayList<>();
        resultValues.add(0);
        return resultValues;
    }

    private static List<Element> getElements(int[] costs) {
        List<Element> elements = new ArrayList<>();
        int i = 1;
        for (int cost : costs) {
            elements.add(new Element(i, cost));
            i++;
        }

        elements = elements.stream()
                .sorted(Comparator.comparing(Element::getPrice)
                        .thenComparing(Element::getValue, Collections.reverseOrder()))
                .collect(Collectors.toList());

        return elements;
    }

    static class Element {
        int value;
        int price;

        public Element(int value, int price) {
            this.value = value;
            this.price = price;
        }

        public int getValue() {
            return value;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "value=" + value +
                    ", price=" + price +
                    '}';
        }
    }
}
