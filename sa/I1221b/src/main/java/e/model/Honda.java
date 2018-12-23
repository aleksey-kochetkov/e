package e.model;

public class Honda implements Bike {

    @Override
    public void start() {
        System.out.println("Honda-start()");
    }

    @Override
    public String toString() {
        return "Honda";
    }
}
