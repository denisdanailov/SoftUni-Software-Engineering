package SingletonPattern;

public class Government {

    //create an object of Government
    private static final Government government = new Government();

    //make the constructor private so that this class cannot be
    //instantiated
    private Government() {
    }

    //Get the only object available
    public static Government elections() {
        return government;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
