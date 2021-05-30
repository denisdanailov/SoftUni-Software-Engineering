package WorkingWithAbstraction_LAB.HotelReservation;

public class PriceCalculator {

  public static double calculate(ReservationDetails details) {
        double price = details.getPricePerDay() * details.getNumberOfDays();

        price = price * details.getSeason().getValue();

        price = price * (1 - details.getType().getDiscount());

        return price;
   }

}
