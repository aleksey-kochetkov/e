package e;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {
    private int number;

    public CreditCard() {
    }

    public CreditCard(String owner, int number) {
        super(owner);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("CreditCard{owner=%s,id=%d,number=%d}",
                             this.getOwner(), this.getId(), this.number);
    }
}
