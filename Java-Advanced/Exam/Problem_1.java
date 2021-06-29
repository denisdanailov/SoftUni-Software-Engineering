import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] taskInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] valuesInput = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> values = new ArrayDeque<>();
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        fillValues(taskInput, tasks);
        fillTask(valuesInput, values);

//        System.out.println(values.pop());
//        System.out.println(tasks.poll());

        while (!values.isEmpty() && !tasks.isEmpty()) {

            int task = tasks.peek();
            int value = values.peek();


            if (task == sum) {
                System.out.println(String.format("Thread with value %d killed task %d",value, task));
                for (Integer integer : values) {
                    System.out.print(integer + " ");
                }
                return;
            } else {
                if (value >= task) {
                    values.pop();
                    tasks.poll();
                }
                if (value < task) {
                    values.pop();
                }
            }


        }



    }
    private static void fillTask(int[] lilies, ArrayDeque<Integer> queue) {
        for (int lily : lilies) {
            queue.offer(lily);
        }
    }

    private static void fillValues(int[] roses, ArrayDeque<Integer> stack) {
        for (int rose : roses) {
            stack.push(rose);
        }
    }
}
