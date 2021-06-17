package WorkShop_SmartArray;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        smartArray.add(6);
        smartArray.add(7);
        smartArray.add(8);
        smartArray.add(9);

        System.out.println(smartArray.contains(3));
        System.out.println(smartArray.contains(23));

        smartArray.forEach(System.out::println);


    }
}
