package e.reflect;

import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.InvocationTargetException;

/**
 * Имея родительский интерфейс, выполнить метод, если он public для дочернего объекта.
 */
public class I0620 extends Exercise {

    public I0620() {
    }

    public I0620(boolean print) {
        super(print);
    }

    @Override
    public String info() {
        return
"Имея родительский интерфейс, выполнить метод, если он public для дочернего объекта";
    }

    @SuppressWarnings("unchecked")
    @Override
    public String[] run() {
        Set<String> parent = new HashSet<>();
        Set<String> newSet;
        try {
            newSet = (Set<String>)
                     parent.getClass().getMethod("clone").invoke(parent);
        } catch (NoSuchMethodException
                 | IllegalAccessException
                 | InvocationTargetException exception) {
            throw new RuntimeException(exception);
        }
        return new String[] {
            String.format("@%s @%s", Integer.toHexString(
                                        System.identityHashCode(parent)),
                  Integer.toHexString(System.identityHashCode(newSet)))};
    }
}
