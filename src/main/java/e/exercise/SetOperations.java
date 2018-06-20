package e.exercise;

import java.util.Set;
import java.lang.reflect.InvocationTargetException;

/**
 * Operations on two sets of <E>. Every operation result is a copy having
 * the same type as the first argument. It is made via reflection.
 * @param <E>
 */
public class SetOperations<E> {

    public Set<E> union(Set<E> a, Set<E> b) {
        Set<E> result = this.copyOf(a);
        result.addAll(b);
        return result;
    }

    public Set<E> intersection(Set<E> a, Set<E> b) {
        Set<E> result = this.copyOf(a);
        result.retainAll(b);
        return result;
    }

    public Set<E> subtraction(Set<E> a, Set<E> b) {
        Set<E> result = this.copyOf(a);
        result.removeAll(b);
        return result;
    }

    @SuppressWarnings("unchecked")
    private Set<E> copyOf(Set<E> s) {
        Set<E> result;
        try {
            result = (Set<E>) s.getClass().getMethod("clone").invoke(s);
            result.addAll(s);
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException exception) {
            throw new RuntimeException(exception);
        }
        return result;
    }
}
