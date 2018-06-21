package e.reflect;

/**
 * Получить строку с полным именем класса для класса.
 */
public class I0615 extends Exercise {

    public static void main(String[] args) {
        Exercise[] exercises = {new I0615(), new I0616(),
                                new I0617(),
                                new I0618(false),
                                new I0620()};
        for (Exercise exercise : exercises) {
            System.out.println(exercise.info());
            exercise.print();
        }
    }

    public I0615() {
    }

    public I0615(boolean print) {
        super(print);
    }

    @Override
    public String info() {
        return "Получить строку с полным именем класса для класса";
    }

    @Override
    public String[] run() {
        return new String[] {I0615.class.getName()};
    }
}
