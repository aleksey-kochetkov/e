package e.model;

public class Bajaj implements Bike {

    @Override
    public void start() {
        System.out.println("Bajaj-start()");
    }

    @Override
    public String toString() {
        return "Bajaj";
    }
}
