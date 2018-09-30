package e;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "address")
public class Address {
    private int id;
    private String street;

    public Address() {
    }

    public Address(int id) {
        this.id = id;
    }

    public Address(String street) {
        this.street = street;
    }

    public Address(int id, String street) {
        this.id = id;
        this.street = street;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
