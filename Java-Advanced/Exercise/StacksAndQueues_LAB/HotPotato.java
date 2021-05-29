package StacksAndQueues_LAB;

import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children,names);

        while (children.size() > 1) {
            for (int i = 1; i < n ; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            System.out.println("Removed " + children.poll());
        }
        System.out.println("Last is " + children.poll());

    }
}
