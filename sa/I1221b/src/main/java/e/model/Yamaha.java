package e.model;

public class Yamaha implements Bike {

    @Override
    public void start() {
        System.out.println("Yamaha-start()");
    }

    @Override
    public String toString() {
        return "Yamaha";
    }
}
