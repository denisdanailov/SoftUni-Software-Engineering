import implementations.ArrayDeque;
import implementations.Queue;

public class Main {
    public static void main(String[] args) {


        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.offer(13);
        arrayDeque.offer(14);
        arrayDeque.offer(15);

        System.out.println(arrayDeque.poll());

    }
}
