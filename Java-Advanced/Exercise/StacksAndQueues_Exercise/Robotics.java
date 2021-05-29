package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputRobots = scanner.nextLine();
        String[] robotsData = inputRobots.split(";");
        LinkedHashMap<String, Integer> robots = getRobotsMap(robotsData);// име и време за приключване на даден продукт
        LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData); // име на робота и колко време работи върху даден продукт


        //startTime ще е хубаво да го преобразуваме в секунди от самото начало
        String startTime = scanner.nextLine();
        int startTimeInSeconds = getSeconds(startTime);


        ArrayDeque<String> products = new ArrayDeque<>();

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            startTimeInSeconds++;
            // трябва да намалим времето за работа при вс роботи, при които има продукт
            decreaseWorkingTime(robotsWorkingTime);
            boolean isTaken = false; //правим си променлива дали продуктът е взет от някой робот, т.е. дали е имало свободен робот
            // проверка кой робот е свободен, т.е. working time = 0
            for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
                if (robot.getValue() == 0) {//=> роботът е свободен и ще вземе съответния текущ продукт
                    System.out.println(robot.getKey() + " - " + currentProduct + " [" + getStartTime(startTimeInSeconds) + "]"); //печатаме името на робота
                    robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
                    isTaken = true; //продуктът ни е взет, намерило се е роботче за него
                    break;
                }
            }
            if (!isTaken) {
                products.offer(currentProduct);
                //т.е. продуктът ни е останал невзет, връящаме го обратно на края на опашката
            }

        }
    }

    private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) {
            if (robot.getValue() > 0) { //=>не е свободен
                //=>работили са 1 с по прдукта и времто за работа по продукта тр да се намали с 1
                robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);

            }
        }
    }

    private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processingTime = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, 0); // нула, начално все още роботът изобщо не е работил
        }
        return robots;
    }

    private static int getSeconds(String startTime) {

        int hours = Integer.parseInt(startTime.split(":")[0]);
        int minutes = Integer.parseInt(startTime.split(":")[1]);
        int seconds = Integer.parseInt(startTime.split(":")[2]);
        return hours * 3600 + minutes * 60 + seconds;
    }


    private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {

        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (String robotData : robotsData) {
            String robotName = robotData.split("-")[0];
            int processingTime = Integer.parseInt(robotData.split("-")[1]);
            robots.put(robotName, processingTime);
        }
        return robots;
    }

    private static String getStartTime(int startTimeInSeconds) {
        // ще превръщаме от секунди в чч:мм:сс
        int hours = (startTimeInSeconds / 3600) % 24;
        int minutes = (startTimeInSeconds % 3600) / 60;
        int seconds = startTimeInSeconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);


    }
}
