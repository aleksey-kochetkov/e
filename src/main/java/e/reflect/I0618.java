package e.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Получить полные имена public конструкторов, полей, методов (включая родительские) класса.
 */
public class I0618 extends Exercise {
    public int i;
    protected Integer integer;

    public I0618() {
    }

    public I0618(boolean print) {
        super(print);
    }

    protected I0618(int i) {
    }

    @Override
    public String info() {
        return "Получить полные имена public конструкторов, полей, методов (включая родительские) класса";
    }

    @Override
    public String[] run() {
        String[] strings = new String[16];
        int next = 0;
        for (Constructor constructor : this.getClass().getConstructors()) {
            strings[next++] = constructor.getName();
        }
        for (Field field : this.getClass().getFields()) {
            strings[next++] = field.getName();
        }
        for (Method method : this.getClass().getMethods()) {
            strings[next++] = method.getName();
        }
        return strings;
    }

    protected void foo() {
    }
}
