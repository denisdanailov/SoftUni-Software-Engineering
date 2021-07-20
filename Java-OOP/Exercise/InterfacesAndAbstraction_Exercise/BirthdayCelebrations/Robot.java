package InterfacesAndAbstraction_Exercise.BirthdayCelebrations;

public class Robot  {
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }



    public String getId() {
        return this.id;
    }


    public String getModel(){
        return this.model;
    }
}
