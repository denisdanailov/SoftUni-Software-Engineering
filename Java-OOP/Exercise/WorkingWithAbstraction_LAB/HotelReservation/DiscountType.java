package WorkingWithAbstraction_LAB.HotelReservation;

public enum DiscountType {
    None(0),
    SecondVisit(10),
    VIP(20);

    int discount;

    private DiscountType(int discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount / 100.0;
    }
}
