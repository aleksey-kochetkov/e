package e;

import javax.persistence.MappedSuperclass;
import javax.persistence.Column;

@MappedSuperclass
public abstract class BillingDetail {
    private String owner;

    public BillingDetail() {
    }

    public BillingDetail(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BillingDetail{" +
                "owner='" + owner + '\'' +
                '}';
    }
}
