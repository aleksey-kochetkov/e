package e;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail {
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
