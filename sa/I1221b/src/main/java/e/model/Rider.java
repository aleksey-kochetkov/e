package e.model;

public class Rider {
    private String name;
    private Bike bike;

    public Rider(String name, Bike bike) {
        this.name = name;
        this.bike = bike;
    }

    public void ride() {
        this.bike.start();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bike getBike() {
        return this.bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return String.format("Rider{name:%s,bike:%s}",
                                                   this.name, this.bike);
    }
}
