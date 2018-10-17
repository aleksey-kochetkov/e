package e;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Column;

@Entity
@DiscriminatorValue("a")
public class BankAccount extends BillingDetail {
    @Column(name = "bank_name")
    private String bankName;

    public BankAccount() {
    }

    public BankAccount(String owner, String bankName) {
        super(owner);
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return String.format("BankAccount{owner=%s,id=%d,bankName=%s}",
                           this.getOwner(), this.getId(), this.bankName);
    }
}
