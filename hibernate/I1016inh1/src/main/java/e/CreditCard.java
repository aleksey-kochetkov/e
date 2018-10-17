package e;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int number;

    public CreditCard() {
    }

    public CreditCard(String owner, int number) {
        super(owner);
        this.number = number;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
                                  this.getOwner(), this.id, this.number);
    }
}
