package e.reflect;

//import java.lang.reflect.ClassNotFoundException;

/**
 * Получить класс по строке.
 */
public class I0617 extends Exercise {

    public I0617() {
    }

    public I0617(boolean print) {
        super(print);
    }

    @Override
    public String info() {
        return "Получить класс по строке";
    }

    @Override
    public String[] run() {
        String[] result = null;
        try {
            result = new String[] {Class.forName("e.reflect.I0617").toString()};
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        return result;
    }
}
