package e.exercise;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SetOperationsTest {

    @Test
    public void whenUnion() {
        SetOperations<String> o = new SetOperations<>();
        Set<String> a = new HashSet<>();
        a.add("one");
        a.add("two");
        Set<String> b = new HashSet<>();
        b.add("one");
        b.add("three");
        Set<String> expect = new HashSet<>();
        expect.add("one");
        expect.add("two");
        expect.add("three");
        assertThat(o.union(a, b), is(expect));
    }

    @Test
    public void whenIntersection() {
        SetOperations<String> o = new SetOperations<>();
        Set<String> a = new HashSet<>();
        a.add("one");
        a.add("two");
        Set<String> b = new HashSet<>();
        b.add("one");
        b.add("three");
        Set<String> expect = new HashSet<>();
        expect.add("one");
        assertThat(o.intersection(a, b), is(expect));
    }

    @Test
    public void whenSubtraction() {
        SetOperations<String> o = new SetOperations<>();
        Set<String> a = new HashSet<>();
        a.add("one");
        a.add("two");
        a.add("three");
        Set<String> b = new HashSet<>();
        b.add("one");
        Set<String> expect = new HashSet<>();
        expect.add("two");
        expect.add("three");
        assertThat(o.subtraction(a, b), is(expect));
    }

    @Test(expected = RuntimeException.class)
    public void whenImplicitCopyOfThenException() {
        SetOperations<String> o = new SetOperations<>();
        Set<String> a = new Set<String>() {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return true;
            }

            @Override
            public void clear() {
            }

            @Override
            public boolean contains(Object element) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean add(String element) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> collection) {
                return false;
            }

            @Override
            public boolean remove(Object element) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Object[] toArray() {
                return null;
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }
        };
        Set<String> b = new HashSet<>();
        b.add("one");
        o.subtraction(a, b);
    }
}
