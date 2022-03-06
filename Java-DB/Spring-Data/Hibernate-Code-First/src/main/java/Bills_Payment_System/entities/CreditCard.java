package Bills_Payment_System.entities;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private String cardType;
    private int expirationMonth;
    private int getExpirationYear;

    private User user;

    @Column(name="card_type")
    public String getCardType() {
        return cardType;
    }

    public CreditCard setCardType(String cardType) {
        this.cardType = cardType;
        return this;

    }

    @Column(name="expiration_month")
    public int getExpirationMonth() {
        return expirationMonth;
    }

    public CreditCard setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
        return this;
    }

    @Column(name="expiration_year")
    public int getGetExpirationYear() {
        return getExpirationYear;
    }

    public CreditCard setGetExpirationYear(int getExpirationYear) {
        this.getExpirationYear = getExpirationYear;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public CreditCard setUser(User user) {
        this.user = user;
        return this;
    }
}
