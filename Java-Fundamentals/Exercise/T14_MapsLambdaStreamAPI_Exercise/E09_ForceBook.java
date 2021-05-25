package T14_MapsLambdaStreamAPI_Exercise;

import java.util.*;

public class E09_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> forceBook = new TreeMap<>();
        while (!"Lumpawaroo".equals(command)) {


            if (command.contains("|")) {

                String[] tokens = command.split("\\s+|\\s+");
                String member = tokens[2];
                String side = tokens[0];

                if (!forceBook.containsKey(side)) {
                    forceBook.putIfAbsent(side,new ArrayList<>());
                    forceBook.get(side).add(member);
                } else if (forceBook.containsKey(side)){
                    forceBook.get(side).add(member);
                }

            }
            if (command.contains("->")) {
                String[] tokens = command.split("\\s+->\\s+",2);
                String member = tokens[0];
                String side = tokens[1];

                 boolean isContain = forceBook.values().stream().anyMatch(list -> list.contains(member));

                 if (isContain) {
                     forceBook.get("Darker").remove(member);
                 }


                if (!forceBook.containsKey(side)) {
                   forceBook.put(side,new ArrayList<>());
                   forceBook.get(side).add(member);

                } else if (forceBook.containsKey(side)) {
                    forceBook.get(side).add(member);
                }
            }
            command = scanner.nextLine();
        }
//         students.
//                entrySet()
//                .stream()
//                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
//                .sorted((s1, s2) -> {
//                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
//                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
//                    return Double.compare(second, first);
//                })
//                .forEach(s -> System.out.println(String.format("%s -> %.2f",
//                        s.getKey(),
//                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));
        forceBook.
                entrySet().
                stream().
                forEach(s -> System.out.println(String.format("%s -> %s",s.getKey(),s.getValue())));
    }
}
