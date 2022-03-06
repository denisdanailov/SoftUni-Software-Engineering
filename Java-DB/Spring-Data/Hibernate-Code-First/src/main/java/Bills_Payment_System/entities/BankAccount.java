package Bills_Payment_System.entities;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail {
    String bankName;
    String SWIFTCode;

    private User user;

    public BankAccount() {};

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public BankAccount setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    @Column(name = "SWIFT_code")
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public BankAccount setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
        return this;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public BankAccount setUser(User user) {
        this.user = user;
        return this;
    }
}
