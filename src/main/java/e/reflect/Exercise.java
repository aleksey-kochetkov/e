package e.reflect;

public abstract class Exercise {
    private boolean print = true;

    public Exercise() {
    }

    public Exercise(boolean print) {
        this.print = print;
    }

    public abstract String info();

    public void print() {
        if (this.print) {
            for (String s : this.run()) {
                System.out.println(s);
            }
        }
    }

    public abstract String[] run();
}
