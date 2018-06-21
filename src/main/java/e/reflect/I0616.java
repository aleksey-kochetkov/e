package e.reflect;

/**
 * Получить строку с полным именем класса для объекта.
 */
public class I0616 extends Exercise {

    public I0616() {
    }

    public I0616(boolean print) {
        super(print);
    }

    @Override
    public String info() {
        return "Получить строку с полным именем класса для объекта";
    }

    @Override
    public String[] run() {
        return new String[] {new I0616().getClass().getName()};
    }
}
