package parseTheStringTask;


public class FibonacciTask {

    private int value = 0;
    private int previousValue = 1;

    public static void main(String[] args) {
        FibonacciTask generator = new FibonacciTask();

        for (int i = 0; i < 14; i++) {
            System.out.println(generator.next());
        }

    }

    public int next() {
        try {
            return value;
        } finally {
            int v = value + previousValue;

            previousValue = value;
            value = v;
        }
    }
}
